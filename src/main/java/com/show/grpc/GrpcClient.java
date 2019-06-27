package com.show.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengfawei
 * @create 2019-06-24 下午1:49
 * @desc
 **/
public class GrpcClient {
    private final ManagedChannel channel;

    private final PersonServiceGrpc.PersonServiceBlockingStub blockingStub;

//    private final PersonServiceGrpc.PersonServiceStub Stub;

    public GrpcClient(String host ,int port) {
        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext().build());
    }
    GrpcClient(ManagedChannel channel){
        this.channel=channel;
        this.blockingStub=PersonServiceGrpc.newBlockingStub(channel);
//        this.Stub=PersonServiceGrpc.newStub(channel);
    }
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    public void Person(String name){
        PersonRequest request = PersonRequest.newBuilder().setName(name).build();
        PersonResponse response = blockingStub.getPerson(request);
        Iterator<PersonResponse> iterator = blockingStub.getPersonByName(request);
        System.out.println(response);
        while (iterator.hasNext()){
            PersonResponse response1 = iterator.next();
            System.out.println(response1.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        GrpcClient client = new GrpcClient("localhost", 8899);
//        client.Person("zhangsan");
//        client.shutdown();

        final CountDownLatch done = new CountDownLatch(2);
        ManagedChannel chan = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext().build();
        PersonServiceGrpc.PersonServiceStub stub = PersonServiceGrpc.newStub(chan);

        ClientResponseObserver<StreamRequest,StreamResponse> clientResponseObserver=new ClientResponseObserver<StreamRequest,StreamResponse>(){
            ClientCallStreamObserver<StreamRequest> requestStream;
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
                requestStream.request(1);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                done.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("oncompleted");
                done.countDown();
            }

            @Override
            public void beforeStart(ClientCallStreamObserver<StreamRequest> requestStream) {
                this.requestStream=requestStream;
                requestStream.disableAutoInboundFlowControl();
                requestStream.setOnReadyHandler(new Runnable() {
                    @Override
                    public void run() {
                        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu");
                        names.stream().forEach(name ->{
                            StreamRequest request = StreamRequest.newBuilder().setRequestInfo(name).build();
                            requestStream.onNext(request);
                        });
                        requestStream.onCompleted();
                    }
                });
            }
        };
        StreamObserver<PersonResponseList> StreamObserver=new StreamObserver<PersonResponseList>(){
            @Override
            public void onNext(PersonResponseList value) {
                value.getPersonResonseList().stream().forEach(item->System.out.println(item.getName()));
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                done.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("oncompleted");
                done.countDown();
            }

        };
        stub.biTalk(clientResponseObserver);
        System.out.println("------------------------");
        StreamObserver<PersonRequest> observer = stub.getPersonWapperByName(StreamObserver);
        observer.onNext(PersonRequest.newBuilder().setName("test1").build());
        observer.onNext(PersonRequest.newBuilder().setName("test2").build());
        observer.onNext(PersonRequest.newBuilder().setName("test3").build());
        observer.onNext(PersonRequest.newBuilder().setName("test4").build());
        observer.onCompleted();
        done.await();
        chan.shutdown();
        chan.awaitTermination(1,TimeUnit.SECONDS);
    }
}

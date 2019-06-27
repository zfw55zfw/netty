package com.show.grpc;


import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhengfawei
 * @create 2019-06-24 下午1:49
 * @desc
 **/
public class PersonServiceImpl extends PersonServiceGrpc.PersonServiceImplBase{
    @Override
    public void getPerson(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        PersonResponse response = PersonResponse.newBuilder().setName("lisi").build();
        System.out.println(request.getName());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getPersonByName(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        PersonResponse response = PersonResponse.newBuilder().setName("lisi").build();
        PersonResponse response1 = PersonResponse.newBuilder().setName("lisi1").build();
        PersonResponse response2 = PersonResponse.newBuilder().setName("lisi2").build();
        PersonResponse response3 = PersonResponse.newBuilder().setName("lisi3").build();
        PersonResponse response4 = PersonResponse.newBuilder().setName("lisi4").build();
        PersonResponse response5= PersonResponse.newBuilder().setName("lisi5").build();
        System.out.println(request.getName());
        responseObserver.onNext(response);
        responseObserver.onNext(response1);
        responseObserver.onNext(response2);
        responseObserver.onNext(response3);
        responseObserver.onNext(response4);
        responseObserver.onNext(response5);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<PersonRequest> getPersonWapperByName(StreamObserver<PersonResponseList> responseObserver) {
        final ServerCallStreamObserver<PersonResponseList> serverCallStreamObserver=(ServerCallStreamObserver<PersonResponseList>) responseObserver;
        serverCallStreamObserver.disableAutoInboundFlowControl();
        final AtomicBoolean wasReady = new AtomicBoolean(false);
        serverCallStreamObserver.setOnReadyHandler(new Runnable() {
            @Override
            public void run() {
                if (serverCallStreamObserver.isReady()&&wasReady.compareAndSet(false,true)){
                    System.out.println("ready");
                    serverCallStreamObserver.request(1);
                }
            }
        });
        return new StreamObserver<PersonRequest>() {
            @Override
            public void onNext(PersonRequest value) {
                System.out.println(value.getName());


                    if(serverCallStreamObserver.isReady()){
                        serverCallStreamObserver.request(1);
                    }else {
                        wasReady.set(false);
                    }
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
                PersonResponseList.Builder builder = PersonResponseList.newBuilder();

                for (int i=0;i<10;++i){
                    builder.addPersonResonse(PersonResponse.newBuilder().setName("test"+i).build());
                }
                responseObserver.onNext(builder.build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        final ServerCallStreamObserver<StreamResponse> serverCallStreamObserver=(ServerCallStreamObserver<StreamResponse>) responseObserver;
        serverCallStreamObserver.disableAutoInboundFlowControl();
        final AtomicBoolean wasReady = new AtomicBoolean(false);
        serverCallStreamObserver.setOnReadyHandler(new Runnable() {
            @Override
            public void run() {
                if (serverCallStreamObserver.isReady()&&wasReady.compareAndSet(false,true)){
                    System.out.println("ready");
                    serverCallStreamObserver.request(1);
                }
            }
        });
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                try {
                    Thread.sleep(100);

                    StreamResponse test = StreamResponse.newBuilder().setResponseInfo("test").build();

                    responseObserver.onNext(test);
                    if(serverCallStreamObserver.isReady()){
                        serverCallStreamObserver.request(1);
                    }else {
                        wasReady.set(false);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    responseObserver.onError(Status.UNKNOWN.withDescription("error").withCause(e).asException());
                }
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
                responseObserver.onCompleted();
            }
        };
    }
}

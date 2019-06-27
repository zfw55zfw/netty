package com.show.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author zhengfawei
 * @create 2019-06-24 下午1:49
 * @desc
 **/
public class GrpcServer {
    private Server server;
    private void start() throws IOException {
        server = ServerBuilder.forPort(8899).addService(new PersonServiceImpl()).build().start();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("jvm shutdown");
                System.out.println();
            }
        });
    }
    private void stop(){
        if(server!=null){
            server.shutdown();
        }
    }
    private void blockUntilshutdown() throws InterruptedException {
        if (null!=server){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
       final GrpcServer grpcServer = new GrpcServer();
       grpcServer.start();
       grpcServer.blockUntilshutdown();
    }
}

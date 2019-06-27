package com.show.thrift;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author zhengfawei
 * @create 2019-06-19 上午10:40
 * @desc
 **/
public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(tNonblockingServerSocket).minWorkerThreads(2).maxWorkerThreads(4);

        StudentService.Processor<StudentHandler> studentHandlerProcessor = new StudentService.Processor<>(new StudentHandler());
        PersonService.Processor<PersonSeviceImpl> personSeviceProcessor = new PersonService.Processor<>(new PersonSeviceImpl());
        TMultiplexedProcessor multiplexedProcessor= new TMultiplexedProcessor();
        multiplexedProcessor.registerProcessor("studentHandlerProcessor",studentHandlerProcessor);
        multiplexedProcessor.registerProcessor("personSeviceProcessor",personSeviceProcessor);
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(multiplexedProcessor));
        //arg.processorFactory(new TProcessorFactory(personSeviceProcessor));
        THsHaServer server = new THsHaServer(arg);
        System.out.println("thrift server started");
        server.serve();
//        TServerSocket serverTransport = new TServerSocket(9090);
//        Factory protocolFactory = new TBinaryProtocol.Factory();
//        //创建多个服务Processor
//        Processor<TestService.Iface> processorTest = new TestService.Processor<TestService.Iface>(new TestServiceImpl());
//        com.thrift.demo01.service.HelloService.Processor<Iface> processorHello = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
//
//        //将服务注册到TMultiplexedProcessor中
//        TMultiplexedProcessor processors = new TMultiplexedProcessor();
//        processors.registerProcessor("testService", processorTest);
//        processors.registerProcessor("helloService", processorHello);
//
//        TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport)
//                .protocolFactory(protocolFactory)
//                .processor(processors)
//                .minWorkerThreads(1000)
//                .maxWorkerThreads(1000);
//        TServer server = new TThreadPoolServer(args);
//        System.out.println("开启thrift服务器，监听端口：9090");
//        server.serve();
    }
}


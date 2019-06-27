package com.show.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author zhengfawei
 * @create 2019-06-19 上午10:40
 * @desc
 **/
public class ThriftClient {
    public static void main(String[] args) throws TException {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        TMultiplexedProtocol studentHandlerProcessor = new TMultiplexedProtocol(protocol, "studentHandlerProcessor");
        TMultiplexedProtocol personSeviceProcessor = new TMultiplexedProtocol(protocol, "personSeviceProcessor");
        StudentService.Client client = new StudentService.Client(studentHandlerProcessor);
        PersonService.Client personClient = new PersonService.Client(personSeviceProcessor);

        transport.open();
        Student show = client.getStudent("show");
        System.out.println(show.getAge());
        System.out.println(show.getName());
        System.out.println(show.isMarried());

        Student candy = new Student().setName("candy").setAge(22).setMarried(true);
        client.saveStudent(candy);

        Person person = personClient.getPerson("show");
        System.out.println(person.getName());

//        TTransport transport = new TSocket("localhost", 9090);
//        TProtocol protocol = new TBinaryProtocol(transport);
//        //通过TMultiplexedProtocol获取对应的服务
//        TMultiplexedProtocol protocolTest = new TMultiplexedProtocol(protocol, "testService");
//        TMultiplexedProtocol protocolHello = new TMultiplexedProtocol(protocol, "helloService");
//
//        //创建Client调用服务接口的方法
//        TestService.Client client = new TestService.Client(protocolTest);
//        HelloService.Client clientHello = new HelloService.Client(protocolHello);
//        transport.open();
//
//        //调用接口方法
//        Test test = new Test();
//        test.setBool_(true);
//        test.setDouble_(5.0);
//        System.out.println("Client getBool()" + client.getBool(test));
//        System.out.println("Client getDouble()" + client.getDouble(test));
//
//        System.out.println("HelloService sayString :" + clientHello.sayString("哈哈哈"));
//        transport.close();

    }
}

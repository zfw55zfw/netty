package com.show.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: Person.proto")
public final class PersonServiceGrpc {

  private PersonServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.PersonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.show.grpc.PersonRequest,
      com.show.grpc.PersonResponse> getGetPersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPerson",
      requestType = com.show.grpc.PersonRequest.class,
      responseType = com.show.grpc.PersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.show.grpc.PersonRequest,
      com.show.grpc.PersonResponse> getGetPersonMethod() {
    io.grpc.MethodDescriptor<com.show.grpc.PersonRequest, com.show.grpc.PersonResponse> getGetPersonMethod;
    if ((getGetPersonMethod = PersonServiceGrpc.getGetPersonMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getGetPersonMethod = PersonServiceGrpc.getGetPersonMethod) == null) {
          PersonServiceGrpc.getGetPersonMethod = getGetPersonMethod = 
              io.grpc.MethodDescriptor.<com.show.grpc.PersonRequest, com.show.grpc.PersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.PersonService", "GetPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.PersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.PersonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("GetPerson"))
                  .build();
          }
        }
     }
     return getGetPersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.show.grpc.PersonRequest,
      com.show.grpc.PersonResponse> getGetPersonByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPersonByName",
      requestType = com.show.grpc.PersonRequest.class,
      responseType = com.show.grpc.PersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.show.grpc.PersonRequest,
      com.show.grpc.PersonResponse> getGetPersonByNameMethod() {
    io.grpc.MethodDescriptor<com.show.grpc.PersonRequest, com.show.grpc.PersonResponse> getGetPersonByNameMethod;
    if ((getGetPersonByNameMethod = PersonServiceGrpc.getGetPersonByNameMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getGetPersonByNameMethod = PersonServiceGrpc.getGetPersonByNameMethod) == null) {
          PersonServiceGrpc.getGetPersonByNameMethod = getGetPersonByNameMethod = 
              io.grpc.MethodDescriptor.<com.show.grpc.PersonRequest, com.show.grpc.PersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.PersonService", "GetPersonByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.PersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.PersonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("GetPersonByName"))
                  .build();
          }
        }
     }
     return getGetPersonByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.show.grpc.PersonRequest,
      com.show.grpc.PersonResponseList> getGetPersonWapperByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPersonWapperByName",
      requestType = com.show.grpc.PersonRequest.class,
      responseType = com.show.grpc.PersonResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.show.grpc.PersonRequest,
      com.show.grpc.PersonResponseList> getGetPersonWapperByNameMethod() {
    io.grpc.MethodDescriptor<com.show.grpc.PersonRequest, com.show.grpc.PersonResponseList> getGetPersonWapperByNameMethod;
    if ((getGetPersonWapperByNameMethod = PersonServiceGrpc.getGetPersonWapperByNameMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getGetPersonWapperByNameMethod = PersonServiceGrpc.getGetPersonWapperByNameMethod) == null) {
          PersonServiceGrpc.getGetPersonWapperByNameMethod = getGetPersonWapperByNameMethod = 
              io.grpc.MethodDescriptor.<com.show.grpc.PersonRequest, com.show.grpc.PersonResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.PersonService", "GetPersonWapperByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.PersonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.PersonResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("GetPersonWapperByName"))
                  .build();
          }
        }
     }
     return getGetPersonWapperByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.show.grpc.StreamRequest,
      com.show.grpc.StreamResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiTalk",
      requestType = com.show.grpc.StreamRequest.class,
      responseType = com.show.grpc.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.show.grpc.StreamRequest,
      com.show.grpc.StreamResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<com.show.grpc.StreamRequest, com.show.grpc.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = PersonServiceGrpc.getBiTalkMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getBiTalkMethod = PersonServiceGrpc.getBiTalkMethod) == null) {
          PersonServiceGrpc.getBiTalkMethod = getBiTalkMethod = 
              io.grpc.MethodDescriptor.<com.show.grpc.StreamRequest, com.show.grpc.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.PersonService", "BiTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.show.grpc.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("BiTalk"))
                  .build();
          }
        }
     }
     return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonServiceStub newStub(io.grpc.Channel channel) {
    return new PersonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PersonServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPerson(com.show.grpc.PersonRequest request,
        io.grpc.stub.StreamObserver<com.show.grpc.PersonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPersonMethod(), responseObserver);
    }

    /**
     */
    public void getPersonByName(com.show.grpc.PersonRequest request,
        io.grpc.stub.StreamObserver<com.show.grpc.PersonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPersonByNameMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.show.grpc.PersonRequest> getPersonWapperByName(
        io.grpc.stub.StreamObserver<com.show.grpc.PersonResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetPersonWapperByNameMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.show.grpc.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.show.grpc.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPersonMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.show.grpc.PersonRequest,
                com.show.grpc.PersonResponse>(
                  this, METHODID_GET_PERSON)))
          .addMethod(
            getGetPersonByNameMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.show.grpc.PersonRequest,
                com.show.grpc.PersonResponse>(
                  this, METHODID_GET_PERSON_BY_NAME)))
          .addMethod(
            getGetPersonWapperByNameMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.show.grpc.PersonRequest,
                com.show.grpc.PersonResponseList>(
                  this, METHODID_GET_PERSON_WAPPER_BY_NAME)))
          .addMethod(
            getBiTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.show.grpc.StreamRequest,
                com.show.grpc.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class PersonServiceStub extends io.grpc.stub.AbstractStub<PersonServiceStub> {
    private PersonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPerson(com.show.grpc.PersonRequest request,
        io.grpc.stub.StreamObserver<com.show.grpc.PersonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPersonByName(com.show.grpc.PersonRequest request,
        io.grpc.stub.StreamObserver<com.show.grpc.PersonResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetPersonByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.show.grpc.PersonRequest> getPersonWapperByName(
        io.grpc.stub.StreamObserver<com.show.grpc.PersonResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetPersonWapperByNameMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.show.grpc.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.show.grpc.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PersonServiceBlockingStub extends io.grpc.stub.AbstractStub<PersonServiceBlockingStub> {
    private PersonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.show.grpc.PersonResponse getPerson(com.show.grpc.PersonRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.show.grpc.PersonResponse> getPersonByName(
        com.show.grpc.PersonRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetPersonByNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PersonServiceFutureStub extends io.grpc.stub.AbstractStub<PersonServiceFutureStub> {
    private PersonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.show.grpc.PersonResponse> getPerson(
        com.show.grpc.PersonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPersonMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PERSON = 0;
  private static final int METHODID_GET_PERSON_BY_NAME = 1;
  private static final int METHODID_GET_PERSON_WAPPER_BY_NAME = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PERSON:
          serviceImpl.getPerson((com.show.grpc.PersonRequest) request,
              (io.grpc.stub.StreamObserver<com.show.grpc.PersonResponse>) responseObserver);
          break;
        case METHODID_GET_PERSON_BY_NAME:
          serviceImpl.getPersonByName((com.show.grpc.PersonRequest) request,
              (io.grpc.stub.StreamObserver<com.show.grpc.PersonResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PERSON_WAPPER_BY_NAME:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getPersonWapperByName(
              (io.grpc.stub.StreamObserver<com.show.grpc.PersonResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<com.show.grpc.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.show.grpc.Person.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonService");
    }
  }

  private static final class PersonServiceFileDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier {
    PersonServiceFileDescriptorSupplier() {}
  }

  private static final class PersonServiceMethodDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PersonServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonServiceFileDescriptorSupplier())
              .addMethod(getGetPersonMethod())
              .addMethod(getGetPersonByNameMethod())
              .addMethod(getGetPersonWapperByNameMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}

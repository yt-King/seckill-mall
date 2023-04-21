package person;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 用户
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: seckill-person-rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SeckillPersonServiceGrpc {

  private SeckillPersonServiceGrpc() {}

  public static final String SERVICE_NAME = "SeckillPersonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.CreatePersonReq,
      person.SeckillPersonRpc.PersonMessage.CommonRely> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "create",
      requestType = person.SeckillPersonRpc.PersonMessage.CreatePersonReq.class,
      responseType = person.SeckillPersonRpc.PersonMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.CreatePersonReq,
      person.SeckillPersonRpc.PersonMessage.CommonRely> getCreateMethod() {
    io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.CreatePersonReq, person.SeckillPersonRpc.PersonMessage.CommonRely> getCreateMethod;
    if ((getCreateMethod = SeckillPersonServiceGrpc.getCreateMethod) == null) {
      synchronized (SeckillPersonServiceGrpc.class) {
        if ((getCreateMethod = SeckillPersonServiceGrpc.getCreateMethod) == null) {
          SeckillPersonServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<person.SeckillPersonRpc.PersonMessage.CreatePersonReq, person.SeckillPersonRpc.PersonMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.CreatePersonReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillPersonServiceMethodDescriptorSupplier("create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.UpdatePersonReq,
      person.SeckillPersonRpc.PersonMessage.CommonRely> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = person.SeckillPersonRpc.PersonMessage.UpdatePersonReq.class,
      responseType = person.SeckillPersonRpc.PersonMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.UpdatePersonReq,
      person.SeckillPersonRpc.PersonMessage.CommonRely> getUpdateMethod() {
    io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.UpdatePersonReq, person.SeckillPersonRpc.PersonMessage.CommonRely> getUpdateMethod;
    if ((getUpdateMethod = SeckillPersonServiceGrpc.getUpdateMethod) == null) {
      synchronized (SeckillPersonServiceGrpc.class) {
        if ((getUpdateMethod = SeckillPersonServiceGrpc.getUpdateMethod) == null) {
          SeckillPersonServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<person.SeckillPersonRpc.PersonMessage.UpdatePersonReq, person.SeckillPersonRpc.PersonMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.UpdatePersonReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillPersonServiceMethodDescriptorSupplier("update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.PersonLoginReq,
      person.SeckillPersonRpc.PersonMessage.PersonLoginRely> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = person.SeckillPersonRpc.PersonMessage.PersonLoginReq.class,
      responseType = person.SeckillPersonRpc.PersonMessage.PersonLoginRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.PersonLoginReq,
      person.SeckillPersonRpc.PersonMessage.PersonLoginRely> getLoginMethod() {
    io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.PersonLoginReq, person.SeckillPersonRpc.PersonMessage.PersonLoginRely> getLoginMethod;
    if ((getLoginMethod = SeckillPersonServiceGrpc.getLoginMethod) == null) {
      synchronized (SeckillPersonServiceGrpc.class) {
        if ((getLoginMethod = SeckillPersonServiceGrpc.getLoginMethod) == null) {
          SeckillPersonServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<person.SeckillPersonRpc.PersonMessage.PersonLoginReq, person.SeckillPersonRpc.PersonMessage.PersonLoginRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.PersonLoginReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.PersonLoginRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillPersonServiceMethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.findUserNameReq,
      person.SeckillPersonRpc.PersonMessage.CommonRely> getFindUserNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findUserName",
      requestType = person.SeckillPersonRpc.PersonMessage.findUserNameReq.class,
      responseType = person.SeckillPersonRpc.PersonMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.findUserNameReq,
      person.SeckillPersonRpc.PersonMessage.CommonRely> getFindUserNameMethod() {
    io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonMessage.findUserNameReq, person.SeckillPersonRpc.PersonMessage.CommonRely> getFindUserNameMethod;
    if ((getFindUserNameMethod = SeckillPersonServiceGrpc.getFindUserNameMethod) == null) {
      synchronized (SeckillPersonServiceGrpc.class) {
        if ((getFindUserNameMethod = SeckillPersonServiceGrpc.getFindUserNameMethod) == null) {
          SeckillPersonServiceGrpc.getFindUserNameMethod = getFindUserNameMethod =
              io.grpc.MethodDescriptor.<person.SeckillPersonRpc.PersonMessage.findUserNameReq, person.SeckillPersonRpc.PersonMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.findUserNameReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillPersonServiceMethodDescriptorSupplier("findUserName"))
              .build();
        }
      }
    }
    return getFindUserNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeckillPersonServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillPersonServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillPersonServiceStub>() {
        @java.lang.Override
        public SeckillPersonServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillPersonServiceStub(channel, callOptions);
        }
      };
    return SeckillPersonServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeckillPersonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillPersonServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillPersonServiceBlockingStub>() {
        @java.lang.Override
        public SeckillPersonServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillPersonServiceBlockingStub(channel, callOptions);
        }
      };
    return SeckillPersonServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeckillPersonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillPersonServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillPersonServiceFutureStub>() {
        @java.lang.Override
        public SeckillPersonServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillPersonServiceFutureStub(channel, callOptions);
        }
      };
    return SeckillPersonServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 用户
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 注册
     * </pre>
     */
    default void create(person.SeckillPersonRpc.PersonMessage.CreatePersonReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    default void update(person.SeckillPersonRpc.PersonMessage.UpdatePersonReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     * <pre>
     * 登陆
     * </pre>
     */
    default void login(person.SeckillPersonRpc.PersonMessage.PersonLoginReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.PersonLoginRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     * <pre>
     * 判断用户名
     * </pre>
     */
    default void findUserName(person.SeckillPersonRpc.PersonMessage.findUserNameReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindUserNameMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeckillPersonService.
   * <pre>
   * 用户
   * </pre>
   */
  public static abstract class SeckillPersonServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SeckillPersonServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SeckillPersonService.
   * <pre>
   * 用户
   * </pre>
   */
  public static final class SeckillPersonServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SeckillPersonServiceStub> {
    private SeckillPersonServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillPersonServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillPersonServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 注册
     * </pre>
     */
    public void create(person.SeckillPersonRpc.PersonMessage.CreatePersonReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    public void update(person.SeckillPersonRpc.PersonMessage.UpdatePersonReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 登陆
     * </pre>
     */
    public void login(person.SeckillPersonRpc.PersonMessage.PersonLoginReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.PersonLoginRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 判断用户名
     * </pre>
     */
    public void findUserName(person.SeckillPersonRpc.PersonMessage.findUserNameReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindUserNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeckillPersonService.
   * <pre>
   * 用户
   * </pre>
   */
  public static final class SeckillPersonServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SeckillPersonServiceBlockingStub> {
    private SeckillPersonServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillPersonServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillPersonServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 注册
     * </pre>
     */
    public person.SeckillPersonRpc.PersonMessage.CommonRely create(person.SeckillPersonRpc.PersonMessage.CreatePersonReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    public person.SeckillPersonRpc.PersonMessage.CommonRely update(person.SeckillPersonRpc.PersonMessage.UpdatePersonReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 登陆
     * </pre>
     */
    public person.SeckillPersonRpc.PersonMessage.PersonLoginRely login(person.SeckillPersonRpc.PersonMessage.PersonLoginReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 判断用户名
     * </pre>
     */
    public person.SeckillPersonRpc.PersonMessage.CommonRely findUserName(person.SeckillPersonRpc.PersonMessage.findUserNameReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindUserNameMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeckillPersonService.
   * <pre>
   * 用户
   * </pre>
   */
  public static final class SeckillPersonServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SeckillPersonServiceFutureStub> {
    private SeckillPersonServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillPersonServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillPersonServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 注册
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<person.SeckillPersonRpc.PersonMessage.CommonRely> create(
        person.SeckillPersonRpc.PersonMessage.CreatePersonReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<person.SeckillPersonRpc.PersonMessage.CommonRely> update(
        person.SeckillPersonRpc.PersonMessage.UpdatePersonReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 登陆
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<person.SeckillPersonRpc.PersonMessage.PersonLoginRely> login(
        person.SeckillPersonRpc.PersonMessage.PersonLoginReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 判断用户名
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<person.SeckillPersonRpc.PersonMessage.CommonRely> findUserName(
        person.SeckillPersonRpc.PersonMessage.findUserNameReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindUserNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_UPDATE = 1;
  private static final int METHODID_LOGIN = 2;
  private static final int METHODID_FIND_USER_NAME = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((person.SeckillPersonRpc.PersonMessage.CreatePersonReq) request,
              (io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((person.SeckillPersonRpc.PersonMessage.UpdatePersonReq) request,
              (io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((person.SeckillPersonRpc.PersonMessage.PersonLoginReq) request,
              (io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.PersonLoginRely>) responseObserver);
          break;
        case METHODID_FIND_USER_NAME:
          serviceImpl.findUserName((person.SeckillPersonRpc.PersonMessage.findUserNameReq) request,
              (io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonMessage.CommonRely>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              person.SeckillPersonRpc.PersonMessage.CreatePersonReq,
              person.SeckillPersonRpc.PersonMessage.CommonRely>(
                service, METHODID_CREATE)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              person.SeckillPersonRpc.PersonMessage.UpdatePersonReq,
              person.SeckillPersonRpc.PersonMessage.CommonRely>(
                service, METHODID_UPDATE)))
        .addMethod(
          getLoginMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              person.SeckillPersonRpc.PersonMessage.PersonLoginReq,
              person.SeckillPersonRpc.PersonMessage.PersonLoginRely>(
                service, METHODID_LOGIN)))
        .addMethod(
          getFindUserNameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              person.SeckillPersonRpc.PersonMessage.findUserNameReq,
              person.SeckillPersonRpc.PersonMessage.CommonRely>(
                service, METHODID_FIND_USER_NAME)))
        .build();
  }

  private static abstract class SeckillPersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeckillPersonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return person.SeckillPersonRpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeckillPersonService");
    }
  }

  private static final class SeckillPersonServiceFileDescriptorSupplier
      extends SeckillPersonServiceBaseDescriptorSupplier {
    SeckillPersonServiceFileDescriptorSupplier() {}
  }

  private static final class SeckillPersonServiceMethodDescriptorSupplier
      extends SeckillPersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SeckillPersonServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SeckillPersonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeckillPersonServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getLoginMethod())
              .addMethod(getFindUserNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}

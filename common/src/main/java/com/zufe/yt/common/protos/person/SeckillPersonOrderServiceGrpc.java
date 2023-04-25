package person;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 用户订单
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: seckill-person-rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SeckillPersonOrderServiceGrpc {

  private SeckillPersonOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "SeckillPersonOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq,
      person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely> getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOrder",
      requestType = person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq.class,
      responseType = person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq,
      person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely> getGetOrderMethod() {
    io.grpc.MethodDescriptor<person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq, person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely> getGetOrderMethod;
    if ((getGetOrderMethod = SeckillPersonOrderServiceGrpc.getGetOrderMethod) == null) {
      synchronized (SeckillPersonOrderServiceGrpc.class) {
        if ((getGetOrderMethod = SeckillPersonOrderServiceGrpc.getGetOrderMethod) == null) {
          SeckillPersonOrderServiceGrpc.getGetOrderMethod = getGetOrderMethod =
              io.grpc.MethodDescriptor.<person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq, person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillPersonOrderServiceMethodDescriptorSupplier("getOrder"))
              .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeckillPersonOrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillPersonOrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillPersonOrderServiceStub>() {
        @java.lang.Override
        public SeckillPersonOrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillPersonOrderServiceStub(channel, callOptions);
        }
      };
    return SeckillPersonOrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeckillPersonOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillPersonOrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillPersonOrderServiceBlockingStub>() {
        @java.lang.Override
        public SeckillPersonOrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillPersonOrderServiceBlockingStub(channel, callOptions);
        }
      };
    return SeckillPersonOrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeckillPersonOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillPersonOrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillPersonOrderServiceFutureStub>() {
        @java.lang.Override
        public SeckillPersonOrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillPersonOrderServiceFutureStub(channel, callOptions);
        }
      };
    return SeckillPersonOrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 用户订单
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 订单列表
     * </pre>
     */
    default void getOrder(person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeckillPersonOrderService.
   * <pre>
   * 用户订单
   * </pre>
   */
  public static abstract class SeckillPersonOrderServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SeckillPersonOrderServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SeckillPersonOrderService.
   * <pre>
   * 用户订单
   * </pre>
   */
  public static final class SeckillPersonOrderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SeckillPersonOrderServiceStub> {
    private SeckillPersonOrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillPersonOrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillPersonOrderServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 订单列表
     * </pre>
     */
    public void getOrder(person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq request,
        io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeckillPersonOrderService.
   * <pre>
   * 用户订单
   * </pre>
   */
  public static final class SeckillPersonOrderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SeckillPersonOrderServiceBlockingStub> {
    private SeckillPersonOrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillPersonOrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillPersonOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 订单列表
     * </pre>
     */
    public person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely getOrder(person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeckillPersonOrderService.
   * <pre>
   * 用户订单
   * </pre>
   */
  public static final class SeckillPersonOrderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SeckillPersonOrderServiceFutureStub> {
    private SeckillPersonOrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillPersonOrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillPersonOrderServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 订单列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely> getOrder(
        person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ORDER = 0;

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
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq) request,
              (io.grpc.stub.StreamObserver<person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely>) responseObserver);
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
          getGetOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              person.SeckillPersonRpc.PersonOrderMessage.GetOrderReq,
              person.SeckillPersonRpc.PersonOrderMessage.GetOrderRely>(
                service, METHODID_GET_ORDER)))
        .build();
  }

  private static abstract class SeckillPersonOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeckillPersonOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return person.SeckillPersonRpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeckillPersonOrderService");
    }
  }

  private static final class SeckillPersonOrderServiceFileDescriptorSupplier
      extends SeckillPersonOrderServiceBaseDescriptorSupplier {
    SeckillPersonOrderServiceFileDescriptorSupplier() {}
  }

  private static final class SeckillPersonOrderServiceMethodDescriptorSupplier
      extends SeckillPersonOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SeckillPersonOrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SeckillPersonOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeckillPersonOrderServiceFileDescriptorSupplier())
              .addMethod(getGetOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}

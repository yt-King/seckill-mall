package order;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 订单
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: seckill-order-rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SeckillOrderServiceGrpc {

  private SeckillOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "SeckillOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<order.SeckillOrderRpc.OrderMessage.AddOrderReq,
      order.SeckillOrderRpc.OrderMessage.CommonRely> getAddOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addOrder",
      requestType = order.SeckillOrderRpc.OrderMessage.AddOrderReq.class,
      responseType = order.SeckillOrderRpc.OrderMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<order.SeckillOrderRpc.OrderMessage.AddOrderReq,
      order.SeckillOrderRpc.OrderMessage.CommonRely> getAddOrderMethod() {
    io.grpc.MethodDescriptor<order.SeckillOrderRpc.OrderMessage.AddOrderReq, order.SeckillOrderRpc.OrderMessage.CommonRely> getAddOrderMethod;
    if ((getAddOrderMethod = SeckillOrderServiceGrpc.getAddOrderMethod) == null) {
      synchronized (SeckillOrderServiceGrpc.class) {
        if ((getAddOrderMethod = SeckillOrderServiceGrpc.getAddOrderMethod) == null) {
          SeckillOrderServiceGrpc.getAddOrderMethod = getAddOrderMethod =
              io.grpc.MethodDescriptor.<order.SeckillOrderRpc.OrderMessage.AddOrderReq, order.SeckillOrderRpc.OrderMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  order.SeckillOrderRpc.OrderMessage.AddOrderReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  order.SeckillOrderRpc.OrderMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillOrderServiceMethodDescriptorSupplier("addOrder"))
              .build();
        }
      }
    }
    return getAddOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeckillOrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillOrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillOrderServiceStub>() {
        @java.lang.Override
        public SeckillOrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillOrderServiceStub(channel, callOptions);
        }
      };
    return SeckillOrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeckillOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillOrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillOrderServiceBlockingStub>() {
        @java.lang.Override
        public SeckillOrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillOrderServiceBlockingStub(channel, callOptions);
        }
      };
    return SeckillOrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeckillOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillOrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillOrderServiceFutureStub>() {
        @java.lang.Override
        public SeckillOrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillOrderServiceFutureStub(channel, callOptions);
        }
      };
    return SeckillOrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 订单
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 新增
     * </pre>
     */
    default void addOrder(order.SeckillOrderRpc.OrderMessage.AddOrderReq request,
        io.grpc.stub.StreamObserver<order.SeckillOrderRpc.OrderMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddOrderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeckillOrderService.
   * <pre>
   * 订单
   * </pre>
   */
  public static abstract class SeckillOrderServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SeckillOrderServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SeckillOrderService.
   * <pre>
   * 订单
   * </pre>
   */
  public static final class SeckillOrderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SeckillOrderServiceStub> {
    private SeckillOrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillOrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillOrderServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 新增
     * </pre>
     */
    public void addOrder(order.SeckillOrderRpc.OrderMessage.AddOrderReq request,
        io.grpc.stub.StreamObserver<order.SeckillOrderRpc.OrderMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeckillOrderService.
   * <pre>
   * 订单
   * </pre>
   */
  public static final class SeckillOrderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SeckillOrderServiceBlockingStub> {
    private SeckillOrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillOrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 新增
     * </pre>
     */
    public order.SeckillOrderRpc.OrderMessage.CommonRely addOrder(order.SeckillOrderRpc.OrderMessage.AddOrderReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeckillOrderService.
   * <pre>
   * 订单
   * </pre>
   */
  public static final class SeckillOrderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SeckillOrderServiceFutureStub> {
    private SeckillOrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillOrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillOrderServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 新增
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<order.SeckillOrderRpc.OrderMessage.CommonRely> addOrder(
        order.SeckillOrderRpc.OrderMessage.AddOrderReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_ORDER = 0;

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
        case METHODID_ADD_ORDER:
          serviceImpl.addOrder((order.SeckillOrderRpc.OrderMessage.AddOrderReq) request,
              (io.grpc.stub.StreamObserver<order.SeckillOrderRpc.OrderMessage.CommonRely>) responseObserver);
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
          getAddOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              order.SeckillOrderRpc.OrderMessage.AddOrderReq,
              order.SeckillOrderRpc.OrderMessage.CommonRely>(
                service, METHODID_ADD_ORDER)))
        .build();
  }

  private static abstract class SeckillOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeckillOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return order.SeckillOrderRpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeckillOrderService");
    }
  }

  private static final class SeckillOrderServiceFileDescriptorSupplier
      extends SeckillOrderServiceBaseDescriptorSupplier {
    SeckillOrderServiceFileDescriptorSupplier() {}
  }

  private static final class SeckillOrderServiceMethodDescriptorSupplier
      extends SeckillOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SeckillOrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SeckillOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeckillOrderServiceFileDescriptorSupplier())
              .addMethod(getAddOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}

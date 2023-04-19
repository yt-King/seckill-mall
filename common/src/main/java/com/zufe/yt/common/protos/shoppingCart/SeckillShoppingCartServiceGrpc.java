package shoppingCart;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 用户购物车
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: seckill-shopping-cart-rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SeckillShoppingCartServiceGrpc {

  private SeckillShoppingCartServiceGrpc() {}

  public static final String SERVICE_NAME = "SeckillShoppingCartService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getAddShoppingCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addShoppingCart",
      requestType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq.class,
      responseType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getAddShoppingCartMethod() {
    io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getAddShoppingCartMethod;
    if ((getAddShoppingCartMethod = SeckillShoppingCartServiceGrpc.getAddShoppingCartMethod) == null) {
      synchronized (SeckillShoppingCartServiceGrpc.class) {
        if ((getAddShoppingCartMethod = SeckillShoppingCartServiceGrpc.getAddShoppingCartMethod) == null) {
          SeckillShoppingCartServiceGrpc.getAddShoppingCartMethod = getAddShoppingCartMethod =
              io.grpc.MethodDescriptor.<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addShoppingCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillShoppingCartServiceMethodDescriptorSupplier("addShoppingCart"))
              .build();
        }
      }
    }
    return getAddShoppingCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getDeleteShoppingCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteShoppingCart",
      requestType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq.class,
      responseType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getDeleteShoppingCartMethod() {
    io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getDeleteShoppingCartMethod;
    if ((getDeleteShoppingCartMethod = SeckillShoppingCartServiceGrpc.getDeleteShoppingCartMethod) == null) {
      synchronized (SeckillShoppingCartServiceGrpc.class) {
        if ((getDeleteShoppingCartMethod = SeckillShoppingCartServiceGrpc.getDeleteShoppingCartMethod) == null) {
          SeckillShoppingCartServiceGrpc.getDeleteShoppingCartMethod = getDeleteShoppingCartMethod =
              io.grpc.MethodDescriptor.<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteShoppingCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillShoppingCartServiceMethodDescriptorSupplier("deleteShoppingCart"))
              .build();
        }
      }
    }
    return getDeleteShoppingCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getUpdateShoppingCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateShoppingCart",
      requestType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq.class,
      responseType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getUpdateShoppingCartMethod() {
    io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> getUpdateShoppingCartMethod;
    if ((getUpdateShoppingCartMethod = SeckillShoppingCartServiceGrpc.getUpdateShoppingCartMethod) == null) {
      synchronized (SeckillShoppingCartServiceGrpc.class) {
        if ((getUpdateShoppingCartMethod = SeckillShoppingCartServiceGrpc.getUpdateShoppingCartMethod) == null) {
          SeckillShoppingCartServiceGrpc.getUpdateShoppingCartMethod = getUpdateShoppingCartMethod =
              io.grpc.MethodDescriptor.<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateShoppingCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillShoppingCartServiceMethodDescriptorSupplier("updateShoppingCart"))
              .build();
        }
      }
    }
    return getUpdateShoppingCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely> getGetShoppingCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getShoppingCart",
      requestType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq.class,
      responseType = shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq,
      shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely> getGetShoppingCartMethod() {
    io.grpc.MethodDescriptor<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely> getGetShoppingCartMethod;
    if ((getGetShoppingCartMethod = SeckillShoppingCartServiceGrpc.getGetShoppingCartMethod) == null) {
      synchronized (SeckillShoppingCartServiceGrpc.class) {
        if ((getGetShoppingCartMethod = SeckillShoppingCartServiceGrpc.getGetShoppingCartMethod) == null) {
          SeckillShoppingCartServiceGrpc.getGetShoppingCartMethod = getGetShoppingCartMethod =
              io.grpc.MethodDescriptor.<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq, shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getShoppingCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillShoppingCartServiceMethodDescriptorSupplier("getShoppingCart"))
              .build();
        }
      }
    }
    return getGetShoppingCartMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeckillShoppingCartServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillShoppingCartServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillShoppingCartServiceStub>() {
        @java.lang.Override
        public SeckillShoppingCartServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillShoppingCartServiceStub(channel, callOptions);
        }
      };
    return SeckillShoppingCartServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeckillShoppingCartServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillShoppingCartServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillShoppingCartServiceBlockingStub>() {
        @java.lang.Override
        public SeckillShoppingCartServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillShoppingCartServiceBlockingStub(channel, callOptions);
        }
      };
    return SeckillShoppingCartServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeckillShoppingCartServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillShoppingCartServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillShoppingCartServiceFutureStub>() {
        @java.lang.Override
        public SeckillShoppingCartServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillShoppingCartServiceFutureStub(channel, callOptions);
        }
      };
    return SeckillShoppingCartServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 用户购物车
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 添加购物车
     * </pre>
     */
    default void addShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddShoppingCartMethod(), responseObserver);
    }

    /**
     * <pre>
     * 删除购物车
     * </pre>
     */
    default void deleteShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteShoppingCartMethod(), responseObserver);
    }

    /**
     * <pre>
     * 更新购物车数量
     * </pre>
     */
    default void updateShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateShoppingCartMethod(), responseObserver);
    }

    /**
     * <pre>
     * 购物车列表
     * </pre>
     */
    default void getShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShoppingCartMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeckillShoppingCartService.
   * <pre>
   * 用户购物车
   * </pre>
   */
  public static abstract class SeckillShoppingCartServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SeckillShoppingCartServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SeckillShoppingCartService.
   * <pre>
   * 用户购物车
   * </pre>
   */
  public static final class SeckillShoppingCartServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SeckillShoppingCartServiceStub> {
    private SeckillShoppingCartServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillShoppingCartServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillShoppingCartServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加购物车
     * </pre>
     */
    public void addShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddShoppingCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 删除购物车
     * </pre>
     */
    public void deleteShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteShoppingCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 更新购物车数量
     * </pre>
     */
    public void updateShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateShoppingCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 购物车列表
     * </pre>
     */
    public void getShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq request,
        io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShoppingCartMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeckillShoppingCartService.
   * <pre>
   * 用户购物车
   * </pre>
   */
  public static final class SeckillShoppingCartServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SeckillShoppingCartServiceBlockingStub> {
    private SeckillShoppingCartServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillShoppingCartServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillShoppingCartServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加购物车
     * </pre>
     */
    public shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely addShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddShoppingCartMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 删除购物车
     * </pre>
     */
    public shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely deleteShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteShoppingCartMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 更新购物车数量
     * </pre>
     */
    public shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely updateShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateShoppingCartMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 购物车列表
     * </pre>
     */
    public shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely getShoppingCart(shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShoppingCartMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeckillShoppingCartService.
   * <pre>
   * 用户购物车
   * </pre>
   */
  public static final class SeckillShoppingCartServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SeckillShoppingCartServiceFutureStub> {
    private SeckillShoppingCartServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillShoppingCartServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillShoppingCartServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加购物车
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> addShoppingCart(
        shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddShoppingCartMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 删除购物车
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> deleteShoppingCart(
        shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteShoppingCartMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 更新购物车数量
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely> updateShoppingCart(
        shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateShoppingCartMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 购物车列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely> getShoppingCart(
        shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShoppingCartMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SHOPPING_CART = 0;
  private static final int METHODID_DELETE_SHOPPING_CART = 1;
  private static final int METHODID_UPDATE_SHOPPING_CART = 2;
  private static final int METHODID_GET_SHOPPING_CART = 3;

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
        case METHODID_ADD_SHOPPING_CART:
          serviceImpl.addShoppingCart((shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq) request,
              (io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>) responseObserver);
          break;
        case METHODID_DELETE_SHOPPING_CART:
          serviceImpl.deleteShoppingCart((shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq) request,
              (io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>) responseObserver);
          break;
        case METHODID_UPDATE_SHOPPING_CART:
          serviceImpl.updateShoppingCart((shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq) request,
              (io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>) responseObserver);
          break;
        case METHODID_GET_SHOPPING_CART:
          serviceImpl.getShoppingCart((shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq) request,
              (io.grpc.stub.StreamObserver<shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely>) responseObserver);
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
          getAddShoppingCartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.AddShoppingCartReq,
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>(
                service, METHODID_ADD_SHOPPING_CART)))
        .addMethod(
          getDeleteShoppingCartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.DeleteShoppingCartReq,
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>(
                service, METHODID_DELETE_SHOPPING_CART)))
        .addMethod(
          getUpdateShoppingCartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.UpdateShoppingCartReq,
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.CommonRely>(
                service, METHODID_UPDATE_SHOPPING_CART)))
        .addMethod(
          getGetShoppingCartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartReq,
              shoppingCart.SeckillShoppingCartRpc.ShoppingCartMessage.GetShoppingCartRely>(
                service, METHODID_GET_SHOPPING_CART)))
        .build();
  }

  private static abstract class SeckillShoppingCartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeckillShoppingCartServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return shoppingCart.SeckillShoppingCartRpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeckillShoppingCartService");
    }
  }

  private static final class SeckillShoppingCartServiceFileDescriptorSupplier
      extends SeckillShoppingCartServiceBaseDescriptorSupplier {
    SeckillShoppingCartServiceFileDescriptorSupplier() {}
  }

  private static final class SeckillShoppingCartServiceMethodDescriptorSupplier
      extends SeckillShoppingCartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SeckillShoppingCartServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SeckillShoppingCartServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeckillShoppingCartServiceFileDescriptorSupplier())
              .addMethod(getAddShoppingCartMethod())
              .addMethod(getDeleteShoppingCartMethod())
              .addMethod(getUpdateShoppingCartMethod())
              .addMethod(getGetShoppingCartMethod())
              .build();
        }
      }
    }
    return result;
  }
}

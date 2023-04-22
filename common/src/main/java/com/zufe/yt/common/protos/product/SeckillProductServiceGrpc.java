package product;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 商品
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: seckill-product-rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SeckillProductServiceGrpc {

  private SeckillProductServiceGrpc() {}

  public static final String SERVICE_NAME = "SeckillProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq,
      product.SeckillProductRpc.ProductMessage.CommonRely> getSaveOrUpdateProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveOrUpdateProduct",
      requestType = product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq.class,
      responseType = product.SeckillProductRpc.ProductMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq,
      product.SeckillProductRpc.ProductMessage.CommonRely> getSaveOrUpdateProductMethod() {
    io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq, product.SeckillProductRpc.ProductMessage.CommonRely> getSaveOrUpdateProductMethod;
    if ((getSaveOrUpdateProductMethod = SeckillProductServiceGrpc.getSaveOrUpdateProductMethod) == null) {
      synchronized (SeckillProductServiceGrpc.class) {
        if ((getSaveOrUpdateProductMethod = SeckillProductServiceGrpc.getSaveOrUpdateProductMethod) == null) {
          SeckillProductServiceGrpc.getSaveOrUpdateProductMethod = getSaveOrUpdateProductMethod =
              io.grpc.MethodDescriptor.<product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq, product.SeckillProductRpc.ProductMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveOrUpdateProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillProductServiceMethodDescriptorSupplier("saveOrUpdateProduct"))
              .build();
        }
      }
    }
    return getSaveOrUpdateProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.DeleteProductReq,
      product.SeckillProductRpc.ProductMessage.CommonRely> getDeleteProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteProduct",
      requestType = product.SeckillProductRpc.ProductMessage.DeleteProductReq.class,
      responseType = product.SeckillProductRpc.ProductMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.DeleteProductReq,
      product.SeckillProductRpc.ProductMessage.CommonRely> getDeleteProductMethod() {
    io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.DeleteProductReq, product.SeckillProductRpc.ProductMessage.CommonRely> getDeleteProductMethod;
    if ((getDeleteProductMethod = SeckillProductServiceGrpc.getDeleteProductMethod) == null) {
      synchronized (SeckillProductServiceGrpc.class) {
        if ((getDeleteProductMethod = SeckillProductServiceGrpc.getDeleteProductMethod) == null) {
          SeckillProductServiceGrpc.getDeleteProductMethod = getDeleteProductMethod =
              io.grpc.MethodDescriptor.<product.SeckillProductRpc.ProductMessage.DeleteProductReq, product.SeckillProductRpc.ProductMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.DeleteProductReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillProductServiceMethodDescriptorSupplier("deleteProduct"))
              .build();
        }
      }
    }
    return getDeleteProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.GetCategoryReq,
      product.SeckillProductRpc.ProductMessage.GetCategoryRely> getGetCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCategory",
      requestType = product.SeckillProductRpc.ProductMessage.GetCategoryReq.class,
      responseType = product.SeckillProductRpc.ProductMessage.GetCategoryRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.GetCategoryReq,
      product.SeckillProductRpc.ProductMessage.GetCategoryRely> getGetCategoryMethod() {
    io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.GetCategoryReq, product.SeckillProductRpc.ProductMessage.GetCategoryRely> getGetCategoryMethod;
    if ((getGetCategoryMethod = SeckillProductServiceGrpc.getGetCategoryMethod) == null) {
      synchronized (SeckillProductServiceGrpc.class) {
        if ((getGetCategoryMethod = SeckillProductServiceGrpc.getGetCategoryMethod) == null) {
          SeckillProductServiceGrpc.getGetCategoryMethod = getGetCategoryMethod =
              io.grpc.MethodDescriptor.<product.SeckillProductRpc.ProductMessage.GetCategoryReq, product.SeckillProductRpc.ProductMessage.GetCategoryRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.GetCategoryReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.GetCategoryRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillProductServiceMethodDescriptorSupplier("getCategory"))
              .build();
        }
      }
    }
    return getGetCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.GetAllProductReq,
      product.SeckillProductRpc.ProductMessage.GetAllProductRely> getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProduct",
      requestType = product.SeckillProductRpc.ProductMessage.GetAllProductReq.class,
      responseType = product.SeckillProductRpc.ProductMessage.GetAllProductRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.GetAllProductReq,
      product.SeckillProductRpc.ProductMessage.GetAllProductRely> getGetProductMethod() {
    io.grpc.MethodDescriptor<product.SeckillProductRpc.ProductMessage.GetAllProductReq, product.SeckillProductRpc.ProductMessage.GetAllProductRely> getGetProductMethod;
    if ((getGetProductMethod = SeckillProductServiceGrpc.getGetProductMethod) == null) {
      synchronized (SeckillProductServiceGrpc.class) {
        if ((getGetProductMethod = SeckillProductServiceGrpc.getGetProductMethod) == null) {
          SeckillProductServiceGrpc.getGetProductMethod = getGetProductMethod =
              io.grpc.MethodDescriptor.<product.SeckillProductRpc.ProductMessage.GetAllProductReq, product.SeckillProductRpc.ProductMessage.GetAllProductRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.GetAllProductReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  product.SeckillProductRpc.ProductMessage.GetAllProductRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillProductServiceMethodDescriptorSupplier("getProduct"))
              .build();
        }
      }
    }
    return getGetProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeckillProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillProductServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillProductServiceStub>() {
        @java.lang.Override
        public SeckillProductServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillProductServiceStub(channel, callOptions);
        }
      };
    return SeckillProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeckillProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillProductServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillProductServiceBlockingStub>() {
        @java.lang.Override
        public SeckillProductServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillProductServiceBlockingStub(channel, callOptions);
        }
      };
    return SeckillProductServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeckillProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillProductServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillProductServiceFutureStub>() {
        @java.lang.Override
        public SeckillProductServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillProductServiceFutureStub(channel, callOptions);
        }
      };
    return SeckillProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 商品
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 添加或更新商品
     * </pre>
     */
    default void saveOrUpdateProduct(product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveOrUpdateProductMethod(), responseObserver);
    }

    /**
     * <pre>
     * 删除商品
     * </pre>
     */
    default void deleteProduct(product.SeckillProductRpc.ProductMessage.DeleteProductReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteProductMethod(), responseObserver);
    }

    /**
     * <pre>
     * 分类列表
     * </pre>
     */
    default void getCategory(product.SeckillProductRpc.ProductMessage.GetCategoryReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.GetCategoryRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCategoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * 商品列表
     * </pre>
     */
    default void getProduct(product.SeckillProductRpc.ProductMessage.GetAllProductReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.GetAllProductRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeckillProductService.
   * <pre>
   * 商品
   * </pre>
   */
  public static abstract class SeckillProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SeckillProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SeckillProductService.
   * <pre>
   * 商品
   * </pre>
   */
  public static final class SeckillProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SeckillProductServiceStub> {
    private SeckillProductServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillProductServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加或更新商品
     * </pre>
     */
    public void saveOrUpdateProduct(product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveOrUpdateProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 删除商品
     * </pre>
     */
    public void deleteProduct(product.SeckillProductRpc.ProductMessage.DeleteProductReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 分类列表
     * </pre>
     */
    public void getCategory(product.SeckillProductRpc.ProductMessage.GetCategoryReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.GetCategoryRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 商品列表
     * </pre>
     */
    public void getProduct(product.SeckillProductRpc.ProductMessage.GetAllProductReq request,
        io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.GetAllProductRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeckillProductService.
   * <pre>
   * 商品
   * </pre>
   */
  public static final class SeckillProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SeckillProductServiceBlockingStub> {
    private SeckillProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillProductServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加或更新商品
     * </pre>
     */
    public product.SeckillProductRpc.ProductMessage.CommonRely saveOrUpdateProduct(product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveOrUpdateProductMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 删除商品
     * </pre>
     */
    public product.SeckillProductRpc.ProductMessage.CommonRely deleteProduct(product.SeckillProductRpc.ProductMessage.DeleteProductReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProductMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 分类列表
     * </pre>
     */
    public product.SeckillProductRpc.ProductMessage.GetCategoryRely getCategory(product.SeckillProductRpc.ProductMessage.GetCategoryReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCategoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 商品列表
     * </pre>
     */
    public product.SeckillProductRpc.ProductMessage.GetAllProductRely getProduct(product.SeckillProductRpc.ProductMessage.GetAllProductReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeckillProductService.
   * <pre>
   * 商品
   * </pre>
   */
  public static final class SeckillProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SeckillProductServiceFutureStub> {
    private SeckillProductServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillProductServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加或更新商品
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<product.SeckillProductRpc.ProductMessage.CommonRely> saveOrUpdateProduct(
        product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveOrUpdateProductMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 删除商品
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<product.SeckillProductRpc.ProductMessage.CommonRely> deleteProduct(
        product.SeckillProductRpc.ProductMessage.DeleteProductReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProductMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 分类列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<product.SeckillProductRpc.ProductMessage.GetCategoryRely> getCategory(
        product.SeckillProductRpc.ProductMessage.GetCategoryReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCategoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 商品列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<product.SeckillProductRpc.ProductMessage.GetAllProductRely> getProduct(
        product.SeckillProductRpc.ProductMessage.GetAllProductReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE_OR_UPDATE_PRODUCT = 0;
  private static final int METHODID_DELETE_PRODUCT = 1;
  private static final int METHODID_GET_CATEGORY = 2;
  private static final int METHODID_GET_PRODUCT = 3;

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
        case METHODID_SAVE_OR_UPDATE_PRODUCT:
          serviceImpl.saveOrUpdateProduct((product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq) request,
              (io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.CommonRely>) responseObserver);
          break;
        case METHODID_DELETE_PRODUCT:
          serviceImpl.deleteProduct((product.SeckillProductRpc.ProductMessage.DeleteProductReq) request,
              (io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.CommonRely>) responseObserver);
          break;
        case METHODID_GET_CATEGORY:
          serviceImpl.getCategory((product.SeckillProductRpc.ProductMessage.GetCategoryReq) request,
              (io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.GetCategoryRely>) responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct((product.SeckillProductRpc.ProductMessage.GetAllProductReq) request,
              (io.grpc.stub.StreamObserver<product.SeckillProductRpc.ProductMessage.GetAllProductRely>) responseObserver);
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
          getSaveOrUpdateProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              product.SeckillProductRpc.ProductMessage.saveOrUpdateProductReq,
              product.SeckillProductRpc.ProductMessage.CommonRely>(
                service, METHODID_SAVE_OR_UPDATE_PRODUCT)))
        .addMethod(
          getDeleteProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              product.SeckillProductRpc.ProductMessage.DeleteProductReq,
              product.SeckillProductRpc.ProductMessage.CommonRely>(
                service, METHODID_DELETE_PRODUCT)))
        .addMethod(
          getGetCategoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              product.SeckillProductRpc.ProductMessage.GetCategoryReq,
              product.SeckillProductRpc.ProductMessage.GetCategoryRely>(
                service, METHODID_GET_CATEGORY)))
        .addMethod(
          getGetProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              product.SeckillProductRpc.ProductMessage.GetAllProductReq,
              product.SeckillProductRpc.ProductMessage.GetAllProductRely>(
                service, METHODID_GET_PRODUCT)))
        .build();
  }

  private static abstract class SeckillProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeckillProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return product.SeckillProductRpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeckillProductService");
    }
  }

  private static final class SeckillProductServiceFileDescriptorSupplier
      extends SeckillProductServiceBaseDescriptorSupplier {
    SeckillProductServiceFileDescriptorSupplier() {}
  }

  private static final class SeckillProductServiceMethodDescriptorSupplier
      extends SeckillProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SeckillProductServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SeckillProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeckillProductServiceFileDescriptorSupplier())
              .addMethod(getSaveOrUpdateProductMethod())
              .addMethod(getDeleteProductMethod())
              .addMethod(getGetCategoryMethod())
              .addMethod(getGetProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}

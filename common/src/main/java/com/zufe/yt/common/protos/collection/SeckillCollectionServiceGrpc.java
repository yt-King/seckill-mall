package collection;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 用户收藏
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: seckill-collection-rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SeckillCollectionServiceGrpc {

  private SeckillCollectionServiceGrpc() {}

  public static final String SERVICE_NAME = "SeckillCollectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getAddCollectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCollect",
      requestType = collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq.class,
      responseType = collection.SeckillCollectionRpc.CollectionMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getAddCollectMethod() {
    io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getAddCollectMethod;
    if ((getAddCollectMethod = SeckillCollectionServiceGrpc.getAddCollectMethod) == null) {
      synchronized (SeckillCollectionServiceGrpc.class) {
        if ((getAddCollectMethod = SeckillCollectionServiceGrpc.getAddCollectMethod) == null) {
          SeckillCollectionServiceGrpc.getAddCollectMethod = getAddCollectMethod =
              io.grpc.MethodDescriptor.<collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCollect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillCollectionServiceMethodDescriptorSupplier("addCollect"))
              .build();
        }
      }
    }
    return getAddCollectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getDeleteCollectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCollect",
      requestType = collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq.class,
      responseType = collection.SeckillCollectionRpc.CollectionMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getDeleteCollectMethod() {
    io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getDeleteCollectMethod;
    if ((getDeleteCollectMethod = SeckillCollectionServiceGrpc.getDeleteCollectMethod) == null) {
      synchronized (SeckillCollectionServiceGrpc.class) {
        if ((getDeleteCollectMethod = SeckillCollectionServiceGrpc.getDeleteCollectMethod) == null) {
          SeckillCollectionServiceGrpc.getDeleteCollectMethod = getDeleteCollectMethod =
              io.grpc.MethodDescriptor.<collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCollect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillCollectionServiceMethodDescriptorSupplier("deleteCollect"))
              .build();
        }
      }
    }
    return getDeleteCollectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq,
      collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely> getGetCollectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCollect",
      requestType = collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq.class,
      responseType = collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq,
      collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely> getGetCollectMethod() {
    io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq, collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely> getGetCollectMethod;
    if ((getGetCollectMethod = SeckillCollectionServiceGrpc.getGetCollectMethod) == null) {
      synchronized (SeckillCollectionServiceGrpc.class) {
        if ((getGetCollectMethod = SeckillCollectionServiceGrpc.getGetCollectMethod) == null) {
          SeckillCollectionServiceGrpc.getGetCollectMethod = getGetCollectMethod =
              io.grpc.MethodDescriptor.<collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq, collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCollect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillCollectionServiceMethodDescriptorSupplier("getCollect"))
              .build();
        }
      }
    }
    return getGetCollectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeckillCollectionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillCollectionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillCollectionServiceStub>() {
        @java.lang.Override
        public SeckillCollectionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillCollectionServiceStub(channel, callOptions);
        }
      };
    return SeckillCollectionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeckillCollectionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillCollectionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillCollectionServiceBlockingStub>() {
        @java.lang.Override
        public SeckillCollectionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillCollectionServiceBlockingStub(channel, callOptions);
        }
      };
    return SeckillCollectionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeckillCollectionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SeckillCollectionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SeckillCollectionServiceFutureStub>() {
        @java.lang.Override
        public SeckillCollectionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SeckillCollectionServiceFutureStub(channel, callOptions);
        }
      };
    return SeckillCollectionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 用户收藏
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 添加收藏
     * </pre>
     */
    default void addCollect(collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCollectMethod(), responseObserver);
    }

    /**
     * <pre>
     * 删除收藏
     * </pre>
     */
    default void deleteCollect(collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCollectMethod(), responseObserver);
    }

    /**
     * <pre>
     * 收藏列表
     * </pre>
     */
    default void getCollect(collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCollectMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeckillCollectionService.
   * <pre>
   * 用户收藏
   * </pre>
   */
  public static abstract class SeckillCollectionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SeckillCollectionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SeckillCollectionService.
   * <pre>
   * 用户收藏
   * </pre>
   */
  public static final class SeckillCollectionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SeckillCollectionServiceStub> {
    private SeckillCollectionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillCollectionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillCollectionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加收藏
     * </pre>
     */
    public void addCollect(collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCollectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 删除收藏
     * </pre>
     */
    public void deleteCollect(collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCollectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 收藏列表
     * </pre>
     */
    public void getCollect(collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCollectMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeckillCollectionService.
   * <pre>
   * 用户收藏
   * </pre>
   */
  public static final class SeckillCollectionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SeckillCollectionServiceBlockingStub> {
    private SeckillCollectionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillCollectionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillCollectionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加收藏
     * </pre>
     */
    public collection.SeckillCollectionRpc.CollectionMessage.CommonRely addCollect(collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCollectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 删除收藏
     * </pre>
     */
    public collection.SeckillCollectionRpc.CollectionMessage.CommonRely deleteCollect(collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCollectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 收藏列表
     * </pre>
     */
    public collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely getCollect(collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCollectMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeckillCollectionService.
   * <pre>
   * 用户收藏
   * </pre>
   */
  public static final class SeckillCollectionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SeckillCollectionServiceFutureStub> {
    private SeckillCollectionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeckillCollectionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SeckillCollectionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 添加收藏
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> addCollect(
        collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCollectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 删除收藏
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> deleteCollect(
        collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCollectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 收藏列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely> getCollect(
        collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCollectMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_COLLECT = 0;
  private static final int METHODID_DELETE_COLLECT = 1;
  private static final int METHODID_GET_COLLECT = 2;

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
        case METHODID_ADD_COLLECT:
          serviceImpl.addCollect((collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq) request,
              (io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely>) responseObserver);
          break;
        case METHODID_DELETE_COLLECT:
          serviceImpl.deleteCollect((collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq) request,
              (io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely>) responseObserver);
          break;
        case METHODID_GET_COLLECT:
          serviceImpl.getCollect((collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq) request,
              (io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely>) responseObserver);
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
          getAddCollectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              collection.SeckillCollectionRpc.CollectionMessage.AddCollectionReq,
              collection.SeckillCollectionRpc.CollectionMessage.CommonRely>(
                service, METHODID_ADD_COLLECT)))
        .addMethod(
          getDeleteCollectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              collection.SeckillCollectionRpc.CollectionMessage.DeleteCollectReq,
              collection.SeckillCollectionRpc.CollectionMessage.CommonRely>(
                service, METHODID_DELETE_COLLECT)))
        .addMethod(
          getGetCollectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              collection.SeckillCollectionRpc.CollectionMessage.GetCollectReq,
              collection.SeckillCollectionRpc.CollectionMessage.GetCollectRely>(
                service, METHODID_GET_COLLECT)))
        .build();
  }

  private static abstract class SeckillCollectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SeckillCollectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return collection.SeckillCollectionRpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SeckillCollectionService");
    }
  }

  private static final class SeckillCollectionServiceFileDescriptorSupplier
      extends SeckillCollectionServiceBaseDescriptorSupplier {
    SeckillCollectionServiceFileDescriptorSupplier() {}
  }

  private static final class SeckillCollectionServiceMethodDescriptorSupplier
      extends SeckillCollectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SeckillCollectionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SeckillCollectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeckillCollectionServiceFileDescriptorSupplier())
              .addMethod(getAddCollectMethod())
              .addMethod(getDeleteCollectMethod())
              .addMethod(getGetCollectMethod())
              .build();
        }
      }
    }
    return result;
  }
}

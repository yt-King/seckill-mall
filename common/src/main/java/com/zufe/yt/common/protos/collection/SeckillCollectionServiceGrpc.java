package collection;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 用户
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
  private static volatile io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "create",
      requestType = collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq.class,
      responseType = collection.SeckillCollectionRpc.CollectionMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getCreateMethod() {
    io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getCreateMethod;
    if ((getCreateMethod = SeckillCollectionServiceGrpc.getCreateMethod) == null) {
      synchronized (SeckillCollectionServiceGrpc.class) {
        if ((getCreateMethod = SeckillCollectionServiceGrpc.getCreateMethod) == null) {
          SeckillCollectionServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillCollectionServiceMethodDescriptorSupplier("create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq.class,
      responseType = collection.SeckillCollectionRpc.CollectionMessage.CommonRely.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq,
      collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getUpdateMethod() {
    io.grpc.MethodDescriptor<collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely> getUpdateMethod;
    if ((getUpdateMethod = SeckillCollectionServiceGrpc.getUpdateMethod) == null) {
      synchronized (SeckillCollectionServiceGrpc.class) {
        if ((getUpdateMethod = SeckillCollectionServiceGrpc.getUpdateMethod) == null) {
          SeckillCollectionServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq, collection.SeckillCollectionRpc.CollectionMessage.CommonRely>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  collection.SeckillCollectionRpc.CollectionMessage.CommonRely.getDefaultInstance()))
              .setSchemaDescriptor(new SeckillCollectionServiceMethodDescriptorSupplier("update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
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
   * 用户
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 创建
     * </pre>
     */
    default void create(collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    default void update(collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SeckillCollectionService.
   * <pre>
   * 用户
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
   * 用户
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
     * 创建
     * </pre>
     */
    public void create(collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    public void update(collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq request,
        io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SeckillCollectionService.
   * <pre>
   * 用户
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
     * 创建
     * </pre>
     */
    public collection.SeckillCollectionRpc.CollectionMessage.CommonRely create(collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    public collection.SeckillCollectionRpc.CollectionMessage.CommonRely update(collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SeckillCollectionService.
   * <pre>
   * 用户
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
     * 创建
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> create(
        collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 更新
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<collection.SeckillCollectionRpc.CollectionMessage.CommonRely> update(
        collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_UPDATE = 1;

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
          serviceImpl.create((collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq) request,
              (io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq) request,
              (io.grpc.stub.StreamObserver<collection.SeckillCollectionRpc.CollectionMessage.CommonRely>) responseObserver);
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
              collection.SeckillCollectionRpc.CollectionMessage.CreateCollectionReq,
              collection.SeckillCollectionRpc.CollectionMessage.CommonRely>(
                service, METHODID_CREATE)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              collection.SeckillCollectionRpc.CollectionMessage.UpdateCollectionReq,
              collection.SeckillCollectionRpc.CollectionMessage.CommonRely>(
                service, METHODID_UPDATE)))
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
              .addMethod(getCreateMethod())
              .addMethod(getUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}

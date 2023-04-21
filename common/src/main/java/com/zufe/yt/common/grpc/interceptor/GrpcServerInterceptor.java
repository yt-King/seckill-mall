package com.zufe.yt.common.grpc.interceptor;


import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.grpc.util.RequestUtils;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;

/**
 * @author 秋玖壹
 **/
@Slf4j
@GrpcGlobalServerInterceptor
public class GrpcServerInterceptor implements ServerInterceptor {

    @Override
    public <T, R> ServerCall.Listener<T> interceptCall(ServerCall<T, R> serverCall, Metadata metadata, ServerCallHandler<T, R> serverCallHandler) {
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<T>(serverCallHandler.startCall(serverCall, metadata)) {
            @Override
            public void onHalfClose() {
                try {
                    RequestUtils.initGrpc(metadata);
                    super.onHalfClose();
                } catch (ServiceException e) {
                    metadata.put(Metadata.Key.of("message-bin", Metadata.BINARY_BYTE_MARSHALLER), e.getMessage().getBytes());
                    serverCall.close(Status.INTERNAL.withDescription(e.getCode() + ":" + e.getMessage()), metadata);
                } catch (Exception e) {
                    log.error("grpc server occured exception.", e);
                    // 通过元数据传输消息
                    metadata.put(Metadata.Key.of("message-bin", Metadata.BINARY_BYTE_MARSHALLER), e.getMessage().getBytes());
                    serverCall.close(Status.UNKNOWN.withDescription(e.getMessage()), metadata);

                } finally {
                    RequestUtils.destroy();
                }
            }

        };
    }
}

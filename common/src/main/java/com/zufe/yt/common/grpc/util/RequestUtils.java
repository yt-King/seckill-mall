package com.zufe.yt.common.grpc.util;

import io.grpc.Metadata;

/**
 * @author chengsiyi
 * @date 2022/9/20 20:12
 */
public class RequestUtils {

    private static final ThreadLocal<RequestDto> LOCAL = new ThreadLocal<>();


    private RequestUtils() {
        //do nothing
    }


    public static void initGrpc(Metadata metadata) {
        //先清理
        clearThreadLocally();
        get().init(metadata);
    }

    /**
     * 销毁工作，此方法调用后RequestLocal不再提供服务。
     */
    public static void destroy() {
        clearThreadLocally();
    }

    /**
     * 清空线程本地变量,必须在处理完用户请求之后调用
     */
    private static void clearThreadLocally() {
        LOCAL.remove();
    }

    /**
     * 获得当前登录的用户的ip
     */
    public static String getIp() {
        return get().ip;
    }

    /**
     * 获得当前登录的用户的ua
     */
    public static String getUa() {
        return get().userAgent;
    }

    /**
     * 获取店铺ID
     * @return 店铺ID
     */
    public static String getShopId() {
        return get().shopId;
    }

    /**
     * 获取用户ID
     * @return 用户ID
     */
    public static String getRoleId() {
        return get().roleId;
    }

    /**
     * 获取用户ID
     * @return 用户ID
     */
    public static String getGrayVersion() {
        return get().grayVersion;
    }

    /**
     * 获取接口类型
     * @return 接口类型
     */
    public static String getRoleType() {
        return get().roleType;
    }

    public static boolean isAdmin() {
        return clientCheck("admin");
    }

    public static boolean isUser() {
        return clientCheck("user");
    }

    public static boolean isIsv() {
        return clientCheck("isv");
    }

    public static boolean isSrv() {
        return clientCheck("srv");
    }

    public static boolean isSystem() {
        return clientCheck("system");
    }

    public static boolean clientCheck(String type) {
        return type.equalsIgnoreCase(get().roleType);
    }


    /**
     * 获取当前线程中存储的登陆信息
     */
    private static RequestDto get() {
        RequestDto httpRequestDto = LOCAL.get();
        if (null == httpRequestDto) {
            httpRequestDto = new RequestDto();
            LOCAL.set(httpRequestDto);
        }
        return httpRequestDto;
    }

    private static class RequestDto {
        /**
         * 请求用户ID
         */
        private String roleId;
        /**
         * 接口请求类型
         * system
         * admin
         * isv
         * srv
         * user
         */
        private String roleType;

        /**
         * 商家ID
         */
        private String shopId;

        /**
         * 请求客户端
         */
        private String userAgent;

        /**
         * ip
         */
        private String ip;

        /**
         * 灰度版本
         */
        private String grayVersion;

        private void init(Metadata metadata) {
            this.ip = metadata.get(Metadata.Key.of("x-forwarded-host", Metadata.ASCII_STRING_MARSHALLER));
            this.userAgent = metadata.get(Metadata.Key.of("grpcgateway-user-agent", Metadata.ASCII_STRING_MARSHALLER));
            this.roleId = metadata.get(Metadata.Key.of("roleid", Metadata.ASCII_STRING_MARSHALLER));
            this.roleType = metadata.get(Metadata.Key.of("roletype", Metadata.ASCII_STRING_MARSHALLER));
            this.shopId = metadata.get(Metadata.Key.of("shopid", Metadata.ASCII_STRING_MARSHALLER));
            this.shopId = metadata.get(Metadata.Key.of("shopid", Metadata.ASCII_STRING_MARSHALLER));
            this.grayVersion = metadata.get(Metadata.Key.of("grayVersion", Metadata.ASCII_STRING_MARSHALLER));
        }
    }

}

package com.zufe.yt.gateway.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import lombok.SneakyThrows;

/**
 * pb转对象
 *
 * @author 秋玖壹
 **/
public class ProtoBeanUtil {

    @SneakyThrows
    public static <T> T toBean(Message message, Class<T> tClass) {
        if (message == null) {
            throw new IllegalArgumentException("No source message specified");
        }

        String json = JsonFormat.printer().includingDefaultValueFields().print(message);

        int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask();

        return JSON.parseObject(json, tClass, disableDecimalFeature);
    }

    @SneakyThrows
    public static <T extends Message.Builder> T toMessage(Object object, T target) {
        if (object == null) {
            throw new IllegalArgumentException("No source message specified");
        }

        int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask();
        String json = JSON.toJSONString(object, disableDecimalFeature);
        JsonFormat.parser().ignoringUnknownFields().merge(json, target);

        return target;
    }
}
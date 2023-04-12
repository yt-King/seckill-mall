package com.zufe.yt.common.core.util;

import java.util.*;

/**
 * @author chengsiyi
 * @date 2022/6/14 17:06
 */
public class SignUtil {

    public static String sign(Map<String, String> paramValues, String secret) {
        return sign(paramValues, (List)null, secret);
    }

    public static String sign(Map<String, String> paramValues, List<String> ignoreParamNames, String secret) {
        StringBuilder sb = new StringBuilder();
        List<String> paramNames = new ArrayList(paramValues.size());
        paramNames.addAll(paramValues.keySet());
        Iterator var5;
        String paramName;
        if (ignoreParamNames != null && !ignoreParamNames.isEmpty()) {
            var5 = ignoreParamNames.iterator();

            while(var5.hasNext()) {
                paramName = (String)var5.next();
                paramNames.remove(paramName);
            }
        }

        Collections.sort(paramNames);
        sb.append(secret);
        var5 = paramNames.iterator();

        while(var5.hasNext()) {
            paramName = (String)var5.next();
            sb.append(paramName).append((String)paramValues.get(paramName));
        }

        sb.append(secret);
        return SecurityUtils.encode2StringBySHA(sb.toString()).toLowerCase();
    }
}

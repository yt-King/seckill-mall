package com.zufe.yt.common.mongo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 转换字符串
 *
 * @author 秋玖壹
 */
public class FormatUtils {
    public static final Pattern REGEX = Pattern.compile("\\$\\{([^}]*)}");

    public static String bson(String json) {
        json = transString(json);
        String blank = "    ";
        // 缩进
        String indent = "";
        StringBuilder sb = new StringBuilder();

        for (char c : json.toCharArray()) {
            switch (c) {
                case '{':
                    indent += blank;
                    sb.append("{\n").append(indent);
                    break;
                case '}':
                    indent = indent.substring(0, indent.length() - blank.length());
                    sb.append("\n").append(indent).append("}");
                    break;
                case '[':
                    indent += blank;
                    sb.append("[\n").append(indent);
                    break;
                case ']':
                    indent = indent.substring(0, indent.length() - blank.length());
                    sb.append("\n").append(indent).append("]");
                    break;
                case ',':
                    sb.append(",\n").append(indent);
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 转换$oid为ObjectId()
     *
     * @param str
     * @return
     */
    private static String transString(String str) {
        str = str.replace(", ", ",").replace("{\"$oid\":", "${");

        List<String> temp = getContentInfo(str);
        for (String tp : temp) {
            str = str.replace("${" + tp + "}", "ObjectId(" + tp.trim() + ")");
        }

        return str;
    }

    /**
     * 获取表达式中${}中的值
     *
     * @param content
     * @return
     */
    private static List<String> getContentInfo(String content) {
        Matcher matcher = REGEX.matcher(content);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(1));
        }

        return list;
    }
}

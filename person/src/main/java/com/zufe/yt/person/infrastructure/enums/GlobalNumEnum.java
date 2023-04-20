package com.zufe.yt.person.infrastructure.enums;

/**
 * @author yt
 * @date 2023/4/20
 */
public enum GlobalNumEnum {
    /**
     * 用户名最低长度
     */
    USER_NAME_LENGTH(6),
    /**
     * 密码最低长度
     */
    PASSWORD_LENGTH(6);
    private final int num;

    GlobalNumEnum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

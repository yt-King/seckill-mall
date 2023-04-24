package com.zufe.yt.goods.infrastructure.enums;

/**
 * @author yt
 * @date 2023/4/24
 */
public enum PageEnum {
    /**
     * 页面大小
     */
    PAGE_SIZE(15),
    /**
     * 当前页
     */
    CURRENT_PAGE(1);
    private final Integer num;

    PageEnum(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }
}

package com.zufe.yt.goods.infrastructure.enums;

/**
 * @author yt
 * @date 2023/4/23
 */
public enum CategoryEnum {
    /**
     * 手机
     */
    PHONE(1, "手机"),
    /**
     * 电视机
     */
    TV(2, "电视机"),
    /**
     * 空调
     */
    AIR(3, "空调"),
    /**
     * 洗衣机
     */
    WASH(4, "洗衣机"),
    /**
     * 保护套
     */
    SLEEVE(5, "保护套"),
    /**
     * 保护膜
     */
    SHELL(6, "保护膜"),
    /**
     * 充电器
     */
    CHARGER(7, "充电器"),
    /**
     * 充电宝
     */
    POWER_BANK(8, "充电宝");

    private final Integer categoryId;
    private final String categoryName;

    CategoryEnum(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}

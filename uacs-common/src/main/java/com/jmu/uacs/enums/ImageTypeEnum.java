package com.jmu.uacs.enums;

public enum ImageTypeEnum {

    USER_AVATAR("用户头像", "USER_AVATAR"),
    USER_ID_PHOTO("证件照", "USER_ID_PHOTO"),
    USER_PHOTO_ALBUM("用户相册", "USER_PHOTO_ALBUM"),
    ASSOCIATION_HOMEPAGE("社团首页", "ASSOCIATION_HOMEPAGE"),
    ASSOCIATION_PHOTO_ALBUM("社团相册", "ASSOCIATION_PHOTO_ALBUM");

    private String label;
    private String value;


    ImageTypeEnum(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static ImageTypeEnum getEnumByValue(String value) {
        for (ImageTypeEnum enums : ImageTypeEnum.values()) {
            if (enums.getValue().equals(value)) {
                return enums;
            }
        }
        return null;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}

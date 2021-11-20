package com.jmu.uacs.enums;

public enum GenderEnum {

    MALE("男"),
    FEMALE("女"),
    UNKNOWN("UNKNOWN");

    private String value;

    GenderEnum(String value) {
        this.value = value;
    }


    public static String getGender(String genderName) {
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.getValue().equals(genderName)) {
                return gender.getValue();
            }
        }
        return GenderEnum.UNKNOWN.getValue();
    }

    public String getValue() {
        return value;
    }
}

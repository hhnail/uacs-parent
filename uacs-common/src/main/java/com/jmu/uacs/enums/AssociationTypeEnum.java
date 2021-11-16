package com.jmu.uacs.enums;

public enum AssociationTypeEnum {
//1.以学术研究为宗旨的学术性社团;
//2.以调剂身心为主的康乐性社团;
//3.以陶冶身心、培养气质为目的的文艺性社团;
//4.锻炼体力与运动技巧的体能性社团;
    ACADEMIC("学术性社团", "ACADEMIC"),
    RECREATIONAL("康乐性社团", "RECREATIONAL"),
    ARTISTIC("艺术性社团", "ARTISTIC"),
    PHYSICAL("体能性社团", "PHYSICAL");

    private String label;
    private String value;


    AssociationTypeEnum(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static AssociationTypeEnum getEnumByValue(String value) {
        for (AssociationTypeEnum enums : AssociationTypeEnum.values()) {
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

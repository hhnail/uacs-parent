package com.jmu.uacs.association.bean;

import lombok.Data;

@Data
public class CascaderClass {

    private String college;

    private String major;

    private String className;

    @Override
    public String toString() {
        return this.college + "/" + this.major + "/" + this.className;
    }
}

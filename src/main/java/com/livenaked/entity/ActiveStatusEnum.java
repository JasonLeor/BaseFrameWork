package com.livenaked.entity;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ActiveStatusEnum {
    DISABLED(0), ENABLED(1);
    private int value;

    ActiveStatusEnum(int value) {
        this.value = value;
    }

    public static ActiveStatusEnum getByValue(int value) {
        return Arrays.stream(ActiveStatusEnum.values()).filter(it -> it.getValue() == value).findAny().orElse(null);
    }

}

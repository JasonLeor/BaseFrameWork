package com.livenaked.entity;

import lombok.Getter;

import java.util.Arrays;

/**
 * 功能状态
 */
@Getter
public enum FunctionStatusEnum {
    DISABLED(0), ENABLED(1), MAINTAINED(2);
    private int value;

    FunctionStatusEnum(int value) {
        this.value = value;
    }

    public static FunctionStatusEnum getByValue(int value) {
        return Arrays.stream(FunctionStatusEnum.values()).filter(it -> it.getValue() == value).findAny().orElse(null);
    }
}

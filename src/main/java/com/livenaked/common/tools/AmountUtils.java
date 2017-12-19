package com.livenaked.common.tools;

import java.math.BigDecimal;

/**
 * 金额 工具类
 */
public class AmountUtils {
    // 默认保留小数位
    public static final int BIGDECIMAL_FORMAT_SCALE_LENGTH = 2;
    public static final int BIGDECIMAL_FORMAT_ROUNDING_MODE = BigDecimal.ROUND_DOWN;

    /**
     * 格式化精度
     */
    public static BigDecimal formatBigDecimal(BigDecimal decimal) {
        if (decimal == null) {
            return BigDecimal.ZERO;
        }
        return decimal.setScale(BIGDECIMAL_FORMAT_SCALE_LENGTH, BIGDECIMAL_FORMAT_ROUNDING_MODE);
    }

    /**
     * 格式化精度
     */
    public static BigDecimal formatBigDecimal(String string) {
        if (string == null || string.equals("")) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(string).setScale(BIGDECIMAL_FORMAT_SCALE_LENGTH, BIGDECIMAL_FORMAT_ROUNDING_MODE);
    }

    /**
     * 格式化精度
     */
    public static BigDecimal formatBigDecimal(Integer inte) {
        if (inte == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(inte).setScale(BIGDECIMAL_FORMAT_SCALE_LENGTH, BIGDECIMAL_FORMAT_ROUNDING_MODE);
    }

    /**
     * 格式化精度
     */
    public static BigDecimal formatBigDecimal(Long lon) {
        if (lon == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(lon).setScale(BIGDECIMAL_FORMAT_SCALE_LENGTH, BIGDECIMAL_FORMAT_ROUNDING_MODE);
    }

    /**
     * 格式化精度
     */
    public static BigDecimal formatBigDecimal(Double dou) {
        if (dou == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(dou).setScale(BIGDECIMAL_FORMAT_SCALE_LENGTH, BIGDECIMAL_FORMAT_ROUNDING_MODE);
    }

    /**
     * 格式化精度
     */
    public static BigDecimal formatBigDecimal(Float floa) {
        if (floa == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(floa).setScale(BIGDECIMAL_FORMAT_SCALE_LENGTH, BIGDECIMAL_FORMAT_ROUNDING_MODE);
    }
}

package com.livenaked.common.tools;

/**
 * 环境工具
 */
public class EnvUtils {
    public static ENVIRONMENT CURRENT_ENVIRONMENT;
    private static final String ENVIRONMENT_KEY = "application.environment";

    static {
        String value = System.getProperty(ENVIRONMENT_KEY);
        value = value == null ? "" : value;
        switch (value) {
            case "production"://生产环境
                CURRENT_ENVIRONMENT = ENVIRONMENT.PRODUCTION;
                break;
            case "dev"://测试环境
                CURRENT_ENVIRONMENT = ENVIRONMENT.DEVELOPMENT;
                break;
            default:// 其他都是开发环境
                CURRENT_ENVIRONMENT = ENVIRONMENT.TEST;
                break;
        }
        System.out.println(String.format("当前环境为:[%s]", CURRENT_ENVIRONMENT));
    }

    public enum ENVIRONMENT {
        PRODUCTION, DEVELOPMENT, TEST
    }
}

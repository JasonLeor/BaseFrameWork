package com.livenaked.common.tools;

public class Environment {
    private static final String ENV_PARAM = "spring.profiles.active";
    private static final String ENV_PRODUCTION = "production";
    private static final String ENV_DEVELOPMENT = "development";
    private static final String ENV_TEST = "test";
    private static final String ENV = System.getProperty(ENV_PARAM);

    public static boolean isProductionEnv() {
        return ENV_PRODUCTION.equals(ENV);
    }

    public static boolean isDevelopmentEnv() {
        return ENV_DEVELOPMENT.equals(ENV);
    }

    public static boolean isTestEnv() {
        return ENV_TEST.equals(ENV);
    }

    public static boolean isLocalEnv() {
        return ENV == null || ENV.isEmpty();
    }
}

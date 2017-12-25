import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.LevelFilter
import ch.qos.logback.core.spi.FilterReply
import com.livenaked.common.Constants
import com.livenaked.common.tools.EnvUtils

def PROD_LOG_HOME = "/data/logs/frameWork"
def DEV_LOG_HOME = "/data/logs/frameWork"
def LOCAL_LOG_HOME = "/Users/${System.getProperty("user.name")}/Desktop/logs/frameWork"

appender('CONSOLE_STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
    filter(LevelFilter) {
        level = DEBUG
        onMatch = FilterReply.ACCEPT
        onMismatch = FilterReply.DENY
    }
}

// 错误日志
appender('ERROR_FILE', RollingFileAppender) {
    rollingPolicy(TimeBasedRollingPolicy) {
        if (EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.PRODUCTION)) {
            fileNamePattern = PROD_LOG_HOME + "/error/error.logFile.%d{yyyy-MM-dd}.log.gz"
        } else if (EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.DEVELOPMENT)) {
            fileNamePattern = DEV_LOG_HOME + "/error/dev.error.logFile.%d{yyyy-MM-dd}.log.gz"
        } else if (EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.TEST)) {
            fileNamePattern = LOCAL_LOG_HOME + "/error/error.frameWork.%d{yyyy-MM-dd}.log"
        }
        maxHistory = 7
    }
    filter(LevelFilter) {
        level = ERROR
        onMatch = FilterReply.ACCEPT
        onMismatch = FilterReply.DENY
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} %X{${Constants.LOG_TRACE_PK_KEY}} - %msg%n"
    }
}
appender('INFO_FILE', RollingFileAppender) {
    rollingPolicy(TimeBasedRollingPolicy) {
        if (EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.PRODUCTION)) {
            fileNamePattern = PROD_LOG_HOME + "/info/info.logFile.%d{yyyy-MM-dd}.log.gz"
        } else if (EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.DEVELOPMENT)) {
            fileNamePattern = DEV_LOG_HOME + "/info/dev.info.logFile.%d{yyyy-MM-dd}.log.gz"
        } else if (EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.TEST)) {
            fileNamePattern = LOCAL_LOG_HOME + "/info/info.frameWork.%d{yyyy-MM-dd}.log"
        }
        maxHistory = 7
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} %X{${Constants.LOG_TRACE_PK_KEY}} - %msg%n"
    }
}

root(INFO, ['ERROR_FILE'])

//测试环境 打印 debug
if (EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.TEST)) {
    root(INFO, ['CONSOLE_STDOUT'])
}
root(INFO, ['INFO_FILE'])

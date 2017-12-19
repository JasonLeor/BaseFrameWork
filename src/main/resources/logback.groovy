import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import com.livenaked.common.tools.Environment
import net.logstash.logback.encoder.LogstashEncoder

appender('FILE', RollingFileAppender) {
    def location = "/"

    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = location + "logFile.%d{yyyy-MM-dd}.log.gz"
        if (Environment.isLocalEnv()) {
            fileNamePattern = "/Users/${System.getProperty("user.name")}/Desktop/log/xx/logFile.%d{yyyy-MM-dd}.log.gz"
        } else if (Environment.isDevelopmentEnv()) {
            fileNamePattern = location + "logFile.dev.%d{yyyy-MM-dd}.log.gz"
        } else if (Environment.isTestEnv()) {
            fileNamePattern = location + "logFile.test.%d{yyyy-MM-dd}.log.gz"
        }
        maxHistory = 7
    }

    encoder(LogstashEncoder) {
        includeMdcKeyNames = ["requestId"]
    }

    if (Environment.isLocalEnv()) {
        encoder(PatternLayoutEncoder) {
            pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} %relative [%thread] %-5level %logger{36} %X{requestId} - %msg%n"
        }
    }
}

root(INFO, ['FILE'])

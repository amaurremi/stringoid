package twitter4j.internal.logging;

import org.apache.log4j.Level;

final class Log4JLogger
        extends Logger {
    private final org.apache.log4j.Logger LOGGER;

    Log4JLogger(org.apache.log4j.Logger paramLogger) {
        this.LOGGER = paramLogger;
    }

    public void debug(String paramString) {
        this.LOGGER.debug(paramString);
    }

    public void debug(String paramString1, String paramString2) {
        debug(paramString1 + paramString2);
    }

    public void error(String paramString) {
        this.LOGGER.error(paramString);
    }

    public void error(String paramString, Throwable paramThrowable) {
        this.LOGGER.error(paramString, paramThrowable);
    }

    public void info(String paramString) {
        this.LOGGER.info(paramString);
    }

    public void info(String paramString1, String paramString2) {
        info(paramString1 + paramString2);
    }

    public boolean isDebugEnabled() {
        return this.LOGGER.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return this.LOGGER.isEnabledFor(Level.WARN);
    }

    public boolean isInfoEnabled() {
        return this.LOGGER.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return this.LOGGER.isEnabledFor(Level.WARN);
    }

    public void warn(String paramString) {
        this.LOGGER.warn(paramString);
    }

    public void warn(String paramString1, String paramString2) {
        warn(paramString1 + paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/logging/Log4JLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
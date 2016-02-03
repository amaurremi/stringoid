package twitter4j.internal.logging;

import java.util.logging.Level;

final class JULLogger
        extends Logger {
    private final java.util.logging.Logger LOGGER;

    JULLogger(java.util.logging.Logger paramLogger) {
        this.LOGGER = paramLogger;
    }

    public void debug(String paramString) {
        this.LOGGER.fine(paramString);
    }

    public void debug(String paramString1, String paramString2) {
        this.LOGGER.fine(paramString1 + paramString2);
    }

    public void error(String paramString) {
        this.LOGGER.severe(paramString);
    }

    public void error(String paramString, Throwable paramThrowable) {
        this.LOGGER.severe(paramString + paramThrowable.getMessage());
    }

    public void info(String paramString) {
        this.LOGGER.info(paramString);
    }

    public void info(String paramString1, String paramString2) {
        this.LOGGER.info(paramString1 + paramString2);
    }

    public boolean isDebugEnabled() {
        return this.LOGGER.isLoggable(Level.FINE);
    }

    public boolean isErrorEnabled() {
        return this.LOGGER.isLoggable(Level.SEVERE);
    }

    public boolean isInfoEnabled() {
        return this.LOGGER.isLoggable(Level.INFO);
    }

    public boolean isWarnEnabled() {
        return this.LOGGER.isLoggable(Level.WARNING);
    }

    public void warn(String paramString) {
        this.LOGGER.warning(paramString);
    }

    public void warn(String paramString1, String paramString2) {
        this.LOGGER.warning(paramString1 + paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/logging/JULLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
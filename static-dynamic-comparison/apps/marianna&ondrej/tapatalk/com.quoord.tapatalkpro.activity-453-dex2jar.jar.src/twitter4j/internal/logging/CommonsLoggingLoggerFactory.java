package twitter4j.internal.logging;

import org.apache.commons.logging.LogFactory;

final class CommonsLoggingLoggerFactory
        extends LoggerFactory {
    public Logger getLogger(Class paramClass) {
        return new CommonsLoggingLogger(LogFactory.getLog(paramClass));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/logging/CommonsLoggingLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
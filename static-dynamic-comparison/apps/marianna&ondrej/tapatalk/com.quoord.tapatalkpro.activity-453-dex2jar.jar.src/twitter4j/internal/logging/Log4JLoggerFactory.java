package twitter4j.internal.logging;

final class Log4JLoggerFactory
        extends LoggerFactory {
    public Logger getLogger(Class paramClass) {
        return new Log4JLogger(org.apache.log4j.Logger.getLogger(paramClass));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/logging/Log4JLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
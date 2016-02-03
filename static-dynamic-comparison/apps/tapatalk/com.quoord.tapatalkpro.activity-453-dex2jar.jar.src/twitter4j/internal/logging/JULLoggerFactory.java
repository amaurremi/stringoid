package twitter4j.internal.logging;

final class JULLoggerFactory
        extends LoggerFactory {
    public Logger getLogger(Class paramClass) {
        return new JULLogger(java.util.logging.Logger.getLogger(paramClass.getName()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/logging/JULLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
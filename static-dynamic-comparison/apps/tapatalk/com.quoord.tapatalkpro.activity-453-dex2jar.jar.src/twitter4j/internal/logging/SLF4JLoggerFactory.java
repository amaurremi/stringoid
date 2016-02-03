package twitter4j.internal.logging;

final class SLF4JLoggerFactory
        extends LoggerFactory {
    public Logger getLogger(Class paramClass) {
        return new SLF4JLogger(org.slf4j.LoggerFactory.getLogger(paramClass));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/logging/SLF4JLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
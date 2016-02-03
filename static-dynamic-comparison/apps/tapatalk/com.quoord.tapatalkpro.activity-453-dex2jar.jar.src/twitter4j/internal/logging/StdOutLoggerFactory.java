package twitter4j.internal.logging;

final class StdOutLoggerFactory
        extends LoggerFactory {
    private static final Logger SINGLETON = new StdOutLogger();

    public Logger getLogger(Class paramClass) {
        return SINGLETON;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/logging/StdOutLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
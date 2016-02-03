package twitter4j;

final class NullLoggerFactory
        extends LoggerFactory {
    private static final Logger SINGLETON = new NullLogger();

    public Logger getLogger(Class paramClass) {
        return SINGLETON;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/NullLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
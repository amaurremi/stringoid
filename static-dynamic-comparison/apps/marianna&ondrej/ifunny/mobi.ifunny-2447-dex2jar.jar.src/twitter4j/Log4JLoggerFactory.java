package twitter4j;

final class Log4JLoggerFactory
        extends LoggerFactory {
    public Logger getLogger(Class paramClass) {
        return new Log4JLogger(org.apache.log4j.Logger.getLogger(paramClass));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/Log4JLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
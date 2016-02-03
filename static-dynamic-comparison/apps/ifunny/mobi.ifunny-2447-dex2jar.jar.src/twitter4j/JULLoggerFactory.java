package twitter4j;

final class JULLoggerFactory
        extends LoggerFactory {
    public Logger getLogger(Class paramClass) {
        return new JULLogger(java.util.logging.Logger.getLogger(paramClass.getName()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/JULLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
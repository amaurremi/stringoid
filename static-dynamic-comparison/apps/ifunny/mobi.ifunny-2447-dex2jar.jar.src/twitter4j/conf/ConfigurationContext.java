package twitter4j.conf;

public final class ConfigurationContext {
    private static final String CONFIGURATION_IMPL = "twitter4j.configurationFactory";
    private static final String DEFAULT_CONFIGURATION_FACTORY = "twitter4j.conf.PropertyConfigurationFactory";
    private static final ConfigurationFactory factory;

    static {
        try {
            str1 = System.getProperty("twitter4j.configurationFactory", "twitter4j.conf.PropertyConfigurationFactory");
        } catch (SecurityException localSecurityException) {
            for (; ; ) {
                try {
                    String str1;
                    factory = (ConfigurationFactory) Class.forName(str1).newInstance();
                    return;
                } catch (ClassNotFoundException localClassNotFoundException) {
                    String str2;
                    throw new AssertionError(localClassNotFoundException);
                } catch (InstantiationException localInstantiationException) {
                    throw new AssertionError(localInstantiationException);
                } catch (IllegalAccessException localIllegalAccessException) {
                    throw new AssertionError(localIllegalAccessException);
                }
                localSecurityException = localSecurityException;
                str2 = "twitter4j.conf.PropertyConfigurationFactory";
            }
        }
    }

    public static Configuration getInstance() {
        return factory.getInstance();
    }

    public static Configuration getInstance(String paramString) {
        return factory.getInstance(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/conf/ConfigurationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
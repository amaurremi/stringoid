package twitter4j.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import twitter4j.internal.util.z_T4JInternalStringUtil;

public final class PropertyConfiguration
        extends ConfigurationBase
        implements Serializable {
    public static final String APPLICATION_ONLY_AUTH_ENABLED = "enableApplicationOnlyAuth";
    public static final String ASYNC_DISPATCHER_IMPL = "async.dispatcherImpl";
    public static final String ASYNC_NUM_THREADS = "async.numThreads";
    public static final String CLIENT_URL = "clientURL";
    public static final String CLIENT_VERSION = "clientVersion";
    public static final String CONTRIBUTING_TO = "contributingTo";
    public static final String DEBUG = "debug";
    public static final String HTTP_CONNECTION_TIMEOUT = "http.connectionTimeout";
    public static final String HTTP_DEFAULT_MAX_PER_ROUTE = "http.defaultMaxPerRoute";
    public static final String HTTP_GZIP = "http.gzip";
    public static final String HTTP_MAX_TOTAL_CONNECTIONS = "http.maxTotalConnections";
    public static final String HTTP_PRETTY_DEBUG = "http.prettyDebug";
    public static final String HTTP_PROXY_HOST = "http.proxyHost";
    public static final String HTTP_PROXY_HOST_FALLBACK = "http.proxyHost";
    public static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";
    public static final String HTTP_PROXY_PORT = "http.proxyPort";
    public static final String HTTP_PROXY_PORT_FALLBACK = "http.proxyPort";
    public static final String HTTP_PROXY_USER = "http.proxyUser";
    public static final String HTTP_READ_TIMEOUT = "http.readTimeout";
    public static final String HTTP_RETRY_COUNT = "http.retryCount";
    public static final String HTTP_RETRY_INTERVAL_SECS = "http.retryIntervalSecs";
    public static final String HTTP_STREAMING_READ_TIMEOUT = "http.streamingReadTimeout";
    public static final String HTTP_USER_AGENT = "http.userAgent";
    public static final String HTTP_USE_SSL = "http.useSSL";
    public static final String INCLUDE_ENTITIES = "includeEntities";
    public static final String INCLUDE_MY_RETWEET = "includeMyRetweet";
    public static final String INCLUDE_RTS = "includeRTs";
    public static final String JSON_STORE_ENABLED = "jsonStoreEnabled";
    public static final String LOGGER_FACTORY = "loggerFactory";
    public static final String MBEAN_ENABLED = "mbeanEnabled";
    public static final String MEDIA_PROVIDER = "media.provider";
    public static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
    public static final String MEDIA_PROVIDER_PARAMETERS = "media.providerParameters";
    public static final String OAUTH2_ACCESS_TOKEN = "oauth2.accessToken";
    public static final String OAUTH2_INVALIDATE_TOKEN_URL = "oauth2.invalidateTokenURL";
    public static final String OAUTH2_TOKEN_TYPE = "oauth2.tokenType";
    public static final String OAUTH2_TOKEN_URL = "oauth2.tokenURL";
    public static final String OAUTH_ACCESS_TOKEN = "oauth.accessToken";
    public static final String OAUTH_ACCESS_TOKEN_SECRET = "oauth.accessTokenSecret";
    public static final String OAUTH_ACCESS_TOKEN_URL = "oauth.accessTokenURL";
    public static final String OAUTH_AUTHENTICATION_URL = "oauth.authenticationURL";
    public static final String OAUTH_AUTHORIZATION_URL = "oauth.authorizationURL";
    public static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
    public static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";
    public static final String OAUTH_REQUEST_TOKEN_URL = "oauth.requestTokenURL";
    public static final String PASSWORD = "password";
    public static final String REST_BASE_URL = "restBaseURL";
    public static final String SITE_STREAM_BASE_URL = "siteStreamBaseURL";
    public static final String STREAM_BASE_URL = "streamBaseURL";
    public static final String STREAM_STALL_WARNINGS_ENABLED = "stream.enableStallWarnings";
    public static final String STREAM_USER_REPLIES_ALL = "stream.user.repliesAll";
    public static final String USER = "user";
    public static final String USER_STREAM_BASE_URL = "userStreamBaseURL";
    private static final long serialVersionUID = 6458764415636588373L;

    PropertyConfiguration() {
        this("/");
    }

    public PropertyConfiguration(InputStream paramInputStream) {
        Properties localProperties = new Properties();
        loadProperties(localProperties, paramInputStream);
        setFieldsWithTreePath(localProperties, "/");
    }

    PropertyConfiguration(String paramString) {
        try {
            localProperties1 = (Properties) System.getProperties().clone();
            try {
                Map localMap = System.getenv();
                Iterator localIterator = localMap.keySet().iterator();
                while (localIterator.hasNext()) {
                    String str = (String) localIterator.next();
                    localProperties1.setProperty(str, (String) localMap.get(str));
                }
                loadProperties(localProperties1, "." + File.separatorChar + "twitter4j.properties");
            } catch (SecurityException localSecurityException2) {
                normalize(localProperties1);
            }
        } catch (SecurityException localSecurityException1) {
            try {
                Properties localProperties1;
                loadProperties(localProperties1, new FileInputStream("WEB-INF/twitter4j.properties"));
                setFieldsWithTreePath(localProperties1, paramString);
                return;
                localSecurityException1 = localSecurityException1;
                Properties localProperties2 = new Properties();
            } catch (FileNotFoundException localFileNotFoundException) {
                for (; ; ) {
                }
            } catch (SecurityException localSecurityException3) {
                for (; ; ) {
                }
            }
        }
        loadProperties(localProperties1, Configuration.class.getResourceAsStream("/twitter4j.properties"));
        loadProperties(localProperties1, Configuration.class.getResourceAsStream("/WEB-INF/twitter4j.properties"));
    }

    public PropertyConfiguration(Properties paramProperties) {
        this(paramProperties, "/");
    }

    public PropertyConfiguration(Properties paramProperties, String paramString) {
        setFieldsWithTreePath(paramProperties, paramString);
    }

    private boolean loadProperties(Properties paramProperties, InputStream paramInputStream) {
        try {
            paramProperties.load(paramInputStream);
            normalize(paramProperties);
            return true;
        } catch (Exception paramProperties) {
        }
        return false;
    }

    /* Error */
    private boolean loadProperties(Properties paramProperties, String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aconst_null
        //   3: astore 4
        //   5: new 252	java/io/File
        //   8: dup
        //   9: aload_2
        //   10: invokespecial 295	java/io/File:<init>	(Ljava/lang/String;)V
        //   13: astore_2
        //   14: aload_2
        //   15: invokevirtual 298	java/io/File:exists	()Z
        //   18: ifeq +39 -> 57
        //   21: aload_2
        //   22: invokevirtual 301	java/io/File:isFile	()Z
        //   25: ifeq +32 -> 57
        //   28: new 282	java/io/FileInputStream
        //   31: dup
        //   32: aload_2
        //   33: invokespecial 304	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   36: astore_2
        //   37: aload_1
        //   38: aload_2
        //   39: invokevirtual 292	java/util/Properties:load	(Ljava/io/InputStream;)V
        //   42: aload_0
        //   43: aload_1
        //   44: invokespecial 241	twitter4j/conf/PropertyConfiguration:normalize	(Ljava/util/Properties;)V
        //   47: aload_2
        //   48: ifnull +7 -> 55
        //   51: aload_2
        //   52: invokevirtual 307	java/io/FileInputStream:close	()V
        //   55: iconst_1
        //   56: ireturn
        //   57: iconst_0
        //   58: ifeq +11 -> 69
        //   61: new 309	java/lang/NullPointerException
        //   64: dup
        //   65: invokespecial 310	java/lang/NullPointerException:<init>	()V
        //   68: athrow
        //   69: iconst_0
        //   70: ireturn
        //   71: astore_1
        //   72: aload 4
        //   74: astore_2
        //   75: aload_2
        //   76: ifnull -7 -> 69
        //   79: aload_2
        //   80: invokevirtual 307	java/io/FileInputStream:close	()V
        //   83: goto -14 -> 69
        //   86: astore_1
        //   87: goto -18 -> 69
        //   90: astore_1
        //   91: aload_3
        //   92: astore_2
        //   93: aload_2
        //   94: ifnull +7 -> 101
        //   97: aload_2
        //   98: invokevirtual 307	java/io/FileInputStream:close	()V
        //   101: aload_1
        //   102: athrow
        //   103: astore_1
        //   104: goto -49 -> 55
        //   107: astore_1
        //   108: goto -39 -> 69
        //   111: astore_2
        //   112: goto -11 -> 101
        //   115: astore_1
        //   116: goto -23 -> 93
        //   119: astore_1
        //   120: goto -45 -> 75
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	123	0	this	PropertyConfiguration
        //   0	123	1	paramProperties	Properties
        //   0	123	2	paramString	String
        //   1	91	3	localObject1	Object
        //   3	70	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   5	37	71	java/lang/Exception
        //   79	83	86	java/io/IOException
        //   5	37	90	finally
        //   51	55	103	java/io/IOException
        //   61	69	107	java/io/IOException
        //   97	101	111	java/io/IOException
        //   37	47	115	finally
        //   37	47	119	java/lang/Exception
    }

    private void normalize(Properties paramProperties) {
        Object localObject2 = paramProperties.keySet();
        Object localObject1 = new ArrayList(10);
        localObject2 = ((Set) localObject2).iterator();
        String str;
        while (((Iterator) localObject2).hasNext()) {
            str = (String) ((Iterator) localObject2).next();
            if (-1 != str.indexOf("twitter4j.")) {
                ((ArrayList) localObject1).add(str);
            }
        }
        localObject1 = ((ArrayList) localObject1).iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (String) ((Iterator) localObject1).next();
            str = paramProperties.getProperty((String) localObject2);
            int i = ((String) localObject2).indexOf("twitter4j.");
            paramProperties.setProperty(((String) localObject2).substring(0, i) + ((String) localObject2).substring(i + 10), str);
        }
    }

    private boolean notNull(Properties paramProperties, String paramString1, String paramString2) {
        return paramProperties.getProperty(paramString1 + paramString2) != null;
    }

    private void setFieldsWithPrefix(Properties paramProperties, String paramString) {
        if (notNull(paramProperties, paramString, "debug")) {
            setDebug(getBoolean(paramProperties, paramString, "debug"));
        }
        if (notNull(paramProperties, paramString, "user")) {
            setUser(getString(paramProperties, paramString, "user"));
        }
        if (notNull(paramProperties, paramString, "password")) {
            setPassword(getString(paramProperties, paramString, "password"));
        }
        if (notNull(paramProperties, paramString, "http.useSSL")) {
            setUseSSL(getBoolean(paramProperties, paramString, "http.useSSL"));
        }
        if (notNull(paramProperties, paramString, "http.prettyDebug")) {
            setPrettyDebugEnabled(getBoolean(paramProperties, paramString, "http.prettyDebug"));
        }
        if (notNull(paramProperties, paramString, "http.gzip")) {
            setGZIPEnabled(getBoolean(paramProperties, paramString, "http.gzip"));
        }
        if (notNull(paramProperties, paramString, "http.proxyHost")) {
            setHttpProxyHost(getString(paramProperties, paramString, "http.proxyHost"));
            if (notNull(paramProperties, paramString, "http.proxyUser")) {
                setHttpProxyUser(getString(paramProperties, paramString, "http.proxyUser"));
            }
            if (notNull(paramProperties, paramString, "http.proxyPassword")) {
                setHttpProxyPassword(getString(paramProperties, paramString, "http.proxyPassword"));
            }
            if (!notNull(paramProperties, paramString, "http.proxyPort")) {
                break label1253;
            }
            setHttpProxyPort(getIntProperty(paramProperties, paramString, "http.proxyPort"));
        }
        for (; ; ) {
            if (notNull(paramProperties, paramString, "http.connectionTimeout")) {
                setHttpConnectionTimeout(getIntProperty(paramProperties, paramString, "http.connectionTimeout"));
            }
            if (notNull(paramProperties, paramString, "http.readTimeout")) {
                setHttpReadTimeout(getIntProperty(paramProperties, paramString, "http.readTimeout"));
            }
            if (notNull(paramProperties, paramString, "http.streamingReadTimeout")) {
                setHttpStreamingReadTimeout(getIntProperty(paramProperties, paramString, "http.streamingReadTimeout"));
            }
            if (notNull(paramProperties, paramString, "http.retryCount")) {
                setHttpRetryCount(getIntProperty(paramProperties, paramString, "http.retryCount"));
            }
            if (notNull(paramProperties, paramString, "http.retryIntervalSecs")) {
                setHttpRetryIntervalSeconds(getIntProperty(paramProperties, paramString, "http.retryIntervalSecs"));
            }
            if (notNull(paramProperties, paramString, "http.maxTotalConnections")) {
                setHttpMaxTotalConnections(getIntProperty(paramProperties, paramString, "http.maxTotalConnections"));
            }
            if (notNull(paramProperties, paramString, "http.defaultMaxPerRoute")) {
                setHttpDefaultMaxPerRoute(getIntProperty(paramProperties, paramString, "http.defaultMaxPerRoute"));
            }
            if (notNull(paramProperties, paramString, "oauth.consumerKey")) {
                setOAuthConsumerKey(getString(paramProperties, paramString, "oauth.consumerKey"));
            }
            if (notNull(paramProperties, paramString, "oauth.consumerSecret")) {
                setOAuthConsumerSecret(getString(paramProperties, paramString, "oauth.consumerSecret"));
            }
            if (notNull(paramProperties, paramString, "oauth.accessToken")) {
                setOAuthAccessToken(getString(paramProperties, paramString, "oauth.accessToken"));
            }
            if (notNull(paramProperties, paramString, "oauth.accessTokenSecret")) {
                setOAuthAccessTokenSecret(getString(paramProperties, paramString, "oauth.accessTokenSecret"));
            }
            if (notNull(paramProperties, paramString, "oauth2.tokenType")) {
                setOAuth2TokenType(getString(paramProperties, paramString, "oauth2.tokenType"));
            }
            if (notNull(paramProperties, paramString, "oauth2.accessToken")) {
                setOAuth2AccessToken(getString(paramProperties, paramString, "oauth2.accessToken"));
            }
            if (notNull(paramProperties, paramString, "async.numThreads")) {
                setAsyncNumThreads(getIntProperty(paramProperties, paramString, "async.numThreads"));
            }
            if (notNull(paramProperties, paramString, "contributingTo")) {
                setContributingTo(getLongProperty(paramProperties, paramString, "contributingTo"));
            }
            if (notNull(paramProperties, paramString, "async.dispatcherImpl")) {
                setDispatcherImpl(getString(paramProperties, paramString, "async.dispatcherImpl"));
            }
            if (notNull(paramProperties, paramString, "clientVersion")) {
                setClientVersion(getString(paramProperties, paramString, "clientVersion"));
            }
            if (notNull(paramProperties, paramString, "clientURL")) {
                setClientURL(getString(paramProperties, paramString, "clientURL"));
            }
            if (notNull(paramProperties, paramString, "http.userAgent")) {
                setUserAgent(getString(paramProperties, paramString, "http.userAgent"));
            }
            if (notNull(paramProperties, paramString, "oauth.requestTokenURL")) {
                setOAuthRequestTokenURL(getString(paramProperties, paramString, "oauth.requestTokenURL"));
            }
            if (notNull(paramProperties, paramString, "oauth.authorizationURL")) {
                setOAuthAuthorizationURL(getString(paramProperties, paramString, "oauth.authorizationURL"));
            }
            if (notNull(paramProperties, paramString, "oauth.accessTokenURL")) {
                setOAuthAccessTokenURL(getString(paramProperties, paramString, "oauth.accessTokenURL"));
            }
            if (notNull(paramProperties, paramString, "oauth.authenticationURL")) {
                setOAuthAuthenticationURL(getString(paramProperties, paramString, "oauth.authenticationURL"));
            }
            if (notNull(paramProperties, paramString, "oauth2.tokenURL")) {
                setOAuth2TokenURL(getString(paramProperties, paramString, "oauth2.tokenURL"));
            }
            if (notNull(paramProperties, paramString, "oauth2.invalidateTokenURL")) {
                setOAuth2InvalidateTokenURL(getString(paramProperties, paramString, "oauth2.invalidateTokenURL"));
            }
            if (notNull(paramProperties, paramString, "restBaseURL")) {
                setRestBaseURL(getString(paramProperties, paramString, "restBaseURL"));
            }
            if (notNull(paramProperties, paramString, "streamBaseURL")) {
                setStreamBaseURL(getString(paramProperties, paramString, "streamBaseURL"));
            }
            if (notNull(paramProperties, paramString, "userStreamBaseURL")) {
                setUserStreamBaseURL(getString(paramProperties, paramString, "userStreamBaseURL"));
            }
            if (notNull(paramProperties, paramString, "siteStreamBaseURL")) {
                setSiteStreamBaseURL(getString(paramProperties, paramString, "siteStreamBaseURL"));
            }
            if (notNull(paramProperties, paramString, "includeRTs")) {
                setIncludeRTsEnbled(getBoolean(paramProperties, paramString, "includeRTs"));
            }
            if (notNull(paramProperties, paramString, "includeEntities")) {
                setIncludeEntitiesEnbled(getBoolean(paramProperties, paramString, "includeEntities"));
            }
            if (notNull(paramProperties, paramString, "includeMyRetweet")) {
                setIncludeMyRetweetEnabled(getBoolean(paramProperties, paramString, "includeMyRetweet"));
            }
            if (notNull(paramProperties, paramString, "loggerFactory")) {
                setLoggerFactory(getString(paramProperties, paramString, "loggerFactory"));
            }
            if (notNull(paramProperties, paramString, "jsonStoreEnabled")) {
                setJSONStoreEnabled(getBoolean(paramProperties, paramString, "jsonStoreEnabled"));
            }
            if (notNull(paramProperties, paramString, "mbeanEnabled")) {
                setMBeanEnabled(getBoolean(paramProperties, paramString, "mbeanEnabled"));
            }
            if (notNull(paramProperties, paramString, "stream.user.repliesAll")) {
                setUserStreamRepliesAllEnabled(getBoolean(paramProperties, paramString, "stream.user.repliesAll"));
            }
            if (notNull(paramProperties, paramString, "stream.enableStallWarnings")) {
                setStallWarningsEnabled(getBoolean(paramProperties, paramString, "stream.enableStallWarnings"));
            }
            if (notNull(paramProperties, paramString, "enableApplicationOnlyAuth")) {
                setApplicationOnlyAuthEnabled(getBoolean(paramProperties, paramString, "enableApplicationOnlyAuth"));
            }
            if (notNull(paramProperties, paramString, "media.provider")) {
                setMediaProvider(getString(paramProperties, paramString, "media.provider"));
            }
            if (notNull(paramProperties, paramString, "media.providerAPIKey")) {
                setMediaProviderAPIKey(getString(paramProperties, paramString, "media.providerAPIKey"));
            }
            if (!notNull(paramProperties, paramString, "media.providerParameters")) {
                break label1284;
            }
            paramProperties = z_T4JInternalStringUtil.split(getString(paramProperties, paramString, "media.providerParameters"), "&");
            paramString = new Properties();
            int j = paramProperties.length;
            int i = 0;
            while (i < j) {
                String[] arrayOfString = z_T4JInternalStringUtil.split(paramProperties[i], "=");
                paramString.setProperty(arrayOfString[0], arrayOfString[1]);
                i += 1;
            }
            if (!notNull(paramProperties, paramString, "http.proxyHost")) {
                break;
            }
            setHttpProxyHost(getString(paramProperties, paramString, "http.proxyHost"));
            break;
            label1253:
            if (notNull(paramProperties, paramString, "http.proxyPort")) {
                setHttpProxyPort(getIntProperty(paramProperties, paramString, "http.proxyPort"));
            }
        }
        setMediaProviderParameters(paramString);
        label1284:
        cacheInstance();
    }

    private void setFieldsWithTreePath(Properties paramProperties, String paramString) {
        setFieldsWithPrefix(paramProperties, "");
        String[] arrayOfString = z_T4JInternalStringUtil.split(paramString, "/");
        paramString = null;
        int j = arrayOfString.length;
        int i = 0;
        if (i < j) {
            String str2 = arrayOfString[i];
            String str1 = paramString;
            if (!"".equals(str2)) {
                if (paramString != null) {
                    break label95;
                }
            }
            label95:
            for (paramString = str2 + "."; ; paramString = paramString + str2 + ".") {
                setFieldsWithPrefix(paramProperties, paramString);
                str1 = paramString;
                i += 1;
                paramString = str1;
                break;
            }
        }
    }

    protected boolean getBoolean(Properties paramProperties, String paramString1, String paramString2) {
        return Boolean.valueOf(paramProperties.getProperty(paramString1 + paramString2)).booleanValue();
    }

    protected int getIntProperty(Properties paramProperties, String paramString1, String paramString2) {
        paramProperties = paramProperties.getProperty(paramString1 + paramString2);
        try {
            int i = Integer.parseInt(paramProperties);
            return i;
        } catch (NumberFormatException paramProperties) {
        }
        return -1;
    }

    protected long getLongProperty(Properties paramProperties, String paramString1, String paramString2) {
        paramProperties = paramProperties.getProperty(paramString1 + paramString2);
        try {
            long l = Long.parseLong(paramProperties);
            return l;
        } catch (NumberFormatException paramProperties) {
        }
        return -1L;
    }

    protected String getString(Properties paramProperties, String paramString1, String paramString2) {
        return paramProperties.getProperty(paramString1 + paramString2);
    }

    protected Object readResolve()
            throws ObjectStreamException {
        return super.readResolve();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/conf/PropertyConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
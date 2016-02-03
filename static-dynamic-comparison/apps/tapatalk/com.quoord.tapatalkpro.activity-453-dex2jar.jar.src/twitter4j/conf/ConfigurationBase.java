package twitter4j.conf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import twitter4j.Version;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.util.z_T4JInternalStringUtil;

class ConfigurationBase
        implements Configuration, Serializable {
    public static final String DALVIK = "twitter4j.dalvik";
    private static final String DEFAULT_OAUTH2_INVALIDATE_TOKEN_URL = "https://api.twitter.com/oauth2/invalidate_token";
    private static final String DEFAULT_OAUTH2_TOKEN_URL = "https://api.twitter.com/oauth2/token";
    private static final String DEFAULT_OAUTH_ACCESS_TOKEN_URL = "http://api.twitter.com/oauth/access_token";
    private static final String DEFAULT_OAUTH_AUTHENTICATION_URL = "http://api.twitter.com/oauth/authenticate";
    private static final String DEFAULT_OAUTH_AUTHORIZATION_URL = "http://api.twitter.com/oauth/authorize";
    private static final String DEFAULT_OAUTH_REQUEST_TOKEN_URL = "http://api.twitter.com/oauth/request_token";
    private static final String DEFAULT_REST_BASE_URL = "http://api.twitter.com/1.1/";
    private static final String DEFAULT_SITE_STREAM_BASE_URL = "https://sitestream.twitter.com/1.1/";
    private static final String DEFAULT_STREAM_BASE_URL = "https://stream.twitter.com/1.1/";
    private static final String DEFAULT_USER_STREAM_BASE_URL = "https://userstream.twitter.com/1.1/";
    public static final String GAE = "twitter4j.gae";
    static String dalvikDetected;
    static String gaeDetected;
    private static final List<ConfigurationBase> instances;
    private static final long serialVersionUID = -6610497517837844232L;
    private boolean IS_DALVIK;
    private boolean IS_GAE;
    private boolean applicationOnlyAuthEnabled = false;
    private int asyncNumThreads;
    private String clientURL;
    private String clientVersion;
    private long contributingTo;
    private boolean debug;
    private int defaultMaxPerRoute;
    private String dispatcherImpl;
    private boolean gzipEnabled;
    private int httpConnectionTimeout;
    private String httpProxyHost;
    private String httpProxyPassword;
    private int httpProxyPort;
    private String httpProxyUser;
    private int httpReadTimeout;
    private int httpRetryCount;
    private int httpRetryIntervalSeconds;
    private int httpStreamingReadTimeout;
    private boolean includeEntitiesEnabled = true;
    private boolean includeMyRetweetEnabled = true;
    private boolean includeRTsEnabled = true;
    private boolean jsonStoreEnabled;
    private String loggerFactory;
    private int maxTotalConnections;
    private boolean mbeanEnabled;
    private String mediaProvider;
    private String mediaProviderAPIKey;
    private Properties mediaProviderParameters;
    private String oAuth2AccessToken;
    private String oAuth2InvalidateTokenURL;
    private String oAuth2TokenType;
    private String oAuth2TokenURL;
    private String oAuthAccessToken;
    private String oAuthAccessTokenSecret;
    private String oAuthAccessTokenURL;
    private String oAuthAuthenticationURL;
    private String oAuthAuthorizationURL;
    private String oAuthConsumerKey;
    private String oAuthConsumerSecret;
    private String oAuthRequestTokenURL;
    private String password;
    private boolean prettyDebug;
    Map<String, String> requestHeaders;
    private String restBaseURL;
    private String siteStreamBaseURL;
    private boolean stallWarningsEnabled;
    private String streamBaseURL;
    private boolean trimUserEnabled = false;
    private boolean useSSL;
    private String user;
    private String userAgent;
    private String userStreamBaseURL;
    private boolean userStreamRepliesAllEnabled;

    static {
        try {
            Class.forName("dalvik.system.VMRuntime");
            dalvikDetected = "true";
        } catch (ClassNotFoundException localClassNotFoundException1) {
            try {
                for (; ; ) {
                    Class.forName("com.google.appengine.api.urlfetch.URLFetchService");
                    gaeDetected = "true";
                    instances = new ArrayList();
                    return;
                    localClassNotFoundException1 = localClassNotFoundException1;
                    dalvikDetected = "false";
                }
            } catch (ClassNotFoundException localClassNotFoundException2) {
                for (; ; ) {
                    gaeDetected = "false";
                }
            }
        }
    }

    protected ConfigurationBase() {
        setDebug(false);
        setUser(null);
        setPassword(null);
        setUseSSL(true);
        setPrettyDebugEnabled(false);
        setGZIPEnabled(true);
        setHttpProxyHost(null);
        setHttpProxyUser(null);
        setHttpProxyPassword(null);
        setHttpProxyPort(-1);
        setHttpConnectionTimeout(20000);
        setHttpReadTimeout(120000);
        setHttpStreamingReadTimeout(40000);
        setHttpRetryCount(0);
        setHttpRetryIntervalSeconds(5);
        setHttpMaxTotalConnections(20);
        setHttpDefaultMaxPerRoute(2);
        setOAuthConsumerKey(null);
        setOAuthConsumerSecret(null);
        setOAuthAccessToken(null);
        setOAuthAccessTokenSecret(null);
        setAsyncNumThreads(1);
        setContributingTo(-1L);
        setClientVersion(Version.getVersion());
        setClientURL("http://twitter4j.org/en/twitter4j-" + Version.getVersion() + ".xml");
        setUserAgent("twitter4j http://twitter4j.org/ /" + Version.getVersion());
        setJSONStoreEnabled(false);
        setMBeanEnabled(false);
        setOAuthRequestTokenURL("http://api.twitter.com/oauth/request_token");
        setOAuthAuthorizationURL("http://api.twitter.com/oauth/authorize");
        setOAuthAccessTokenURL("http://api.twitter.com/oauth/access_token");
        setOAuthAuthenticationURL("http://api.twitter.com/oauth/authenticate");
        setOAuth2TokenURL("https://api.twitter.com/oauth2/token");
        setOAuth2InvalidateTokenURL("https://api.twitter.com/oauth2/invalidate_token");
        setRestBaseURL("http://api.twitter.com/1.1/");
        setStreamBaseURL("https://stream.twitter.com/1.1/");
        setUserStreamBaseURL("https://userstream.twitter.com/1.1/");
        setSiteStreamBaseURL("https://sitestream.twitter.com/1.1/");
        setDispatcherImpl("twitter4j.internal.async.DispatcherImpl");
        setLoggerFactory(null);
        setUserStreamRepliesAllEnabled(false);
        setStallWarningsEnabled(true);
        try {
            str1 = System.getProperty("twitter4j.dalvik", dalvikDetected);
            this.IS_DALVIK = Boolean.valueOf(str1).booleanValue();
        } catch (SecurityException localSecurityException1) {
            try {
                String str1 = System.getProperty("twitter4j.gae", gaeDetected);
                this.IS_GAE = Boolean.valueOf(str1).booleanValue();
                setMediaProvider("TWITTER");
                setMediaProviderAPIKey(null);
                setMediaProviderParameters(null);
                return;
                localSecurityException1 = localSecurityException1;
                String str2 = dalvikDetected;
            } catch (SecurityException localSecurityException2) {
                for (; ; ) {
                    String str3 = gaeDetected;
                }
            }
        }
    }

    private static void cacheInstance(ConfigurationBase paramConfigurationBase) {
        if (!instances.contains(paramConfigurationBase)) {
            instances.add(paramConfigurationBase);
        }
    }

    private void fixRestBaseURL() {
        if ("http://api.twitter.com/1.1/".equals(fixURL(false, this.restBaseURL))) {
            this.restBaseURL = fixURL(this.useSSL, this.restBaseURL);
        }
        if ("http://api.twitter.com/oauth/access_token".equals(fixURL(false, this.oAuthAccessTokenURL))) {
            this.oAuthAccessTokenURL = fixURL(this.useSSL, this.oAuthAccessTokenURL);
        }
        if ("http://api.twitter.com/oauth/authenticate".equals(fixURL(false, this.oAuthAuthenticationURL))) {
            this.oAuthAuthenticationURL = fixURL(this.useSSL, this.oAuthAuthenticationURL);
        }
        if ("http://api.twitter.com/oauth/authorize".equals(fixURL(false, this.oAuthAuthorizationURL))) {
            this.oAuthAuthorizationURL = fixURL(this.useSSL, this.oAuthAuthorizationURL);
        }
        if ("http://api.twitter.com/oauth/request_token".equals(fixURL(false, this.oAuthRequestTokenURL))) {
            this.oAuthRequestTokenURL = fixURL(this.useSSL, this.oAuthRequestTokenURL);
        }
    }

    static String fixURL(boolean paramBoolean, String paramString) {
        if (paramString == null) {
            return null;
        }
        int i = paramString.indexOf("://");
        if (-1 == i) {
            throw new IllegalArgumentException("url should contain '://'");
        }
        paramString = paramString.substring(i + 3);
        if (paramBoolean) {
            return "https://" + paramString;
        }
        return "http://" + paramString;
    }

    private static ConfigurationBase getInstance(ConfigurationBase paramConfigurationBase) {
        int i = instances.indexOf(paramConfigurationBase);
        if (i == -1) {
            instances.add(paramConfigurationBase);
            return paramConfigurationBase;
        }
        return (ConfigurationBase) instances.get(i);
    }

    private void initRequestHeaders() {
        this.requestHeaders = new HashMap();
        this.requestHeaders.put("X-Twitter-Client-Version", getClientVersion());
        this.requestHeaders.put("X-Twitter-Client-URL", getClientURL());
        this.requestHeaders.put("X-Twitter-Client", "Twitter4J");
        this.requestHeaders.put("User-Agent", getUserAgent());
        if (this.gzipEnabled) {
            this.requestHeaders.put("Accept-Encoding", "gzip");
        }
        if (this.IS_DALVIK) {
            this.requestHeaders.put("Connection", "close");
        }
    }

    protected void cacheInstance() {
        cacheInstance(this);
    }

    public void dumpConfiguration() {
        Logger localLogger = Logger.getLogger(ConfigurationBase.class);
        if (this.debug) {
            Field[] arrayOfField = ConfigurationBase.class.getDeclaredFields();
            int j = arrayOfField.length;
            int i = 0;
            while (i < j) {
                Field localField = arrayOfField[i];
                try {
                    Object localObject = localField.get(this);
                    String str2 = String.valueOf(localObject);
                    String str1 = str2;
                    if (localObject != null) {
                        str1 = str2;
                        if (localField.getName().matches("oAuthConsumerSecret|oAuthAccessTokenSecret|password")) {
                            str1 = z_T4JInternalStringUtil.maskString(String.valueOf(localObject));
                        }
                    }
                    localLogger.debug(localField.getName() + ": " + str1);
                } catch (IllegalAccessException localIllegalAccessException) {
                    for (; ; ) {
                    }
                }
                i += 1;
            }
        }
        if (!this.includeRTsEnabled) {
            localLogger.warn("includeRTsEnabled is set to false. This configuration may not take effect after May 14th, 2012. https://dev.twitter.com/blog/api-housekeeping");
        }
        if (!this.includeEntitiesEnabled) {
            localLogger.warn("includeEntitiesEnabled is set to false. This configuration may not take effect after May 14th, 2012. https://dev.twitter.com/blog/api-housekeeping");
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (ConfigurationBase) paramObject;
            if (this.IS_DALVIK != ((ConfigurationBase) paramObject).IS_DALVIK) {
                return false;
            }
            if (this.IS_GAE != ((ConfigurationBase) paramObject).IS_GAE) {
                return false;
            }
            if (this.asyncNumThreads != ((ConfigurationBase) paramObject).asyncNumThreads) {
                return false;
            }
            if (this.contributingTo != ((ConfigurationBase) paramObject).contributingTo) {
                return false;
            }
            if (this.debug != ((ConfigurationBase) paramObject).debug) {
                return false;
            }
            if (this.defaultMaxPerRoute != ((ConfigurationBase) paramObject).defaultMaxPerRoute) {
                return false;
            }
            if (this.gzipEnabled != ((ConfigurationBase) paramObject).gzipEnabled) {
                return false;
            }
            if (this.httpConnectionTimeout != ((ConfigurationBase) paramObject).httpConnectionTimeout) {
                return false;
            }
            if (this.httpProxyPort != ((ConfigurationBase) paramObject).httpProxyPort) {
                return false;
            }
            if (this.httpReadTimeout != ((ConfigurationBase) paramObject).httpReadTimeout) {
                return false;
            }
            if (this.httpRetryCount != ((ConfigurationBase) paramObject).httpRetryCount) {
                return false;
            }
            if (this.httpRetryIntervalSeconds != ((ConfigurationBase) paramObject).httpRetryIntervalSeconds) {
                return false;
            }
            if (this.httpStreamingReadTimeout != ((ConfigurationBase) paramObject).httpStreamingReadTimeout) {
                return false;
            }
            if (this.includeEntitiesEnabled != ((ConfigurationBase) paramObject).includeEntitiesEnabled) {
                return false;
            }
            if (this.includeMyRetweetEnabled != ((ConfigurationBase) paramObject).includeMyRetweetEnabled) {
                return false;
            }
            if (this.trimUserEnabled != ((ConfigurationBase) paramObject).trimUserEnabled) {
                return false;
            }
            if (this.includeRTsEnabled != ((ConfigurationBase) paramObject).includeRTsEnabled) {
                return false;
            }
            if (this.jsonStoreEnabled != ((ConfigurationBase) paramObject).jsonStoreEnabled) {
                return false;
            }
            if (this.maxTotalConnections != ((ConfigurationBase) paramObject).maxTotalConnections) {
                return false;
            }
            if (this.mbeanEnabled != ((ConfigurationBase) paramObject).mbeanEnabled) {
                return false;
            }
            if (this.prettyDebug != ((ConfigurationBase) paramObject).prettyDebug) {
                return false;
            }
            if (this.stallWarningsEnabled != ((ConfigurationBase) paramObject).stallWarningsEnabled) {
                return false;
            }
            if (this.applicationOnlyAuthEnabled != ((ConfigurationBase) paramObject).applicationOnlyAuthEnabled) {
                return false;
            }
            if (this.useSSL != ((ConfigurationBase) paramObject).useSSL) {
                return false;
            }
            if (this.userStreamRepliesAllEnabled != ((ConfigurationBase) paramObject).userStreamRepliesAllEnabled) {
                return false;
            }
            if (this.clientURL != null) {
                if (this.clientURL.equals(((ConfigurationBase) paramObject).clientURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).clientURL != null) {
                    return false;
                }
            }
            if (this.clientVersion != null) {
                if (this.clientVersion.equals(((ConfigurationBase) paramObject).clientVersion)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).clientVersion != null) {
                    return false;
                }
            }
            if (this.dispatcherImpl != null) {
                if (this.dispatcherImpl.equals(((ConfigurationBase) paramObject).dispatcherImpl)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).dispatcherImpl != null) {
                    return false;
                }
            }
            if (this.httpProxyHost != null) {
                if (this.httpProxyHost.equals(((ConfigurationBase) paramObject).httpProxyHost)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).httpProxyHost != null) {
                    return false;
                }
            }
            if (this.httpProxyPassword != null) {
                if (this.httpProxyPassword.equals(((ConfigurationBase) paramObject).httpProxyPassword)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).httpProxyPassword != null) {
                    return false;
                }
            }
            if (this.httpProxyUser != null) {
                if (this.httpProxyUser.equals(((ConfigurationBase) paramObject).httpProxyUser)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).httpProxyUser != null) {
                    return false;
                }
            }
            if (this.loggerFactory != null) {
                if (this.loggerFactory.equals(((ConfigurationBase) paramObject).loggerFactory)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).loggerFactory != null) {
                    return false;
                }
            }
            if (this.mediaProvider != null) {
                if (this.mediaProvider.equals(((ConfigurationBase) paramObject).mediaProvider)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).mediaProvider != null) {
                    return false;
                }
            }
            if (this.mediaProviderAPIKey != null) {
                if (this.mediaProviderAPIKey.equals(((ConfigurationBase) paramObject).mediaProviderAPIKey)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).mediaProviderAPIKey != null) {
                    return false;
                }
            }
            if (this.mediaProviderParameters != null) {
                if (this.mediaProviderParameters.equals(((ConfigurationBase) paramObject).mediaProviderParameters)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).mediaProviderParameters != null) {
                    return false;
                }
            }
            if (this.oAuthAccessToken != null) {
                if (this.oAuthAccessToken.equals(((ConfigurationBase) paramObject).oAuthAccessToken)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthAccessToken != null) {
                    return false;
                }
            }
            if (this.oAuthAccessTokenSecret != null) {
                if (this.oAuthAccessTokenSecret.equals(((ConfigurationBase) paramObject).oAuthAccessTokenSecret)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthAccessTokenSecret != null) {
                    return false;
                }
            }
            if (this.oAuth2TokenType != null) {
                if (this.oAuth2TokenType.equals(((ConfigurationBase) paramObject).oAuth2TokenType)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuth2TokenType != null) {
                    return false;
                }
            }
            if (this.oAuth2AccessToken != null) {
                if (this.oAuth2AccessToken.equals(((ConfigurationBase) paramObject).oAuth2AccessToken)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuth2AccessToken != null) {
                    return false;
                }
            }
            if (this.oAuthAccessTokenURL != null) {
                if (this.oAuthAccessTokenURL.equals(((ConfigurationBase) paramObject).oAuthAccessTokenURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthAccessTokenURL != null) {
                    return false;
                }
            }
            if (this.oAuthAuthenticationURL != null) {
                if (this.oAuthAuthenticationURL.equals(((ConfigurationBase) paramObject).oAuthAuthenticationURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthAuthenticationURL != null) {
                    return false;
                }
            }
            if (this.oAuthAuthorizationURL != null) {
                if (this.oAuthAuthorizationURL.equals(((ConfigurationBase) paramObject).oAuthAuthorizationURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthAuthorizationURL != null) {
                    return false;
                }
            }
            if (this.oAuth2TokenURL != null) {
                if (this.oAuth2TokenURL.equals(((ConfigurationBase) paramObject).oAuth2TokenURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuth2TokenURL != null) {
                    return false;
                }
            }
            if (this.oAuth2InvalidateTokenURL != null) {
                if (this.oAuth2InvalidateTokenURL.equals(((ConfigurationBase) paramObject).oAuth2InvalidateTokenURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuth2InvalidateTokenURL != null) {
                    return false;
                }
            }
            if (this.oAuthConsumerKey != null) {
                if (this.oAuthConsumerKey.equals(((ConfigurationBase) paramObject).oAuthConsumerKey)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthConsumerKey != null) {
                    return false;
                }
            }
            if (this.oAuthConsumerSecret != null) {
                if (this.oAuthConsumerSecret.equals(((ConfigurationBase) paramObject).oAuthConsumerSecret)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthConsumerSecret != null) {
                    return false;
                }
            }
            if (this.oAuthRequestTokenURL != null) {
                if (this.oAuthRequestTokenURL.equals(((ConfigurationBase) paramObject).oAuthRequestTokenURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuthRequestTokenURL != null) {
                    return false;
                }
            }
            if (this.password != null) {
                if (this.password.equals(((ConfigurationBase) paramObject).password)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).password != null) {
                    return false;
                }
            }
            if (this.requestHeaders != null) {
                if (this.requestHeaders.equals(((ConfigurationBase) paramObject).requestHeaders)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).requestHeaders != null) {
                    return false;
                }
            }
            if (this.restBaseURL != null) {
                if (this.restBaseURL.equals(((ConfigurationBase) paramObject).restBaseURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).restBaseURL != null) {
                    return false;
                }
            }
            if (this.siteStreamBaseURL != null) {
                if (this.siteStreamBaseURL.equals(((ConfigurationBase) paramObject).siteStreamBaseURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).siteStreamBaseURL != null) {
                    return false;
                }
            }
            if (this.streamBaseURL != null) {
                if (this.streamBaseURL.equals(((ConfigurationBase) paramObject).streamBaseURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).streamBaseURL != null) {
                    return false;
                }
            }
            if (this.user != null) {
                if (this.user.equals(((ConfigurationBase) paramObject).user)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).user != null) {
                    return false;
                }
            }
            if (this.userAgent != null) {
                if (this.userAgent.equals(((ConfigurationBase) paramObject).userAgent)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).userAgent != null) {
                    return false;
                }
            }
            if (this.userStreamBaseURL == null) {
                break;
            }
        } while (this.userStreamBaseURL.equals(((ConfigurationBase) paramObject).userStreamBaseURL));
        for (; ; ) {
            return false;
            if (((ConfigurationBase) paramObject).userStreamBaseURL == null) {
                break;
            }
        }
    }

    public final int getAsyncNumThreads() {
        return this.asyncNumThreads;
    }

    public final String getClientURL() {
        return this.clientURL;
    }

    public final String getClientVersion() {
        return this.clientVersion;
    }

    public final long getContributingTo() {
        return this.contributingTo;
    }

    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }

    public final int getHttpConnectionTimeout() {
        return this.httpConnectionTimeout;
    }

    public final int getHttpDefaultMaxPerRoute() {
        return this.defaultMaxPerRoute;
    }

    public final int getHttpMaxTotalConnections() {
        return this.maxTotalConnections;
    }

    public final String getHttpProxyHost() {
        return this.httpProxyHost;
    }

    public final String getHttpProxyPassword() {
        return this.httpProxyPassword;
    }

    public final int getHttpProxyPort() {
        return this.httpProxyPort;
    }

    public final String getHttpProxyUser() {
        return this.httpProxyUser;
    }

    public final int getHttpReadTimeout() {
        return this.httpReadTimeout;
    }

    public final int getHttpRetryCount() {
        return this.httpRetryCount;
    }

    public final int getHttpRetryIntervalSeconds() {
        return this.httpRetryIntervalSeconds;
    }

    public int getHttpStreamingReadTimeout() {
        return this.httpStreamingReadTimeout;
    }

    public String getLoggerFactory() {
        return this.loggerFactory;
    }

    public String getMediaProvider() {
        return this.mediaProvider;
    }

    public String getMediaProviderAPIKey() {
        return this.mediaProviderAPIKey;
    }

    public Properties getMediaProviderParameters() {
        return this.mediaProviderParameters;
    }

    public String getOAuth2AccessToken() {
        return this.oAuth2AccessToken;
    }

    public String getOAuth2InvalidateTokenURL() {
        return this.oAuth2InvalidateTokenURL;
    }

    public String getOAuth2TokenType() {
        return this.oAuth2TokenType;
    }

    public String getOAuth2TokenURL() {
        return this.oAuth2TokenURL;
    }

    public String getOAuthAccessToken() {
        return this.oAuthAccessToken;
    }

    public String getOAuthAccessTokenSecret() {
        return this.oAuthAccessTokenSecret;
    }

    public String getOAuthAccessTokenURL() {
        return this.oAuthAccessTokenURL;
    }

    public String getOAuthAuthenticationURL() {
        return this.oAuthAuthenticationURL;
    }

    public String getOAuthAuthorizationURL() {
        return this.oAuthAuthorizationURL;
    }

    public final String getOAuthConsumerKey() {
        return this.oAuthConsumerKey;
    }

    public final String getOAuthConsumerSecret() {
        return this.oAuthConsumerSecret;
    }

    public String getOAuthRequestTokenURL() {
        return this.oAuthRequestTokenURL;
    }

    public final String getPassword() {
        return this.password;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getRestBaseURL() {
        return this.restBaseURL;
    }

    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }

    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }

    public final String getUser() {
        return this.user;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }

    public int hashCode() {
        int i39 = 1;
        int i40 = 0;
        int i;
        int j;
        label30:
        int k;
        label45:
        int m;
        label61:
        int n;
        label71:
        int i1;
        label81:
        int i2;
        label91:
        int i3;
        label107:
        int i4;
        label123:
        int i5;
        label139:
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        int i46;
        int i47;
        int i48;
        int i6;
        label203:
        int i7;
        label219:
        int i8;
        label235:
        int i9;
        label251:
        int i10;
        label267:
        int i11;
        label283:
        int i12;
        label299:
        int i13;
        label315:
        int i14;
        label331:
        int i15;
        label347:
        int i16;
        label363:
        int i17;
        label379:
        int i18;
        label395:
        int i19;
        label411:
        int i20;
        label427:
        int i21;
        label443:
        int i22;
        label459:
        int i23;
        label475:
        int i49;
        int i50;
        int i24;
        label506:
        int i25;
        label516:
        int i26;
        label526:
        int i27;
        label536:
        int i28;
        label546:
        int i29;
        label556:
        int i30;
        label566:
        int i31;
        label576:
        int i32;
        label586:
        int i33;
        label602:
        int i34;
        label618:
        int i35;
        label634:
        int i36;
        label650:
        int i37;
        label666:
        int i38;
        if (this.debug) {
            i = 1;
            if (this.userAgent == null) {
                break label1030;
            }
            j = this.userAgent.hashCode();
            if (this.user == null) {
                break label1035;
            }
            k = this.user.hashCode();
            if (this.password == null) {
                break label1040;
            }
            m = this.password.hashCode();
            if (!this.useSSL) {
                break label1046;
            }
            n = 1;
            if (!this.prettyDebug) {
                break label1052;
            }
            i1 = 1;
            if (!this.gzipEnabled) {
                break label1058;
            }
            i2 = 1;
            if (this.httpProxyHost == null) {
                break label1064;
            }
            i3 = this.httpProxyHost.hashCode();
            if (this.httpProxyUser == null) {
                break label1070;
            }
            i4 = this.httpProxyUser.hashCode();
            if (this.httpProxyPassword == null) {
                break label1076;
            }
            i5 = this.httpProxyPassword.hashCode();
            i41 = this.httpProxyPort;
            i42 = this.httpConnectionTimeout;
            i43 = this.httpReadTimeout;
            i44 = this.httpStreamingReadTimeout;
            i45 = this.httpRetryCount;
            i46 = this.httpRetryIntervalSeconds;
            i47 = this.maxTotalConnections;
            i48 = this.defaultMaxPerRoute;
            if (this.oAuthConsumerKey == null) {
                break label1082;
            }
            i6 = this.oAuthConsumerKey.hashCode();
            if (this.oAuthConsumerSecret == null) {
                break label1088;
            }
            i7 = this.oAuthConsumerSecret.hashCode();
            if (this.oAuthAccessToken == null) {
                break label1094;
            }
            i8 = this.oAuthAccessToken.hashCode();
            if (this.oAuthAccessTokenSecret == null) {
                break label1100;
            }
            i9 = this.oAuthAccessTokenSecret.hashCode();
            if (this.oAuth2TokenType == null) {
                break label1106;
            }
            i10 = this.oAuth2TokenType.hashCode();
            if (this.oAuth2AccessToken == null) {
                break label1112;
            }
            i11 = this.oAuth2AccessToken.hashCode();
            if (this.oAuthRequestTokenURL == null) {
                break label1118;
            }
            i12 = this.oAuthRequestTokenURL.hashCode();
            if (this.oAuthAuthorizationURL == null) {
                break label1124;
            }
            i13 = this.oAuthAuthorizationURL.hashCode();
            if (this.oAuthAccessTokenURL == null) {
                break label1130;
            }
            i14 = this.oAuthAccessTokenURL.hashCode();
            if (this.oAuthAuthenticationURL == null) {
                break label1136;
            }
            i15 = this.oAuthAuthenticationURL.hashCode();
            if (this.oAuth2TokenURL == null) {
                break label1142;
            }
            i16 = this.oAuth2TokenURL.hashCode();
            if (this.oAuth2InvalidateTokenURL == null) {
                break label1148;
            }
            i17 = this.oAuth2InvalidateTokenURL.hashCode();
            if (this.restBaseURL == null) {
                break label1154;
            }
            i18 = this.restBaseURL.hashCode();
            if (this.streamBaseURL == null) {
                break label1160;
            }
            i19 = this.streamBaseURL.hashCode();
            if (this.userStreamBaseURL == null) {
                break label1166;
            }
            i20 = this.userStreamBaseURL.hashCode();
            if (this.siteStreamBaseURL == null) {
                break label1172;
            }
            i21 = this.siteStreamBaseURL.hashCode();
            if (this.dispatcherImpl == null) {
                break label1178;
            }
            i22 = this.dispatcherImpl.hashCode();
            if (this.loggerFactory == null) {
                break label1184;
            }
            i23 = this.loggerFactory.hashCode();
            i49 = this.asyncNumThreads;
            i50 = (int) (this.contributingTo ^ this.contributingTo >>> 32);
            if (!this.includeRTsEnabled) {
                break label1190;
            }
            i24 = 1;
            if (!this.includeEntitiesEnabled) {
                break label1196;
            }
            i25 = 1;
            if (!this.includeMyRetweetEnabled) {
                break label1202;
            }
            i26 = 1;
            if (!this.trimUserEnabled) {
                break label1208;
            }
            i27 = 1;
            if (!this.jsonStoreEnabled) {
                break label1214;
            }
            i28 = 1;
            if (!this.mbeanEnabled) {
                break label1220;
            }
            i29 = 1;
            if (!this.userStreamRepliesAllEnabled) {
                break label1226;
            }
            i30 = 1;
            if (!this.stallWarningsEnabled) {
                break label1232;
            }
            i31 = 1;
            if (!this.applicationOnlyAuthEnabled) {
                break label1238;
            }
            i32 = 1;
            if (this.mediaProvider == null) {
                break label1244;
            }
            i33 = this.mediaProvider.hashCode();
            if (this.mediaProviderAPIKey == null) {
                break label1250;
            }
            i34 = this.mediaProviderAPIKey.hashCode();
            if (this.mediaProviderParameters == null) {
                break label1256;
            }
            i35 = this.mediaProviderParameters.hashCode();
            if (this.clientVersion == null) {
                break label1262;
            }
            i36 = this.clientVersion.hashCode();
            if (this.clientURL == null) {
                break label1268;
            }
            i37 = this.clientURL.hashCode();
            if (!this.IS_DALVIK) {
                break label1274;
            }
            i38 = 1;
            label676:
            if (!this.IS_GAE) {
                break label1280;
            }
        }
        for (; ; ) {
            if (this.requestHeaders != null) {
                i40 = this.requestHeaders.hashCode();
            }
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i41) * 31 + i42) * 31 + i43) * 31 + i44) * 31 + i45) * 31 + i46) * 31 + i47) * 31 + i48) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31 + i49) * 31 + i50) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30) * 31 + i31) * 31 + i32) * 31 + i33) * 31 + i34) * 31 + i35) * 31 + i36) * 31 + i37) * 31 + i38) * 31 + i39) * 31 + i40;
            i = 0;
            break;
            label1030:
            j = 0;
            break label30;
            label1035:
            k = 0;
            break label45;
            label1040:
            m = 0;
            break label61;
            label1046:
            n = 0;
            break label71;
            label1052:
            i1 = 0;
            break label81;
            label1058:
            i2 = 0;
            break label91;
            label1064:
            i3 = 0;
            break label107;
            label1070:
            i4 = 0;
            break label123;
            label1076:
            i5 = 0;
            break label139;
            label1082:
            i6 = 0;
            break label203;
            label1088:
            i7 = 0;
            break label219;
            label1094:
            i8 = 0;
            break label235;
            label1100:
            i9 = 0;
            break label251;
            label1106:
            i10 = 0;
            break label267;
            label1112:
            i11 = 0;
            break label283;
            label1118:
            i12 = 0;
            break label299;
            label1124:
            i13 = 0;
            break label315;
            label1130:
            i14 = 0;
            break label331;
            label1136:
            i15 = 0;
            break label347;
            label1142:
            i16 = 0;
            break label363;
            label1148:
            i17 = 0;
            break label379;
            label1154:
            i18 = 0;
            break label395;
            label1160:
            i19 = 0;
            break label411;
            label1166:
            i20 = 0;
            break label427;
            label1172:
            i21 = 0;
            break label443;
            label1178:
            i22 = 0;
            break label459;
            label1184:
            i23 = 0;
            break label475;
            label1190:
            i24 = 0;
            break label506;
            label1196:
            i25 = 0;
            break label516;
            label1202:
            i26 = 0;
            break label526;
            label1208:
            i27 = 0;
            break label536;
            label1214:
            i28 = 0;
            break label546;
            label1220:
            i29 = 0;
            break label556;
            label1226:
            i30 = 0;
            break label566;
            label1232:
            i31 = 0;
            break label576;
            label1238:
            i32 = 0;
            break label586;
            label1244:
            i33 = 0;
            break label602;
            label1250:
            i34 = 0;
            break label618;
            label1256:
            i35 = 0;
            break label634;
            label1262:
            i36 = 0;
            break label650;
            label1268:
            i37 = 0;
            break label666;
            label1274:
            i38 = 0;
            break label676;
            label1280:
            i39 = 0;
        }
    }

    public boolean isApplicationOnlyAuthEnabled() {
        return this.applicationOnlyAuthEnabled;
    }

    public final boolean isDalvik() {
        return this.IS_DALVIK;
    }

    public final boolean isDebugEnabled() {
        return this.debug;
    }

    public boolean isGAE() {
        return this.IS_GAE;
    }

    public boolean isGZIPEnabled() {
        return this.gzipEnabled;
    }

    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }

    public boolean isIncludeMyRetweetEnabled() {
        return this.includeMyRetweetEnabled;
    }

    public boolean isIncludeRTsEnabled() {
        return this.includeRTsEnabled;
    }

    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }

    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
    }

    public boolean isPrettyDebugEnabled() {
        return this.prettyDebug;
    }

    public boolean isStallWarningsEnabled() {
        return this.stallWarningsEnabled;
    }

    public boolean isTrimUserEnabled() {
        return this.trimUserEnabled;
    }

    public boolean isUserStreamRepliesAllEnabled() {
        return this.userStreamRepliesAllEnabled;
    }

    protected Object readResolve()
            throws ObjectStreamException {
        return getInstance(this);
    }

    protected final void setApplicationOnlyAuthEnabled(boolean paramBoolean) {
        this.applicationOnlyAuthEnabled = paramBoolean;
    }

    protected final void setAsyncNumThreads(int paramInt) {
        this.asyncNumThreads = paramInt;
    }

    protected final void setClientURL(String paramString) {
        this.clientURL = paramString;
        initRequestHeaders();
    }

    protected final void setClientVersion(String paramString) {
        this.clientVersion = paramString;
        initRequestHeaders();
    }

    protected final void setContributingTo(long paramLong) {
        this.contributingTo = paramLong;
    }

    protected final void setDebug(boolean paramBoolean) {
        this.debug = paramBoolean;
    }

    protected final void setDispatcherImpl(String paramString) {
        this.dispatcherImpl = paramString;
    }

    protected final void setGZIPEnabled(boolean paramBoolean) {
        this.gzipEnabled = paramBoolean;
        initRequestHeaders();
    }

    protected final void setHttpConnectionTimeout(int paramInt) {
        this.httpConnectionTimeout = paramInt;
    }

    protected final void setHttpDefaultMaxPerRoute(int paramInt) {
        this.defaultMaxPerRoute = paramInt;
    }

    protected final void setHttpMaxTotalConnections(int paramInt) {
        this.maxTotalConnections = paramInt;
    }

    protected final void setHttpProxyHost(String paramString) {
        this.httpProxyHost = paramString;
    }

    protected final void setHttpProxyPassword(String paramString) {
        this.httpProxyPassword = paramString;
    }

    protected final void setHttpProxyPort(int paramInt) {
        this.httpProxyPort = paramInt;
    }

    protected final void setHttpProxyUser(String paramString) {
        this.httpProxyUser = paramString;
    }

    protected final void setHttpReadTimeout(int paramInt) {
        this.httpReadTimeout = paramInt;
    }

    protected final void setHttpRetryCount(int paramInt) {
        this.httpRetryCount = paramInt;
    }

    protected final void setHttpRetryIntervalSeconds(int paramInt) {
        this.httpRetryIntervalSeconds = paramInt;
    }

    protected final void setHttpStreamingReadTimeout(int paramInt) {
        this.httpStreamingReadTimeout = paramInt;
    }

    protected final void setIncludeEntitiesEnbled(boolean paramBoolean) {
        this.includeEntitiesEnabled = paramBoolean;
    }

    public void setIncludeMyRetweetEnabled(boolean paramBoolean) {
        this.includeMyRetweetEnabled = paramBoolean;
    }

    protected final void setIncludeRTsEnbled(boolean paramBoolean) {
        this.includeRTsEnabled = paramBoolean;
    }

    protected final void setJSONStoreEnabled(boolean paramBoolean) {
        this.jsonStoreEnabled = paramBoolean;
    }

    protected final void setLoggerFactory(String paramString) {
        this.loggerFactory = paramString;
    }

    protected final void setMBeanEnabled(boolean paramBoolean) {
        this.mbeanEnabled = paramBoolean;
    }

    protected final void setMediaProvider(String paramString) {
        this.mediaProvider = paramString;
    }

    protected final void setMediaProviderAPIKey(String paramString) {
        this.mediaProviderAPIKey = paramString;
    }

    protected final void setMediaProviderParameters(Properties paramProperties) {
        this.mediaProviderParameters = paramProperties;
    }

    protected final void setOAuth2AccessToken(String paramString) {
        this.oAuth2AccessToken = paramString;
    }

    protected final void setOAuth2InvalidateTokenURL(String paramString) {
        this.oAuth2InvalidateTokenURL = paramString;
        fixRestBaseURL();
    }

    protected final void setOAuth2TokenType(String paramString) {
        this.oAuth2TokenType = paramString;
    }

    protected final void setOAuth2TokenURL(String paramString) {
        this.oAuth2TokenURL = paramString;
        fixRestBaseURL();
    }

    protected final void setOAuthAccessToken(String paramString) {
        this.oAuthAccessToken = paramString;
    }

    protected final void setOAuthAccessTokenSecret(String paramString) {
        this.oAuthAccessTokenSecret = paramString;
    }

    protected final void setOAuthAccessTokenURL(String paramString) {
        this.oAuthAccessTokenURL = paramString;
        fixRestBaseURL();
    }

    protected final void setOAuthAuthenticationURL(String paramString) {
        this.oAuthAuthenticationURL = paramString;
        fixRestBaseURL();
    }

    protected final void setOAuthAuthorizationURL(String paramString) {
        this.oAuthAuthorizationURL = paramString;
        fixRestBaseURL();
    }

    protected final void setOAuthConsumerKey(String paramString) {
        this.oAuthConsumerKey = paramString;
        fixRestBaseURL();
    }

    protected final void setOAuthConsumerSecret(String paramString) {
        this.oAuthConsumerSecret = paramString;
        fixRestBaseURL();
    }

    protected final void setOAuthRequestTokenURL(String paramString) {
        this.oAuthRequestTokenURL = paramString;
        fixRestBaseURL();
    }

    protected final void setPassword(String paramString) {
        this.password = paramString;
    }

    protected final void setPrettyDebugEnabled(boolean paramBoolean) {
        this.prettyDebug = paramBoolean;
    }

    protected final void setRestBaseURL(String paramString) {
        this.restBaseURL = paramString;
        fixRestBaseURL();
    }

    protected final void setSiteStreamBaseURL(String paramString) {
        this.siteStreamBaseURL = paramString;
    }

    protected final void setStallWarningsEnabled(boolean paramBoolean) {
        this.stallWarningsEnabled = paramBoolean;
    }

    protected final void setStreamBaseURL(String paramString) {
        this.streamBaseURL = paramString;
    }

    public void setTrimUserEnabled(boolean paramBoolean) {
        this.trimUserEnabled = paramBoolean;
    }

    protected final void setUseSSL(boolean paramBoolean) {
        this.useSSL = paramBoolean;
        fixRestBaseURL();
    }

    protected final void setUser(String paramString) {
        this.user = paramString;
    }

    protected final void setUserAgent(String paramString) {
        this.userAgent = paramString;
        initRequestHeaders();
    }

    protected final void setUserStreamBaseURL(String paramString) {
        this.userStreamBaseURL = paramString;
    }

    protected final void setUserStreamRepliesAllEnabled(boolean paramBoolean) {
        this.userStreamRepliesAllEnabled = paramBoolean;
    }

    public String toString() {
        return "ConfigurationBase{debug=" + this.debug + ", userAgent='" + this.userAgent + '\'' + ", user='" + this.user + '\'' + ", password='" + this.password + '\'' + ", useSSL=" + this.useSSL + ", prettyDebug=" + this.prettyDebug + ", gzipEnabled=" + this.gzipEnabled + ", httpProxyHost='" + this.httpProxyHost + '\'' + ", httpProxyUser='" + this.httpProxyUser + '\'' + ", httpProxyPassword='" + this.httpProxyPassword + '\'' + ", httpProxyPort=" + this.httpProxyPort + ", httpConnectionTimeout=" + this.httpConnectionTimeout + ", httpReadTimeout=" + this.httpReadTimeout + ", httpStreamingReadTimeout=" + this.httpStreamingReadTimeout + ", httpRetryCount=" + this.httpRetryCount + ", httpRetryIntervalSeconds=" + this.httpRetryIntervalSeconds + ", maxTotalConnections=" + this.maxTotalConnections + ", defaultMaxPerRoute=" + this.defaultMaxPerRoute + ", oAuthConsumerKey='" + this.oAuthConsumerKey + '\'' + ", oAuthConsumerSecret='" + this.oAuthConsumerSecret + '\'' + ", oAuthAccessToken='" + this.oAuthAccessToken + '\'' + ", oAuthAccessTokenSecret='" + this.oAuthAccessTokenSecret + '\'' + ", oAuth2TokenType='" + this.oAuth2TokenType + '\'' + ", oAuth2AccessToken='" + this.oAuth2AccessToken + '\'' + ", oAuthRequestTokenURL='" + this.oAuthRequestTokenURL + '\'' + ", oAuthAuthorizationURL='" + this.oAuthAuthorizationURL + '\'' + ", oAuthAccessTokenURL='" + this.oAuthAccessTokenURL + '\'' + ", oAuthAuthenticationURL='" + this.oAuthAuthenticationURL + '\'' + ", oAuth2TokenURL='" + this.oAuth2TokenURL + '\'' + ", oAuth2InvalidateTokenURL='" + this.oAuth2InvalidateTokenURL + '\'' + ", restBaseURL='" + this.restBaseURL + '\'' + ", streamBaseURL='" + this.streamBaseURL + '\'' + ", userStreamBaseURL='" + this.userStreamBaseURL + '\'' + ", siteStreamBaseURL='" + this.siteStreamBaseURL + '\'' + ", dispatcherImpl='" + this.dispatcherImpl + '\'' + ", loggerFactory='" + this.loggerFactory + '\'' + ", asyncNumThreads=" + this.asyncNumThreads + ", contributingTo=" + this.contributingTo + ", includeRTsEnabled=" + this.includeRTsEnabled + ", includeEntitiesEnabled=" + this.includeEntitiesEnabled + ", includeMyRetweetEnabled=" + this.includeMyRetweetEnabled + ", trimUserEnabled=" + this.trimUserEnabled + ", jsonStoreEnabled=" + this.jsonStoreEnabled + ", mbeanEnabled=" + this.mbeanEnabled + ", userStreamRepliesAllEnabled=" + this.userStreamRepliesAllEnabled + ", stallWarningsEnabled=" + this.stallWarningsEnabled + ", applicationOnlyAuthEnabled=" + this.applicationOnlyAuthEnabled + ", mediaProvider='" + this.mediaProvider + '\'' + ", mediaProviderAPIKey='" + this.mediaProviderAPIKey + '\'' + ", mediaProviderParameters=" + this.mediaProviderParameters + ", clientVersion='" + this.clientVersion + '\'' + ", clientURL='" + this.clientURL + '\'' + ", IS_DALVIK=" + this.IS_DALVIK + ", IS_GAE=" + this.IS_GAE + ", requestHeaders=" + this.requestHeaders + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/conf/ConfigurationBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
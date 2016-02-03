package twitter4j.conf;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import twitter4j.HttpClientConfiguration;
import twitter4j.Logger;

class ConfigurationBase
        implements Serializable, Configuration {
    private static final List<ConfigurationBase> instances = new ArrayList();
    private static final long serialVersionUID = 6175546394599249696L;
    private boolean applicationOnlyAuthEnabled = false;
    private int asyncNumThreads = 1;
    private long contributingTo = -1L;
    private boolean daemonEnabled = true;
    private boolean debug = false;
    private String dispatcherImpl = "twitter4j.DispatcherImpl";
    private HttpClientConfiguration httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, null, null, null, -1, 20000, 120000, false, true);
    private int httpRetryCount = 0;
    private int httpRetryIntervalSeconds = 5;
    private int httpStreamingReadTimeout = 40000;
    private boolean includeEntitiesEnabled = true;
    private boolean includeMyRetweetEnabled = true;
    private boolean jsonStoreEnabled = false;
    private String loggerFactory = null;
    private boolean mbeanEnabled = false;
    private String mediaProvider = "TWITTER";
    private String mediaProviderAPIKey = null;
    private Properties mediaProviderParameters = null;
    private String oAuth2AccessToken;
    private String oAuth2InvalidateTokenURL = "https://api.twitter.com/oauth2/invalidate_token";
    private String oAuth2Scope;
    private String oAuth2TokenType;
    private String oAuth2TokenURL = "https://api.twitter.com/oauth2/token";
    private String oAuthAccessToken = null;
    private String oAuthAccessTokenSecret = null;
    private String oAuthAccessTokenURL = "https://api.twitter.com/oauth/access_token";
    private String oAuthAuthenticationURL = "https://api.twitter.com/oauth/authenticate";
    private String oAuthAuthorizationURL = "https://api.twitter.com/oauth/authorize";
    private String oAuthConsumerKey = null;
    private String oAuthConsumerSecret = null;
    private String oAuthRequestTokenURL = "https://api.twitter.com/oauth/request_token";
    private String password = null;
    private String restBaseURL = "https://api.twitter.com/1.1/";
    private String siteStreamBaseURL = "https://sitestream.twitter.com/1.1/";
    private boolean stallWarningsEnabled = true;
    private String streamBaseURL = "https://stream.twitter.com/1.1/";
    private boolean trimUserEnabled = false;
    private String uploadBaseURL = "https://upload.twitter.com/1.1/";
    private String user = null;
    private String userStreamBaseURL = "https://userstream.twitter.com/1.1/";
    private boolean userStreamRepliesAllEnabled = false;
    private boolean userStreamWithFollowingsEnabled = true;

    private static void cacheInstance(ConfigurationBase paramConfigurationBase) {
        if (!instances.contains(paramConfigurationBase)) {
            instances.add(paramConfigurationBase);
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
                            str1 = String.valueOf(localObject).replaceAll(".", "*");
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
            if (this.applicationOnlyAuthEnabled != ((ConfigurationBase) paramObject).applicationOnlyAuthEnabled) {
                return false;
            }
            if (this.asyncNumThreads != ((ConfigurationBase) paramObject).asyncNumThreads) {
                return false;
            }
            if (this.contributingTo != ((ConfigurationBase) paramObject).contributingTo) {
                return false;
            }
            if (this.daemonEnabled != ((ConfigurationBase) paramObject).daemonEnabled) {
                return false;
            }
            if (this.debug != ((ConfigurationBase) paramObject).debug) {
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
            if (this.jsonStoreEnabled != ((ConfigurationBase) paramObject).jsonStoreEnabled) {
                return false;
            }
            if (this.mbeanEnabled != ((ConfigurationBase) paramObject).mbeanEnabled) {
                return false;
            }
            if (this.stallWarningsEnabled != ((ConfigurationBase) paramObject).stallWarningsEnabled) {
                return false;
            }
            if (this.trimUserEnabled != ((ConfigurationBase) paramObject).trimUserEnabled) {
                return false;
            }
            if (this.userStreamRepliesAllEnabled != ((ConfigurationBase) paramObject).userStreamRepliesAllEnabled) {
                return false;
            }
            if (this.userStreamWithFollowingsEnabled != ((ConfigurationBase) paramObject).userStreamWithFollowingsEnabled) {
                return false;
            }
            if (this.dispatcherImpl != null) {
                if (this.dispatcherImpl.equals(((ConfigurationBase) paramObject).dispatcherImpl)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).dispatcherImpl != null) {
                    return false;
                }
            }
            if (this.httpConf != null) {
                if (this.httpConf.equals(((ConfigurationBase) paramObject).httpConf)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).httpConf != null) {
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
            if (this.oAuth2AccessToken != null) {
                if (this.oAuth2AccessToken.equals(((ConfigurationBase) paramObject).oAuth2AccessToken)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuth2AccessToken != null) {
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
            if (this.oAuth2TokenType != null) {
                if (this.oAuth2TokenType.equals(((ConfigurationBase) paramObject).oAuth2TokenType)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuth2TokenType != null) {
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
            if (this.oAuth2Scope != null) {
                if (this.oAuth2Scope.equals(((ConfigurationBase) paramObject).oAuth2Scope)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).oAuth2Scope != null) {
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
            if (this.restBaseURL != null) {
                if (this.restBaseURL.equals(((ConfigurationBase) paramObject).restBaseURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).restBaseURL != null) {
                    return false;
                }
            }
            if (this.uploadBaseURL != null) {
                if (this.uploadBaseURL.equals(((ConfigurationBase) paramObject).uploadBaseURL)) {
                }
            } else {
                while (((ConfigurationBase) paramObject).uploadBaseURL != null) {
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

    public final long getContributingTo() {
        return this.contributingTo;
    }

    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }

    public HttpClientConfiguration getHttpClientConfiguration() {
        return this.httpConf;
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

    public String getOAuth2Scope() {
        return this.oAuth2Scope;
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

    public String getRestBaseURL() {
        return this.restBaseURL;
    }

    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }

    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }

    public String getUploadBaseURL() {
        return this.uploadBaseURL;
    }

    public final String getUser() {
        return this.user;
    }

    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }

    public int hashCode() {
        int i32 = 1;
        int i;
        int j;
        label27:
        int k;
        label42:
        int m;
        label58:
        int i33;
        int i34;
        int i35;
        int n;
        label92:
        int i1;
        label108:
        int i2;
        label124:
        int i3;
        label140:
        int i4;
        label156:
        int i5;
        label172:
        int i6;
        label188:
        int i7;
        label204:
        int i8;
        label220:
        int i9;
        label236:
        int i10;
        label252:
        int i11;
        label268:
        int i12;
        label284:
        int i13;
        label300:
        int i14;
        label316:
        int i15;
        label332:
        int i16;
        label348:
        int i17;
        label364:
        int i18;
        label380:
        int i36;
        int i19;
        label402:
        int i37;
        int i20;
        label427:
        int i21;
        label437:
        int i22;
        label447:
        int i23;
        label457:
        int i24;
        label467:
        int i25;
        label477:
        int i26;
        label487:
        int i27;
        label497:
        int i28;
        label507:
        int i29;
        label523:
        int i30;
        label539:
        int i31;
        if (this.debug) {
            i = 1;
            if (this.user == null) {
                break label813;
            }
            j = this.user.hashCode();
            if (this.password == null) {
                break label818;
            }
            k = this.password.hashCode();
            if (this.httpConf == null) {
                break label823;
            }
            m = this.httpConf.hashCode();
            i33 = this.httpStreamingReadTimeout;
            i34 = this.httpRetryCount;
            i35 = this.httpRetryIntervalSeconds;
            if (this.oAuthConsumerKey == null) {
                break label829;
            }
            n = this.oAuthConsumerKey.hashCode();
            if (this.oAuthConsumerSecret == null) {
                break label835;
            }
            i1 = this.oAuthConsumerSecret.hashCode();
            if (this.oAuthAccessToken == null) {
                break label841;
            }
            i2 = this.oAuthAccessToken.hashCode();
            if (this.oAuthAccessTokenSecret == null) {
                break label847;
            }
            i3 = this.oAuthAccessTokenSecret.hashCode();
            if (this.oAuth2TokenType == null) {
                break label853;
            }
            i4 = this.oAuth2TokenType.hashCode();
            if (this.oAuth2AccessToken == null) {
                break label859;
            }
            i5 = this.oAuth2AccessToken.hashCode();
            if (this.oAuth2Scope == null) {
                break label865;
            }
            i6 = this.oAuth2Scope.hashCode();
            if (this.oAuthRequestTokenURL == null) {
                break label871;
            }
            i7 = this.oAuthRequestTokenURL.hashCode();
            if (this.oAuthAuthorizationURL == null) {
                break label877;
            }
            i8 = this.oAuthAuthorizationURL.hashCode();
            if (this.oAuthAccessTokenURL == null) {
                break label883;
            }
            i9 = this.oAuthAccessTokenURL.hashCode();
            if (this.oAuthAuthenticationURL == null) {
                break label889;
            }
            i10 = this.oAuthAuthenticationURL.hashCode();
            if (this.oAuth2TokenURL == null) {
                break label895;
            }
            i11 = this.oAuth2TokenURL.hashCode();
            if (this.oAuth2InvalidateTokenURL == null) {
                break label901;
            }
            i12 = this.oAuth2InvalidateTokenURL.hashCode();
            if (this.restBaseURL == null) {
                break label907;
            }
            i13 = this.restBaseURL.hashCode();
            if (this.uploadBaseURL == null) {
                break label913;
            }
            i14 = this.uploadBaseURL.hashCode();
            if (this.streamBaseURL == null) {
                break label919;
            }
            i15 = this.streamBaseURL.hashCode();
            if (this.userStreamBaseURL == null) {
                break label925;
            }
            i16 = this.userStreamBaseURL.hashCode();
            if (this.siteStreamBaseURL == null) {
                break label931;
            }
            i17 = this.siteStreamBaseURL.hashCode();
            if (this.dispatcherImpl == null) {
                break label937;
            }
            i18 = this.dispatcherImpl.hashCode();
            i36 = this.asyncNumThreads;
            if (this.loggerFactory == null) {
                break label943;
            }
            i19 = this.loggerFactory.hashCode();
            i37 = (int) (this.contributingTo ^ this.contributingTo >>> 32);
            if (!this.includeMyRetweetEnabled) {
                break label949;
            }
            i20 = 1;
            if (!this.includeEntitiesEnabled) {
                break label955;
            }
            i21 = 1;
            if (!this.trimUserEnabled) {
                break label961;
            }
            i22 = 1;
            if (!this.jsonStoreEnabled) {
                break label967;
            }
            i23 = 1;
            if (!this.mbeanEnabled) {
                break label973;
            }
            i24 = 1;
            if (!this.userStreamRepliesAllEnabled) {
                break label979;
            }
            i25 = 1;
            if (!this.userStreamWithFollowingsEnabled) {
                break label985;
            }
            i26 = 1;
            if (!this.stallWarningsEnabled) {
                break label991;
            }
            i27 = 1;
            if (!this.applicationOnlyAuthEnabled) {
                break label997;
            }
            i28 = 1;
            if (this.mediaProvider == null) {
                break label1003;
            }
            i29 = this.mediaProvider.hashCode();
            if (this.mediaProviderAPIKey == null) {
                break label1009;
            }
            i30 = this.mediaProviderAPIKey.hashCode();
            if (this.mediaProviderParameters == null) {
                break label1015;
            }
            i31 = this.mediaProviderParameters.hashCode();
            label555:
            if (!this.daemonEnabled) {
                break label1021;
            }
        }
        for (; ; ) {
            return (i31 + (i30 + (i29 + (i28 + (i27 + (i26 + (i25 + (i24 + (i23 + (i22 + (i21 + (i20 + ((i19 + ((i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + ((((m + (k + (j + i * 31) * 31) * 31) * 31 + i33) * 31 + i34) * 31 + i35) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i36) * 31) * 31 + i37) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i32;
            i = 0;
            break;
            label813:
            j = 0;
            break label27;
            label818:
            k = 0;
            break label42;
            label823:
            m = 0;
            break label58;
            label829:
            n = 0;
            break label92;
            label835:
            i1 = 0;
            break label108;
            label841:
            i2 = 0;
            break label124;
            label847:
            i3 = 0;
            break label140;
            label853:
            i4 = 0;
            break label156;
            label859:
            i5 = 0;
            break label172;
            label865:
            i6 = 0;
            break label188;
            label871:
            i7 = 0;
            break label204;
            label877:
            i8 = 0;
            break label220;
            label883:
            i9 = 0;
            break label236;
            label889:
            i10 = 0;
            break label252;
            label895:
            i11 = 0;
            break label268;
            label901:
            i12 = 0;
            break label284;
            label907:
            i13 = 0;
            break label300;
            label913:
            i14 = 0;
            break label316;
            label919:
            i15 = 0;
            break label332;
            label925:
            i16 = 0;
            break label348;
            label931:
            i17 = 0;
            break label364;
            label937:
            i18 = 0;
            break label380;
            label943:
            i19 = 0;
            break label402;
            label949:
            i20 = 0;
            break label427;
            label955:
            i21 = 0;
            break label437;
            label961:
            i22 = 0;
            break label447;
            label967:
            i23 = 0;
            break label457;
            label973:
            i24 = 0;
            break label467;
            label979:
            i25 = 0;
            break label477;
            label985:
            i26 = 0;
            break label487;
            label991:
            i27 = 0;
            break label497;
            label997:
            i28 = 0;
            break label507;
            label1003:
            i29 = 0;
            break label523;
            label1009:
            i30 = 0;
            break label539;
            label1015:
            i31 = 0;
            break label555;
            label1021:
            i32 = 0;
        }
    }

    public boolean isApplicationOnlyAuthEnabled() {
        return this.applicationOnlyAuthEnabled;
    }

    public boolean isDaemonEnabled() {
        return this.daemonEnabled;
    }

    public final boolean isDebugEnabled() {
        return this.debug;
    }

    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }

    public boolean isIncludeMyRetweetEnabled() {
        return this.includeMyRetweetEnabled;
    }

    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }

    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
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

    public boolean isUserStreamWithFollowingsEnabled() {
        return this.userStreamWithFollowingsEnabled;
    }

    protected Object readResolve() {
        return getInstance(this);
    }

    protected final void setApplicationOnlyAuthEnabled(boolean paramBoolean) {
        this.applicationOnlyAuthEnabled = paramBoolean;
    }

    protected final void setAsyncNumThreads(int paramInt) {
        this.asyncNumThreads = paramInt;
    }

    protected final void setContributingTo(long paramLong) {
        this.contributingTo = paramLong;
    }

    protected void setDaemonEnabled(boolean paramBoolean) {
        this.daemonEnabled = paramBoolean;
    }

    protected final void setDebug(boolean paramBoolean) {
        this.debug = paramBoolean;
    }

    protected final void setDispatcherImpl(String paramString) {
        this.dispatcherImpl = paramString;
    }

    protected final void setGZIPEnabled(boolean paramBoolean) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), paramBoolean);
    }

    protected final void setHttpConnectionTimeout(int paramInt) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), paramInt, this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    protected final void setHttpProxyHost(String paramString) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, paramString, this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    protected final void setHttpProxyPassword(String paramString) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), paramString, this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    protected final void setHttpProxyPort(int paramInt) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), paramInt, this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    protected final void setHttpProxyUser(String paramString) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, this.httpConf.getHttpProxyHost(), paramString, this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    protected final void setHttpReadTimeout(int paramInt) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), paramInt, this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
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

    protected void setIncludeEntitiesEnabled(boolean paramBoolean) {
        this.includeEntitiesEnabled = paramBoolean;
    }

    public void setIncludeMyRetweetEnabled(boolean paramBoolean) {
        this.includeMyRetweetEnabled = paramBoolean;
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
    }

    protected final void setOAuth2Scope(String paramString) {
        this.oAuth2Scope = paramString;
    }

    protected final void setOAuth2TokenType(String paramString) {
        this.oAuth2TokenType = paramString;
    }

    protected final void setOAuth2TokenURL(String paramString) {
        this.oAuth2TokenURL = paramString;
    }

    protected final void setOAuthAccessToken(String paramString) {
        this.oAuthAccessToken = paramString;
    }

    protected final void setOAuthAccessTokenSecret(String paramString) {
        this.oAuthAccessTokenSecret = paramString;
    }

    protected final void setOAuthAccessTokenURL(String paramString) {
        this.oAuthAccessTokenURL = paramString;
    }

    protected final void setOAuthAuthenticationURL(String paramString) {
        this.oAuthAuthenticationURL = paramString;
    }

    protected final void setOAuthAuthorizationURL(String paramString) {
        this.oAuthAuthorizationURL = paramString;
    }

    protected final void setOAuthConsumerKey(String paramString) {
        this.oAuthConsumerKey = paramString;
    }

    protected final void setOAuthConsumerSecret(String paramString) {
        this.oAuthConsumerSecret = paramString;
    }

    protected final void setOAuthRequestTokenURL(String paramString) {
        this.oAuthRequestTokenURL = paramString;
    }

    protected final void setPassword(String paramString) {
        this.password = paramString;
    }

    protected final void setPrettyDebugEnabled(boolean paramBoolean) {
        this.httpConf = new ConfigurationBase.MyHttpClientConfiguration(this, this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), paramBoolean, this.httpConf.isGZIPEnabled());
    }

    protected final void setRestBaseURL(String paramString) {
        this.restBaseURL = paramString;
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

    protected final void setUploadBaseURL(String paramString) {
        this.uploadBaseURL = paramString;
    }

    protected final void setUser(String paramString) {
        this.user = paramString;
    }

    protected final void setUserStreamBaseURL(String paramString) {
        this.userStreamBaseURL = paramString;
    }

    protected final void setUserStreamRepliesAllEnabled(boolean paramBoolean) {
        this.userStreamRepliesAllEnabled = paramBoolean;
    }

    protected final void setUserStreamWithFollowingsEnabled(boolean paramBoolean) {
        this.userStreamWithFollowingsEnabled = paramBoolean;
    }

    public String toString() {
        return "ConfigurationBase{debug=" + this.debug + ", user='" + this.user + '\'' + ", password='" + this.password + '\'' + ", httpConf=" + this.httpConf + ", httpStreamingReadTimeout=" + this.httpStreamingReadTimeout + ", httpRetryCount=" + this.httpRetryCount + ", httpRetryIntervalSeconds=" + this.httpRetryIntervalSeconds + ", oAuthConsumerKey='" + this.oAuthConsumerKey + '\'' + ", oAuthConsumerSecret='" + this.oAuthConsumerSecret + '\'' + ", oAuthAccessToken='" + this.oAuthAccessToken + '\'' + ", oAuthAccessTokenSecret='" + this.oAuthAccessTokenSecret + '\'' + ", oAuth2TokenType='" + this.oAuth2TokenType + '\'' + ", oAuth2AccessToken='" + this.oAuth2AccessToken + '\'' + ", oAuth2Scope='" + this.oAuth2Scope + '\'' + ", oAuthRequestTokenURL='" + this.oAuthRequestTokenURL + '\'' + ", oAuthAuthorizationURL='" + this.oAuthAuthorizationURL + '\'' + ", oAuthAccessTokenURL='" + this.oAuthAccessTokenURL + '\'' + ", oAuthAuthenticationURL='" + this.oAuthAuthenticationURL + '\'' + ", oAuth2TokenURL='" + this.oAuth2TokenURL + '\'' + ", oAuth2InvalidateTokenURL='" + this.oAuth2InvalidateTokenURL + '\'' + ", restBaseURL='" + this.restBaseURL + '\'' + ", uploadBaseURL='" + this.uploadBaseURL + '\'' + ", streamBaseURL='" + this.streamBaseURL + '\'' + ", userStreamBaseURL='" + this.userStreamBaseURL + '\'' + ", siteStreamBaseURL='" + this.siteStreamBaseURL + '\'' + ", dispatcherImpl='" + this.dispatcherImpl + '\'' + ", asyncNumThreads=" + this.asyncNumThreads + ", loggerFactory='" + this.loggerFactory + '\'' + ", contributingTo=" + this.contributingTo + ", includeMyRetweetEnabled=" + this.includeMyRetweetEnabled + ", includeEntitiesEnabled=" + this.includeEntitiesEnabled + ", trimUserEnabled=" + this.trimUserEnabled + ", jsonStoreEnabled=" + this.jsonStoreEnabled + ", mbeanEnabled=" + this.mbeanEnabled + ", userStreamRepliesAllEnabled=" + this.userStreamRepliesAllEnabled + ", userStreamWithFollowingsEnabled=" + this.userStreamWithFollowingsEnabled + ", stallWarningsEnabled=" + this.stallWarningsEnabled + ", applicationOnlyAuthEnabled=" + this.applicationOnlyAuthEnabled + ", mediaProvider='" + this.mediaProvider + '\'' + ", mediaProviderAPIKey='" + this.mediaProviderAPIKey + '\'' + ", mediaProviderParameters=" + this.mediaProviderParameters + ", daemonEnabled=" + this.daemonEnabled + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/conf/ConfigurationBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
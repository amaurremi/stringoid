package twitter4j.conf;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;
import twitter4j.auth.AuthorizationConfiguration;
import twitter4j.internal.http.HttpClientConfiguration;
import twitter4j.internal.http.HttpClientWrapperConfiguration;

public abstract interface Configuration
  extends Serializable, AuthorizationConfiguration, HttpClientConfiguration, HttpClientWrapperConfiguration
{
  public abstract int getAsyncNumThreads();
  
  public abstract String getClientURL();
  
  public abstract String getClientVersion();
  
  public abstract long getContributingTo();
  
  public abstract String getDispatcherImpl();
  
  public abstract int getHttpConnectionTimeout();
  
  public abstract int getHttpDefaultMaxPerRoute();
  
  public abstract int getHttpMaxTotalConnections();
  
  public abstract String getHttpProxyHost();
  
  public abstract String getHttpProxyPassword();
  
  public abstract int getHttpProxyPort();
  
  public abstract String getHttpProxyUser();
  
  public abstract int getHttpReadTimeout();
  
  public abstract int getHttpRetryCount();
  
  public abstract int getHttpRetryIntervalSeconds();
  
  public abstract int getHttpStreamingReadTimeout();
  
  public abstract String getLoggerFactory();
  
  public abstract String getMediaProvider();
  
  public abstract String getMediaProviderAPIKey();
  
  public abstract Properties getMediaProviderParameters();
  
  public abstract String getOAuth2AccessToken();
  
  public abstract String getOAuth2InvalidateTokenURL();
  
  public abstract String getOAuth2TokenType();
  
  public abstract String getOAuth2TokenURL();
  
  public abstract String getOAuthAccessToken();
  
  public abstract String getOAuthAccessTokenSecret();
  
  public abstract String getOAuthAccessTokenURL();
  
  public abstract String getOAuthAuthenticationURL();
  
  public abstract String getOAuthAuthorizationURL();
  
  public abstract String getOAuthConsumerKey();
  
  public abstract String getOAuthConsumerSecret();
  
  public abstract String getOAuthRequestTokenURL();
  
  public abstract String getPassword();
  
  public abstract Map getRequestHeaders();
  
  public abstract String getRestBaseURL();
  
  public abstract String getSiteStreamBaseURL();
  
  public abstract String getStreamBaseURL();
  
  public abstract String getUser();
  
  public abstract String getUserAgent();
  
  public abstract String getUserStreamBaseURL();
  
  public abstract boolean isApplicationOnlyAuthEnabled();
  
  public abstract boolean isDalvik();
  
  public abstract boolean isDebugEnabled();
  
  public abstract boolean isGAE();
  
  public abstract boolean isIncludeEntitiesEnabled();
  
  public abstract boolean isIncludeMyRetweetEnabled();
  
  public abstract boolean isIncludeRTsEnabled();
  
  public abstract boolean isJSONStoreEnabled();
  
  public abstract boolean isMBeanEnabled();
  
  public abstract boolean isStallWarningsEnabled();
  
  public abstract boolean isTrimUserEnabled();
  
  public abstract boolean isUserStreamRepliesAllEnabled();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/conf/Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
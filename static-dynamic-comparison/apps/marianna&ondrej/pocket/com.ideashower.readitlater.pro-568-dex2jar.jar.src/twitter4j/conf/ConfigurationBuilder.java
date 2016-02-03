package twitter4j.conf;

import java.util.Properties;

public final class ConfigurationBuilder
{
  private ConfigurationBase configurationBean = new PropertyConfiguration();
  
  private void checkNotBuilt()
  {
    if (this.configurationBean == null) {
      throw new IllegalStateException("Cannot use this builder any longer, build() has already been called");
    }
  }
  
  public Configuration build()
  {
    checkNotBuilt();
    this.configurationBean.cacheInstance();
    try
    {
      ConfigurationBase localConfigurationBase = this.configurationBean;
      return localConfigurationBase;
    }
    finally
    {
      this.configurationBean = null;
    }
  }
  
  public ConfigurationBuilder setApplicationOnlyAuthEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setApplicationOnlyAuthEnabled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setAsyncNumThreads(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setAsyncNumThreads(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setClientURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setClientURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setClientVersion(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setClientVersion(paramString);
    return this;
  }
  
  public ConfigurationBuilder setContributingTo(long paramLong)
  {
    checkNotBuilt();
    this.configurationBean.setContributingTo(paramLong);
    return this;
  }
  
  public ConfigurationBuilder setDebugEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setDebug(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setDispatcherImpl(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setDispatcherImpl(paramString);
    return this;
  }
  
  public ConfigurationBuilder setGZIPEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setGZIPEnabled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setHttpConnectionTimeout(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpConnectionTimeout(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setHttpDefaultMaxPerRoute(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpDefaultMaxPerRoute(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setHttpMaxTotalConnections(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpMaxTotalConnections(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setHttpProxyHost(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setHttpProxyHost(paramString);
    return this;
  }
  
  public ConfigurationBuilder setHttpProxyPassword(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setHttpProxyPassword(paramString);
    return this;
  }
  
  public ConfigurationBuilder setHttpProxyPort(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpProxyPort(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setHttpProxyUser(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setHttpProxyUser(paramString);
    return this;
  }
  
  public ConfigurationBuilder setHttpReadTimeout(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpReadTimeout(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setHttpRetryCount(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpRetryCount(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setHttpRetryIntervalSeconds(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpRetryIntervalSeconds(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setHttpStreamingReadTimeout(int paramInt)
  {
    checkNotBuilt();
    this.configurationBean.setHttpStreamingReadTimeout(paramInt);
    return this;
  }
  
  public ConfigurationBuilder setIncludeEntitiesEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setIncludeEntitiesEnbled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setIncludeMyRetweetEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setIncludeMyRetweetEnabled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setIncludeRTsEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setIncludeRTsEnbled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setJSONStoreEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setJSONStoreEnabled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setMBeanEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setMBeanEnabled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setMediaProvider(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setMediaProvider(paramString);
    return this;
  }
  
  public ConfigurationBuilder setMediaProviderAPIKey(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setMediaProviderAPIKey(paramString);
    return this;
  }
  
  public ConfigurationBuilder setMediaProviderParameters(Properties paramProperties)
  {
    checkNotBuilt();
    this.configurationBean.setMediaProviderParameters(paramProperties);
    return this;
  }
  
  public ConfigurationBuilder setOAuth2AccessToken(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuth2AccessToken(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuth2InvalidateTokenURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuth2InvalidateTokenURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuth2TokenType(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuth2TokenType(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuth2TokenURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuth2TokenURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthAccessToken(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthAccessToken(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthAccessTokenSecret(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthAccessTokenSecret(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthAccessTokenURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthAccessTokenURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthAuthenticationURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthAuthenticationURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthAuthorizationURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthAuthorizationURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthConsumerKey(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthConsumerKey(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthConsumerSecret(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthConsumerSecret(paramString);
    return this;
  }
  
  public ConfigurationBuilder setOAuthRequestTokenURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setOAuthRequestTokenURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setPassword(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setPassword(paramString);
    return this;
  }
  
  public ConfigurationBuilder setPrettyDebugEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setPrettyDebugEnabled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setRestBaseURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setRestBaseURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setSiteStreamBaseURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setSiteStreamBaseURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setStreamBaseURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setStreamBaseURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setTrimUserEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setTrimUserEnabled(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setUseSSL(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setUseSSL(paramBoolean);
    return this;
  }
  
  public ConfigurationBuilder setUser(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setUser(paramString);
    return this;
  }
  
  public ConfigurationBuilder setUserStreamBaseURL(String paramString)
  {
    checkNotBuilt();
    this.configurationBean.setUserStreamBaseURL(paramString);
    return this;
  }
  
  public ConfigurationBuilder setUserStreamRepliesAllEnabled(boolean paramBoolean)
  {
    checkNotBuilt();
    this.configurationBean.setUserStreamRepliesAllEnabled(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/conf/ConfigurationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
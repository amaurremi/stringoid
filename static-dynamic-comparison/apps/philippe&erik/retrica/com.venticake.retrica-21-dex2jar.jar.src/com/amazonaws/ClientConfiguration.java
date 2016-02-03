package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import java.net.InetAddress;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ClientConfiguration
{
  public static final RetryPolicy DEFAULT_RETRY_POLICY = PredefinedRetryPolicies.DEFAULT;
  public static final String DEFAULT_USER_AGENT = ;
  private int connectionTimeout = 50000;
  private InetAddress localAddress;
  private int maxConnections = 50;
  private int maxErrorRetry = -1;
  private boolean preemptiveBasicProxyAuth;
  private Protocol protocol = Protocol.HTTPS;
  private String proxyDomain = null;
  private String proxyHost = null;
  private String proxyPassword = null;
  private int proxyPort = -1;
  private String proxyUsername = null;
  private String proxyWorkstation = null;
  private RetryPolicy retryPolicy = DEFAULT_RETRY_POLICY;
  private String signerOverride;
  private int socketReceiveBufferSizeHint = 0;
  private int socketSendBufferSizeHint = 0;
  private int socketTimeout = 50000;
  private boolean useReaper = true;
  private String userAgent = DEFAULT_USER_AGENT;
  
  public ClientConfiguration() {}
  
  public ClientConfiguration(ClientConfiguration paramClientConfiguration)
  {
    this.connectionTimeout = paramClientConfiguration.connectionTimeout;
    this.maxConnections = paramClientConfiguration.maxConnections;
    this.maxErrorRetry = paramClientConfiguration.maxErrorRetry;
    this.retryPolicy = paramClientConfiguration.retryPolicy;
    this.localAddress = paramClientConfiguration.localAddress;
    this.protocol = paramClientConfiguration.protocol;
    this.proxyDomain = paramClientConfiguration.proxyDomain;
    this.proxyHost = paramClientConfiguration.proxyHost;
    this.proxyPassword = paramClientConfiguration.proxyPassword;
    this.proxyPort = paramClientConfiguration.proxyPort;
    this.proxyUsername = paramClientConfiguration.proxyUsername;
    this.proxyWorkstation = paramClientConfiguration.proxyWorkstation;
    this.preemptiveBasicProxyAuth = paramClientConfiguration.preemptiveBasicProxyAuth;
    this.socketTimeout = paramClientConfiguration.socketTimeout;
    this.userAgent = paramClientConfiguration.userAgent;
    this.useReaper = paramClientConfiguration.useReaper;
    this.socketReceiveBufferSizeHint = paramClientConfiguration.socketReceiveBufferSizeHint;
    this.socketSendBufferSizeHint = paramClientConfiguration.socketSendBufferSizeHint;
    this.signerOverride = paramClientConfiguration.signerOverride;
  }
  
  public int getConnectionTimeout()
  {
    return this.connectionTimeout;
  }
  
  public InetAddress getLocalAddress()
  {
    return this.localAddress;
  }
  
  public int getMaxConnections()
  {
    return this.maxConnections;
  }
  
  public int getMaxErrorRetry()
  {
    return this.maxErrorRetry;
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  public String getProxyDomain()
  {
    return this.proxyDomain;
  }
  
  public String getProxyHost()
  {
    return this.proxyHost;
  }
  
  public String getProxyPassword()
  {
    return this.proxyPassword;
  }
  
  public int getProxyPort()
  {
    return this.proxyPort;
  }
  
  public String getProxyUsername()
  {
    return this.proxyUsername;
  }
  
  public String getProxyWorkstation()
  {
    return this.proxyWorkstation;
  }
  
  public RetryPolicy getRetryPolicy()
  {
    return this.retryPolicy;
  }
  
  public String getSignerOverride()
  {
    return this.signerOverride;
  }
  
  public int[] getSocketBufferSizeHints()
  {
    return new int[] { this.socketSendBufferSizeHint, this.socketReceiveBufferSizeHint };
  }
  
  public int getSocketTimeout()
  {
    return this.socketTimeout;
  }
  
  public String getUserAgent()
  {
    return this.userAgent;
  }
  
  public boolean isPreemptiveBasicProxyAuth()
  {
    return this.preemptiveBasicProxyAuth;
  }
  
  public boolean useReaper()
  {
    return this.useReaper;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/ClientConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
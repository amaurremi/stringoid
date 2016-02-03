package com.amazonaws.org.apache.http.auth;

import java.util.Queue;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class AuthState
{
  private Queue<AuthOption> authOptions;
  private AuthScheme authScheme;
  private AuthScope authScope;
  private Credentials credentials;
  private AuthProtocolState state = AuthProtocolState.UNCHALLENGED;
  
  public Queue<AuthOption> getAuthOptions()
  {
    return this.authOptions;
  }
  
  public AuthScheme getAuthScheme()
  {
    return this.authScheme;
  }
  
  public Credentials getCredentials()
  {
    return this.credentials;
  }
  
  public AuthProtocolState getState()
  {
    return this.state;
  }
  
  public void reset()
  {
    this.state = AuthProtocolState.UNCHALLENGED;
    this.authOptions = null;
    this.authScheme = null;
    this.authScope = null;
    this.credentials = null;
  }
  
  public void setState(AuthProtocolState paramAuthProtocolState)
  {
    if (paramAuthProtocolState != null) {}
    for (;;)
    {
      this.state = paramAuthProtocolState;
      return;
      paramAuthProtocolState = AuthProtocolState.UNCHALLENGED;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state:").append(this.state).append(";");
    if (this.authScheme != null) {
      localStringBuilder.append("auth scheme:").append(this.authScheme.getSchemeName()).append(";");
    }
    if (this.credentials != null) {
      localStringBuilder.append("credentials present");
    }
    return localStringBuilder.toString();
  }
  
  public void update(AuthScheme paramAuthScheme, Credentials paramCredentials)
  {
    if (paramAuthScheme == null) {
      throw new IllegalArgumentException("Auth scheme may not be null or empty");
    }
    if (paramCredentials == null) {
      throw new IllegalArgumentException("Credentials may not be null or empty");
    }
    this.authScheme = paramAuthScheme;
    this.credentials = paramCredentials;
    this.authOptions = null;
  }
  
  public void update(Queue<AuthOption> paramQueue)
  {
    if ((paramQueue == null) || (paramQueue.isEmpty())) {
      throw new IllegalArgumentException("Queue of auth options may not be null or empty");
    }
    this.authOptions = paramQueue;
    this.authScheme = null;
    this.credentials = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/AuthState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.amazonaws.org.apache.http.auth;

import org.apache.http.annotation.Immutable;

@Immutable
public final class AuthOption
{
  private final AuthScheme authScheme;
  private final Credentials creds;
  
  public AuthOption(AuthScheme paramAuthScheme, Credentials paramCredentials)
  {
    if (paramAuthScheme == null) {
      throw new IllegalArgumentException("Auth scheme may not be null");
    }
    if (paramCredentials == null) {
      throw new IllegalArgumentException("User credentials may not be null");
    }
    this.authScheme = paramAuthScheme;
    this.creds = paramCredentials;
  }
  
  public AuthScheme getAuthScheme()
  {
    return this.authScheme;
  }
  
  public Credentials getCredentials()
  {
    return this.creds;
  }
  
  public String toString()
  {
    return this.authScheme.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/AuthOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
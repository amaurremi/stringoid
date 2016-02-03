package com.amazonaws.org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;

@Immutable
public class ProxyAuthenticationStrategy
  extends AuthenticationStrategyImpl
{
  public ProxyAuthenticationStrategy()
  {
    super(407, "Proxy-Authenticate", "http.auth.proxy-scheme-pref");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/ProxyAuthenticationStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
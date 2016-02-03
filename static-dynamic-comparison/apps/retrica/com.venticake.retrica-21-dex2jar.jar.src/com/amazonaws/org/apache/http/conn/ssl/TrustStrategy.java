package com.amazonaws.org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;

public abstract interface TrustStrategy
{
  public abstract boolean isTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ssl/TrustStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
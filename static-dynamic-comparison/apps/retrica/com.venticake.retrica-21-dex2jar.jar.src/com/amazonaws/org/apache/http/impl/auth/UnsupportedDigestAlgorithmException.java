package com.amazonaws.org.apache.http.impl.auth;

import org.apache.http.annotation.Immutable;

@Immutable
public class UnsupportedDigestAlgorithmException
  extends RuntimeException
{
  public UnsupportedDigestAlgorithmException() {}
  
  public UnsupportedDigestAlgorithmException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/UnsupportedDigestAlgorithmException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
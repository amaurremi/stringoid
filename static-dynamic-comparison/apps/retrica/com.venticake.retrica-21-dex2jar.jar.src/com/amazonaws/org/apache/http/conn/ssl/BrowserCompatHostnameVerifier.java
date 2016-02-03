package com.amazonaws.org.apache.http.conn.ssl;

import org.apache.http.annotation.Immutable;

@Immutable
public class BrowserCompatHostnameVerifier
  extends AbstractVerifier
{
  public final String toString()
  {
    return "BROWSER_COMPATIBLE";
  }
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    verify(paramString, paramArrayOfString1, paramArrayOfString2, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ssl/BrowserCompatHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.amazonaws.org.apache.http.auth.params;

import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HTTP;
import java.nio.charset.Charset;
import org.apache.http.annotation.Immutable;

@Immutable
public final class AuthParams
{
  public static String getCredentialCharset(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    String str = (String)paramHttpParams.getParameter("http.auth.credential-charset");
    paramHttpParams = str;
    if (str == null) {
      paramHttpParams = HTTP.DEF_PROTOCOL_CHARSET.name();
    }
    return paramHttpParams;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/auth/params/AuthParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
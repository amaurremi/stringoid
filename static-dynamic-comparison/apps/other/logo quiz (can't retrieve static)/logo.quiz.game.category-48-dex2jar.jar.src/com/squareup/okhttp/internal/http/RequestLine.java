package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import java.net.Proxy.Type;
import java.net.URL;

public final class RequestLine
{
  static String get(Request paramRequest, Proxy.Type paramType, Protocol paramProtocol)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRequest.method());
    localStringBuilder.append(' ');
    if (includeAuthorityInRequestLine(paramRequest, paramType)) {
      localStringBuilder.append(paramRequest.url());
    }
    for (;;)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(version(paramProtocol));
      return localStringBuilder.toString();
      localStringBuilder.append(requestPath(paramRequest.url()));
    }
  }
  
  private static boolean includeAuthorityInRequestLine(Request paramRequest, Proxy.Type paramType)
  {
    return (!paramRequest.isHttps()) && (paramType == Proxy.Type.HTTP);
  }
  
  public static String requestPath(URL paramURL)
  {
    String str = paramURL.getFile();
    if (str == null) {
      paramURL = "/";
    }
    do
    {
      return paramURL;
      paramURL = str;
    } while (str.startsWith("/"));
    return "/" + str;
  }
  
  public static String version(Protocol paramProtocol)
  {
    if (paramProtocol == Protocol.HTTP_1_0) {
      return "HTTP/1.0";
    }
    return "HTTP/1.1";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/http/RequestLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.amazonaws.org.apache.http.params;

import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.protocol.HTTP;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

public final class HttpProtocolParams
{
  public static String getHttpElementCharset(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    String str = (String)paramHttpParams.getParameter("http.protocol.element-charset");
    paramHttpParams = str;
    if (str == null) {
      paramHttpParams = HTTP.DEF_PROTOCOL_CHARSET.name();
    }
    return paramHttpParams;
  }
  
  public static CodingErrorAction getMalformedInputAction(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams = paramHttpParams.getParameter("http.malformed.input.action");
    if (paramHttpParams == null) {
      return CodingErrorAction.REPORT;
    }
    return (CodingErrorAction)paramHttpParams;
  }
  
  public static CodingErrorAction getUnmappableInputAction(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams = paramHttpParams.getParameter("http.unmappable.input.action");
    if (paramHttpParams == null) {
      return CodingErrorAction.REPORT;
    }
    return (CodingErrorAction)paramHttpParams;
  }
  
  public static String getUserAgent(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return (String)paramHttpParams.getParameter("http.useragent");
  }
  
  public static ProtocolVersion getVersion(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams = paramHttpParams.getParameter("http.protocol.version");
    if (paramHttpParams == null) {
      return HttpVersion.HTTP_1_1;
    }
    return (ProtocolVersion)paramHttpParams;
  }
  
  public static void setContentCharset(HttpParams paramHttpParams, String paramString)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setParameter("http.protocol.content-charset", paramString);
  }
  
  public static void setUserAgent(HttpParams paramHttpParams, String paramString)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setParameter("http.useragent", paramString);
  }
  
  public static void setVersion(HttpParams paramHttpParams, ProtocolVersion paramProtocolVersion)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setParameter("http.protocol.version", paramProtocolVersion);
  }
  
  public static boolean useExpectContinue(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getBooleanParameter("http.protocol.expect-continue", false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/params/HttpProtocolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
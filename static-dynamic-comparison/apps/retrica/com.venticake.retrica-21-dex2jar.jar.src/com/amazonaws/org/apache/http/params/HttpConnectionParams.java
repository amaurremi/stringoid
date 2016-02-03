package com.amazonaws.org.apache.http.params;

public final class HttpConnectionParams
{
  public static int getConnectionTimeout(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getIntParameter("http.connection.timeout", 0);
  }
  
  public static int getLinger(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getIntParameter("http.socket.linger", -1);
  }
  
  public static boolean getSoReuseaddr(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getBooleanParameter("http.socket.reuseaddr", false);
  }
  
  public static int getSoTimeout(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getIntParameter("http.socket.timeout", 0);
  }
  
  public static int getSocketBufferSize(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getIntParameter("http.socket.buffer-size", -1);
  }
  
  public static boolean getTcpNoDelay(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getBooleanParameter("http.tcp.nodelay", true);
  }
  
  public static boolean isStaleCheckingEnabled(HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    return paramHttpParams.getBooleanParameter("http.connection.stalecheck", true);
  }
  
  public static void setConnectionTimeout(HttpParams paramHttpParams, int paramInt)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setIntParameter("http.connection.timeout", paramInt);
  }
  
  public static void setSoTimeout(HttpParams paramHttpParams, int paramInt)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setIntParameter("http.socket.timeout", paramInt);
  }
  
  public static void setSocketBufferSize(HttpParams paramHttpParams, int paramInt)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setIntParameter("http.socket.buffer-size", paramInt);
  }
  
  public static void setStaleCheckingEnabled(HttpParams paramHttpParams, boolean paramBoolean)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setBooleanParameter("http.connection.stalecheck", paramBoolean);
  }
  
  public static void setTcpNoDelay(HttpParams paramHttpParams, boolean paramBoolean)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    paramHttpParams.setBooleanParameter("http.tcp.nodelay", paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/params/HttpConnectionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
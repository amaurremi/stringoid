package com.amazonaws.org.apache.http;

import com.amazonaws.org.apache.http.params.HttpParams;

public abstract interface HttpMessage
{
  public abstract void addHeader(Header paramHeader);
  
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract boolean containsHeader(String paramString);
  
  public abstract Header[] getAllHeaders();
  
  public abstract Header getFirstHeader(String paramString);
  
  public abstract Header[] getHeaders(String paramString);
  
  public abstract HttpParams getParams();
  
  public abstract ProtocolVersion getProtocolVersion();
  
  public abstract HeaderIterator headerIterator();
  
  public abstract HeaderIterator headerIterator(String paramString);
  
  public abstract void removeHeaders(String paramString);
  
  public abstract void setHeader(String paramString1, String paramString2);
  
  public abstract void setHeaders(Header[] paramArrayOfHeader);
  
  public abstract void setParams(HttpParams paramHttpParams);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/HttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
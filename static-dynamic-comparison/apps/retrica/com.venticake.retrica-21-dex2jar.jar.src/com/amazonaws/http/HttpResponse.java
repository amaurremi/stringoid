package com.amazonaws.http;

import com.amazonaws.Request;
import com.amazonaws.org.apache.http.client.methods.HttpRequestBase;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse
{
  private InputStream content;
  private Map<String, String> headers = new HashMap();
  private final HttpRequestBase httpRequest;
  private final Request<?> request;
  private int statusCode;
  private String statusText;
  
  public HttpResponse(Request<?> paramRequest, HttpRequestBase paramHttpRequestBase)
  {
    this.request = paramRequest;
    this.httpRequest = paramHttpRequestBase;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
  }
  
  public InputStream getContent()
  {
    return this.content;
  }
  
  public Map<String, String> getHeaders()
  {
    return this.headers;
  }
  
  public Request<?> getRequest()
  {
    return this.request;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String getStatusText()
  {
    return this.statusText;
  }
  
  public void setContent(InputStream paramInputStream)
  {
    this.content = paramInputStream;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public void setStatusText(String paramString)
  {
    this.statusText = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
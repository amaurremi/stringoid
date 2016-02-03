package com.parse.signpost.commonshttp;

import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpRequestAdapter
  implements HttpRequest
{
  private HttpEntity entity;
  private HttpUriRequest request;
  
  public HttpRequestAdapter(HttpUriRequest paramHttpUriRequest)
  {
    this.request = paramHttpUriRequest;
    if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest)) {
      this.entity = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
    }
  }
  
  public Map<String, String> getAllHeaders()
  {
    Header[] arrayOfHeader = this.request.getAllHeaders();
    HashMap localHashMap = new HashMap();
    int j = arrayOfHeader.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localHashMap;
      }
      Header localHeader = arrayOfHeader[i];
      localHashMap.put(localHeader.getName(), localHeader.getValue());
      i += 1;
    }
  }
  
  public String getContentType()
  {
    if (this.entity == null) {}
    Header localHeader;
    do
    {
      return null;
      localHeader = this.entity.getContentType();
    } while (localHeader == null);
    return localHeader.getValue();
  }
  
  public String getHeader(String paramString)
  {
    paramString = this.request.getFirstHeader(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getValue();
  }
  
  public InputStream getMessagePayload()
    throws IOException
  {
    if (this.entity == null) {
      return null;
    }
    return this.entity.getContent();
  }
  
  public String getMethod()
  {
    return this.request.getRequestLine().getMethod();
  }
  
  public String getRequestUrl()
  {
    return this.request.getURI().toString();
  }
  
  public void setHeader(String paramString1, String paramString2)
  {
    this.request.setHeader(paramString1, paramString2);
  }
  
  public void setRequestUrl(String paramString)
  {
    throw new RuntimeException(new UnsupportedOperationException());
  }
  
  public Object unwrap()
  {
    return this.request;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/commonshttp/HttpRequestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
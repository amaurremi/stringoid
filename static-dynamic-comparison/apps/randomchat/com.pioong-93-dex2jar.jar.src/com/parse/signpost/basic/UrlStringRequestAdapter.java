package com.parse.signpost.basic;

import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class UrlStringRequestAdapter
  implements HttpRequest
{
  private String url;
  
  public UrlStringRequestAdapter(String paramString)
  {
    this.url = paramString;
  }
  
  public Map<String, String> getAllHeaders()
  {
    return Collections.emptyMap();
  }
  
  public String getContentType()
  {
    return null;
  }
  
  public String getHeader(String paramString)
  {
    return null;
  }
  
  public InputStream getMessagePayload()
    throws IOException
  {
    return null;
  }
  
  public String getMethod()
  {
    return "GET";
  }
  
  public String getRequestUrl()
  {
    return this.url;
  }
  
  public void setHeader(String paramString1, String paramString2) {}
  
  public void setRequestUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public Object unwrap()
  {
    return this.url;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/basic/UrlStringRequestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
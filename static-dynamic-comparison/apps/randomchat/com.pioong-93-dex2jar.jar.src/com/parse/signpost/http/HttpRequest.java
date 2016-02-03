package com.parse.signpost.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract interface HttpRequest
{
  public abstract Map<String, String> getAllHeaders();
  
  public abstract String getContentType();
  
  public abstract String getHeader(String paramString);
  
  public abstract InputStream getMessagePayload()
    throws IOException;
  
  public abstract String getMethod();
  
  public abstract String getRequestUrl();
  
  public abstract void setHeader(String paramString1, String paramString2);
  
  public abstract void setRequestUrl(String paramString);
  
  public abstract Object unwrap();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/http/HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
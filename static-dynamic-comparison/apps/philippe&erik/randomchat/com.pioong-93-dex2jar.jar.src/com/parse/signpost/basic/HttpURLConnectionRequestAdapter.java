package com.parse.signpost.basic;

import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLConnectionRequestAdapter
  implements HttpRequest
{
  protected HttpURLConnection connection;
  
  public HttpURLConnectionRequestAdapter(HttpURLConnection paramHttpURLConnection)
  {
    this.connection = paramHttpURLConnection;
  }
  
  public Map<String, String> getAllHeaders()
  {
    Map localMap = this.connection.getRequestProperties();
    HashMap localHashMap = new HashMap(localMap.size());
    Iterator localIterator = localMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      String str = (String)localIterator.next();
      List localList = (List)localMap.get(str);
      if (!localList.isEmpty()) {
        localHashMap.put(str, (String)localList.get(0));
      }
    }
  }
  
  public String getContentType()
  {
    return this.connection.getRequestProperty("Content-Type");
  }
  
  public String getHeader(String paramString)
  {
    return this.connection.getRequestProperty(paramString);
  }
  
  public InputStream getMessagePayload()
    throws IOException
  {
    return null;
  }
  
  public String getMethod()
  {
    return this.connection.getRequestMethod();
  }
  
  public String getRequestUrl()
  {
    return this.connection.getURL().toExternalForm();
  }
  
  public void setHeader(String paramString1, String paramString2)
  {
    this.connection.setRequestProperty(paramString1, paramString2);
  }
  
  public void setRequestUrl(String paramString) {}
  
  public HttpURLConnection unwrap()
  {
    return this.connection;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/basic/HttpURLConnectionRequestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
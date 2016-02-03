package com.parse.signpost.basic;

import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpURLConnectionResponseAdapter
  implements HttpResponse
{
  private HttpURLConnection connection;
  
  public HttpURLConnectionResponseAdapter(HttpURLConnection paramHttpURLConnection)
  {
    this.connection = paramHttpURLConnection;
  }
  
  public InputStream getContent()
    throws IOException
  {
    return this.connection.getInputStream();
  }
  
  public String getReasonPhrase()
    throws Exception
  {
    return this.connection.getResponseMessage();
  }
  
  public int getStatusCode()
    throws IOException
  {
    return this.connection.getResponseCode();
  }
  
  public Object unwrap()
  {
    return this.connection;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/basic/HttpURLConnectionResponseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
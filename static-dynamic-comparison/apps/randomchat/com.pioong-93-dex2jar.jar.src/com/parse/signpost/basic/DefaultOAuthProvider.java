package com.parse.signpost.basic;

import com.parse.signpost.AbstractOAuthProvider;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultOAuthProvider
  extends AbstractOAuthProvider
{
  private static final long serialVersionUID = 1L;
  
  public DefaultOAuthProvider(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void closeConnection(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    paramHttpRequest = (HttpURLConnection)paramHttpRequest.unwrap();
    if (paramHttpRequest != null) {
      paramHttpRequest.disconnect();
    }
  }
  
  protected HttpRequest createRequest(String paramString)
    throws MalformedURLException, IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setRequestMethod("POST");
    paramString.setAllowUserInteraction(false);
    paramString.setRequestProperty("Content-Length", "0");
    return new HttpURLConnectionRequestAdapter(paramString);
  }
  
  protected HttpResponse sendRequest(HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest = (HttpURLConnection)paramHttpRequest.unwrap();
    paramHttpRequest.connect();
    return new HttpURLConnectionResponseAdapter(paramHttpRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/basic/DefaultOAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
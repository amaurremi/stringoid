package com.parse.signpost.commonshttp;

import com.parse.signpost.AbstractOAuthProvider;
import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class CommonsHttpOAuthProvider
  extends AbstractOAuthProvider
{
  private static final long serialVersionUID = 1L;
  private transient HttpClient httpClient;
  
  public CommonsHttpOAuthProvider(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.httpClient = new DefaultHttpClient();
  }
  
  public CommonsHttpOAuthProvider(String paramString1, String paramString2, String paramString3, HttpClient paramHttpClient)
  {
    super(paramString1, paramString2, paramString3);
    this.httpClient = paramHttpClient;
  }
  
  protected void closeConnection(HttpRequest paramHttpRequest, com.parse.signpost.http.HttpResponse paramHttpResponse)
    throws Exception
  {
    if (paramHttpResponse != null)
    {
      paramHttpRequest = ((org.apache.http.HttpResponse)paramHttpResponse.unwrap()).getEntity();
      if (paramHttpRequest == null) {}
    }
    try
    {
      paramHttpRequest.consumeContent();
      return;
    }
    catch (IOException paramHttpRequest)
    {
      paramHttpRequest.printStackTrace();
    }
  }
  
  protected HttpRequest createRequest(String paramString)
    throws Exception
  {
    return new HttpRequestAdapter(new HttpPost(paramString));
  }
  
  protected com.parse.signpost.http.HttpResponse sendRequest(HttpRequest paramHttpRequest)
    throws Exception
  {
    return new HttpResponseAdapter(this.httpClient.execute((HttpUriRequest)paramHttpRequest.unwrap()));
  }
  
  public void setHttpClient(HttpClient paramHttpClient)
  {
    this.httpClient = paramHttpClient;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/commonshttp/CommonsHttpOAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
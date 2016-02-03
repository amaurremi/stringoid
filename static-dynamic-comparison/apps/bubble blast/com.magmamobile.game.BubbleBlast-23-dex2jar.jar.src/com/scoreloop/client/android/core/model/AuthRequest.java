package com.scoreloop.client.android.core.model;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public abstract class AuthRequest
{
  private AuthRequestDelegate a;
  
  public AuthRequest(AuthRequestDelegate paramAuthRequestDelegate)
  {
    this.a = paramAuthRequestDelegate;
  }
  
  AuthRequestDelegate a()
  {
    return this.a;
  }
  
  abstract void a(HttpResponse paramHttpResponse);
  
  abstract void a(HttpResponse paramHttpResponse, Throwable paramThrowable);
  
  void a(HttpUriRequest paramHttpUriRequest)
  {
    HttpUriRequest localHttpUriRequest2 = null;
    HttpUriRequest localHttpUriRequest1 = null;
    try
    {
      paramHttpUriRequest = new DefaultHttpClient().execute(paramHttpUriRequest);
      localHttpUriRequest1 = paramHttpUriRequest;
      localHttpUriRequest2 = paramHttpUriRequest;
      a(paramHttpUriRequest);
      return;
    }
    catch (ClientProtocolException paramHttpUriRequest)
    {
      a(localHttpUriRequest1, paramHttpUriRequest);
      return;
    }
    catch (IOException paramHttpUriRequest)
    {
      a(localHttpUriRequest2, paramHttpUriRequest);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/AuthRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
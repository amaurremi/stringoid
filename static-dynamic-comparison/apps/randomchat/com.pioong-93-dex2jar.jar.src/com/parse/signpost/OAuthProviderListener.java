package com.parse.signpost;

import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;

public abstract interface OAuthProviderListener
{
  public abstract boolean onResponseReceived(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
    throws Exception;
  
  public abstract void prepareRequest(HttpRequest paramHttpRequest)
    throws Exception;
  
  public abstract void prepareSubmission(HttpRequest paramHttpRequest)
    throws Exception;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/OAuthProviderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
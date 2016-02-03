package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.exception.OAuthNotAuthorizedException;
import com.parse.signpost.http.HttpParameters;
import java.io.Serializable;
import java.util.Map;

public abstract interface OAuthProvider
  extends Serializable
{
  public abstract String getAccessTokenEndpointUrl();
  
  public abstract String getAuthorizationWebsiteUrl();
  
  @Deprecated
  public abstract Map<String, String> getRequestHeaders();
  
  public abstract String getRequestTokenEndpointUrl();
  
  public abstract HttpParameters getResponseParameters();
  
  public abstract boolean isOAuth10a();
  
  public abstract void removeListener(OAuthProviderListener paramOAuthProviderListener);
  
  public abstract void retrieveAccessToken(OAuthConsumer paramOAuthConsumer, String paramString)
    throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException;
  
  public abstract String retrieveRequestToken(OAuthConsumer paramOAuthConsumer, String paramString)
    throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException;
  
  public abstract void setListener(OAuthProviderListener paramOAuthProviderListener);
  
  public abstract void setOAuth10a(boolean paramBoolean);
  
  @Deprecated
  public abstract void setRequestHeader(String paramString1, String paramString2);
  
  public abstract void setResponseParameters(HttpParameters paramHttpParameters);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/OAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
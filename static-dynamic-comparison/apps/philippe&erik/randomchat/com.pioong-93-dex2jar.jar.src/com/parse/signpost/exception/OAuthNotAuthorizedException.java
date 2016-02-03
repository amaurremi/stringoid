package com.parse.signpost.exception;

public class OAuthNotAuthorizedException
  extends OAuthException
{
  private static final String ERROR = "Authorization failed (server replied with a 401). This can happen if the consumer key was not correct or the signatures did not match.";
  private String responseBody;
  
  public OAuthNotAuthorizedException()
  {
    super("Authorization failed (server replied with a 401). This can happen if the consumer key was not correct or the signatures did not match.");
  }
  
  public OAuthNotAuthorizedException(String paramString)
  {
    super("Authorization failed (server replied with a 401). This can happen if the consumer key was not correct or the signatures did not match.");
    this.responseBody = paramString;
  }
  
  public String getResponseBody()
  {
    return this.responseBody;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/exception/OAuthNotAuthorizedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
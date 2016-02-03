package com.parse.signpost.exception;

public class OAuthCommunicationException
  extends OAuthException
{
  private String responseBody;
  
  public OAuthCommunicationException(Exception paramException)
  {
    super("Communication with the service provider failed: " + paramException.getLocalizedMessage(), paramException);
  }
  
  public OAuthCommunicationException(String paramString1, String paramString2)
  {
    super(paramString1);
    this.responseBody = paramString2;
  }
  
  public String getResponseBody()
  {
    return this.responseBody;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/exception/OAuthCommunicationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
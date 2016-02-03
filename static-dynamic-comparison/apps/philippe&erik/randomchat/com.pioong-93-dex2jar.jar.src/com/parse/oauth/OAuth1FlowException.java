package com.parse.oauth;

public class OAuth1FlowException
  extends Exception
{
  private static final long serialVersionUID = 4272662026279290823L;
  private final String description;
  private final int errorCode;
  private final String failingUrl;
  
  public OAuth1FlowException(int paramInt, String paramString1, String paramString2)
  {
    super(String.format("OAuth Flow Error %d: Url: %s Description: %s", new Object[] { Integer.valueOf(paramInt), paramString2, paramString1 }));
    this.errorCode = paramInt;
    this.description = paramString1;
    this.failingUrl = paramString2;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getFailingUrl()
  {
    return this.failingUrl;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/oauth/OAuth1FlowException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
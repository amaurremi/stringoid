package twitter4j.auth;

public abstract interface OAuth2Support
{
  public abstract OAuth2Token getOAuth2Token();
  
  public abstract void invalidateOAuth2Token();
  
  public abstract void setOAuth2Token(OAuth2Token paramOAuth2Token);
  
  public abstract void setOAuthConsumer(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/auth/OAuth2Support.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
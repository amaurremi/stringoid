package twitter4j.auth;

public abstract interface OAuthSupport
{
  public abstract AccessToken getOAuthAccessToken();
  
  public abstract AccessToken getOAuthAccessToken(String paramString);
  
  public abstract AccessToken getOAuthAccessToken(String paramString1, String paramString2);
  
  public abstract AccessToken getOAuthAccessToken(RequestToken paramRequestToken);
  
  public abstract AccessToken getOAuthAccessToken(RequestToken paramRequestToken, String paramString);
  
  public abstract RequestToken getOAuthRequestToken();
  
  public abstract RequestToken getOAuthRequestToken(String paramString);
  
  public abstract RequestToken getOAuthRequestToken(String paramString1, String paramString2);
  
  public abstract void setOAuthAccessToken(AccessToken paramAccessToken);
  
  public abstract void setOAuthConsumer(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/auth/OAuthSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
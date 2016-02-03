package twitter4j.auth;

public abstract interface AuthorizationConfiguration
{
  public abstract String getOAuth2AccessToken();
  
  public abstract String getOAuth2TokenType();
  
  public abstract String getOAuthAccessToken();
  
  public abstract String getOAuthAccessTokenSecret();
  
  public abstract String getOAuthConsumerKey();
  
  public abstract String getOAuthConsumerSecret();
  
  public abstract String getPassword();
  
  public abstract String getUser();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/auth/AuthorizationConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
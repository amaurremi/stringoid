package twitter4j.api;

import java.util.Map;
import twitter4j.ResponseList;
import twitter4j.TwitterAPIConfiguration;

public abstract interface HelpResources
{
  public abstract TwitterAPIConfiguration getAPIConfiguration();
  
  public abstract ResponseList getLanguages();
  
  public abstract String getPrivacyPolicy();
  
  public abstract Map getRateLimitStatus();
  
  public abstract Map getRateLimitStatus(String... paramVarArgs);
  
  public abstract String getTermsOfService();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/HelpResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
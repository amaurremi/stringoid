package twitter4j.internal.http;

import java.io.Serializable;
import twitter4j.auth.Authorization;
import twitter4j.auth.BasicAuthorization;

public class XAuthAuthorization
  implements Serializable, Authorization
{
  private static final long serialVersionUID = -6082451214083464902L;
  private BasicAuthorization basic;
  private String consumerKey;
  private String consumerSecret;
  
  public XAuthAuthorization(BasicAuthorization paramBasicAuthorization)
  {
    this.basic = paramBasicAuthorization;
  }
  
  public String getAuthorizationHeader(HttpRequest paramHttpRequest)
  {
    return this.basic.getAuthorizationHeader(paramHttpRequest);
  }
  
  public String getConsumerKey()
  {
    return this.consumerKey;
  }
  
  public String getConsumerSecret()
  {
    return this.consumerSecret;
  }
  
  public String getPassword()
  {
    return this.basic.getPassword();
  }
  
  public String getUserId()
  {
    return this.basic.getUserId();
  }
  
  public boolean isEnabled()
  {
    return this.basic.isEnabled();
  }
  
  public void setOAuthConsumer(String paramString1, String paramString2)
  {
    try
    {
      this.consumerKey = paramString1;
      this.consumerSecret = paramString2;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/http/XAuthAuthorization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
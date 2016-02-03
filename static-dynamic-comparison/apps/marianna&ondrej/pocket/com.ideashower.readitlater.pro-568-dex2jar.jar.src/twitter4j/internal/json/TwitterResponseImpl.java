package twitter4j.internal.json;

import java.io.Serializable;
import twitter4j.RateLimitStatus;
import twitter4j.TwitterResponse;
import twitter4j.internal.http.HttpResponse;

abstract class TwitterResponseImpl
  implements Serializable, TwitterResponse
{
  private static final long serialVersionUID = -7284708239736552059L;
  private transient int accessLevel;
  private transient RateLimitStatus rateLimitStatus = null;
  
  public TwitterResponseImpl()
  {
    this.accessLevel = 0;
  }
  
  public TwitterResponseImpl(HttpResponse paramHttpResponse)
  {
    this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(paramHttpResponse);
    this.accessLevel = z_T4JInternalParseUtil.toAccessLevel(paramHttpResponse);
  }
  
  public int getAccessLevel()
  {
    return this.accessLevel;
  }
  
  public RateLimitStatus getRateLimitStatus()
  {
    return this.rateLimitStatus;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/TwitterResponseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
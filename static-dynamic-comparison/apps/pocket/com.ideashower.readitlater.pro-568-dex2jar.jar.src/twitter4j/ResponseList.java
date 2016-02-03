package twitter4j;

import java.util.List;

public abstract interface ResponseList
  extends List, TwitterResponse
{
  public abstract RateLimitStatus getRateLimitStatus();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/ResponseList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
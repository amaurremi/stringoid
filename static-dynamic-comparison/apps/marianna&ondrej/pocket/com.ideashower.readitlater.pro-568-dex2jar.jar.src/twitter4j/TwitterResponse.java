package twitter4j;

import java.io.Serializable;

public abstract interface TwitterResponse
  extends Serializable
{
  public static final int NONE = 0;
  public static final int READ = 1;
  public static final int READ_WRITE = 2;
  public static final int READ_WRITE_DIRECTMESSAGES = 3;
  
  public abstract int getAccessLevel();
  
  public abstract RateLimitStatus getRateLimitStatus();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/TwitterResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
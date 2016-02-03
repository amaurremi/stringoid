package twitter4j;

import java.io.Serializable;

public abstract interface Friendship
  extends Serializable
{
  public abstract long getId();
  
  public abstract String getName();
  
  public abstract String getScreenName();
  
  public abstract boolean isFollowedBy();
  
  public abstract boolean isFollowing();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/Friendship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
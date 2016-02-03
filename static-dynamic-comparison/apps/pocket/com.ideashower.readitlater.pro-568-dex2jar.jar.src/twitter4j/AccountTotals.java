package twitter4j;

import java.io.Serializable;

public abstract interface AccountTotals
  extends Serializable, TwitterResponse
{
  public abstract int getFavorites();
  
  public abstract int getFollowers();
  
  public abstract int getFriends();
  
  public abstract int getUpdates();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/AccountTotals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package twitter4j;

import java.io.Serializable;
import java.util.Date;

public abstract interface Trends
  extends Serializable, Comparable, TwitterResponse
{
  public abstract Date getAsOf();
  
  public abstract Location getLocation();
  
  public abstract Date getTrendAt();
  
  public abstract Trend[] getTrends();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/Trends.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
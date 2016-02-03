package twitter4j;

import java.io.Serializable;

public abstract interface Trend
  extends Serializable
{
  public abstract String getName();
  
  public abstract String getQuery();
  
  public abstract String getURL();
  
  public abstract String getUrl();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/Trend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
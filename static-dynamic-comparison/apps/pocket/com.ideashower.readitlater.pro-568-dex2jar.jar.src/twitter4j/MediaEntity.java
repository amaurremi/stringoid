package twitter4j;

import java.util.Map;

public abstract interface MediaEntity
  extends URLEntity
{
  public abstract long getId();
  
  public abstract String getMediaURL();
  
  public abstract String getMediaURLHttps();
  
  public abstract Map getSizes();
  
  public abstract String getType();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/MediaEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
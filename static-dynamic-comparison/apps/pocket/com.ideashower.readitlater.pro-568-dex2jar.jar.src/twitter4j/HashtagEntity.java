package twitter4j;

import java.io.Serializable;

public abstract interface HashtagEntity
  extends Serializable, TweetEntity
{
  public abstract int getEnd();
  
  public abstract int getStart();
  
  public abstract String getText();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/HashtagEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
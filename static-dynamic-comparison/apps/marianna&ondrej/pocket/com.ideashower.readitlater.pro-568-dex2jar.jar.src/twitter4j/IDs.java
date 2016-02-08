package twitter4j;

import java.io.Serializable;

public abstract interface IDs
  extends Serializable, CursorSupport, TwitterResponse
{
  public abstract long[] getIDs();
  
  public abstract long getNextCursor();
  
  public abstract long getPreviousCursor();
  
  public abstract boolean hasNext();
  
  public abstract boolean hasPrevious();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/IDs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
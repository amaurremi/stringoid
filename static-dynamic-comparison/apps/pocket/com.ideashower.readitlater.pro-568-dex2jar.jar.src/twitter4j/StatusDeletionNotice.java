package twitter4j;

import java.io.Serializable;

public abstract interface StatusDeletionNotice
  extends Serializable, Comparable
{
  public abstract long getStatusId();
  
  public abstract long getUserId();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/StatusDeletionNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
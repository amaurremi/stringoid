package twitter4j;

public abstract interface CursorSupport
{
  public static final long START = -1L;
  
  public abstract long getNextCursor();
  
  public abstract long getPreviousCursor();
  
  public abstract boolean hasNext();
  
  public abstract boolean hasPrevious();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/CursorSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
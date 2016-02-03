package mobi.beyondpod.sync.trackers.bp;

public class AuthenticationException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private int statusCode;
  
  public AuthenticationException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.statusCode = paramInt;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/trackers/bp/AuthenticationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package mobi.beyondpod.aggregators;

import org.apache.http.client.methods.HttpUriRequest;

public class RequestBase
{
  public static String AuthRequestHeader = "Authorization";
  public static final int STATUS_FAILED = 2;
  public static final int STATUS_PENDING = 0;
  public static final int STATUS_SUCCESS = 1;
  Exception _LastException;
  protected int _RequestStatus = 0;
  protected int _RetryCount = 0;
  protected boolean _ShouldAbort = false;
  
  public Exception LastException()
  {
    return this._LastException;
  }
  
  public void OnFail(Exception paramException)
  {
    this._RequestStatus = 2;
    this._LastException = paramException;
    if ((paramException instanceof AggregatorLoginHelper.AuthenticationException)) {
      AggregatorLoginHelper.ClearAccountToken();
    }
  }
  
  public void OnSuccess(String paramString)
  {
    this._RequestStatus = 1;
  }
  
  public HttpUriRequest Request()
  {
    return null;
  }
  
  public boolean ShouldAbort()
  {
    return this._ShouldAbort;
  }
  
  public boolean ShouldRetry()
  {
    this._RetryCount -= 1;
    return this._RetryCount >= 0;
  }
  
  public int Status()
  {
    return this._RequestStatus;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/RequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
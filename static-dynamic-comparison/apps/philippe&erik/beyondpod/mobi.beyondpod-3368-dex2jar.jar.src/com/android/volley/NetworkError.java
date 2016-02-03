package com.android.volley;

public class NetworkError
  extends VolleyError
{
  public NetworkError() {}
  
  public NetworkError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }
  
  public NetworkError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/android/volley/NetworkError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
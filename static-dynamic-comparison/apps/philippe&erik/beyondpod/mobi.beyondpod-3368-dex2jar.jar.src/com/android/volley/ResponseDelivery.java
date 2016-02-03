package com.android.volley;

public abstract interface ResponseDelivery
{
  public abstract void postError(Request<?> paramRequest, VolleyError paramVolleyError);
  
  public abstract void postResponse(Request<?> paramRequest, Response<?> paramResponse);
  
  public abstract void postResponse(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/android/volley/ResponseDelivery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
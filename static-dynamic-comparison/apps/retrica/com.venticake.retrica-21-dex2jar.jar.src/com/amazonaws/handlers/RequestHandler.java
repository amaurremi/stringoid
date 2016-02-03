package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
public abstract interface RequestHandler
{
  public abstract void afterError(Request<?> paramRequest, Exception paramException);
  
  public abstract void afterResponse(Request<?> paramRequest, Object paramObject, TimingInfo paramTimingInfo);
  
  public abstract void beforeRequest(Request<?> paramRequest);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/handlers/RequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
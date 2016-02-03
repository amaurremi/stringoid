package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;

public abstract class RequestHandler2
{
  public static RequestHandler2 adapt(RequestHandler paramRequestHandler)
  {
    return new RequestHandler2Adaptor(paramRequestHandler);
  }
  
  public abstract void afterError(Request<?> paramRequest, Response<?> paramResponse, Exception paramException);
  
  public abstract void afterResponse(Request<?> paramRequest, Response<?> paramResponse);
  
  public abstract void beforeRequest(Request<?> paramRequest);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/handlers/RequestHandler2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;

final class RequestHandler2Adaptor
  extends RequestHandler2
{
  private final RequestHandler old;
  
  RequestHandler2Adaptor(RequestHandler paramRequestHandler)
  {
    if (paramRequestHandler == null) {
      throw new IllegalArgumentException();
    }
    this.old = paramRequestHandler;
  }
  
  public void afterError(Request<?> paramRequest, Response<?> paramResponse, Exception paramException)
  {
    this.old.afterError(paramRequest, paramException);
  }
  
  public void afterResponse(Request<?> paramRequest, Response<?> paramResponse)
  {
    Object localObject2 = null;
    if (paramRequest == null)
    {
      localObject1 = null;
      if (paramResponse != null) {
        break label45;
      }
      paramResponse = null;
      label15:
      if (localObject1 != null) {
        break label53;
      }
    }
    label45:
    label53:
    for (Object localObject1 = localObject2;; localObject1 = ((AWSRequestMetrics)localObject1).getTimingInfo())
    {
      this.old.afterResponse(paramRequest, paramResponse, (TimingInfo)localObject1);
      return;
      localObject1 = paramRequest.getAWSRequestMetrics();
      break;
      paramResponse = paramResponse.getAwsResponse();
      break label15;
    }
  }
  
  public void beforeRequest(Request<?> paramRequest)
  {
    this.old.beforeRequest(paramRequest);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RequestHandler2Adaptor)) {
      return false;
    }
    paramObject = (RequestHandler2Adaptor)paramObject;
    return this.old.equals(((RequestHandler2Adaptor)paramObject).old);
  }
  
  public int hashCode()
  {
    return this.old.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/handlers/RequestHandler2Adaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
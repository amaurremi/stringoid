package com.amazonaws.http.protocol;

import com.amazonaws.org.apache.http.HttpClientConnection;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import com.amazonaws.org.apache.http.protocol.HttpRequestExecutor;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetrics.Field;

public class SdkHttpRequestExecutor
  extends HttpRequestExecutor
{
  protected HttpResponse doReceiveResponse(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext)
  {
    AWSRequestMetrics localAWSRequestMetrics = (AWSRequestMetrics)paramHttpContext.getAttribute(AWSRequestMetrics.class.getSimpleName());
    if (localAWSRequestMetrics == null) {
      return super.doReceiveResponse(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
    }
    localAWSRequestMetrics.startEvent(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
    try
    {
      paramHttpRequest = super.doReceiveResponse(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
      return paramHttpRequest;
    }
    finally
    {
      localAWSRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
    }
  }
  
  protected HttpResponse doSendRequest(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext)
  {
    AWSRequestMetrics localAWSRequestMetrics = (AWSRequestMetrics)paramHttpContext.getAttribute(AWSRequestMetrics.class.getSimpleName());
    if (localAWSRequestMetrics == null) {
      return super.doSendRequest(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
    }
    localAWSRequestMetrics.startEvent(AWSRequestMetrics.Field.HttpClientSendRequestTime);
    try
    {
      paramHttpRequest = super.doSendRequest(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
      return paramHttpRequest;
    }
    finally
    {
      localAWSRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpClientSendRequestTime);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/protocol/SdkHttpRequestExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
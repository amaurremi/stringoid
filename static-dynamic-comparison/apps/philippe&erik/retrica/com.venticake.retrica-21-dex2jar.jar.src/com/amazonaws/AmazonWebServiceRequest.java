package com.amazonaws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.metrics.RequestMetricCollector;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AmazonWebServiceRequest
{
  private AWSCredentials credentials;
  private final RequestClientOptions requestClientOptions = new RequestClientOptions();
  private RequestMetricCollector requestMetricCollector;
  
  public RequestClientOptions getRequestClientOptions()
  {
    return this.requestClientOptions;
  }
  
  public AWSCredentials getRequestCredentials()
  {
    return this.credentials;
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return this.requestMetricCollector;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/AmazonWebServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
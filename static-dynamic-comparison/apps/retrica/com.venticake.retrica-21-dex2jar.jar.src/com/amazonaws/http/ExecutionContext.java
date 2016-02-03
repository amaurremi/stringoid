package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ExecutionContext
{
  private final AmazonWebServiceClient awsClient;
  private final AWSRequestMetrics awsRequestMetrics;
  private String contextUserAgent;
  private AWSCredentials credentials;
  private final List<RequestHandler2> requestHandler2s;
  
  public ExecutionContext()
  {
    this(null, false, null);
  }
  
  public ExecutionContext(List<RequestHandler2> paramList, boolean paramBoolean, AmazonWebServiceClient paramAmazonWebServiceClient)
  {
    this.requestHandler2s = paramList;
    if (paramBoolean) {}
    for (paramList = new AWSRequestMetricsFullSupport();; paramList = new AWSRequestMetrics())
    {
      this.awsRequestMetrics = paramList;
      this.awsClient = paramAmazonWebServiceClient;
      return;
    }
  }
  
  public AWSRequestMetrics getAwsRequestMetrics()
  {
    return this.awsRequestMetrics;
  }
  
  public String getContextUserAgent()
  {
    return this.contextUserAgent;
  }
  
  public AWSCredentials getCredentials()
  {
    return this.credentials;
  }
  
  public List<RequestHandler2> getRequestHandler2s()
  {
    return this.requestHandler2s;
  }
  
  public Signer getSignerByURI(URI paramURI)
  {
    if (this.awsClient == null) {
      return null;
    }
    return this.awsClient.getSignerByURI(paramURI);
  }
  
  public void setCredentials(AWSCredentials paramAWSCredentials)
  {
    this.credentials = paramAWSCredentials;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/ExecutionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
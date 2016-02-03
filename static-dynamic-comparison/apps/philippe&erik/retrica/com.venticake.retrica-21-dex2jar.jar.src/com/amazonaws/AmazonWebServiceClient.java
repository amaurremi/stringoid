package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.TimingInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AmazonWebServiceClient
{
  private static final Log log = LogFactory.getLog(AmazonWebServiceClient.class);
  protected AmazonHttpClient client;
  protected ClientConfiguration clientConfiguration;
  protected volatile URI endpoint;
  protected final List<RequestHandler2> requestHandler2s;
  private volatile String serviceName;
  private volatile Signer signer;
  private volatile String signerRegionOverride;
  protected int timeOffset;
  
  public AmazonWebServiceClient(ClientConfiguration paramClientConfiguration, RequestMetricCollector paramRequestMetricCollector)
  {
    this.clientConfiguration = paramClientConfiguration;
    this.client = new AmazonHttpClient(paramClientConfiguration, paramRequestMetricCollector);
    this.requestHandler2s = new CopyOnWriteArrayList();
  }
  
  private String computeServiceName()
  {
    String str1 = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
    String str2 = ServiceNameFactory.getServiceName(str1);
    if (str2 != null) {
      return str2;
    }
    int j = str1.indexOf("JavaClient");
    int i = j;
    if (j == -1)
    {
      j = str1.indexOf("Client");
      i = j;
      if (j == -1) {
        throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + str1);
      }
    }
    int k = str1.indexOf("Amazon");
    if (k == -1)
    {
      k = str1.indexOf("AWS");
      if (k == -1) {
        throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + str1);
      }
    }
    for (j = "AWS".length(); k >= i; j = "Amazon".length()) {
      throw new IllegalStateException("Unrecognized AWS http client class name " + str1);
    }
    return str1.substring(j + k, i).toLowerCase();
  }
  
  private Signer computeSignerByServiceRegion(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject = this.clientConfiguration.getSignerOverride();
    if (localObject == null)
    {
      paramString1 = SignerFactory.getSigner(paramString1, paramString2);
      if ((paramString1 instanceof RegionAwareSigner))
      {
        localObject = (RegionAwareSigner)paramString1;
        if (paramString3 == null) {
          break label57;
        }
        ((RegionAwareSigner)localObject).setRegionName(paramString3);
      }
    }
    label57:
    while ((paramString2 == null) || (!paramBoolean))
    {
      return paramString1;
      paramString1 = SignerFactory.getSignerByTypeAndService((String)localObject, paramString1);
      break;
    }
    ((RegionAwareSigner)localObject).setRegionName(paramString2);
    return paramString1;
  }
  
  private Signer computeSignerByURI(URI paramURI, String paramString, boolean paramBoolean)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
    }
    String str = getServiceNameIntern();
    return computeSignerByServiceRegion(str, AwsHostNameUtils.parseRegionName(paramURI.getHost(), str), paramString, paramBoolean);
  }
  
  protected static boolean isProfilingEnabled()
  {
    return System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null;
  }
  
  private boolean isRMCEnabledAtClientOrSdkLevel()
  {
    RequestMetricCollector localRequestMetricCollector = requestMetricCollector();
    return (localRequestMetricCollector != null) && (localRequestMetricCollector.isEnabled());
  }
  
  private URI toURI(String paramString)
  {
    String str = paramString;
    if (!paramString.contains("://")) {
      str = this.clientConfiguration.getProtocol().toString() + "://" + paramString;
    }
    try
    {
      paramString = new URI(str);
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  protected ExecutionContext createExecutionContext(AmazonWebServiceRequest paramAmazonWebServiceRequest)
  {
    if ((isRequestMetricsEnabled(paramAmazonWebServiceRequest)) || (isProfilingEnabled())) {}
    for (boolean bool = true;; bool = false) {
      return new ExecutionContext(this.requestHandler2s, bool, this);
    }
  }
  
  protected final void endClientExecution(AWSRequestMetrics paramAWSRequestMetrics, Request<?> paramRequest, Response<?> paramResponse, boolean paramBoolean)
  {
    if (paramRequest != null)
    {
      paramAWSRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
      paramAWSRequestMetrics.getTimingInfo().endTiming();
      findRequestMetricCollector(paramRequest).collectMetrics(paramRequest, paramResponse);
    }
    if (paramBoolean) {
      paramAWSRequestMetrics.log();
    }
  }
  
  protected final RequestMetricCollector findRequestMetricCollector(Request<?> paramRequest)
  {
    paramRequest = paramRequest.getOriginalRequest().getRequestMetricCollector();
    if (paramRequest != null) {}
    RequestMetricCollector localRequestMetricCollector;
    do
    {
      return paramRequest;
      localRequestMetricCollector = getRequestMetricsCollector();
      paramRequest = localRequestMetricCollector;
    } while (localRequestMetricCollector != null);
    return AwsSdkMetrics.getRequestMetricCollector();
  }
  
  public RequestMetricCollector getRequestMetricsCollector()
  {
    return this.client.getRequestMetricCollector();
  }
  
  protected String getServiceNameIntern()
  {
    if (this.serviceName == null) {}
    try
    {
      if (this.serviceName == null)
      {
        String str = computeServiceName();
        this.serviceName = str;
        return str;
      }
      return this.serviceName;
    }
    finally {}
  }
  
  public Signer getSignerByURI(URI paramURI)
  {
    return computeSignerByURI(paramURI, this.signerRegionOverride, true);
  }
  
  protected final boolean isRequestMetricsEnabled(AmazonWebServiceRequest paramAmazonWebServiceRequest)
  {
    paramAmazonWebServiceRequest = paramAmazonWebServiceRequest.getRequestMetricCollector();
    if ((paramAmazonWebServiceRequest != null) && (paramAmazonWebServiceRequest.isEnabled())) {
      return true;
    }
    return isRMCEnabledAtClientOrSdkLevel();
  }
  
  protected RequestMetricCollector requestMetricCollector()
  {
    RequestMetricCollector localRequestMetricCollector2 = this.client.getRequestMetricCollector();
    RequestMetricCollector localRequestMetricCollector1 = localRequestMetricCollector2;
    if (localRequestMetricCollector2 == null) {
      localRequestMetricCollector1 = AwsSdkMetrics.getRequestMetricCollector();
    }
    return localRequestMetricCollector1;
  }
  
  public void setEndpoint(String paramString)
  {
    paramString = toURI(paramString);
    Signer localSigner = computeSignerByURI(paramString, this.signerRegionOverride, false);
    try
    {
      this.endpoint = paramString;
      this.signer = localSigner;
      return;
    }
    finally {}
  }
  
  public void setRegion(Region paramRegion)
  {
    if (paramRegion == null) {
      throw new IllegalArgumentException("No region provided");
    }
    String str2 = getServiceNameIntern();
    Object localObject;
    if (paramRegion.isServiceSupported(str2))
    {
      String str1 = paramRegion.getServiceEndpoint(str2);
      int i = str1.indexOf("://");
      localObject = str1;
      if (i >= 0) {
        localObject = str1.substring(i + "://".length());
      }
    }
    for (;;)
    {
      localObject = toURI((String)localObject);
      paramRegion = computeSignerByServiceRegion(str2, paramRegion.getName(), this.signerRegionOverride, false);
      try
      {
        this.endpoint = ((URI)localObject);
        this.signer = paramRegion;
        return;
      }
      finally {}
      localObject = String.format("%s.%s.%s", new Object[] { str2, paramRegion.getName(), paramRegion.getDomain() });
      log.info("{" + str2 + ", " + paramRegion.getName() + "} was not " + "found in region metadata, trying to construct an " + "endpoint using the standard pattern for this region: '" + (String)localObject + "'.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/AmazonWebServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
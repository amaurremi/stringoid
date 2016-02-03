package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class DefaultRequest<T>
  implements Request<T>
{
  private InputStream content;
  private URI endpoint;
  private Map<String, String> headers = new HashMap();
  private HttpMethodName httpMethod = HttpMethodName.POST;
  private AWSRequestMetrics metrics;
  private final AmazonWebServiceRequest originalRequest;
  private Map<String, String> parameters = new LinkedHashMap();
  private String resourcePath;
  private String serviceName;
  private int timeOffset;
  
  public DefaultRequest(AmazonWebServiceRequest paramAmazonWebServiceRequest, String paramString)
  {
    this.serviceName = paramString;
    this.originalRequest = paramAmazonWebServiceRequest;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
  }
  
  public void addParameter(String paramString1, String paramString2)
  {
    this.parameters.put(paramString1, paramString2);
  }
  
  public AWSRequestMetrics getAWSRequestMetrics()
  {
    return this.metrics;
  }
  
  public InputStream getContent()
  {
    return this.content;
  }
  
  public URI getEndpoint()
  {
    return this.endpoint;
  }
  
  public Map<String, String> getHeaders()
  {
    return this.headers;
  }
  
  public HttpMethodName getHttpMethod()
  {
    return this.httpMethod;
  }
  
  public AmazonWebServiceRequest getOriginalRequest()
  {
    return this.originalRequest;
  }
  
  public Map<String, String> getParameters()
  {
    return this.parameters;
  }
  
  public String getResourcePath()
  {
    return this.resourcePath;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public int getTimeOffset()
  {
    return this.timeOffset;
  }
  
  public void setAWSRequestMetrics(AWSRequestMetrics paramAWSRequestMetrics)
  {
    if (this.metrics == null)
    {
      this.metrics = paramAWSRequestMetrics;
      return;
    }
    throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
  }
  
  public void setContent(InputStream paramInputStream)
  {
    this.content = paramInputStream;
  }
  
  public void setEndpoint(URI paramURI)
  {
    this.endpoint = paramURI;
  }
  
  public void setHeaders(Map<String, String> paramMap)
  {
    this.headers.clear();
    this.headers.putAll(paramMap);
  }
  
  public void setHttpMethod(HttpMethodName paramHttpMethodName)
  {
    this.httpMethod = paramHttpMethodName;
  }
  
  public void setParameters(Map<String, String> paramMap)
  {
    this.parameters.clear();
    this.parameters.putAll(paramMap);
  }
  
  public void setResourcePath(String paramString)
  {
    this.resourcePath = paramString;
  }
  
  public void setTimeOffset(int paramInt)
  {
    this.timeOffset = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getHttpMethod()).append(" ");
    localStringBuilder.append(getEndpoint()).append(" ");
    Object localObject = getResourcePath();
    if (localObject == null) {
      localStringBuilder.append("/");
    }
    String str1;
    String str2;
    for (;;)
    {
      localStringBuilder.append(" ");
      if (getParameters().isEmpty()) {
        break label183;
      }
      localStringBuilder.append("Parameters: (");
      localObject = getParameters().keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        str2 = (String)getParameters().get(str1);
        localStringBuilder.append(str1).append(": ").append(str2).append(", ");
      }
      if (!((String)localObject).startsWith("/")) {
        localStringBuilder.append("/");
      }
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(") ");
    label183:
    if (!getHeaders().isEmpty())
    {
      localStringBuilder.append("Headers: (");
      localObject = getHeaders().keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        str1 = (String)((Iterator)localObject).next();
        str2 = (String)getHeaders().get(str1);
        localStringBuilder.append(str1).append(": ").append(str2).append(", ");
      }
      localStringBuilder.append(") ");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/DefaultRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
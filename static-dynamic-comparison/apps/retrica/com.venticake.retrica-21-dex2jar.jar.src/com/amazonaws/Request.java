package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

public abstract interface Request<T>
{
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract void addParameter(String paramString1, String paramString2);
  
  public abstract AWSRequestMetrics getAWSRequestMetrics();
  
  public abstract InputStream getContent();
  
  public abstract URI getEndpoint();
  
  public abstract Map<String, String> getHeaders();
  
  public abstract HttpMethodName getHttpMethod();
  
  public abstract AmazonWebServiceRequest getOriginalRequest();
  
  public abstract Map<String, String> getParameters();
  
  public abstract String getResourcePath();
  
  public abstract String getServiceName();
  
  public abstract int getTimeOffset();
  
  public abstract void setAWSRequestMetrics(AWSRequestMetrics paramAWSRequestMetrics);
  
  public abstract void setContent(InputStream paramInputStream);
  
  public abstract void setEndpoint(URI paramURI);
  
  public abstract void setHeaders(Map<String, String> paramMap);
  
  public abstract void setHttpMethod(HttpMethodName paramHttpMethodName);
  
  public abstract void setParameters(Map<String, String> paramMap);
  
  public abstract void setResourcePath(String paramString);
  
  public abstract void setTimeOffset(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
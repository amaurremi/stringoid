package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.client.methods.HttpDelete;
import com.amazonaws.org.apache.http.client.methods.HttpGet;
import com.amazonaws.org.apache.http.client.methods.HttpHead;
import com.amazonaws.org.apache.http.client.methods.HttpPatch;
import com.amazonaws.org.apache.http.client.methods.HttpPost;
import com.amazonaws.org.apache.http.client.methods.HttpPut;
import com.amazonaws.org.apache.http.client.methods.HttpRequestBase;
import com.amazonaws.org.apache.http.entity.BufferedHttpEntity;
import com.amazonaws.org.apache.http.entity.StringEntity;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.util.HttpUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HttpRequestFactory
{
  private void configureHeaders(HttpRequestBase paramHttpRequestBase, Request<?> paramRequest, ExecutionContext paramExecutionContext, ClientConfiguration paramClientConfiguration)
  {
    URI localURI = paramRequest.getEndpoint();
    String str = localURI.getHost();
    Object localObject = str;
    if (HttpUtils.isUsingNonDefaultPort(localURI)) {
      localObject = str + ":" + localURI.getPort();
    }
    paramHttpRequestBase.addHeader("Host", (String)localObject);
    paramRequest = paramRequest.getHeaders().entrySet().iterator();
    while (paramRequest.hasNext())
    {
      localObject = (Map.Entry)paramRequest.next();
      if ((!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("Content-Length")) && (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("Host"))) {
        paramHttpRequestBase.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    if ((paramHttpRequestBase.getHeaders("Content-Type") == null) || (paramHttpRequestBase.getHeaders("Content-Type").length == 0)) {
      paramHttpRequestBase.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + "UTF-8".toLowerCase());
    }
    if ((paramExecutionContext != null) && (paramExecutionContext.getContextUserAgent() != null)) {
      paramHttpRequestBase.addHeader("User-Agent", createUserAgentString(paramClientConfiguration, paramExecutionContext.getContextUserAgent()));
    }
  }
  
  private String createUserAgentString(ClientConfiguration paramClientConfiguration, String paramString)
  {
    if (paramClientConfiguration.getUserAgent().contains(paramString)) {
      return paramClientConfiguration.getUserAgent();
    }
    return paramClientConfiguration.getUserAgent() + " " + paramString;
  }
  
  private HttpEntity newBufferedHttpEntity(HttpEntity paramHttpEntity)
  {
    try
    {
      paramHttpEntity = new BufferedHttpEntity(paramHttpEntity);
      return paramHttpEntity;
    }
    catch (IOException paramHttpEntity)
    {
      throw new AmazonClientException("Unable to create HTTP entity: " + paramHttpEntity.getMessage(), paramHttpEntity);
    }
  }
  
  private HttpEntity newStringEntity(String paramString)
  {
    try
    {
      paramString = new StringEntity(paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AmazonClientException("Unable to create HTTP entity: " + paramString.getMessage(), paramString);
    }
  }
  
  HttpRequestBase createHttpRequest(Request<?> paramRequest, ClientConfiguration paramClientConfiguration, ExecutionContext paramExecutionContext)
  {
    int k = 0;
    Object localObject1 = HttpUtils.appendUri(paramRequest.getEndpoint().toString(), paramRequest.getResourcePath(), true);
    Object localObject2 = HttpUtils.encodeParameters(paramRequest);
    int i;
    int j;
    if (paramRequest.getContent() != null)
    {
      i = 1;
      if (paramRequest.getHttpMethod() != HttpMethodName.POST) {
        break label177;
      }
      j = 1;
      label57:
      if (j != 0)
      {
        j = k;
        if (i == 0) {}
      }
      else
      {
        j = 1;
      }
      if ((localObject2 == null) || (j == 0)) {
        break label495;
      }
      localObject1 = (String)localObject1 + "?" + (String)localObject2;
    }
    label177:
    label462:
    label495:
    for (;;)
    {
      if (paramRequest.getHttpMethod() == HttpMethodName.POST)
      {
        localObject1 = new HttpPost((String)localObject1);
        if ((paramRequest.getContent() == null) && (localObject2 != null)) {
          ((HttpPost)localObject1).setEntity(newStringEntity((String)localObject2));
        }
      }
      for (;;)
      {
        configureHeaders((HttpRequestBase)localObject1, paramRequest, paramExecutionContext, paramClientConfiguration);
        return (HttpRequestBase)localObject1;
        i = 0;
        break;
        j = 0;
        break label57;
        ((HttpPost)localObject1).setEntity(new RepeatableInputStreamRequestEntity(paramRequest));
        continue;
        RepeatableInputStreamRequestEntity localRepeatableInputStreamRequestEntity;
        if (paramRequest.getHttpMethod() == HttpMethodName.PUT)
        {
          localObject2 = new HttpPut((String)localObject1);
          ((HttpPut)localObject2).getParams().setParameter("http.protocol.expect-continue", Boolean.valueOf(true));
          if (paramRequest.getContent() != null)
          {
            localRepeatableInputStreamRequestEntity = new RepeatableInputStreamRequestEntity(paramRequest);
            localObject1 = localRepeatableInputStreamRequestEntity;
            if (paramRequest.getHeaders().get("Content-Length") == null) {
              localObject1 = newBufferedHttpEntity(localRepeatableInputStreamRequestEntity);
            }
            ((HttpPut)localObject2).setEntity((HttpEntity)localObject1);
          }
          localObject1 = localObject2;
        }
        else if (paramRequest.getHttpMethod() == HttpMethodName.PATCH)
        {
          localObject2 = new HttpPatch((String)localObject1);
          if (paramRequest.getContent() != null)
          {
            localRepeatableInputStreamRequestEntity = new RepeatableInputStreamRequestEntity(paramRequest);
            localObject1 = localRepeatableInputStreamRequestEntity;
            if (paramRequest.getHeaders().get("Content-Length") == null) {
              localObject1 = newBufferedHttpEntity(localRepeatableInputStreamRequestEntity);
            }
            ((HttpPatch)localObject2).setEntity((HttpEntity)localObject1);
          }
          localObject1 = localObject2;
        }
        else if (paramRequest.getHttpMethod() == HttpMethodName.GET)
        {
          localObject1 = new HttpGet((String)localObject1);
        }
        else if (paramRequest.getHttpMethod() == HttpMethodName.DELETE)
        {
          localObject1 = new HttpDelete((String)localObject1);
        }
        else
        {
          if (paramRequest.getHttpMethod() != HttpMethodName.HEAD) {
            break label462;
          }
          localObject1 = new HttpHead((String)localObject1);
        }
      }
      throw new AmazonClientException("Unknown HTTP method name: " + paramRequest.getHttpMethod());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/HttpRequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
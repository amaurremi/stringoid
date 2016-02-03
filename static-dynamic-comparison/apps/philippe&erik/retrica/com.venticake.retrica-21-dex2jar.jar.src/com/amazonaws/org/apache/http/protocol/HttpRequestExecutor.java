package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.HttpClientConnection;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpException;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.io.IOException;
import org.apache.http.annotation.Immutable;

@Immutable
public class HttpRequestExecutor
{
  private static final void closeConnection(HttpClientConnection paramHttpClientConnection)
  {
    try
    {
      paramHttpClientConnection.close();
      return;
    }
    catch (IOException paramHttpClientConnection) {}
  }
  
  protected boolean canResponseHaveBody(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    if ("HEAD".equalsIgnoreCase(paramHttpRequest.getRequestLine().getMethod())) {}
    int i;
    do
    {
      return false;
      i = paramHttpResponse.getStatusLine().getStatusCode();
    } while ((i < 200) || (i == 204) || (i == 304) || (i == 205));
    return true;
  }
  
  protected HttpResponse doReceiveResponse(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpClientConnection == null) {
      throw new IllegalArgumentException("HTTP connection may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    paramHttpContext = null;
    for (int i = 0; (paramHttpContext == null) || (i < 200); i = paramHttpContext.getStatusLine().getStatusCode())
    {
      paramHttpContext = paramHttpClientConnection.receiveResponseHeader();
      if (canResponseHaveBody(paramHttpRequest, paramHttpContext)) {
        paramHttpClientConnection.receiveResponseEntity(paramHttpContext);
      }
    }
    return paramHttpContext;
  }
  
  protected HttpResponse doSendRequest(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpClientConnection == null) {
      throw new IllegalArgumentException("HTTP connection may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    paramHttpContext.setAttribute("http.connection", paramHttpClientConnection);
    paramHttpContext.setAttribute("http.request_sent", Boolean.FALSE);
    paramHttpClientConnection.sendRequestHeader(paramHttpRequest);
    Object localObject1;
    int i;
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
    {
      localObject1 = paramHttpRequest.getRequestLine().getProtocolVersion();
      if ((((HttpEntityEnclosingRequest)paramHttpRequest).expectContinue()) && (!((ProtocolVersion)localObject1).lessEquals(HttpVersion.HTTP_1_0)))
      {
        paramHttpClientConnection.flush();
        if (paramHttpClientConnection.isResponseAvailable(paramHttpRequest.getParams().getIntParameter("http.protocol.wait-for-continue", 2000)))
        {
          localObject1 = paramHttpClientConnection.receiveResponseHeader();
          if (canResponseHaveBody(paramHttpRequest, (HttpResponse)localObject1)) {
            paramHttpClientConnection.receiveResponseEntity((HttpResponse)localObject1);
          }
          i = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
          if (i < 200)
          {
            if (i != 100) {
              throw new ProtocolException("Unexpected response: " + ((HttpResponse)localObject1).getStatusLine());
            }
            localObject1 = null;
            i = 1;
            localObject2 = localObject1;
            if (i != 0) {
              paramHttpClientConnection.sendRequestEntity((HttpEntityEnclosingRequest)paramHttpRequest);
            }
          }
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      paramHttpClientConnection.flush();
      paramHttpContext.setAttribute("http.request_sent", Boolean.TRUE);
      return (HttpResponse)localObject2;
      i = 0;
      break;
      localObject1 = null;
      i = 1;
      break;
    }
  }
  
  public HttpResponse execute(HttpRequest paramHttpRequest, HttpClientConnection paramHttpClientConnection, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpClientConnection == null) {
      throw new IllegalArgumentException("Client connection may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    try
    {
      HttpResponse localHttpResponse2 = doSendRequest(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
      HttpResponse localHttpResponse1 = localHttpResponse2;
      if (localHttpResponse2 == null) {
        localHttpResponse1 = doReceiveResponse(paramHttpRequest, paramHttpClientConnection, paramHttpContext);
      }
      return localHttpResponse1;
    }
    catch (IOException paramHttpRequest)
    {
      closeConnection(paramHttpClientConnection);
      throw paramHttpRequest;
    }
    catch (HttpException paramHttpRequest)
    {
      closeConnection(paramHttpClientConnection);
      throw paramHttpRequest;
    }
    catch (RuntimeException paramHttpRequest)
    {
      closeConnection(paramHttpClientConnection);
      throw paramHttpRequest;
    }
  }
  
  public void postProcess(HttpResponse paramHttpResponse, HttpProcessor paramHttpProcessor, HttpContext paramHttpContext)
  {
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    if (paramHttpProcessor == null) {
      throw new IllegalArgumentException("HTTP processor may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    paramHttpContext.setAttribute("http.response", paramHttpResponse);
    paramHttpProcessor.process(paramHttpResponse, paramHttpContext);
  }
  
  public void preProcess(HttpRequest paramHttpRequest, HttpProcessor paramHttpProcessor, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpProcessor == null) {
      throw new IllegalArgumentException("HTTP processor may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    paramHttpContext.setAttribute("http.request", paramHttpRequest);
    paramHttpProcessor.process(paramHttpRequest, paramHttpContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/HttpRequestExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
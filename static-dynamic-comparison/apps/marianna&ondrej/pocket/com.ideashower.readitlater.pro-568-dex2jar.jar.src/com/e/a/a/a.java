package com.e.a.a;

import com.e.a.m;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class a
  implements HttpClient
{
  protected final m a;
  private final HttpParams b = new AbstractHttpParams()
  {
    public HttpParams copy()
    {
      throw new UnsupportedOperationException();
    }
    
    public Object getParameter(String paramAnonymousString)
    {
      if (paramAnonymousString.equals("http.route.default-proxy"))
      {
        paramAnonymousString = a.this.a.c();
        if (paramAnonymousString == null) {
          return null;
        }
        paramAnonymousString = (InetSocketAddress)paramAnonymousString.address();
        return new HttpHost(paramAnonymousString.getHostName(), paramAnonymousString.getPort());
      }
      throw new IllegalArgumentException(paramAnonymousString);
    }
    
    public boolean removeParameter(String paramAnonymousString)
    {
      throw new UnsupportedOperationException();
    }
    
    public HttpParams setParameter(String paramAnonymousString, Object paramAnonymousObject)
    {
      if (paramAnonymousString.equals("http.route.default-proxy"))
      {
        paramAnonymousObject = (HttpHost)paramAnonymousObject;
        paramAnonymousString = null;
        if (paramAnonymousObject != null) {
          paramAnonymousString = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(((HttpHost)paramAnonymousObject).getHostName(), ((HttpHost)paramAnonymousObject).getPort()));
        }
        a.this.a.a(paramAnonymousString);
        return this;
      }
      throw new IllegalArgumentException(paramAnonymousString);
    }
  };
  
  public a()
  {
    this(new m());
  }
  
  public a(m paramm)
  {
    this.a = paramm;
  }
  
  private static void a(HttpResponse paramHttpResponse)
  {
    try
    {
      paramHttpResponse.getEntity().consumeContent();
      return;
    }
    catch (Throwable paramHttpResponse) {}
  }
  
  public m a()
  {
    return this.a;
  }
  
  protected HttpURLConnection a(URL paramURL)
  {
    return this.a.a(paramURL);
  }
  
  public Object execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler)
  {
    return execute(paramHttpHost, paramHttpRequest, paramResponseHandler, null);
  }
  
  public Object execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
  {
    paramHttpHost = execute(paramHttpHost, paramHttpRequest, paramHttpContext);
    try
    {
      paramHttpRequest = paramResponseHandler.handleResponse(paramHttpHost);
      return paramHttpRequest;
    }
    finally
    {
      a(paramHttpHost);
    }
  }
  
  public Object execute(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler)
  {
    return execute(null, paramHttpUriRequest, paramResponseHandler, null);
  }
  
  public Object execute(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
  {
    return execute(null, paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    return execute(paramHttpHost, paramHttpRequest, (HttpContext)null);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    paramHttpHost = paramHttpRequest.getRequestLine();
    paramHttpContext = a(new URL(paramHttpHost.getUri()));
    paramHttpContext.setRequestMethod(paramHttpHost.getMethod());
    paramHttpHost = paramHttpRequest.getAllHeaders();
    int j = paramHttpHost.length;
    int i = 0;
    String str;
    while (i < j)
    {
      str = paramHttpHost[i];
      paramHttpContext.addRequestProperty(str.getName(), str.getValue());
      i += 1;
    }
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
    {
      paramHttpHost = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
      if (paramHttpHost != null)
      {
        paramHttpContext.setDoOutput(true);
        paramHttpRequest = paramHttpHost.getContentType();
        if (paramHttpRequest != null) {
          paramHttpContext.addRequestProperty(paramHttpRequest.getName(), paramHttpRequest.getValue());
        }
        paramHttpRequest = paramHttpHost.getContentEncoding();
        if (paramHttpRequest != null) {
          paramHttpContext.addRequestProperty(paramHttpRequest.getName(), paramHttpRequest.getValue());
        }
        if ((!paramHttpHost.isChunked()) && (paramHttpHost.getContentLength() >= 0L)) {
          break label279;
        }
        paramHttpContext.setChunkedStreamingMode(0);
        paramHttpHost.writeTo(paramHttpContext.getOutputStream());
      }
    }
    i = paramHttpContext.getResponseCode();
    paramHttpHost = paramHttpContext.getResponseMessage();
    paramHttpRequest = new BasicHttpResponse(HttpVersion.HTTP_1_1, i, paramHttpHost);
    if (i < 400) {}
    for (paramHttpHost = paramHttpContext.getInputStream();; paramHttpHost = paramHttpContext.getErrorStream())
    {
      paramHttpHost = new InputStreamEntity(paramHttpHost, paramHttpContext.getContentLength());
      i = 0;
      str = paramHttpContext.getHeaderFieldKey(i);
      if (str != null) {
        break label332;
      }
      paramHttpRequest.setEntity(paramHttpHost);
      return paramHttpRequest;
      label279:
      if (paramHttpHost.getContentLength() <= 8192L)
      {
        paramHttpContext.addRequestProperty("Content-Length", Long.toString(paramHttpHost.getContentLength()));
        break;
      }
      paramHttpContext.setFixedLengthStreamingMode((int)paramHttpHost.getContentLength());
      break;
    }
    label332:
    BasicHeader localBasicHeader = new BasicHeader(str, paramHttpContext.getHeaderField(i));
    paramHttpRequest.addHeader(localBasicHeader);
    if (str.equalsIgnoreCase("Content-Type")) {
      paramHttpHost.setContentType(localBasicHeader);
    }
    for (;;)
    {
      i += 1;
      break;
      if (str.equalsIgnoreCase("Content-Encoding")) {
        paramHttpHost.setContentEncoding(localBasicHeader);
      }
    }
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
  {
    return execute(null, paramHttpUriRequest, (HttpContext)null);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    return execute(null, paramHttpUriRequest, paramHttpContext);
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    throw new UnsupportedOperationException();
  }
  
  public HttpParams getParams()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
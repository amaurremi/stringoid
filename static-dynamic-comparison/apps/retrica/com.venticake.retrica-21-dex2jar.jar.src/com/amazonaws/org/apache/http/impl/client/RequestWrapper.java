package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.client.methods.HttpUriRequest;
import com.amazonaws.org.apache.http.message.AbstractHttpMessage;
import com.amazonaws.org.apache.http.message.BasicRequestLine;
import com.amazonaws.org.apache.http.message.HeaderGroup;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class RequestWrapper
  extends AbstractHttpMessage
  implements HttpUriRequest
{
  private int execCount;
  private String method;
  private final HttpRequest original;
  private URI uri;
  private ProtocolVersion version;
  
  public RequestWrapper(HttpRequest paramHttpRequest)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    this.original = paramHttpRequest;
    setParams(paramHttpRequest.getParams());
    setHeaders(paramHttpRequest.getAllHeaders());
    if ((paramHttpRequest instanceof HttpUriRequest))
    {
      this.uri = ((HttpUriRequest)paramHttpRequest).getURI();
      this.method = ((HttpUriRequest)paramHttpRequest).getMethod();
      this.version = null;
    }
    for (;;)
    {
      this.execCount = 0;
      return;
      RequestLine localRequestLine = paramHttpRequest.getRequestLine();
      try
      {
        this.uri = new URI(localRequestLine.getUri());
        this.method = localRequestLine.getMethod();
        this.version = paramHttpRequest.getProtocolVersion();
      }
      catch (URISyntaxException paramHttpRequest)
      {
        throw new ProtocolException("Invalid request URI: " + localRequestLine.getUri(), paramHttpRequest);
      }
    }
  }
  
  public int getExecCount()
  {
    return this.execCount;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public HttpRequest getOriginal()
  {
    return this.original;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    if (this.version == null) {
      this.version = HttpProtocolParams.getVersion(getParams());
    }
    return this.version;
  }
  
  public RequestLine getRequestLine()
  {
    String str3 = getMethod();
    ProtocolVersion localProtocolVersion = getProtocolVersion();
    String str1 = null;
    if (this.uri != null) {
      str1 = this.uri.toASCIIString();
    }
    String str2;
    if (str1 != null)
    {
      str2 = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      str2 = "/";
    }
    return new BasicRequestLine(str3, str2, localProtocolVersion);
  }
  
  public URI getURI()
  {
    return this.uri;
  }
  
  public void incrementExecCount()
  {
    this.execCount += 1;
  }
  
  public boolean isAborted()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public void resetHeaders()
  {
    this.headergroup.clear();
    setHeaders(this.original.getAllHeaders());
  }
  
  public void setURI(URI paramURI)
  {
    this.uri = paramURI;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/RequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
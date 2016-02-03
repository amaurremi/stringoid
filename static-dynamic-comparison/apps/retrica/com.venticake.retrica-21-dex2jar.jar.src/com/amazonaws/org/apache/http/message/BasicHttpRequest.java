package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicHttpRequest
  extends AbstractHttpMessage
  implements HttpRequest
{
  private final String method;
  private RequestLine requestline;
  private final String uri;
  
  public BasicHttpRequest(RequestLine paramRequestLine)
  {
    if (paramRequestLine == null) {
      throw new IllegalArgumentException("Request line may not be null");
    }
    this.requestline = paramRequestLine;
    this.method = paramRequestLine.getMethod();
    this.uri = paramRequestLine.getUri();
  }
  
  public BasicHttpRequest(String paramString1, String paramString2, ProtocolVersion paramProtocolVersion)
  {
    this(new BasicRequestLine(paramString1, paramString2, paramProtocolVersion));
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return getRequestLine().getProtocolVersion();
  }
  
  public RequestLine getRequestLine()
  {
    if (this.requestline == null)
    {
      ProtocolVersion localProtocolVersion = HttpProtocolParams.getVersion(getParams());
      this.requestline = new BasicRequestLine(this.method, this.uri, localProtocolVersion);
    }
    return this.requestline;
  }
  
  public String toString()
  {
    return this.method + " " + this.uri + " " + this.headergroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
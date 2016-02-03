package com.amazonaws.org.apache.http.client.methods;

import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.client.utils.CloneUtils;
import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import com.amazonaws.org.apache.http.conn.ConnectionReleaseTrigger;
import com.amazonaws.org.apache.http.message.AbstractHttpMessage;
import com.amazonaws.org.apache.http.message.BasicRequestLine;
import com.amazonaws.org.apache.http.message.HeaderGroup;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class HttpRequestBase
  extends AbstractHttpMessage
  implements AbortableHttpRequest, HttpUriRequest, Cloneable
{
  private Lock abortLock = new ReentrantLock();
  private volatile boolean aborted;
  private ClientConnectionRequest connRequest;
  private ConnectionReleaseTrigger releaseTrigger;
  private URI uri;
  
  private void cleanup()
  {
    if (this.connRequest != null)
    {
      this.connRequest.abortRequest();
      this.connRequest = null;
    }
    if (this.releaseTrigger != null) {}
    try
    {
      this.releaseTrigger.abortConnection();
      this.releaseTrigger = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public void abort()
  {
    if (this.aborted) {
      return;
    }
    this.abortLock.lock();
    try
    {
      this.aborted = true;
      cleanup();
      return;
    }
    finally
    {
      this.abortLock.unlock();
    }
  }
  
  public Object clone()
  {
    HttpRequestBase localHttpRequestBase = (HttpRequestBase)super.clone();
    localHttpRequestBase.abortLock = new ReentrantLock();
    localHttpRequestBase.aborted = false;
    localHttpRequestBase.releaseTrigger = null;
    localHttpRequestBase.connRequest = null;
    localHttpRequestBase.headergroup = ((HeaderGroup)CloneUtils.clone(this.headergroup));
    localHttpRequestBase.params = ((HttpParams)CloneUtils.clone(this.params));
    return localHttpRequestBase;
  }
  
  public abstract String getMethod();
  
  public ProtocolVersion getProtocolVersion()
  {
    return HttpProtocolParams.getVersion(getParams());
  }
  
  public RequestLine getRequestLine()
  {
    String str2 = getMethod();
    ProtocolVersion localProtocolVersion = getProtocolVersion();
    Object localObject = getURI();
    String str1 = null;
    if (localObject != null) {
      str1 = ((URI)localObject).toASCIIString();
    }
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "/";
    }
    return new BasicRequestLine(str2, (String)localObject, localProtocolVersion);
  }
  
  public URI getURI()
  {
    return this.uri;
  }
  
  public boolean isAborted()
  {
    return this.aborted;
  }
  
  public void setConnectionRequest(ClientConnectionRequest paramClientConnectionRequest)
  {
    if (this.aborted) {
      throw new IOException("Request already aborted");
    }
    this.abortLock.lock();
    try
    {
      this.connRequest = paramClientConnectionRequest;
      return;
    }
    finally
    {
      this.abortLock.unlock();
    }
  }
  
  public void setReleaseTrigger(ConnectionReleaseTrigger paramConnectionReleaseTrigger)
  {
    if (this.aborted) {
      throw new IOException("Request already aborted");
    }
    this.abortLock.lock();
    try
    {
      this.releaseTrigger = paramConnectionReleaseTrigger;
      return;
    }
    finally
    {
      this.abortLock.unlock();
    }
  }
  
  public void setURI(URI paramURI)
  {
    this.uri = paramURI;
  }
  
  public String toString()
  {
    return getMethod() + " " + getURI() + " " + getProtocolVersion();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/methods/HttpRequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
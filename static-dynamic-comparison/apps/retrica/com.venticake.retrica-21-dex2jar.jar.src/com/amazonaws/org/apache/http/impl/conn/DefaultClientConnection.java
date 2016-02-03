package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseFactory;
import com.amazonaws.org.apache.http.conn.OperatedClientConnection;
import com.amazonaws.org.apache.http.impl.SocketHttpClientConnection;
import com.amazonaws.org.apache.http.io.HttpMessageParser;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class DefaultClientConnection
  extends SocketHttpClientConnection
  implements OperatedClientConnection, HttpContext
{
  private final Map<String, Object> attributes = new HashMap();
  private boolean connSecure;
  private final Log headerLog = LogFactory.getLog("com.amazonaws.org.apache.http.headers");
  private final Log log = LogFactory.getLog(getClass());
  private volatile boolean shutdown;
  private volatile Socket socket;
  private HttpHost targetHost;
  private final Log wireLog = LogFactory.getLog("com.amazonaws.org.apache.http.wire");
  
  public void close()
  {
    try
    {
      super.close();
      if (this.log.isDebugEnabled()) {
        this.log.debug("Connection " + this + " closed");
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.log.debug("I/O error closing connection", localIOException);
    }
  }
  
  protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer paramSessionInputBuffer, HttpResponseFactory paramHttpResponseFactory, HttpParams paramHttpParams)
  {
    return new DefaultHttpResponseParser(paramSessionInputBuffer, null, paramHttpResponseFactory, paramHttpParams);
  }
  
  protected SessionInputBuffer createSessionInputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 8192;
    }
    paramSocket = super.createSessionInputBuffer(paramSocket, i, paramHttpParams);
    if (this.wireLog.isDebugEnabled()) {
      return new LoggingSessionInputBuffer(paramSocket, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(paramHttpParams));
    }
    return paramSocket;
  }
  
  protected SessionOutputBuffer createSessionOutputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 8192;
    }
    paramSocket = super.createSessionOutputBuffer(paramSocket, i, paramHttpParams);
    if (this.wireLog.isDebugEnabled()) {
      return new LoggingSessionOutputBuffer(paramSocket, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(paramHttpParams));
    }
    return paramSocket;
  }
  
  public Object getAttribute(String paramString)
  {
    return this.attributes.get(paramString);
  }
  
  public final Socket getSocket()
  {
    return this.socket;
  }
  
  public final boolean isSecure()
  {
    return this.connSecure;
  }
  
  public void openCompleted(boolean paramBoolean, HttpParams paramHttpParams)
  {
    assertNotOpen();
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters must not be null.");
    }
    this.connSecure = paramBoolean;
    bind(this.socket, paramHttpParams);
  }
  
  public void opening(Socket paramSocket, HttpHost paramHttpHost)
  {
    assertNotOpen();
    this.socket = paramSocket;
    this.targetHost = paramHttpHost;
    if (this.shutdown)
    {
      paramSocket.close();
      throw new InterruptedIOException("Connection already shutdown");
    }
  }
  
  public HttpResponse receiveResponseHeader()
  {
    HttpResponse localHttpResponse = super.receiveResponseHeader();
    if (this.log.isDebugEnabled()) {
      this.log.debug("Receiving response: " + localHttpResponse.getStatusLine());
    }
    if (this.headerLog.isDebugEnabled())
    {
      this.headerLog.debug("<< " + localHttpResponse.getStatusLine().toString());
      Header[] arrayOfHeader = localHttpResponse.getAllHeaders();
      int j = arrayOfHeader.length;
      int i = 0;
      while (i < j)
      {
        Header localHeader = arrayOfHeader[i];
        this.headerLog.debug("<< " + localHeader.toString());
        i += 1;
      }
    }
    return localHttpResponse;
  }
  
  public void sendRequestHeader(HttpRequest paramHttpRequest)
  {
    if (this.log.isDebugEnabled()) {
      this.log.debug("Sending request: " + paramHttpRequest.getRequestLine());
    }
    super.sendRequestHeader(paramHttpRequest);
    if (this.headerLog.isDebugEnabled())
    {
      this.headerLog.debug(">> " + paramHttpRequest.getRequestLine().toString());
      paramHttpRequest = paramHttpRequest.getAllHeaders();
      int j = paramHttpRequest.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramHttpRequest[i];
        this.headerLog.debug(">> " + localObject.toString());
        i += 1;
      }
    }
  }
  
  public void setAttribute(String paramString, Object paramObject)
  {
    this.attributes.put(paramString, paramObject);
  }
  
  public void shutdown()
  {
    this.shutdown = true;
    try
    {
      super.shutdown();
      if (this.log.isDebugEnabled()) {
        this.log.debug("Connection " + this + " shut down");
      }
      Socket localSocket = this.socket;
      if (localSocket != null) {
        localSocket.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.log.debug("I/O error shutting down connection", localIOException);
    }
  }
  
  public void update(Socket paramSocket, HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
  {
    assertOpen();
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Target host must not be null.");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters must not be null.");
    }
    if (paramSocket != null)
    {
      this.socket = paramSocket;
      bind(paramSocket, paramHttpParams);
    }
    this.targetHost = paramHttpHost;
    this.connSecure = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/DefaultClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyConnection.Builder;
import java.io.IOException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class Connection
{
  private boolean connected = false;
  private Handshake handshake;
  private HttpConnection httpConnection;
  private long idleStartTimeNs;
  private Object owner;
  private final ConnectionPool pool;
  private Protocol protocol = Protocol.HTTP_1_1;
  private int recycleCount;
  private final Route route;
  private Socket socket;
  private SpdyConnection spdyConnection;
  
  public Connection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.pool = paramConnectionPool;
    this.route = paramRoute;
  }
  
  private void makeTunnel(Request paramRequest, int paramInt1, int paramInt2)
    throws IOException
  {
    HttpConnection localHttpConnection = new HttpConnection(this.pool, this, this.socket);
    localHttpConnection.setTimeouts(paramInt1, paramInt2);
    Object localObject = paramRequest.url();
    String str = "CONNECT " + ((URL)localObject).getHost() + ":" + ((URL)localObject).getPort() + " HTTP/1.1";
    do
    {
      localHttpConnection.writeRequest(paramRequest.headers(), str);
      localHttpConnection.flush();
      paramRequest = localHttpConnection.readResponse().request(paramRequest).build();
      localHttpConnection.emptyResponseBody();
      switch (paramRequest.code())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + paramRequest.code());
      case 200: 
        if (localHttpConnection.bufferSize() <= 0L) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        localObject = OkHeaders.processAuthHeader(this.route.address.authenticator, paramRequest, this.route.proxy);
        paramRequest = (Request)localObject;
      }
    } while (localObject != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  private void upgradeToTls(Request paramRequest, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject = Platform.get();
    if (paramRequest != null) {
      makeTunnel(paramRequest, paramInt1, paramInt2);
    }
    this.socket = this.route.address.sslSocketFactory.createSocket(this.socket, this.route.address.uriHost, this.route.address.uriPort, true);
    paramRequest = (SSLSocket)this.socket;
    ((Platform)localObject).configureTls(paramRequest, this.route.address.uriHost, this.route.tlsVersion);
    boolean bool = this.route.supportsNpn();
    if (bool) {
      ((Platform)localObject).setProtocols(paramRequest, this.route.address.protocols);
    }
    paramRequest.startHandshake();
    if (!this.route.address.hostnameVerifier.verify(this.route.address.uriHost, paramRequest.getSession())) {
      throw new IOException("Hostname '" + this.route.address.uriHost + "' was not verified");
    }
    this.handshake = Handshake.get(paramRequest.getSession());
    if (bool)
    {
      localObject = ((Platform)localObject).getSelectedProtocol(paramRequest);
      if (localObject != null) {
        this.protocol = Protocol.get((String)localObject);
      }
    }
    if ((this.protocol == Protocol.SPDY_3) || (this.protocol == Protocol.HTTP_2))
    {
      paramRequest.setSoTimeout(0);
      this.spdyConnection = new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.socket).protocol(this.protocol).build();
      this.spdyConnection.sendConnectionPreface();
      return;
    }
    this.httpConnection = new HttpConnection(this.pool, this, this.socket);
  }
  
  boolean clearOwner()
  {
    synchronized (this.pool)
    {
      if (this.owner == null) {
        return false;
      }
      this.owner = null;
      return true;
    }
  }
  
  void closeIfOwnedBy(Object paramObject)
    throws IOException
  {
    if (isSpdy()) {
      throw new IllegalStateException();
    }
    synchronized (this.pool)
    {
      if (this.owner != paramObject) {
        return;
      }
      this.owner = null;
      this.socket.close();
      return;
    }
  }
  
  void connect(int paramInt1, int paramInt2, int paramInt3, Request paramRequest)
    throws IOException
  {
    if (this.connected) {
      throw new IllegalStateException("already connected");
    }
    if (this.route.proxy.type() != Proxy.Type.HTTP)
    {
      this.socket = new Socket(this.route.proxy);
      this.socket.setSoTimeout(paramInt2);
      Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, paramInt1);
      if (this.route.address.sslSocketFactory == null) {
        break label125;
      }
      upgradeToTls(paramRequest, paramInt2, paramInt3);
    }
    for (;;)
    {
      this.connected = true;
      return;
      this.socket = this.route.address.socketFactory.createSocket();
      break;
      label125:
      this.httpConnection = new HttpConnection(this.pool, this, this.socket);
    }
  }
  
  public Handshake getHandshake()
  {
    return this.handshake;
  }
  
  long getIdleStartTimeNs()
  {
    if (this.spdyConnection == null) {
      return this.idleStartTimeNs;
    }
    return this.spdyConnection.getIdleStartTimeNs();
  }
  
  Object getOwner()
  {
    synchronized (this.pool)
    {
      Object localObject1 = this.owner;
      return localObject1;
    }
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  public Route getRoute()
  {
    return this.route;
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  void incrementRecycleCount()
  {
    this.recycleCount += 1;
  }
  
  boolean isAlive()
  {
    return (!this.socket.isClosed()) && (!this.socket.isInputShutdown()) && (!this.socket.isOutputShutdown());
  }
  
  boolean isConnected()
  {
    return this.connected;
  }
  
  boolean isExpired(long paramLong)
  {
    return getIdleStartTimeNs() < System.nanoTime() - paramLong;
  }
  
  boolean isIdle()
  {
    return (this.spdyConnection == null) || (this.spdyConnection.isIdle());
  }
  
  boolean isReadable()
  {
    if (this.httpConnection != null) {
      return this.httpConnection.isReadable();
    }
    return true;
  }
  
  boolean isSpdy()
  {
    return this.spdyConnection != null;
  }
  
  Transport newTransport(HttpEngine paramHttpEngine)
    throws IOException
  {
    if (this.spdyConnection != null) {
      return new SpdyTransport(paramHttpEngine, this.spdyConnection);
    }
    return new HttpTransport(paramHttpEngine, this.httpConnection);
  }
  
  int recycleCount()
  {
    return this.recycleCount;
  }
  
  void resetIdleStartTime()
  {
    if (this.spdyConnection != null) {
      throw new IllegalStateException("spdyConnection != null");
    }
    this.idleStartTimeNs = System.nanoTime();
  }
  
  void setOwner(Object paramObject)
  {
    if (isSpdy()) {
      return;
    }
    synchronized (this.pool)
    {
      if (this.owner != null) {
        throw new IllegalStateException("Connection already has an owner!");
      }
    }
    this.owner = paramObject;
  }
  
  void setProtocol(Protocol paramProtocol)
  {
    if (paramProtocol == null) {
      throw new IllegalArgumentException("protocol == null");
    }
    this.protocol = paramProtocol;
  }
  
  void setTimeouts(int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.connected) {
      throw new IllegalStateException("setTimeouts - not connected");
    }
    if (this.httpConnection != null)
    {
      this.socket.setSoTimeout(paramInt1);
      this.httpConnection.setTimeouts(paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
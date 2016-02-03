package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.conn.ClientConnectionOperator;
import com.amazonaws.org.apache.http.conn.ConnectTimeoutException;
import com.amazonaws.org.apache.http.conn.DnsResolver;
import com.amazonaws.org.apache.http.conn.HttpHostConnectException;
import com.amazonaws.org.apache.http.conn.HttpInetSocketAddress;
import com.amazonaws.org.apache.http.conn.OperatedClientConnection;
import com.amazonaws.org.apache.http.conn.scheme.Scheme;
import com.amazonaws.org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.conn.scheme.SchemeSocketFactory;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class DefaultClientConnectionOperator
  implements ClientConnectionOperator
{
  protected final DnsResolver dnsResolver;
  private final Log log = LogFactory.getLog(getClass());
  protected final SchemeRegistry schemeRegistry;
  
  public DefaultClientConnectionOperator(SchemeRegistry paramSchemeRegistry)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("Scheme registry amy not be null");
    }
    this.schemeRegistry = paramSchemeRegistry;
    this.dnsResolver = new SystemDefaultDnsResolver();
  }
  
  public DefaultClientConnectionOperator(SchemeRegistry paramSchemeRegistry, DnsResolver paramDnsResolver)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("Scheme registry may not be null");
    }
    if (paramDnsResolver == null) {
      throw new IllegalArgumentException("DNS resolver may not be null");
    }
    this.schemeRegistry = paramSchemeRegistry;
    this.dnsResolver = paramDnsResolver;
  }
  
  public OperatedClientConnection createConnection()
  {
    return new DefaultClientConnection();
  }
  
  public void openConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, InetAddress paramInetAddress, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramOperatedClientConnection == null) {
      throw new IllegalArgumentException("Connection may not be null");
    }
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Target host may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters may not be null");
    }
    if (paramOperatedClientConnection.isOpen()) {
      throw new IllegalStateException("Connection must not be open");
    }
    Object localObject1 = this.schemeRegistry.getScheme(paramHttpHost.getSchemeName());
    SchemeSocketFactory localSchemeSocketFactory = ((Scheme)localObject1).getSchemeSocketFactory();
    InetAddress[] arrayOfInetAddress = resolveHostname(paramHttpHost.getHostName());
    int k = ((Scheme)localObject1).resolvePort(paramHttpHost.getPort());
    int i = 0;
    int j;
    label134:
    Socket localSocket;
    HttpInetSocketAddress localHttpInetSocketAddress;
    if (i < arrayOfInetAddress.length)
    {
      localObject1 = arrayOfInetAddress[i];
      if (i != arrayOfInetAddress.length - 1) {
        break label288;
      }
      j = 1;
      localSocket = localSchemeSocketFactory.createSocket(paramHttpParams);
      paramOperatedClientConnection.opening(localSocket, paramHttpHost);
      localHttpInetSocketAddress = new HttpInetSocketAddress(paramHttpHost, (InetAddress)localObject1, k);
      localObject1 = null;
      if (paramInetAddress != null) {
        localObject1 = new InetSocketAddress(paramInetAddress, 0);
      }
      if (this.log.isDebugEnabled()) {
        this.log.debug("Connecting to " + localHttpInetSocketAddress);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localSchemeSocketFactory.connectSocket(localSocket, localHttpInetSocketAddress, (InetSocketAddress)localObject1, paramHttpParams);
        if (localSocket == localObject1) {
          break label382;
        }
        paramOperatedClientConnection.opening((Socket)localObject1, paramHttpHost);
        prepareSocket((Socket)localObject1, paramHttpContext, paramHttpParams);
        paramOperatedClientConnection.openCompleted(localSchemeSocketFactory.isSecure((Socket)localObject1), paramHttpParams);
        return;
      }
      catch (ConnectException localConnectException)
      {
        if (j == 0) {
          continue;
        }
        throw new HttpHostConnectException(paramHttpHost, localConnectException);
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        label288:
        if (j == 0) {
          continue;
        }
        throw localConnectTimeoutException;
        if (!this.log.isDebugEnabled()) {
          continue;
        }
        this.log.debug("Connect to " + localHttpInetSocketAddress + " timed out. " + "Connection will be retried using another IP address");
        i += 1;
      }
      j = 0;
      break label134;
      break;
      label382:
      Object localObject2 = localSocket;
    }
  }
  
  protected void prepareSocket(Socket paramSocket, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    paramSocket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(paramHttpParams));
    paramSocket.setSoTimeout(HttpConnectionParams.getSoTimeout(paramHttpParams));
    int i = HttpConnectionParams.getLinger(paramHttpParams);
    if (i >= 0) {
      if (i <= 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      paramSocket.setSoLinger(bool, i);
      return;
    }
  }
  
  protected InetAddress[] resolveHostname(String paramString)
  {
    return this.dnsResolver.resolve(paramString);
  }
  
  public void updateSecureConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramOperatedClientConnection == null) {
      throw new IllegalArgumentException("Connection may not be null");
    }
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Target host may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters may not be null");
    }
    if (!paramOperatedClientConnection.isOpen()) {
      throw new IllegalStateException("Connection must be open");
    }
    Object localObject = this.schemeRegistry.getScheme(paramHttpHost.getSchemeName());
    if (!(((Scheme)localObject).getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory)) {
      throw new IllegalArgumentException("Target scheme (" + ((Scheme)localObject).getName() + ") must have layered socket factory.");
    }
    localObject = (SchemeLayeredSocketFactory)((Scheme)localObject).getSchemeSocketFactory();
    try
    {
      Socket localSocket = ((SchemeLayeredSocketFactory)localObject).createLayeredSocket(paramOperatedClientConnection.getSocket(), paramHttpHost.getHostName(), paramHttpHost.getPort(), paramHttpParams);
      prepareSocket(localSocket, paramHttpContext, paramHttpParams);
      paramOperatedClientConnection.update(localSocket, paramHttpHost, ((SchemeLayeredSocketFactory)localObject).isSecure(localSocket), paramHttpParams);
      return;
    }
    catch (ConnectException paramOperatedClientConnection)
    {
      throw new HttpHostConnectException(paramHttpHost, paramOperatedClientConnection);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/DefaultClientConnectionOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
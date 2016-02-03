package com.amazonaws.org.apache.http.conn.scheme;

import com.amazonaws.org.apache.http.conn.ConnectTimeoutException;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.http.annotation.Immutable;

@Immutable
public class PlainSocketFactory
  implements SchemeSocketFactory
{
  private final HostNameResolver nameResolver = null;
  
  public static PlainSocketFactory getSocketFactory()
  {
    return new PlainSocketFactory();
  }
  
  public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams)
  {
    if (paramInetSocketAddress1 == null) {
      throw new IllegalArgumentException("Remote address may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    Socket localSocket = paramSocket;
    if (paramSocket == null) {
      localSocket = createSocket();
    }
    if (paramInetSocketAddress2 != null)
    {
      localSocket.setReuseAddress(HttpConnectionParams.getSoReuseaddr(paramHttpParams));
      localSocket.bind(paramInetSocketAddress2);
    }
    int i = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
    int j = HttpConnectionParams.getSoTimeout(paramHttpParams);
    try
    {
      localSocket.setSoTimeout(j);
      localSocket.connect(paramInetSocketAddress1, i);
      return localSocket;
    }
    catch (SocketTimeoutException paramSocket)
    {
      throw new ConnectTimeoutException("Connect to " + paramInetSocketAddress1 + " timed out");
    }
  }
  
  public Socket createSocket()
  {
    return new Socket();
  }
  
  public Socket createSocket(HttpParams paramHttpParams)
  {
    return new Socket();
  }
  
  public final boolean isSecure(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("Socket may not be null.");
    }
    if (paramSocket.isClosed()) {
      throw new IllegalArgumentException("Socket is closed.");
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/scheme/PlainSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
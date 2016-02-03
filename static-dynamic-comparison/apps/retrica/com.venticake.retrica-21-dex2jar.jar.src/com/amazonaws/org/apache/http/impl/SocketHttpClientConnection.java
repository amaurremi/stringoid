package com.amazonaws.org.apache.http.impl;

import com.amazonaws.org.apache.http.HttpInetConnection;
import com.amazonaws.org.apache.http.impl.io.SocketInputBuffer;
import com.amazonaws.org.apache.http.impl.io.SocketOutputBuffer;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class SocketHttpClientConnection
  extends AbstractHttpClientConnection
  implements HttpInetConnection
{
  private volatile boolean open;
  private volatile Socket socket = null;
  
  private static void formatAddress(StringBuilder paramStringBuilder, SocketAddress paramSocketAddress)
  {
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
      if (localInetSocketAddress.getAddress() != null) {}
      for (paramSocketAddress = localInetSocketAddress.getAddress().getHostAddress();; paramSocketAddress = localInetSocketAddress.getAddress())
      {
        paramStringBuilder.append(paramSocketAddress).append(':').append(localInetSocketAddress.getPort());
        return;
      }
    }
    paramStringBuilder.append(paramSocketAddress);
  }
  
  protected void assertNotOpen()
  {
    if (this.open) {
      throw new IllegalStateException("Connection is already open");
    }
  }
  
  protected void assertOpen()
  {
    if (!this.open) {
      throw new IllegalStateException("Connection is not open");
    }
  }
  
  protected void bind(Socket paramSocket, HttpParams paramHttpParams)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("Socket may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    this.socket = paramSocket;
    int i = HttpConnectionParams.getSocketBufferSize(paramHttpParams);
    init(createSessionInputBuffer(paramSocket, i, paramHttpParams), createSessionOutputBuffer(paramSocket, i, paramHttpParams), paramHttpParams);
    this.open = true;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/amazonaws/org/apache/http/impl/SocketHttpClientConnection:open	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield 51	com/amazonaws/org/apache/http/impl/SocketHttpClientConnection:open	Z
    //   13: aload_0
    //   14: getfield 17	com/amazonaws/org/apache/http/impl/SocketHttpClientConnection:socket	Ljava/net/Socket;
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 96	com/amazonaws/org/apache/http/impl/SocketHttpClientConnection:doFlush	()V
    //   22: aload_1
    //   23: invokevirtual 101	java/net/Socket:shutdownOutput	()V
    //   26: aload_1
    //   27: invokevirtual 104	java/net/Socket:shutdownInput	()V
    //   30: aload_1
    //   31: invokevirtual 106	java/net/Socket:close	()V
    //   34: return
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 106	java/net/Socket:close	()V
    //   40: aload_2
    //   41: athrow
    //   42: astore_2
    //   43: goto -17 -> 26
    //   46: astore_2
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: goto -21 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	SocketHttpClientConnection
    //   17	20	1	localSocket	Socket
    //   35	6	2	localObject	Object
    //   42	1	2	localIOException1	java.io.IOException
    //   46	1	2	localIOException2	java.io.IOException
    //   50	1	2	localUnsupportedOperationException	UnsupportedOperationException
    // Exception table:
    //   from	to	target	type
    //   18	22	35	finally
    //   22	26	35	finally
    //   26	30	35	finally
    //   22	26	42	java/io/IOException
    //   26	30	46	java/io/IOException
    //   22	26	50	java/lang/UnsupportedOperationException
    //   26	30	50	java/lang/UnsupportedOperationException
  }
  
  protected SessionInputBuffer createSessionInputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    return new SocketInputBuffer(paramSocket, paramInt, paramHttpParams);
  }
  
  protected SessionOutputBuffer createSessionOutputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    return new SocketOutputBuffer(paramSocket, paramInt, paramHttpParams);
  }
  
  public InetAddress getRemoteAddress()
  {
    if (this.socket != null) {
      return this.socket.getInetAddress();
    }
    return null;
  }
  
  public int getRemotePort()
  {
    if (this.socket != null) {
      return this.socket.getPort();
    }
    return -1;
  }
  
  protected Socket getSocket()
  {
    return this.socket;
  }
  
  public boolean isOpen()
  {
    return this.open;
  }
  
  public void setSocketTimeout(int paramInt)
  {
    assertOpen();
    if (this.socket != null) {}
    try
    {
      this.socket.setSoTimeout(paramInt);
      return;
    }
    catch (SocketException localSocketException) {}
  }
  
  public void shutdown()
  {
    this.open = false;
    Socket localSocket = this.socket;
    if (localSocket != null) {
      localSocket.close();
    }
  }
  
  public String toString()
  {
    if (this.socket != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      SocketAddress localSocketAddress1 = this.socket.getRemoteSocketAddress();
      SocketAddress localSocketAddress2 = this.socket.getLocalSocketAddress();
      if ((localSocketAddress1 != null) && (localSocketAddress2 != null))
      {
        formatAddress(localStringBuilder, localSocketAddress2);
        localStringBuilder.append("<->");
        formatAddress(localStringBuilder, localSocketAddress1);
      }
      return localStringBuilder.toString();
    }
    return super.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/SocketHttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
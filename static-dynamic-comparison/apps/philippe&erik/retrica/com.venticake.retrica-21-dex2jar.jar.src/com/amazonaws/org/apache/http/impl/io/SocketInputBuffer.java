package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.io.EofSensor;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class SocketInputBuffer
  extends AbstractSessionInputBuffer
  implements EofSensor
{
  private boolean eof;
  private final Socket socket;
  
  public SocketInputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("Socket may not be null");
    }
    this.socket = paramSocket;
    this.eof = false;
    if (paramInt < 0) {
      paramInt = paramSocket.getReceiveBufferSize();
    }
    for (;;)
    {
      if (paramInt < 1024) {
        paramInt = i;
      }
      for (;;)
      {
        init(paramSocket.getInputStream(), paramInt, paramHttpParams);
        return;
      }
    }
  }
  
  protected int fillBuffer()
  {
    int i = super.fillBuffer();
    if (i == -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.eof = bool;
      return i;
    }
  }
  
  public boolean isDataAvailable(int paramInt)
  {
    boolean bool2 = hasBufferedData();
    boolean bool1 = bool2;
    int i;
    if (!bool2) {
      i = this.socket.getSoTimeout();
    }
    try
    {
      this.socket.setSoTimeout(paramInt);
      fillBuffer();
      bool1 = hasBufferedData();
      return bool1;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      throw localSocketTimeoutException;
    }
    finally
    {
      this.socket.setSoTimeout(i);
    }
  }
  
  public boolean isEof()
  {
    return this.eof;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/SocketInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
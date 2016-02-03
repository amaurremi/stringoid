package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.params.HttpParams;
import java.net.Socket;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class SocketOutputBuffer
  extends AbstractSessionOutputBuffer
{
  public SocketOutputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("Socket may not be null");
    }
    if (paramInt < 0) {
      paramInt = paramSocket.getSendBufferSize();
    }
    for (;;)
    {
      if (paramInt < 1024) {
        paramInt = i;
      }
      for (;;)
      {
        init(paramSocket.getOutputStream(), paramInt, paramHttpParams);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/SocketOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
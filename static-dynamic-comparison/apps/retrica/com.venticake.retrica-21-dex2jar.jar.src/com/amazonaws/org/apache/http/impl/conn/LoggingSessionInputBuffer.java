package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.Consts;
import com.amazonaws.org.apache.http.io.EofSensor;
import com.amazonaws.org.apache.http.io.HttpTransportMetrics;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.nio.charset.Charset;
import org.apache.http.annotation.Immutable;

@Immutable
public class LoggingSessionInputBuffer
  implements EofSensor, SessionInputBuffer
{
  private final String charset;
  private final EofSensor eofSensor;
  private final SessionInputBuffer in;
  private final Wire wire;
  
  public LoggingSessionInputBuffer(SessionInputBuffer paramSessionInputBuffer, Wire paramWire, String paramString)
  {
    this.in = paramSessionInputBuffer;
    if ((paramSessionInputBuffer instanceof EofSensor))
    {
      paramSessionInputBuffer = (EofSensor)paramSessionInputBuffer;
      this.eofSensor = paramSessionInputBuffer;
      this.wire = paramWire;
      if (paramString == null) {
        break label46;
      }
    }
    for (;;)
    {
      this.charset = paramString;
      return;
      paramSessionInputBuffer = null;
      break;
      label46:
      paramString = Consts.ASCII.name();
    }
  }
  
  public HttpTransportMetrics getMetrics()
  {
    return this.in.getMetrics();
  }
  
  public boolean isDataAvailable(int paramInt)
  {
    return this.in.isDataAvailable(paramInt);
  }
  
  public boolean isEof()
  {
    if (this.eofSensor != null) {
      return this.eofSensor.isEof();
    }
    return false;
  }
  
  public int read()
  {
    int i = this.in.read();
    if ((this.wire.enabled()) && (i != -1)) {
      this.wire.input(i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if ((this.wire.enabled()) && (paramInt2 > 0)) {
      this.wire.input(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public int readLine(CharArrayBuffer paramCharArrayBuffer)
  {
    int i = this.in.readLine(paramCharArrayBuffer);
    if ((this.wire.enabled()) && (i >= 0))
    {
      int j = paramCharArrayBuffer.length();
      paramCharArrayBuffer = new String(paramCharArrayBuffer.buffer(), j - i, i);
      paramCharArrayBuffer = paramCharArrayBuffer + "\r\n";
      this.wire.input(paramCharArrayBuffer.getBytes(this.charset));
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/LoggingSessionInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
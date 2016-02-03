package com.amazonaws.org.apache.http.impl.conn;

import com.amazonaws.org.apache.http.Consts;
import com.amazonaws.org.apache.http.io.HttpTransportMetrics;
import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.nio.charset.Charset;
import org.apache.http.annotation.Immutable;

@Immutable
public class LoggingSessionOutputBuffer
  implements SessionOutputBuffer
{
  private final String charset;
  private final SessionOutputBuffer out;
  private final Wire wire;
  
  public LoggingSessionOutputBuffer(SessionOutputBuffer paramSessionOutputBuffer, Wire paramWire, String paramString)
  {
    this.out = paramSessionOutputBuffer;
    this.wire = paramWire;
    if (paramString != null) {}
    for (;;)
    {
      this.charset = paramString;
      return;
      paramString = Consts.ASCII.name();
    }
  }
  
  public void flush()
  {
    this.out.flush();
  }
  
  public HttpTransportMetrics getMetrics()
  {
    return this.out.getMetrics();
  }
  
  public void write(int paramInt)
  {
    this.out.write(paramInt);
    if (this.wire.enabled()) {
      this.wire.output(paramInt);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    if (this.wire.enabled()) {
      this.wire.output(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void writeLine(CharArrayBuffer paramCharArrayBuffer)
  {
    this.out.writeLine(paramCharArrayBuffer);
    if (this.wire.enabled())
    {
      paramCharArrayBuffer = new String(paramCharArrayBuffer.buffer(), 0, paramCharArrayBuffer.length());
      paramCharArrayBuffer = paramCharArrayBuffer + "\r\n";
      this.wire.output(paramCharArrayBuffer.getBytes(this.charset));
    }
  }
  
  public void writeLine(String paramString)
  {
    this.out.writeLine(paramString);
    if (this.wire.enabled())
    {
      paramString = paramString + "\r\n";
      this.wire.output(paramString.getBytes(this.charset));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/LoggingSessionOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.amazonaws.org.apache.http.impl.conn;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.http.annotation.Immutable;

@Immutable
public class Wire
{
  private final Log log;
  
  public Wire(Log paramLog)
  {
    this.log = paramLog;
  }
  
  private void wire(String paramString, InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      if (i == 13)
      {
        localStringBuilder.append("[\\r]");
      }
      else if (i == 10)
      {
        localStringBuilder.append("[\\n]\"");
        localStringBuilder.insert(0, "\"");
        localStringBuilder.insert(0, paramString);
        this.log.debug(localStringBuilder.toString());
        localStringBuilder.setLength(0);
      }
      else if ((i < 32) || (i > 127))
      {
        localStringBuilder.append("[0x");
        localStringBuilder.append(Integer.toHexString(i));
        localStringBuilder.append("]");
      }
      else
      {
        localStringBuilder.append((char)i);
      }
    }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.append('"');
      localStringBuilder.insert(0, '"');
      localStringBuilder.insert(0, paramString);
      this.log.debug(localStringBuilder.toString());
    }
  }
  
  public boolean enabled()
  {
    return this.log.isDebugEnabled();
  }
  
  public void input(int paramInt)
  {
    input(new byte[] { (byte)paramInt });
  }
  
  public void input(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Input may not be null");
    }
    wire("<< ", new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public void input(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Input may not be null");
    }
    wire("<< ", new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public void output(int paramInt)
  {
    output(new byte[] { (byte)paramInt });
  }
  
  public void output(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Output may not be null");
    }
    wire(">> ", new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public void output(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Output may not be null");
    }
    wire(">> ", new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/conn/Wire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
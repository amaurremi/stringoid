package com.amazonaws.org.apache.http.io;

import com.amazonaws.org.apache.http.util.CharArrayBuffer;

public abstract interface SessionOutputBuffer
{
  public abstract void flush();
  
  public abstract HttpTransportMetrics getMetrics();
  
  public abstract void write(int paramInt);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeLine(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract void writeLine(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/io/SessionOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.io.SessionOutputBuffer;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ContentLengthOutputStream
  extends OutputStream
{
  private boolean closed = false;
  private final long contentLength;
  private final SessionOutputBuffer out;
  private long total = 0L;
  
  public ContentLengthOutputStream(SessionOutputBuffer paramSessionOutputBuffer, long paramLong)
  {
    if (paramSessionOutputBuffer == null) {
      throw new IllegalArgumentException("Session output buffer may not be null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Content length may not be negative");
    }
    this.out = paramSessionOutputBuffer;
    this.contentLength = paramLong;
  }
  
  public void close()
  {
    if (!this.closed)
    {
      this.closed = true;
      this.out.flush();
    }
  }
  
  public void flush()
  {
    this.out.flush();
  }
  
  public void write(int paramInt)
  {
    if (this.closed) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (this.total < this.contentLength)
    {
      this.out.write(paramInt);
      this.total += 1L;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.closed) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (this.total < this.contentLength)
    {
      long l = this.contentLength - this.total;
      int i = paramInt2;
      if (paramInt2 > l) {
        i = (int)l;
      }
      this.out.write(paramArrayOfByte, paramInt1, i);
      this.total += i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/ContentLengthOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.amazonaws.javax.xml.stream.xerces.impl.io;

import com.amazonaws.javax.xml.stream.util.BufferAllocator;
import com.amazonaws.javax.xml.stream.util.ThreadLocalBufferAllocator;
import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Locale;

public class ASCIIReader
  extends Reader
{
  protected byte[] fBuffer;
  private MessageFormatter fFormatter = null;
  protected InputStream fInputStream;
  private Locale fLocale = null;
  
  public ASCIIReader(InputStream paramInputStream, int paramInt, MessageFormatter paramMessageFormatter, Locale paramLocale)
  {
    this.fInputStream = paramInputStream;
    this.fBuffer = ThreadLocalBufferAllocator.getBufferAllocator().getByteBuffer(paramInt);
    if (this.fBuffer == null) {
      this.fBuffer = new byte[paramInt];
    }
    this.fFormatter = paramMessageFormatter;
    this.fLocale = paramLocale;
  }
  
  public void close()
  {
    ThreadLocalBufferAllocator.getBufferAllocator().returnByteBuffer(this.fBuffer);
    this.fBuffer = null;
    this.fInputStream.close();
  }
  
  public void mark(int paramInt)
  {
    this.fInputStream.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.fInputStream.markSupported();
  }
  
  public int read()
  {
    int i = this.fInputStream.read();
    if (i > 128) {
      throw new IOException(this.fFormatter.formatMessage(this.fLocale, "InvalidASCII", new Object[] { Integer.toString(i) }));
    }
    return i;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 > this.fBuffer.length) {
      i = this.fBuffer.length;
    }
    i = this.fInputStream.read(this.fBuffer, 0, i);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      int j = this.fBuffer[paramInt2];
      if (j > 128) {
        throw new IOException(this.fFormatter.formatMessage(this.fLocale, "InvalidASCII", new Object[] { Integer.toString(j) }));
      }
      paramArrayOfChar[(paramInt1 + paramInt2)] = ((char)j);
      paramInt2 += 1;
    }
    return i;
  }
  
  public boolean ready()
  {
    return false;
  }
  
  public void reset()
  {
    this.fInputStream.reset();
  }
  
  public long skip(long paramLong)
  {
    return this.fInputStream.skip(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/impl/io/ASCIIReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
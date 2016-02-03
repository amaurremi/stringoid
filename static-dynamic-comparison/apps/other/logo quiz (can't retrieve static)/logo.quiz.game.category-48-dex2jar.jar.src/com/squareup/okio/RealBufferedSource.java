package com.squareup.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class RealBufferedSource
  implements BufferedSource
{
  public final Buffer buffer;
  private boolean closed;
  public final Source source;
  
  public RealBufferedSource(Source paramSource)
  {
    this(paramSource, new Buffer());
  }
  
  public RealBufferedSource(Source paramSource, Buffer paramBuffer)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.buffer = paramBuffer;
    this.source = paramSource;
  }
  
  public Buffer buffer()
  {
    return this.buffer;
  }
  
  public void close()
    throws IOException
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    this.source.close();
    this.buffer.clear();
  }
  
  public boolean exhausted()
    throws IOException
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    return (this.buffer.exhausted()) && (this.source.read(this.buffer, 2048L) == -1L);
  }
  
  public long indexOf(byte paramByte)
    throws IOException
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    long l1 = 0L;
    do
    {
      long l2 = this.buffer.indexOf(paramByte, l1);
      l1 = l2;
      if (l2 != -1L) {
        break;
      }
      l1 = this.buffer.size;
    } while (this.source.read(this.buffer, 2048L) != -1L);
    l1 = -1L;
    return l1;
  }
  
  public InputStream inputStream()
  {
    new InputStream()
    {
      public int available()
        throws IOException
      {
        if (RealBufferedSource.this.closed) {
          throw new IOException("closed");
        }
        return (int)Math.min(RealBufferedSource.this.buffer.size, 2147483647L);
      }
      
      public void close()
        throws IOException
      {
        RealBufferedSource.this.close();
      }
      
      public int read()
        throws IOException
      {
        if (RealBufferedSource.this.closed) {
          throw new IOException("closed");
        }
        if ((RealBufferedSource.this.buffer.size == 0L) && (RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 2048L) == -1L)) {
          return -1;
        }
        return RealBufferedSource.this.buffer.readByte() & 0xFF;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (RealBufferedSource.this.closed) {
          throw new IOException("closed");
        }
        Util.checkOffsetAndCount(paramAnonymousArrayOfByte.length, paramAnonymousInt1, paramAnonymousInt2);
        if ((RealBufferedSource.this.buffer.size == 0L) && (RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 2048L) == -1L)) {
          return -1;
        }
        return RealBufferedSource.this.buffer.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        return RealBufferedSource.this + ".inputStream()";
      }
    };
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 2048L) == -1L)) {
      return -1;
    }
    paramInt2 = (int)Math.min(paramInt2, this.buffer.size);
    return this.buffer.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if ((this.buffer.size == 0L) && (this.source.read(this.buffer, 2048L) == -1L)) {
      return -1L;
    }
    paramLong = Math.min(paramLong, this.buffer.size);
    return this.buffer.read(paramBuffer, paramLong);
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("sink == null");
    }
    long l1 = 0L;
    while (this.source.read(this.buffer, 2048L) != -1L)
    {
      l2 = this.buffer.completeSegmentByteCount();
      if (l2 > 0L)
      {
        l1 += l2;
        paramSink.write(this.buffer, l2);
      }
    }
    long l2 = l1;
    if (this.buffer.size() > 0L)
    {
      l2 = l1 + this.buffer.size();
      paramSink.write(this.buffer, this.buffer.size());
    }
    return l2;
  }
  
  public byte readByte()
    throws IOException
  {
    require(1L);
    return this.buffer.readByte();
  }
  
  public byte[] readByteArray()
    throws IOException
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteArray();
  }
  
  public byte[] readByteArray(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.buffer.readByteArray(paramLong);
  }
  
  public ByteString readByteString()
    throws IOException
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteString();
  }
  
  public ByteString readByteString(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.buffer.readByteString(paramLong);
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    try
    {
      require(paramLong);
      this.buffer.readFully(paramBuffer, paramLong);
      return;
    }
    catch (EOFException localEOFException)
    {
      paramBuffer.writeAll(this.buffer);
      throw localEOFException;
    }
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      require(paramArrayOfByte.length);
      this.buffer.readFully(paramArrayOfByte);
      return;
    }
    catch (EOFException localEOFException)
    {
      int i = 0;
      while (this.buffer.size > 0L)
      {
        int j = this.buffer.read(paramArrayOfByte, i, (int)this.buffer.size - i);
        if (j == -1) {
          throw new AssertionError();
        }
        i += j;
      }
      throw localEOFException;
    }
  }
  
  public int readInt()
    throws IOException
  {
    require(4L);
    return this.buffer.readInt();
  }
  
  public int readIntLe()
    throws IOException
  {
    require(4L);
    return this.buffer.readIntLe();
  }
  
  public long readLong()
    throws IOException
  {
    require(8L);
    return this.buffer.readLong();
  }
  
  public long readLongLe()
    throws IOException
  {
    require(8L);
    return this.buffer.readLongLe();
  }
  
  public short readShort()
    throws IOException
  {
    require(2L);
    return this.buffer.readShort();
  }
  
  public short readShortLe()
    throws IOException
  {
    require(2L);
    return this.buffer.readShortLe();
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws IOException
  {
    require(paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    return this.buffer.readString(paramLong, paramCharset);
  }
  
  public String readString(Charset paramCharset)
    throws IOException
  {
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    this.buffer.writeAll(this.source);
    return this.buffer.readString(paramCharset);
  }
  
  public String readUtf8()
    throws IOException
  {
    this.buffer.writeAll(this.source);
    return this.buffer.readUtf8();
  }
  
  public String readUtf8(long paramLong)
    throws IOException
  {
    require(paramLong);
    return this.buffer.readUtf8(paramLong);
  }
  
  public String readUtf8Line()
    throws IOException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.buffer.size != 0L) {
        return readUtf8(this.buffer.size);
      }
      return null;
    }
    return this.buffer.readUtf8Line(l);
  }
  
  public String readUtf8LineStrict()
    throws IOException
  {
    long l = indexOf((byte)10);
    if (l == -1L) {
      throw new EOFException();
    }
    return this.buffer.readUtf8Line(l);
  }
  
  public void require(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    while (this.buffer.size < paramLong) {
      if (this.source.read(this.buffer, 2048L) == -1L) {
        throw new EOFException();
      }
    }
  }
  
  public void skip(long paramLong)
    throws IOException
  {
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    do
    {
      long l = Math.min(paramLong, this.buffer.size());
      this.buffer.skip(l);
      paramLong -= l;
      if (paramLong <= 0L) {
        break;
      }
    } while ((this.buffer.size != 0L) || (this.source.read(this.buffer, 2048L) != -1L));
    throw new EOFException();
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
  
  public String toString()
  {
    return "buffer(" + this.source + ")";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okio/RealBufferedSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.fasterxml.jackson.core.io;

import java.io.InputStream;

public final class MergedStream
  extends InputStream
{
  byte[] _buffer;
  protected final IOContext _context;
  final int _end;
  final InputStream _in;
  int _ptr;
  
  public MergedStream(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._buffer = paramArrayOfByte;
    this._ptr = paramInt1;
    this._end = paramInt2;
  }
  
  private void freeMergedBuffer()
  {
    byte[] arrayOfByte = this._buffer;
    if (arrayOfByte != null)
    {
      this._buffer = null;
      if (this._context != null) {
        this._context.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  public int available()
  {
    if (this._buffer != null) {
      return this._end - this._ptr;
    }
    return this._in.available();
  }
  
  public void close()
  {
    freeMergedBuffer();
    this._in.close();
  }
  
  public void mark(int paramInt)
  {
    if (this._buffer == null) {
      this._in.mark(paramInt);
    }
  }
  
  public boolean markSupported()
  {
    return (this._buffer == null) && (this._in.markSupported());
  }
  
  public int read()
  {
    if (this._buffer != null)
    {
      byte[] arrayOfByte = this._buffer;
      int i = this._ptr;
      this._ptr = (i + 1);
      i = arrayOfByte[i];
      if (this._ptr >= this._end) {
        freeMergedBuffer();
      }
      return i & 0xFF;
    }
    return this._in.read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this._buffer != null)
    {
      int j = this._end - this._ptr;
      int i = paramInt2;
      if (paramInt2 > j) {
        i = j;
      }
      System.arraycopy(this._buffer, this._ptr, paramArrayOfByte, paramInt1, i);
      this._ptr += i;
      if (this._ptr >= this._end) {
        freeMergedBuffer();
      }
      return i;
    }
    return this._in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    if (this._buffer == null) {
      this._in.reset();
    }
  }
  
  public long skip(long paramLong)
  {
    long l1;
    if (this._buffer != null)
    {
      int i = this._end - this._ptr;
      if (i > paramLong)
      {
        this._ptr += (int)paramLong;
        return paramLong;
      }
      freeMergedBuffer();
      l1 = i + 0L;
      paramLong -= i;
    }
    for (;;)
    {
      long l2 = l1;
      if (paramLong > 0L) {
        l2 = l1 + this._in.skip(paramLong);
      }
      return l2;
      l1 = 0L;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/MergedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
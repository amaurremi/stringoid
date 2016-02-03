package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

abstract class BaseReader
  extends Reader
{
  protected byte[] _buffer;
  protected final IOContext _context;
  protected InputStream _in;
  protected int _length;
  protected int _ptr;
  protected char[] _tmpBuf = null;
  
  protected BaseReader(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._buffer = paramArrayOfByte;
    this._ptr = paramInt1;
    this._length = paramInt2;
  }
  
  public void close()
  {
    InputStream localInputStream = this._in;
    if (localInputStream != null)
    {
      this._in = null;
      freeBuffers();
      localInputStream.close();
    }
  }
  
  public final void freeBuffers()
  {
    byte[] arrayOfByte = this._buffer;
    if (arrayOfByte != null)
    {
      this._buffer = null;
      this._context.releaseReadIOBuffer(arrayOfByte);
    }
  }
  
  public int read()
  {
    if (this._tmpBuf == null) {
      this._tmpBuf = new char[1];
    }
    if (read(this._tmpBuf, 0, 1) < 1) {
      return -1;
    }
    return this._tmpBuf[0];
  }
  
  protected void reportBounds(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    throw new ArrayIndexOutOfBoundsException("read(buf," + paramInt1 + "," + paramInt2 + "), cbuf[" + paramArrayOfChar.length + "]");
  }
  
  protected void reportStrangeStream()
  {
    throw new IOException("Strange I/O stream, returned 0 bytes on read");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/BaseReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
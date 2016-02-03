package com.mongodb.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class ByteBufferInputStream
  extends InputStream
{
  final List<ByteBuffer> _lst;
  private int _pos = 0;
  
  public ByteBufferInputStream(List<ByteBuffer> paramList)
  {
    this(paramList, false);
  }
  
  public ByteBufferInputStream(List<ByteBuffer> paramList, boolean paramBoolean)
  {
    this._lst = paramList;
    if (paramBoolean)
    {
      paramList = this._lst.iterator();
      while (paramList.hasNext()) {
        ((ByteBuffer)paramList.next()).flip();
      }
    }
  }
  
  public int available()
  {
    int j = 0;
    int i = this._pos;
    while (i < this._lst.size())
    {
      j += ((ByteBuffer)this._lst.get(i)).remaining();
      i += 1;
    }
    return j;
  }
  
  public void close() {}
  
  public void mark(int paramInt)
  {
    throw new RuntimeException("mark not supported");
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
  {
    if (this._pos >= this._lst.size()) {
      return -1;
    }
    ByteBuffer localByteBuffer = (ByteBuffer)this._lst.get(this._pos);
    if (localByteBuffer.remaining() > 0) {
      return localByteBuffer.get() & 0xFF;
    }
    this._pos += 1;
    return read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i;
    if (this._pos >= this._lst.size()) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        ByteBuffer localByteBuffer = (ByteBuffer)this._lst.get(this._pos);
        if (localByteBuffer.remaining() == 0)
        {
          this._pos += 1;
          return read(paramArrayOfByte, paramInt1, paramInt2);
        }
        j = Math.min(paramInt2, localByteBuffer.remaining());
        localByteBuffer.get(paramArrayOfByte, paramInt1, j);
        i = j;
      } while (j == paramInt2);
      i = j;
    } while (this._pos + 1 >= this._lst.size());
    this._pos += 1;
    return j + read(paramArrayOfByte, paramInt1 + j, paramInt2 - j);
  }
  
  public void reset()
  {
    throw new RuntimeException("mark not supported");
  }
  
  public long skip(long paramLong)
  {
    long l = 0L;
    while ((paramLong >= 0L) && (this._pos < this._lst.size()))
    {
      ByteBuffer localByteBuffer = (ByteBuffer)this._lst.get(this._pos);
      if (localByteBuffer.remaining() < paramLong)
      {
        l += localByteBuffer.remaining();
        paramLong -= localByteBuffer.remaining();
        localByteBuffer.position(localByteBuffer.limit());
        this._pos += 1;
      }
      else
      {
        localByteBuffer.position((int)(localByteBuffer.position() + paramLong));
        return l + paramLong;
      }
    }
    return l;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/io/ByteBufferInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
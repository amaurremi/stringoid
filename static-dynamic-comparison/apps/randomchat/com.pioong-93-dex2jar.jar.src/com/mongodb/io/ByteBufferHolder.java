package com.mongodb.io;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ByteBufferHolder
{
  static final int _bufSize = 4096;
  List<ByteBuffer> _buffers = new ArrayList();
  final int _max;
  int _pos = 0;
  
  public ByteBufferHolder()
  {
    this(1073741824);
  }
  
  public ByteBufferHolder(int paramInt)
  {
    this._max = paramInt;
  }
  
  private void _addBucket()
  {
    if (capacity() + 4096 > this._max) {
      throw new RuntimeException("too big current:" + capacity());
    }
    this._buffers.add(ByteBuffer.allocateDirect(4096));
  }
  
  public int capacity()
  {
    return this._buffers.size() * 4096;
  }
  
  public byte get(int paramInt)
  {
    if (paramInt >= this._pos) {
      throw new RuntimeException("out of bounds");
    }
    int i = paramInt / 4096;
    return ((ByteBuffer)this._buffers.get(i)).get(paramInt % 4096);
  }
  
  public void get(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = get(i + paramInt);
      i += 1;
    }
  }
  
  public int position()
  {
    return this._pos;
  }
  
  public void position(int paramInt)
  {
    this._pos = paramInt;
    paramInt = this._pos / 4096;
    int i = this._pos;
    while (this._buffers.size() <= paramInt) {
      _addBucket();
    }
    ((ByteBuffer)this._buffers.get(paramInt)).position(i % 4096);
    paramInt += 1;
    while (paramInt < this._buffers.size())
    {
      ((ByteBuffer)this._buffers.get(paramInt)).position(0);
      paramInt += 1;
    }
  }
  
  public void put(int paramInt, byte paramByte)
  {
    if (paramInt >= this._pos) {
      throw new RuntimeException("out of bounds");
    }
    int i = paramInt / 4096;
    ((ByteBuffer)this._buffers.get(i)).put(paramInt % 4096, paramByte);
  }
  
  public void put(ByteBuffer paramByteBuffer)
  {
    while (paramByteBuffer.hasRemaining())
    {
      int i = this._pos / 4096;
      if (i >= this._buffers.size()) {
        _addBucket();
      }
      ByteBuffer localByteBuffer = (ByteBuffer)this._buffers.get(i);
      i = Math.min(localByteBuffer.remaining(), paramByteBuffer.remaining());
      int j = paramByteBuffer.limit();
      paramByteBuffer.limit(paramByteBuffer.position() + i);
      localByteBuffer.put(paramByteBuffer);
      paramByteBuffer.limit(j);
      this._pos += i;
    }
  }
  
  public int remaining()
  {
    return Integer.MAX_VALUE;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ ByteBufferHolder pos:" + this._pos + " ");
    Iterator localIterator = this._buffers.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((ByteBuffer)localIterator.next()).append(" ");
    }
    return "}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/io/ByteBufferHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
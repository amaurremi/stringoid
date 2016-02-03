package com.mongodb.io;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ByteBufferOutputStream
  extends OutputStream
{
  static final ByteBufferFactory _defaultFactory = new ByteBufferFactory.SimpleHeapByteBufferFactory(4096);
  final ByteBufferFactory _factory;
  final List<ByteBuffer> _lst = new ArrayList();
  
  public ByteBufferOutputStream()
  {
    this(_defaultFactory);
  }
  
  public ByteBufferOutputStream(int paramInt)
  {
    this(new ByteBufferFactory.SimpleHeapByteBufferFactory(paramInt));
  }
  
  public ByteBufferOutputStream(ByteBufferFactory paramByteBufferFactory)
  {
    this._factory = paramByteBufferFactory;
  }
  
  private ByteBuffer _need(int paramInt)
  {
    if (this._lst.size() == 0)
    {
      this._lst.add(this._factory.get());
      return (ByteBuffer)this._lst.get(0);
    }
    ByteBuffer localByteBuffer = (ByteBuffer)this._lst.get(this._lst.size() - 1);
    if (paramInt <= localByteBuffer.remaining()) {
      return localByteBuffer;
    }
    this._lst.add(this._factory.get());
    return (ByteBuffer)this._lst.get(this._lst.size() - 1);
  }
  
  public void close() {}
  
  public void flush() {}
  
  public List<ByteBuffer> getBuffers()
  {
    return this._lst;
  }
  
  public List<ByteBuffer> getBuffers(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this._lst.iterator();
      while (localIterator.hasNext()) {
        ((ByteBuffer)localIterator.next()).flip();
      }
    }
    return this._lst;
  }
  
  public void write(int paramInt)
  {
    _need(1).put((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = _need(1);
    int i = Math.min(paramInt2, localByteBuffer.remaining());
    localByteBuffer.put(paramArrayOfByte, paramInt1, i);
    if (i == paramInt2) {
      return;
    }
    write(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/io/ByteBufferOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
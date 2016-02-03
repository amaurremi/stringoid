package com.mongodb.io;

import java.nio.ByteBuffer;

public abstract interface ByteBufferFactory
{
  public abstract ByteBuffer get();
  
  public static class SimpleHeapByteBufferFactory
    implements ByteBufferFactory
  {
    final int _size;
    
    public SimpleHeapByteBufferFactory(int paramInt)
    {
      this._size = paramInt;
    }
    
    public ByteBuffer get()
    {
      return ByteBuffer.wrap(new byte[this._size]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/io/ByteBufferFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
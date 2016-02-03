package com.fasterxml.jackson.core.util;

public class BufferRecycler
{
  protected final byte[][] _byteBuffers = new byte[BufferRecycler.ByteBufferType.values().length][];
  protected final char[][] _charBuffers = new char[BufferRecycler.CharBufferType.values().length][];
  
  private byte[] balloc(int paramInt)
  {
    return new byte[paramInt];
  }
  
  private char[] calloc(int paramInt)
  {
    return new char[paramInt];
  }
  
  public final byte[] allocByteBuffer(BufferRecycler.ByteBufferType paramByteBufferType)
  {
    int i = paramByteBufferType.ordinal();
    byte[] arrayOfByte = this._byteBuffers[i];
    if (arrayOfByte == null) {
      return balloc(paramByteBufferType.size);
    }
    this._byteBuffers[i] = null;
    return arrayOfByte;
  }
  
  public final char[] allocCharBuffer(BufferRecycler.CharBufferType paramCharBufferType)
  {
    return allocCharBuffer(paramCharBufferType, 0);
  }
  
  public final char[] allocCharBuffer(BufferRecycler.CharBufferType paramCharBufferType, int paramInt)
  {
    int i = paramInt;
    if (paramCharBufferType.size > paramInt) {
      i = paramCharBufferType.size;
    }
    paramInt = paramCharBufferType.ordinal();
    paramCharBufferType = this._charBuffers[paramInt];
    if ((paramCharBufferType == null) || (paramCharBufferType.length < i)) {
      return calloc(i);
    }
    this._charBuffers[paramInt] = null;
    return paramCharBufferType;
  }
  
  public final void releaseByteBuffer(BufferRecycler.ByteBufferType paramByteBufferType, byte[] paramArrayOfByte)
  {
    this._byteBuffers[paramByteBufferType.ordinal()] = paramArrayOfByte;
  }
  
  public final void releaseCharBuffer(BufferRecycler.CharBufferType paramCharBufferType, char[] paramArrayOfChar)
  {
    this._charBuffers[paramCharBufferType.ordinal()] = paramArrayOfChar;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/util/BufferRecycler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class ByteArrayBuilder
  extends OutputStream
{
  private static final byte[] NO_BYTES = new byte[0];
  private final BufferRecycler _bufferRecycler;
  private byte[] _currBlock;
  private int _currBlockPtr;
  private final LinkedList<byte[]> _pastBlocks = new LinkedList();
  private int _pastLen;
  
  public ByteArrayBuilder()
  {
    this(null);
  }
  
  public ByteArrayBuilder(int paramInt)
  {
    this(null, paramInt);
  }
  
  public ByteArrayBuilder(BufferRecycler paramBufferRecycler)
  {
    this(paramBufferRecycler, 500);
  }
  
  public ByteArrayBuilder(BufferRecycler paramBufferRecycler, int paramInt)
  {
    this._bufferRecycler = paramBufferRecycler;
    if (paramBufferRecycler == null)
    {
      this._currBlock = new byte[paramInt];
      return;
    }
    this._currBlock = paramBufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER);
  }
  
  private void _allocMore()
  {
    int i = 262144;
    this._pastLen += this._currBlock.length;
    int j = Math.max(this._pastLen >> 1, 1000);
    if (j > 262144) {}
    for (;;)
    {
      this._pastBlocks.add(this._currBlock);
      this._currBlock = new byte[i];
      this._currBlockPtr = 0;
      return;
      i = j;
    }
  }
  
  public void append(int paramInt)
  {
    if (this._currBlockPtr >= this._currBlock.length) {
      _allocMore();
    }
    byte[] arrayOfByte = this._currBlock;
    int i = this._currBlockPtr;
    this._currBlockPtr = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }
  
  public void appendThreeBytes(int paramInt)
  {
    if (this._currBlockPtr + 2 < this._currBlock.length)
    {
      byte[] arrayOfByte = this._currBlock;
      int i = this._currBlockPtr;
      this._currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 16));
      arrayOfByte = this._currBlock;
      i = this._currBlockPtr;
      this._currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      arrayOfByte = this._currBlock;
      i = this._currBlockPtr;
      this._currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    append(paramInt >> 16);
    append(paramInt >> 8);
    append(paramInt);
  }
  
  public void appendTwoBytes(int paramInt)
  {
    if (this._currBlockPtr + 1 < this._currBlock.length)
    {
      byte[] arrayOfByte = this._currBlock;
      int i = this._currBlockPtr;
      this._currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      arrayOfByte = this._currBlock;
      i = this._currBlockPtr;
      this._currBlockPtr = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    append(paramInt >> 8);
    append(paramInt);
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void reset()
  {
    this._pastLen = 0;
    this._currBlockPtr = 0;
    if (!this._pastBlocks.isEmpty()) {
      this._pastBlocks.clear();
    }
  }
  
  public byte[] toByteArray()
  {
    int j = this._pastLen + this._currBlockPtr;
    if (j == 0) {
      return NO_BYTES;
    }
    byte[] arrayOfByte1 = new byte[j];
    Iterator localIterator = this._pastBlocks.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte2 = (byte[])localIterator.next();
      int k = arrayOfByte2.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, k);
      i += k;
    }
    System.arraycopy(this._currBlock, 0, arrayOfByte1, i, this._currBlockPtr);
    i = this._currBlockPtr + i;
    if (i != j) {
      throw new RuntimeException("Internal error: total len assumed to be " + j + ", copied " + i + " bytes");
    }
    if (!this._pastBlocks.isEmpty()) {
      reset();
    }
    return arrayOfByte1;
  }
  
  public void write(int paramInt)
  {
    append(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      int k = Math.min(this._currBlock.length - this._currBlockPtr, paramInt2);
      int j = i;
      paramInt1 = paramInt2;
      if (k > 0)
      {
        System.arraycopy(paramArrayOfByte, i, this._currBlock, this._currBlockPtr, k);
        j = i + k;
        this._currBlockPtr += k;
        paramInt1 = paramInt2 - k;
      }
      if (paramInt1 <= 0) {
        return;
      }
      _allocMore();
      i = j;
      paramInt2 = paramInt1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/util/ByteArrayBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
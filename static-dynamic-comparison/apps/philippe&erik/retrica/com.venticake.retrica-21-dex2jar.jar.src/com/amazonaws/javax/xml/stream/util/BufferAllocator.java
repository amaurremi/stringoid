package com.amazonaws.javax.xml.stream.util;

public class BufferAllocator
{
  public static int LARGE_SIZE_LIMIT = 8192;
  public static int MEDIUM_SIZE_LIMIT;
  public static int SMALL_SIZE_LIMIT = 128;
  byte[] largeByteBuffer;
  char[] largeCharBuffer;
  byte[] mediumByteBuffer;
  char[] mediumCharBuffer;
  byte[] smallByteBuffer;
  char[] smallCharBuffer;
  
  static
  {
    MEDIUM_SIZE_LIMIT = 2048;
  }
  
  public byte[] getByteBuffer(int paramInt)
  {
    byte[] arrayOfByte;
    if (paramInt <= SMALL_SIZE_LIMIT)
    {
      arrayOfByte = this.smallByteBuffer;
      this.smallByteBuffer = null;
      return arrayOfByte;
    }
    if (paramInt <= MEDIUM_SIZE_LIMIT)
    {
      arrayOfByte = this.mediumByteBuffer;
      this.mediumByteBuffer = null;
      return arrayOfByte;
    }
    if (paramInt <= LARGE_SIZE_LIMIT)
    {
      arrayOfByte = this.largeByteBuffer;
      this.largeByteBuffer = null;
      return arrayOfByte;
    }
    return null;
  }
  
  public char[] getCharBuffer(int paramInt)
  {
    char[] arrayOfChar;
    if (paramInt <= SMALL_SIZE_LIMIT)
    {
      arrayOfChar = this.smallCharBuffer;
      this.smallCharBuffer = null;
      return arrayOfChar;
    }
    if (paramInt <= MEDIUM_SIZE_LIMIT)
    {
      arrayOfChar = this.mediumCharBuffer;
      this.mediumCharBuffer = null;
      return arrayOfChar;
    }
    if (paramInt <= LARGE_SIZE_LIMIT)
    {
      arrayOfChar = this.largeCharBuffer;
      this.largeCharBuffer = null;
      return arrayOfChar;
    }
    return null;
  }
  
  public void returnByteBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      if (paramArrayOfByte.length <= SMALL_SIZE_LIMIT)
      {
        this.smallByteBuffer = paramArrayOfByte;
        return;
      }
      if (paramArrayOfByte.length <= MEDIUM_SIZE_LIMIT)
      {
        this.mediumByteBuffer = paramArrayOfByte;
        return;
      }
    } while (paramArrayOfByte.length > LARGE_SIZE_LIMIT);
    this.largeByteBuffer = paramArrayOfByte;
  }
  
  public void returnCharBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {}
    do
    {
      return;
      if (paramArrayOfChar.length <= SMALL_SIZE_LIMIT)
      {
        this.smallCharBuffer = paramArrayOfChar;
        return;
      }
      if (paramArrayOfChar.length <= MEDIUM_SIZE_LIMIT)
      {
        this.mediumCharBuffer = paramArrayOfChar;
        return;
      }
    } while (paramArrayOfChar.length > LARGE_SIZE_LIMIT);
    this.largeCharBuffer = paramArrayOfChar;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/util/BufferAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
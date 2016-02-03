package org.bson.io;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bson.BSONException;

public class BSONByteBuffer
{
  protected ByteBuffer buf;
  
  private BSONByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.buf = paramByteBuffer;
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  public static BSONByteBuffer wrap(byte[] paramArrayOfByte)
  {
    return new BSONByteBuffer(ByteBuffer.wrap(paramArrayOfByte));
  }
  
  public static BSONByteBuffer wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new BSONByteBuffer(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public byte[] array()
  {
    return this.buf.array();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (BSONByteBuffer)paramObject;
      if (this.buf == null) {
        break;
      }
    } while (this.buf.equals(((BSONByteBuffer)paramObject).buf));
    for (;;)
    {
      return false;
      if (((BSONByteBuffer)paramObject).buf == null) {
        break;
      }
    }
  }
  
  public byte get(int paramInt)
  {
    return this.buf.get(paramInt);
  }
  
  public ByteBuffer get(byte[] paramArrayOfByte)
  {
    return this.buf.get(paramArrayOfByte);
  }
  
  public ByteBuffer get(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.buf.get(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String getCString(int paramInt)
  {
    int i = paramInt;
    while (get(i) != 0) {
      i += 1;
    }
    return new String(array(), paramInt, i - paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return getIntLE(paramInt);
  }
  
  public int getIntBE(int paramInt)
  {
    return 0x0 | (this.buf.get(paramInt + 0) & 0xFF) << 24 | (this.buf.get(paramInt + 1) & 0xFF) << 16 | (this.buf.get(paramInt + 2) & 0xFF) << 8 | (this.buf.get(paramInt + 3) & 0xFF) << 0;
  }
  
  public int getIntLE(int paramInt)
  {
    return 0x0 | (this.buf.get(paramInt + 0) & 0xFF) << 0 | (this.buf.get(paramInt + 1) & 0xFF) << 8 | (this.buf.get(paramInt + 2) & 0xFF) << 16 | (this.buf.get(paramInt + 3) & 0xFF) << 24;
  }
  
  public long getLong(int paramInt)
  {
    return this.buf.getLong(paramInt);
  }
  
  public String getUTF8String(int paramInt)
  {
    int i = getInt(paramInt);
    try
    {
      String str = new String(array(), paramInt + 4, i - 1, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new BSONException("Cannot decode string as UTF-8.");
    }
  }
  
  public int hashCode()
  {
    return this.buf.hashCode();
  }
  
  public Buffer position(int paramInt)
  {
    return this.buf.position(paramInt);
  }
  
  public Buffer reset()
  {
    return this.buf.reset();
  }
  
  public int size()
  {
    return getInt(0);
  }
  
  public String toString()
  {
    return this.buf.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/io/BSONByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
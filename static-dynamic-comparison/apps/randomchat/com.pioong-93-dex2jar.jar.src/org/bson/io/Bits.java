package org.bson.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class Bits
{
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramInputStream, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    readFully(paramInputStream, paramArrayOfByte, 0, paramInt);
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramArrayOfByte.length - paramInt1 > paramInt2) {
      throw new IllegalArgumentException("Buffer is too small");
    }
    while (paramInt2 > 0)
    {
      int i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i < 0) {
        throw new EOFException();
      }
      paramInt2 -= i;
      paramInt1 += i;
    }
  }
  
  public static int readInt(InputStream paramInputStream)
    throws IOException
  {
    return readInt(paramInputStream, new byte[4]);
  }
  
  public static int readInt(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramInputStream, paramArrayOfByte, 4);
    return readInt(paramArrayOfByte);
  }
  
  public static int readInt(byte[] paramArrayOfByte)
  {
    return readInt(paramArrayOfByte, 0);
  }
  
  public static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    return 0x0 | (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  public static int readIntBE(byte[] paramArrayOfByte, int paramInt)
  {
    return 0x0 | (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0;
  }
  
  public static long readLong(InputStream paramInputStream)
    throws IOException
  {
    return readLong(paramInputStream, new byte[8]);
  }
  
  public static long readLong(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramInputStream, paramArrayOfByte, 8);
    return readLong(paramArrayOfByte);
  }
  
  public static long readLong(byte[] paramArrayOfByte)
  {
    return readLong(paramArrayOfByte, 0);
  }
  
  public static long readLong(byte[] paramArrayOfByte, int paramInt)
  {
    return 0L | (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 4)] & 0xFF) << 32 | (paramArrayOfByte[(paramInt + 5)] & 0xFF) << 40 | (paramArrayOfByte[(paramInt + 6)] & 0xFF) << 48 | (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/io/Bits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mongodb.util;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util
{
  public static String hexMD5(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      arrayOfByte[i] = paramByteBuffer.get(paramInt1 + i);
      i += 1;
    }
    return hexMD5(arrayOfByte);
  }
  
  public static String hexMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = toHex(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException("Error - this implementation of Java doesn't support MD5.");
    }
  }
  
  public static String toHex(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
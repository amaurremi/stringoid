package com.amazonaws.util;

public enum CodecUtils
{
  public static byte[] toBytesDirect(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[arrayOfChar.length];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = arrayOfChar[i];
      if (j > 127) {
        throw new IllegalArgumentException("Invalid character found at position " + i + " for " + paramString);
      }
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String toStringDirect(byte[] paramArrayOfByte)
  {
    int j = 0;
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    int k = paramArrayOfByte.length;
    int i = 0;
    while (j < k)
    {
      arrayOfChar[i] = ((char)paramArrayOfByte[j]);
      j += 1;
      i += 1;
    }
    return new String(arrayOfChar);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/CodecUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
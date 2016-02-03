package com.amazonaws.util;

import java.util.Locale;

public class BinaryUtils
{
  public static String toBase64(byte[] paramArrayOfByte)
  {
    return Base64.encodeAsString(paramArrayOfByte);
  }
  
  public static String toHex(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i]);
      String str1;
      if (str2.length() == 1)
      {
        localStringBuilder.append("0");
        str1 = str2;
      }
      for (;;)
      {
        localStringBuilder.append(str1);
        i += 1;
        break;
        str1 = str2;
        if (str2.length() == 8) {
          str1 = str2.substring(6);
        }
      }
    }
    return localStringBuilder.toString().toLowerCase(Locale.getDefault());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/BinaryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
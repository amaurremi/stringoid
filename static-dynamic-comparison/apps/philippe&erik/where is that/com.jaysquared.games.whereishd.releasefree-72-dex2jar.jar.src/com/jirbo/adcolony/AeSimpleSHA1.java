package com.jirbo.adcolony;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class AeSimpleSHA1
{
  private static String convertToHex(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramArrayOfByte.length;
    int i = 0;
    int n;
    int k;
    int j;
    if (i < m)
    {
      n = paramArrayOfByte[i];
      k = n >>> 4 & 0xF;
      j = 0;
    }
    for (;;)
    {
      if ((k >= 0) && (k <= 9)) {}
      for (char c = (char)(k + 48);; c = (char)(k - 10 + 97))
      {
        localStringBuilder.append(c);
        k = n & 0xF;
        if (j < 1) {
          break label101;
        }
        i += 1;
        break;
      }
      return localStringBuilder.toString();
      label101:
      j += 1;
    }
  }
  
  public static String sha1(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.update(paramString.getBytes("iso-8859-1"), 0, paramString.length());
    return convertToHex(localMessageDigest.digest());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/AeSimpleSHA1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
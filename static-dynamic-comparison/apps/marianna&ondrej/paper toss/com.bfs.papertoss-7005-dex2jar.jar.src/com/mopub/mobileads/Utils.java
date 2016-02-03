package com.mopub.mobileads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils
{
  public static String sha1(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i = 0;
      while (i < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF | 0x100).substring(1));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
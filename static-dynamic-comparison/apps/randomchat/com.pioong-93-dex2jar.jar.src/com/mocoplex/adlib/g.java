package com.mocoplex.adlib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class g
{
  static String a;
  
  static String a(String paramString)
  {
    localObject1 = null;
    try
    {
      localObject2 = MessageDigest.getInstance("MD5");
      localObject1 = localObject2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        localNoSuchAlgorithmException.printStackTrace();
        continue;
        int j = localNoSuchAlgorithmException[i] & 0xFF;
        localObject1 = paramString;
        if (j <= 15) {
          localObject1 = paramString + "0";
        }
        paramString = localObject1 + Integer.toHexString(j);
        i += 1;
      }
    }
    ((MessageDigest)localObject1).update(paramString.getBytes(), 0, paramString.length());
    localObject2 = ((MessageDigest)localObject1).digest();
    paramString = new String();
    i = 0;
    if (i >= localObject2.length) {
      return paramString.toUpperCase();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
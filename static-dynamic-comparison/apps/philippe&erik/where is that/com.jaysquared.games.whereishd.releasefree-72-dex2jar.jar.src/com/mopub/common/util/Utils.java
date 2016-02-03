package com.mopub.common.util;

import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicLong;

public class Utils
{
  private static final AtomicLong sNextGeneratedId = new AtomicLong(1L);
  
  public static long generateUniqueId()
  {
    long l3;
    long l1;
    do
    {
      l3 = sNextGeneratedId.get();
      long l2 = l3 + 1L;
      l1 = l2;
      if (l2 > 9223372036854775806L) {
        l1 = 1L;
      }
    } while (!sNextGeneratedId.compareAndSet(l3, l1));
    return l3;
  }
  
  public static String sha1(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      paramString = paramString.getBytes("UTF-8");
      localMessageDigest.update(paramString, 0, paramString.length);
      paramString = localMessageDigest.digest();
      int j = paramString.length;
      while (i < j)
      {
        localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramString[i]) }));
        i += 1;
      }
      paramString = localStringBuilder.toString().toLowerCase();
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
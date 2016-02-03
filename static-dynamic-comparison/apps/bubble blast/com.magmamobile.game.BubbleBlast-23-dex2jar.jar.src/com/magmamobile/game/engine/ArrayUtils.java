package com.magmamobile.game.engine;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public final class ArrayUtils
{
  private static final char[] HEXDIGITS = "0123456789abcdef".toCharArray();
  
  public static final boolean isNullOrEmpty(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {}
    while (paramArrayOfObject.length <= 0) {
      return true;
    }
    return false;
  }
  
  public static final String md5(Context paramContext)
  {
    try
    {
      paramContext = new FileInputStream(paramContext.getApplicationInfo().sourceDir);
      String str = md5(paramContext);
      paramContext.close();
      return str;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static final String md5(InputStream paramInputStream)
  {
    int i = 0;
    try
    {
      Object localObject = new byte['က'];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      int j = paramInputStream.read((byte[])localObject);
      if (j == -1)
      {
        paramInputStream = localMessageDigest.digest();
        localObject = new StringBuilder(32);
        j = paramInputStream.length;
      }
      for (;;)
      {
        if (i >= j)
        {
          return ((StringBuilder)localObject).toString();
          localMessageDigest.update((byte[])localObject, 0, j);
          break;
        }
        int k = paramInputStream[i];
        ((StringBuilder)localObject).append(HEXDIGITS[(k >> 4 & 0xF)]);
        ((StringBuilder)localObject).append(HEXDIGITS[(k & 0xF)]);
        i += 1;
      }
      return null;
    }
    catch (Exception paramInputStream) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
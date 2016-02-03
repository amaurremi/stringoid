package com.vungle.publisher;

import com.vungle.publisher.log.Logger;
import java.io.File;

public final class bk
{
  public static String a(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 2)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {
        throw new IllegalArgumentException("null path element at index " + i);
      }
      localStringBuilder.append(localObject);
      int j = localStringBuilder.length();
      if ((j > 0) && (i + 1 < 2) && (localStringBuilder.charAt(j - 1) != File.separatorChar)) {
        localStringBuilder.append(File.separatorChar);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean a(File paramFile)
  {
    int k;
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int m = arrayOfFile.length;
      int j = 0;
      int i = 1;
      k = i;
      if (j < m)
      {
        if ((a(arrayOfFile[j])) && (i != 0)) {}
        for (i = 1;; i = 0)
        {
          j += 1;
          break;
        }
      }
    }
    else
    {
      k = 1;
    }
    return (paramFile.delete()) && (k != 0);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = a(new File(paramString));
    if (bool)
    {
      Logger.d("VungleFile", "successfully deleted: " + paramString);
      return bool;
    }
    Logger.w("VungleFile", "could not delete: " + paramString);
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
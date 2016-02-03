package com.mopub.common.util;

import java.io.File;

public class Files
{
  public static File createDirectory(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    File localFile;
    do
    {
      do
      {
        return paramString;
        localFile = new File(paramString);
        if (!localFile.exists()) {
          break;
        }
        paramString = localFile;
      } while (localFile.isDirectory());
      if (!localFile.mkdirs()) {
        break;
      }
      paramString = localFile;
    } while (localFile.isDirectory());
    return null;
  }
  
  public static int intLength(File paramFile)
  {
    if (paramFile == null) {
      return 0;
    }
    long l = paramFile.length();
    if (l < 2147483647L) {
      return (int)l;
    }
    return Integer.MAX_VALUE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.jaysquared.games.whereishd.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Utils
{
  private static final String LOG_TAG = Utils.class.getSimpleName();
  
  public static void inputstreamToFile(InputStream paramInputStream, File paramFile)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramFile.write(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramInputStream)
    {
      SLog.d(LOG_TAG, "Downloading file failed: " + paramInputStream.getMessage());
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
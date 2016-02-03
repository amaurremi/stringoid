package com.vungle.sdk;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

abstract class as
{
  public static boolean a(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists())
    {
      ((File)localObject1).mkdirs();
      if (!((File)localObject1).isDirectory()) {
        return false;
      }
    }
    if (!((File)localObject1).isDirectory()) {
      return false;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        paramString1 = new File(paramString1);
        if (!paramString1.exists())
        {
          Log.e("unzipInto", "Provided zip-file does not exist.");
          return false;
        }
        paramString1 = new ZipFile(paramString1);
        localObject1 = paramString1.entries();
        if (!((Enumeration)localObject1).hasMoreElements()) {
          break;
        }
        localObject3 = (ZipEntry)((Enumeration)localObject1).nextElement();
        if (((ZipEntry)localObject3).isDirectory())
        {
          localObject2 = new File(paramString2, ((ZipEntry)localObject3).getName());
          ((File)localObject2).mkdirs();
          if (((File)localObject2).isDirectory()) {
            continue;
          }
          return false;
        }
        Object localObject2 = paramString1.getInputStream((ZipEntry)localObject3);
        localObject3 = new FileOutputStream(new File(paramString2, ((ZipEntry)localObject3).getName()));
        byte[] arrayOfByte = new byte['ࠀ'];
        int i = ((InputStream)localObject2).read(arrayOfByte, 0, 2048);
        if (i >= 0)
        {
          ((FileOutputStream)localObject3).write(arrayOfByte, 0, i);
          continue;
        }
        ((InputStream)localObject2).close();
      }
      catch (IOException paramString1)
      {
        Log.e("unzipInto", "IO Exception during decompression: " + paramString1.getMessage());
        return false;
      }
      ((FileOutputStream)localObject3).close();
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
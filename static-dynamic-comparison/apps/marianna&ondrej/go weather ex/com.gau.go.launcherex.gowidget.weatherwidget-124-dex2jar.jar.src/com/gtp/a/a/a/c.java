package com.gtp.a.a.a;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class c
{
  private static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    Object localObject = new StringBuilder().append(paramString);
    if (paramString.trim().length() == 0) {}
    int i;
    for (paramString = "";; paramString = File.separator)
    {
      paramString = new String((paramString + paramFile.getName()).getBytes("8859_1"), "GB2312");
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
      int j = paramFile.length;
      i = 0;
      while (i < j)
      {
        a(paramFile[i], paramZipOutputStream, paramString);
        i += 1;
      }
    }
    localObject = new byte[1048576];
    paramFile = new BufferedInputStream(new FileInputStream(paramFile), 1048576);
    paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
    for (;;)
    {
      i = paramFile.read((byte[])localObject);
      if (i == -1) {
        break;
      }
      paramZipOutputStream.write((byte[])localObject, 0, i);
    }
    paramFile.close();
    paramZipOutputStream.flush();
    paramZipOutputStream.closeEntry();
  }
  
  public static void a(Collection paramCollection, File paramFile)
  {
    paramFile = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile), 1048576));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a((File)paramCollection.next(), paramFile, "");
    }
    paramFile.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
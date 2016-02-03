package com.gau.go.launcherex.gowidget.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public abstract class f
{
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString1.getBytes());
    localGZIPOutputStream.close();
    paramString1 = localByteArrayOutputStream.toString(paramString2);
    localByteArrayOutputStream.close();
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString1.getBytes(paramString2));
    localGZIPOutputStream.close();
    paramString1 = localByteArrayOutputStream.toString(paramString3);
    localByteArrayOutputStream.close();
    return paramString1;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramString1 = new ByteArrayInputStream(paramString1.getBytes(paramString2));
    paramString2 = new GZIPInputStream(paramString1);
    byte[] arrayOfByte = new byte['Ā'];
    for (;;)
    {
      int i = paramString2.read(arrayOfByte);
      if (i < 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramString3 = localByteArrayOutputStream.toString(paramString3);
    try
    {
      localByteArrayOutputStream.close();
      paramString2.close();
      paramString1.close();
      return paramString3;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
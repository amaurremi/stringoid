package com.jiubang.playsdk.g;

import android.os.Environment;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c
{
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['က'];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (-1 == j) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
    return i;
  }
  
  public static File a()
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "GOWeatherEX");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    if (((File)localObject).isDirectory()) {}
    File localFile;
    do
    {
      return (File)localObject;
      localFile = new File("/mnt/emmc/GOWeatherEX");
      localObject = localFile;
    } while (localFile.exists());
    localFile.mkdir();
    return localFile;
  }
  
  public static File a(String paramString, boolean paramBoolean)
  {
    paramString = new File(paramString);
    if ((!paramBoolean) && (paramString.exists())) {
      paramString.delete();
    }
    if (!paramString.exists()) {}
    try
    {
      File localFile = paramString.getParentFile();
      if ((localFile != null) && (!localFile.exists())) {
        localFile.mkdirs();
      }
      paramString.createNewFile();
      return paramString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = new FileOutputStream(a(paramString, false));
      paramString.write(paramArrayOfByte);
      paramString.flush();
      paramString.close();
      return true;
    }
    catch (FileNotFoundException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return false;
    }
    catch (SecurityException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    FileInputStream localFileInputStream;
    byte[] arrayOfByte;
    do
    {
      return paramString;
      paramString = new File(paramString);
      if (!paramString.exists()) {
        throw new FileNotFoundException();
      }
      localFileInputStream = new FileInputStream(paramString);
      arrayOfByte = a(localFileInputStream);
      paramString = arrayOfByte;
    } while (localFileInputStream == null);
    localFileInputStream.close();
    return arrayOfByte;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return paramString.delete();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
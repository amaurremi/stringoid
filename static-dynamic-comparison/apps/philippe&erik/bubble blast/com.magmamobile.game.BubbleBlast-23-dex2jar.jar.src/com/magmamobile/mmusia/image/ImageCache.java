package com.magmamobile.mmusia.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.magmamobile.mmusia.MMUSIA;
import com.magmamobile.mmusia.parser.data.ApiBase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class ImageCache
{
  private static final Bitmap bytes2Bitmap(byte[] paramArrayOfByte)
  {
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static File getCacheFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(paramContext.getCacheDir().getAbsolutePath() + "/" + paramString);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static final byte[] readCachedBitmap(Context paramContext, String paramString)
  {
    try
    {
      paramContext = getCacheFile(paramContext, paramString);
      if (paramContext.exists())
      {
        paramContext = new FileInputStream(paramContext);
        paramString = readStream(paramContext);
        paramContext.close();
        return paramString;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static final byte[] readStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return localByteArrayOutputStream.toByteArray();
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static final Bitmap requestAppOfTheDayBitmap(Context paramContext)
  {
    Object localObject = MMUSIA.api.appodayIconUrl;
    String str = "appoday_" + MMUSIA.api.appodayId;
    byte[] arrayOfByte = readCachedBitmap(paramContext, str);
    if (arrayOfByte != null) {
      return bytes2Bitmap(arrayOfByte);
    }
    localObject = requestWebBitmap((String)localObject);
    if (localObject != null)
    {
      writeCachedBitmap(paramContext, (byte[])localObject, str);
      return bytes2Bitmap((byte[])localObject);
    }
    return null;
  }
  
  private static final byte[] requestWebBitmap(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      HttpURLConnection.setFollowRedirects(true);
      paramString.setConnectTimeout(3000);
      paramString.setReadTimeout(3000);
      paramString.connect();
      InputStream localInputStream = paramString.getInputStream();
      byte[] arrayOfByte = readStream(localInputStream);
      localInputStream.close();
      paramString.disconnect();
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static final void writeCachedBitmap(Context paramContext, byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramContext = new FileOutputStream(getCacheFile(paramContext, paramString));
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/image/ImageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
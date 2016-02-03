package com.inmobi.re.controller.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageProcessing
{
  public static String convertMediaUriToPath(Uri paramUri, Context paramContext)
  {
    paramUri = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    int i = paramUri.getColumnIndexOrThrow("_data");
    paramUri.moveToFirst();
    paramContext = paramUri.getString(i);
    paramUri.close();
    return paramContext;
  }
  
  public static String getBase64EncodedImage(Bitmap paramBitmap, Context paramContext)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = getDefaultImgQuality(paramContext);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
  }
  
  public static Bitmap getCompressedBitmap(String paramString, Context paramContext)
  {
    try
    {
      int i = getDefaultImgWidth(paramContext);
      int j = getDefaultImgHeight(paramContext) * i;
      paramContext = new FileInputStream(paramString);
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramContext, null, (BitmapFactory.Options)localObject);
      paramContext.close();
      i = 1;
      while (((BitmapFactory.Options)localObject).outWidth * ((BitmapFactory.Options)localObject).outHeight * (1.0D / Math.pow(i, 2.0D)) > j) {
        i += 1;
      }
      paramContext = new FileInputStream(paramString);
      if (i > 1)
      {
        paramString = new BitmapFactory.Options();
        paramString.inSampleSize = (i - 1);
        localObject = BitmapFactory.decodeStream(paramContext, null, paramString);
        i = ((Bitmap)localObject).getHeight();
        int k = ((Bitmap)localObject).getWidth();
        double d = Math.sqrt(j / (k / i));
        paramString = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(d / i * k), (int)d, true);
        ((Bitmap)localObject).recycle();
        System.gc();
      }
      for (;;)
      {
        paramContext.close();
        Log.debug("[InMobi]-[RE]-4.1.1", "bitmap size - width: " + paramString.getWidth() + ", height: " + paramString.getHeight());
        return paramString;
        paramString = BitmapFactory.decodeStream(paramContext);
      }
      return null;
    }
    catch (IOException paramString)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", paramString.getMessage(), paramString);
    }
  }
  
  public static int getDefaultImgHeight(Context paramContext)
  {
    return Initializer.getConfigParams().getPicHeight();
  }
  
  public static int getDefaultImgQuality(Context paramContext)
  {
    return Initializer.getConfigParams().getPicQuality();
  }
  
  public static int getDefaultImgWidth(Context paramContext)
  {
    return Initializer.getConfigParams().getPicWidth();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/controller/util/ImageProcessing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
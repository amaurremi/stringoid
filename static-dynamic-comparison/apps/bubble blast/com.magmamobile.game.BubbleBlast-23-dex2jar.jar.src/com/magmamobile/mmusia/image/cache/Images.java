package com.magmamobile.mmusia.image.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.magmamobile.mmusia.MCommon;
import java.io.File;
import java.io.FileOutputStream;

public class Images
{
  private static final String TAG = "PodKast";
  
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
  
  private static File getDataFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/" + paramString);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static boolean isExist(Context paramContext, String paramString)
  {
    try
    {
      if (!getCacheFile(paramContext, paramString).exists())
      {
        boolean bool = getDataFile(paramContext, paramString).exists();
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static Drawable loadImage(Context paramContext, String paramString)
  {
    paramContext = getCacheFile(paramContext, paramString);
    if ((paramContext == null) || (!paramContext.exists())) {
      return null;
    }
    try
    {
      paramContext = BitmapDrawable.createFromPath(paramContext.getPath());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      MCommon.Log_e("PodKast", "Image Cache not Loaded :: " + paramContext.getMessage());
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void saveImage(Context paramContext, Drawable paramDrawable, String paramString)
  {
    MCommon.Log_d("PodKast", "Save data to cache");
    if (paramDrawable == null) {
      return;
    }
    paramContext = getCacheFile(paramContext, paramString);
    try
    {
      paramContext = new FileOutputStream(paramContext);
      ((BitmapDrawable)paramDrawable).getBitmap().compress(Bitmap.CompressFormat.PNG, 10, paramContext);
      paramContext.close();
      MCommon.Log_d("PodKast", "Image Saved");
      return;
    }
    catch (Exception paramContext)
    {
      MCommon.Log_e("PodKast", "Image Cache not Saved :: " + paramContext.getMessage());
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/image/cache/Images.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
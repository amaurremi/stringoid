package logo.quiz.commons.utils.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageUtils
{
  public static final int IMAGE_CACHE_SIZE = 40;
  public static final int LEVEL_CACHE_SIZE = 6;
  public static final int THUMB_SIZE = 80;
  private static final LruCache<String, SoftReference<Bitmap>> imageCache = new LruCache(40);
  private static final LruCache<Integer, SoftReference<BitmapDrawable>> levelCache = new LruCache(6);
  private static Boolean useLowResThumb;
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt)
  {
    return BitmapFactory.decodeResource(paramResources, paramInt);
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inJustDecodeBounds = false;
    localOptions.inPurgeable = true;
    Object localObject = null;
    paramInt2 = calculateInSampleSize(localOptions, paramInt2, paramInt3);
    paramInt3 = 0;
    for (;;)
    {
      if ((localObject != null) || (paramInt2 > 32) || (paramInt3 >= 8)) {
        return (Bitmap)localObject;
      }
      paramInt3 += 1;
      try
      {
        localOptions.inSampleSize = paramInt2;
        Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
        localObject = localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramInt2 *= 2;
      }
    }
  }
  
  public static Bitmap getBitmapFromURL(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap getImageFromCache(String paramString)
  {
    Object localObject = (SoftReference)imageCache.get(paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = (Bitmap)((SoftReference)localObject).get())
    {
      imageCache.remove(paramString);
      return (Bitmap)localObject;
    }
  }
  
  public static BitmapDrawable getLevelImageFromCache(int paramInt)
  {
    Object localObject = (SoftReference)levelCache.get(Integer.valueOf(paramInt));
    if (localObject == null) {}
    for (localObject = null;; localObject = (BitmapDrawable)((SoftReference)localObject).get())
    {
      levelCache.remove(Integer.valueOf(paramInt));
      return (BitmapDrawable)localObject;
    }
  }
  
  public static void putImageToCache(String paramString, Bitmap paramBitmap)
  {
    imageCache.put(paramString, new SoftReference(paramBitmap));
  }
  
  public static void putLevelImageToCache(int paramInt, BitmapDrawable paramBitmapDrawable)
  {
    levelCache.put(Integer.valueOf(paramInt), new SoftReference(paramBitmapDrawable));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
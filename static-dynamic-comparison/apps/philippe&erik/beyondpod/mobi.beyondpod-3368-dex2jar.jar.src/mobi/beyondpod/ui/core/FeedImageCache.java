package mobi.beyondpod.ui.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.drawable;
import mobi.beyondpod.R.integer;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class FeedImageCache
{
  public static int CacheSize;
  public static int DefaultImageHeight;
  public static int DefaultImageWidth;
  public static int PREFETCH_QUEUE_SIZE;
  private static final String TAG = FeedImageCache.class.getSimpleName();
  private static final BitmapFactory.Options _DefaultBitmapOptionsCache;
  public static int _DownloadedImageSize_height = BeyondPodApplication.GetInstance().getResources().getInteger(R.integer.FeedDownloadImage_px_height);
  public static int _DownloadedImageSize_width;
  private static final File _FeedImageCacheDir;
  
  static
  {
    CacheSize = 40;
    PREFETCH_QUEUE_SIZE = 30;
    _DefaultBitmapOptionsCache = new BitmapFactory.Options();
    DefaultImageWidth = 46;
    DefaultImageHeight = 46;
    _DownloadedImageSize_width = 300;
    _DownloadedImageSize_height = 300;
    _FeedImageCacheDir = new File(Configuration.RssImageCachePath());
    _DefaultBitmapOptionsCache.inPreferredConfig = Bitmap.Config.RGB_565;
    _DefaultBitmapOptionsCache.inDither = false;
    Drawable localDrawable = BeyondPodApplication.GetInstance().getResources().getDrawable(R.drawable.default_feed_image);
    DefaultImageWidth = localDrawable.getIntrinsicWidth();
    DefaultImageHeight = localDrawable.getIntrinsicHeight();
    _DownloadedImageSize_width = BeyondPodApplication.GetInstance().getResources().getInteger(R.integer.FeedDownloadImage_px_width);
  }
  
  public static void DeleteCustomImageForFeed(Feed paramFeed)
  {
    FileUtils.DeleteFileIfExists(GetCustomFeedImageFileName(paramFeed));
  }
  
  public static void DeleteImageCacheFor(Feed paramFeed)
  {
    FileUtils.DeleteFileIfExists(GetFeedImagePath(paramFeed));
  }
  
  public static int DeleteImageCacheForAllFeeds()
  {
    File[] arrayOfFile = new File(Configuration.RssImageCachePath()).listFiles();
    int j = 0;
    int k = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        return j;
      }
      File localFile = arrayOfFile[i];
      try
      {
        localFile.delete();
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CoreHelper.WriteLogEntry(TAG, "Unable to delete image for feed: " + localFile.getPath() + " Reason: " + localException);
          j += 1;
        }
      }
    }
  }
  
  /* Error */
  public static void FormatTempImageForFeed(Feed paramFeed)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokestatic 176	mobi/beyondpod/ui/core/FeedImageCache:GetTempFeedImagePath	(Lmobi/beyondpod/rsscore/Feed;)Ljava/io/File;
    //   9: astore_1
    //   10: aload_1
    //   11: invokevirtual 179	java/io/File:exists	()Z
    //   14: ifeq -10 -> 4
    //   17: aload_1
    //   18: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: getstatic 47	mobi/beyondpod/ui/core/FeedImageCache:_DownloadedImageSize_width	I
    //   24: getstatic 49	mobi/beyondpod/ui/core/FeedImageCache:_DownloadedImageSize_height	I
    //   27: iconst_0
    //   28: invokestatic 186	mobi/beyondpod/ui/core/FeedImageCache:LoadAsSize	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull -29 -> 4
    //   36: new 51	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokestatic 134	mobi/beyondpod/ui/core/FeedImageCache:GetFeedImagePath	(Lmobi/beyondpod/rsscore/Feed;)Ljava/lang/String;
    //   44: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: aload_3
    //   49: invokevirtual 179	java/io/File:exists	()Z
    //   52: ifeq +8 -> 60
    //   55: aload_3
    //   56: invokevirtual 145	java/io/File:delete	()Z
    //   59: pop
    //   60: new 188	java/io/FileOutputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   68: astore_3
    //   69: aload_2
    //   70: getstatic 197	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_3
    //   76: invokevirtual 203	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload_3
    //   81: invokevirtual 206	java/io/FileOutputStream:flush	()V
    //   84: aload_3
    //   85: invokevirtual 209	java/io/FileOutputStream:close	()V
    //   88: aload_2
    //   89: invokevirtual 212	android/graphics/Bitmap:recycle	()V
    //   92: aload_1
    //   93: invokevirtual 145	java/io/File:delete	()Z
    //   96: pop
    //   97: return
    //   98: astore_1
    //   99: getstatic 30	mobi/beyondpod/ui/core/FeedImageCache:TAG	Ljava/lang/String;
    //   102: new 147	java/lang/StringBuilder
    //   105: dup
    //   106: ldc -42
    //   108: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 219	mobi/beyondpod/rsscore/Feed:getName	()Ljava/lang/String;
    //   115: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload_1
    //   122: invokestatic 223	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: return
    //   126: astore_3
    //   127: getstatic 30	mobi/beyondpod/ui/core/FeedImageCache:TAG	Ljava/lang/String;
    //   130: new 147	java/lang/StringBuilder
    //   133: dup
    //   134: ldc -31
    //   136: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokevirtual 219	mobi/beyondpod/rsscore/Feed:getName	()Ljava/lang/String;
    //   143: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: aload_3
    //   150: invokestatic 223	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_2
    //   154: invokevirtual 212	android/graphics/Bitmap:recycle	()V
    //   157: aload_1
    //   158: invokevirtual 145	java/io/File:delete	()Z
    //   161: pop
    //   162: return
    //   163: astore_3
    //   164: aload_2
    //   165: invokevirtual 212	android/graphics/Bitmap:recycle	()V
    //   168: aload_1
    //   169: invokevirtual 145	java/io/File:delete	()Z
    //   172: pop
    //   173: aload_3
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramFeed	Feed
    //   9	84	1	localFile	File
    //   98	71	1	localException1	Exception
    //   31	134	2	localBitmap	Bitmap
    //   47	38	3	localObject1	Object
    //   126	24	3	localException2	Exception
    //   163	11	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	32	98	java/lang/Exception
    //   36	60	98	java/lang/Exception
    //   88	97	98	java/lang/Exception
    //   153	162	98	java/lang/Exception
    //   164	175	98	java/lang/Exception
    //   60	88	126	java/lang/Exception
    //   60	88	163	finally
    //   127	153	163	finally
  }
  
  private static String GetCustomFeedImageFileName(Feed paramFeed)
  {
    return String.format("%s/.feedimage", new Object[] { paramFeed.getFeedPath() }).toString();
  }
  
  public static Drawable GetDefaultImage(Feed paramFeed)
  {
    return BeyondPodApplication.GetInstance().getResources().getDrawable(GetDefaultImageResId(paramFeed));
  }
  
  public static int GetDefaultImageResId(Feed paramFeed)
  {
    if ((paramFeed != null) && (paramFeed.IsGReaderFeed())) {
      return R.drawable.default_greader_feed_image;
    }
    return R.drawable.default_feed_image;
  }
  
  public static String GetExistingFeedImagePath(Feed paramFeed)
  {
    Object localObject;
    if (paramFeed == null) {
      localObject = null;
    }
    String str;
    do
    {
      do
      {
        return (String)localObject;
        str = GetCustomFeedImageFileName(paramFeed);
        localObject = str;
      } while (FileUtils.Exists(str));
      if (!StringUtils.IsNullOrEmpty(paramFeed.getFeedImageUrl())) {
        str = GetFeedImageFileName(paramFeed.getFeedUri(), false);
      }
      localObject = str;
    } while (FileUtils.Exists(str));
    return null;
  }
  
  private static String GetFeedImageFileName(Uri paramUri, boolean paramBoolean)
  {
    File localFile = _FeedImageCacheDir;
    String str;
    int i;
    if (paramUri.getHost() != null)
    {
      str = paramUri.getHost().replace('.', '_');
      i = paramUri.hashCode();
      if (!paramBoolean) {
        break label78;
      }
    }
    label78:
    for (paramUri = "temp";; paramUri = "")
    {
      return String.format("%s/%s_%x%s.img", new Object[] { localFile, str, Integer.valueOf(i), paramUri }).toString();
      str = "unknownimagehost";
      break;
    }
  }
  
  public static Drawable GetFeedImageFor(Feed paramFeed)
  {
    try
    {
      Object localObject = GetSizedFeedImageFor(paramFeed, DefaultImageWidth, DefaultImageHeight);
      if (localObject != null)
      {
        localObject = new BitmapDrawable(BeyondPodApplication.GetInstance().getResources(), (Bitmap)localObject);
        return (Drawable)localObject;
      }
    }
    catch (Exception localException)
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to load image for: " + paramFeed.getName() + "! Reason:" + localException);
    }
    return GetDefaultImage(paramFeed);
  }
  
  public static String GetFeedImagePath(Feed paramFeed)
  {
    if (paramFeed == null) {
      return null;
    }
    if ((StringUtils.IsNullOrEmpty(paramFeed.getFeedImageUrl())) || (paramFeed.getFeedUri() == null) || (FileUtils.Exists(GetCustomFeedImageFileName(paramFeed)))) {
      return GetCustomFeedImageFileName(paramFeed);
    }
    return GetFeedImageFileName(paramFeed.getFeedUri(), false);
  }
  
  public static Bitmap GetSizedFeedImageFor(Feed paramFeed, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = GetFeedImagePath(paramFeed);
      if (localObject == null) {
        return null;
      }
      localObject = LoadAsSize((String)localObject, paramInt1, paramInt2, true);
      return (Bitmap)localObject;
    }
    catch (Exception localException)
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to load Sized image for: " + paramFeed.getName() + "! Reason:" + localException);
    }
    return null;
  }
  
  public static File GetTempFeedImagePath(Feed paramFeed)
  {
    if ((paramFeed == null) || (StringUtils.IsNullOrEmpty(paramFeed.getFeedImageUrl())) || (paramFeed.getFeedUri() == null)) {
      return null;
    }
    return new File(GetFeedImageFileName(paramFeed.getFeedUri(), true));
  }
  
  public static boolean HasCachedImageFor(Feed paramFeed)
  {
    return FileUtils.Exists(GetFeedImagePath(paramFeed));
  }
  
  public static boolean HasCustomImageForFeed(Feed paramFeed)
  {
    return FileUtils.Exists(GetCustomFeedImageFileName(paramFeed));
  }
  
  public static boolean HasImageToDownload(Feed paramFeed)
  {
    return (!StringUtils.IsNullOrEmpty(paramFeed.getFeedImageUrl())) && (!HasCachedImageFor(paramFeed));
  }
  
  public static boolean HasOriginalImage(Feed paramFeed)
  {
    String str = GetCustomFeedImageFileName(paramFeed);
    paramFeed = GetFeedImagePath(paramFeed);
    if (str.equals(paramFeed)) {
      return false;
    }
    return FileUtils.Exists(paramFeed);
  }
  
  private static Bitmap LoadAsSize(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = null;
    Bitmap localBitmap2 = null;
    if (!FileUtils.Exists(paramString)) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inDither = false;
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localBitmap1 = localBitmap2;
      localObject1 = localObject2;
    }
    try
    {
      return BitmapFactory.decodeFile(paramString, localOptions);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k;
        CoreHelper.LogException(TAG, "Unable to load Feed Image", paramString);
        paramString = localBitmap1;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        CoreHelper.WriteLogEntry(TAG, "Unable to load Feed Image. OutOfMemory error!");
        paramString = (String)localObject1;
      }
    }
    Bitmap localBitmap1 = localBitmap2;
    Object localObject1 = localObject2;
    localOptions.inJustDecodeBounds = true;
    localBitmap1 = localBitmap2;
    localObject1 = localObject2;
    BitmapFactory.decodeFile(paramString, localOptions);
    localBitmap1 = localBitmap2;
    localObject1 = localObject2;
    CoreHelper.WriteTraceEntryInDebug(TAG, "Resizing image from: " + localOptions.outWidth + "/" + localOptions.outHeight + " => " + paramInt1 + "/" + paramInt2);
    localBitmap1 = localBitmap2;
    localObject1 = localObject2;
    if (localOptions.outWidth <= paramInt1)
    {
      localBitmap1 = localBitmap2;
      localObject1 = localObject2;
      if ((localOptions.outHeight <= paramInt2) && (!paramBoolean))
      {
        localBitmap1 = localBitmap2;
        localObject1 = localObject2;
        CoreHelper.WriteTraceEntryInDebug(TAG, "Resizing image is smaller then required and we are not allowed to scale up! Using the original image.");
        localBitmap1 = localBitmap2;
        localObject1 = localObject2;
        localOptions.inJustDecodeBounds = false;
        localBitmap1 = localBitmap2;
        localObject1 = localObject2;
        return BitmapFactory.decodeFile(paramString, localOptions);
      }
    }
    k = 1;
    localBitmap1 = localBitmap2;
    localObject1 = localObject2;
    int j = localOptions.outWidth >> 1;
    localBitmap1 = localBitmap2;
    localObject1 = localObject2;
    int i = localOptions.outHeight >> 1;
    for (;;)
    {
      localBitmap1 = localBitmap2;
      localObject1 = localObject2;
      localOptions.inSampleSize = k;
      localBitmap1 = localBitmap2;
      localObject1 = localObject2;
      localOptions.inJustDecodeBounds = false;
      localBitmap1 = localBitmap2;
      localObject1 = localObject2;
      localBitmap2 = BitmapFactory.decodeFile(paramString, localOptions);
      paramString = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        localObject1 = localBitmap2;
        if (localOptions.outWidth == paramInt1)
        {
          paramString = localBitmap2;
          localBitmap1 = localBitmap2;
          localObject1 = localBitmap2;
          if (localOptions.outHeight == paramInt2) {}
        }
        else
        {
          localBitmap1 = localBitmap2;
          localObject1 = localBitmap2;
          float f = localOptions.outWidth / localOptions.outHeight;
          localBitmap1 = localBitmap2;
          localObject1 = localBitmap2;
          paramString = Bitmap.createScaledBitmap(localBitmap2, paramInt1, (int)(paramInt1 / f), true);
          if (paramString != localBitmap2)
          {
            localBitmap1 = localBitmap2;
            localObject1 = localBitmap2;
            localBitmap2.recycle();
          }
        }
      }
      return paramString;
      do
      {
        k <<= 1;
        j >>= 1;
        i >>= 1;
        if (j <= paramInt1) {
          break;
        }
      } while (i > paramInt2);
    }
  }
  
  public static void SetCustomFeedImage(Feed paramFeed, String paramString)
  {
    try
    {
      DeleteCustomImageForFeed(paramFeed);
      FileUtils.CopyFile(paramString, GetCustomFeedImageFileName(paramFeed));
      return;
    }
    catch (Exception paramFeed)
    {
      CoreHelper.LogException(TAG, "Unable to copy feed image", paramFeed);
    }
  }
  
  public static abstract interface FeedCachePublisher
  {
    public abstract void FeedImageLoaded(Feed paramFeed, Drawable paramDrawable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/FeedImageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
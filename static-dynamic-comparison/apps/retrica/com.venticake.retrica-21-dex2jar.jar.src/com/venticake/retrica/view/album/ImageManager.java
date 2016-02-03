package com.venticake.retrica.view.album;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class ImageManager
{
  public static final String CAMERA_IMAGE_BUCKET_ID = getBucketId(CAMERA_IMAGE_BUCKET_NAME);
  public static final String CAMERA_IMAGE_BUCKET_NAME;
  public static final Bitmap DEFAULT_THUMBNAIL;
  public static final int INCLUDE_DRM_IMAGES = 2;
  public static final int INCLUDE_IMAGES = 1;
  public static final int INCLUDE_VIDEOS = 4;
  private static final long LOW_STORAGE_THRESHOLD = 2097152L;
  public static final Bitmap NO_IMAGE_BITMAP;
  public static final int SORT_ASCENDING = 1;
  public static final int SORT_DESCENDING = 2;
  private static final Uri STORAGE_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
  private static final String TAG = "ImageManager";
  
  static
  {
    DEFAULT_THUMBNAIL = Bitmap.createBitmap(32, 32, Bitmap.Config.RGB_565);
    NO_IMAGE_BITMAP = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
    CAMERA_IMAGE_BUCKET_NAME = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera";
  }
  
  public static Uri addImage(ContentResolver paramContentResolver, String paramString1, long paramLong, double paramDouble1, double paramDouble2, int paramInt, String paramString2, String paramString3)
  {
    ContentValues localContentValues = new ContentValues(7);
    localContentValues.put("title", paramString1);
    localContentValues.put("_display_name", paramString3);
    localContentValues.put("datetaken", Long.valueOf(paramLong));
    localContentValues.put("mime_type", "image/jpeg");
    localContentValues.put("orientation", Integer.valueOf(paramInt));
    localContentValues.put("latitude", Double.valueOf(paramDouble1));
    localContentValues.put("longitude", Double.valueOf(paramDouble2));
    if ((paramString2 != null) && (paramString3 != null)) {
      localContentValues.put("_data", paramString2 + "/" + paramString3);
    }
    return paramContentResolver.insert(STORAGE_URI, localContentValues);
  }
  
  private static boolean checkFsWritable()
  {
    Object localObject = Environment.getExternalStorageDirectory().toString() + "/Pictures/Retrica";
    File localFile = new File((String)localObject);
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {}
    for (;;)
    {
      return false;
      localObject = new File((String)localObject, ".probe");
      try
      {
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (((File)localObject).createNewFile())
        {
          ((File)localObject).delete();
          return true;
        }
      }
      catch (IOException localIOException) {}
    }
    return false;
  }
  
  public static void ensureOSXCompatibleFolder()
  {
    File localFile = new File(Environment.getExternalStorageDirectory().toString() + "/DCIM/100ANDRO");
    if ((!localFile.exists()) && (!localFile.mkdir())) {
      Log.e("ImageManager", "create NNNAAAAA file: " + localFile.getPath() + " failed");
    }
  }
  
  public static String getBucketId(String paramString)
  {
    return String.valueOf(paramString.toLowerCase().hashCode());
  }
  
  public static String getLastImageThumbPath()
  {
    return Environment.getExternalStorageDirectory().toString() + "/DCIM/.thumbnails/image_last_thumb";
  }
  
  public static String getLastVideoThumbPath()
  {
    return Environment.getExternalStorageDirectory().toString() + "/DCIM/.thumbnails/video_last_thumb";
  }
  
  public static boolean hasLowStorage()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().toString());
    long l = localStatFs.getAvailableBlocks();
    return localStatFs.getBlockSize() * l < 2097152L;
  }
  
  public static boolean hasStorage()
  {
    return hasStorage(true);
  }
  
  public static boolean hasStorage(boolean paramBoolean)
  {
    boolean bool = true;
    String str = Environment.getExternalStorageState();
    if ("mounted".equals(str)) {
      if (paramBoolean) {
        bool = checkFsWritable();
      }
    }
    while ((!paramBoolean) && ("mounted_ro".equals(str))) {
      return bool;
    }
    return false;
  }
  
  public static boolean isImageMimeType(String paramString)
  {
    return paramString.startsWith("image/");
  }
  
  public static final boolean isMediaScannerScanning(ContentResolver paramContentResolver)
  {
    paramContentResolver = query(paramContentResolver, MediaStore.getMediaScannerUri(), new String[] { "volume" }, null, null, null);
    if (paramContentResolver != null)
    {
      if (paramContentResolver.getCount() == 1) {
        paramContentResolver.moveToFirst();
      }
      for (boolean bool = "external".equals(paramContentResolver.getString(0));; bool = false)
      {
        paramContentResolver.close();
        return bool;
      }
    }
    return false;
  }
  
  static boolean isSingleImageMode(String paramString)
  {
    return (!paramString.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())) && (!paramString.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()));
  }
  
  public static boolean isVideoMimeType(String paramString)
  {
    return paramString.startsWith("video/");
  }
  
  private static final Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (paramContentResolver == null) {
      return null;
    }
    try
    {
      paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      return paramContentResolver;
    }
    catch (UnsupportedOperationException paramContentResolver) {}
    return null;
  }
  
  public static boolean quickHasStorage()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static int roundOrientation(int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 0;
    }
    paramInt = i % 360;
    if (paramInt < 45) {}
    do
    {
      return 0;
      if (paramInt < 135) {
        return 90;
      }
      if (paramInt < 225) {
        return 180;
      }
    } while (paramInt >= 315);
    return 270;
  }
  
  public static void setImageSize(ContentResolver paramContentResolver, Uri paramUri, long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_size", Long.valueOf(paramLong));
    paramContentResolver.update(paramUri, localContentValues, null, null);
  }
  
  public static Cancelable<Void> storeImage(Uri paramUri, ContentResolver paramContentResolver, int paramInt, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    return new ImageManager.AddImageCancelable(paramUri, paramContentResolver, paramInt, paramBitmap, paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package mobi.beyondpod.ui.core;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Media;
import android.provider.MediaStore.Video.Thumbnails;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.raw;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.Path;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class MusicUtils
{
  public static final int GET_ARTWORK_KIND_CHECK_ONLY = 2;
  public static final int GET_ARTWORK_KIND_EXACT = 0;
  public static final int GET_ARTWORK_KIND_INSIDE_BOUNDS = 1;
  public static int STORE_TYPE_OPTIONAL_MOUNT = 0;
  public static int STORE_TYPE_SD_CARD = 0;
  private static final String TAG = "MusicUtils";
  private static final Uri _ArtworkExternalUri;
  private static final BitmapFactory.Options _BitmapOptions;
  private static final BitmapFactory.Options _BitmapOptionsCache = new BitmapFactory.Options();
  
  static
  {
    _BitmapOptions = new BitmapFactory.Options();
    _ArtworkExternalUri = Uri.parse("content://media/external/audio/albumart");
    STORE_TYPE_SD_CARD = 1;
    STORE_TYPE_OPTIONAL_MOUNT = 2;
    _BitmapOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    _BitmapOptions.inDither = false;
    _BitmapOptionsCache.inPreferredConfig = Bitmap.Config.RGB_565;
    _BitmapOptionsCache.inDither = false;
  }
  
  public static boolean AudioTrackImageMatchesDatabase(Track paramTrack, Cursor paramCursor)
  {
    if (paramTrack.IsUsingParentImage()) {}
    do
    {
      return true;
      if (StringUtils.IsNullOrEmpty(paramTrack.TrackImagePath())) {
        return false;
      }
    } while ((paramTrack.TrackImagePath().contains(paramCursor.getString(paramCursor.getColumnIndexOrThrow("album_id")))) || (paramTrack.TrackImagePath().contains(paramCursor.getString(paramCursor.getColumnIndexOrThrow("_id")))));
    return false;
  }
  
  public static boolean DeleteRecord(Context paramContext, Uri paramUri, String paramString)
  {
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      if (localContentResolver == null) {
        return false;
      }
      paramContext = null;
      if (paramUri == MediaStore.Audio.Media.EXTERNAL_CONTENT_URI) {
        paramContext = "_data";
      }
      int j;
      int i;
      for (;;)
      {
        if (paramContext == null) {
          break label260;
        }
        j = localContentResolver.delete(paramUri, paramContext + "=?", new String[] { paramString });
        i = j;
        String str = paramString;
        if (j == 0)
        {
          CoreHelper.WriteTraceEntry("MusicUtils", "Unable to delete record using provided path: " + paramString + "! Trying canonical path...");
          str = paramString;
        }
        try
        {
          paramString = new File(paramString).getCanonicalFile().getAbsolutePath();
          str = paramString;
          i = localContentResolver.delete(paramUri, paramContext + "=?", new String[] { paramString });
          str = paramString;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            CoreHelper.WriteTraceEntry("MusicUtils", "Unable to delete using canonical path! Reason: " + paramContext.getMessage());
            i = j;
          }
        }
        CoreHelper.WriteTraceEntry("MusicUtils", "Deleted " + i + " records for " + str + " from the Media Database");
        if (i != 1) {
          break label260;
        }
        return true;
        if (paramUri == MediaStore.Video.Media.EXTERNAL_CONTENT_URI) {
          paramContext = "_data";
        } else if (paramUri == MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
          paramContext = "_data";
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
  }
  
  public static void DumpAudioDB(Context paramContext)
  {
    paramContext = GetAllRecordsAudioCursor(paramContext);
    if ((paramContext != null) && (paramContext.moveToFirst()))
    {
      do
      {
        long l1 = paramContext.getLong(paramContext.getColumnIndexOrThrow("_id"));
        String str1 = paramContext.getString(paramContext.getColumnIndexOrThrow("title"));
        long l2 = paramContext.getLong(paramContext.getColumnIndexOrThrow("duration")) / 1000L;
        String str2 = paramContext.getString(paramContext.getColumnIndexOrThrow("mime_type"));
        String str3 = paramContext.getString(paramContext.getColumnIndexOrThrow("_data"));
        CoreHelper.WriteTraceEntry("MusicUtils", "##### AUDIO RECORD => id:" + l1 + ", name:" + str1 + ", dur:" + l2 + ", mime:" + str2 + ", path:" + str3);
      } while (paramContext.moveToNext());
      paramContext.close();
    }
  }
  
  public static int DumpAudioDBRecordCount(Context paramContext)
  {
    paramContext = GetAllRecordsAudioCursor(paramContext);
    int j = -1;
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.moveToFirst())
      {
        i = paramContext.getCount();
        paramContext.close();
      }
    }
    return i;
  }
  
  public static void DumpVideoDB(Context paramContext)
  {
    paramContext = query(paramContext, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_data", "title", "duration", "_id", "mime_type" }, null, null, null);
    if ((paramContext != null) && (paramContext.moveToFirst())) {
      do
      {
        String str1 = paramContext.getString(paramContext.getColumnIndexOrThrow("title"));
        long l = paramContext.getLong(paramContext.getColumnIndexOrThrow("duration")) / 1000L;
        String str2 = paramContext.getString(paramContext.getColumnIndexOrThrow("mime_type"));
        String str3 = paramContext.getString(paramContext.getColumnIndexOrThrow("_data"));
        CoreHelper.WriteTraceEntry("MusicUtils", "##### VIDEO RECORD => name:" + str1 + ", dur:" + l + ", mime:" + str2 + ", path:" + str3);
      } while (paramContext.moveToNext());
    }
  }
  
  public static void ForceMediaScanFor(String paramString)
  {
    if (CoreHelper.ApiLevel() >= 19)
    {
      CoreHelper.WriteTraceEntry("MusicUtils", "Forcing Rescan in not supported on KitKat or later! Ignoring...");
      return;
    }
    if ((paramString == null) || (paramString.startsWith(Environment.getExternalStorageDirectory().getPath()))) {}
    for (paramString = Environment.getExternalStorageDirectory();; paramString = CoreHelper.GetOptionalStorageMount())
    {
      CoreHelper.WriteTraceEntry("MusicUtils", "Forcing Rescan of: " + paramString);
      BeyondPodApplication.GetInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + paramString)));
      return;
    }
  }
  
  public static Cursor GetAllRecordsAudioCursor(Context paramContext)
  {
    return query(paramContext, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] { "_data", "title", "duration", "_id", "mime_type" }, null, null, "_id");
  }
  
  public static Bitmap GetVideoThumbnail(final Context paramContext, final long paramLong, boolean paramBoolean, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramLong < 0L)
    {
      localObject = null;
      return (Bitmap)localObject;
    }
    for (;;)
    {
      try
      {
        Thread.sleep(1L);
        new Thread()
        {
          public void run()
          {
            try
            {
              Thread.sleep(5000L);
              try
              {
                if (this.val$isVideo)
                {
                  MediaStore.Video.Thumbnails.cancelThumbnailRequest(paramContext.getContentResolver(), paramLong);
                  return;
                }
                MediaStore.Images.Thumbnails.cancelThumbnailRequest(paramContext.getContentResolver(), paramLong);
                return;
              }
              catch (Exception localException) {}
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;) {}
            }
          }
        }.start();
        if (paramBoolean)
        {
          paramContext = MediaStore.Video.Thumbnails.getThumbnail(paramContext.getContentResolver(), paramLong, 1, null);
          if (paramContext == null) {
            CoreHelper.WriteTraceEntry("MusicUtils", "Unable to find video thumbnail for: " + paramLong);
          }
        }
        else
        {
          paramContext = MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), paramLong, 1, null);
          continue;
          paramContext = sizeAndFrame(paramContext, paramBitmap, paramInt1, paramInt2);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
      catch (OutOfMemoryError paramContext)
      {
        CoreHelper.WriteTraceEntry("MusicUtils", "Unable to load video thumbnail! OutOfMemoryError");
        return null;
      }
      if (paramContext == null) {
        return null;
      }
      if (paramBitmap == null)
      {
        localObject = paramContext;
        if (paramInt2 <= 0) {
          break;
        }
        localObject = paramContext;
        if (paramInt1 <= 0) {
          break;
        }
      }
    }
  }
  
  static boolean IsTitleSameAsFileName(Track paramTrack, String paramString)
  {
    paramTrack = Path.GetFileNameWithoutExtension(paramTrack.TrackPath());
    return (!StringUtils.IsNullOrEmpty(paramString)) && (paramString.equals(paramTrack));
  }
  
  private static boolean LoadAudioID3InfoFor(Track paramTrack, boolean paramBoolean1, Uri paramUri, Cursor paramCursor, boolean paramBoolean2)
  {
    localObject2 = paramCursor;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject3 = localObject2;
    }
    try
    {
      localObject1 = getAudioCursor(BeyondPodApplication.GetInstance(), paramTrack.TrackPath(), paramUri);
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        localObject2 = localObject1;
        paramUri = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("title"));
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (!StringUtils.IsNullOrEmpty(paramUri))
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (!IsTitleSameAsFileName(paramTrack, paramUri))
          {
            localObject3 = localObject1;
            localObject2 = localObject1;
            paramTrack.setName(paramUri);
          }
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("duration")) / 1000L;
        if (l != 0L)
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          paramTrack.setTotalTime(l);
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        paramUri = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (!StringUtils.IsNullOrEmpty(paramUri))
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          paramTrack.setContentMimeType(paramUri);
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (paramTrack.HasImage())
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (!paramTrack.IsUsingParentImage()) {}
        }
        else
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          paramUri = LoadAudioThumbnail(BeyondPodApplication.GetInstance(), paramTrack, 0, 0, 2, (Cursor)localObject1);
          if (paramUri != null)
          {
            localObject3 = localObject1;
            localObject2 = localObject1;
            paramUri.recycle();
          }
        }
        if (paramBoolean1)
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          DeleteRecord(BeyondPodApplication.GetInstance(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, paramTrack.TrackPath());
        }
        return true;
      }
      localObject3 = localObject1;
      localObject2 = localObject1;
      CoreHelper.WriteTraceEntry("MusicUtils", "No audio media scanner record exists for: " + paramTrack.TrackPath());
      if (paramBoolean2)
      {
        localObject3 = localObject1;
        localObject2 = localObject1;
        paramTrack.setUseParentImage();
      }
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        localObject2 = localObject3;
        CoreHelper.WriteLogEntry("MusicUtils", "Failed to load audio ID3 tags for track " + paramTrack.getName() + "! Reason: " + paramUri.getMessage());
        if ((paramCursor == null) && (localObject3 != null)) {
          ((Cursor)localObject3).close();
        }
      }
    }
    finally
    {
      if ((paramCursor != null) || (localObject2 == null)) {
        break label465;
      }
      ((Cursor)localObject2).close();
    }
    return false;
  }
  
  private static Bitmap LoadAudioThumbnail(Context paramContext, Track paramTrack, int paramInt1, int paramInt2, int paramInt3, Cursor paramCursor)
  {
    Uri localUri = ContentUris.withAppendedId(_ArtworkExternalUri, paramCursor.getInt(paramCursor.getColumnIndexOrThrow("album_id")));
    Object localObject = getArtworkQuick(paramContext, localUri, paramInt1, paramInt2, paramInt3);
    if (localObject != null)
    {
      paramContext = "album art";
      paramTrack.setTrackImagePath(localUri.toString());
      paramCursor = (Cursor)localObject;
    }
    for (;;)
    {
      CoreHelper.WriteTraceEntry("MusicUtils", "** Track " + paramTrack.getName() + " will be using [" + paramContext + "] image");
      return paramCursor;
      int i = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("_id"));
      localObject = Uri.parse("content://media/external/audio/media/" + i + "/albumart");
      paramCursor = getArtworkQuick(paramContext, (Uri)localObject, paramInt1, paramInt2, paramInt3);
      if (paramCursor != null)
      {
        paramTrack.setTrackImagePath(((Uri)localObject).toString());
        paramContext = "track";
      }
      else
      {
        paramTrack.setUseParentImage();
        paramContext = "parent feed";
      }
    }
  }
  
  public static void LoadID3InfoForTrack(Track paramTrack, boolean paramBoolean1, Uri paramUri, Cursor paramCursor, boolean paramBoolean2)
  {
    boolean bool;
    if (paramTrack != null)
    {
      bool = false;
      if (paramUri == null) {
        break label188;
      }
      if (!paramUri.getPath().contains("audio")) {
        break label134;
      }
      bool = LoadAudioID3InfoFor(paramTrack, paramBoolean1, paramUri, null, paramBoolean2);
    }
    label134:
    label188:
    while (paramCursor == null) {
      for (;;)
      {
        if ((!bool) && (!LoadAudioID3InfoFor(paramTrack, paramBoolean1, null, null, paramBoolean2)) && (!LoadVideoID3InfoFor(paramTrack, paramBoolean1, null, null, paramBoolean2))) {
          LoadImageInfoFor(paramTrack, false, null, null, paramBoolean2);
        }
        if ((StringUtils.IsNullOrEmpty(paramTrack.ContentMimeType())) && (paramTrack.Exists())) {
          paramTrack.setContentMimeType(MediaFile.getMimeType(paramTrack.TrackPath()));
        }
        if ((paramUri != null) && (paramTrack.HasUrl()) && (Configuration.ForceMediaDatabaseRescanOnDownloadOrDelete()) && (FeedRepository.RepositoryLoadState() == 2)) {
          ForceMediaScanFor(paramTrack.TrackPath());
        }
        return;
        if (paramUri.getPath().contains("video")) {
          bool = LoadVideoID3InfoFor(paramTrack, paramBoolean1, paramUri, null, paramBoolean2);
        } else if (paramUri.getPath().contains("image")) {
          bool = LoadImageInfoFor(paramTrack, false, paramUri, null, paramBoolean2);
        }
      }
    }
    if (paramCursor.getColumnIndex("album_id") != -1) {
      LoadAudioID3InfoFor(paramTrack, paramBoolean1, null, paramCursor, paramBoolean2);
    }
    for (;;)
    {
      bool = true;
      break;
      LoadVideoID3InfoFor(paramTrack, paramBoolean1, null, paramCursor, paramBoolean2);
    }
  }
  
  private static boolean LoadImageInfoFor(Track paramTrack, boolean paramBoolean1, Uri paramUri, Cursor paramCursor, boolean paramBoolean2)
  {
    localObject2 = paramCursor;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject3 = localObject2;
    }
    try
    {
      localObject1 = getImageCursor(BeyondPodApplication.GetInstance(), paramTrack.TrackPath(), paramUri);
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        localObject2 = localObject1;
        paramUri = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("title"));
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (!StringUtils.IsNullOrEmpty(paramUri))
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (!IsTitleSameAsFileName(paramTrack, paramUri))
          {
            localObject3 = localObject1;
            localObject2 = localObject1;
            paramTrack.setName(paramUri);
          }
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        paramUri = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (!StringUtils.IsNullOrEmpty(paramUri))
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          paramTrack.setContentMimeType(paramUri);
        }
        if (paramBoolean1)
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          DeleteRecord(BeyondPodApplication.GetInstance(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramTrack.TrackPath());
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        paramTrack.setUseParentImage();
        return true;
      }
      localObject3 = localObject1;
      localObject2 = localObject1;
      CoreHelper.WriteTraceEntry("MusicUtils", "No image media scanner record exists for: " + paramTrack.TrackPath());
      if (paramBoolean2)
      {
        localObject3 = localObject1;
        localObject2 = localObject1;
        paramTrack.setUseParentImage();
      }
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        localObject2 = localObject3;
        CoreHelper.WriteLogEntry("MusicUtils", "Failed to load image ID3 tags for track " + paramTrack.getName() + "! Reason: " + paramUri.getMessage());
        if ((paramCursor == null) && (localObject3 != null)) {
          ((Cursor)localObject3).close();
        }
      }
    }
    finally
    {
      if ((paramCursor != null) || (localObject2 == null)) {
        break label359;
      }
      ((Cursor)localObject2).close();
    }
    return false;
  }
  
  /* Error */
  private static boolean LoadVideoID3InfoFor(Track paramTrack, boolean paramBoolean1, Uri paramUri, Cursor paramCursor, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 9
    //   3: aload 9
    //   5: astore 8
    //   7: aload 9
    //   9: ifnonnull +20 -> 29
    //   12: aload 9
    //   14: astore 10
    //   16: invokestatic 269	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   19: aload_0
    //   20: invokevirtual 323	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   23: aload_2
    //   24: invokestatic 469	mobi/beyondpod/ui/core/MusicUtils:getVideoCursor	(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;)Landroid/database/Cursor;
    //   27: astore 8
    //   29: aload 8
    //   31: ifnull +649 -> 680
    //   34: aload 8
    //   36: astore 10
    //   38: aload 8
    //   40: astore 9
    //   42: aload 8
    //   44: aload 8
    //   46: ldc -53
    //   48: invokeinterface 95 2 0
    //   53: invokeinterface 99 2 0
    //   58: astore_2
    //   59: aload 8
    //   61: astore 10
    //   63: aload 8
    //   65: astore 9
    //   67: aload_2
    //   68: invokestatic 87	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   71: ifne +32 -> 103
    //   74: aload 8
    //   76: astore 10
    //   78: aload 8
    //   80: astore 9
    //   82: aload_0
    //   83: aload_2
    //   84: invokestatic 341	mobi/beyondpod/ui/core/MusicUtils:IsTitleSameAsFileName	(Lmobi/beyondpod/rsscore/Track;Ljava/lang/String;)Z
    //   87: ifne +16 -> 103
    //   90: aload 8
    //   92: astore 10
    //   94: aload 8
    //   96: astore 9
    //   98: aload_0
    //   99: aload_2
    //   100: invokevirtual 344	mobi/beyondpod/rsscore/Track:setName	(Ljava/lang/String;)V
    //   103: aload 8
    //   105: astore 10
    //   107: aload 8
    //   109: astore 9
    //   111: aload 8
    //   113: aload 8
    //   115: ldc -51
    //   117: invokeinterface 95 2 0
    //   122: invokeinterface 201 2 0
    //   127: ldc2_w 206
    //   130: ldiv
    //   131: lstore 6
    //   133: lload 6
    //   135: lconst_0
    //   136: lcmp
    //   137: ifeq +17 -> 154
    //   140: aload 8
    //   142: astore 10
    //   144: aload 8
    //   146: astore 9
    //   148: aload_0
    //   149: lload 6
    //   151: invokevirtual 347	mobi/beyondpod/rsscore/Track:setTotalTime	(J)V
    //   154: aload 8
    //   156: astore 10
    //   158: aload 8
    //   160: astore 9
    //   162: aload 8
    //   164: aload 8
    //   166: ldc -47
    //   168: invokeinterface 95 2 0
    //   173: invokeinterface 99 2 0
    //   178: astore 11
    //   180: aload 8
    //   182: astore 10
    //   184: aload 8
    //   186: astore 9
    //   188: aload 11
    //   190: invokestatic 87	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   193: ifne +17 -> 210
    //   196: aload 8
    //   198: astore 10
    //   200: aload 8
    //   202: astore 9
    //   204: aload_0
    //   205: aload 11
    //   207: invokevirtual 350	mobi/beyondpod/rsscore/Track:setContentMimeType	(Ljava/lang/String;)V
    //   210: aload 8
    //   212: astore 10
    //   214: aload 8
    //   216: astore 9
    //   218: aload 8
    //   220: aload 8
    //   222: ldc 107
    //   224: invokeinterface 95 2 0
    //   229: invokeinterface 383 2 0
    //   234: istore 5
    //   236: aload 8
    //   238: astore 10
    //   240: aload 8
    //   242: astore 9
    //   244: ldc 24
    //   246: new 126	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 471
    //   253: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: iload 5
    //   258: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc_w 473
    //   264: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 475
    //   274: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: lload 6
    //   279: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: ldc -36
    //   284: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 11
    //   289: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload 8
    //   300: astore 10
    //   302: aload 8
    //   304: astore 9
    //   306: aload_0
    //   307: invokevirtual 353	mobi/beyondpod/rsscore/Track:HasImage	()Z
    //   310: ifeq +18 -> 328
    //   313: aload 8
    //   315: astore 10
    //   317: aload 8
    //   319: astore 9
    //   321: aload_0
    //   322: invokevirtual 77	mobi/beyondpod/rsscore/Track:IsUsingParentImage	()Z
    //   325: ifeq +40 -> 365
    //   328: aload 8
    //   330: astore 10
    //   332: aload 8
    //   334: astore 9
    //   336: invokestatic 269	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   339: aload_0
    //   340: aconst_null
    //   341: iconst_m1
    //   342: iconst_m1
    //   343: aload 8
    //   345: invokestatic 479	mobi/beyondpod/ui/core/MusicUtils:LoadVideoThumbnail	(Landroid/content/Context;Lmobi/beyondpod/rsscore/Track;Landroid/graphics/Bitmap;IILandroid/database/Cursor;)Landroid/graphics/Bitmap;
    //   348: astore_2
    //   349: aload_2
    //   350: ifnull +15 -> 365
    //   353: aload 8
    //   355: astore 10
    //   357: aload 8
    //   359: astore 9
    //   361: aload_2
    //   362: invokevirtual 362	android/graphics/Bitmap:recycle	()V
    //   365: iload_1
    //   366: ifeq +193 -> 559
    //   369: aload 8
    //   371: astore 10
    //   373: aload 8
    //   375: astore 9
    //   377: invokestatic 482	mobi/beyondpod/rsscore/Configuration:PatchVideoFilesForMediaScanner	()Z
    //   380: ifeq +179 -> 559
    //   383: aload 8
    //   385: astore 10
    //   387: aload 8
    //   389: astore 9
    //   391: ldc 24
    //   393: ldc_w 484
    //   396: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload 8
    //   401: astore 10
    //   403: aload 8
    //   405: astore 9
    //   407: new 160	java/io/File
    //   410: dup
    //   411: aload_0
    //   412: invokevirtual 323	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   415: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   418: astore_2
    //   419: aload 8
    //   421: astore 10
    //   423: aload 8
    //   425: astore 9
    //   427: new 160	java/io/File
    //   430: dup
    //   431: aload_2
    //   432: invokevirtual 487	java/io/File:getParent	()Ljava/lang/String;
    //   435: new 126	java/lang/StringBuilder
    //   438: dup
    //   439: ldc_w 489
    //   442: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   445: aload_2
    //   446: invokevirtual 490	java/io/File:getName	()Ljava/lang/String;
    //   449: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokespecial 492	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: astore 11
    //   460: aload 8
    //   462: astore 10
    //   464: aload 8
    //   466: astore 9
    //   468: aload_2
    //   469: aload 11
    //   471: invokevirtual 496	java/io/File:renameTo	(Ljava/io/File;)Z
    //   474: ifeq +103 -> 577
    //   477: aload 8
    //   479: astore 10
    //   481: aload 8
    //   483: astore 9
    //   485: invokestatic 269	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   488: getstatic 180	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   491: aload_2
    //   492: invokevirtual 168	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   495: invokestatic 364	mobi/beyondpod/ui/core/MusicUtils:DeleteRecord	(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Z
    //   498: pop
    //   499: aload 8
    //   501: astore 10
    //   503: aload 8
    //   505: astore 9
    //   507: aload 11
    //   509: aload_2
    //   510: invokevirtual 499	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   513: invokevirtual 496	java/io/File:renameTo	(Ljava/io/File;)Z
    //   516: ifne +43 -> 559
    //   519: aload 8
    //   521: astore 10
    //   523: aload 8
    //   525: astore 9
    //   527: ldc 24
    //   529: new 126	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 501
    //   536: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: aload 11
    //   541: invokevirtual 168	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   544: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc_w 503
    //   550: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 379	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload_3
    //   560: ifnonnull +15 -> 575
    //   563: aload 8
    //   565: ifnull +10 -> 575
    //   568: aload 8
    //   570: invokeinterface 228 1 0
    //   575: iconst_1
    //   576: ireturn
    //   577: aload 8
    //   579: astore 10
    //   581: aload 8
    //   583: astore 9
    //   585: ldc 24
    //   587: new 126	java/lang/StringBuilder
    //   590: dup
    //   591: ldc_w 505
    //   594: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   597: aload_0
    //   598: invokevirtual 323	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   601: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc_w 507
    //   607: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 379	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: goto -57 -> 559
    //   619: astore_2
    //   620: aload 10
    //   622: astore 9
    //   624: ldc 24
    //   626: new 126	java/lang/StringBuilder
    //   629: dup
    //   630: ldc_w 509
    //   633: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   636: aload_0
    //   637: invokevirtual 374	mobi/beyondpod/rsscore/Track:getName	()Ljava/lang/String;
    //   640: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: ldc_w 376
    //   646: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_2
    //   650: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   653: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 379	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload_3
    //   663: ifnonnull +15 -> 678
    //   666: aload 10
    //   668: ifnull +10 -> 678
    //   671: aload 10
    //   673: invokeinterface 228 1 0
    //   678: iconst_0
    //   679: ireturn
    //   680: aload 8
    //   682: astore 10
    //   684: aload 8
    //   686: astore 9
    //   688: ldc 24
    //   690: new 126	java/lang/StringBuilder
    //   693: dup
    //   694: ldc_w 511
    //   697: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   700: aload_0
    //   701: invokevirtual 323	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   704: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: iload 4
    //   715: ifeq +15 -> 730
    //   718: aload 8
    //   720: astore 10
    //   722: aload 8
    //   724: astore 9
    //   726: aload_0
    //   727: invokevirtual 369	mobi/beyondpod/rsscore/Track:setUseParentImage	()V
    //   730: aload_3
    //   731: ifnonnull -53 -> 678
    //   734: aload 8
    //   736: ifnull -58 -> 678
    //   739: aload 8
    //   741: invokeinterface 228 1 0
    //   746: goto -68 -> 678
    //   749: astore_0
    //   750: aload_3
    //   751: ifnonnull +15 -> 766
    //   754: aload 9
    //   756: ifnull +10 -> 766
    //   759: aload 9
    //   761: invokeinterface 228 1 0
    //   766: aload_0
    //   767: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	768	0	paramTrack	Track
    //   0	768	1	paramBoolean1	boolean
    //   0	768	2	paramUri	Uri
    //   0	768	3	paramCursor	Cursor
    //   0	768	4	paramBoolean2	boolean
    //   234	23	5	i	int
    //   131	147	6	l	long
    //   5	735	8	localObject1	Object
    //   1	759	9	localObject2	Object
    //   14	707	10	localObject3	Object
    //   178	362	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	619	java/lang/Exception
    //   42	59	619	java/lang/Exception
    //   67	74	619	java/lang/Exception
    //   82	90	619	java/lang/Exception
    //   98	103	619	java/lang/Exception
    //   111	133	619	java/lang/Exception
    //   148	154	619	java/lang/Exception
    //   162	180	619	java/lang/Exception
    //   188	196	619	java/lang/Exception
    //   204	210	619	java/lang/Exception
    //   218	236	619	java/lang/Exception
    //   244	298	619	java/lang/Exception
    //   306	313	619	java/lang/Exception
    //   321	328	619	java/lang/Exception
    //   336	349	619	java/lang/Exception
    //   361	365	619	java/lang/Exception
    //   377	383	619	java/lang/Exception
    //   391	399	619	java/lang/Exception
    //   407	419	619	java/lang/Exception
    //   427	460	619	java/lang/Exception
    //   468	477	619	java/lang/Exception
    //   485	499	619	java/lang/Exception
    //   507	519	619	java/lang/Exception
    //   527	559	619	java/lang/Exception
    //   585	616	619	java/lang/Exception
    //   688	713	619	java/lang/Exception
    //   726	730	619	java/lang/Exception
    //   16	29	749	finally
    //   42	59	749	finally
    //   67	74	749	finally
    //   82	90	749	finally
    //   98	103	749	finally
    //   111	133	749	finally
    //   148	154	749	finally
    //   162	180	749	finally
    //   188	196	749	finally
    //   204	210	749	finally
    //   218	236	749	finally
    //   244	298	749	finally
    //   306	313	749	finally
    //   321	328	749	finally
    //   336	349	749	finally
    //   361	365	749	finally
    //   377	383	749	finally
    //   391	399	749	finally
    //   407	419	749	finally
    //   427	460	749	finally
    //   468	477	749	finally
    //   485	499	749	finally
    //   507	519	749	finally
    //   527	559	749	finally
    //   585	616	749	finally
    //   624	662	749	finally
    //   688	713	749	finally
    //   726	730	749	finally
  }
  
  private static Bitmap LoadVideoThumbnail(Context paramContext, Track paramTrack, Bitmap paramBitmap, int paramInt1, int paramInt2, Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("_id"));
    paramContext = GetVideoThumbnail(paramContext, i, true, paramBitmap, paramInt1, paramInt2);
    if (paramContext != null)
    {
      paramTrack.setTrackImagePath(Integer.toString(i));
      return paramContext;
    }
    paramTrack.setUseParentImage();
    return paramContext;
  }
  
  public static void RebuildMediaDatabase(final RebuildMediaDatabaseListener paramRebuildMediaDatabaseListener)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new File(Configuration.EnclosureDownloadRoot(), ".nomedia");
    if (!((File)localObject2).exists()) {
      ((ArrayList)localObject1).add(localObject2);
    }
    Object localObject3 = FeedRepository.getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext())
      {
        if (((ArrayList)localObject1).size() != 0) {
          break;
        }
        CoreHelper.WriteTraceEntry("MusicUtils", "Nothing to rebuild. Exiting...");
        if (paramRebuildMediaDatabaseListener != null)
        {
          paramRebuildMediaDatabaseListener.RebuiltStarted((ArrayList)localObject1);
          paramRebuildMediaDatabaseListener.RebuiltComplete();
        }
        return;
      }
      Object localObject4 = (Feed)((Iterator)localObject3).next();
      if (((Feed)localObject4).getType() == 1)
      {
        localObject4 = new File(((Feed)localObject4).getFeedPath(), ".nomedia");
        if (!((File)localObject2).exists()) {
          ((ArrayList)localObject1).add(localObject4);
        }
      }
    }
    if (paramRebuildMediaDatabaseListener != null) {
      paramRebuildMediaDatabaseListener.RebuiltStarted((ArrayList)localObject1);
    }
    localObject2 = "Starting Database Rebuild... (Media database currently has " + DumpAudioDBRecordCount(BeyondPodApplication.GetInstance().getApplicationContext()) + " records.)";
    if (paramRebuildMediaDatabaseListener != null) {
      paramRebuildMediaDatabaseListener.RebuiltProgress((String)localObject2);
    }
    CoreHelper.WriteTraceEntry("MusicUtils", (String)localObject2);
    localObject2 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        paramRebuildMediaDatabaseListener = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = paramAnonymousIntent.getAction();
            if (paramAnonymousContext.equals("android.intent.action.MEDIA_SCANNER_STARTED")) {
              CoreHelper.WriteTraceEntry("MusicUtils", "Scanner Started");
            }
            while (!paramAnonymousContext.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
              return;
            }
            CoreHelper.WriteTraceEntry("MusicUtils", "Scanner Finished");
            if (MusicUtils.this.size() > 0)
            {
              CoreHelper.WriteTraceEntry("MusicUtils", "Scanner Finished. Deleting .nomedia files...");
              paramAnonymousContext = MusicUtils.this.iterator();
              for (;;)
              {
                if (!paramAnonymousContext.hasNext())
                {
                  MusicUtils.this.clear();
                  paramAnonymousContext = "Starting re-scan without .nomedia files... (Media database currently has " + MusicUtils.DumpAudioDBRecordCount(BeyondPodApplication.GetInstance().getApplicationContext()) + " records.)";
                  CoreHelper.WriteTraceEntry("MusicUtils", paramAnonymousContext);
                  if (paramRebuildMediaDatabaseListener != null) {
                    paramRebuildMediaDatabaseListener.RebuiltProgress(paramAnonymousContext);
                  }
                  MusicUtils.ForceMediaScanFor(FeedRepository.getRootPath());
                  return;
                }
                paramAnonymousIntent = (File)paramAnonymousContext.next();
                paramAnonymousIntent.delete();
                CoreHelper.WriteTraceEntry("MusicUtils", "   * Deleted .nomedia file in: " + paramAnonymousIntent);
              }
            }
            paramAnonymousContext = "Rebuilt complete! (Media database currently has " + MusicUtils.DumpAudioDBRecordCount(BeyondPodApplication.GetInstance().getApplicationContext()) + " records.). Reloading Repository...";
            if (paramRebuildMediaDatabaseListener != null) {
              paramRebuildMediaDatabaseListener.RebuiltProgress(paramAnonymousContext);
            }
            CoreHelper.WriteTraceEntry("MusicUtils", paramAnonymousContext);
            FeedRepository.ClearTrackImageCaches();
            BeyondPodApplication.GetInstance().unregisterReceiver(this);
            CoreHelper.nap(1);
            label245:
            if (FeedRepository.RepositoryLoadState() == 2)
            {
              CoreHelper.WriteTraceEntry("MusicUtils", "Repository saved, Reloading repository...");
              FeedRepository.UnloadRepository();
              FeedRepository.InitializeAndLoadRepository();
            }
            for (;;)
            {
              if (FeedRepository.RepositoryLoadState() == 2)
              {
                if (paramRebuildMediaDatabaseListener == null) {
                  break;
                }
                paramRebuildMediaDatabaseListener.RebuiltComplete();
                return;
                CoreHelper.WriteTraceEntry("MusicUtils", "Waiting for repository to finish saving...");
                CoreHelper.nap(1);
                break label245;
              }
              CoreHelper.WriteTraceEntry("MusicUtils", "Waiting for repository to finish loading...");
              CoreHelper.nap(1);
            }
          }
        };
        localObject1 = new IntentFilter();
        ((IntentFilter)localObject1).addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        ((IntentFilter)localObject1).addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        ((IntentFilter)localObject1).addAction("android.intent.action.MEDIA_UNMOUNTED");
        ((IntentFilter)localObject1).addDataScheme("file");
        BeyondPodApplication.GetInstance().registerReceiver(paramRebuildMediaDatabaseListener, (IntentFilter)localObject1);
        ForceMediaScanFor(FeedRepository.getRootPath());
        return;
      }
      localObject3 = (File)((Iterator)localObject2).next();
      if (CoreHelper.CopyResToFile(R.raw.nomedia, (File)localObject3)) {
        CoreHelper.WriteTraceEntry("MusicUtils", "   * Created .nomedia file in: " + localObject3);
      }
    }
  }
  
  public static boolean VideoTrackImageMatchesDatabase(Track paramTrack, Cursor paramCursor)
  {
    if (paramTrack.IsUsingParentImage()) {}
    do
    {
      return true;
      if (StringUtils.IsNullOrEmpty(paramTrack.TrackImagePath())) {
        return false;
      }
      paramCursor = paramCursor.getString(paramCursor.getColumnIndexOrThrow("_id"));
    } while (paramTrack.TrackImagePath().contains(paramCursor));
    return false;
  }
  
  public static Bitmap getArtwork(Context paramContext, Track paramTrack, int paramInt1, int paramInt2, int paramInt3)
  {
    localObject3 = null;
    Bitmap localBitmap = null;
    localObject2 = localObject3;
    Object localObject4;
    Object localObject5;
    Cursor localCursor1;
    if (paramTrack != null)
    {
      localObject4 = null;
      localObject5 = null;
      localCursor1 = null;
      localObject1 = localObject4;
      localObject2 = localObject5;
    }
    for (;;)
    {
      try
      {
        if (paramTrack.HasImage()) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = localObject5;
        localCursor1 = getAudioCursor(paramContext, paramTrack.TrackPath(), null);
        localCursor2 = localCursor1;
        if (localCursor1 != null)
        {
          localObject1 = localCursor1;
          localObject2 = localCursor1;
          localBitmap = LoadAudioThumbnail(paramContext, paramTrack, paramInt1, paramInt2, paramInt3, localCursor1);
          localCursor2 = localCursor1;
        }
        localObject2 = localBitmap;
        if (localCursor2 != null)
        {
          localCursor2.close();
          localObject2 = localBitmap;
        }
      }
      catch (Exception paramContext)
      {
        Cursor localCursor2;
        localObject2 = localObject1;
        CoreHelper.WriteLogEntry("MusicUtils", "Failed to get album artwork for" + paramTrack.getName() + "! Reason: " + paramContext.getMessage());
        localObject2 = localObject3;
        return null;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        ((Cursor)localObject2).close();
      }
      return (Bitmap)localObject2;
      localCursor2 = localCursor1;
      localObject1 = localObject4;
      localObject2 = localObject5;
      if (paramTrack.TrackImagePath().startsWith("content"))
      {
        localObject1 = localObject4;
        localObject2 = localObject5;
        localBitmap = getArtworkQuick(paramContext, Uri.parse(paramTrack.TrackImagePath()), paramInt1, paramInt2, paramInt3);
        localCursor2 = localCursor1;
      }
    }
  }
  
  /* Error */
  private static Bitmap getArtworkQuick(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 117	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload_1
    //   7: ifnull +558 -> 565
    //   10: aconst_null
    //   11: astore 10
    //   13: aconst_null
    //   14: astore 11
    //   16: aconst_null
    //   17: astore_0
    //   18: aconst_null
    //   19: astore 9
    //   21: aload 8
    //   23: aload_1
    //   24: ldc_w 641
    //   27: invokevirtual 645	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   30: astore 8
    //   32: aload 8
    //   34: ifnonnull +54 -> 88
    //   37: aload 8
    //   39: astore 9
    //   41: aload 8
    //   43: astore 10
    //   45: aload 8
    //   47: astore 11
    //   49: aload 8
    //   51: astore_0
    //   52: ldc 24
    //   54: new 126	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 647
    //   61: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 8
    //   76: ifnull +8 -> 84
    //   79: aload 8
    //   81: invokevirtual 650	android/os/ParcelFileDescriptor:close	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: iload 4
    //   90: iconst_2
    //   91: if_icmpne +48 -> 139
    //   94: aload 8
    //   96: astore 9
    //   98: aload 8
    //   100: astore 10
    //   102: aload 8
    //   104: astore 11
    //   106: aload 8
    //   108: astore_0
    //   109: iconst_1
    //   110: iconst_1
    //   111: getstatic 60	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   114: invokestatic 654	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   117: astore 12
    //   119: aload 12
    //   121: astore_1
    //   122: aload_1
    //   123: astore_0
    //   124: aload 8
    //   126: ifnull -40 -> 86
    //   129: aload 8
    //   131: invokevirtual 650	android/os/ParcelFileDescriptor:close	()V
    //   134: aload_1
    //   135: areturn
    //   136: astore_0
    //   137: aload_1
    //   138: areturn
    //   139: iconst_1
    //   140: istore 7
    //   142: aload 8
    //   144: astore 9
    //   146: aload 8
    //   148: astore 10
    //   150: aload 8
    //   152: astore 11
    //   154: aload 8
    //   156: astore_0
    //   157: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   160: iconst_1
    //   161: putfield 657	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   164: aload 8
    //   166: astore 9
    //   168: aload 8
    //   170: astore 10
    //   172: aload 8
    //   174: astore 11
    //   176: aload 8
    //   178: astore_0
    //   179: aload 8
    //   181: invokevirtual 661	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   184: aconst_null
    //   185: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   188: invokestatic 667	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   191: pop
    //   192: aload 8
    //   194: astore 9
    //   196: aload 8
    //   198: astore 10
    //   200: aload 8
    //   202: astore 11
    //   204: aload 8
    //   206: astore_0
    //   207: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   210: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   213: iconst_1
    //   214: ishr
    //   215: istore 6
    //   217: aload 8
    //   219: astore 9
    //   221: aload 8
    //   223: astore 10
    //   225: aload 8
    //   227: astore 11
    //   229: aload 8
    //   231: astore_0
    //   232: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   235: getfield 673	android/graphics/BitmapFactory$Options:outHeight	I
    //   238: iconst_1
    //   239: ishr
    //   240: istore 5
    //   242: goto +434 -> 676
    //   245: aload 8
    //   247: astore 9
    //   249: aload 8
    //   251: astore 10
    //   253: aload 8
    //   255: astore 11
    //   257: aload 8
    //   259: astore_0
    //   260: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   263: iload 7
    //   265: putfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   268: aload 8
    //   270: astore 9
    //   272: aload 8
    //   274: astore 10
    //   276: aload 8
    //   278: astore 11
    //   280: aload 8
    //   282: astore_0
    //   283: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   286: iconst_0
    //   287: putfield 657	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   290: aload 8
    //   292: astore 9
    //   294: aload 8
    //   296: astore 10
    //   298: aload 8
    //   300: astore 11
    //   302: aload 8
    //   304: astore_0
    //   305: aload 8
    //   307: invokevirtual 661	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   310: aconst_null
    //   311: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   314: invokestatic 667	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   317: astore 13
    //   319: aload 13
    //   321: astore 12
    //   323: aload 13
    //   325: ifnull +121 -> 446
    //   328: aload 13
    //   330: astore 12
    //   332: iload 4
    //   334: ifne +112 -> 446
    //   337: aload 8
    //   339: astore 9
    //   341: aload 8
    //   343: astore 10
    //   345: aload 8
    //   347: astore 11
    //   349: aload 8
    //   351: astore_0
    //   352: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   355: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   358: iload_2
    //   359: if_icmpne +32 -> 391
    //   362: aload 13
    //   364: astore 12
    //   366: aload 8
    //   368: astore 9
    //   370: aload 8
    //   372: astore 10
    //   374: aload 8
    //   376: astore 11
    //   378: aload 8
    //   380: astore_0
    //   381: getstatic 38	mobi/beyondpod/ui/core/MusicUtils:_BitmapOptionsCache	Landroid/graphics/BitmapFactory$Options;
    //   384: getfield 673	android/graphics/BitmapFactory$Options:outHeight	I
    //   387: iload_3
    //   388: if_icmpeq +58 -> 446
    //   391: aload 8
    //   393: astore 9
    //   395: aload 8
    //   397: astore 10
    //   399: aload 8
    //   401: astore 11
    //   403: aload 8
    //   405: astore_0
    //   406: aload 13
    //   408: iload_2
    //   409: iload_3
    //   410: iconst_1
    //   411: invokestatic 680	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   414: astore 12
    //   416: aload 12
    //   418: aload 13
    //   420: if_acmpeq +271 -> 691
    //   423: aload 8
    //   425: astore 9
    //   427: aload 8
    //   429: astore 10
    //   431: aload 8
    //   433: astore 11
    //   435: aload 8
    //   437: astore_0
    //   438: aload 13
    //   440: invokevirtual 362	android/graphics/Bitmap:recycle	()V
    //   443: goto +248 -> 691
    //   446: aload 12
    //   448: ifnonnull +40 -> 488
    //   451: aload 8
    //   453: astore 9
    //   455: aload 8
    //   457: astore 10
    //   459: aload 8
    //   461: astore 11
    //   463: aload 8
    //   465: astore_0
    //   466: ldc 24
    //   468: new 126	java/lang/StringBuilder
    //   471: dup
    //   472: ldc_w 682
    //   475: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   478: aload_1
    //   479: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: aload 12
    //   490: astore_0
    //   491: aload 8
    //   493: ifnull -407 -> 86
    //   496: aload 8
    //   498: invokevirtual 650	android/os/ParcelFileDescriptor:close	()V
    //   501: aload 12
    //   503: areturn
    //   504: astore_0
    //   505: aload 12
    //   507: areturn
    //   508: iload 7
    //   510: iconst_1
    //   511: ishl
    //   512: istore 7
    //   514: iload 6
    //   516: iconst_1
    //   517: ishr
    //   518: istore 6
    //   520: iload 5
    //   522: iconst_1
    //   523: ishr
    //   524: istore 5
    //   526: goto +150 -> 676
    //   529: astore_0
    //   530: aload 9
    //   532: astore_0
    //   533: ldc 24
    //   535: new 126	java/lang/StringBuilder
    //   538: dup
    //   539: ldc_w 684
    //   542: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   545: aload_1
    //   546: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload 9
    //   557: ifnull +8 -> 565
    //   560: aload 9
    //   562: invokevirtual 650	android/os/ParcelFileDescriptor:close	()V
    //   565: aconst_null
    //   566: areturn
    //   567: astore 8
    //   569: aload 10
    //   571: astore_0
    //   572: ldc 24
    //   574: new 126	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 686
    //   581: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_1
    //   585: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   588: ldc_w 688
    //   591: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 8
    //   596: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   599: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 10
    //   610: ifnull -45 -> 565
    //   613: aload 10
    //   615: invokevirtual 650	android/os/ParcelFileDescriptor:close	()V
    //   618: goto -53 -> 565
    //   621: astore_0
    //   622: goto -57 -> 565
    //   625: astore_0
    //   626: aload 11
    //   628: astore_0
    //   629: ldc 24
    //   631: ldc_w 690
    //   634: invokestatic 158	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload 11
    //   639: ifnull +8 -> 647
    //   642: aload 11
    //   644: invokevirtual 650	android/os/ParcelFileDescriptor:close	()V
    //   647: aconst_null
    //   648: areturn
    //   649: astore_1
    //   650: aload_0
    //   651: ifnull +7 -> 658
    //   654: aload_0
    //   655: invokevirtual 650	android/os/ParcelFileDescriptor:close	()V
    //   658: aload_1
    //   659: athrow
    //   660: astore_0
    //   661: goto -577 -> 84
    //   664: astore_0
    //   665: goto -100 -> 565
    //   668: astore_0
    //   669: goto -22 -> 647
    //   672: astore_0
    //   673: goto -15 -> 658
    //   676: iload 6
    //   678: iload_2
    //   679: if_icmple -434 -> 245
    //   682: iload 5
    //   684: iload_3
    //   685: if_icmpgt -177 -> 508
    //   688: goto -443 -> 245
    //   691: goto -245 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	paramContext	Context
    //   0	694	1	paramUri	Uri
    //   0	694	2	paramInt1	int
    //   0	694	3	paramInt2	int
    //   0	694	4	paramInt3	int
    //   240	446	5	i	int
    //   215	465	6	j	int
    //   140	373	7	k	int
    //   4	493	8	localObject1	Object
    //   567	28	8	localException	Exception
    //   19	542	9	localObject2	Object
    //   11	603	10	localObject3	Object
    //   14	629	11	localObject4	Object
    //   117	389	12	localObject5	Object
    //   317	122	13	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   129	134	136	java/io/IOException
    //   496	501	504	java/io/IOException
    //   21	32	529	java/io/FileNotFoundException
    //   52	74	529	java/io/FileNotFoundException
    //   109	119	529	java/io/FileNotFoundException
    //   157	164	529	java/io/FileNotFoundException
    //   179	192	529	java/io/FileNotFoundException
    //   207	217	529	java/io/FileNotFoundException
    //   232	242	529	java/io/FileNotFoundException
    //   260	268	529	java/io/FileNotFoundException
    //   283	290	529	java/io/FileNotFoundException
    //   305	319	529	java/io/FileNotFoundException
    //   352	362	529	java/io/FileNotFoundException
    //   381	391	529	java/io/FileNotFoundException
    //   406	416	529	java/io/FileNotFoundException
    //   438	443	529	java/io/FileNotFoundException
    //   466	488	529	java/io/FileNotFoundException
    //   21	32	567	java/lang/Exception
    //   52	74	567	java/lang/Exception
    //   109	119	567	java/lang/Exception
    //   157	164	567	java/lang/Exception
    //   179	192	567	java/lang/Exception
    //   207	217	567	java/lang/Exception
    //   232	242	567	java/lang/Exception
    //   260	268	567	java/lang/Exception
    //   283	290	567	java/lang/Exception
    //   305	319	567	java/lang/Exception
    //   352	362	567	java/lang/Exception
    //   381	391	567	java/lang/Exception
    //   406	416	567	java/lang/Exception
    //   438	443	567	java/lang/Exception
    //   466	488	567	java/lang/Exception
    //   613	618	621	java/io/IOException
    //   21	32	625	java/lang/OutOfMemoryError
    //   52	74	625	java/lang/OutOfMemoryError
    //   109	119	625	java/lang/OutOfMemoryError
    //   157	164	625	java/lang/OutOfMemoryError
    //   179	192	625	java/lang/OutOfMemoryError
    //   207	217	625	java/lang/OutOfMemoryError
    //   232	242	625	java/lang/OutOfMemoryError
    //   260	268	625	java/lang/OutOfMemoryError
    //   283	290	625	java/lang/OutOfMemoryError
    //   305	319	625	java/lang/OutOfMemoryError
    //   352	362	625	java/lang/OutOfMemoryError
    //   381	391	625	java/lang/OutOfMemoryError
    //   406	416	625	java/lang/OutOfMemoryError
    //   438	443	625	java/lang/OutOfMemoryError
    //   466	488	625	java/lang/OutOfMemoryError
    //   21	32	649	finally
    //   52	74	649	finally
    //   109	119	649	finally
    //   157	164	649	finally
    //   179	192	649	finally
    //   207	217	649	finally
    //   232	242	649	finally
    //   260	268	649	finally
    //   283	290	649	finally
    //   305	319	649	finally
    //   352	362	649	finally
    //   381	391	649	finally
    //   406	416	649	finally
    //   438	443	649	finally
    //   466	488	649	finally
    //   533	555	649	finally
    //   572	608	649	finally
    //   629	637	649	finally
    //   79	84	660	java/io/IOException
    //   560	565	664	java/io/IOException
    //   642	647	668	java/io/IOException
    //   654	658	672	java/io/IOException
  }
  
  public static Cursor getAudioCursor(Context paramContext, String paramString, Uri paramUri)
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "_id";
    arrayOfString[1] = "_data";
    arrayOfString[2] = "title";
    arrayOfString[3] = "duration";
    arrayOfString[4] = "album_id";
    arrayOfString[5] = "mime_type";
    if (paramUri != null) {
      paramContext = query(paramContext, paramUri, arrayOfString, null, null, null);
    }
    while (paramContext != null)
    {
      paramContext.moveToFirst();
      if (paramContext.isAfterLast()) {
        break;
      }
      return paramContext;
      if (paramString != null) {
        paramContext = query(paramContext, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOfString, "_data=?", new String[] { paramString }, "title_key");
      } else {
        paramContext = query(paramContext, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOfString, null, null, "title_key");
      }
    }
    return null;
  }
  
  private static Cursor getImageCursor(Context paramContext, String paramString, Uri paramUri)
  {
    Object localObject = new String[4];
    localObject[0] = "_data";
    localObject[1] = "title";
    localObject[2] = "_id";
    localObject[3] = "mime_type";
    if (paramUri != null)
    {
      paramContext = query(paramContext, paramUri, (String[])localObject, null, null, null);
      if (paramContext == null) {
        break label144;
      }
      paramContext.moveToFirst();
      if (paramContext.isAfterLast()) {
        break label144;
      }
      localObject = new StringBuilder("Found image record for:").append(paramString);
      if (paramUri == null) {
        break label137;
      }
    }
    label137:
    for (paramString = ", Location: " + paramUri;; paramString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    {
      CoreHelper.WriteTraceEntry("MusicUtils", paramString);
      return paramContext;
      paramContext = query(paramContext, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[])localObject, "_data=?", new String[] { paramString }, "bucket_display_name");
      break;
    }
    label144:
    return null;
  }
  
  public static final Bitmap getVideoArtwork(Context paramContext, Track paramTrack, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    localObject4 = null;
    Object localObject5 = null;
    localObject3 = localObject4;
    Object localObject6;
    Object localObject7;
    if (paramTrack != null)
    {
      localObject6 = null;
      localObject7 = null;
      localObject3 = null;
      localObject1 = localObject6;
    }
    for (localObject2 = localObject7;; localObject2 = localObject3)
    {
      try
      {
        if (paramTrack.HasImage()) {
          break label120;
        }
        localObject1 = localObject6;
        localObject2 = localObject7;
        localObject3 = getVideoCursor(paramContext, paramTrack.TrackPath(), null);
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramContext = LoadVideoThumbnail(paramContext, paramTrack, paramBitmap, paramInt1, paramInt2, (Cursor)localObject3);
          localObject1 = paramContext;
          localObject2 = localObject3;
        }
        localObject3 = localObject1;
        if (localObject2 != null)
        {
          ((Cursor)localObject2).close();
          localObject3 = localObject1;
        }
      }
      catch (Exception paramContext)
      {
        label120:
        localObject2 = localObject1;
        CoreHelper.WriteLogEntry("MusicUtils", "Failed to get album artwork for" + paramTrack.getName() + "! Reason: " + paramContext.getMessage());
        localObject3 = localObject4;
        return null;
      }
      finally
      {
        if (localObject2 == null) {
          break;
        }
        ((Cursor)localObject2).close();
      }
      return (Bitmap)localObject3;
      localObject1 = localObject6;
      localObject2 = localObject7;
      paramContext = GetVideoThumbnail(paramContext, StringUtils.TryParseIntFromString(paramTrack.TrackImagePath(), Integer.valueOf(-1)).intValue(), true, paramBitmap, paramInt1, paramInt2);
      localObject1 = paramContext;
    }
  }
  
  public static Cursor getVideoCursor(Context paramContext, String paramString, Uri paramUri)
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "_data";
    arrayOfString[1] = "title";
    arrayOfString[2] = "duration";
    arrayOfString[3] = "_id";
    arrayOfString[4] = "mime_type";
    if (paramUri != null) {
      paramContext = query(paramContext, paramUri, arrayOfString, null, null, null);
    }
    while (paramContext != null)
    {
      paramContext.moveToFirst();
      if (paramContext.isAfterLast()) {
        break;
      }
      return paramContext;
      if (paramString != null) {
        paramContext = query(paramContext, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, arrayOfString, "_data=?", new String[] { paramString }, "title");
      } else {
        paramContext = query(paramContext, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, arrayOfString, null, null, "title");
      }
    }
    return null;
  }
  
  public static Cursor query(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      paramContext = paramContext.getContentResolver();
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      return paramContext;
    }
    catch (UnsupportedOperationException paramContext) {}
    return null;
  }
  
  public static final Bitmap sizeAndFrame(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2)
  {
    if (paramBitmap1 == null) {
      return paramBitmap2;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    label26:
    Object localObject;
    Rect localRect;
    if (paramBitmap2 == null)
    {
      if (paramBitmap2 != null) {
        break label249;
      }
      localObject = null;
      localRect = new Rect(0, 0, paramInt1, paramInt2);
      if ((i > paramInt1) || (j > paramInt2)) {
        break label257;
      }
      localRect.left = (paramInt1 / 2 - i / 2);
      localRect.top = (paramInt2 / 2 - j / 2);
      localRect.right = (localRect.left + i);
      localRect.bottom = (localRect.top + j);
    }
    for (;;)
    {
      try
      {
        CoreHelper.WriteTraceEntryInDebug("MusicUtils", "Resizing image: " + localObject + " => " + localRect);
        Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        if ((localRect.width() < paramInt1) || (localRect.height() < paramInt2)) {
          localCanvas.drawColor(-12303292);
        }
        localCanvas.drawBitmap(paramBitmap1, (Rect)localObject, localRect, localPaint);
        if (paramBitmap2 != null) {
          localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, localPaint);
        }
        paramBitmap1.recycle();
        return localBitmap;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        label249:
        label257:
        CoreHelper.WriteTraceEntry("MusicUtils", "Unable to execute sizeAndFrame! OutOfMemoryError");
      }
      paramInt1 = paramBitmap2.getWidth();
      break;
      paramInt2 = paramBitmap2.getHeight();
      break label26;
      if ((i > paramInt1) || (j > paramInt2)) {
        if (i >= j)
        {
          i = (i - j) / 2;
          localObject = new Rect(i, 0, i + j, j);
        }
        else
        {
          j = (j - i) / 2;
          localObject = new Rect(0, j, i, j + i);
        }
      }
    }
    return null;
  }
  
  public static abstract interface RebuildMediaDatabaseListener
  {
    public abstract void RebuiltComplete();
    
    public abstract void RebuiltProgress(String paramString);
    
    public abstract void RebuiltStarted(ArrayList<File> paramArrayList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/MusicUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
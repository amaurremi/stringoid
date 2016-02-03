package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

final class Utils
{
  static final int DEFAULT_CONNECT_TIMEOUT = 15000;
  static final int DEFAULT_READ_TIMEOUT = 20000;
  private static final int KEY_PADDING = 50;
  static final StringBuilder MAIN_THREAD_KEY_BUILDER = new StringBuilder();
  private static final int MAX_DISK_CACHE_SIZE = 52428800;
  private static final int MIN_DISK_CACHE_SIZE = 5242880;
  static final String OWNER_DISPATCHER = "Dispatcher";
  static final String OWNER_HUNTER = "Hunter";
  static final String OWNER_MAIN = "Main";
  private static final String PICASSO_CACHE = "picasso-cache";
  static final String THREAD_IDLE_NAME = "Picasso-Idle";
  static final String THREAD_PREFIX = "Picasso-";
  static final String VERB_BATCHED = "batched";
  static final String VERB_CANCELED = "canceled";
  static final String VERB_CHANGED = "changed";
  static final String VERB_COMPLETED = "completed";
  static final String VERB_CREATED = "created";
  static final String VERB_DECODED = "decoded";
  static final String VERB_DELIVERED = "delivered";
  static final String VERB_ENQUEUED = "enqueued";
  static final String VERB_ERRORED = "errored";
  static final String VERB_EXECUTING = "executing";
  static final String VERB_IGNORED = "ignored";
  static final String VERB_JOINED = "joined";
  static final String VERB_REMOVED = "removed";
  static final String VERB_REPLAYING = "replaying";
  static final String VERB_RETRYING = "retrying";
  static final String VERB_TRANSFORMED = "transformed";
  private static final String WEBP_FILE_HEADER_RIFF = "RIFF";
  private static final int WEBP_FILE_HEADER_SIZE = 12;
  private static final String WEBP_FILE_HEADER_WEBP = "WEBP";
  
  static long calculateDiskCacheSize(File paramFile)
  {
    long l1 = 5242880L;
    try
    {
      paramFile = new StatFs(paramFile.getAbsolutePath());
      long l2 = paramFile.getBlockCount() * paramFile.getBlockSize() / 50L;
      l1 = l2;
    }
    catch (IllegalArgumentException paramFile)
    {
      for (;;) {}
    }
    return Math.max(Math.min(l1, 52428800L), 5242880L);
  }
  
  static int calculateMemoryCacheSize(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)getService(paramContext, "activity");
    if ((paramContext.getApplicationInfo().flags & 0x100000) != 0) {}
    for (int i = 1;; i = 0)
    {
      int k = localActivityManager.getMemoryClass();
      int j = k;
      if (i != 0)
      {
        j = k;
        if (Build.VERSION.SDK_INT >= 11) {
          j = ActivityManagerHoneycomb.getLargeMemoryClass(localActivityManager);
        }
      }
      return 1048576 * j / 7;
    }
  }
  
  static void checkMain()
  {
    if (!isMain()) {
      throw new IllegalStateException("Method call should happen from the main thread.");
    }
  }
  
  static void checkNotMain()
  {
    if (isMain()) {
      throw new IllegalStateException("Method call should not happen from the main thread.");
    }
  }
  
  static void closeQuietly(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return;
    }
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  static File createDefaultCacheDir(Context paramContext)
  {
    paramContext = new File(paramContext.getApplicationContext().getCacheDir(), "picasso-cache");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext;
  }
  
  static Downloader createDefaultDownloader(Context paramContext)
  {
    int i = 0;
    try
    {
      Class.forName("com.squareup.okhttp.OkUrlFactory");
      i = 1;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      int j;
      for (;;) {}
    }
    j = 0;
    try
    {
      Class.forName("com.squareup.okhttp.OkHttpClient");
      j = 1;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;) {}
    }
    if (j != i) {
      throw new RuntimeException("Picasso detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Picasso, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
    }
    if (j != 0) {
      return OkHttpLoaderCreator.create(paramContext);
    }
    return new UrlConnectionDownloader(paramContext);
  }
  
  static String createKey(Request paramRequest)
  {
    paramRequest = createKey(paramRequest, MAIN_THREAD_KEY_BUILDER);
    MAIN_THREAD_KEY_BUILDER.setLength(0);
    return paramRequest;
  }
  
  static String createKey(Request paramRequest, StringBuilder paramStringBuilder)
  {
    if (paramRequest.uri != null)
    {
      String str = paramRequest.uri.toString();
      paramStringBuilder.ensureCapacity(str.length() + 50);
      paramStringBuilder.append(str);
      paramStringBuilder.append('\n');
      if (paramRequest.rotationDegrees != 0.0F)
      {
        paramStringBuilder.append("rotation:").append(paramRequest.rotationDegrees);
        if (paramRequest.hasRotationPivot) {
          paramStringBuilder.append('@').append(paramRequest.rotationPivotX).append('x').append(paramRequest.rotationPivotY);
        }
        paramStringBuilder.append('\n');
      }
      if (paramRequest.targetWidth != 0)
      {
        paramStringBuilder.append("resize:").append(paramRequest.targetWidth).append('x').append(paramRequest.targetHeight);
        paramStringBuilder.append('\n');
      }
      if (!paramRequest.centerCrop) {
        break label241;
      }
      paramStringBuilder.append("centerCrop\n");
    }
    for (;;)
    {
      if (paramRequest.transformations == null) {
        break label259;
      }
      int i = 0;
      int j = paramRequest.transformations.size();
      while (i < j)
      {
        paramStringBuilder.append(((Transformation)paramRequest.transformations.get(i)).key());
        paramStringBuilder.append('\n');
        i += 1;
      }
      paramStringBuilder.ensureCapacity(50);
      paramStringBuilder.append(paramRequest.resourceId);
      break;
      label241:
      if (paramRequest.centerInside) {
        paramStringBuilder.append("centerInside\n");
      }
    }
    label259:
    return paramStringBuilder.toString();
  }
  
  static int getBitmapBytes(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 12) {}
    for (int i = BitmapHoneycombMR1.getByteCount(paramBitmap); i < 0; i = paramBitmap.getRowBytes() * paramBitmap.getHeight()) {
      throw new IllegalStateException("Negative size: " + paramBitmap);
    }
    return i;
  }
  
  static String getLogIdsForHunter(BitmapHunter paramBitmapHunter)
  {
    return getLogIdsForHunter(paramBitmapHunter, "");
  }
  
  static String getLogIdsForHunter(BitmapHunter paramBitmapHunter, String paramString)
  {
    paramString = new StringBuilder(paramString);
    Action localAction = paramBitmapHunter.getAction();
    if (localAction != null) {
      paramString.append(localAction.request.logId());
    }
    paramBitmapHunter = paramBitmapHunter.getActions();
    if (paramBitmapHunter != null)
    {
      int i = 0;
      int j = paramBitmapHunter.size();
      while (i < j)
      {
        if ((i > 0) || (localAction != null)) {
          paramString.append(", ");
        }
        paramString.append(((Action)paramBitmapHunter.get(i)).request.logId());
        i += 1;
      }
    }
    return paramString.toString();
  }
  
  static int getResourceId(Resources paramResources, Request paramRequest)
    throws FileNotFoundException
  {
    if ((paramRequest.resourceId != 0) || (paramRequest.uri == null)) {
      return paramRequest.resourceId;
    }
    String str = paramRequest.uri.getAuthority();
    if (str == null) {
      throw new FileNotFoundException("No package provided: " + paramRequest.uri);
    }
    List localList = paramRequest.uri.getPathSegments();
    if ((localList == null) || (localList.isEmpty())) {
      throw new FileNotFoundException("No path segments: " + paramRequest.uri);
    }
    if (localList.size() == 1) {
      try
      {
        int i = Integer.parseInt((String)localList.get(0));
        return i;
      }
      catch (NumberFormatException paramResources)
      {
        throw new FileNotFoundException("Last path segment is not a resource ID: " + paramRequest.uri);
      }
    }
    if (localList.size() == 2)
    {
      paramRequest = (String)localList.get(0);
      return paramResources.getIdentifier((String)localList.get(1), paramRequest, str);
    }
    throw new FileNotFoundException("More than two path segments: " + paramRequest.uri);
  }
  
  static Resources getResources(Context paramContext, Request paramRequest)
    throws FileNotFoundException
  {
    if ((paramRequest.resourceId != 0) || (paramRequest.uri == null)) {
      return paramContext.getResources();
    }
    String str = paramRequest.uri.getAuthority();
    if (str == null) {
      throw new FileNotFoundException("No package provided: " + paramRequest.uri);
    }
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication(str);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new FileNotFoundException("Unable to obtain resources for package: " + paramRequest.uri);
    }
  }
  
  static <T> T getService(Context paramContext, String paramString)
  {
    return (T)paramContext.getSystemService(paramString);
  }
  
  static boolean hasPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  static boolean isAirplaneModeOn(Context paramContext)
  {
    boolean bool = false;
    if (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  static boolean isMain()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  static boolean isWebPFile(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[12];
    boolean bool = false;
    if (paramInputStream.read(arrayOfByte, 0, 12) == 12)
    {
      if (("RIFF".equals(new String(arrayOfByte, 0, 4, "US-ASCII"))) && ("WEBP".equals(new String(arrayOfByte, 8, 4, "US-ASCII")))) {
        bool = true;
      }
    }
    else {
      return bool;
    }
    return false;
  }
  
  static void log(String paramString1, String paramString2, String paramString3)
  {
    log(paramString1, paramString2, paramString3, "");
  }
  
  static void log(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
  }
  
  static boolean parseResponseSourceHeader(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.split(" ", 2);
      if ("CACHE".equals(paramString[0])) {
        return true;
      }
    } while (paramString.length == 1);
    try
    {
      if ("CONDITIONAL_CACHE".equals(paramString[0]))
      {
        int i = Integer.parseInt(paramString[1]);
        if (i != 304) {}
      }
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (NumberFormatException paramString) {}
  }
  
  static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  @TargetApi(11)
  private static class ActivityManagerHoneycomb
  {
    static int getLargeMemoryClass(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  @TargetApi(12)
  private static class BitmapHoneycombMR1
  {
    static int getByteCount(Bitmap paramBitmap)
    {
      return paramBitmap.getByteCount();
    }
  }
  
  private static class OkHttpLoaderCreator
  {
    static Downloader create(Context paramContext)
    {
      return new OkHttpDownloader(paramContext);
    }
  }
  
  private static class PicassoThread
    extends Thread
  {
    public PicassoThread(Runnable paramRunnable)
    {
      super();
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      super.run();
    }
  }
  
  static class PicassoThreadFactory
    implements ThreadFactory
  {
    public Thread newThread(Runnable paramRunnable)
    {
      return new Utils.PicassoThread(paramRunnable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
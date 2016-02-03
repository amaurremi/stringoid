package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class AdCache
{
  private static final String CACHED_AD_FILE = "ad.dat";
  private static final String CACHE_INCOMPLETE_PREFIX = "incompleteDownload_";
  private static final String CACHE_PREFIX = "nextCachedAd_";
  private static final String CACHE_PREFIX_APID = "nextCachedAd_apids";
  private static final String LOCK_FILE = "ad.lock";
  static final int PRIORITY_FETCH = 3;
  static final int PRIORITY_PRECACHE = 1;
  static final int PRIORITY_REFRESH = 2;
  static final String PRIVATE_CACHE_DIR = ".mmsyscache";
  private static Set<String> apidListSet;
  private static String cachedVideoList;
  private static boolean cachedVideoListLoaded;
  private static Set<String> cachedVideoSet;
  private static Map<String, String> incompleteDownloadHashMap;
  private static boolean incompleteDownloadHashMapLoaded;
  static boolean isExternalEnabled = true;
  private static Map<String, String> nextCachedAdHashMap;
  private static boolean nextCachedAdHashMapLoaded;
  
  static void cachedVideoWasAdded(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!cachedVideoListLoaded) {
        getCachedVideoList(paramContext);
      }
      if (cachedVideoSet == null) {
        cachedVideoSet = new HashSet();
      }
      cachedVideoSet.add(paramString);
      cachedVideoList = null;
      return;
    }
    finally {}
  }
  
  static void cachedVideoWasRemoved(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!cachedVideoListLoaded) {
        getCachedVideoList(paramContext);
      }
      if (cachedVideoSet != null)
      {
        cachedVideoSet.remove(paramString);
        cachedVideoList = null;
      }
      return;
    }
    finally {}
  }
  
  static void cleanCache(Context paramContext)
  {
    Utils.ThreadUtils.execute(new Runnable()
    {
      public void run()
      {
        MMSDK.Log.d("AdCache");
        AdCache.cleanUpExpiredAds(this.val$context);
        AdCache.cleanupCache(this.val$context);
      }
    });
  }
  
  static void cleanUpExpiredAds(Context paramContext)
  {
    iterateCachedAds(paramContext, 1, new Iterator()
    {
      boolean callback(String paramAnonymousString1, int paramAnonymousInt, Date paramAnonymousDate, String paramAnonymousString2, long paramAnonymousLong, ObjectInputStream paramAnonymousObjectInputStream)
      {
        if ((paramAnonymousDate != null) && (paramAnonymousDate.getTime() <= System.currentTimeMillis())) {}
        try
        {
          paramAnonymousDate = (CachedAd)paramAnonymousObjectInputStream.readObject();
          MMSDK.Log.d("Deleting expired ad %s.", new Object[] { paramAnonymousDate.getId() });
          paramAnonymousDate.delete(this.val$context);
          return true;
        }
        catch (Exception paramAnonymousDate)
        {
          MMSDK.Log.d("There was a problem reading the cached ad %s.", new Object[] { paramAnonymousString1 });
          MMSDK.Log.d(paramAnonymousDate);
        }
        return true;
      }
    });
  }
  
  static void cleanupCache(Context paramContext)
  {
    cleanupInternalCache(paramContext);
    if (isExternalStorageAvailable(paramContext)) {
      cleanupExternalCache(paramContext);
    }
  }
  
  static void cleanupDirectory(File paramFile, long paramLong)
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isFile()) {
        if (System.currentTimeMillis() - localFile.lastModified() > paramLong) {
          localFile.delete();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFile.isDirectory()) {
          try
          {
            cleanupDirectory(localFile, paramLong);
            if (localFile.list().length == 0) {
              localFile.delete();
            }
          }
          catch (SecurityException localSecurityException) {}
        }
      }
    }
  }
  
  private static void cleanupExternalCache(Context paramContext)
  {
    File localFile = getExternalCacheDirectory(paramContext);
    if (localFile == null) {}
    while ((!localFile.exists()) || (!localFile.isDirectory())) {
      return;
    }
    cleanupDirectory(localFile, HandShake.sharedHandShake(paramContext).creativeCacheTimeout);
  }
  
  private static void cleanupInternalCache(Context paramContext)
  {
    File localFile = getInternalCacheDirectory(paramContext);
    if (localFile == null) {}
    while ((!localFile.exists()) || (!localFile.isDirectory())) {
      return;
    }
    cleanupDirectory(localFile, HandShake.sharedHandShake(paramContext).creativeCacheTimeout);
  }
  
  static boolean deleteFile(Context paramContext, String paramString)
  {
    paramContext = getCachedAdFile(paramContext, paramString);
    if (paramContext != null) {
      return paramContext.delete();
    }
    return false;
  }
  
  static boolean downloadComponent(String paramString1, String paramString2, File paramFile, Context paramContext)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString1))
    {
      MMSDK.Log.d("No Url ...");
      bool = false;
    }
    File localFile;
    Object localObject1;
    for (;;)
    {
      return bool;
      localFile = new File(paramFile, paramString2);
      MMSDK.Log.v("Downloading Component: %s from %s", new Object[] { paramString2, paramString1 });
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        MMSDK.Log.v(paramString2 + " already exists, skipping...");
        return true;
      }
      Object localObject5 = null;
      InputStream localInputStream2 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      long l1 = -1L;
      InputStream localInputStream1 = localInputStream2;
      Object localObject2 = localObject3;
      localObject1 = localObject5;
      paramFile = (File)localObject4;
      try
      {
        paramString1 = new URL(paramString1);
        localInputStream1 = localInputStream2;
        localObject2 = localObject3;
        localObject1 = localObject5;
        paramFile = (File)localObject4;
        HttpURLConnection.setFollowRedirects(true);
        localInputStream1 = localInputStream2;
        localObject2 = localObject3;
        localObject1 = localObject5;
        paramFile = (File)localObject4;
        paramString1 = (HttpURLConnection)paramString1.openConnection();
        localInputStream1 = localInputStream2;
        localObject2 = localObject3;
        localObject1 = localObject5;
        paramFile = (File)localObject4;
        paramString1.setConnectTimeout(30000);
        localInputStream1 = localInputStream2;
        localObject2 = localObject3;
        localObject1 = localObject5;
        paramFile = (File)localObject4;
        paramString1.setRequestMethod("GET");
        localInputStream1 = localInputStream2;
        localObject2 = localObject3;
        localObject1 = localObject5;
        paramFile = (File)localObject4;
        paramString1.connect();
        localInputStream1 = localInputStream2;
        localObject2 = localObject3;
        localObject1 = localObject5;
        paramFile = (File)localObject4;
        localInputStream2 = paramString1.getInputStream();
        localInputStream1 = localInputStream2;
        localObject2 = localObject3;
        localObject1 = localInputStream2;
        paramFile = (File)localObject4;
        paramString1 = paramString1.getHeaderField("Content-Length");
        if (paramString1 != null)
        {
          localInputStream1 = localInputStream2;
          localObject2 = localObject3;
          localObject1 = localInputStream2;
          paramFile = (File)localObject4;
          l1 = Long.parseLong(paramString1);
        }
        if (localInputStream2 == null)
        {
          localInputStream1 = localInputStream2;
          localObject2 = localObject3;
          localObject1 = localInputStream2;
          paramFile = (File)localObject4;
          MMSDK.Log.e("Connection stream is null downloading %s.", new Object[] { paramString2 });
          bool = false;
          if (localInputStream2 != null) {}
          try
          {
            localInputStream2.close();
            if (0 == 0) {
              continue;
            }
            throw new NullPointerException();
          }
          catch (IOException paramString1)
          {
            MMSDK.Log.e("Content caching error: %s", new Object[] { paramString1.getMessage() });
            if (localFile != null) {
              localFile.delete();
            }
            return false;
          }
        }
        else
        {
          localInputStream1 = localInputStream2;
          localObject2 = localObject3;
          localObject1 = localInputStream2;
          paramFile = (File)localObject4;
          if (isInternalDir(paramContext, getCacheDirectory(paramContext)))
          {
            localInputStream1 = localInputStream2;
            localObject2 = localObject3;
            localObject1 = localInputStream2;
            paramFile = (File)localObject4;
            paramString1 = paramContext.openFileOutput(localFile.getName(), 1);
            label444:
            localInputStream1 = localInputStream2;
            localObject2 = paramString1;
            localObject1 = localInputStream2;
            paramFile = paramString1;
            paramContext = new byte['က'];
            for (;;)
            {
              localInputStream1 = localInputStream2;
              localObject2 = paramString1;
              localObject1 = localInputStream2;
              paramFile = paramString1;
              int i = localInputStream2.read(paramContext);
              if (i <= 0) {
                break;
              }
              localInputStream1 = localInputStream2;
              localObject2 = paramString1;
              localObject1 = localInputStream2;
              paramFile = paramString1;
              paramString1.write(paramContext, 0, i);
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        localObject1 = localInputStream1;
        paramFile = (File)localObject2;
        MMSDK.Log.e("Exception downloading component %s: %s", new Object[] { paramString2, paramString1.getMessage() });
        if (localInputStream1 != null) {}
        for (;;)
        {
          try
          {
            localInputStream1.close();
            if (localObject2 != null) {
              ((FileOutputStream)localObject2).close();
            }
            if (localFile != null) {
              localFile.delete();
            }
            return false;
          }
          catch (IOException paramString1)
          {
            try
            {
              ((InputStream)localObject1).close();
              if (paramFile != null) {
                paramFile.close();
              }
              throw paramString1;
            }
            catch (IOException paramString1)
            {
              MMSDK.Log.e("Content caching error: %s", new Object[] { paramString1.getMessage() });
              if (localFile == null) {
                break label889;
              }
              localFile.delete();
            }
            paramString1 = paramString1;
            MMSDK.Log.e("Content caching error: %s", new Object[] { paramString1.getMessage() });
            if (localFile == null) {
              continue;
            }
            localFile.delete();
            return false;
          }
          localInputStream1 = localInputStream2;
          localObject2 = localObject3;
          localObject1 = localInputStream2;
          paramFile = (File)localObject4;
          paramString1 = new FileOutputStream(localFile);
          break label444;
          if (localFile != null)
          {
            localInputStream1 = localInputStream2;
            localObject2 = paramString1;
            localObject1 = localInputStream2;
            paramFile = paramString1;
          }
          try
          {
            long l2 = localFile.length();
            if ((l2 == l1) || (l1 == -1L))
            {
              bool = true;
              if (localInputStream2 != null) {}
              try
              {
                localInputStream2.close();
                if (paramString1 == null) {
                  break;
                }
                paramString1.close();
                return true;
              }
              catch (IOException paramString1)
              {
                MMSDK.Log.e("Content caching error: %s", new Object[] { paramString1.getMessage() });
                if (localFile != null) {
                  localFile.delete();
                }
                return false;
              }
            }
            localInputStream1 = localInputStream2;
            localObject2 = paramString1;
            localObject1 = localInputStream2;
            paramFile = paramString1;
            MMSDK.Log.e("Content-Length does not match actual length.");
          }
          catch (SecurityException paramContext)
          {
            localInputStream1 = localInputStream2;
            localObject2 = paramString1;
            localObject1 = localInputStream2;
            paramFile = paramString1;
            MMSDK.Log.e("Exception downloading component %s: %s", new Object[] { paramString2, paramContext.getMessage() });
            continue;
          }
          if (localInputStream2 != null) {}
          try
          {
            localInputStream2.close();
            if (paramString1 != null) {
              paramString1.close();
            }
          }
          catch (IOException paramString1)
          {
            MMSDK.Log.e("Content caching error: %s", new Object[] { paramString1.getMessage() });
            if (localFile != null) {
              localFile.delete();
            }
            return false;
          }
        }
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
    label889:
    return false;
  }
  
  static boolean downloadComponentToCache(String paramString1, String paramString2, Context paramContext)
  {
    return downloadComponent(paramString1, paramString2, getCacheDirectory(paramContext), paramContext);
  }
  
  static File getCacheDirectory(Context paramContext)
  {
    if (isExternalStorageAvailable(paramContext)) {
      return getExternalCacheDirectory(paramContext);
    }
    return getInternalCacheDirectory(paramContext);
  }
  
  private static File getCachedAdFile(Context paramContext, String paramString)
  {
    String str = paramString + "ad.dat";
    boolean bool = isExternalStorageAvailable(paramContext);
    File localFile = getCacheDirectory(paramContext);
    Object localObject = null;
    paramString = (String)localObject;
    if (localFile != null) {
      paramString = (String)localObject;
    }
    try
    {
      if (localFile.isDirectory()) {
        paramString = new File(localFile, str);
      }
      if (((paramString == null) || (!paramString.exists())) && (!bool))
      {
        paramContext = paramContext.getFilesDir();
        if (paramContext != null)
        {
          paramContext = new File(paramContext, ".mmsyscache" + File.separator + str);
          if (paramContext.exists())
          {
            bool = paramContext.isFile();
            if (bool) {
              return paramContext;
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      MMSDK.Log.e(paramContext);
      return null;
    }
    return paramString;
  }
  
  static String getCachedVideoList(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (cachedVideoList != null) {
          break label161;
        }
        if (!cachedVideoListLoaded)
        {
          localObject = new HashSet();
          iterateCachedAds(paramContext, 2, new Iterator()
          {
            boolean callback(CachedAd paramAnonymousCachedAd)
            {
              if ((paramAnonymousCachedAd.acid != null) && (paramAnonymousCachedAd.getType() == 1) && (paramAnonymousCachedAd.isOnDisk(this.val$context))) {
                localObject.add(paramAnonymousCachedAd.acid);
              }
              return true;
            }
          });
          cachedVideoSet = (Set)localObject;
          cachedVideoListLoaded = true;
        }
        if ((cachedVideoSet == null) || (cachedVideoSet.size() <= 0)) {
          break label161;
        }
        paramContext = new StringBuilder();
        final Object localObject = cachedVideoSet.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        String str = (String)((Iterator)localObject).next();
        if (paramContext.length() > 0) {
          paramContext.append("," + (String)str);
        } else {
          paramContext.append((String)str);
        }
      }
      finally {}
    }
    cachedVideoList = paramContext.toString();
    label161:
    paramContext = cachedVideoList;
    return paramContext;
  }
  
  static File getDownloadFile(Context paramContext, String paramString)
  {
    File localFile = getCacheDirectory(paramContext);
    paramContext = null;
    if (localFile != null) {
      paramContext = new File(localFile, paramString);
    }
    return paramContext;
  }
  
  private static File getExternalCacheDirectory(Context paramContext)
  {
    paramContext = null;
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile != null)
    {
      localFile = new File(localFile, ".mmsyscache");
      paramContext = localFile;
      if (!localFile.exists())
      {
        paramContext = localFile;
        if (!localFile.mkdirs()) {
          paramContext = null;
        }
      }
    }
    return paramContext;
  }
  
  /* Error */
  static String getIncompleteDownload(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 381	com/millennialmedia/android/AdCache:incompleteDownloadHashMapLoaded	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokestatic 384	com/millennialmedia/android/AdCache:loadIncompleteDownloadHashMap	(Landroid/content/Context;)V
    //   13: aload_1
    //   14: ifnonnull +10 -> 24
    //   17: aconst_null
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: getstatic 386	com/millennialmedia/android/AdCache:incompleteDownloadHashMap	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 392 2 0
    //   33: checkcast 364	java/lang/String
    //   36: astore_0
    //   37: goto -18 -> 19
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   0	46	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	13	40	finally
    //   24	37	40	finally
  }
  
  static File getInternalCacheDirectory(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    File localFile;
    do
    {
      do
      {
        do
        {
          return paramContext;
          localFile = new File(paramContext.getFilesDir(), ".mmsyscache");
          paramContext = localFile;
        } while (localFile == null);
        paramContext = localFile;
      } while (localFile.exists());
      paramContext = localFile;
    } while (localFile.mkdirs());
    return null;
  }
  
  /* Error */
  static String getNextCachedAd(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 395	com/millennialmedia/android/AdCache:nextCachedAdHashMapLoaded	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokestatic 398	com/millennialmedia/android/AdCache:loadNextCachedAdHashMap	(Landroid/content/Context;)V
    //   13: aload_1
    //   14: ifnonnull +10 -> 24
    //   17: aconst_null
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: getstatic 400	com/millennialmedia/android/AdCache:nextCachedAdHashMap	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 392 2 0
    //   33: checkcast 364	java/lang/String
    //   36: astore_0
    //   37: goto -18 -> 19
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   0	46	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	13	40	finally
    //   24	37	40	finally
  }
  
  static boolean hasDownloadFile(Context paramContext, String paramString)
  {
    paramContext = getDownloadFile(paramContext, paramString);
    return (paramContext != null) && (paramContext.exists());
  }
  
  static boolean isExternalMounted()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  static boolean isExternalStorageAvailable(Context paramContext)
  {
    if (paramContext == null) {}
    String str;
    do
    {
      return false;
      str = Environment.getExternalStorageState();
    } while ((paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) || (TextUtils.isEmpty(str)) || (!str.equals("mounted")) || (!isExternalEnabled));
    return true;
  }
  
  static boolean isInternalDir(Context paramContext, File paramFile)
  {
    paramContext = getInternalCacheDirectory(paramContext);
    return (paramContext != null) && (paramContext.equals(paramFile));
  }
  
  /* Error */
  static void iterateCachedAds(Context paramContext, int paramInt, Iterator paramIterator)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 293	com/millennialmedia/android/AdCache:getCacheDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnull +109 -> 115
    //   9: aload_0
    //   10: new 8	com/millennialmedia/android/AdCache$2
    //   13: dup
    //   14: invokespecial 420	com/millennialmedia/android/AdCache$2:<init>	()V
    //   17: invokevirtual 423	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   20: astore 11
    //   22: aload 11
    //   24: ifnull +91 -> 115
    //   27: aload 11
    //   29: arraylength
    //   30: istore 4
    //   32: iconst_0
    //   33: istore_3
    //   34: aconst_null
    //   35: astore_0
    //   36: iload_3
    //   37: iload 4
    //   39: if_icmpge +374 -> 413
    //   42: aload 11
    //   44: iload_3
    //   45: aaload
    //   46: astore 12
    //   48: aload 12
    //   50: ifnull +15 -> 65
    //   53: aload 12
    //   55: invokevirtual 162	java/io/File:exists	()Z
    //   58: istore 8
    //   60: iload 8
    //   62: ifne +25 -> 87
    //   65: aload_0
    //   66: ifnull +344 -> 410
    //   69: aload_0
    //   70: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   73: aconst_null
    //   74: astore_0
    //   75: iload_3
    //   76: iconst_1
    //   77: iadd
    //   78: istore_3
    //   79: goto -43 -> 36
    //   82: astore 9
    //   84: goto -9 -> 75
    //   87: iload_1
    //   88: ifne +54 -> 142
    //   91: aload_2
    //   92: aload 12
    //   94: invokevirtual 300	java/io/File:getName	()Ljava/lang/String;
    //   97: invokevirtual 430	com/millennialmedia/android/AdCache$Iterator:callback	(Ljava/lang/String;)Z
    //   100: istore 8
    //   102: iload 8
    //   104: ifne +20 -> 124
    //   107: aload_0
    //   108: ifnull +305 -> 413
    //   111: aload_0
    //   112: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   115: aload_2
    //   116: invokevirtual 433	com/millennialmedia/android/AdCache$Iterator:done	()V
    //   119: return
    //   120: astore_0
    //   121: goto -6 -> 115
    //   124: aload_0
    //   125: ifnull +285 -> 410
    //   128: aload_0
    //   129: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   132: aconst_null
    //   133: astore_0
    //   134: goto -59 -> 75
    //   137: astore 9
    //   139: goto -64 -> 75
    //   142: new 425	java/io/ObjectInputStream
    //   145: dup
    //   146: new 435	java/io/FileInputStream
    //   149: dup
    //   150: aload 12
    //   152: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 439	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   158: astore 9
    //   160: aload 9
    //   162: astore_0
    //   163: aload 9
    //   165: invokevirtual 442	java/io/ObjectInputStream:readInt	()I
    //   168: istore 5
    //   170: aload 9
    //   172: astore_0
    //   173: aload 9
    //   175: invokevirtual 445	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   178: checkcast 447	java/util/Date
    //   181: astore 13
    //   183: aload 9
    //   185: astore_0
    //   186: aload 9
    //   188: invokevirtual 445	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   191: checkcast 364	java/lang/String
    //   194: astore 10
    //   196: aload 9
    //   198: astore_0
    //   199: aload 9
    //   201: invokevirtual 450	java/io/ObjectInputStream:readLong	()J
    //   204: lstore 6
    //   206: iload_1
    //   207: iconst_1
    //   208: if_icmpne +48 -> 256
    //   211: aload 9
    //   213: astore_0
    //   214: aload_2
    //   215: aload 12
    //   217: invokevirtual 300	java/io/File:getName	()Ljava/lang/String;
    //   220: iload 5
    //   222: aload 13
    //   224: aload 10
    //   226: lload 6
    //   228: aload 9
    //   230: invokevirtual 453	com/millennialmedia/android/AdCache$Iterator:callback	(Ljava/lang/String;ILjava/util/Date;Ljava/lang/String;JLjava/io/ObjectInputStream;)Z
    //   233: ifne +61 -> 294
    //   236: aload 9
    //   238: astore_0
    //   239: aload 9
    //   241: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   244: iconst_0
    //   245: ifeq -130 -> 115
    //   248: new 284	java/lang/NullPointerException
    //   251: dup
    //   252: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   255: athrow
    //   256: aload 9
    //   258: astore_0
    //   259: aload_2
    //   260: aload 9
    //   262: invokevirtual 445	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   265: checkcast 455	com/millennialmedia/android/CachedAd
    //   268: invokevirtual 458	com/millennialmedia/android/AdCache$Iterator:callback	(Lcom/millennialmedia/android/CachedAd;)Z
    //   271: ifne +23 -> 294
    //   274: aload 9
    //   276: astore_0
    //   277: aload 9
    //   279: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   282: iconst_0
    //   283: ifeq -168 -> 115
    //   286: new 284	java/lang/NullPointerException
    //   289: dup
    //   290: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   293: athrow
    //   294: aload 9
    //   296: astore_0
    //   297: aload 9
    //   299: ifnull -224 -> 75
    //   302: aload 9
    //   304: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   307: aconst_null
    //   308: astore_0
    //   309: goto -234 -> 75
    //   312: astore 10
    //   314: aload_0
    //   315: astore 9
    //   317: aload 9
    //   319: astore_0
    //   320: ldc_w 460
    //   323: iconst_1
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload 12
    //   331: invokevirtual 300	java/io/File:getName	()Ljava/lang/String;
    //   334: aastore
    //   335: invokestatic 462	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload 9
    //   340: astore_0
    //   341: aload 10
    //   343: invokestatic 464	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/Throwable;)V
    //   346: aload 9
    //   348: astore_0
    //   349: aload 9
    //   351: ifnull -276 -> 75
    //   354: aload 9
    //   356: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   359: aconst_null
    //   360: astore_0
    //   361: goto -286 -> 75
    //   364: astore_2
    //   365: aload_0
    //   366: ifnull +7 -> 373
    //   369: aload_0
    //   370: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   373: aload_2
    //   374: athrow
    //   375: astore_0
    //   376: goto -261 -> 115
    //   379: astore_0
    //   380: goto -265 -> 115
    //   383: astore_0
    //   384: aload 9
    //   386: astore_0
    //   387: goto -312 -> 75
    //   390: astore_0
    //   391: aload 9
    //   393: astore_0
    //   394: goto -319 -> 75
    //   397: astore_0
    //   398: goto -25 -> 373
    //   401: astore_2
    //   402: goto -37 -> 365
    //   405: astore 10
    //   407: goto -90 -> 317
    //   410: goto -335 -> 75
    //   413: goto -298 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramContext	Context
    //   0	416	1	paramInt	int
    //   0	416	2	paramIterator	Iterator
    //   33	46	3	i	int
    //   30	10	4	j	int
    //   168	53	5	k	int
    //   204	23	6	l	long
    //   58	45	8	bool	boolean
    //   82	1	9	localIOException1	IOException
    //   137	1	9	localIOException2	IOException
    //   158	234	9	localObject	Object
    //   194	31	10	str	String
    //   312	30	10	localException1	Exception
    //   405	1	10	localException2	Exception
    //   20	23	11	arrayOfFile	File[]
    //   46	284	12	localFile	File
    //   181	42	13	localDate	Date
    // Exception table:
    //   from	to	target	type
    //   69	73	82	java/io/IOException
    //   111	115	120	java/io/IOException
    //   128	132	137	java/io/IOException
    //   53	60	312	java/lang/Exception
    //   91	102	312	java/lang/Exception
    //   142	160	312	java/lang/Exception
    //   53	60	364	finally
    //   91	102	364	finally
    //   142	160	364	finally
    //   248	256	375	java/io/IOException
    //   286	294	379	java/io/IOException
    //   302	307	383	java/io/IOException
    //   354	359	390	java/io/IOException
    //   369	373	397	java/io/IOException
    //   163	170	401	finally
    //   173	183	401	finally
    //   186	196	401	finally
    //   199	206	401	finally
    //   214	236	401	finally
    //   239	244	401	finally
    //   259	274	401	finally
    //   277	282	401	finally
    //   320	338	401	finally
    //   341	346	401	finally
    //   163	170	405	java/lang/Exception
    //   173	183	405	java/lang/Exception
    //   186	196	405	java/lang/Exception
    //   199	206	405	java/lang/Exception
    //   214	236	405	java/lang/Exception
    //   239	244	405	java/lang/Exception
    //   259	274	405	java/lang/Exception
    //   277	282	405	java/lang/Exception
  }
  
  /* Error */
  static CachedAd load(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: ldc_w 470
    //   8: invokevirtual 412	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore_2
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokestatic 181	com/millennialmedia/android/AdCache:getCachedAdFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   28: astore 5
    //   30: aload 5
    //   32: ifnonnull +5 -> 37
    //   35: aconst_null
    //   36: areturn
    //   37: aload_2
    //   38: astore_0
    //   39: new 425	java/io/ObjectInputStream
    //   42: dup
    //   43: new 435	java/io/FileInputStream
    //   46: dup
    //   47: aload 5
    //   49: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 439	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 442	java/io/ObjectInputStream:readInt	()I
    //   60: pop
    //   61: aload_2
    //   62: invokevirtual 445	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   65: checkcast 447	java/util/Date
    //   68: astore_0
    //   69: aload_2
    //   70: invokevirtual 445	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   73: pop
    //   74: aload_2
    //   75: invokevirtual 450	java/io/ObjectInputStream:readLong	()J
    //   78: pop2
    //   79: aload_2
    //   80: invokevirtual 445	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   83: checkcast 455	com/millennialmedia/android/CachedAd
    //   86: astore_0
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   95: aload_0
    //   96: areturn
    //   97: astore_1
    //   98: aload_0
    //   99: areturn
    //   100: astore_0
    //   101: aload_3
    //   102: astore_2
    //   103: aload_2
    //   104: astore_0
    //   105: ldc_w 472
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_1
    //   115: aastore
    //   116: invokestatic 277	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_2
    //   120: ifnull -106 -> 14
    //   123: aload_2
    //   124: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: areturn
    //   132: astore_3
    //   133: aload 4
    //   135: astore_2
    //   136: aload_2
    //   137: astore_0
    //   138: ldc_w 474
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: invokestatic 277	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_2
    //   153: astore_0
    //   154: aload_3
    //   155: invokevirtual 319	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokestatic 201	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   161: aload_2
    //   162: astore_0
    //   163: aload_3
    //   164: invokestatic 464	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/Throwable;)V
    //   167: aload_2
    //   168: ifnull -154 -> 14
    //   171: aload_2
    //   172: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: areturn
    //   180: astore_1
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 426	java/io/ObjectInputStream:close	()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_0
    //   192: goto -3 -> 189
    //   195: astore_1
    //   196: aload_2
    //   197: astore_0
    //   198: goto -17 -> 181
    //   201: astore_3
    //   202: goto -66 -> 136
    //   205: astore_0
    //   206: goto -103 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramContext	Context
    //   0	209	1	paramString	String
    //   20	177	2	localObject1	Object
    //   22	80	3	localObject2	Object
    //   132	32	3	localException1	Exception
    //   201	1	3	localException2	Exception
    //   17	117	4	localObject3	Object
    //   28	20	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   91	95	97	java/io/IOException
    //   39	56	100	java/io/FileNotFoundException
    //   123	127	129	java/io/IOException
    //   39	56	132	java/lang/Exception
    //   171	175	177	java/io/IOException
    //   39	56	180	finally
    //   105	119	180	finally
    //   138	152	180	finally
    //   154	161	180	finally
    //   163	167	180	finally
    //   185	189	191	java/io/IOException
    //   56	87	195	finally
    //   56	87	201	java/lang/Exception
    //   56	87	205	java/io/FileNotFoundException
  }
  
  private static void loadApidListSet(SharedPreferences paramSharedPreferences)
  {
    apidListSet = new HashSet();
    paramSharedPreferences = paramSharedPreferences.getString("nextCachedAd_apids", null);
    if (paramSharedPreferences != null)
    {
      paramSharedPreferences = paramSharedPreferences.split(MMSDK.COMMA);
      if ((paramSharedPreferences != null) && (paramSharedPreferences.length > 0))
      {
        int j = paramSharedPreferences.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramSharedPreferences[i];
          apidListSet.add(localObject);
          i += 1;
        }
      }
    }
  }
  
  static CachedAd loadIncompleteDownload(Context paramContext, String paramString)
  {
    paramString = getIncompleteDownload(paramContext, paramString);
    if (paramString == null) {
      return null;
    }
    return load(paramContext, paramString);
  }
  
  private static void loadIncompleteDownloadHashMap(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
    incompleteDownloadHashMap = new ConcurrentHashMap();
    if (apidListSet == null) {
      loadApidListSet(paramContext);
    }
    Iterator localIterator = apidListSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String[] arrayOfString = MMAdImpl.getAdTypes();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        String str3 = paramContext.getString("incompleteDownload_" + str2 + '_' + str1, null);
        if (str3 != null) {
          incompleteDownloadHashMap.put(str2 + '_' + str1, str3);
        }
        i += 1;
      }
    }
    incompleteDownloadHashMapLoaded = true;
  }
  
  static CachedAd loadNextCachedAd(Context paramContext, String paramString)
  {
    paramString = getNextCachedAd(paramContext, paramString);
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return load(paramContext, paramString);
  }
  
  private static void loadNextCachedAdHashMap(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
    nextCachedAdHashMap = new ConcurrentHashMap();
    if (apidListSet == null) {
      loadApidListSet(paramContext);
    }
    Iterator localIterator = apidListSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String[] arrayOfString = MMAdImpl.getAdTypes();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        String str3 = paramContext.getString("nextCachedAd_" + str2 + '_' + str1, null);
        if (str3 != null) {
          nextCachedAdHashMap.put(str2 + '_' + str1, str3);
        }
        i += 1;
      }
    }
    nextCachedAdHashMapLoaded = true;
  }
  
  static void resetCache(Context paramContext)
  {
    iterateCachedAds(paramContext, 2, new Iterator()
    {
      boolean callback(CachedAd paramAnonymousCachedAd)
      {
        MMSDK.Log.d("Deleting ad %s.", new Object[] { paramAnonymousCachedAd.getId() });
        paramAnonymousCachedAd.delete(this.val$context);
        return true;
      }
    });
    cachedVideoSet = null;
    cachedVideoList = null;
    cachedVideoListLoaded = false;
    Iterator localIterator;
    if (nextCachedAdHashMap != null)
    {
      localIterator = nextCachedAdHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        setNextCachedAd(paramContext, (String)localIterator.next(), null);
      }
    }
    if (incompleteDownloadHashMap != null)
    {
      localIterator = incompleteDownloadHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        setIncompleteDownload(paramContext, (String)localIterator.next(), null);
      }
    }
  }
  
  /* Error */
  static boolean save(Context paramContext, CachedAd paramCachedAd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_1
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 542	com/millennialmedia/android/CachedAd:getId	()Ljava/lang/String;
    //   25: invokestatic 181	com/millennialmedia/android/AdCache:getCachedAdFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   28: astore 8
    //   30: aload 8
    //   32: ifnull -14 -> 18
    //   35: ldc_w 544
    //   38: iconst_2
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: invokevirtual 542	com/millennialmedia/android/CachedAd:getId	()Ljava/lang/String;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 8
    //   53: aastore
    //   54: invokestatic 210	com/millennialmedia/android/MMSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: new 126	java/io/File
    //   60: dup
    //   61: aload 8
    //   63: invokevirtual 547	java/io/File:getParent	()Ljava/lang/String;
    //   66: new 215	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   73: aload_1
    //   74: invokevirtual 542	com/millennialmedia/android/CachedAd:getId	()Ljava/lang/String;
    //   77: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 36
    //   82: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 550	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 553	java/io/File:createNewFile	()Z
    //   96: ifne +39 -> 135
    //   99: ldc_w 555
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_1
    //   109: invokevirtual 542	com/millennialmedia/android/CachedAd:getId	()Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 210	com/millennialmedia/android/MMSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: invokevirtual 146	java/io/File:delete	()Z
    //   120: pop
    //   121: iconst_0
    //   122: ifeq +11 -> 133
    //   125: new 284	java/lang/NullPointerException
    //   128: dup
    //   129: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   132: athrow
    //   133: iconst_0
    //   134: ireturn
    //   135: new 557	java/io/ObjectOutputStream
    //   138: dup
    //   139: new 312	java/io/FileOutputStream
    //   142: dup
    //   143: aload 8
    //   145: invokespecial 323	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: invokespecial 560	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   151: astore_3
    //   152: aload_3
    //   153: aload_1
    //   154: invokevirtual 563	com/millennialmedia/android/CachedAd:getType	()I
    //   157: invokevirtual 566	java/io/ObjectOutputStream:writeInt	(I)V
    //   160: aload_3
    //   161: aload_1
    //   162: getfield 570	com/millennialmedia/android/CachedAd:expiration	Ljava/util/Date;
    //   165: invokevirtual 574	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   168: aload_3
    //   169: aload_1
    //   170: getfield 577	com/millennialmedia/android/CachedAd:acid	Ljava/lang/String;
    //   173: invokevirtual 574	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   176: aload_3
    //   177: aload_1
    //   178: getfield 580	com/millennialmedia/android/CachedAd:deferredViewStart	J
    //   181: invokevirtual 584	java/io/ObjectOutputStream:writeLong	(J)V
    //   184: aload_3
    //   185: aload_1
    //   186: invokevirtual 574	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   189: aload_2
    //   190: invokevirtual 146	java/io/File:delete	()Z
    //   193: pop
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 585	java/io/ObjectOutputStream:close	()V
    //   202: aload_1
    //   203: aload_0
    //   204: invokevirtual 588	com/millennialmedia/android/CachedAd:saveAssets	(Landroid/content/Context;)Z
    //   207: ifne +98 -> 305
    //   210: aload_1
    //   211: aload_0
    //   212: invokevirtual 590	com/millennialmedia/android/CachedAd:delete	(Landroid/content/Context;)V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_2
    //   218: aload 7
    //   220: astore_0
    //   221: aload_0
    //   222: astore_3
    //   223: aload 5
    //   225: astore 4
    //   227: ldc_w 592
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload_1
    //   237: invokevirtual 542	com/millennialmedia/android/CachedAd:getId	()Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 277	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_0
    //   245: astore_3
    //   246: aload 5
    //   248: astore 4
    //   250: aload_2
    //   251: invokevirtual 319	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   254: invokestatic 201	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/String;)V
    //   257: aload_0
    //   258: astore_3
    //   259: aload 5
    //   261: astore 4
    //   263: aload_2
    //   264: invokestatic 464	com/millennialmedia/android/MMSDK$Log:d	(Ljava/lang/Throwable;)V
    //   267: aload_0
    //   268: invokevirtual 146	java/io/File:delete	()Z
    //   271: pop
    //   272: aload 5
    //   274: ifnull -256 -> 18
    //   277: aload 5
    //   279: invokevirtual 585	java/io/ObjectOutputStream:close	()V
    //   282: iconst_0
    //   283: ireturn
    //   284: astore_0
    //   285: iconst_0
    //   286: ireturn
    //   287: astore_0
    //   288: aload_3
    //   289: invokevirtual 146	java/io/File:delete	()Z
    //   292: pop
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 585	java/io/ObjectOutputStream:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: iconst_1
    //   306: ireturn
    //   307: astore_1
    //   308: goto -5 -> 303
    //   311: astore_0
    //   312: aload_2
    //   313: astore_3
    //   314: aload 6
    //   316: astore 4
    //   318: goto -30 -> 288
    //   321: astore_0
    //   322: aload_3
    //   323: astore 4
    //   325: aload_2
    //   326: astore_3
    //   327: goto -39 -> 288
    //   330: astore_3
    //   331: aload_2
    //   332: astore_0
    //   333: aload_3
    //   334: astore_2
    //   335: goto -114 -> 221
    //   338: astore 4
    //   340: aload_2
    //   341: astore_0
    //   342: aload 4
    //   344: astore_2
    //   345: aload_3
    //   346: astore 5
    //   348: goto -127 -> 221
    //   351: astore_2
    //   352: goto -150 -> 202
    //   355: astore_0
    //   356: goto -223 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramContext	Context
    //   0	359	1	paramCachedAd	CachedAd
    //   91	99	2	localFile1	File
    //   217	115	2	localException1	Exception
    //   334	11	2	localException2	Exception
    //   351	1	2	localIOException	IOException
    //   1	326	3	localObject1	Object
    //   330	16	3	localException3	Exception
    //   6	318	4	localObject2	Object
    //   338	5	4	localException4	Exception
    //   12	335	5	localException5	Exception
    //   9	306	6	localObject3	Object
    //   3	216	7	localObject4	Object
    //   28	116	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   57	92	217	java/lang/Exception
    //   267	272	284	java/io/IOException
    //   277	282	284	java/io/IOException
    //   57	92	287	finally
    //   227	244	287	finally
    //   250	257	287	finally
    //   263	267	287	finally
    //   288	293	307	java/io/IOException
    //   298	303	307	java/io/IOException
    //   92	116	311	finally
    //   135	152	311	finally
    //   152	189	321	finally
    //   92	116	330	java/lang/Exception
    //   135	152	330	java/lang/Exception
    //   152	189	338	java/lang/Exception
    //   189	194	351	java/io/IOException
    //   198	202	351	java/io/IOException
    //   116	121	355	java/io/IOException
    //   125	133	355	java/io/IOException
  }
  
  private static void saveApidListSet(SharedPreferences.Editor paramEditor, String paramString)
  {
    int i = paramString.indexOf('_');
    String str;
    StringBuilder localStringBuilder;
    if ((i >= 0) && (i < paramString.length()))
    {
      str = paramString.substring(i + 1);
      if ((str != null) && (!apidListSet.contains(str)))
      {
        paramString = null;
        if (!apidListSet.isEmpty())
        {
          Iterator localIterator = apidListSet.iterator();
          localStringBuilder = new StringBuilder();
          for (;;)
          {
            paramString = localStringBuilder;
            if (!localIterator.hasNext()) {
              break;
            }
            localStringBuilder.append((String)localIterator.next() + MMSDK.COMMA);
          }
        }
        localStringBuilder = new StringBuilder();
        if (paramString != null) {
          break label176;
        }
      }
    }
    label176:
    for (paramString = "";; paramString = paramString.toString())
    {
      paramEditor.putString("nextCachedAd_apids", paramString + str);
      apidListSet.add(str);
      return;
    }
  }
  
  private static void saveIncompleteDownloadHashMap(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
      saveApidListSet(paramContext, paramString);
      paramContext.putString("incompleteDownload_" + paramString, (String)incompleteDownloadHashMap.get(paramString));
      paramContext.commit();
    }
  }
  
  private static void saveNextCachedAdHashMapValue(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
      saveApidListSet(paramContext, paramString);
      paramContext.putString("nextCachedAd_" + paramString, (String)nextCachedAdHashMap.get(paramString));
      paramContext.commit();
    }
  }
  
  static void setEnableExternalStorage(boolean paramBoolean)
  {
    isExternalEnabled = paramBoolean;
  }
  
  static void setIncompleteDownload(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (!incompleteDownloadHashMapLoaded) {
        loadIncompleteDownloadHashMap(paramContext);
      }
      if (paramString1 != null)
      {
        Map localMap = incompleteDownloadHashMap;
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        localMap.put(paramString1, str);
        saveIncompleteDownloadHashMap(paramContext, paramString1);
      }
      return;
    }
    finally {}
  }
  
  static void setNextCachedAd(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (!nextCachedAdHashMapLoaded) {
        loadNextCachedAdHashMap(paramContext);
      }
      if (paramString1 != null)
      {
        Map localMap = nextCachedAdHashMap;
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        localMap.put(paramString1, str);
        saveNextCachedAdHashMapValue(paramContext, paramString1);
      }
      return;
    }
    finally {}
  }
  
  static boolean startDownloadTask(Context paramContext, String paramString, CachedAd paramCachedAd, AdCacheTaskListener paramAdCacheTaskListener)
  {
    return AdCacheThreadPool.sharedThreadPool().startDownloadTask(paramContext, paramString, paramCachedAd, paramAdCacheTaskListener);
  }
  
  static abstract interface AdCacheTaskListener
  {
    public abstract void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean);
    
    public abstract void downloadStart(CachedAd paramCachedAd);
  }
  
  static class Iterator
  {
    static final int ITERATE_ID = 0;
    static final int ITERATE_INFO = 1;
    static final int ITERATE_OBJECT = 2;
    
    boolean callback(CachedAd paramCachedAd)
    {
      return false;
    }
    
    boolean callback(String paramString)
    {
      return false;
    }
    
    boolean callback(String paramString1, int paramInt, Date paramDate, String paramString2, long paramLong, ObjectInputStream paramObjectInputStream)
    {
      return false;
    }
    
    void done() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/AdCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
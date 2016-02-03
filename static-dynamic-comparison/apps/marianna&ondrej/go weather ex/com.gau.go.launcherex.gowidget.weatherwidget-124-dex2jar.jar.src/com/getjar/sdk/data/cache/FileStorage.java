package com.getjar.sdk.data.cache;

import android.content.Context;
import android.net.Uri;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.exceptions.CachingException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class FileStorage
  implements CacheStorage
{
  private final BasicCache _basicCache;
  private final File _directory;
  
  public FileStorage(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'namespace' cannot be NULL or empty");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("'databaseVersion' cannot be less than 0");
    }
    this._basicCache = new BasicCache(paramContext, paramString, paramInt, true);
    this._directory = new File(paramContext.getFilesDir() + File.separator + AuthManager.getInstance().getUserAccessId() + File.separator + paramString);
    if ((!this._directory.mkdirs()) && (!this._directory.isDirectory())) {
      throw new CachingException(String.format(Locale.US, "Failed to create file storage cache directory '%1$s'", new Object[] { this._directory.getAbsolutePath() }));
    }
    Logger.d(Area.STORAGE.value(), "FileStorage: Root cache directory created [%1$s]", new Object[] { Uri.fromFile(this._directory).toString() });
  }
  
  private void removeCacheEntry(CacheEntry paramCacheEntry)
  {
    new File(URI.create(paramCacheEntry.getValue())).delete();
    this._basicCache.removeCacheEntry(paramCacheEntry.getName());
  }
  
  public ArrayList<CacheEntry> getAllCacheEntries()
  {
    return this._basicCache.getAllCacheEntries();
  }
  
  public CacheEntry getCacheEntry(String paramString)
  {
    return this._basicCache.getCacheEntry(paramString);
  }
  
  public CacheEntry getUnexpiredCacheEntry(String paramString)
  {
    return this._basicCache.getUnexpiredCacheEntry(paramString);
  }
  
  public void removeCacheEntries()
  {
    Iterator localIterator = this._basicCache.getAllCacheEntries().iterator();
    while (localIterator.hasNext()) {
      removeCacheEntry((CacheEntry)localIterator.next());
    }
  }
  
  public void removeCacheEntry(String paramString)
  {
    paramString = this._basicCache.getCacheEntry(paramString);
    if (paramString != null) {
      removeCacheEntry(paramString);
    }
  }
  
  public void trimLruEntries(int paramInt)
  {
    Iterator localIterator = this._basicCache.getLruEntries(paramInt).iterator();
    while (localIterator.hasNext()) {
      removeCacheEntry((CacheEntry)localIterator.next());
    }
  }
  
  public boolean updateCache(String paramString1, String paramString2, Long paramLong, String paramString3, URI paramURI)
  {
    try
    {
      boolean bool = updateCache(paramString1, paramString2.getBytes("UTF-8"), paramLong, paramString3, paramURI);
      return bool;
    }
    catch (UnsupportedEncodingException paramLong)
    {
      throw new CachingException(String.format(Locale.US, "Fetch of UTF-8 bytes failed [%1$s=%2$s]", new Object[] { paramString1, paramString2 }), paramLong);
    }
  }
  
  /* Error */
  public boolean updateCache(String paramString1, String paramString2, byte[] paramArrayOfByte, Long paramLong, String paramString3, URI paramURI)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 28	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   4: ifeq +13 -> 17
    //   7: new 17	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc -42
    //   13: invokespecial 22	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_2
    //   18: invokestatic 28	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   21: ifeq +13 -> 34
    //   24: new 17	java/lang/IllegalArgumentException
    //   27: dup
    //   28: ldc -40
    //   30: invokespecial 22	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   33: athrow
    //   34: aload 4
    //   36: ifnonnull +13 -> 49
    //   39: new 17	java/lang/IllegalArgumentException
    //   42: dup
    //   43: ldc -38
    //   45: invokespecial 22	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: aconst_null
    //   50: astore 7
    //   52: aconst_null
    //   53: astore 8
    //   55: new 41	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: getfield 77	com/getjar/sdk/data/cache/FileStorage:_directory	Ljava/io/File;
    //   63: aload_2
    //   64: invokespecial 221	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore 9
    //   69: aload 7
    //   71: astore_2
    //   72: new 223	java/io/FileOutputStream
    //   75: dup
    //   76: aload 9
    //   78: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore 7
    //   83: aload_3
    //   84: ifnull +14 -> 98
    //   87: aload_3
    //   88: arraylength
    //   89: ifle +9 -> 98
    //   92: aload 7
    //   94: aload_3
    //   95: invokevirtual 230	java/io/FileOutputStream:write	([B)V
    //   98: aload 7
    //   100: ifnull +144 -> 244
    //   103: aload 7
    //   105: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   108: aload_0
    //   109: getfield 39	com/getjar/sdk/data/cache/FileStorage:_basicCache	Lcom/getjar/sdk/data/cache/BasicCache;
    //   112: aload_1
    //   113: aload 9
    //   115: invokestatic 122	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   118: invokevirtual 123	android/net/Uri:toString	()Ljava/lang/String;
    //   121: aload 4
    //   123: aload 5
    //   125: aload 6
    //   127: invokevirtual 235	com/getjar/sdk/data/cache/BasicCache:updateCache	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/net/URI;)Z
    //   130: ifne +98 -> 228
    //   133: aload 9
    //   135: invokevirtual 149	java/io/File:delete	()Z
    //   138: pop
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_2
    //   142: getstatic 110	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   145: invokevirtual 114	com/getjar/sdk/logging/Area:value	()J
    //   148: aload_2
    //   149: ldc -19
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 241	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: goto -50 -> 108
    //   161: astore_1
    //   162: aload 8
    //   164: astore_2
    //   165: new 86	com/getjar/sdk/exceptions/CachingException
    //   168: dup
    //   169: getstatic 92	java/util/Locale:US	Ljava/util/Locale;
    //   172: ldc -13
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload 9
    //   182: invokestatic 122	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   185: invokevirtual 123	android/net/Uri:toString	()Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 103	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   192: aload_1
    //   193: invokespecial 209	com/getjar/sdk/exceptions/CachingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: athrow
    //   197: astore_1
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 233	java/io/FileOutputStream:close	()V
    //   206: aload_1
    //   207: athrow
    //   208: astore_2
    //   209: getstatic 110	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   212: invokevirtual 114	com/getjar/sdk/logging/Area:value	()J
    //   215: aload_2
    //   216: ldc -19
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 241	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -19 -> 206
    //   228: iconst_1
    //   229: ireturn
    //   230: astore_1
    //   231: aload 7
    //   233: astore_2
    //   234: goto -36 -> 198
    //   237: astore_1
    //   238: aload 7
    //   240: astore_2
    //   241: goto -76 -> 165
    //   244: goto -136 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	FileStorage
    //   0	247	1	paramString1	String
    //   0	247	2	paramString2	String
    //   0	247	3	paramArrayOfByte	byte[]
    //   0	247	4	paramLong	Long
    //   0	247	5	paramString3	String
    //   0	247	6	paramURI	URI
    //   50	189	7	localFileOutputStream	java.io.FileOutputStream
    //   53	110	8	localObject	Object
    //   67	114	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	108	141	java/lang/Exception
    //   72	83	161	java/lang/Exception
    //   72	83	197	finally
    //   165	197	197	finally
    //   202	206	208	java/lang/Exception
    //   87	98	230	finally
    //   87	98	237	java/lang/Exception
  }
  
  public boolean updateCache(String paramString1, byte[] paramArrayOfByte, Long paramLong, String paramString2, URI paramURI)
  {
    return updateCache(paramString1, paramString1, paramArrayOfByte, paramLong, paramString2, paramURI);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/FileStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
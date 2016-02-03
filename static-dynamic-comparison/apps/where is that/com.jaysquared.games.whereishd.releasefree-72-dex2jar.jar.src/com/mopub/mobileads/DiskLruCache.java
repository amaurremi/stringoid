package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import android.support.v4.util.LruCache;
import android.util.Log;
import com.mopub.common.util.Files;
import com.mopub.common.util.Utils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DiskLruCache
  extends LruCache<String, File>
{
  private final File mCacheDirectory;
  private final String mCacheDirectoryName;
  private final Context mContext;
  
  public DiskLruCache(Context paramContext, String paramString, int paramInt)
    throws IllegalArgumentException, IOException
  {
    super(paramInt);
    if (paramContext == null) {
      throw new IllegalArgumentException("context may not be null.");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("cacheDirectoryName may not be null.");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxSizeBytes must be positive.");
    }
    this.mContext = paramContext;
    this.mCacheDirectoryName = paramString;
    this.mCacheDirectory = Files.createDirectory(paramContext.getFilesDir() + File.separator + this.mCacheDirectoryName);
    if (this.mCacheDirectory == null) {
      throw new IOException("Unable to obtain access to directory " + this.mCacheDirectoryName);
    }
    loadFilesFromDisk();
  }
  
  /* Error */
  private File createFile(String paramString, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 50	java/io/File
    //   3: dup
    //   4: new 35	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: getfield 31	com/mopub/mobileads/DiskLruCache:mContext	Landroid/content/Context;
    //   15: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: getstatic 53	java/io/File:separator	Ljava/lang/String;
    //   24: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 33	com/mopub/mobileads/DiskLruCache:mCacheDirectoryName	Ljava/lang/String;
    //   31: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: getstatic 53	java/io/File:separator	Ljava/lang/String;
    //   37: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: new 83	java/io/FileOutputStream
    //   54: dup
    //   55: aload_3
    //   56: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: astore_1
    //   60: aload_2
    //   61: aload_1
    //   62: invokestatic 92	com/mopub/common/util/Streams:copyContent	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   65: aload_1
    //   66: invokestatic 96	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   69: aload_3
    //   70: areturn
    //   71: astore_1
    //   72: aconst_null
    //   73: areturn
    //   74: astore_2
    //   75: aload_3
    //   76: invokevirtual 100	java/io/File:delete	()Z
    //   79: pop
    //   80: aload_1
    //   81: invokestatic 96	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_2
    //   87: aload_1
    //   88: invokestatic 96	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   91: aload_2
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	DiskLruCache
    //   0	93	1	paramString	String
    //   0	93	2	paramInputStream	InputStream
    //   50	26	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   51	60	71	java/io/FileNotFoundException
    //   60	65	74	java/io/IOException
    //   60	65	86	finally
    //   75	80	86	finally
  }
  
  private void loadFilesFromDisk()
  {
    File[] arrayOfFile = this.mCacheDirectory.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        put(localFile.getName(), localFile);
        i += 1;
      }
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, String paramString, File paramFile1, File paramFile2)
  {
    super.entryRemoved(paramBoolean, paramString, paramFile1, paramFile2);
    if ((paramFile1 != null) && (!paramFile1.delete())) {
      Log.d("MoPub", "Unable to delete file from cache: " + paramFile1.getName());
    }
  }
  
  File getCacheDirectory()
  {
    return this.mCacheDirectory;
  }
  
  Uri getUri(String paramString)
  {
    paramString = (File)get(Utils.sha1(paramString));
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString.getAbsolutePath());
  }
  
  boolean putStream(String paramString, InputStream paramInputStream)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramInputStream != null) {
        break label23;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label23:
      bool1 = bool2;
      try
      {
        if (getUri(paramString) != null) {
          continue;
        }
        paramString = Utils.sha1(paramString);
        paramInputStream = createFile(paramString, paramInputStream);
        bool1 = bool2;
        if (paramInputStream == null) {
          continue;
        }
        bool1 = bool2;
        if (!paramInputStream.exists()) {
          continue;
        }
        put(paramString, paramInputStream);
        bool1 = true;
      }
      finally {}
    }
  }
  
  File removeStream(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (File)remove(Utils.sha1(paramString));
      }
      finally {}
    }
  }
  
  protected int sizeOf(String paramString, File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() > 0L)) {
      return Files.intLength(paramFile);
    }
    return super.sizeOf(paramString, paramFile);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
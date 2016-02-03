package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONObject;

public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private AtomicLong lastClearCacheTime = new AtomicLong(0L);
    private final FileLruCache.Limits limits;
    private final Object lock;
    private final String tag;

    public FileLruCache(Context paramContext, String paramString, FileLruCache.Limits paramLimits) {
        this.tag = paramString;
        this.limits = paramLimits;
        this.directory = new File(paramContext.getCacheDir(), paramString);
        this.lock = new Object();
        if ((this.directory.mkdirs()) || (this.directory.isDirectory())) {
            FileLruCache.BufferFile.deleteAll(this.directory);
        }
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                Settings.getExecutor().execute(new FileLruCache .3 (this));
            }
            return;
        }
    }

    private void renameToTargetAndTrim(String paramString, File paramFile) {
        if (!paramFile.renameTo(new File(this.directory, Utility.md5hash(paramString)))) {
            paramFile.delete();
        }
        postTrim();
    }

    private void trim() {
        synchronized (this.lock) {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
        }
        for (; ; ) {
            try {
                Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
                ???=new PriorityQueue();
                l1 = 0L;
                long l3 = 0L;
                File[] arrayOfFile = this.directory.listFiles(FileLruCache.BufferFile.excludeBufferFiles());
                l2 = l3;
                l4 = l1;
                if (arrayOfFile == null) {
                    continue;
                }
                int j = arrayOfFile.length;
                int i = 0;
                l2 = l3;
                l4 = l1;
                if (i >= j) {
                    continue;
                }
                File localFile2 = arrayOfFile[i];
                FileLruCache.ModifiedFile localModifiedFile = new FileLruCache.ModifiedFile(localFile2);
                ((PriorityQueue) ? ??).add(localModifiedFile);
                Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(localModifiedFile.getModified()) + " name=" + localModifiedFile.getFile().getName());
                l2 = localFile2.length();
                i += 1;
                l3 = 1L + l3;
                l1 = l2 + l1;
                continue;
                localObject2 =finally;
                throw ((Throwable) localObject2);
            } finally {
                long l1;
                long l2;
                synchronized (this.lock) {
                    long l4;
                    File localFile1;
                    this.isTrimInProgress = false;
                    this.lock.notifyAll();
                    throw ((Throwable) localObject4);
                }
            }
            if ((l4 <= this.limits.getByteCount()) && (l1 <= this.limits.getFileCount())) {
                continue;
            }
            localFile1 = ((FileLruCache.ModifiedFile) ((PriorityQueue) ? ? ?).remove()).getFile();
            Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + localFile1.getName());
            l4 -= localFile1.length();
            localFile1.delete();
            l1 -= 1L;
        }
        synchronized (this.lock) {
            this.isTrimInProgress = false;
            this.lock.notifyAll();
            return;
        }
    }

    public void clearCache() {
        File[] arrayOfFile = this.directory.listFiles(FileLruCache.BufferFile.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (arrayOfFile != null) {
            Settings.getExecutor().execute(new FileLruCache .2 (this, arrayOfFile));
        }
    }

    public InputStream get(String paramString) {
        return get(paramString, null);
    }

    public InputStream get(String paramString1, String paramString2) {
        File localFile = new File(this.directory, Utility.md5hash(paramString1));
        try {
            Object localObject = new FileInputStream(localFile);
            localObject = new BufferedInputStream((InputStream) localObject, 8192);
            try {
                JSONObject localJSONObject = FileLruCache.StreamHeader.readHeader((InputStream) localObject);
                if (localJSONObject == null) {
                    return null;
                }
                String str = localJSONObject.optString("key");
                boolean bool;
                if (str != null) {
                    bool = str.equals(paramString1);
                    if (bool) {
                    }
                } else {
                    return null;
                }
                paramString1 = localJSONObject.optString("tag", null);
                if ((paramString2 != null) || (paramString1 == null)) {
                    if (paramString2 != null) {
                        bool = paramString2.equals(paramString1);
                        if (bool) {
                        }
                    }
                } else {
                    return null;
                }
                long l = new Date().getTime();
                Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(l) + " for " + localFile.getName());
                localFile.setLastModified(l);
                return (InputStream) localObject;
            } finally {
                ((BufferedInputStream) localObject).close();
            }
            return null;
        } catch (IOException paramString1) {
        }
    }

    public InputStream interceptAndPut(String paramString, InputStream paramInputStream) {
        return new FileLruCache.CopyingInputStream(paramInputStream, openPutStream(paramString));
    }

    OutputStream openPutStream(String paramString) {
        return openPutStream(paramString, null);
    }

    /* Error */
    public OutputStream openPutStream(String paramString1, String paramString2) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 66	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
        //   4: invokestatic 306	com/facebook/internal/FileLruCache$BufferFile:newFile	(Ljava/io/File;)Ljava/io/File;
        //   7: astore_3
        //   8: aload_3
        //   9: invokevirtual 128	java/io/File:delete	()Z
        //   12: pop
        //   13: aload_3
        //   14: invokevirtual 309	java/io/File:createNewFile	()Z
        //   17: ifne +34 -> 51
        //   20: new 240	java/io/IOException
        //   23: dup
        //   24: new 167	java/lang/StringBuilder
        //   27: dup
        //   28: invokespecial 168	java/lang/StringBuilder:<init>	()V
        //   31: ldc_w 311
        //   34: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   37: aload_3
        //   38: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   41: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   44: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   47: invokespecial 317	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   50: athrow
        //   51: new 319	java/io/FileOutputStream
        //   54: dup
        //   55: aload_3
        //   56: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   59: astore 4
        //   61: new 322	java/io/BufferedOutputStream
        //   64: dup
        //   65: new 324	com/facebook/internal/FileLruCache$CloseCallbackOutputStream
        //   68: dup
        //   69: aload 4
        //   71: new 326	com/facebook/internal/FileLruCache$1
        //   74: dup
        //   75: aload_0
        //   76: invokestatic 225	java/lang/System:currentTimeMillis	()J
        //   79: aload_3
        //   80: aload_1
        //   81: invokespecial 329	com/facebook/internal/FileLruCache$1:<init>	(Lcom/facebook/internal/FileLruCache;JLjava/io/File;Ljava/lang/String;)V
        //   84: invokespecial 332	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V
        //   87: sipush 8192
        //   90: invokespecial 335	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
        //   93: astore_3
        //   94: new 259	org/json/JSONObject
        //   97: dup
        //   98: invokespecial 336	org/json/JSONObject:<init>	()V
        //   101: astore 4
        //   103: aload 4
        //   105: ldc 8
        //   107: aload_1
        //   108: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   111: pop
        //   112: aload_2
        //   113: invokestatic 344	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   116: ifne +12 -> 128
        //   119: aload 4
        //   121: ldc 11
        //   123: aload_2
        //   124: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   127: pop
        //   128: aload_3
        //   129: aload 4
        //   131: invokestatic 348	com/facebook/internal/FileLruCache$StreamHeader:writeHeader	(Ljava/io/OutputStream;Lorg/json/JSONObject;)V
        //   134: aload_3
        //   135: areturn
        //   136: astore_1
        //   137: getstatic 138	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
        //   140: iconst_5
        //   141: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
        //   144: new 167	java/lang/StringBuilder
        //   147: dup
        //   148: invokespecial 168	java/lang/StringBuilder:<init>	()V
        //   151: ldc_w 350
        //   154: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   157: aload_1
        //   158: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   161: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   164: invokestatic 353	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
        //   167: new 240	java/io/IOException
        //   170: dup
        //   171: aload_1
        //   172: invokevirtual 356	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
        //   175: invokespecial 317	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   178: athrow
        //   179: astore_1
        //   180: getstatic 138	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
        //   183: iconst_5
        //   184: getstatic 34	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
        //   187: new 167	java/lang/StringBuilder
        //   190: dup
        //   191: invokespecial 168	java/lang/StringBuilder:<init>	()V
        //   194: ldc_w 358
        //   197: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: aload_1
        //   201: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   204: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   207: invokestatic 353	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
        //   210: new 240	java/io/IOException
        //   213: dup
        //   214: aload_1
        //   215: invokevirtual 359	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   218: invokespecial 317	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   221: athrow
        //   222: astore_1
        //   223: aload_3
        //   224: invokevirtual 360	java/io/BufferedOutputStream:close	()V
        //   227: aload_1
        //   228: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	229	0	this	FileLruCache
        //   0	229	1	paramString1	String
        //   0	229	2	paramString2	String
        //   7	217	3	localObject1	Object
        //   59	71	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   51	61	136	java/io/FileNotFoundException
        //   94	128	179	org/json/JSONException
        //   128	134	179	org/json/JSONException
        //   94	128	222	finally
        //   128	134	222	finally
        //   180	222	222	finally
    }

    long sizeInBytesForTest() {
        long l2;
        synchronized (this.lock) {
            for (; ; ) {
                if (!this.isTrimPending) {
                    boolean bool = this.isTrimInProgress;
                    if (!bool) {
                        break;
                    }
                }
                try {
                    this.lock.wait();
                } catch (InterruptedException localInterruptedException) {
                }
            }
            ???=this.directory.listFiles();
            long l1 = 0L;
            l2 = l1;
            if (???!=null)
            {
                int j =???.length;
                int i = 0;
                l2 = l1;
                if (i < j) {
                    l2 =???[i].length();
                    i += 1;
                    l1 = l2 + l1;
                }
            }
        }
        return l2;
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
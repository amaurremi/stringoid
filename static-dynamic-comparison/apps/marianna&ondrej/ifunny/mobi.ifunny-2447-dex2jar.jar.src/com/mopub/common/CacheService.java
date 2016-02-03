package com.mopub.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.d.f;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import com.mopub.common.util.Utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CacheService {
    private static DiskLruCache a;
    private static a b;

    @Deprecated
    @VisibleForTesting
    public static void clearAndNullCaches() {
        if (a != null) {
        }
        try {
            a.delete();
            a = null;
            if (b != null) {
                b.evictAll();
                b = null;
            }
            return;
        } catch (IOException localIOException) {
            for (; ; ) {
                a = null;
            }
        }
    }

    public static boolean containsKeyDiskCache(String paramString) {
        if (a == null) {
        }
        for (; ; ) {
            return false;
            try {
                paramString = a.get(createValidDiskCacheKey(paramString));
                if (paramString != null) {
                    return true;
                }
            } catch (Exception paramString) {
            }
        }
        return false;
    }

    public static String createValidDiskCacheKey(String paramString) {
        return Utils.sha1(paramString);
    }

    @Deprecated
    @VisibleForTesting
    public static f<String, Bitmap> getBitmapLruCache() {
        return b;
    }

    public static File getDiskCacheDirectory(Context paramContext) {
        paramContext = paramContext.getCacheDir().getPath();
        return new File(paramContext + File.separator + "mopub-cache");
    }

    @Deprecated
    @VisibleForTesting
    public static DiskLruCache getDiskLruCache() {
        return a;
    }

    public static String getFilePathDiskCache(String paramString) {
        if (a == null) {
            return null;
        }
        return a.getDirectory() + File.separator + createValidDiskCacheKey(paramString) + "." + 0;
    }

    public static Bitmap getFromBitmapCache(String paramString) {
        if (b == null) {
            return null;
        }
        return (Bitmap) b.get(paramString);
    }

    /* Error */
    public static byte[] getFromDiskCache(String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: aconst_null
        //   3: astore_3
        //   4: aconst_null
        //   5: astore_1
        //   6: getstatic 20	com/mopub/common/CacheService:a	Lcom/mopub/common/DiskLruCache;
        //   9: ifnonnull +5 -> 14
        //   12: aload_1
        //   13: areturn
        //   14: getstatic 20	com/mopub/common/CacheService:a	Lcom/mopub/common/DiskLruCache;
        //   17: aload_0
        //   18: invokestatic 42	com/mopub/common/CacheService:createValidDiskCacheKey	(Ljava/lang/String;)Ljava/lang/String;
        //   21: invokevirtual 46	com/mopub/common/DiskLruCache:get	(Ljava/lang/String;)Lcom/mopub/common/DiskLruCache$Snapshot;
        //   24: astore_0
        //   25: aload_0
        //   26: ifnonnull +13 -> 39
        //   29: aload_0
        //   30: ifnull -18 -> 12
        //   33: aload_0
        //   34: invokevirtual 116	com/mopub/common/DiskLruCache$Snapshot:close	()V
        //   37: aconst_null
        //   38: areturn
        //   39: aload_0
        //   40: astore_1
        //   41: aload_0
        //   42: iconst_0
        //   43: invokevirtual 120	com/mopub/common/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
        //   46: astore 4
        //   48: aload 4
        //   50: ifnull +37 -> 87
        //   53: aload_0
        //   54: astore_1
        //   55: aload_0
        //   56: iconst_0
        //   57: invokevirtual 124	com/mopub/common/DiskLruCache$Snapshot:getLength	(I)J
        //   60: l2i
        //   61: newarray <illegal type>
        //   63: astore_2
        //   64: aload_0
        //   65: astore_1
        //   66: new 126	java/io/BufferedInputStream
        //   69: dup
        //   70: aload 4
        //   72: invokespecial 129	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   75: astore_3
        //   76: aload_3
        //   77: aload_2
        //   78: invokestatic 135	com/mopub/common/util/Streams:readStream	(Ljava/io/InputStream;[B)V
        //   81: aload_0
        //   82: astore_1
        //   83: aload_3
        //   84: invokestatic 139	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   87: aload_2
        //   88: astore_1
        //   89: aload_0
        //   90: ifnull -78 -> 12
        //   93: aload_0
        //   94: invokevirtual 116	com/mopub/common/DiskLruCache$Snapshot:close	()V
        //   97: aload_2
        //   98: areturn
        //   99: astore 4
        //   101: aload_0
        //   102: astore_1
        //   103: aload_3
        //   104: invokestatic 139	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   107: aload_0
        //   108: astore_1
        //   109: aload 4
        //   111: athrow
        //   112: astore_3
        //   113: aload_0
        //   114: astore_1
        //   115: ldc -115
        //   117: aload_3
        //   118: invokestatic 147	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   121: aload_2
        //   122: astore_1
        //   123: aload_0
        //   124: ifnull -112 -> 12
        //   127: aload_0
        //   128: invokevirtual 116	com/mopub/common/DiskLruCache$Snapshot:close	()V
        //   131: aload_2
        //   132: areturn
        //   133: astore_0
        //   134: aconst_null
        //   135: astore_1
        //   136: aload_1
        //   137: ifnull +7 -> 144
        //   140: aload_1
        //   141: invokevirtual 116	com/mopub/common/DiskLruCache$Snapshot:close	()V
        //   144: aload_0
        //   145: athrow
        //   146: astore_0
        //   147: goto -11 -> 136
        //   150: astore_1
        //   151: aconst_null
        //   152: astore_0
        //   153: aload_3
        //   154: astore_2
        //   155: aload_1
        //   156: astore_3
        //   157: goto -44 -> 113
        //   160: astore_1
        //   161: aload_3
        //   162: astore_2
        //   163: aload_1
        //   164: astore_3
        //   165: goto -52 -> 113
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	168	0	paramString	String
        //   5	136	1	localObject1	Object
        //   150	6	1	localException1	Exception
        //   160	4	1	localException2	Exception
        //   1	162	2	localObject2	Object
        //   3	101	3	localBufferedInputStream	java.io.BufferedInputStream
        //   112	42	3	localException3	Exception
        //   156	9	3	localObject3	Object
        //   46	25	4	localInputStream	InputStream
        //   99	11	4	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   76	81	99	finally
        //   66	76	112	java/lang/Exception
        //   83	87	112	java/lang/Exception
        //   103	107	112	java/lang/Exception
        //   109	112	112	java/lang/Exception
        //   14	25	133	finally
        //   41	48	146	finally
        //   55	64	146	finally
        //   66	76	146	finally
        //   83	87	146	finally
        //   103	107	146	finally
        //   109	112	146	finally
        //   115	121	146	finally
        //   14	25	150	java/lang/Exception
        //   41	48	160	java/lang/Exception
        //   55	64	160	java/lang/Exception
    }

    public static void getFromDiskCacheAsync(String paramString, CacheService.DiskLruCacheGetListener paramDiskLruCacheGetListener) {
        new b(paramString, paramDiskLruCacheGetListener).execute(new Void[0]);
    }

    public static void initialize(Context paramContext) {
        initializeBitmapCache(paramContext);
        initializeDiskCache(paramContext);
    }

    public static boolean initializeBitmapCache(Context paramContext) {
        if (paramContext == null) {
            return false;
        }
        if (b == null) {
            b = new a(DeviceUtils.memoryCacheSizeBytes(paramContext));
        }
        return true;
    }

    public static boolean initializeDiskCache(Context paramContext) {
        boolean bool = true;
        if (paramContext == null) {
            bool = false;
        }
        while (a != null) {
            return bool;
        }
        paramContext = getDiskCacheDirectory(paramContext);
        long l = DeviceUtils.diskCacheSizeBytes(paramContext);
        try {
            a = DiskLruCache.open(paramContext, 1, 1, l);
            return true;
        } catch (IOException paramContext) {
            MoPubLog.d("Unable to create DiskLruCache", paramContext);
        }
        return true;
    }

    public static void putToBitmapCache(String paramString, Bitmap paramBitmap) {
        if (b == null) {
            return;
        }
        b.put(paramString, paramBitmap);
    }

    public static boolean putToDiskCache(String paramString, InputStream paramInputStream) {
        if (a == null) {
        }
        String str;
        do {
            for (; ; ) {
                return false;
                str = null;
                try {
                    paramString = a.edit(createValidDiskCacheKey(paramString));
                    if (paramString != null) {
                        str = paramString;
                        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramString.newOutputStream(0));
                        str = paramString;
                        Streams.copyContent(paramInputStream, localBufferedOutputStream);
                        str = paramString;
                        localBufferedOutputStream.flush();
                        str = paramString;
                        localBufferedOutputStream.close();
                        str = paramString;
                        a.flush();
                        str = paramString;
                        paramString.commit();
                        return true;
                    }
                } catch (Exception paramString) {
                    MoPubLog.d("Unable to put to DiskLruCache", paramString);
                }
            }
        } while (str == null);
        try {
            str.abort();
            return false;
        } catch (IOException paramString) {
        }
        return false;
    }

    public static boolean putToDiskCache(String paramString, byte[] paramArrayOfByte) {
        return putToDiskCache(paramString, new ByteArrayInputStream(paramArrayOfByte));
    }

    public static void putToDiskCacheAsync(String paramString, byte[] paramArrayOfByte) {
        new c(paramString, paramArrayOfByte).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/CacheService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
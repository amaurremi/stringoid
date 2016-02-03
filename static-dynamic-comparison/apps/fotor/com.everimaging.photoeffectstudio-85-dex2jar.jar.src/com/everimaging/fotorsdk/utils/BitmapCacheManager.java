package com.everimaging.fotorsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class BitmapCacheManager {
    private static final int CACHE_SIZE_FRACTION = 2;
    private static final String TAG = BitmapCacheManager.class.getSimpleName();
    private static FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private static BitmapCacheManager mCacheManager;
    private LruCache<String, Bitmap> mLruCache;

    private BitmapCacheManager(Context paramContext) {
        int i = ((ActivityManager) paramContext.getSystemService("activity")).getMemoryClass();
        logger.f(new Object[]{"memory class is:" + i + "MB"});
        this.mLruCache = new LruCache(i * 1048576 / 2) {
            protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap) {
                if (paramAnonymousBitmap != null) {
                    return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
                }
                return super.sizeOf(paramAnonymousString, paramAnonymousBitmap);
            }
        };
    }

    public static BitmapCacheManager getInstance(Context paramContext) {
        if (mCacheManager == null) {
            mCacheManager = new BitmapCacheManager(paramContext);
        }
        return mCacheManager;
    }

    public void addBitmap(String paramString, Bitmap paramBitmap) {
        try {
            this.mLruCache.put(paramString, paramBitmap);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    /* Error */
    public Bitmap loadBitmap(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   6: istore_2
        //   7: iload_2
        //   8: ifeq +9 -> 17
        //   11: aconst_null
        //   12: astore_3
        //   13: aload_0
        //   14: monitorexit
        //   15: aload_3
        //   16: areturn
        //   17: getstatic 42	com/everimaging/fotorsdk/utils/BitmapCacheManager:logger	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   20: iconst_1
        //   21: anewarray 4	java/lang/Object
        //   24: dup
        //   25: iconst_0
        //   26: new 63	java/lang/StringBuilder
        //   29: dup
        //   30: invokespecial 64	java/lang/StringBuilder:<init>	()V
        //   33: ldc 114
        //   35: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   38: aload_1
        //   39: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   45: aastore
        //   46: invokeinterface 117 2 0
        //   51: aload_0
        //   52: getfield 90	com/everimaging/fotorsdk/utils/BitmapCacheManager:mLruCache	Landroid/support/v4/util/LruCache;
        //   55: aload_1
        //   56: invokevirtual 121	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   59: checkcast 123	android/graphics/Bitmap
        //   62: astore 4
        //   64: aload 4
        //   66: ifnull +14 -> 80
        //   69: aload 4
        //   71: astore_3
        //   72: aload 4
        //   74: invokevirtual 127	android/graphics/Bitmap:isRecycled	()Z
        //   77: ifeq -64 -> 13
        //   80: getstatic 42	com/everimaging/fotorsdk/utils/BitmapCacheManager:logger	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   83: iconst_1
        //   84: anewarray 4	java/lang/Object
        //   87: dup
        //   88: iconst_0
        //   89: new 63	java/lang/StringBuilder
        //   92: dup
        //   93: invokespecial 64	java/lang/StringBuilder:<init>	()V
        //   96: ldc -127
        //   98: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: aload_1
        //   102: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   108: aastore
        //   109: invokeinterface 117 2 0
        //   114: aload_1
        //   115: invokestatic 134	com/everimaging/fotorsdk/utils/BitmapDecodeUtils:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
        //   118: astore 4
        //   120: aload 4
        //   122: astore_3
        //   123: aload 4
        //   125: ifnull -112 -> 13
        //   128: aload_0
        //   129: aload_1
        //   130: aload 4
        //   132: invokevirtual 136	com/everimaging/fotorsdk/utils/BitmapCacheManager:addBitmap	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
        //   135: aload 4
        //   137: astore_3
        //   138: goto -125 -> 13
        //   141: astore_1
        //   142: aload_0
        //   143: monitorexit
        //   144: aload_1
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	BitmapCacheManager
        //   0	146	1	paramString	String
        //   6	2	2	bool	boolean
        //   12	126	3	localObject	Object
        //   62	74	4	localBitmap	Bitmap
        // Exception table:
        //   from	to	target	type
        //   2	7	141	finally
        //   17	64	141	finally
        //   72	80	141	finally
        //   80	120	141	finally
        //   128	135	141	finally
    }

    public void removeBitmap(String paramString) {
        try {
            this.mLruCache.remove(paramString);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/BitmapCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
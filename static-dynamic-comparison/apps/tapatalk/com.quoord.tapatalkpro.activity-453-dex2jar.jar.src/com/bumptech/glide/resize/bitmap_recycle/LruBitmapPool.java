package com.bumptech.glide.resize.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;

public class LruBitmapPool
        implements BitmapPool {
    private static final String TAG = "LruBitmapPool";
    private int currentSize = 0;
    private int evictions;
    private int hits;
    private final int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;

    public LruBitmapPool(int paramInt) {
        this.maxSize = paramInt;
        this.strategy = new AttributeStrategy();
    }

    LruBitmapPool(int paramInt, LruPoolStrategy paramLruPoolStrategy) {
        this.maxSize = paramInt;
        this.strategy = paramLruPoolStrategy;
    }

    private void dump() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Hits=" + this.hits + " misses=" + this.misses + " puts=" + this.puts + " evictions=" + this.evictions + " currentSize=" + this.currentSize + " maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private void trimToSize(int paramInt) {
        for (; ; ) {
            if (this.currentSize <= paramInt) {
                return;
            }
            Bitmap localBitmap = this.strategy.removeLast();
            this.currentSize -= this.strategy.getSize(localBitmap);
            localBitmap.recycle();
            this.evictions += 1;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.strategy.logBitmap(localBitmap));
            }
            dump();
        }
    }

    public void clearMemory() {
        trimToSize(0);
    }

    /* Error */
    public Bitmap get(int paramInt1, int paramInt2, android.graphics.Bitmap.Config paramConfig) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   6: iload_1
        //   7: iload_2
        //   8: aload_3
        //   9: invokeinterface 122 4 0
        //   14: astore 4
        //   16: aload 4
        //   18: ifnonnull +106 -> 124
        //   21: ldc 10
        //   23: iconst_3
        //   24: invokestatic 42	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   27: ifeq +36 -> 63
        //   30: ldc 10
        //   32: new 44	java/lang/StringBuilder
        //   35: dup
        //   36: ldc 124
        //   38: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   45: iload_1
        //   46: iload_2
        //   47: aload_3
        //   48: invokeinterface 127 4 0
        //   53: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   56: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   59: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   62: pop
        //   63: aload_0
        //   64: aload_0
        //   65: getfield 62	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:misses	I
        //   68: iconst_1
        //   69: iadd
        //   70: putfield 62	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:misses	I
        //   73: ldc 10
        //   75: iconst_3
        //   76: invokestatic 42	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   79: ifeq +36 -> 115
        //   82: ldc 10
        //   84: new 44	java/lang/StringBuilder
        //   87: dup
        //   88: ldc -127
        //   90: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   93: aload_0
        //   94: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   97: iload_1
        //   98: iload_2
        //   99: aload_3
        //   100: invokeinterface 127 4 0
        //   105: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   108: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   111: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   114: pop
        //   115: aload_0
        //   116: invokespecial 117	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:dump	()V
        //   119: aload_0
        //   120: monitorexit
        //   121: aload 4
        //   123: areturn
        //   124: aload_0
        //   125: aload_0
        //   126: getfield 51	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:hits	I
        //   129: iconst_1
        //   130: iadd
        //   131: putfield 51	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:hits	I
        //   134: aload_0
        //   135: aload_0
        //   136: getfield 26	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:currentSize	I
        //   139: aload_0
        //   140: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   143: aload 4
        //   145: invokeinterface 101 2 0
        //   150: isub
        //   151: putfield 26	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:currentSize	I
        //   154: goto -81 -> 73
        //   157: astore_3
        //   158: aload_0
        //   159: monitorexit
        //   160: aload_3
        //   161: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	162	0	this	LruBitmapPool
        //   0	162	1	paramInt1	int
        //   0	162	2	paramInt2	int
        //   0	162	3	paramConfig	android.graphics.Bitmap.Config
        //   14	130	4	localBitmap	Bitmap
        // Exception table:
        //   from	to	target	type
        //   2	16	157	finally
        //   21	63	157	finally
        //   63	73	157	finally
        //   73	115	157	finally
        //   115	119	157	finally
        //   124	154	157	finally
    }

    /* Error */
    public boolean put(Bitmap paramBitmap) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: invokevirtual 135	android/graphics/Bitmap:isMutable	()Z
        //   6: ifeq +24 -> 30
        //   9: aload_0
        //   10: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   13: aload_1
        //   14: invokeinterface 101 2 0
        //   19: istore_2
        //   20: aload_0
        //   21: getfield 28	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:maxSize	I
        //   24: istore_3
        //   25: iload_2
        //   26: iload_3
        //   27: if_icmple +11 -> 38
        //   30: iconst_0
        //   31: istore 4
        //   33: aload_0
        //   34: monitorexit
        //   35: iload 4
        //   37: ireturn
        //   38: aload_0
        //   39: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   42: aload_1
        //   43: invokeinterface 101 2 0
        //   48: istore_2
        //   49: aload_0
        //   50: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   53: aload_1
        //   54: invokeinterface 138 2 0
        //   59: aload_0
        //   60: aload_0
        //   61: getfield 66	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:puts	I
        //   64: iconst_1
        //   65: iadd
        //   66: putfield 66	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:puts	I
        //   69: aload_0
        //   70: aload_0
        //   71: getfield 26	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:currentSize	I
        //   74: iload_2
        //   75: iadd
        //   76: putfield 26	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:currentSize	I
        //   79: ldc 10
        //   81: iconst_3
        //   82: invokestatic 42	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   85: ifeq +34 -> 119
        //   88: ldc 10
        //   90: new 44	java/lang/StringBuilder
        //   93: dup
        //   94: ldc -116
        //   96: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   99: aload_0
        //   100: getfield 33	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:strategy	Lcom/bumptech/glide/resize/bitmap_recycle/LruPoolStrategy;
        //   103: aload_1
        //   104: invokeinterface 112 2 0
        //   109: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   115: invokestatic 115	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   118: pop
        //   119: aload_0
        //   120: invokespecial 117	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:dump	()V
        //   123: aload_0
        //   124: invokespecial 142	com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool:evict	()V
        //   127: iconst_1
        //   128: istore 4
        //   130: goto -97 -> 33
        //   133: astore_1
        //   134: aload_0
        //   135: monitorexit
        //   136: aload_1
        //   137: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	this	LruBitmapPool
        //   0	138	1	paramBitmap	Bitmap
        //   19	57	2	i	int
        //   24	4	3	j	int
        //   31	98	4	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	25	133	finally
        //   38	119	133	finally
        //   119	127	133	finally
    }

    public void trimMemory(int paramInt) {
        if (paramInt >= 60) {
            clearMemory();
        }
        while (paramInt < 40) {
            return;
        }
        trimToSize(this.maxSize / 2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/bitmap_recycle/LruBitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
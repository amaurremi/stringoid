package com.bumptech.glide.resize.load;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.resize.RecyclableBufferedInputStream;
import com.bumptech.glide.resize.bitmap_recycle.BitmapPool;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

public abstract class Downsampler {
    public static Downsampler AT_LEAST = new Downsampler() {
        protected int getSampleSize(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {
            return Math.min(paramAnonymousInt2 / paramAnonymousInt4, paramAnonymousInt1 / paramAnonymousInt3);
        }
    };
    public static Downsampler AT_MOST = new Downsampler() {
        protected int getSampleSize(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {
            return Math.max(paramAnonymousInt2 / paramAnonymousInt4, paramAnonymousInt1 / paramAnonymousInt3);
        }
    };
    private static final int MARK_POSITION = 5242880;
    public static Downsampler NONE = new Downsampler() {
        protected int getSampleSize(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {
            return 0;
        }
    };
    private static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    private final String id = getClass().toString();

    private Bitmap decodeStream(RecyclableBufferedInputStream paramRecyclableBufferedInputStream, BitmapFactory.Options paramOptions) {
        if (paramOptions.inJustDecodeBounds) {
            paramRecyclableBufferedInputStream.mark(5242880);
        }
        Bitmap localBitmap = BitmapFactory.decodeStream(paramRecyclableBufferedInputStream, null, paramOptions);
        try {
            if (paramOptions.inJustDecodeBounds) {
                paramRecyclableBufferedInputStream.reset();
                paramRecyclableBufferedInputStream.clearMark();
                return localBitmap;
            }
            paramRecyclableBufferedInputStream.close();
            return localBitmap;
        } catch (IOException paramRecyclableBufferedInputStream) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + paramOptions.inJustDecodeBounds + " sample=" + paramOptions.inSampleSize, paramRecyclableBufferedInputStream);
            }
        }
        return localBitmap;
    }

    private Bitmap.Config getConfig(RecyclableBufferedInputStream paramRecyclableBufferedInputStream) {
        localConfig3 = Bitmap.Config.RGB_565;
        paramRecyclableBufferedInputStream.mark(1024);
        for (; ; ) {
            try {
                if (new ImageHeaderParser(paramRecyclableBufferedInputStream).hasAlpha()) {
                    localConfig1 = Bitmap.Config.ARGB_8888;
                }
            } catch (IOException localIOException) {
                Bitmap.Config localConfig1;
                localIOException.printStackTrace();
                try {
                    paramRecyclableBufferedInputStream.reset();
                    return localConfig3;
                } catch (IOException paramRecyclableBufferedInputStream) {
                    paramRecyclableBufferedInputStream.printStackTrace();
                    return localConfig3;
                }
            } finally {
                try {
                    paramRecyclableBufferedInputStream.reset();
                    throw localConfig2;
                } catch (IOException paramRecyclableBufferedInputStream) {
                    paramRecyclableBufferedInputStream.printStackTrace();
                    continue;
                }
                return localConfig2;
            }
            try {
                paramRecyclableBufferedInputStream.reset();
                return localConfig1;
            } catch (IOException paramRecyclableBufferedInputStream) {
                paramRecyclableBufferedInputStream.printStackTrace();
            }
            localConfig1 = Bitmap.Config.RGB_565;
        }
    }

    @TargetApi(11)
    private static void setInBitmap(BitmapFactory.Options paramOptions, Bitmap paramBitmap) {
        if (Build.VERSION.SDK_INT >= 11) {
            paramOptions.inBitmap = paramBitmap;
        }
    }

    private boolean shouldUsePool(RecyclableBufferedInputStream paramRecyclableBufferedInputStream) {
        paramRecyclableBufferedInputStream.mark(1024);
        try {
            ImageHeaderParser.ImageType localImageType = new ImageHeaderParser(paramRecyclableBufferedInputStream).getType();
            boolean bool = TYPES_THAT_USE_POOL.contains(localImageType);
            try {
                paramRecyclableBufferedInputStream.reset();
                return bool;
            } catch (IOException paramRecyclableBufferedInputStream) {
                paramRecyclableBufferedInputStream.printStackTrace();
                return bool;
            }
            try {
                paramRecyclableBufferedInputStream.reset();
                throw ((Throwable) localObject);
            } catch (IOException paramRecyclableBufferedInputStream) {
                for (; ; ) {
                    paramRecyclableBufferedInputStream.printStackTrace();
                }
            }
        } catch (IOException localIOException) {
            localIOException = localIOException;
            localIOException.printStackTrace();
            try {
                paramRecyclableBufferedInputStream.reset();
                return false;
            } catch (IOException paramRecyclableBufferedInputStream) {
                for (; ; ) {
                    paramRecyclableBufferedInputStream.printStackTrace();
                }
            }
        } finally {
        }
    }

    /* Error */
    public Bitmap downsample(RecyclableBufferedInputStream paramRecyclableBufferedInputStream, BitmapFactory.Options paramOptions, BitmapPool paramBitmapPool, int paramInt1, int paramInt2) {
        // Byte code:
        //   0: aload_1
        //   1: ldc 16
        //   3: invokevirtual 88	com/bumptech/glide/resize/RecyclableBufferedInputStream:mark	(I)V
        //   6: iconst_0
        //   7: istore 6
        //   9: new 145	com/bumptech/glide/resize/load/ImageHeaderParser
        //   12: dup
        //   13: aload_1
        //   14: invokespecial 148	com/bumptech/glide/resize/load/ImageHeaderParser:<init>	(Ljava/io/InputStream;)V
        //   17: invokevirtual 191	com/bumptech/glide/resize/load/ImageHeaderParser:getOrientation	()I
        //   20: istore 7
        //   22: iload 7
        //   24: istore 6
        //   26: aload_1
        //   27: invokevirtual 96	com/bumptech/glide/resize/RecyclableBufferedInputStream:reset	()V
        //   30: aload_0
        //   31: aload_1
        //   32: aload_2
        //   33: invokevirtual 195	com/bumptech/glide/resize/load/Downsampler:getDimensions	(Lcom/bumptech/glide/resize/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;)[I
        //   36: astore 10
        //   38: aload 10
        //   40: iconst_0
        //   41: iaload
        //   42: istore 7
        //   44: aload 10
        //   46: iconst_1
        //   47: iaload
        //   48: istore 8
        //   50: iload 6
        //   52: invokestatic 201	com/bumptech/glide/resize/load/ImageResizer:getExifOrientationDegrees	(I)I
        //   55: istore 9
        //   57: iload 9
        //   59: bipush 90
        //   61: if_icmpeq +11 -> 72
        //   64: iload 9
        //   66: sipush 270
        //   69: if_icmpne +80 -> 149
        //   72: aload_0
        //   73: iload 8
        //   75: iload 7
        //   77: iload 4
        //   79: iload 5
        //   81: invokevirtual 205	com/bumptech/glide/resize/load/Downsampler:getSampleSize	(IIII)I
        //   84: istore 4
        //   86: aload_0
        //   87: aload_1
        //   88: aload_2
        //   89: aload_3
        //   90: iload 7
        //   92: iload 8
        //   94: iload 4
        //   96: invokevirtual 209	com/bumptech/glide/resize/load/Downsampler:downsampleWithSize	(Lcom/bumptech/glide/resize/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;Lcom/bumptech/glide/resize/bitmap_recycle/BitmapPool;III)Landroid/graphics/Bitmap;
        //   99: astore_1
        //   100: aload_1
        //   101: aload_3
        //   102: iload 6
        //   104: invokestatic 213	com/bumptech/glide/resize/load/ImageResizer:rotateImageExif	(Landroid/graphics/Bitmap;Lcom/bumptech/glide/resize/bitmap_recycle/BitmapPool;I)Landroid/graphics/Bitmap;
        //   107: astore_2
        //   108: aload_1
        //   109: aload_2
        //   110: if_acmpeq +17 -> 127
        //   113: aload_3
        //   114: aload_1
        //   115: invokeinterface 219 2 0
        //   120: ifne +7 -> 127
        //   123: aload_1
        //   124: invokevirtual 224	android/graphics/Bitmap:recycle	()V
        //   127: aload_2
        //   128: areturn
        //   129: astore 10
        //   131: aload 10
        //   133: invokevirtual 158	java/io/IOException:printStackTrace	()V
        //   136: goto -110 -> 26
        //   139: astore 10
        //   141: aload 10
        //   143: invokevirtual 158	java/io/IOException:printStackTrace	()V
        //   146: goto -116 -> 30
        //   149: aload_0
        //   150: iload 7
        //   152: iload 8
        //   154: iload 4
        //   156: iload 5
        //   158: invokevirtual 205	com/bumptech/glide/resize/load/Downsampler:getSampleSize	(IIII)I
        //   161: istore 4
        //   163: goto -77 -> 86
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	166	0	this	Downsampler
        //   0	166	1	paramRecyclableBufferedInputStream	RecyclableBufferedInputStream
        //   0	166	2	paramOptions	BitmapFactory.Options
        //   0	166	3	paramBitmapPool	BitmapPool
        //   0	166	4	paramInt1	int
        //   0	166	5	paramInt2	int
        //   7	96	6	i	int
        //   20	131	7	j	int
        //   48	105	8	k	int
        //   55	15	9	m	int
        //   36	9	10	arrayOfInt	int[]
        //   129	3	10	localIOException1	IOException
        //   139	3	10	localIOException2	IOException
        // Exception table:
        //   from	to	target	type
        //   9	22	129	java/io/IOException
        //   26	30	139	java/io/IOException
    }

    protected Bitmap downsampleWithSize(RecyclableBufferedInputStream paramRecyclableBufferedInputStream, BitmapFactory.Options paramOptions, BitmapPool paramBitmapPool, int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt3 > 1) {
            paramOptions.inSampleSize = paramInt3;
        }
        for (; ; ) {
            return decodeStream(paramRecyclableBufferedInputStream, paramOptions);
            if (shouldUsePool(paramRecyclableBufferedInputStream)) {
                setInBitmap(paramOptions, paramBitmapPool.get(paramInt1, paramInt2, getConfig(paramRecyclableBufferedInputStream)));
            }
        }
    }

    public int[] getDimensions(RecyclableBufferedInputStream paramRecyclableBufferedInputStream, BitmapFactory.Options paramOptions) {
        paramOptions.inJustDecodeBounds = true;
        decodeStream(paramRecyclableBufferedInputStream, paramOptions);
        paramOptions.inJustDecodeBounds = false;
        return new int[]{paramOptions.outWidth, paramOptions.outHeight};
    }

    public String getId() {
        return this.id;
    }

    protected abstract int getSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/load/Downsampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
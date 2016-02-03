package com.bumptech.glide.resize.load;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.resize.RecyclableBufferedInputStream;
import com.bumptech.glide.resize.bitmap_recycle.BitmapPool;
import com.bumptech.glide.resize.bitmap_recycle.BitmapPoolAdapter;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

public class ImageResizer {
    private static final boolean CAN_RECYCLE;
    private static final String TAG = "ImageResizer";
    private static final int TEMP_BYTES_SIZE = 16384;
    private final BitmapPool bitmapPool;
    private final BitmapFactory.Options defaultOptions;
    private final Queue<byte[]> tempQueue = new LinkedList();

    static {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        for (boolean bool = true; ; bool = false) {
            CAN_RECYCLE = bool;
            return;
        }
    }

    public ImageResizer() {
        this(null, null);
    }

    @Deprecated
    public ImageResizer(BitmapFactory.Options paramOptions) {
        this(null, paramOptions);
    }

    public ImageResizer(BitmapPool paramBitmapPool) {
        this(paramBitmapPool, null);
    }

    @Deprecated
    public ImageResizer(BitmapPool paramBitmapPool, BitmapFactory.Options paramOptions) {
        if (paramBitmapPool == null) {
        }
        for (this.bitmapPool = new BitmapPoolAdapter(); paramOptions == null; this.bitmapPool = paramBitmapPool) {
            this.defaultOptions = getDefaultOptions();
            return;
        }
        this.defaultOptions = paramOptions;
    }

    public static Bitmap centerCrop(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2) {
        if (paramBitmap2 == null) {
            localObject = null;
        }
        do {
            return (Bitmap) localObject;
            if (paramBitmap2.getWidth() != paramInt1) {
                break;
            }
            localObject = paramBitmap2;
        } while (paramBitmap2.getHeight() == paramInt2);
        float f1 = 0.0F;
        float f2 = 0.0F;
        Object localObject = new Matrix();
        float f3;
        if (paramBitmap2.getWidth() * paramInt2 > paramBitmap2.getHeight() * paramInt1) {
            f3 = paramInt2 / paramBitmap2.getHeight();
            f1 = (paramInt1 - paramBitmap2.getWidth() * f3) * 0.5F;
        }
        for (; ; ) {
            ((Matrix) localObject).setScale(f3, f3);
            ((Matrix) localObject).postTranslate((int) f1 + 0.5F, (int) f2 + 0.5F);
            if (paramBitmap1 == null) {
                break;
            }
            Canvas localCanvas = new Canvas(paramBitmap1);
            Paint localPaint = new Paint();
            localPaint.setFilterBitmap(false);
            localPaint.setAntiAlias(true);
            localCanvas.drawBitmap(paramBitmap2, (Matrix) localObject, localPaint);
            return paramBitmap1;
            f3 = paramInt1 / paramBitmap2.getWidth();
            f2 = (paramInt2 - paramBitmap2.getHeight() * f3) * 0.5F;
        }
        if (paramBitmap2.getConfig() == null) {
        }
        for (paramBitmap1 = Bitmap.Config.ARGB_8888; ; paramBitmap1 = paramBitmap2.getConfig()) {
            paramBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap1);
            break;
        }
    }

    private static void copyOptions(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2) {
        if (Build.VERSION.SDK_INT >= 11) {
            copyOptionsHoneycomb(paramOptions1, paramOptions2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 10) {
            copyOptionsGingerbreadMr1(paramOptions1, paramOptions2);
            return;
        }
        copyOptionsFroyo(paramOptions1, paramOptions2);
    }

    private static void copyOptionsFroyo(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2) {
        paramOptions2.inDensity = paramOptions1.inDensity;
        paramOptions2.inDither = paramOptions1.inDither;
        paramOptions2.inInputShareable = paramOptions1.inInputShareable;
        paramOptions2.inPreferredConfig = paramOptions1.inPreferredConfig;
        paramOptions2.inPurgeable = paramOptions1.inPurgeable;
        paramOptions2.inSampleSize = paramOptions1.inSampleSize;
        paramOptions2.inScaled = paramOptions1.inScaled;
        paramOptions2.inScreenDensity = paramOptions1.inScreenDensity;
        paramOptions2.inTargetDensity = paramOptions1.inTargetDensity;
    }

    @TargetApi(10)
    private static void copyOptionsGingerbreadMr1(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2) {
        copyOptionsFroyo(paramOptions1, paramOptions2);
        paramOptions2.inPreferQualityOverSpeed = paramOptions1.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private static void copyOptionsHoneycomb(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2) {
        copyOptionsGingerbreadMr1(paramOptions1, paramOptions2);
        paramOptions2.inMutable = paramOptions1.inMutable;
    }

    public static Bitmap fitInSpace(Bitmap paramBitmap, int paramInt1, int paramInt2) {
        if (paramBitmap == null) {
            return null;
        }
        if (paramInt2 > paramInt1) {
            return shrinkToWidth(paramBitmap, paramInt1);
        }
        return shrinkToHeight(paramBitmap, paramInt2);
    }

    @TargetApi(11)
    public static BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inDither = false;
        localOptions.inScaled = false;
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inSampleSize = 1;
        if (CAN_RECYCLE) {
            localOptions.inMutable = true;
        }
        return localOptions;
    }

    public static int getExifOrientationDegrees(int paramInt) {
        switch (paramInt) {
            default:
                return 0;
            case 5:
            case 6:
                return 90;
            case 3:
            case 4:
                return 180;
        }
        return 270;
    }

    private BitmapFactory.Options getOptions() {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        copyOptions(this.defaultOptions, localOptions);
        return localOptions;
    }

    public static int getOrientation(String paramString) {
        int i = 0;
        label28:
        do {
            try {
                j = new ExifInterface(paramString).getAttributeInt("Orientation", 0);
                if (j != 6) {
                    break label28;
                }
                i = 90;
            } catch (Exception localException) {
                int j;
                while (!Log.isLoggable("ImageResizer", 6)) {
                }
                Log.e("ImageResizer", "Unable to get orientation for image with path=" + paramString, localException);
            }
            return i;
            if (j == 3) {
                return 180;
            }
        } while (j != 8);
        return 270;
        return 0;
    }

    private byte[] getTempBytes() {
        synchronized (this.tempQueue) {
            byte[] arrayOfByte = (byte[]) this.tempQueue.poll();
            ???=arrayOfByte;
            if (arrayOfByte == null) {
                arrayOfByte = new byte['䀀'];
                ???=arrayOfByte;
                if (Log.isLoggable("ImageResizer", 3)) {
                    Log.d("ImageResizer", "Created temp bytes");
                    ???=arrayOfByte;
                }
            }
            return (byte[])???;
        }
    }

    public static Bitmap orientImage(String paramString, Bitmap paramBitmap) {
        return rotateImage(paramBitmap, getOrientation(paramString));
    }

    private void releaseTempBytes(byte[] paramArrayOfByte) {
        synchronized (this.tempQueue) {
            this.tempQueue.offer(paramArrayOfByte);
            return;
        }
    }

    public static Bitmap rotateImage(Bitmap paramBitmap, int paramInt) {
        Object localObject = paramBitmap;
        if (paramInt != 0) {
        }
        try {
            localObject = new Matrix();
            ((Matrix) localObject).setRotate(paramInt);
            localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix) localObject, true);
            return (Bitmap) localObject;
        } catch (Exception localException) {
            if (Log.isLoggable("ImageResizer", 6)) {
                Log.e("ImageResizer", "Exception when trying to orient image", localException);
            }
            localException.printStackTrace();
        }
        return paramBitmap;
    }

    public static Bitmap rotateImageExif(Bitmap paramBitmap, BitmapPool paramBitmapPool, int paramInt) {
        Matrix localMatrix = new Matrix();
        switch (paramInt) {
            default:
                return paramBitmap;
            case 2:
                localMatrix.setScale(-1.0F, 1.0F);
        }
        for (; ; ) {
            Object localObject2 = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
            localMatrix.mapRect((RectF) localObject2);
            paramInt = Math.round(((RectF) localObject2).width());
            int i = Math.round(((RectF) localObject2).height());
            Object localObject1 = paramBitmapPool.get(paramInt, i, paramBitmap.getConfig());
            paramBitmapPool = (BitmapPool) localObject1;
            if (localObject1 == null) {
                paramBitmapPool = Bitmap.createBitmap(paramInt, i, paramBitmap.getConfig());
            }
            localMatrix.postTranslate(-((RectF) localObject2).left, -((RectF) localObject2).top);
            localObject1 = new Canvas(paramBitmapPool);
            localObject2 = new Paint();
            ((Paint) localObject2).setFilterBitmap(true);
            ((Paint) localObject2).setAntiAlias(true);
            ((Canvas) localObject1).drawBitmap(paramBitmap, localMatrix, null);
            return paramBitmapPool;
            localMatrix.setRotate(180.0F);
            continue;
            localMatrix.setRotate(180.0F);
            localMatrix.postScale(-1.0F, 1.0F);
            continue;
            localMatrix.setRotate(90.0F);
            localMatrix.postScale(-1.0F, 1.0F);
            continue;
            localMatrix.setRotate(90.0F);
            continue;
            localMatrix.setRotate(-90.0F);
            localMatrix.postScale(-1.0F, 1.0F);
            continue;
            localMatrix.setRotate(-90.0F);
        }
    }

    public static Bitmap shrinkToHeight(Bitmap paramBitmap, int paramInt) {
        Bitmap localBitmap = paramBitmap;
        float f = paramInt / paramBitmap.getHeight();
        if (f != 1.0F) {
            localBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * f), paramInt, true);
        }
        return localBitmap;
    }

    public static Bitmap shrinkToWidth(Bitmap paramBitmap, int paramInt) {
        Bitmap localBitmap = paramBitmap;
        float f = paramInt / paramBitmap.getWidth();
        if (f != 1.0F) {
            localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt, Math.round(paramBitmap.getHeight() * f), true);
        }
        return localBitmap;
    }

    public Bitmap load(InputStream paramInputStream) {
        return load(paramInputStream, -1, -1, Downsampler.NONE, Transformation.NONE);
    }

    public Bitmap load(InputStream paramInputStream, int paramInt1, int paramInt2) {
        return load(paramInputStream, paramInt1, paramInt2, Transformation.NONE);
    }

    public Bitmap load(InputStream paramInputStream, int paramInt1, int paramInt2, Downsampler paramDownsampler) {
        return load(paramInputStream, paramInt1, paramInt2, paramDownsampler, Transformation.NONE);
    }

    public Bitmap load(InputStream paramInputStream, int paramInt1, int paramInt2, Downsampler paramDownsampler, Transformation paramTransformation) {
        byte[] arrayOfByte1 = getTempBytes();
        byte[] arrayOfByte2 = getTempBytes();
        BitmapFactory.Options localOptions = getOptions();
        localOptions.inTempStorage = arrayOfByte2;
        paramInputStream = paramDownsampler.downsample(new RecyclableBufferedInputStream(paramInputStream, arrayOfByte1), localOptions, this.bitmapPool, paramInt1, paramInt2);
        paramDownsampler = paramTransformation.transform(paramInputStream, this.bitmapPool, paramInt1, paramInt2);
        if ((paramInputStream != paramDownsampler) && (!this.bitmapPool.put(paramInputStream))) {
            paramInputStream.recycle();
        }
        releaseTempBytes(arrayOfByte1);
        releaseTempBytes(arrayOfByte2);
        return paramDownsampler;
    }

    public Bitmap load(InputStream paramInputStream, int paramInt1, int paramInt2, Transformation paramTransformation) {
        return load(paramInputStream, paramInt1, paramInt2, Downsampler.AT_LEAST, paramTransformation);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/load/ImageResizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.bitmap;

import android.content.res.AssetManager.AssetInputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class EIBitmapUtil {
    public static boolean a = false;
    private static Bitmap.Config b;

    static {
        Log.d("EIBitmap", "device sdk int is:" + Build.VERSION.SDK_INT + "version:" + Build.VERSION.RELEASE);
        if (Build.VERSION.SDK_INT >= 19) {
        }
        for (; ; ) {
            try {
                System.loadLibrary("eibitmap_4_4");
                a = true;
                b = Bitmap.Config.ARGB_8888;
                return;
            } catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {
                Log.e("EIBitmap", "load eibitmap_4_4 error:" + localUnsatisfiedLinkError1.getMessage());
                try {
                    System.loadLibrary("eibitmap_4_4_3");
                    a = true;
                } catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {
                    Log.e("EIBitmap", "load eibitmap_4_4_3 error:" + localUnsatisfiedLinkError2.getMessage());
                    a = false;
                }
                continue;
            }
            if (Build.VERSION.SDK_INT == 18) {
                try {
                    System.loadLibrary("eibitmap_4_3");
                    a = true;
                } catch (UnsatisfiedLinkError localUnsatisfiedLinkError3) {
                    localUnsatisfiedLinkError3.printStackTrace();
                    a = false;
                }
            } else {
                try {
                    System.loadLibrary("eibitmap");
                    a = true;
                } catch (UnsatisfiedLinkError localUnsatisfiedLinkError4) {
                    localUnsatisfiedLinkError4.printStackTrace();
                    a = false;
                }
            }
        }
    }

    public static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
        if (a) {
        }
        for (paramConfig = nativeCreateBitmap(paramInt1, paramInt2, paramConfig, true); ; paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig)) {
            if (paramConfig != null) {
                paramConfig.eraseColor(0);
            }
            return paramConfig;
        }
    }

    public static Bitmap a(Bitmap paramBitmap) {
        Bitmap localBitmap = a(paramBitmap.getWidth(), paramBitmap.getHeight(), b);
        new Canvas(localBitmap).drawBitmap(paramBitmap, new Matrix(), null);
        return localBitmap;
    }

    public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, boolean paramBoolean) {
        a(paramInt1, paramInt2);
        b(paramInt3, paramInt4);
        if (paramInt1 + paramInt3 > paramBitmap.getWidth()) {
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        }
        if (paramInt2 + paramInt4 > paramBitmap.getHeight()) {
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        }
        if ((!paramBitmap.isMutable()) && (paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == paramBitmap.getWidth()) && (paramInt4 == paramBitmap.getHeight()) && ((paramMatrix == null) || (paramMatrix.isIdentity()))) {
            return paramBitmap;
        }
        Canvas localCanvas = new Canvas();
        Rect localRect = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
        RectF localRectF = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
        Object localObject1;
        Object localObject2;
        if ((paramMatrix == null) || (paramMatrix.isIdentity())) {
            localObject1 = a(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
            localObject2 = null;
            ((Bitmap) localObject1).setDensity(paramBitmap.getDensity());
            localCanvas.setBitmap((Bitmap) localObject1);
            localCanvas.drawBitmap(paramBitmap, localRect, localRectF, (Paint) localObject2);
            return (Bitmap) localObject1;
        }
        if ((paramBitmap.hasAlpha()) || (!paramMatrix.rectStaysRect())) {
        }
        for (paramInt1 = 1; ; paramInt1 = 0) {
            localObject1 = new RectF();
            paramMatrix.mapRect((RectF) localObject1, localRectF);
            Bitmap localBitmap = a(Math.round(((RectF) localObject1).width()), Math.round(((RectF) localObject1).height()), Bitmap.Config.ARGB_8888);
            if (paramInt1 != 0) {
                localBitmap.eraseColor(0);
            }
            localCanvas.translate(-((RectF) localObject1).left, -((RectF) localObject1).top);
            localCanvas.concat(paramMatrix);
            Paint localPaint = new Paint();
            localPaint.setFilterBitmap(paramBoolean);
            localObject2 = localPaint;
            localObject1 = localBitmap;
            if (paramMatrix.rectStaysRect()) {
                break;
            }
            localPaint.setAntiAlias(true);
            localObject2 = localPaint;
            localObject1 = localBitmap;
            break;
        }
    }

    public static Bitmap a(InputStream paramInputStream) {
        if (a) {
            byte[] arrayOfByte = new byte['䀀'];
            if (paramInputStream == null) {
                return null;
            }
            Object localObject = paramInputStream;
            if (!(paramInputStream instanceof AssetManager.AssetInputStream)) {
                localObject = new BufferedInputStream(paramInputStream);
                ((InputStream) localObject).mark(16384);
            }
            return nativeDecodeStream((InputStream) localObject, arrayOfByte, Bitmap.Config.ARGB_8888, true);
        }
        return BitmapFactory.decodeStream(paramInputStream);
    }

    public static Bitmap a(String paramString, Bitmap.Config paramConfig) {
        if (a) {
            return nativeDecodeFile(paramString, paramConfig, true);
        }
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = paramConfig;
        return BitmapFactory.decodeFile(paramString, localOptions);
    }

    private static void a(int paramInt1, int paramInt2) {
        if (paramInt1 < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (paramInt2 < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    private static void b(int paramInt1, int paramInt2) {
        if (paramInt1 <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (paramInt2 <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
    }

    public static native Bitmap nativeCreateBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean);

    public static native Bitmap nativeDecodeFile(String paramString, Bitmap.Config paramConfig, boolean paramBoolean);

    public static native Bitmap nativeDecodeStream(InputStream paramInputStream, byte[] paramArrayOfByte, Bitmap.Config paramConfig, boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/bitmap/EIBitmapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
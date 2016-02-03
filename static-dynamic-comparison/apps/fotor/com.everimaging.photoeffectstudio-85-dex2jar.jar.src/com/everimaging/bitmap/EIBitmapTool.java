package com.everimaging.bitmap;

import android.graphics.Bitmap;
import android.util.Log;

public class EIBitmapTool {
    public static boolean a = false;

    static {
        try {
            System.loadLibrary("stb_eibitmap");
            a = true;
            return;
        } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
            Log.e("BitmapTool", "load error:" + localUnsatisfiedLinkError.getMessage());
            a = false;
        }
    }

    public static boolean a(Bitmap paramBitmap1, Bitmap paramBitmap2) {
        if (a) {
            if ((paramBitmap1 != null) && (paramBitmap2 != null) && (paramBitmap1.getWidth() == paramBitmap2.getWidth()) && (paramBitmap1.getHeight() == paramBitmap2.getHeight()) && (paramBitmap1.getConfig() == paramBitmap2.getConfig())) {
                nativeCopyPixels(paramBitmap1, paramBitmap2);
                return true;
            }
        } else {
            Log.e("BitmapTool", "copy pixels is occur error");
            try {
                int[] arrayOfInt = new int[paramBitmap1.getWidth() * paramBitmap1.getHeight()];
                paramBitmap1.getPixels(arrayOfInt, 0, paramBitmap1.getWidth(), 0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
                paramBitmap2.setPixels(arrayOfInt, 0, paramBitmap1.getWidth(), 0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
                return true;
            } catch (Exception paramBitmap1) {
            }
        }
        return false;
    }

    private static native void nativeCopyPixels(Bitmap paramBitmap1, Bitmap paramBitmap2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/bitmap/EIBitmapTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
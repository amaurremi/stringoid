package com.everimaging.fotorsdk.algorithms.jni;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.IAssetLoader;
import com.everimaging.fotorsdk.algorithms.params.base.RSCurveBaseFilterParams;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;

import java.io.PrintStream;

public class FotorSDKAlgorithmsNative {
    static {
        try {
            System.loadLibrary("fotorsdk_algorithms_native");
            return;
        } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
            System.err.println("WARNING: Could not load library!");
        }
    }

    public static native void adjust(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float[] paramArrayOfFloat);

    public static native void blend(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, float paramFloat);

    public static native void effect(Bitmap paramBitmap1, Bitmap paramBitmap2, EffectEntity paramEffectEntity, IAssetLoader paramIAssetLoader);

    public static native void gaussian(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat);

    public static native void mosaic(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat);

    public static native float[] nativeGenCurve(RSCurveBaseFilterParams paramRSCurveBaseFilterParams);

    public static native void tiltShift(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/jni/FotorSDKAlgorithmsNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
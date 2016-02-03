package com.everimaging.fotorsdk.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

public class FotorNativeAlgothims {
    public static native void nativeDoEnhance(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt);

    public static native Bitmap nativeLoadImage(String paramString, Context paramContext, Uri paramUri, int paramInt1, int paramInt2, int paramInt3);

    public static native boolean nativeSaveImage(String paramString, int paramInt, Bitmap paramBitmap);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/jni/FotorNativeAlgothims.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
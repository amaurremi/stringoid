package com.everimaging.fotor.c;

import android.graphics.Bitmap;
import android.net.Uri;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.ExifUtils;

import java.io.File;

public class d {
    public static int a(String paramString) {
        return ExifUtils.getExifOrientation(paramString);
    }

    public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3) {
        return BitmapDecodeUtils.decode(null, Uri.fromFile(new File(paramString)), paramInt1, paramInt2, null, paramInt3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
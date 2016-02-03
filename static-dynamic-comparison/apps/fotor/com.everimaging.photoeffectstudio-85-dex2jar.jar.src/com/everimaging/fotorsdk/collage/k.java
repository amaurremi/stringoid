package com.everimaging.fotorsdk.collage;

import android.content.Context;
import android.graphics.Bitmap;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.GridThumbStreamLoader;
import com.everimaging.fotorsdk.utils.GridThumbStreamLoader.StreamThumbProcessor;

import java.io.InputStream;

public class k {
    private static GridThumbStreamLoader a = null;

    public static GridThumbStreamLoader a(Context paramContext) {
        if (a == null) {
            a = new GridThumbStreamLoader(paramContext, new GridThumbStreamLoader.StreamThumbProcessor() {
                public Bitmap processImageStream(InputStream paramAnonymousInputStream) {
                    return BitmapDecodeUtils.decodeStream(paramAnonymousInputStream);
                }
            }, 8);
            a.setDisplayDensity(240);
        }
        return a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
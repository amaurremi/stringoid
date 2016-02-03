package com.everimaging.fotorsdk.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;

import java.io.File;

public class a {
    private static Bitmap a(Context paramContext, int paramInt1, int paramInt2) {
        try {
            paramContext = MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), paramInt1, paramInt2, 1, null);
            return paramContext;
        } catch (OutOfMemoryError paramContext) {
        }
        return null;
    }

    public static Bitmap a(Context paramContext, Picture paramPicture, int paramInt1, int paramInt2) {
        Bitmap localBitmap = a(paramContext, paramPicture.f(), Integer.parseInt(paramPicture.a()));
        if (localBitmap == null) {
            paramContext = BitmapDecodeUtils.decode(null, Uri.fromFile(new File(paramPicture.c())), paramInt1, paramInt2, null, paramPicture.d());
        }
        do {
            return paramContext;
            if (paramPicture.d() == 0) {
                break;
            }
            paramPicture = BitmapUtils.rotateBitmap(localBitmap, paramPicture.d(), false, false);
            paramContext = paramPicture;
        } while (localBitmap == paramPicture);
        localBitmap.recycle();
        return paramPicture;
        return localBitmap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/imagepicker/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.everimaging.fotorsdk.editor.filter.params.EnhanceParams;
import com.everimaging.fotorsdk.editor.filter.params.EnhanceParams.EnhanceLevel;
import com.everimaging.fotorsdk.jni.FotorNativeAlgothims;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class d
        extends a {
    public d(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, EnhanceParams paramEnhanceParams) {
        super(parama, paramBitmap1, paramBitmap2, paramEnhanceParams);
    }

    public Bitmap a() {
        Bitmap localBitmap = this.d;
        if (localBitmap == null) {
            localBitmap = BitmapUtils.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
        }
        for (; ; ) {
            EnhanceParams localEnhanceParams = (EnhanceParams) this.e;
            FotorNativeAlgothims.nativeDoEnhance(this.c, localBitmap, localEnhanceParams.getEnhanceLevel().getLevel());
            return localBitmap;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
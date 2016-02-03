package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.editor.filter.params.RotateParams;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class h
        extends a {
    public h(a.a parama, Bitmap paramBitmap, RotateParams paramRotateParams) {
        super(parama, paramBitmap, null, paramRotateParams);
    }

    public Bitmap a() {
        Object localObject = (RotateParams) this.e;
        boolean bool1 = ((RotateParams) localObject).isFlipH();
        boolean bool2 = ((RotateParams) localObject).isFlipV();
        int i = ((RotateParams) localObject).getDegree();
        localObject = BitmapUtils.rotateBitmap(this.c, i, bool2, bool1);
        if (this.d != null) {
        }
        return (Bitmap) localObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
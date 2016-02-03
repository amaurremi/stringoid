package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.everimaging.fotorsdk.editor.filter.params.CropParams;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class b
        extends a {
    public b(a.a parama, Bitmap paramBitmap, CropParams paramCropParams) {
        super(parama, paramBitmap, null, paramCropParams);
    }

    public Bitmap a() {
        Object localObject = (CropParams) this.e;
        Rect localRect = ((CropParams) localObject).getCropBounds();
        float f4 = ((CropParams) localObject).getStraiDegree();
        int[] arrayOfInt = ((CropParams) localObject).getStraiSize();
        float f2 = this.c.getWidth() / ((CropParams) localObject).getPreviewWidth();
        float f3 = this.c.getHeight() / ((CropParams) localObject).getPreviewHeight();
        float f1 = f3;
        if (f2 < f3) {
            f1 = f2;
        }
        int i = localRect.width();
        int j = localRect.height();
        localRect.left = ((int) (localRect.left * f1));
        localRect.top = ((int) (localRect.top * f1));
        int k = localRect.left;
        localRect.right = ((int) (i * f1) + k);
        localRect.bottom = (localRect.top + (int) (j * f1));
        arrayOfInt[0] = ((int) (arrayOfInt[0] * f1));
        arrayOfInt[1] = ((int) (f1 * arrayOfInt[1]));
        localObject = BitmapUtils.getStraiCropResult(this.c, arrayOfInt, f4, localRect);
        if (this.d != null) {
        }
        return (Bitmap) localObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
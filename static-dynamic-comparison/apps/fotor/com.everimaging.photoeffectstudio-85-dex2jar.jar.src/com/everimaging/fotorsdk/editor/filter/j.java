package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import com.everimaging.fotorsdk.editor.filter.params.TextsParams;
import com.everimaging.fotorsdk.editor.filter.params.TextsParams.a;
import com.everimaging.fotorsdk.editor.widget.d;
import com.everimaging.fotorsdk.utils.BitmapUtils;

import java.util.Iterator;
import java.util.List;

public class j
        extends a {
    public j(a.a parama, Bitmap paramBitmap, TextsParams paramTextsParams) {
        super(parama, paramBitmap, null, paramTextsParams);
    }

    public Bitmap a() {
        Object localObject = (TextsParams) this.e;
        int i = this.c.getWidth();
        int j = this.c.getHeight();
        Bitmap localBitmap = BitmapUtils.copy(this.c, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        localObject = ((TextsParams) localObject).getParamObjList().iterator();
        while (((Iterator) localObject).hasNext()) {
            TextsParams.a locala = (TextsParams.a) ((Iterator) localObject).next();
            d locald = new d(this.a);
            locald.a(locala.m());
            locald.a(locala.k());
            locald.b(locala.l());
            locald.d(locala.e());
            locald.e(locala.f());
            locald.b(locala.b());
            locald.a(locala.j());
            locald.a(locala.g());
            locald.a(locala.a());
            locald.a(locala.d());
            locald.a(locala.i());
            locald.f(locala.h());
            locald.b(locala.c());
            locald.a(locala.n());
            locald.a(localCanvas, i, j);
        }
        if (this.d != null) {
        }
        return localBitmap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
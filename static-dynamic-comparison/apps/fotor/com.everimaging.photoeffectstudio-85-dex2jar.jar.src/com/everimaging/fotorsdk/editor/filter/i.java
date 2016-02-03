package com.everimaging.fotorsdk.editor.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import com.everimaging.fotorsdk.editor.filter.params.StickersParams;
import com.everimaging.fotorsdk.editor.filter.params.StickersParams.a;
import com.everimaging.fotorsdk.editor.utils.StickersDecodeUtils.StickersResLoadMode;
import com.everimaging.fotorsdk.editor.widget.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.widget.entity.StickersEntity;

import java.util.Iterator;
import java.util.List;

public class i
        extends a {
    public i(a.a parama, Bitmap paramBitmap, StickersParams paramStickersParams) {
        super(parama, paramBitmap, null, paramStickersParams);
    }

    public Bitmap a() {
        Bitmap localBitmap = BitmapUtils.copy(this.c, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Iterator localIterator = ((StickersParams) this.e).getParamObjList().iterator();
        while (localIterator.hasNext()) {
            Object localObject = (StickersParams.a) localIterator.next();
            RectF localRectF = ((StickersParams.a) localObject).b();
            float f1 = ((StickersParams.a) localObject).f();
            float f2 = ((StickersParams.a) localObject).e();
            StickersEntity localStickersEntity = ((StickersParams.a) localObject).a();
            float f3 = ((StickersParams.a) localObject).c();
            float f4 = ((StickersParams.a) localObject).d();
            int i = ((StickersParams.a) localObject).g();
            int j = ((StickersParams.a) localObject).h();
            int k = ((StickersParams.a) localObject).i();
            int m = ((StickersParams.a) localObject).j();
            boolean bool = ((StickersParams.a) localObject).k();
            localObject = new c(this.a, localStickersEntity, StickersDecodeUtils.StickersResLoadMode.MODE_ORIGINAL);
            ((c) localObject).a(localRectF);
            ((c) localObject).a(f1);
            ((c) localObject).b(f2);
            ((c) localObject).c(f3);
            ((c) localObject).d(f4);
            ((c) localObject).b(i, j);
            if (bool) {
                ((c) localObject).a(k);
            }
            ((c) localObject).b(m);
            ((c) localObject).a(localCanvas, localBitmap.getWidth(), localBitmap.getHeight());
        }
        if (this.d != null) {
        }
        return localBitmap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
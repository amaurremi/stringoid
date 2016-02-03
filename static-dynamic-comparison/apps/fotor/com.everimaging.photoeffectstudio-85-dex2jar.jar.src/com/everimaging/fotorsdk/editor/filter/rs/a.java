package com.everimaging.fotorsdk.editor.filter.rs;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.support.v8.renderscript.Type;
import com.everimaging.bitmap.EIBitmapTool;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;

public class a {
    private static final String a = a.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private Bitmap c;
    private Bitmap d;
    private RenderScript e;
    private Allocation f;
    private Allocation g;
    private ScriptIntrinsicBlur h;

    public a(RenderScript paramRenderScript, Bitmap paramBitmap1, Bitmap paramBitmap2) {
        this.e = paramRenderScript;
        this.c = paramBitmap1;
        this.d = paramBitmap2;
        this.f = Allocation.createFromBitmap(this.e, this.c);
        this.g = Allocation.createTyped(this.e, this.f.getType());
        this.h = ScriptIntrinsicBlur.create(this.e, Element.U8_4(this.e));
    }

    public Bitmap a(float paramFloat) {
        float f1 = 25.0F;
        b.a();
        if ((this.f == null) || (this.g == null) || (this.e == null) || (this.h == null)) {
            return null;
        }
        Bitmap localBitmap2 = this.d;
        Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null) {
            localBitmap1 = BitmapUtils.createBitmap(this.g.getType().getX(), this.g.getType().getY(), Bitmap.Config.ARGB_8888);
        }
        if (paramFloat > 0.0F) {
            paramFloat = 2.0F * paramFloat;
            b.c(new Object[]{"radius:" + paramFloat});
            if (paramFloat < 25.0F) {
                break label245;
            }
            paramFloat = f1;
        }
        label245:
        for (; ; ) {
            this.h.setInput(this.f);
            this.h.setRadius(paramFloat);
            this.h.forEach(this.g);
            this.g.copyTo(localBitmap1);
            for (; ; ) {
                b.c(new Object[]{"Do Gaussian blur use time:" + b.b()});
                return localBitmap1;
                b.c(new Object[]{"radius is zero copy src to dst"});
                EIBitmapTool.a(this.c, localBitmap1);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/rs/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
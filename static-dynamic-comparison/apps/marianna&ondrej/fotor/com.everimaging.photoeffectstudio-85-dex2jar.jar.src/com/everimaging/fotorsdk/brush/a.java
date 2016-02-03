package com.everimaging.fotorsdk.brush;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public abstract class a
        extends View {
    protected Context a = null;
    protected Canvas b = null;
    protected Bitmap c = null;
    protected Brush d = null;

    public a(Context paramContext) {
        super(paramContext);
        this.a = paramContext;
    }

    public Bitmap getBitmap() {
        return this.c;
    }

    public Brush getBrush() {
        return this.d;
    }

    public void setBitmap(Bitmap paramBitmap) {
        this.c = paramBitmap;
    }

    public void setBrush(Brush paramBrush) {
        this.d = paramBrush;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
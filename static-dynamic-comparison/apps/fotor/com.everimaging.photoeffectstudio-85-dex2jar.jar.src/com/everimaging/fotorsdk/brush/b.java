package com.everimaging.fotorsdk.brush;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import com.everimaging.fotorsdk.brush.toolkit.e;

public abstract class b
        extends View {
    protected e a = new e(this);
    protected Bitmap b;
    protected Bitmap c;
    private a d = null;

    public b(Context paramContext) {
        super(paramContext);
    }

    protected void a() {
        if (this.d == null) {
            return;
        }
        this.d.a(this);
    }

    public void a(Bitmap paramBitmap1, Bitmap paramBitmap2) {
        this.b = paramBitmap1;
        this.c = paramBitmap2;
        if ((this.b.getWidth() == this.c.getWidth()) && (this.b.getHeight() == this.c.getHeight()) && (this.b.getConfig() != this.c.getConfig())) {
        }
    }

    protected void a(MotionEvent paramMotionEvent) {
        if (this.d == null) {
            return;
        }
        this.d.a(this, paramMotionEvent);
    }

    protected void b(MotionEvent paramMotionEvent) {
        if (this.d == null) {
            return;
        }
        this.d.b(this, paramMotionEvent);
    }

    protected void c(MotionEvent paramMotionEvent) {
        if (this.d == null) {
            return;
        }
        this.d.c(this, paramMotionEvent);
    }

    public Bitmap getDstBitmap() {
        return this.c;
    }

    public a getOnPainterBeautyListener() {
        return this.d;
    }

    public Bitmap getSrcBitmap() {
        return this.b;
    }

    public e getViewCamera() {
        return this.a;
    }

    public void setDstBitmap(Bitmap paramBitmap) {
        this.c = paramBitmap;
    }

    public void setOnPainterBeautyListenr(a parama) {
        this.d = parama;
    }

    public void setSrcBitmap(Bitmap paramBitmap) {
        this.b = paramBitmap;
    }

    public void setViewCamera(e parame) {
        this.a = parame;
    }

    public static abstract interface a {
        public abstract void a(b paramb);

        public abstract void a(b paramb, MotionEvent paramMotionEvent);

        public abstract void b(b paramb, MotionEvent paramMotionEvent);

        public abstract void c(b paramb, MotionEvent paramMotionEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
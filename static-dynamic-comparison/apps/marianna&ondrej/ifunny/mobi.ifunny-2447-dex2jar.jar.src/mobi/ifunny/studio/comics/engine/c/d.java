package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Bitmap;
import android.graphics.PointF;

public class d
        implements Cloneable {
    private Bitmap a;
    private PointF b;
    private float c;
    private float d;

    public d(Bitmap paramBitmap) {
        this.a = paramBitmap;
        this.b = new PointF(paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
        this.d = 1.0F;
    }

    public PointF a() {
        return this.b;
    }

    public void a(float paramFloat) {
        this.c = paramFloat;
    }

    public void a(Bitmap paramBitmap) {
        this.a = paramBitmap;
    }

    public void a(PointF paramPointF) {
        this.b = paramPointF;
    }

    public float b() {
        return this.c;
    }

    public void b(float paramFloat) {
        this.d = paramFloat;
    }

    public float c() {
        return this.d;
    }

    public Object clone() {
        d locald = (d) super.clone();
        locald.b = new PointF(this.b.x, this.b.y);
        return locald;
    }

    public Bitmap d() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
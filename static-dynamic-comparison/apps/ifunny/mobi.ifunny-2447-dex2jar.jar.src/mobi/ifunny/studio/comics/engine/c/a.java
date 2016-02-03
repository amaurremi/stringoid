package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Iterator;

import mobi.ifunny.util.a.d;
import mobi.ifunny.util.a.e;
import mobi.ifunny.view.drawable.f;

public class a
        extends h {
    private Drawable c;

    public a(Drawable paramDrawable) {
        this(j.c, paramDrawable);
    }

    public a(j paramj, Drawable paramDrawable) {
        super(paramj);
        a(paramDrawable);
    }

    private void a(Drawable paramDrawable) {
        this.c = paramDrawable;
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        a(i, j);
    }

    public Drawable a() {
        return this.c;
    }

    protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        super.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.c.setBounds(0, 0, (int) paramFloat3, (int) paramFloat4);
    }

    protected void a(Canvas paramCanvas) {
        this.c.draw(paramCanvas);
    }

    public void b() {
        super.b();
        if ((this.c instanceof BitmapDrawable)) {
            ((BitmapDrawable) this.c).getBitmap().recycle();
        }
        for (; ; ) {
            return;
            if ((this.c instanceof f)) {
                Iterator localIterator = ((f) this.c).e().c.iterator();
                while (localIterator.hasNext()) {
                    ((e) localIterator.next()).a.recycle();
                }
            }
        }
    }

    public Object clone() {
        a locala = (a) super.clone();
        if ((this.c instanceof BitmapDrawable)) {
            locala.a(new BitmapDrawable(((BitmapDrawable) this.c).getBitmap()));
        }
        for (; ; ) {
            locala.a(this.c);
            return locala;
            if ((this.c instanceof f)) {
                locala.a(new f(((f) this.c).e(), true));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
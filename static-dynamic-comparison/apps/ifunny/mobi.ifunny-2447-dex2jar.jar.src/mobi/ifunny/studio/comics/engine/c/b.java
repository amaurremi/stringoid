package mobi.ifunny.studio.comics.engine.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

public final class b
        extends h {
    public b(int paramInt) {
        super(j.b);
        e(paramInt);
        C().setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.DST));
    }

    protected void a(Canvas paramCanvas) {
        paramCanvas.drawPaint(this.a);
    }

    public boolean equals(Object paramObject) {
        if (paramObject == null) {
        }
        do {
            do {
                return false;
            } while (!(paramObject instanceof b));
            paramObject = (b) paramObject;
        } while (z() != ((b) paramObject).z());
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
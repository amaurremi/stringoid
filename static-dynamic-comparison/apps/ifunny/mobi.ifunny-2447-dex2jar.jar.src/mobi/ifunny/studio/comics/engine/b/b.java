package mobi.ifunny.studio.comics.engine.b;

import android.graphics.Paint;
import mobi.ifunny.studio.comics.engine.c.h;
import mobi.ifunny.studio.comics.engine.f;

public class b
        extends i {
    public b(h paramh, Paint paramPaint, boolean paramBoolean) {
        super(paramh, paramPaint, new Paint(paramh.C()), Boolean.valueOf(paramBoolean));
    }

    public Object a() {
        Paint localPaint2 = (Paint) super.a();
        Paint localPaint1 = localPaint2;
        if (localPaint2 == null) {
            localPaint1 = new Paint(c().C());
            a(localPaint1);
        }
        return localPaint1;
    }

    public void a(int paramInt) {
        ((Paint) a()).setColor(paramInt);
    }

    public void a(f paramf) {
        c().a((Paint) a());
    }

    public void b(f paramf) {
        c().a((Paint) b());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
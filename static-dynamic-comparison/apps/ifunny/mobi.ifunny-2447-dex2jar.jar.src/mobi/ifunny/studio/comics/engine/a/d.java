package mobi.ifunny.studio.comics.engine.a;

import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract class d {
    private g a;
    private e b;
    private f c;

    public d(g paramg, e parame) {
        this.a = paramg;
        this.b = parame;
    }

    public void a(e parame) {
        this.b = parame;
    }

    public void a(f paramf) {
        this.c = paramf;
    }

    public void a(g paramg) {
        this.a = paramg;
    }

    public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);

    public boolean a(MotionEvent paramMotionEvent) {
        if (this.c != null) {
            return this.c.a(this, paramMotionEvent);
        }
        return false;
    }

    public abstract boolean b(int paramInt, KeyEvent paramKeyEvent);

    public g h() {
        return this.a;
    }

    public e i() {
        return this.b;
    }

    protected mobi.ifunny.studio.comics.engine.f j() {
        if (this.a != null) {
            return this.a.a();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
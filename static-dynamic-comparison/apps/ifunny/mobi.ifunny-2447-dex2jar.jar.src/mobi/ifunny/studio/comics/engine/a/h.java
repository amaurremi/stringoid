package mobi.ifunny.studio.comics.engine.a;

import android.view.KeyEvent;
import android.view.MotionEvent;
import mobi.ifunny.studio.comics.engine.f;

public final class h
        implements g {
    private d a;
    private f b;

    public h(f paramf) {
        this.b = paramf;
    }

    public f a() {
        return this.b;
    }

    public void a(d paramd) {
        if (this.a != null) {
            this.a.a(null);
        }
        this.a = paramd;
        if (this.a != null) {
            this.a.a(this);
        }
    }

    public boolean a(int paramInt, KeyEvent paramKeyEvent) {
        if (this.a != null) {
            return this.a.a(paramInt, paramKeyEvent);
        }
        return false;
    }

    public boolean a(MotionEvent paramMotionEvent) {
        if (this.a != null) {
            return this.a.a(paramMotionEvent);
        }
        return false;
    }

    public d b() {
        return this.a;
    }

    public boolean b(int paramInt, KeyEvent paramKeyEvent) {
        if (this.a != null) {
            return this.a.b(paramInt, paramKeyEvent);
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
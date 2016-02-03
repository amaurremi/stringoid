package android.support.v7.a;

import android.support.v7.c.a;
import android.support.v7.c.b;
import android.support.v7.internal.view.menu.q;
import android.support.v7.internal.view.menu.r;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.view.Menu;
import android.view.MenuItem;

class t
        extends a
        implements r {
    private b b;
    private q c;

    public t(s params, b paramb) {
        this.b = paramb;
        this.c = new q(params.i()).a(1);
        this.c.a(this);
    }

    public Menu a() {
        return this.c;
    }

    public void a(q paramq) {
        if (this.b == null) {
            return;
        }
        c();
        s.e(this.a).a();
    }

    public void a(CharSequence paramCharSequence) {
        s.e(this.a).setTitle(paramCharSequence);
    }

    public boolean a(q paramq, MenuItem paramMenuItem) {
        if (this.b != null) {
            return this.b.a(this, paramMenuItem);
        }
        return false;
    }

    public void b() {
        if (this.a.a != this) {
            return;
        }
        if (!s.a(s.c(this.a), s.d(this.a), false)) {
            this.a.b = this;
            this.a.c = this.b;
        }
        for (; ; ) {
            this.b = null;
            this.a.e(false);
            s.e(this.a).g();
            s.f(this.a).sendAccessibilityEvent(32);
            this.a.a = null;
            return;
            this.b.a(this);
        }
    }

    public void c() {
        this.c.g();
        try {
            this.b.b(this, this.c);
            return;
        } finally {
            this.c.h();
        }
    }

    public boolean d() {
        this.c.g();
        try {
            boolean bool = this.b.a(this, this.c);
            return bool;
        } finally {
            this.c.h();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
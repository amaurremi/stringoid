package mobi.ifunny.social.a;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;

import java.lang.reflect.Field;

public class a
        implements m, n {
    private g a;
    private boolean b;
    private k c;
    private e d;
    private f e;
    private d f;
    private c g;
    private Field h;

    private void a(String paramString) {
        if (this.f != null) {
            this.f.b(paramString);
        }
    }

    private void f() {
        l locall = new l(this.g.p().getActivity());
        locall.a(com.google.android.gms.plus.d.c).a(com.google.android.gms.plus.d.d).a(this).a(this);
        this.c = locall.b();
    }

    private void g() {
        if (this.c.c()) {
            this.c.b(this);
            this.c.b(this);
            com.google.android.gms.plus.d.h.b(this.c);
            this.c.b();
            f();
        }
    }

    private void h() {
        if (this.c.c()) {
            this.c.b(this);
            this.c.b(this);
            com.google.android.gms.plus.d.h.b(this.c);
            com.google.android.gms.plus.d.h.a(this.c);
            this.a = g.a;
            f();
            l();
        }
    }

    private void i() {
        this.b = false;
        if (this.c.c()) {
            a(null);
        }
        if (!this.c.d()) {
            this.c.a();
        }
    }

    private void j() {
        if (this.c != null) {
            this.c.b(this);
            this.c.b(this);
            if (this.c.c()) {
                this.c.b();
            }
            this.c = null;
        }
    }

    private void k() {
        if (this.d != null) {
            this.d.q();
        }
    }

    private void l() {
        if (this.e != null) {
            this.e.m();
        }
    }

    private void m() {
        if (this.f != null) {
            this.f.r();
        }
    }

    private void n() {
        a(null);
    }

    public void a() {
        j();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void a(int paramInt) {
        this.b = false;
        e();
        n();
    }

    public void a(int paramInt1, int paramInt2, Intent paramIntent) {
        this.b = false;
        if ((paramInt1 == 9000) && (paramInt2 == -1)) {
            i();
            return;
        }
        if (paramInt2 == 0) {
            this.a = g.a;
            m();
            return;
        }
        this.a = g.a;
        n();
    }

    public void a(Bundle paramBundle) {
        this.b = false;
        switch (b.a[this.a.ordinal()]) {
        }
        for (; ; ) {
            this.a = g.a;
            return;
            this.a = g.a;
            k();
            continue;
            h();
        }
    }

    public void a(com.google.android.gms.common.a parama) {
        if ((parama.a()) && (this.g != null)) {
            try {
                Fragment localFragment = this.g.p();
                int i = this.h.getInt(localFragment);
                this.b = true;
                parama.a(localFragment.getActivity(), (i + 1 << 16) + 9000);
                return;
            } catch (IntentSender.SendIntentException parama) {
                this.c.a();
                return;
            } catch (IllegalAccessException parama) {
                throw new RuntimeException(parama);
            }
        }
        e();
        n();
    }

    public void a(e parame, f paramf, d paramd, c paramc, Bundle paramBundle) {
        this.g = paramc;
        this.d = parame;
        this.e = paramf;
        this.f = paramd;
        for (; ; ) {
            try {
                this.h = Fragment.class.getDeclaredField("mIndex");
                this.h.setAccessible(true);
                this.a = g.a;
                if (paramBundle != null) {
                    this.a = ((g) paramBundle.getSerializable("SAVE_ACTION"));
                    this.b = paramBundle.getBoolean("SAVE_RESOLVING", false);
                    f();
                    if ((this.a != g.a) && (!this.b)) {
                        i();
                    }
                    return;
                }
            } catch (NoSuchFieldException parame) {
                throw new RuntimeException(parame);
            }
            this.b = false;
        }
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2) {
        this.b = false;
        this.a = g.b;
        if ((!paramBoolean1) && (this.c.c())) {
            if (paramBoolean2) {
                com.google.android.gms.plus.d.h.b(this.c);
            }
            this.c.b(this);
            this.c.b(this);
            this.c.b();
            f();
        }
        i();
    }

    public com.google.android.gms.plus.a.b.a b() {
        return com.google.android.gms.plus.d.g.a(this.c);
    }

    public void b(Bundle paramBundle) {
        paramBundle.putSerializable("SAVE_ACTION", this.a);
        paramBundle.putBoolean("SAVE_RESOLVING", this.b);
    }

    public String c() {
        return com.google.android.gms.plus.d.h.c(this.c);
    }

    public void d() {
        this.b = false;
        this.a = g.c;
        i();
    }

    public void e() {
        this.b = false;
        this.a = g.a;
        g();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
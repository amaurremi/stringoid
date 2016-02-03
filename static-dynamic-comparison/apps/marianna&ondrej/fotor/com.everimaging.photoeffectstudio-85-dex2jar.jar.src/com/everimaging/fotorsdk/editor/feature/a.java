package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v8.renderscript.RenderScript;
import android.view.LayoutInflater;
import android.view.View;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public abstract class a
        implements h, com.everimaging.fotorsdk.editor.filter.a.a {
    private static final String l = a.class.getSimpleName();
    private static final FotorLoggerFactory.c m = FotorLoggerFactory.a(l, FotorLoggerFactory.LoggerType.CONSOLE);
    protected c a;
    protected a b;
    protected b c;
    protected Bitmap d;
    protected String e;
    protected View f;
    protected View g;
    protected Context h;
    protected boolean i;
    protected RenderScript j;
    protected com.everimaging.fotorsdk.algorithms.filter.d k;
    private boolean n;
    private boolean o;

    public a(c paramc) {
        this.a = paramc;
        this.h = paramc.a().g();
        this.j = paramc.a().r();
        this.k = paramc.a().s();
        this.n = false;
        this.o = false;
    }

    private boolean a() {
        return this.o;
    }

    protected abstract void A();

    public boolean B() {
        return false;
    }

    protected void C() {
        m.c(new Object[]{"onPreApply do Nothing."});
    }

    public final void D() {
        C();
        m.c(new Object[]{"onApplyClick->isBitmapChanged:" + this.i});
        if (this.i) {
            A();
        }
        for (; ; ) {
            try {
                E();
                return;
            } catch (Exception localException) {
                m.equals("log apply error" + localException.getMessage());
            }
            if (this.b != null) {
                this.b.a(this);
            }
        }
    }

    protected void E() {
        m.c(new Object[]{"doNothing"});
    }

    public final boolean F() {
        return B();
    }

    protected boolean G() {
        return (this.n) && (a());
    }

    public void H() {
    }

    public void I() {
        com.everimaging.fotorsdk.engine.d.a(this.h, e());
    }

    public View a(LayoutInflater paramLayoutInflater) {
        this.f = c(paramLayoutInflater);
        return this.f;
    }

    public void a(Configuration paramConfiguration) {
        m.c(new Object[]{"onConfigurationChanged"});
    }

    public void a(Bitmap paramBitmap, String paramString) {
        m.f(new Object[]{"#onCreate#"});
        this.d = paramBitmap;
        this.e = paramString;
        t();
        u();
        this.i = false;
        this.o = true;
    }

    public void a(a parama) {
        this.b = parama;
    }

    public void a(b paramb) {
        this.c = paramb;
    }

    public View b(LayoutInflater paramLayoutInflater) {
        this.g = d(paramLayoutInflater);
        return this.g;
    }

    protected int e() {
        return 0;
    }

    public void f() {
        this.o = false;
        m.f(new Object[]{"#onDestory#"});
    }

    public void g() {
        m.f(new Object[]{"#onOpening#"});
    }

    public Context getContext() {
        return this.h;
    }

    public RenderScript getRenderScript() {
        return this.j;
    }

    public com.everimaging.fotorsdk.algorithms.filter.d getScript_BaseFilter() {
        return this.k;
    }

    public final void k() {
        m.f(new Object[]{"#onOpened#"});
        m();
        r();
        this.n = true;
        com.everimaging.fotorsdk.engine.d.a(this.h, e());
    }

    public final void l() {
        m.f(new Object[]{"#onClosed#"});
        q();
        this.n = false;
        com.everimaging.fotorsdk.engine.d.a(this.h, 4);
    }

    protected void m() {
    }

    public final void o() {
        m.f(new Object[]{"#onClosing#"});
        p();
        s();
    }

    protected void p() {
    }

    protected void q() {
    }

    public void r() {
        if (this.c != null) {
            this.c.b(this);
        }
    }

    public void s() {
        if (this.c != null) {
            this.c.c(this);
        }
    }

    protected abstract void t();

    protected abstract void u();

    protected View v() {
        return this.f;
    }

    protected View w() {
        return this.g;
    }

    public abstract FotorFeaturesFactory.FeatureType x();

    public abstract String y();

    public boolean z() {
        return false;
    }

    public static abstract interface a {
        public abstract void a(a parama);

        public abstract void a(a parama, Bitmap paramBitmap, BaseParams... paramVarArgs);
    }

    public static abstract interface b {
        public abstract void b(a parama);

        public abstract void c(a parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
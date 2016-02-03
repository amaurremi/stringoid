package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.support.v7.b.c;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

class s
        extends a {
    private boolean A;
    private b B;
    t a;
    android.support.v7.c.a b;
    android.support.v7.c.b c;
    final Handler d = new Handler();
    private Context e;
    private Context f;
    private g g;
    private ActionBarOverlayLayout h;
    private ActionBarContainer i;
    private ViewGroup j;
    private ActionBarView k;
    private ActionBarContextView l;
    private ActionBarContainer m;
    private ScrollingTabContainerView n;
    private ArrayList<u> o = new ArrayList();
    private u p;
    private int q = -1;
    private boolean r;
    private ArrayList s = new ArrayList();
    private int t;
    private boolean u;
    private int v = 0;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z = true;

    public s(g paramg, b paramb) {
        this.g = paramg;
        this.e = paramg;
        this.B = paramb;
        a(this.g);
    }

    private void a(e parame, int paramInt) {
        parame = (u) parame;
        if (parame.g() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        parame.b(paramInt);
        this.o.add(paramInt, parame);
        int i1 = this.o.size();
        paramInt += 1;
        while (paramInt < i1) {
            ((u) this.o.get(paramInt)).b(paramInt);
            paramInt += 1;
        }
    }

    private void a(g paramg) {
        boolean bool = false;
        this.h = ((ActionBarOverlayLayout) paramg.findViewById(android.support.v7.b.f.action_bar_overlay_layout));
        if (this.h != null) {
            this.h.setActionBar(this);
        }
        this.k = ((ActionBarView) paramg.findViewById(android.support.v7.b.f.action_bar));
        this.l = ((ActionBarContextView) paramg.findViewById(android.support.v7.b.f.action_context_bar));
        this.i = ((ActionBarContainer) paramg.findViewById(android.support.v7.b.f.action_bar_container));
        this.j = ((ViewGroup) paramg.findViewById(android.support.v7.b.f.top_action_bar));
        if (this.j == null) {
            this.j = this.i;
        }
        this.m = ((ActionBarContainer) paramg.findViewById(android.support.v7.b.f.split_action_bar));
        if ((this.k == null) || (this.l == null) || (this.i == null)) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.k.setContextView(this.l);
        if (this.k.i()) {
            i1 = 1;
            this.t = i1;
            if ((this.k.getDisplayOptions() & 0x4) == 0) {
                break label277;
            }
        }
        label277:
        for (int i1 = 1; ; i1 = 0) {
            if (i1 != 0) {
                this.r = true;
            }
            paramg = android.support.v7.internal.view.a.a(this.e);
            if ((paramg.f()) || (i1 != 0)) {
                bool = true;
            }
            d(bool);
            i(paramg.d());
            a(this.g.getTitle());
            return;
            i1 = 0;
            break;
        }
    }

    private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        if (paramBoolean3) {
        }
        while ((!paramBoolean1) && (!paramBoolean2)) {
            return true;
        }
        return false;
    }

    private void i(boolean paramBoolean) {
        boolean bool = true;
        this.u = paramBoolean;
        int i1;
        label43:
        label62:
        ActionBarView localActionBarView;
        if (!this.u) {
            this.k.setEmbeddedTabView(null);
            this.i.setTabContainer(this.n);
            if (j() != 2) {
                break label110;
            }
            i1 = 1;
            if (this.n != null) {
                if (i1 == 0) {
                    break label115;
                }
                this.n.setVisibility(0);
            }
            localActionBarView = this.k;
            if ((this.u) || (i1 == 0)) {
                break label127;
            }
        }
        label110:
        label115:
        label127:
        for (paramBoolean = bool; ; paramBoolean = false) {
            localActionBarView.setCollapsable(paramBoolean);
            return;
            this.i.setTabContainer(null);
            this.k.setEmbeddedTabView(this.n);
            break;
            i1 = 0;
            break label43;
            this.n.setVisibility(8);
            break label62;
        }
    }

    private void j(boolean paramBoolean) {
        if (b(this.w, this.x, this.y)) {
            if (!this.z) {
                this.z = true;
                g(paramBoolean);
            }
        }
        while (!this.z) {
            return;
        }
        this.z = false;
        h(paramBoolean);
    }

    private void n() {
        if (this.n != null) {
            return;
        }
        ScrollingTabContainerView localScrollingTabContainerView = new ScrollingTabContainerView(this.e);
        if (this.u) {
            localScrollingTabContainerView.setVisibility(0);
            this.k.setEmbeddedTabView(localScrollingTabContainerView);
            this.n = localScrollingTabContainerView;
            return;
        }
        if (j() == 2) {
            localScrollingTabContainerView.setVisibility(0);
        }
        for (; ; ) {
            this.i.setTabContainer(localScrollingTabContainerView);
            break;
            localScrollingTabContainerView.setVisibility(8);
        }
    }

    public int a() {
        switch (this.k.getNavigationMode()) {
            default:
            case 2:
                do {
                    return -1;
                } while (this.p == null);
                return this.p.a();
        }
        return this.k.getDropdownSelectedPosition();
    }

    public android.support.v7.c.a a(android.support.v7.c.b paramb) {
        if (this.a != null) {
            this.a.b();
        }
        this.l.h();
        paramb = new t(this, paramb);
        if (paramb.d()) {
            paramb.c();
            this.l.a(paramb);
            e(true);
            if ((this.m != null) && (this.t == 1) && (this.m.getVisibility() != 0)) {
                this.m.setVisibility(0);
            }
            this.l.sendAccessibilityEvent(32);
            this.a = paramb;
            return paramb;
        }
        return null;
    }

    public void a(int paramInt) {
        a(LayoutInflater.from(i()).inflate(paramInt, this.k, false));
    }

    public void a(int paramInt1, int paramInt2) {
        int i1 = this.k.getDisplayOptions();
        if ((paramInt2 & 0x4) != 0) {
            this.r = true;
        }
        this.k.setDisplayOptions(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }

    public void a(Configuration paramConfiguration) {
        i(android.support.v7.internal.view.a.a(this.e).d());
    }

    public void a(e parame) {
        a(parame, this.o.isEmpty());
    }

    public void a(e parame, boolean paramBoolean) {
        n();
        this.n.a(parame, paramBoolean);
        a(parame, this.o.size());
        if (paramBoolean) {
            b(parame);
        }
    }

    public void a(View paramView) {
        this.k.setCustomNavigationView(paramView);
    }

    public void a(CharSequence paramCharSequence) {
        this.k.setTitle(paramCharSequence);
    }

    public void a(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i1 = 4; ; i1 = 0) {
            a(i1, 4);
            return;
        }
    }

    public View b() {
        return this.k.getCustomNavigationView();
    }

    public void b(int paramInt) {
        switch (this.k.getNavigationMode()) {
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            case 2:
                b((e) this.o.get(paramInt));
                return;
        }
        this.k.setDropdownSelectedPosition(paramInt);
    }

    public void b(e parame) {
        int i1 = -1;
        if (j() != 2) {
            if (parame != null) {
                i1 = parame.a();
            }
            this.q = i1;
        }
        for (; ; ) {
            return;
            ab localab = this.g.f().a().a();
            if (this.p == parame) {
                if (this.p != null) {
                    this.p.g().c(this.p, localab);
                    this.n.a(parame.a());
                }
            }
            while (!localab.e()) {
                localab.b();
                return;
                ScrollingTabContainerView localScrollingTabContainerView = this.n;
                if (parame != null) {
                    i1 = parame.a();
                }
                localScrollingTabContainerView.setTabSelected(i1);
                if (this.p != null) {
                    this.p.g().b(this.p, localab);
                }
                this.p = ((u) parame);
                if (this.p != null) {
                    this.p.g().a(this.p, localab);
                }
            }
        }
    }

    public void b(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i1 = 8; ; i1 = 0) {
            a(i1, 8);
            return;
        }
    }

    public CharSequence c() {
        return this.k.getTitle();
    }

    public void c(int paramInt) {
        boolean bool2 = false;
        switch (this.k.getNavigationMode()) {
            default:
                this.k.setNavigationMode(paramInt);
                switch (paramInt) {
                }
                break;
        }
        for (; ; ) {
            ActionBarView localActionBarView = this.k;
            boolean bool1 = bool2;
            if (paramInt == 2) {
                bool1 = bool2;
                if (!this.u) {
                    bool1 = true;
                }
            }
            localActionBarView.setCollapsable(bool1);
            return;
            this.q = a();
            b(null);
            this.n.setVisibility(8);
            break;
            n();
            this.n.setVisibility(0);
            if (this.q != -1) {
                b(this.q);
                this.q = -1;
            }
        }
    }

    public void c(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i1 = 16; ; i1 = 0) {
            a(i1, 16);
            return;
        }
    }

    public int d() {
        return this.k.getDisplayOptions();
    }

    public void d(boolean paramBoolean) {
        this.k.setHomeButtonEnabled(paramBoolean);
    }

    public e e() {
        return new u(this);
    }

    void e(boolean paramBoolean) {
        int i2 = 8;
        Object localObject;
        if (paramBoolean) {
            k();
            localObject = this.k;
            if (!paramBoolean) {
                break label100;
            }
            i1 = 4;
            label23:
            ((ActionBarView) localObject).a(i1);
            localObject = this.l;
            if (!paramBoolean) {
                break label105;
            }
            i1 = 0;
            label41:
            ((ActionBarContextView) localObject).a(i1);
            if ((this.n != null) && (!this.k.j()) && (this.k.m())) {
                localObject = this.n;
                if (!paramBoolean) {
                    break label111;
                }
            }
        }
        label100:
        label105:
        label111:
        for (int i1 = i2; ; i1 = 0) {
            ((ScrollingTabContainerView) localObject).setVisibility(i1);
            return;
            l();
            break;
            i1 = 0;
            break label23;
            i1 = 8;
            break label41;
        }
    }

    public void f() {
        if (this.w) {
            this.w = false;
            j(false);
        }
    }

    public void f(boolean paramBoolean) {
        this.A = paramBoolean;
        if (!paramBoolean) {
            this.j.clearAnimation();
            if (this.m != null) {
                this.m.clearAnimation();
            }
        }
    }

    public void g() {
        if (!this.w) {
            this.w = true;
            j(false);
        }
    }

    public void g(boolean paramBoolean) {
        this.j.clearAnimation();
        if (this.j.getVisibility() == 0) {
            return;
        }
        if ((m()) || (paramBoolean)) {
        }
        for (int i1 = 1; ; i1 = 0) {
            Animation localAnimation;
            if (i1 != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.e, android.support.v7.b.b.abc_slide_in_top);
                this.j.startAnimation(localAnimation);
            }
            this.j.setVisibility(0);
            if ((this.m == null) || (this.m.getVisibility() == 0)) {
                break;
            }
            if (i1 != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.e, android.support.v7.b.b.abc_slide_in_bottom);
                this.m.startAnimation(localAnimation);
            }
            this.m.setVisibility(0);
            return;
        }
    }

    public void h(boolean paramBoolean) {
        this.j.clearAnimation();
        if (this.j.getVisibility() == 8) {
            return;
        }
        if ((m()) || (paramBoolean)) {
        }
        for (int i1 = 1; ; i1 = 0) {
            Animation localAnimation;
            if (i1 != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.e, android.support.v7.b.b.abc_slide_out_top);
                this.j.startAnimation(localAnimation);
            }
            this.j.setVisibility(8);
            if ((this.m == null) || (this.m.getVisibility() == 8)) {
                break;
            }
            if (i1 != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.e, android.support.v7.b.b.abc_slide_out_bottom);
                this.m.startAnimation(localAnimation);
            }
            this.m.setVisibility(8);
            return;
        }
    }

    public boolean h() {
        return this.z;
    }

    public Context i() {
        int i1;
        if (this.f == null) {
            TypedValue localTypedValue = new TypedValue();
            this.e.getTheme().resolveAttribute(c.actionBarWidgetTheme, localTypedValue, true);
            i1 = localTypedValue.resourceId;
            if (i1 == 0) {
                break label61;
            }
        }
        label61:
        for (this.f = new ContextThemeWrapper(this.e, i1); ; this.f = this.e) {
            return this.f;
        }
    }

    public int j() {
        return this.k.getNavigationMode();
    }

    void k() {
        if (!this.y) {
            this.y = true;
            j(false);
        }
    }

    void l() {
        if (this.y) {
            this.y = false;
            j(false);
        }
    }

    boolean m() {
        return this.A;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
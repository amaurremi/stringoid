package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.b.c;
import android.support.v7.b.d;
import android.support.v7.b.f;
import android.support.v7.b.j;
import android.support.v7.c.b;
import android.support.v7.internal.view.menu.ah;
import android.support.v7.internal.view.menu.ai;
import android.support.v7.internal.view.menu.ak;
import android.support.v7.internal.view.menu.o;
import android.support.v7.internal.view.menu.q;
import android.support.v7.internal.view.menu.r;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

class k
        extends h
        implements ah, r {
    private static final int[] d = {c.homeAsUpIndicator};
    private ActionBarView e;
    private o f;
    private q g;
    private android.support.v7.c.a h;
    private boolean i;
    private CharSequence j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private Bundle p;

    k(g paramg) {
        super(paramg);
    }

    private ai a(Context paramContext, ah paramah) {
        if (this.g == null) {
            return null;
        }
        if (this.f == null) {
            TypedArray localTypedArray = paramContext.obtainStyledAttributes(android.support.v7.b.k.Theme);
            int i1 = localTypedArray.getResourceId(4, j.Theme_AppCompat_CompactMenu);
            localTypedArray.recycle();
            this.f = new o(android.support.v7.b.h.abc_list_menu_item_layout, i1);
            this.f.a(paramah);
            this.g.a(this.f);
        }
        for (; ; ) {
            return this.f.a(new FrameLayout(paramContext));
            this.f.c(false);
        }
    }

    private void b(q paramq, boolean paramBoolean) {
        if ((this.e != null) && (this.e.e())) {
            if ((!this.e.d()) || (!paramBoolean)) {
                if (this.e.getVisibility() == 0) {
                    this.e.a();
                }
                return;
            }
            this.e.c();
            return;
        }
        paramq.close();
    }

    private void l() {
        Object localObject2 = null;
        DisplayMetrics localDisplayMetrics = null;
        TypedArray localTypedArray = this.a.obtainStyledAttributes(android.support.v7.b.k.ActionBarWindow);
        TypedValue localTypedValue1;
        if (localTypedArray.hasValue(3)) {
            if (0 == 0) {
                localTypedValue1 = new TypedValue();
                localTypedArray.getValue(3, localTypedValue1);
            }
        }
        for (; ; ) {
            TypedValue localTypedValue2;
            if (localTypedArray.hasValue(5)) {
                if (0 == 0) {
                    localTypedValue2 = new TypedValue();
                    localTypedArray.getValue(5, localTypedValue2);
                }
            }
            for (; ; ) {
                Object localObject1;
                if (localTypedArray.hasValue(6)) {
                    if (0 == 0) {
                        localObject1 = new TypedValue();
                        localTypedArray.getValue(6, (TypedValue) localObject1);
                    }
                }
                for (; ; ) {
                    if (localTypedArray.hasValue(4)) {
                        localObject2 = localDisplayMetrics;
                        if (0 == 0) {
                            localObject2 = new TypedValue();
                        }
                        localTypedArray.getValue(4, (TypedValue) localObject2);
                    }
                    localDisplayMetrics = this.a.getResources().getDisplayMetrics();
                    int i2;
                    label177:
                    int i1;
                    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {
                        i2 = 1;
                        if (i2 == 0) {
                            break label276;
                        }
                        if ((localTypedValue2 == null) || (localTypedValue2.type == 0)) {
                            break label358;
                        }
                        if (localTypedValue2.type != 5) {
                            break label282;
                        }
                        i1 = (int) localTypedValue2.getDimension(localDisplayMetrics);
                    }
                    for (; ; ) {
                        label208:
                        if (i2 != 0) {
                            label212:
                            if ((localObject1 == null) || (((TypedValue) localObject1).type == 0)) {
                                break label353;
                            }
                            if (((TypedValue) localObject1).type != 5) {
                                break label321;
                            }
                            i2 = (int) ((TypedValue) localObject1).getDimension(localDisplayMetrics);
                        }
                        for (; ; ) {
                            if ((i1 != -1) || (i2 != -1)) {
                                this.a.getWindow().setLayout(i1, i2);
                            }
                            localTypedArray.recycle();
                            return;
                            i2 = 0;
                            break;
                            label276:
                            localTypedValue2 = localTypedValue1;
                            break label177;
                            label282:
                            if (localTypedValue2.type != 6) {
                                break label358;
                            }
                            i1 = (int) localTypedValue2.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
                            break label208;
                            localObject1 = localObject2;
                            break label212;
                            label321:
                            if (((TypedValue) localObject1).type == 6) {
                                i2 = (int) ((TypedValue) localObject1).getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
                            } else {
                                label353:
                                i2 = -1;
                            }
                        }
                        label358:
                        i1 = -1;
                    }
                    localObject1 = null;
                    break;
                    localObject1 = null;
                }
                localTypedValue2 = null;
                break;
                localTypedValue2 = null;
            }
            localTypedValue1 = null;
            break;
            localTypedValue1 = null;
        }
    }

    private boolean m() {
        this.g = new q(j());
        this.g.a(this);
        return true;
    }

    private boolean n() {
        if (this.n) {
            return true;
        }
        if ((this.g == null) || (this.o)) {
            if ((this.g == null) && ((!m()) || (this.g == null))) {
                return false;
            }
            if (this.e != null) {
                this.e.a(this.g, this);
            }
            this.g.g();
            if (!this.a.a(0, this.g)) {
                this.g = null;
                if (this.e != null) {
                    this.e.a(null, this);
                }
                return false;
            }
            this.o = false;
        }
        this.g.g();
        if (this.p != null) {
            this.g.b(this.p);
            this.p = null;
        }
        if (!this.a.a(0, null, this.g)) {
            if (this.e != null) {
                this.e.a(null, this);
            }
            this.g.h();
            return false;
        }
        this.g.h();
        this.n = true;
        return true;
    }

    public a a() {
        k();
        return new s(this.a, this.a);
    }

    public android.support.v7.c.a a(b paramb) {
        if (paramb == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.h != null) {
            this.h.b();
        }
        paramb = new m(this, paramb);
        s locals = (s) b();
        if (locals != null) {
            this.h = locals.a(paramb);
        }
        if (this.h != null) {
            this.a.a(this.h);
        }
        return this.h;
    }

    public void a(int paramInt) {
        k();
        ViewGroup localViewGroup = (ViewGroup) this.a.findViewById(16908290);
        localViewGroup.removeAllViews();
        this.a.getLayoutInflater().inflate(paramInt, localViewGroup);
        this.a.j();
    }

    public void a(Configuration paramConfiguration) {
        if ((this.b) && (this.i)) {
            ((s) b()).a(paramConfiguration);
        }
    }

    public void a(q paramq) {
        b(paramq, true);
    }

    public void a(q paramq, boolean paramBoolean) {
        if (this.m) {
            return;
        }
        this.m = true;
        this.a.closeOptionsMenu();
        this.e.f();
        this.m = false;
    }

    public void a(View paramView) {
        k();
        ViewGroup localViewGroup = (ViewGroup) this.a.findViewById(16908290);
        localViewGroup.removeAllViews();
        localViewGroup.addView(paramView);
        this.a.j();
    }

    public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        k();
        ViewGroup localViewGroup = (ViewGroup) this.a.findViewById(16908290);
        localViewGroup.removeAllViews();
        localViewGroup.addView(paramView, paramLayoutParams);
        this.a.j();
    }

    public void a(CharSequence paramCharSequence) {
        if (this.e != null) {
            this.e.setWindowTitle(paramCharSequence);
            return;
        }
        this.j = paramCharSequence;
    }

    public boolean a(int paramInt, Menu paramMenu) {
        if (paramInt != 0) {
            return this.a.a(paramInt, paramMenu);
        }
        return false;
    }

    public boolean a(int paramInt, MenuItem paramMenuItem) {
        MenuItem localMenuItem = paramMenuItem;
        if (paramInt == 0) {
            localMenuItem = ak.a(paramMenuItem);
        }
        return this.a.a(paramInt, localMenuItem);
    }

    public boolean a(int paramInt, View paramView, Menu paramMenu) {
        if (paramInt != 0) {
            return this.a.a(paramInt, paramView, paramMenu);
        }
        return false;
    }

    public boolean a(q paramq, MenuItem paramMenuItem) {
        return this.a.onMenuItemSelected(0, paramMenuItem);
    }

    public View b(int paramInt) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramInt == 0) {
            localObject1 = localObject2;
            if (n()) {
                localObject1 = (View) a(this.a, this);
            }
        }
        return (View) localObject1;
    }

    public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        k();
        ((ViewGroup) this.a.findViewById(16908290)).addView(paramView, paramLayoutParams);
        this.a.j();
    }

    public boolean b(q paramq) {
        return false;
    }

    public void d() {
        s locals = (s) b();
        if (locals != null) {
            locals.f(false);
        }
    }

    public void e() {
        s locals = (s) b();
        if (locals != null) {
            locals.f(true);
        }
    }

    public void f() {
        if (this.g != null) {
            Bundle localBundle = new Bundle();
            this.g.a(localBundle);
            if (localBundle.size() > 0) {
                this.p = localBundle;
            }
            this.g.g();
            this.g.clear();
        }
        this.o = true;
        if (this.e != null) {
            this.n = false;
            n();
        }
    }

    public boolean g() {
        if (this.h != null) {
            this.h.b();
            return true;
        }
        if ((this.e != null) && (this.e.k())) {
            this.e.l();
            return true;
        }
        return false;
    }

    public void h() {
    }

    final void k() {
        boolean bool1;
        label116:
        Object localObject;
        if (!this.i) {
            if (!this.b) {
                break label312;
            }
            if (!this.c) {
                break label274;
            }
            this.a.a_(android.support.v7.b.h.abc_action_bar_decor_overlay);
            this.e = ((ActionBarView) this.a.findViewById(f.action_bar));
            this.e.setWindowCallback(this.a);
            if (this.k) {
                this.e.g();
            }
            if (this.l) {
                this.e.h();
            }
            boolean bool2 = "splitActionBarWhenNarrow".equals(i());
            if (!bool2) {
                break label287;
            }
            bool1 = this.a.getResources().getBoolean(d.abc_split_action_bar_is_narrow);
            localObject = (ActionBarContainer) this.a.findViewById(f.split_action_bar);
            if (localObject != null) {
                this.e.setSplitView((ActionBarContainer) localObject);
                this.e.setSplitActionBar(bool1);
                this.e.setSplitWhenNarrow(bool2);
                ActionBarContextView localActionBarContextView = (ActionBarContextView) this.a.findViewById(f.action_context_bar);
                localActionBarContextView.setSplitView((ActionBarContainer) localObject);
                localActionBarContextView.setSplitActionBar(bool1);
                localActionBarContextView.setSplitWhenNarrow(bool2);
            }
        }
        for (; ; ) {
            this.a.findViewById(16908290).setId(-1);
            this.a.findViewById(f.action_bar_activity_content).setId(16908290);
            if (this.j != null) {
                this.e.setWindowTitle(this.j);
                this.j = null;
            }
            l();
            this.i = true;
            this.a.getWindow().getDecorView().post(new l(this));
            return;
            label274:
            this.a.a_(android.support.v7.b.h.abc_action_bar_decor);
            break;
            label287:
            localObject = this.a.obtainStyledAttributes(android.support.v7.b.k.ActionBarWindow);
            bool1 = ((TypedArray) localObject).getBoolean(2, false);
            ((TypedArray) localObject).recycle();
            break label116;
            label312:
            this.a.a_(android.support.v7.b.h.abc_simple_decor);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
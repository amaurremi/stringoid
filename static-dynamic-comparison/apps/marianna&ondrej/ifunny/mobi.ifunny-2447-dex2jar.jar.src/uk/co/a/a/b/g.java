package uk.co.a.a.b;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import java.util.WeakHashMap;

import uk.co.a.a.b.a.b;

public class g {
    private c a;
    private d b;
    private b c;
    private Activity d;
    private View e;
    private uk.co.a.a.b.a.a f;
    private final int g;
    private final float h;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private boolean m;
    private boolean n;
    private final WeakHashMap o;
    private final boolean p;
    private final int q;
    private final boolean r;
    private boolean s = false;
    private final int[] t = new int[2];
    private final Rect u = new Rect();
    private Handler v;
    private Runnable w = new h(this);
    private final Runnable x = new j(this);

    public g(Activity paramActivity, e parame) {
        if (paramActivity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        e locale = parame;
        if (parame == null) {
            Log.i("PullToRefreshAttacher", "Given null options so using default options.");
            locale = new e();
        }
        this.d = paramActivity;
        this.o = new WeakHashMap();
        this.h = locale.d;
        this.p = locale.e;
        this.q = locale.f;
        this.r = locale.g;
        if (locale.a != null) {
            parame = locale.a;
            this.a = parame;
            if (locale.c == null) {
                break label242;
            }
        }
        label242:
        for (parame = locale.c; ; parame = b()) {
            this.b = parame;
            this.g = ViewConfiguration.get(paramActivity).getScaledTouchSlop();
            parame = (ViewGroup) paramActivity.getWindow().getDecorView();
            this.e = LayoutInflater.from(this.a.a(paramActivity)).inflate(locale.b, parame, false);
            if (this.e != null) {
                break label250;
            }
            throw new IllegalArgumentException("Must supply valid layout id for header.");
            parame = a();
            break;
        }
        label250:
        this.e.setVisibility(4);
        this.b.a(paramActivity, this.e);
        this.v = new Handler(Looper.getMainLooper());
        this.w.run();
    }

    private void a(View paramView, boolean paramBoolean) {
        this.m = true;
        if (this.c != null) {
            this.c.onRefreshStarted(paramView);
        }
        this.b.f();
        j();
        if (this.r) {
            if (this.q > 0) {
                g().postDelayed(this.x, this.q);
            }
        } else {
            return;
        }
        g().post(this.x);
    }

    private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2) {
        if (o()) {
        }
        while ((g() == null) || (this.m == paramBoolean1)) {
            return;
        }
        i();
        if ((paramBoolean1) && (b(paramBoolean2))) {
            a(paramView, paramBoolean2);
            return;
        }
        c(paramBoolean2);
    }

    private boolean b(boolean paramBoolean) {
        return (!this.m) && ((!paramBoolean) || (this.c != null));
    }

    private void c(boolean paramBoolean) {
        this.m = false;
        if (this.r) {
            g().removeCallbacks(this.x);
        }
        k();
    }

    private boolean m() {
        if (o()) {
        }
        View localView;
        do {
            return false;
            localView = n();
        } while ((localView == null) || (localView.getWindowToken() == null));
        return true;
    }

    private View n() {
        if (o()) {
        }
        Window localWindow;
        do {
            do {
                return null;
            } while (this.d == null);
            localWindow = this.d.getWindow();
        } while (localWindow == null);
        return localWindow.getDecorView();
    }

    private boolean o() {
        if (this.s) {
            Log.i("PullToRefreshAttacher", "PullToRefreshAttacher is destroyed.");
        }
        return this.s;
    }

    protected c a() {
        return new i(this);
    }

    protected void a(View paramView) {
        if ((this.d == null) || (this.d.getWindow() == null)) {
            return;
        }
        this.d.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.u);
        int i1 = -1;
        int i2 = -2;
        Object localObject = paramView.getLayoutParams();
        if (localObject != null) {
            i1 = ((ViewGroup.LayoutParams) localObject).width;
            i2 = ((ViewGroup.LayoutParams) localObject).height;
        }
        localObject = new WindowManager.LayoutParams(i1, i2, 1000, 280, -3);
        ((WindowManager.LayoutParams) localObject).x = 0;
        ((WindowManager.LayoutParams) localObject).y = this.u.top;
        ((WindowManager.LayoutParams) localObject).gravity = 48;
        paramView.setTag(localObject);
        this.d.getWindowManager().addView(paramView, (ViewGroup.LayoutParams) localObject);
    }

    public void a(b paramb) {
        this.c = paramb;
    }

    public final void a(boolean paramBoolean) {
        a(null, paramBoolean, false);
    }

    protected d b() {
        return new a();
    }

    protected void b(View paramView) {
        this.d.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.u);
        WindowManager.LayoutParams localLayoutParams = null;
        if ((paramView.getLayoutParams() instanceof WindowManager.LayoutParams)) {
            localLayoutParams = (WindowManager.LayoutParams) paramView.getLayoutParams();
        }
        for (; ; ) {
            if ((localLayoutParams != null) && (localLayoutParams.y != this.u.top)) {
                localLayoutParams.y = this.u.top;
                this.d.getWindowManager().updateViewLayout(paramView, localLayoutParams);
            }
            return;
            if ((paramView.getTag() instanceof WindowManager.LayoutParams)) {
                localLayoutParams = (WindowManager.LayoutParams) paramView.getTag();
            }
        }
    }

    void c() {
        this.o.clear();
    }

    protected void c(View paramView) {
        this.v.removeCallbacks(this.w);
        if (paramView.getWindowToken() != null) {
            this.d.getWindowManager().removeViewImmediate(paramView);
        }
    }

    public final void d() {
        a(null, false, false);
    }

    public b e() {
        return this.c;
    }

    public void f() {
        if (this.s) {
            return;
        }
        c(this.e);
        c();
        this.v.removeCallbacks(this.w);
        this.v = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.b = null;
        this.s = true;
    }

    final View g() {
        return this.e;
    }

    void h() {
        if (o()) {
        }
        do {
            return;
            this.b.c();
        } while (this.f == null);
        this.f.a(this.e, 1);
    }

    void i() {
        this.l = false;
        this.n = false;
        this.k = -1.0F;
        this.j = -1.0F;
        this.i = -1.0F;
    }

    void j() {
        b(this.e);
        if ((this.b.a()) && (this.f != null)) {
            this.f.a(this.e, 0);
        }
    }

    void k() {
        if ((this.b.b()) && (this.f != null)) {
            this.f.a(this.e, 2);
        }
    }

    protected final Activity l() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
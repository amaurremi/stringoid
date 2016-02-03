package com.amazon.device.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class al
        extends FrameLayout
        implements aa {
    private static ScheduledThreadPoolExecutor p = new ScheduledThreadPoolExecutor(1);
    private BroadcastReceiver a;
    private boolean b;
    private Context c;
    private bn d;
    private dj e;
    private boolean f = false;
    private boolean g = false;
    private int h = 8;
    private AtomicBoolean i = new AtomicBoolean(false);
    private az j = null;
    private boolean k = false;
    private View l = null;
    private boolean m = false;
    private long n = 0L;
    private boolean o;

    static {
        p.setKeepAliveTime(60L, TimeUnit.SECONDS);
    }

    public al(Activity paramActivity, bn parambn) {
        super(paramActivity);
        a(paramActivity, parambn);
    }

    private void a(Context paramContext, bn parambn) {
        dn.i().a(paramContext);
        bn localbn = parambn;
        if (parambn == null) {
            localbn = bn.g;
        }
        this.d = localbn;
        this.c = paramContext;
        if (isInEditMode()) {
            paramContext = new TextView(this.c);
            paramContext.setText("AdLayout");
            paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            paramContext.setGravity(17);
            addView(paramContext);
            return;
        }
        if (getVisibility() == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.b = bool;
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            if (!a(this.c)) {
                break;
            }
            dv.c(true, "AdLayout", "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        if (this.e == null) {
            this.e = a(this.d, this.c);
        }
        this.m = bs.a(this.c);
    }

    private void d(az paramaz) {
        if (getLayoutParams() == null) {
            dy.a().b().a(eb.G);
            a("Can't load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.");
            return;
        }
        if (hu.a(11)) {
            g();
            if (i()) {
                a("Ad load failed because root view could not be obtained from the activity.");
                return;
            }
            if (h()) {
                b(paramaz);
                setOnLayoutChangeListenerForRoot(paramaz);
                return;
            }
            b();
            c(paramaz);
            return;
        }
        b();
        c(paramaz);
    }

    private void k() {
        if (this.f == true) {
            return;
        }
        this.f = true;
        this.a = new am(this);
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        this.c.getApplicationContext().registerReceiver(this.a, localIntentFilter);
    }

    private void l() {
        if (this.f) {
            this.f = false;
            this.c.getApplicationContext().unregisterReceiver(this.a);
        }
    }

    int a(az paramaz) {
        this.n = System.nanoTime();
        if ((this.e.c()) || (this.i.get())) {
            dv.c("AdLayout", "Can't load an ad because ad loading is already in progress");
            return -1;
        }
        if (this.e.f()) {
            dv.c("AdLayout", "Can't load an ad because another ad is currently expanded");
            return -1;
        }
        if (!this.m) {
            a("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
            return 1;
        }
        if (!c(this.c)) {
            a("Ads cannot load because the INTERNET permission is missing from the app's manifest.");
            return 1;
        }
        if (dn.i().c().e() == null) {
            a("Can't load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?");
            return 1;
        }
        if (!b(this.c)) {
            dy.a().b().a(eb.F);
            a("We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView.");
            return 1;
        }
        if (this.d.a()) {
            dv.b("AdLayout", "Ad size to be determined automatically.");
        }
        f();
        if ((isLayoutRequested()) && (this.d.a()) && (!e())) {
            b(paramaz);
        }
        for (; ; ) {
            return 0;
            if (e()) {
                d(paramaz);
            } else {
                c(paramaz);
            }
        }
    }

    int a(boolean paramBoolean) {
        int i1;
        int i2;
        if (paramBoolean) {
            i1 = getLayoutParams().width;
            if (i1 != -1) {
                break label49;
            }
            if (!i()) {
                break label43;
            }
            i2 = b(paramBoolean);
        }
        label43:
        label49:
        do {
            return i2;
            i1 = getLayoutParams().height;
            break;
            return c(paramBoolean);
            i2 = i1;
        } while (i1 != -2);
        return 0;
    }

    dj a(bn parambn, Context paramContext) {
        return new ab(this, parambn, paramContext);
    }

    void a(String paramString) {
        dv.c("AdLayout", paramString);
        ((dk) this.e).a(new aj(ak.e, paramString));
    }

    boolean a() {
        return this.o;
    }

    boolean a(Context paramContext) {
        return WebViewDatabase.getInstance(paramContext) == null;
    }

    public boolean a(br parambr) {
        br localbr = parambr;
        if (parambr == null) {
            localbr = new br();
        }
        return as.a(this.e.e(), localbr, new bq[]{new bq(this, localbr)})[0];
    }

    int b(boolean paramBoolean) {
        WindowManager localWindowManager = (WindowManager) this.c.getSystemService("window");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (paramBoolean) {
            return localDisplayMetrics.widthPixels;
        }
        return localDisplayMetrics.heightPixels;
    }

    void b() {
        int i1 = a(true);
        int i2 = a(false);
        this.e.a(i1, i2);
    }

    void b(az paramaz) {
        this.i.set(true);
        this.j = paramaz;
        c();
    }

    boolean b(Context paramContext) {
        return ig.b(paramContext);
    }

    int c(boolean paramBoolean) {
        if (paramBoolean) {
            return this.l.getWidth();
        }
        return this.l.getHeight();
    }

    void c() {
        an localan = new an(this);
        p.schedule(localan, getTimeout(), TimeUnit.MILLISECONDS);
    }

    void c(az paramaz) {
        this.e.a(this.n);
        paramaz.a(this);
    }

    protected boolean c(Context paramContext) {
        return go.a().a(paramContext);
    }

    void d() {
        if (this.i.getAndSet(false)) {
            dy.a().b().a(eb.H);
            a("Can't load an ad because the view size cannot be determined.");
        }
    }

    boolean e() {
        return this.k;
    }

    void f() {
        if (getParent() == null) {
        }
        for (boolean bool = true; ; bool = false) {
            this.k = bool;
            return;
        }
    }

    void g() {
        this.l = ((Activity) this.c).getWindow().getDecorView().findViewById(16908290).getRootView();
    }

    View getActivityRootView() {
        return this.l;
    }

    ab getAdController() {
        return (ab) this.e;
    }

    public bn getAdSize() {
        return this.d;
    }

    boolean getNeedsToLoadAdOnLayout() {
        return this.i.get();
    }

    public int getTimeout() {
        return this.e.e();
    }

    boolean h() {
        return this.l.isLayoutRequested();
    }

    boolean i() {
        return this.l == null;
    }

    public void j() {
        dv.b("AdLayout", "Destroying the AdLayout");
        l();
        this.e.k();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.g = true;
        k();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
        l();
        this.e.j();
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (isInEditMode()) {
        }
        do {
            return;
            this.e.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
        } while (!this.i.getAndSet(false));
        c(this.j);
        this.j = null;
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        if ((this.g) && (this.h != paramInt)) {
            if (paramInt == 0) {
                break label29;
            }
            this.b = false;
            l();
        }
        label29:
        while (paramInt != 0) {
            return;
        }
        this.b = true;
    }

    void setIsParentViewMissingAtLoadTime(boolean paramBoolean) {
        this.k = paramBoolean;
    }

    public void setListener(ar paramar) {
        this.e.a(paramar);
    }

    void setNeedsToLoadAdOnLayout(boolean paramBoolean) {
        this.i.set(paramBoolean);
    }

    void setOnLayoutChangeListenerForRoot(az paramaz) {
        ao.a(this, paramaz);
    }

    void setShouldDisableWebViewHardwareAcceleration(boolean paramBoolean) {
        this.o = paramBoolean;
    }

    public void setTimeout(int paramInt) {
        this.e.a(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
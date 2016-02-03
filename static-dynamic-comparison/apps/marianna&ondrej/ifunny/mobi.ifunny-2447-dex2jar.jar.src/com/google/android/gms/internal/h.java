package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ii
public final class h
        implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long m = TimeUnit.MILLISECONDS.toNanos(100L);
    private final Object a = new Object();
    private final WeakReference<lc> b;
    private WeakReference<ViewTreeObserver> c;
    private final WeakReference<View> d;
    private final f e;
    private final Context f;
    private final q g;
    private boolean h;
    private final WindowManager i;
    private final PowerManager j;
    private final KeyguardManager k;
    private p l;
    private boolean n = false;
    private boolean o = false;
    private final BlockingQueue<Runnable> p = new ArrayBlockingQueue(2);
    private long q = Long.MIN_VALUE;
    private boolean r;
    private boolean s;
    private BroadcastReceiver t;
    private final HashSet<e> u = new HashSet();

    public h(Context paramContext, ay paramay, lc paramlc, View paramView, gt paramgt) {
        this(paramay, paramlc, paramgt, paramView, new v(paramContext, paramgt));
    }

    public h(ay paramay, lc paramlc, gt paramgt, View paramView, q paramq) {
        this.b = new WeakReference(paramlc);
        this.d = new WeakReference(paramView);
        this.c = new WeakReference(null);
        this.r = true;
        this.e = new f(UUID.randomUUID().toString(), paramgt, paramay.b, paramlc.j);
        this.g = paramq;
        this.i = ((WindowManager) paramView.getContext().getSystemService("window"));
        this.j = ((PowerManager) paramView.getContext().getApplicationContext().getSystemService("power"));
        this.k = ((KeyguardManager) paramView.getContext().getSystemService("keyguard"));
        this.f = paramView.getContext().getApplicationContext();
        a(paramq);
        this.g.a(new i(this, paramView));
        b(this.g);
        try {
            paramay = b(paramView);
            this.p.add(new j(this, paramay));
            this.p.add(new k(this));
            mx.a("Tracking ad unit: " + this.e.d());
            return;
        } catch (Throwable paramay) {
            for (; ; ) {
            }
        }
    }

    protected int a(int paramInt, DisplayMetrics paramDisplayMetrics) {
        float f1 = paramDisplayMetrics.density;
        return (int) (paramInt / f1);
    }

    protected void a() {
        synchronized (this.a) {
            if (this.t != null) {
                return;
            }
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.intent.action.SCREEN_ON");
            localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.t = new l(this);
            this.f.registerReceiver(this.t, localIntentFilter);
            return;
        }
    }

    protected void a(View paramView) {
        paramView = new ArrayList();
        this.p.drainTo(paramView);
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
            ((Runnable) paramView.next()).run();
        }
    }

    protected void a(View paramView, Map<String, String> paramMap) {
        b(false);
    }

    public void a(e parame) {
        this.u.add(parame);
    }

    public void a(p paramp) {
        synchronized (this.a) {
            this.l = paramp;
            return;
        }
    }

    protected void a(q paramq) {
        paramq.a("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected void a(JSONObject paramJSONObject) {
        try {
            JSONArray localJSONArray = new JSONArray();
            JSONObject localJSONObject = new JSONObject();
            localJSONArray.put(paramJSONObject);
            localJSONObject.put("units", localJSONArray);
            this.g.a("AFMA_updateActiveView", localJSONObject);
            return;
        } catch (Throwable paramJSONObject) {
            mx.b("Skipping active view message.", paramJSONObject);
        }
    }

    protected void a(boolean paramBoolean) {
        Iterator localIterator = this.u.iterator();
        while (localIterator.hasNext()) {
            ((e) localIterator.next()).a(this, paramBoolean);
        }
    }

    protected boolean a(Map<String, String> paramMap) {
        if (paramMap == null) {
            return false;
        }
        paramMap = (String) paramMap.get("hashCode");
        if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(this.e.d()))) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    protected JSONObject b(View paramView) {
        Object localObject2 = new int[2];
        Object localObject1 = new int[2];
        paramView.getLocationOnScreen((int[]) localObject2);
        paramView.getLocationInWindow((int[]) localObject1);
        localObject1 = i();
        DisplayMetrics localDisplayMetrics = paramView.getContext().getResources().getDisplayMetrics();
        Rect localRect1 = new Rect();
        localRect1.left = localObject2[0];
        localRect1.top = localObject2[1];
        localRect1.right = (localRect1.left + paramView.getWidth());
        localRect1.bottom = (localRect1.top + paramView.getHeight());
        localObject2 = new Rect();
        ((Rect) localObject2).right = this.i.getDefaultDisplay().getWidth();
        ((Rect) localObject2).bottom = this.i.getDefaultDisplay().getHeight();
        Rect localRect2 = new Rect();
        boolean bool1 = paramView.getGlobalVisibleRect(localRect2, null);
        Rect localRect3 = new Rect();
        boolean bool2 = paramView.getLocalVisibleRect(localRect3);
        ((JSONObject) localObject1).put("viewBox", new JSONObject().put("top", a(((Rect) localObject2).top, localDisplayMetrics)).put("bottom", a(((Rect) localObject2).bottom, localDisplayMetrics)).put("left", a(((Rect) localObject2).left, localDisplayMetrics)).put("right", a(((Rect) localObject2).right, localDisplayMetrics))).put("adBox", new JSONObject().put("top", a(localRect1.top, localDisplayMetrics)).put("bottom", a(localRect1.bottom, localDisplayMetrics)).put("left", a(localRect1.left, localDisplayMetrics)).put("right", a(localRect1.right, localDisplayMetrics))).put("globalVisibleBox", new JSONObject().put("top", a(localRect2.top, localDisplayMetrics)).put("bottom", a(localRect2.bottom, localDisplayMetrics)).put("left", a(localRect2.left, localDisplayMetrics)).put("right", a(localRect2.right, localDisplayMetrics))).put("globalVisibleBoxVisible", bool1).put("localVisibleBox", new JSONObject().put("top", a(localRect3.top, localDisplayMetrics)).put("bottom", a(localRect3.bottom, localDisplayMetrics)).put("left", a(localRect3.left, localDisplayMetrics)).put("right", a(localRect3.right, localDisplayMetrics))).put("localVisibleBoxVisible", bool2).put("screenDensity", localDisplayMetrics.density).put("isVisible", c(paramView)).put("isStopped", this.o).put("isPaused", this.n);
        return (JSONObject) localObject1;
    }

    protected void b() {
        synchronized (this.a) {
            if (this.t != null) {
                this.f.unregisterReceiver(this.t);
                this.t = null;
            }
            return;
        }
    }

    protected void b(q paramq) {
        paramq.a("/updateActiveView", new m(this));
        paramq.a("/untrackActiveViewUnit", new n(this));
        paramq.a("/visibilityChanged", new o(this));
        paramq.a("/viewabilityChanged", cg.a);
    }

    protected void b(boolean paramBoolean) {
        long l1;
        synchronized (this.a) {
            if ((!this.h) || (!this.r)) {
                return;
            }
            l1 = System.nanoTime();
            if ((paramBoolean) && (this.q + m > l1)) {
                return;
            }
        }
        this.q = l1;
        lc locallc = (lc) this.b.get();
        View localView = (View) this.d.get();
        if (localView != null) {
            if (locallc == null) {
                break label154;
            }
        }
        for (; ; ) {
            int i1;
            if (i1 != 0) {
                d();
                return;
                i1 = 0;
            } else {
                try {
                    a(b(localView));
                    g();
                    e();
                    return;
                } catch (JSONException localJSONException) {
                    for (; ; ) {
                        mx.a("Active view update failed.", localJSONException);
                    }
                }
                label154:
                i1 = 1;
            }
        }
    }

    protected void c() {
        synchronized (this.a) {
            h();
            b();
            this.r = false;
        }
        try {
            this.g.c();
            e();
            return;
            localObject2 =finally;
            throw ((Throwable) localObject2);
        } catch (Throwable localThrowable) {
            for (; ; ) {
            }
        }
    }

    protected boolean c(View paramView) {
        return (paramView.getVisibility() == 0) && (paramView.isShown()) && (this.j.isScreenOn()) && (!this.k.inKeyguardRestrictedInputMode());
    }

    public void d() {
        synchronized (this.a) {
            if (this.r) {
                this.s = true;
            }
            try {
                a(j());
                mx.a("Untracking ad unit: " + this.e.d());
                return;
            } catch (JSONException localJSONException) {
                for (; ; ) {
                    mx.b("JSON Failure while processing active view data.", localJSONException);
                }
            }
        }
    }

    protected void e() {
        if (this.l != null) {
            this.l.a(this);
        }
    }

    public boolean f() {
        synchronized (this.a) {
            boolean bool = this.r;
            return bool;
        }
    }

    protected void g() {
        Object localObject = (View) this.d.get();
        if (localObject == null) {
        }
        ViewTreeObserver localViewTreeObserver;
        do {
            return;
            localViewTreeObserver = (ViewTreeObserver) this.c.get();
            localObject = ((View) localObject).getViewTreeObserver();
        } while (localObject == localViewTreeObserver);
        this.c = new WeakReference(localObject);
        ((ViewTreeObserver) localObject).addOnScrollChangedListener(this);
        ((ViewTreeObserver) localObject).addOnGlobalLayoutListener(this);
    }

    protected void h() {
        ViewTreeObserver localViewTreeObserver = (ViewTreeObserver) this.c.get();
        if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive())) {
            return;
        }
        localViewTreeObserver.removeOnScrollChangedListener(this);
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }

    protected JSONObject i() {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("afmaVersion", this.e.b()).put("activeViewJSON", this.e.c()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.e.a()).put("hashCode", this.e.d());
        return localJSONObject;
    }

    protected JSONObject j() {
        JSONObject localJSONObject = i();
        localJSONObject.put("doneReasonCode", "u");
        return localJSONObject;
    }

    public void k() {
        synchronized (this.a) {
            this.o = true;
            b(false);
            this.g.a();
            return;
        }
    }

    public void l() {
        synchronized (this.a) {
            this.n = true;
            b(false);
            this.g.a();
            return;
        }
    }

    public void m() {
        synchronized (this.a) {
            this.g.b();
            this.n = false;
            b(false);
            return;
        }
    }

    public void onGlobalLayout() {
        b(false);
    }

    public void onScrollChanged() {
        b(true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
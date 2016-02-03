package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import com.google.android.gms.b.d;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.ag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ii
public class te
        extends bd
        implements a, cf, cq, cs, dk, fq, fv, ja, jo, ll, td {
    private av a;
    private final dt b;
    private final tj c;
    private final b d;
    private final g e;
    private boolean f;
    private final ComponentCallbacks g = new tf(this);

    public te(Context paramContext, ay paramay, String paramString, dt paramdt, gt paramgt) {
        this(new tj(paramContext, paramay, paramString, paramgt), paramdt, null);
    }

    te(tj paramtj, dt paramdt, b paramb) {
        this.c = paramtj;
        this.b = paramdt;
        if (paramb != null) {
        }
        for (; ; ) {
            this.d = paramb;
            this.e = new g();
            lw.b(this.c.c);
            lj.a(this.c.c, this.c.e);
            w();
            return;
            paramb = new b(this);
        }
    }

    private void A() {
        mx.c("Ad opening.");
        if (this.c.f != null) {
        }
        try {
            this.c.f.d();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call AdListener.onAdOpened().", localRemoteException);
        }
    }

    private void B() {
        mx.c("Ad finished loading.");
        if (this.c.f != null) {
        }
        try {
            this.c.f.c();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call AdListener.onAdLoaded().", localRemoteException);
        }
    }

    private void C() {
        try {
            if (((this.c.j.w instanceof bu)) && (this.c.r != null)) {
                this.c.r.a((bu) this.c.j.w);
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
        }
    }

    private void D() {
        try {
            if (((this.c.j.w instanceof bv)) && (this.c.s != null)) {
                this.c.s.a((bv) this.c.j.w);
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
        }
    }

    private void E() {
        if (this.c.j != null) {
            if (this.c.x == 0) {
                this.c.j.b.destroy();
            }
            this.c.j = null;
            this.c.y = false;
        }
    }

    private kc a(av paramav, Bundle paramBundle) {
        ApplicationInfo localApplicationInfo = this.c.c.getApplicationInfo();
        try {
            PackageInfo localPackageInfo = this.c.c.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
            String str = null;
            Object localObject2 = str;
            if (!this.c.i.e) {
                localObject2 = str;
                if (this.c.a.getParent() != null) {
                    localObject2 = new int[2];
                    this.c.a.getLocationOnScreen((int[]) localObject2);
                    int k = localObject2[0];
                    int m = localObject2[1];
                    localObject2 = this.c.c.getResources().getDisplayMetrics();
                    int n = this.c.a.getWidth();
                    int i1 = this.c.a.getHeight();
                    int j = 0;
                    int i = j;
                    if (this.c.a.isShown()) {
                        i = j;
                        if (k + n > 0) {
                            i = j;
                            if (m + i1 > 0) {
                                i = j;
                                if (k <= ((DisplayMetrics) localObject2).widthPixels) {
                                    i = j;
                                    if (m <= ((DisplayMetrics) localObject2).heightPixels) {
                                        i = 1;
                                    }
                                }
                            }
                        }
                    }
                    localObject2 = new Bundle(5);
                    ((Bundle) localObject2).putInt("x", k);
                    ((Bundle) localObject2).putInt("y", m);
                    ((Bundle) localObject2).putInt("width", n);
                    ((Bundle) localObject2).putInt("height", i1);
                    ((Bundle) localObject2).putInt("visible", i);
                }
            }
            str = lj.c();
            this.c.l = new lg(str, this.c.b);
            this.c.l.a(paramav);
            Bundle localBundle = lj.a(this.c.c, this, str);
            return new kc((Bundle) localObject2, paramav, this.c.i, this.c.b, localApplicationInfo, localPackageInfo, str, lj.a, this.c.e, localBundle, this.c.t, paramBundle, lj.i());
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            for (; ; ) {
                Object localObject1 = null;
            }
        }
    }

    private mz a(tk paramtk) {
        if (this.c.i.e) {
            localObject = mz.a(this.c.c, this.c.i, false, false, this.c.d, this.c.e);
            ((mz) localObject).f().a(this, null, this, this, true, this, this, paramtk);
            return (mz) localObject;
        }
        Object localObject = this.c.a.getNextView();
        if ((localObject instanceof mz)) {
            localObject = (mz) localObject;
            ((mz) localObject).a(this.c.c, this.c.i);
        }
        for (; ; ) {
            ((mz) localObject).f().a(this, this, this, this, false, this, paramtk);
            return (mz) localObject;
            if (localObject != null) {
                this.c.a.removeView((View) localObject);
            }
            mz localmz = mz.a(this.c.c, this.c.i, false, false, this.c.d, this.c.e);
            localObject = localmz;
            if (this.c.i.h == null) {
                b(localmz);
                localObject = localmz;
            }
        }
    }

    private void a(int paramInt) {
        mx.e("Failed to load ad: " + paramInt);
        if (this.c.f != null) {
        }
        try {
            this.c.f.a(paramInt);
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
        }
    }

    private void b(View paramView) {
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
        this.c.a.addView(paramView, localLayoutParams);
    }

    private void b(boolean paramBoolean) {
        if (this.c.j == null) {
            mx.e("Ad state was null when trying to ping impression URLs.");
        }
        do {
            return;
            mx.a("Pinging Impression URLs.");
            this.c.l.a();
            if (this.c.j.e != null) {
                lw.a(this.c.c, this.c.e.b, this.c.j.e);
            }
            if ((this.c.j.o != null) && (this.c.j.o.d != null)) {
                dr.a(this.c.c, this.c.e.b, this.c.j, this.c.b, paramBoolean, this.c.j.o.d);
            }
        } while ((this.c.j.l == null) || (this.c.j.l.f == null));
        dr.a(this.c.c, this.c.e.b, this.c.j, this.c.b, paramBoolean, this.c.j.l.f);
    }

    /* Error */
    private boolean b(lc paramlc) {
        // Byte code:
        //   0: aload_1
        //   1: getfield 411	com/google/android/gms/internal/lc:k	Z
        //   4: ifeq +184 -> 188
        //   7: aload_1
        //   8: getfield 415	com/google/android/gms/internal/lc:m	Lcom/google/android/gms/internal/dx;
        //   11: invokeinterface 420 1 0
        //   16: invokestatic 425	com/google/android/gms/b/d:a	(Lcom/google/android/gms/b/a;)Ljava/lang/Object;
        //   19: checkcast 427	android/view/View
        //   22: astore_1
        //   23: aload_0
        //   24: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   27: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   30: invokevirtual 321	com/google/android/gms/internal/ti:getNextView	()Landroid/view/View;
        //   33: astore_2
        //   34: aload_2
        //   35: ifnull +14 -> 49
        //   38: aload_0
        //   39: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   42: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   45: aload_2
        //   46: invokevirtual 331	com/google/android/gms/internal/ti:removeView	(Landroid/view/View;)V
        //   49: aload_0
        //   50: aload_1
        //   51: invokespecial 337	com/google/android/gms/internal/te:b	(Landroid/view/View;)V
        //   54: aload_0
        //   55: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   58: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   61: invokevirtual 430	com/google/android/gms/internal/ti:getChildCount	()I
        //   64: iconst_1
        //   65: if_icmple +13 -> 78
        //   68: aload_0
        //   69: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   72: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   75: invokevirtual 433	com/google/android/gms/internal/ti:showNext	()V
        //   78: aload_0
        //   79: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   82: getfield 129	com/google/android/gms/internal/tj:j	Lcom/google/android/gms/internal/lc;
        //   85: ifnull +70 -> 155
        //   88: aload_0
        //   89: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   92: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   95: invokevirtual 321	com/google/android/gms/internal/ti:getNextView	()Landroid/view/View;
        //   98: astore_1
        //   99: aload_1
        //   100: instanceof 171
        //   103: ifeq +158 -> 261
        //   106: aload_1
        //   107: checkcast 171	com/google/android/gms/internal/mz
        //   110: aload_0
        //   111: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   114: getfield 76	com/google/android/gms/internal/tj:c	Landroid/content/Context;
        //   117: aload_0
        //   118: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   121: getfield 206	com/google/android/gms/internal/tj:i	Lcom/google/android/gms/internal/ay;
        //   124: invokevirtual 324	com/google/android/gms/internal/mz:a	(Landroid/content/Context;Lcom/google/android/gms/internal/ay;)V
        //   127: aload_0
        //   128: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   131: getfield 129	com/google/android/gms/internal/tj:j	Lcom/google/android/gms/internal/lc;
        //   134: getfield 415	com/google/android/gms/internal/lc:m	Lcom/google/android/gms/internal/dx;
        //   137: ifnull +18 -> 155
        //   140: aload_0
        //   141: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   144: getfield 129	com/google/android/gms/internal/tj:j	Lcom/google/android/gms/internal/lc;
        //   147: getfield 415	com/google/android/gms/internal/lc:m	Lcom/google/android/gms/internal/dx;
        //   150: invokeinterface 434 1 0
        //   155: aload_0
        //   156: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   159: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   162: iconst_0
        //   163: invokevirtual 437	com/google/android/gms/internal/ti:setVisibility	(I)V
        //   166: iconst_1
        //   167: ireturn
        //   168: astore_1
        //   169: ldc_w 439
        //   172: aload_1
        //   173: invokestatic 117	com/google/android/gms/internal/mx:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   176: iconst_0
        //   177: ireturn
        //   178: astore_1
        //   179: ldc_w 441
        //   182: aload_1
        //   183: invokestatic 117	com/google/android/gms/internal/mx:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   186: iconst_0
        //   187: ireturn
        //   188: aload_1
        //   189: getfield 443	com/google/android/gms/internal/lc:r	Lcom/google/android/gms/internal/ay;
        //   192: ifnull -138 -> 54
        //   195: aload_1
        //   196: getfield 169	com/google/android/gms/internal/lc:b	Lcom/google/android/gms/internal/mz;
        //   199: aload_1
        //   200: getfield 443	com/google/android/gms/internal/lc:r	Lcom/google/android/gms/internal/ay;
        //   203: invokevirtual 446	com/google/android/gms/internal/mz:a	(Lcom/google/android/gms/internal/ay;)V
        //   206: aload_0
        //   207: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   210: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   213: invokevirtual 449	com/google/android/gms/internal/ti:removeAllViews	()V
        //   216: aload_0
        //   217: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   220: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   223: aload_1
        //   224: getfield 443	com/google/android/gms/internal/lc:r	Lcom/google/android/gms/internal/ay;
        //   227: getfield 451	com/google/android/gms/internal/ay:g	I
        //   230: invokevirtual 454	com/google/android/gms/internal/ti:setMinimumWidth	(I)V
        //   233: aload_0
        //   234: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   237: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   240: aload_1
        //   241: getfield 443	com/google/android/gms/internal/lc:r	Lcom/google/android/gms/internal/ay;
        //   244: getfield 456	com/google/android/gms/internal/ay:d	I
        //   247: invokevirtual 459	com/google/android/gms/internal/ti:setMinimumHeight	(I)V
        //   250: aload_0
        //   251: aload_1
        //   252: getfield 169	com/google/android/gms/internal/lc:b	Lcom/google/android/gms/internal/mz;
        //   255: invokespecial 337	com/google/android/gms/internal/te:b	(Landroid/view/View;)V
        //   258: goto -204 -> 54
        //   261: aload_1
        //   262: ifnull -135 -> 127
        //   265: aload_0
        //   266: getfield 64	com/google/android/gms/internal/te:c	Lcom/google/android/gms/internal/tj;
        //   269: getfield 213	com/google/android/gms/internal/tj:a	Lcom/google/android/gms/internal/ti;
        //   272: aload_1
        //   273: invokevirtual 331	com/google/android/gms/internal/ti:removeView	(Landroid/view/View;)V
        //   276: goto -149 -> 127
        //   279: astore_1
        //   280: ldc_w 461
        //   283: invokestatic 355	com/google/android/gms/internal/mx:e	(Ljava/lang/String;)V
        //   286: goto -131 -> 155
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	289	0	this	te
        //   0	289	1	paramlc	lc
        //   33	13	2	localView	View
        // Exception table:
        //   from	to	target	type
        //   7	23	168	android/os/RemoteException
        //   49	54	178	java/lang/Throwable
        //   140	155	279	android/os/RemoteException
    }

    private void w() {
        if ((Build.VERSION.SDK_INT >= 14) && (this.c != null) && (this.c.c != null)) {
            this.c.c.registerComponentCallbacks(this.g);
        }
    }

    private void x() {
        if ((Build.VERSION.SDK_INT >= 14) && (this.c != null) && (this.c.c != null)) {
            this.c.c.unregisterComponentCallbacks(this.g);
        }
    }

    private void y() {
        mx.c("Ad closing.");
        if (this.c.f != null) {
        }
        try {
            this.c.f.a();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call AdListener.onAdClosed().", localRemoteException);
        }
    }

    private void z() {
        mx.c("Ad leaving application.");
        if (this.c.f != null) {
        }
        try {
            this.c.f.b();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Could not call AdListener.onAdLeftApplication().", localRemoteException);
        }
    }

    Bundle a(ad paramad) {
        if (paramad == null) {
        }
        for (; ; ) {
            return null;
            if (paramad.e()) {
                paramad.c();
            }
            Object localObject = paramad.b();
            if (localObject != null) {
                paramad = ((aa) localObject).b();
                mx.a("In AdManger: loadAd, " + ((aa) localObject).toString());
            }
            while (paramad != null) {
                localObject = new Bundle(1);
                ((Bundle) localObject).putString("fingerprint", paramad);
                return (Bundle) localObject;
                paramad = null;
            }
        }
    }

    public void a() {
        if (this.c.j == null) {
            mx.e("Ad state was null when trying to ping click URLs.");
        }
        do {
            return;
            mx.a("Pinging click URLs.");
            this.c.l.b();
            if (this.c.j.c != null) {
                lw.a(this.c.c, this.c.e.b, this.c.j.c);
            }
        } while ((this.c.j.o == null) || (this.c.j.o.c == null));
        dr.a(this.c.c, this.c.e.b, this.c.j, this.c.b, false, this.c.j.o.c);
    }

    public void a(View paramView) {
        this.c.w = paramView;
        a(new lc(this.c.k, null, null, null, null, null, null));
    }

    public void a(ay paramay) {
        ag.b("setAdSize must be called on the main UI thread.");
        this.c.i = paramay;
        if ((this.c.j != null) && (this.c.x == 0)) {
            this.c.j.b.a(paramay);
        }
        if (this.c.a.getChildCount() > 1) {
            this.c.a.removeView(this.c.a.getNextView());
        }
        this.c.a.setMinimumWidth(paramay.g);
        this.c.a.setMinimumHeight(paramay.d);
        this.c.a.requestLayout();
    }

    public void a(az paramaz) {
        ag.b("setAdListener must be called on the main UI thread.");
        this.c.f = paramaz;
    }

    public void a(bi parambi) {
        ag.b("setAppEventListener must be called on the main UI thread.");
        this.c.m = parambi;
    }

    public void a(gw paramgw) {
        ag.b("setInAppPurchaseListener must be called on the main UI thread.");
        this.c.o = paramgw;
    }

    public void a(hh paramhh, String paramString) {
        ag.b("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.c.u = new gq(paramString);
        this.c.n = paramhh;
        if ((!lj.g()) && (paramhh != null)) {
            new gg(this.c.c, this.c.n, this.c.u).e();
        }
    }

    public void a(hx paramhx) {
        ag.b("setRawHtmlPublisherAdViewListener must be called on the main UI thread.");
        this.c.p = paramhx;
    }

    public void a(ia paramia) {
        ag.b("setRawHtmlPublisherInterstitialAdListener must be called on the main UI thread.");
        this.c.q = paramia;
    }

    public void a(lc paramlc) {
        this.c.h = null;
        if (paramlc.w != null) {
        }
        for (boolean bool = true; ; bool = false) {
            if ((paramlc.d != -2) && (paramlc.d != 3)) {
                lj.a(this.c.a());
            }
            if (paramlc.d != -1) {
                break;
            }
            return;
        }
        if (a(paramlc, bool)) {
            mx.a("Ad refresh scheduled.");
        }
        if ((paramlc.d == 3) && (paramlc.o != null) && (paramlc.o.e != null)) {
            mx.a("Pinging no fill URLs.");
            dr.a(this.c.c, this.c.e.b, paramlc, this.c.b, false, paramlc.o.e);
        }
        if (paramlc.d != -2) {
            a(paramlc.d);
            return;
        }
        if ((!this.c.i.e) && (!bool) && (this.c.x == 0)) {
            if (!b(paramlc)) {
                a(0);
                return;
            }
            if (this.c.a != null) {
                ti.a(this.c.a).a(paramlc.v);
            }
        }
        if ((this.c.j != null) && (this.c.j.p != null)) {
            this.c.j.p.a(null);
        }
        if (paramlc.p != null) {
            paramlc.p.a(this);
        }
        this.e.b(this.c.j);
        this.c.j = paramlc;
        this.c.l.a(paramlc.t);
        this.c.l.b(paramlc.u);
        this.c.l.a(this.c.i.e);
        this.c.l.b(paramlc.k);
        if ((!this.c.i.e) && (!bool) && (this.c.x == 0)) {
            b(false);
        }
        if (this.c.v == null) {
            this.c.v = new lm(this.c.b);
        }
        int j;
        int i;
        if (paramlc.o != null) {
            j = paramlc.o.h;
            i = paramlc.o.i;
        }
        for (; ; ) {
            this.c.v.a(j, i);
            if (this.c.x == 0) {
                if ((!this.c.i.e) && (paramlc.b != null) && ((paramlc.b.f().b()) || (paramlc.j != null))) {
                    h localh = this.e.a(this.c.i, this.c.j);
                    if ((paramlc.b.f().b()) && (localh != null)) {
                        localh.a(new tp(paramlc.b));
                    }
                }
                if (this.c.j.b != null) {
                    this.c.j.b.a();
                    this.c.j.b.f().c();
                }
                if (bool) {
                    paramlc = paramlc.w;
                    if ((!(paramlc instanceof bv)) || (this.c.s == null)) {
                        break label650;
                    }
                    D();
                }
                for (; ; ) {
                    B();
                    return;
                    label650:
                    if ((!(paramlc instanceof bu)) || (this.c.r == null)) {
                        break;
                    }
                    C();
                }
                mx.e("No matching listener for retrieved native ad template.");
                a(0);
                return;
            }
            if ((this.c.w == null) || (paramlc.j == null)) {
                break;
            }
            this.e.a(this.c.c, this.c.i, this.c.j, this.c.w, this.c.e);
            return;
            i = 0;
            j = 0;
        }
    }

    public void a(ld paramld) {
        String str = null;
        this.c.g = null;
        this.c.k = paramld;
        a(null);
        Object localObject;
        mz localmz;
        if (!paramld.b.t) {
            localObject = new tk();
            localmz = a((tk) localObject);
            ((tk) localObject).a(new tm(paramld, localmz));
            localmz.setOnTouchListener(new tg(this, (tk) localObject));
            localmz.setOnClickListener(new th(this, (tk) localObject));
        }
        for (; ; ) {
            if (paramld.d != null) {
                this.c.i = paramld.d;
            }
            if (paramld.e != -2) {
                a(new lc(paramld, localmz, null, null, null, null, null));
                return;
            }
            if ((!paramld.b.h) && (paramld.b.s)) {
                if (paramld.b.b != null) {
                    str = Uri.parse(paramld.b.b).buildUpon().query(null).build().toString();
                }
                localObject = new ht(this, str, paramld.b.c);
                try {
                    if ((this.c.p != null) && (!this.c.i.e) && (this.c.p.a(str, paramld.b.c))) {
                        this.c.x = 1;
                        this.c.p.a((hu) localObject);
                        return;
                    }
                } catch (RemoteException localRemoteException2) {
                    mx.d("Could not call the rawHtmlPublisherAdViewListener.", localRemoteException2);
                    try {
                        if ((this.c.q != null) && (this.c.i.e) && (this.c.q.a(str, paramld.b.c))) {
                            this.c.x = 1;
                            this.c.q.a((hu) localObject);
                            return;
                        }
                    } catch (RemoteException localRemoteException1) {
                        mx.d("Could not call the RawHtmlPublisherInterstitialAdListener.", localRemoteException1);
                    }
                }
            }
            this.c.x = 0;
            this.c.h = jn.a(this.c.c, this, paramld, localmz, this.b, this);
            return;
            localmz = null;
        }
    }

    public void a(String paramString1, String paramString2) {
        if (this.c.m != null) {
        }
        try {
            this.c.m.a(paramString1, paramString2);
            return;
        } catch (RemoteException paramString1) {
            mx.d("Could not call the AppEventListener.", paramString1);
        }
    }

    public void a(String paramString, ArrayList<String> paramArrayList) {
        paramArrayList = new gi(paramString, paramArrayList, this.c.c, this.c.e.b);
        if (this.c.o == null) {
            mx.e("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.c.c) != 0) {
                mx.e("Google Play Service unavailable, cannot launch default purchase flow.");
            }
            for (; ; ) {
                return;
                if (this.c.n == null) {
                    mx.e("PlayStorePurchaseListener is not set.");
                    return;
                }
                if (this.c.u == null) {
                    mx.e("PlayStorePurchaseVerifier is not initialized.");
                    return;
                }
                try {
                    boolean bool = this.c.n.a(paramString);
                    if (!bool) {
                    }
                } catch (RemoteException paramString) {
                    for (; ; ) {
                        mx.e("Could not start In-App purchase.");
                    }
                }
            }
            gj.a(this.c.c, this.c.e.e, new dv(paramArrayList, this.c.n, this.c.u, this.c.c));
            return;
        }
        try {
            this.c.o.a(paramArrayList);
            return;
        } catch (RemoteException paramString) {
            mx.e("Could not start In-App purchase.");
        }
    }

    public void a(HashSet<lg> paramHashSet) {
        this.c.a(paramHashSet);
    }

    public void a(List<String> paramList) {
        ag.b("setNativeTemplates must be called on the main UI thread.");
        this.c.t = paramList;
    }

    public void a(boolean paramBoolean) {
        this.c.y = paramBoolean;
    }

    public boolean a(av paramav) {
        ag.b("loadAd must be called on the main UI thread.");
        if ((this.c.g != null) || (this.c.h != null)) {
            if (this.a != null) {
                mx.e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            this.a = paramav;
        }
        do {
            return false;
            if ((this.c.i.e) && (this.c.j != null)) {
                mx.e("An interstitial is already loading. Aborting.");
                return false;
            }
        } while (!v());
        mx.c("Starting ad request.");
        if (!paramav.f) {
            mx.c("Use AdRequest.Builder.addTestDevice(\"" + mv.a(this.c.c) + "\") to get test ads on this device.");
        }
        Bundle localBundle = a(lj.a().a(this.c.c));
        this.d.a();
        this.c.x = 0;
        paramav = a(paramav, localBundle);
        this.c.g = iz.a(this.c.c, paramav, this.c.d, this);
        return true;
    }

    boolean a(lc paramlc, boolean paramBoolean) {
        boolean bool = false;
        Object localObject;
        if (this.a != null) {
            localObject = this.a;
            this.a = null;
            if (!this.c.i.e) {
                break label96;
            }
            if (this.c.x == 0) {
                lw.a(paramlc.b);
            }
        }
        for (; ; ) {
            return this.d.d();
            av localav = paramlc.a;
            localObject = localav;
            if (localav.c == null) {
                break;
            }
            bool = localav.c.getBoolean("_noRefresh", false);
            localObject = localav;
            break;
            label96:
            if ((!(bool | paramBoolean)) && (this.c.x == 0)) {
                if (paramlc.h > 0L) {
                    this.d.a((av) localObject, paramlc.h);
                } else if ((paramlc.o != null) && (paramlc.o.g > 0L)) {
                    this.d.a((av) localObject, paramlc.o.g);
                } else if ((!paramlc.k) && (paramlc.d == 2)) {
                    this.d.a((av) localObject);
                }
            }
        }
    }

    public void b() {
        b(false);
    }

    public void b(av paramav) {
        ViewParent localViewParent = this.c.a.getParent();
        if (((localViewParent instanceof View)) && (((View) localViewParent).isShown()) && (lw.a()) && (!this.f)) {
            a(paramav);
            return;
        }
        mx.c("Ad is not visible. Not refreshing ad.");
        this.d.a(paramav);
    }

    public com.google.android.gms.b.a c() {
        ag.b("getAdFrame must be called on the main UI thread.");
        return d.a(this.c.a);
    }

    public void d() {
        ag.b("destroy must be called on the main UI thread.");
        x();
        this.c.f = null;
        this.c.m = null;
        this.c.n = null;
        this.c.o = null;
        this.c.p = null;
        this.c.q = null;
        this.d.a();
        this.e.a();
        i();
        if (this.c.a != null) {
            this.c.a.removeAllViews();
        }
        if ((this.c.j != null) && (this.c.j.b != null)) {
            this.c.j.b.destroy();
        }
        if ((this.c.j != null) && (this.c.j.m != null)) {
        }
        try {
            this.c.j.m.c();
            return;
        } catch (RemoteException localRemoteException) {
            mx.e("Could not destroy mediation adapter.");
        }
    }

    public boolean e() {
        ag.b("isLoaded must be called on the main UI thread.");
        return (this.c.g == null) && (this.c.h == null) && (this.c.j != null);
    }

    public void f() {
        ag.b("pause must be called on the main UI thread.");
        if ((this.c.j != null) && (this.c.x == 0)) {
            lw.a(this.c.j.b);
        }
        if ((this.c.j != null) && (this.c.j.m != null)) {
        }
        try {
            this.c.j.m.d();
            this.e.b();
            this.d.b();
            return;
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
                mx.e("Could not pause mediation adapter.");
            }
        }
    }

    public void g() {
        ag.b("resume must be called on the main UI thread.");
        if ((this.c.j != null) && (this.c.x == 0)) {
            lw.b(this.c.j.b);
        }
        if ((this.c.j != null) && (this.c.j.m != null)) {
        }
        try {
            this.c.j.m.e();
            this.d.c();
            this.e.c();
            return;
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
                mx.e("Could not resume mediation adapter.");
            }
        }
    }

    public void h() {
        ag.b("showInterstitial must be called on the main UI thread.");
        if (!this.c.i.e) {
            mx.e("Cannot call showInterstitial on a banner ad.");
        }
        do {
            return;
            if (this.c.j == null) {
                mx.e("The interstitial has not loaded.");
                return;
            }
        } while (this.c.x == 1);
        if (this.c.j.b.j()) {
            mx.e("The interstitial is already showing.");
            return;
        }
        this.c.j.b.a(true);
        if ((this.c.j.b.f().b()) || (this.c.j.j != null)) {
            h localh = this.e.a(this.c.i, this.c.j);
            if ((this.c.j.b.f().b()) && (localh != null)) {
                localh.a(new tp(this.c.j.b));
            }
        }
        if (this.c.j.k) {
            try {
                this.c.j.m.b();
                return;
            } catch (RemoteException localRemoteException) {
                mx.d("Could not show interstitial.", localRemoteException);
                E();
                return;
            }
        }
        x localx = new x(this.c.y, false);
        Object localObject = localx;
        boolean bool2;
        if ((this.c.c instanceof Activity)) {
            localObject = ((Activity) this.c.c).getWindow();
            Rect localRect1 = new Rect();
            Rect localRect2 = new Rect();
            ((Window) localObject).getDecorView().getGlobalVisibleRect(localRect1);
            ((Window) localObject).getDecorView().getWindowVisibleDisplayFrame(localRect2);
            localObject = localx;
            if (localRect1.bottom != 0) {
                localObject = localx;
                if (localRect2.bottom != 0) {
                    bool2 = this.c.y;
                    if (localRect1.top != localRect2.top) {
                        break label431;
                    }
                }
            }
        }
        label431:
        for (boolean bool1 = true; ; bool1 = false) {
            localObject = new x(bool2, bool1);
            localObject = new dm(this, this, this, this.c.j.b, this.c.j.g, this.c.e, this.c.j.v, (x) localObject);
            fj.a(this.c.c, (dm) localObject);
            return;
        }
    }

    public void i() {
        ag.b("stopLoading must be called on the main UI thread.");
        if ((this.c.j != null) && (this.c.x == 0)) {
            this.c.j.b.stopLoading();
            this.c.j = null;
        }
        if (this.c.g != null) {
            this.c.g.f();
        }
        if (this.c.h != null) {
            this.c.h.f();
        }
    }

    public void j() {
        ag.b("recordManualImpression must be called on the main UI thread.");
        if (this.c.j == null) {
            mx.e("Ad state was null when trying to ping manual tracking URLs.");
        }
        do {
            return;
            mx.a("Pinging manual tracking URLs.");
        } while (this.c.j.f == null);
        lw.a(this.c.c, this.c.e.b, this.c.j.f);
    }

    public ay k() {
        ag.b("getAdSize must be called on the main UI thread.");
        return this.c.i;
    }

    public String l() {
        if (this.c.j != null) {
            return this.c.j.n;
        }
        return null;
    }

    public void m() {
        u();
    }

    public void n() {
        r();
    }

    public void o() {
        t();
    }

    public void p() {
        s();
    }

    public void q() {
        if (this.c.j != null) {
            mx.e("Mediation adapter " + this.c.j.n + " refreshed, but mediation adapters should never refresh.");
        }
        b(true);
        B();
    }

    public void r() {
        this.e.b(this.c.j);
        if (this.c.i.e) {
            E();
        }
        this.f = false;
        y();
        this.c.l.c();
    }

    public void s() {
        if (this.c.i.e) {
            b(false);
        }
        this.f = true;
        A();
    }

    public void t() {
        z();
    }

    public void u() {
        a();
    }

    public boolean v() {
        boolean bool = true;
        if (!lw.a(this.c.c.getPackageManager(), this.c.c.getPackageName(), "android.permission.INTERNET")) {
            if (!this.c.i.e) {
                mv.a(this.c.a, this.c.i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            bool = false;
        }
        if (!lw.a(this.c.c)) {
            if (!this.c.i.e) {
                mv.a(this.c.a, this.c.i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            bool = false;
        }
        if ((!bool) && (!this.c.i.e)) {
            this.c.a.setVisibility(0);
        }
        return bool;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/te.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
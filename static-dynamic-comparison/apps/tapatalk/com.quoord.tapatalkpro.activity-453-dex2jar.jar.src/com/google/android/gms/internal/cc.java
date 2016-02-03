package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class cc
        extends ck.a {
    private dz lC;
    private final Activity nS;
    private ce nT;
    private cg nU;
    private c nV;
    private ch nW;
    private boolean nX;
    private FrameLayout nY;
    private WebChromeClient.CustomViewCallback nZ;
    private boolean oa = false;
    private boolean ob = false;
    private RelativeLayout oc;

    public cc(Activity paramActivity) {
        this.nS = paramActivity;
    }

    private static RelativeLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
        localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(9);
        return localLayoutParams;
    }

    public static void a(Context paramContext, ce paramce) {
        Intent localIntent = new Intent();
        localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
        localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramce.kK.rt);
        ce.a(localIntent, paramce);
        localIntent.addFlags(524288);
        if (!(paramContext instanceof Activity)) {
            localIntent.addFlags(268435456);
        }
        paramContext.startActivity(localIntent);
    }

    private void aN() {
        if ((!this.nS.isFinishing()) || (this.ob)) {
        }
        do {
            do {
                return;
                this.ob = true;
            } while (!this.nS.isFinishing());
            if (this.lC != null) {
                this.lC.bF();
                this.oc.removeView(this.lC);
                if (this.nV != null) {
                    this.lC.p(false);
                    this.nV.of.addView(this.lC, this.nV.index, this.nV.oe);
                }
            }
        } while ((this.nT == null) || (this.nT.oi == null));
        this.nT.oi.V();
    }

    private void j(boolean paramBoolean)
            throws cc.a {
        if (!this.nX) {
            this.nS.requestWindowFeature(1);
        }
        Object localObject = this.nS.getWindow();
        ((Window) localObject).setFlags(1024, 1024);
        setRequestedOrientation(this.nT.orientation);
        if (Build.VERSION.SDK_INT >= 11) {
            dw.v("Enabling hardware acceleration on the AdActivity window.");
            ds.a((Window) localObject);
        }
        this.oc = new b(this.nS, this.nT.or);
        this.oc.setBackgroundColor(-16777216);
        this.nS.setContentView(this.oc);
        N();
        boolean bool = this.nT.oj.bI().bP();
        if (paramBoolean) {
            this.lC = dz.a(this.nS, this.nT.oj.R(), true, bool, null, this.nT.kK);
            this.lC.bI().a(null, null, this.nT.ok, this.nT.oo, true, this.nT.oq);
            this.lC.bI().a(new ea.a() {
                public void a(dz paramAnonymousdz) {
                    paramAnonymousdz.bG();
                }
            });
            if (this.nT.nO != null) {
                this.lC.loadUrl(this.nT.nO);
            }
        }
        for (; ; ) {
            this.lC.a(this);
            localObject = this.lC.getParent();
            if ((localObject != null) && ((localObject instanceof ViewGroup))) {
                ((ViewGroup) localObject).removeView(this.lC);
            }
            this.oc.addView(this.lC, -1, -1);
            if (!paramBoolean) {
                this.lC.bG();
            }
            h(bool);
            return;
            if (this.nT.on != null) {
                this.lC.loadDataWithBaseURL(this.nT.ol, this.nT.on, "text/html", "UTF-8", null);
            } else {
                throw new a("No URL or HTML to display in ad overlay.");
                this.lC = this.nT.oj;
                this.lC.setContext(this.nS);
            }
        }
    }

    public void N() {
        this.nX = true;
    }

    public void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
        this.nY = new FrameLayout(this.nS);
        this.nY.setBackgroundColor(-16777216);
        this.nY.addView(paramView, -1, -1);
        this.nS.setContentView(this.nY);
        N();
        this.nZ = paramCustomViewCallback;
    }

    public cg aK() {
        return this.nU;
    }

    public void aL() {
        if (this.nT != null) {
            setRequestedOrientation(this.nT.orientation);
        }
        if (this.nY != null) {
            this.nS.setContentView(this.oc);
            N();
            this.nY.removeAllViews();
            this.nY = null;
        }
        if (this.nZ != null) {
            this.nZ.onCustomViewHidden();
            this.nZ = null;
        }
    }

    public void aM() {
        this.oc.removeView(this.nW);
        h(true);
    }

    public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.nU != null) {
            this.nU.setLayoutParams(a(paramInt1, paramInt2, paramInt3, paramInt4));
        }
    }

    public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.nU == null) {
            this.nU = new cg(this.nS, this.lC);
            this.oc.addView(this.nU, 0, a(paramInt1, paramInt2, paramInt3, paramInt4));
            this.lC.bI().q(false);
        }
    }

    public void close() {
        this.nS.finish();
    }

    public void h(boolean paramBoolean) {
        RelativeLayout.LayoutParams localLayoutParams;
        if (paramBoolean) {
            i = 50;
            this.nW = new ch(this.nS, i);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(10);
            if (!paramBoolean) {
                break label86;
            }
        }
        label86:
        for (int i = 11; ; i = 9) {
            localLayoutParams.addRule(i);
            this.nW.i(this.nT.om);
            this.oc.addView(this.nW, localLayoutParams);
            return;
            i = 32;
            break;
        }
    }

    public void i(boolean paramBoolean) {
        if (this.nW != null) {
            this.nW.i(paramBoolean);
        }
    }

    public void onCreate(Bundle paramBundle) {
        boolean bool = false;
        if (paramBundle != null) {
            bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.oa = bool;
        try {
            this.nT = ce.a(this.nS.getIntent());
            if (this.nT != null) {
                break label68;
            }
            throw new a("Could not get info for ad overlay.");
        } catch (a paramBundle) {
            dw.z(paramBundle.getMessage());
            this.nS.finish();
        }
        return;
        label68:
        if (paramBundle == null) {
            if (this.nT.oi != null) {
                this.nT.oi.W();
            }
            if ((this.nT.op != 1) && (this.nT.oh != null)) {
                this.nT.oh.P();
            }
        }
        switch (this.nT.op) {
        }
        for (; ; ) {
            throw new a("Could not determine ad overlay type.");
            j(false);
            return;
            this.nV = new c(this.nT.oj);
            j(false);
            return;
            j(true);
            return;
            if (this.oa) {
                this.nS.finish();
                return;
            }
            if (bz.a(this.nS, this.nT.og, this.nT.oo)) {
                break;
            }
            this.nS.finish();
            return;
        }
    }

    public void onDestroy() {
        if (this.nU != null) {
            this.nU.destroy();
        }
        if (this.lC != null) {
            this.oc.removeView(this.lC);
        }
        aN();
    }

    public void onPause() {
        if (this.nU != null) {
            this.nU.pause();
        }
        aL();
        if ((this.lC != null) && ((!this.nS.isFinishing()) || (this.nV == null))) {
            dq.a(this.lC);
        }
        aN();
    }

    public void onRestart() {
    }

    public void onResume() {
        if ((this.nT != null) && (this.nT.op == 4)) {
            if (!this.oa) {
                break label47;
            }
            this.nS.finish();
        }
        for (; ; ) {
            if (this.lC != null) {
                dq.b(this.lC);
            }
            return;
            label47:
            this.oa = true;
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.oa);
    }

    public void onStart() {
    }

    public void onStop() {
        aN();
    }

    public void setRequestedOrientation(int paramInt) {
        this.nS.setRequestedOrientation(paramInt);
    }

    private static final class a
            extends Exception {
        public a(String paramString) {
            super();
        }
    }

    private static final class b
            extends RelativeLayout {
        private final dr kF;

        public b(Context paramContext, String paramString) {
            super();
            this.kF = new dr(paramContext, paramString);
        }

        public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
            this.kF.c(paramMotionEvent);
            return false;
        }
    }

    private static final class c {
        public final int index;
        public final ViewGroup.LayoutParams oe;
        public final ViewGroup of;

        public c(dz paramdz)
                throws cc.a {
            this.oe = paramdz.getLayoutParams();
            ViewParent localViewParent = paramdz.getParent();
            if ((localViewParent instanceof ViewGroup)) {
                this.of = ((ViewGroup) localViewParent);
                this.index = this.of.indexOfChild(paramdz);
                this.of.removeView(paramdz);
                paramdz.p(true);
                return;
            }
            throw new cc.a("Could not get the parent of the WebView for an overlay.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
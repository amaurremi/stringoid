package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ea
        extends WebViewClient {
    protected final dz lC;
    private final Object li = new Object();
    private az mF;
    private bc mP;
    private a oW;
    private final HashMap<String, bb> rA = new HashMap();
    private u rB;
    private cf rC;
    private boolean rD = false;
    private boolean rE;
    private ci rF;

    public ea(dz paramdz, boolean paramBoolean) {
        this.lC = paramdz;
        this.rE = paramBoolean;
    }

    private static boolean c(Uri paramUri) {
        paramUri = paramUri.getScheme();
        return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
    }

    private void d(Uri paramUri) {
        Object localObject = paramUri.getPath();
        bb localbb = (bb) this.rA.get(localObject);
        if (localbb != null) {
            paramUri = dq.b(paramUri);
            if (dw.n(2)) {
                dw.y("Received GMSG: " + (String) localObject);
                localObject = paramUri.keySet().iterator();
                while (((Iterator) localObject).hasNext()) {
                    String str = (String) ((Iterator) localObject).next();
                    dw.y("  " + str + ": " + (String) paramUri.get(str));
                }
            }
            localbb.b(this.lC, paramUri);
            return;
        }
        dw.y("No GMSG handler found for GMSG: " + paramUri);
    }

    public final void a(cb paramcb) {
        cf localcf = null;
        boolean bool = this.lC.bL();
        u localu;
        if ((bool) && (!this.lC.R().lT)) {
            localu = null;
            if (!bool) {
                break label69;
            }
        }
        for (; ; ) {
            a(new ce(paramcb, localu, localcf, this.rF, this.lC.bK()));
            return;
            localu = this.rB;
            break;
            label69:
            localcf = this.rC;
        }
    }

    protected void a(ce paramce) {
        cc.a(this.lC.getContext(), paramce);
    }

    public final void a(a parama) {
        this.oW = parama;
    }

    public void a(u paramu, cf paramcf, az paramaz, ci paramci, boolean paramBoolean, bc parambc) {
        a("/appEvent", new ay(paramaz));
        a("/canOpenURLs", ba.mH);
        a("/click", ba.mI);
        a("/close", ba.mJ);
        a("/customClose", ba.mK);
        a("/httpTrack", ba.mL);
        a("/log", ba.mM);
        a("/open", new bd(parambc));
        a("/touch", ba.mN);
        a("/video", ba.mO);
        this.rB = paramu;
        this.rC = paramcf;
        this.mF = paramaz;
        this.mP = parambc;
        this.rF = paramci;
        q(paramBoolean);
    }

    public final void a(String paramString, bb parambb) {
        this.rA.put(paramString, parambb);
    }

    public final void a(boolean paramBoolean, int paramInt) {
        if ((this.lC.bL()) && (!this.lC.R().lT)) {
        }
        for (u localu = null; ; localu = this.rB) {
            a(new ce(localu, this.rC, this.rF, this.lC, paramBoolean, paramInt, this.lC.bK()));
            return;
        }
    }

    public final void a(boolean paramBoolean, int paramInt, String paramString) {
        cf localcf = null;
        boolean bool = this.lC.bL();
        u localu;
        if ((bool) && (!this.lC.R().lT)) {
            localu = null;
            if (!bool) {
                break label89;
            }
        }
        for (; ; ) {
            a(new ce(localu, localcf, this.mF, this.rF, this.lC, paramBoolean, paramInt, paramString, this.lC.bK(), this.mP));
            return;
            localu = this.rB;
            break;
            label89:
            localcf = this.rC;
        }
    }

    public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {
        boolean bool = this.lC.bL();
        u localu;
        if ((bool) && (!this.lC.R().lT)) {
            localu = null;
            if (!bool) {
                break label91;
            }
        }
        label91:
        for (cf localcf = null; ; localcf = this.rC) {
            a(new ce(localu, localcf, this.mF, this.rF, this.lC, paramBoolean, paramInt, paramString1, paramString2, this.lC.bK(), this.mP));
            return;
            localu = this.rB;
            break;
        }
    }

    public final void aM() {
        synchronized (this.li) {
            this.rD = false;
            this.rE = true;
            final cc localcc = this.lC.bH();
            if (localcc != null) {
                if (!dv.bD()) {
                    dv.rp.post(new Runnable() {
                        public void run() {
                            localcc.aM();
                        }
                    });
                }
            } else {
                return;
            }
            localcc.aM();
        }
    }

    public boolean bP() {
        synchronized (this.li) {
            boolean bool = this.rE;
            return bool;
        }
    }

    public final void onLoadResource(WebView paramWebView, String paramString) {
        dw.y("Loading resource: " + paramString);
        paramWebView = Uri.parse(paramString);
        if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
            d(paramWebView);
        }
    }

    public final void onPageFinished(WebView paramWebView, String paramString) {
        if (this.oW != null) {
            this.oW.a(this.lC);
            this.oW = null;
        }
    }

    public final void q(boolean paramBoolean) {
        this.rD = paramBoolean;
    }

    public final void reset() {
        synchronized (this.li) {
            this.rA.clear();
            this.rB = null;
            this.rC = null;
            this.oW = null;
            this.mF = null;
            this.rD = false;
            this.rE = false;
            this.mP = null;
            this.rF = null;
            return;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        dw.y("AdWebView shouldOverrideUrlLoading: " + paramString);
        Uri localUri = Uri.parse(paramString);
        if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
            d(localUri);
        }
        for (; ; ) {
            return true;
            if ((this.rD) && (paramWebView == this.lC) && (c(localUri))) {
                return super.shouldOverrideUrlLoading(paramWebView, paramString);
            }
            if (!this.lC.willNotDraw()) {
                try {
                    l locall = this.lC.bJ();
                    paramWebView = localUri;
                    if (locall != null) {
                        paramWebView = localUri;
                        if (locall.a(localUri)) {
                            paramWebView = locall.a(localUri, this.lC.getContext());
                        }
                    }
                } catch (m paramWebView) {
                    for (; ; ) {
                        dw.z("Unable to append parameter to URL: " + paramString);
                        paramWebView = localUri;
                    }
                }
                a(new cb("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
            } else {
                dw.z("AdWebView unable to handle URL: " + paramString);
            }
        }
    }

    public static abstract interface a {
        public abstract void a(dz paramdz);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
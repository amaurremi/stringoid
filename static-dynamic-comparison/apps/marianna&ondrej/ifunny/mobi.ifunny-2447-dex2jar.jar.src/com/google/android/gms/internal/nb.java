package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ii
public class nb
        extends WebViewClient {
    protected final mz a;
    private final HashMap<String, cp> b = new HashMap();
    private final Object c = new Object();
    private td d;
    private fq e;
    private nd f;
    private cf g;
    private boolean h = false;
    private cq i;
    private cs j;
    private boolean k;
    private fv l;
    private final ff m;
    private tk n;

    public nb(mz parammz, boolean paramBoolean) {
        this(parammz, paramBoolean, new ff(parammz, parammz.getContext(), new br(parammz.getContext())));
    }

    nb(mz parammz, boolean paramBoolean, ff paramff) {
        this.a = parammz;
        this.k = paramBoolean;
        this.m = paramff;
    }

    private static boolean a(Uri paramUri) {
        paramUri = paramUri.getScheme();
        return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
    }

    private void b(Uri paramUri) {
        Object localObject = paramUri.getPath();
        cp localcp = (cp) this.b.get(localObject);
        if (localcp != null) {
            paramUri = lw.a(paramUri);
            if (mx.a(2)) {
                mx.d("Received GMSG: " + (String) localObject);
                localObject = paramUri.keySet().iterator();
                while (((Iterator) localObject).hasNext()) {
                    String str = (String) ((Iterator) localObject).next();
                    mx.d("  " + str + ": " + (String) paramUri.get(str));
                }
            }
            localcp.a(this.a, paramUri);
            return;
        }
        mx.d("No GMSG handler found for GMSG: " + paramUri);
    }

    public tk a() {
        return this.n;
    }

    public final void a(dj paramdj) {
        fq localfq = null;
        boolean bool = this.a.j();
        td localtd;
        if ((bool) && (!this.a.e().e)) {
            localtd = null;
            if (!bool) {
                break label69;
            }
        }
        for (; ; ) {
            a(new dm(paramdj, localtd, localfq, this.l, this.a.i()));
            return;
            localtd = this.d;
            break;
            label69:
            localfq = this.e;
        }
    }

    protected void a(dm paramdm) {
        fj.a(this.a.getContext(), paramdm);
    }

    public final void a(nd paramnd) {
        this.f = paramnd;
    }

    public void a(td paramtd, fq paramfq, cf paramcf, fv paramfv, boolean paramBoolean, cq paramcq, cs paramcs, tk paramtk) {
        a(paramtd, paramfq, paramcf, paramfv, paramBoolean, paramcq, paramtk);
        a("/setInterstitialProperties", new cr(paramcs));
        this.j = paramcs;
    }

    public void a(td paramtd, fq paramfq, cf paramcf, fv paramfv, boolean paramBoolean, cq paramcq, tk paramtk) {
        tk localtk = paramtk;
        if (paramtk == null) {
            localtk = new tk(false);
        }
        a("/appEvent", new ce(paramcf));
        a("/canOpenURLs", cg.b);
        a("/click", cg.c);
        a("/close", cg.d);
        a("/customClose", cg.e);
        a("/httpTrack", cg.f);
        a("/log", cg.g);
        a("/open", new cu(paramcq, localtk));
        a("/touch", cg.h);
        a("/video", cg.i);
        a("/mraid", new ct());
        this.d = paramtd;
        this.e = paramfq;
        this.g = paramcf;
        this.i = paramcq;
        this.l = paramfv;
        this.n = localtk;
        a(paramBoolean);
    }

    public final void a(String paramString, cp paramcp) {
        this.b.put(paramString, paramcp);
    }

    public final void a(boolean paramBoolean) {
        this.h = paramBoolean;
    }

    public final void a(boolean paramBoolean, int paramInt) {
        if ((this.a.j()) && (!this.a.e().e)) {
        }
        for (td localtd = null; ; localtd = this.d) {
            a(new dm(localtd, this.e, this.l, this.a, paramBoolean, paramInt, this.a.i()));
            return;
        }
    }

    public final void a(boolean paramBoolean, int paramInt, String paramString) {
        fq localfq = null;
        boolean bool = this.a.j();
        td localtd;
        if ((bool) && (!this.a.e().e)) {
            localtd = null;
            if (!bool) {
                break label89;
            }
        }
        for (; ; ) {
            a(new dm(localtd, localfq, this.g, this.l, this.a, paramBoolean, paramInt, paramString, this.a.i(), this.i));
            return;
            localtd = this.d;
            break;
            label89:
            localfq = this.e;
        }
    }

    public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {
        boolean bool = this.a.j();
        td localtd;
        if ((bool) && (!this.a.e().e)) {
            localtd = null;
            if (!bool) {
                break label91;
            }
        }
        label91:
        for (fq localfq = null; ; localfq = this.e) {
            a(new dm(localtd, localfq, this.g, this.l, this.a, paramBoolean, paramInt, paramString1, paramString2, this.a.i(), this.i));
            return;
            localtd = this.d;
            break;
        }
    }

    public boolean b() {
        synchronized (this.c) {
            boolean bool = this.k;
            return bool;
        }
    }

    public void c() {
        if (b()) {
            this.m.b();
        }
    }

    public final void d() {
        synchronized (this.c) {
            this.b.clear();
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = false;
            this.k = false;
            this.i = null;
            this.l = null;
            return;
        }
    }

    public final void e() {
        synchronized (this.c) {
            this.h = false;
            this.k = true;
            fj localfj = this.a.d();
            if (localfj != null) {
                if (!mv.b()) {
                    mv.a.post(new nc(this, localfj));
                }
            } else {
                return;
            }
            localfj.k();
        }
    }

    public final void onLoadResource(WebView paramWebView, String paramString) {
        mx.d("Loading resource: " + paramString);
        paramWebView = Uri.parse(paramString);
        if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
            b(paramWebView);
        }
    }

    public final void onPageFinished(WebView paramWebView, String paramString) {
        if (this.f != null) {
            this.f.a(this.a);
            this.f = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        mx.d("AdWebView shouldOverrideUrlLoading: " + paramString);
        Uri localUri = Uri.parse(paramString);
        if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
            b(localUri);
        }
        for (; ; ) {
            return true;
            if ((this.h) && (paramWebView == this.a) && (a(localUri))) {
                return super.shouldOverrideUrlLoading(paramWebView, paramString);
            }
            if (!this.a.willNotDraw()) {
                try {
                    pv localpv = this.a.h();
                    paramWebView = localUri;
                    if (localpv != null) {
                        paramWebView = localUri;
                        if (localpv.b(localUri)) {
                            paramWebView = localpv.a(localUri, this.a.getContext());
                        }
                    }
                } catch (qu paramWebView) {
                    for (; ; ) {
                        mx.e("Unable to append parameter to URL: " + paramString);
                        paramWebView = localUri;
                    }
                    this.n.a(paramString);
                }
                if ((this.n == null) || (this.n.b())) {
                    a(new dj("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
                }
            } else {
                mx.e("AdWebView unable to handle URL: " + paramString);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
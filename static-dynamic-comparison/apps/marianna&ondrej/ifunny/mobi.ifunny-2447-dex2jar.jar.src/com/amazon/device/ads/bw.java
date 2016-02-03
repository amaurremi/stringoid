package com.amazon.device.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class bw
        extends WebViewClient {
    protected static final HashSet<String> a;
    protected static Set<String> b;
    private static final String c = bw.class.getSimpleName();
    private final Context d;
    private final bv e;
    private final HashMap<String, ca> f;

    static {
        a = new HashSet();
        a.add("tel");
        a.add("voicemail");
        a.add("sms");
        a.add("mailto");
        a.add("geo");
        a.add("google.streetview");
        b = new HashSet();
        b.add("aax-us-east.amazon-adsystem.com");
        b.add("aax-us-east.amazon-adsystem.com");
        b.add("aax-beta.integ.amazon.com");
        b.add("pda-bes.amazon.com");
        b.add("d16g-cornerstone-bes.integ.amazon.com");
    }

    public bw(bv parambv, Context paramContext) {
        this.d = paramContext;
        this.e = parambv;
        this.f = new HashMap();
        b();
    }

    private void b() {
        this.f.put("mopub", new bz(this));
        this.f.put("amazonmobile", new bx(this.e, this.d));
        by localby = new by(this);
        Iterator localIterator = a.iterator();
        while (localIterator.hasNext()) {
            a((String) localIterator.next(), localby);
        }
    }

    private static boolean c() {
        return (Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT <= 13);
    }

    protected String a(String paramString) {
        return Uri.parse(paramString).getScheme();
    }

    public void a(String paramString, ca paramca) {
        this.f.put(paramString, paramca);
    }

    protected boolean a(String paramString1, String paramString2) {
        boolean bool = false;
        if (paramString2 != null) {
            if (this.f.containsKey(paramString2)) {
                bool = ((ca) this.f.get(paramString2)).a(paramString1);
            }
        } else {
            return bool;
        }
        dv.a(c, "Scheme %s unrecognized. Launching external browser.", new Object[]{paramString2});
        return this.e.a(paramString1);
    }

    public void onLoadResource(WebView paramWebView, String paramString) {
        dv.a(c, "Loaded resource: %s", new Object[]{paramString});
    }

    public void onPageFinished(WebView paramWebView, String paramString) {
        if (this.e == null) {
            dv.e(c, "Call to onPageFinished() ignored because view is null.");
            return;
        }
        this.e.p();
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
        dv.b(c, "Error: %s", new Object[]{paramString1});
        super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
        boolean bool2 = false;
        boolean bool1 = false;
        if (this.e == null) {
        }
        for (; ; ) {
            return bool1;
            if (!this.e.g()) {
                return true;
            }
            paramWebView = Uri.parse(paramString);
            if ((b.contains(paramWebView.getHost())) && (!c())) {
            }
            for (bool1 = bool2; a(paramString, a(paramString)); bool1 = true) {
                return true;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
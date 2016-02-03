package com.inneractive.api.ads.sdk;

import android.net.Uri;

abstract class j {
    private StringBuilder a;
    private boolean b;

    protected final String a() {
        InneractiveAdView.Log.d("Inneractive_debug", "final url = " + this.a);
        return this.a.toString();
    }

    abstract String a(String paramString);

    protected final void a(String paramString1, String paramString2) {
        if (c.b(paramString2)) {
            return;
        }
        StringBuilder localStringBuilder = this.a;
        if (this.b) {
            this.b = false;
        }
        for (String str = "?"; ; str = "&") {
            localStringBuilder.append(str);
            this.a.append(paramString1);
            this.a.append("=");
            this.a.append(Uri.encode(paramString2));
            return;
        }
    }

    protected final void g(String paramString) {
        this.a = new StringBuilder("http://" + paramString);
        this.b = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
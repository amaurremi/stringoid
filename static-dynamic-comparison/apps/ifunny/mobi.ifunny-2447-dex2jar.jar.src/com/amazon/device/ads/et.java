package com.amazon.device.ads;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageButton;

class et
        extends AsyncTask<Void, Void, Void> {
    private final ViewGroup b;
    private final int c;
    private final int d;
    private final Intent e;

    public et(el paramel, Intent paramIntent, ViewGroup paramViewGroup, int paramInt1, int paramInt2) {
        this.e = paramIntent;
        this.b = paramViewGroup;
        this.c = paramInt1;
        this.d = paramInt2;
    }

    protected Void a(Void... paramVarArgs) {
        el.a(this.a, el.a(this.a, cn.a().a("amazon_ads_leftarrow.png"), 9, -1, this.c, this.d));
        el.c(this.a).setId(10537);
        el.b(this.a, el.a(this.a, cn.a().a("amazon_ads_rightarrow.png"), 1, el.c(this.a).getId(), this.c, this.d));
        el.d(this.a).setId(10794);
        el.c(this.a, el.a(this.a, cn.a().a("amazon_ads_close.png"), 11, -1, this.c, this.d));
        if (el.e(this.a)) {
            el.d(this.a, el.a(this.a, cn.a().a("amazon_ads_open_external_browser.png"), 1, el.d(this.a).getId(), this.c, this.d));
            el.f(this.a).setId(10795);
            el.e(this.a, el.a(this.a, cn.a().a("amazon_ads_refresh.png"), 1, el.f(this.a).getId(), this.c, this.d));
        }
        for (; ; ) {
            return null;
            el.e(this.a, el.a(this.a, cn.a().a("amazon_ads_refresh.png"), 1, el.d(this.a).getId(), this.c, this.d));
        }
    }

    protected void a(Void paramVoid) {
        this.b.addView(el.c(this.a));
        this.b.addView(el.d(this.a));
        this.b.addView(el.g(this.a));
        this.b.addView(el.h(this.a));
        if (el.e(this.a)) {
            this.b.addView(el.f(this.a));
        }
        el.a(this.a, this.e);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
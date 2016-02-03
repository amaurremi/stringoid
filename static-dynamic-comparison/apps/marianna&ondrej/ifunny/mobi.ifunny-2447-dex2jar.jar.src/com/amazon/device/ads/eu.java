package com.amazon.device.ads;

import android.content.Context;
import android.content.Intent;

class eu {
    private static final String a = eu.class.getSimpleName();
    private Context b;
    private String c;
    private boolean d;

    eu a() {
        this.d = true;
        return this;
    }

    eu a(Context paramContext) {
        this.b = paramContext;
        return this;
    }

    eu a(String paramString) {
        this.c = paramString;
        return this;
    }

    void b() {
        if (this.b == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (hu.d(this.c)) {
            throw new IllegalArgumentException("Url must not be null or white space");
        }
        if (!cn.a().c()) {
            dv.b(a, "Could not load application assets, failed to open URI: %s", new Object[]{this.c});
            return;
        }
        Intent localIntent = new Intent(this.b, AdActivity.class);
        localIntent.putExtra("adapter", el.class.getName());
        localIntent.putExtra("extra_url", this.c);
        localIntent.putExtra("extra_open_btn", this.d);
        localIntent.addFlags(268435456);
        this.b.startActivity(localIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
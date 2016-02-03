package com.amazon.device.ads;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class es
        implements View.OnClickListener {
    final String a = this.b.getStringExtra("extra_url");

    es(el paramel, Intent paramIntent) {
    }

    public void onClick(View paramView) {
        String str = el.b(this.c).getUrl();
        paramView = str;
        if (str == null) {
            dv.e(el.a, "The current URL is null. Reverting to the original URL for external browser.");
            paramView = this.a;
        }
        bs.a(paramView, el.b(this.c).getContext());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
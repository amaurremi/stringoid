package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class q
        implements View.OnClickListener {
    q(MoPubBrowser paramMoPubBrowser) {
    }

    public void onClick(View paramView) {
        MoPubBrowser.c(this.a).reload();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
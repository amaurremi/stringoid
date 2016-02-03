package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class p
        implements View.OnClickListener {
    p(MoPubBrowser paramMoPubBrowser) {
    }

    public void onClick(View paramView) {
        if (MoPubBrowser.c(this.a).canGoForward()) {
            MoPubBrowser.c(this.a).goForward();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
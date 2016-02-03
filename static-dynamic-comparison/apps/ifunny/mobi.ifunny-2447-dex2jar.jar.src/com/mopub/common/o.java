package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class o
        implements View.OnClickListener {
    o(MoPubBrowser paramMoPubBrowser) {
    }

    public void onClick(View paramView) {
        if (MoPubBrowser.c(this.a).canGoBack()) {
            MoPubBrowser.c(this.a).goBack();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
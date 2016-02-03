package com.inneractive.api.ads.sdk;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

final class InneractiveInternalBrowserActivity$4
        implements View.OnClickListener {
    InneractiveInternalBrowserActivity$4(InneractiveInternalBrowserActivity paramInneractiveInternalBrowserActivity) {
    }

    public final void onClick(View paramView) {
        if (InneractiveInternalBrowserActivity.c(this.a).canGoForward()) {
            InneractiveInternalBrowserActivity.c(this.a).goForward();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInternalBrowserActivity$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.inneractive.api.ads.sdk;

import android.view.View;
import android.view.View.OnClickListener;

final class InneractiveInternalBrowserActivity$6
        implements View.OnClickListener {
    InneractiveInternalBrowserActivity$6(InneractiveInternalBrowserActivity paramInneractiveInternalBrowserActivity) {
    }

    public final void onClick(View paramView) {
        if (InneractiveInternalBrowserActivity.a() != null) {
            InneractiveInternalBrowserActivity.a().onInternalBrowserDismissed();
        }
        this.a.finish();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInternalBrowserActivity$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
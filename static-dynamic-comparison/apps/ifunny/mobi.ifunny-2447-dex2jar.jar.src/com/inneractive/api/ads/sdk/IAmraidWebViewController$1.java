package com.inneractive.api.ads.sdk;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class IAmraidWebViewController$1
        implements View.OnKeyListener {
    IAmraidWebViewController$1(IAmraidWebViewController paramIAmraidWebViewController) {
    }

    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && (this.this$0.isExpanded())) {
            InneractiveAdView.Log.v("Inneractive_verbose", "back button pressed while ad is expanded, ad will be collapsed.");
            this.this$0.close();
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebViewController$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
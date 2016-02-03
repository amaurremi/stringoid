package com.mopub.mobileads;

import android.content.Context;

public class HtmlBannerWebView
        extends BaseHtmlWebView {
    public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";

    public HtmlBannerWebView(Context paramContext, AdConfiguration paramAdConfiguration) {
        super(paramContext, paramAdConfiguration);
    }

    public void init(CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, boolean paramBoolean, String paramString1, String paramString2) {
        super.init(paramBoolean);
        setWebViewClient(new HtmlWebViewClient(new HtmlBannerWebView.HtmlBannerWebViewListener(paramCustomEventBannerListener), this, paramString2, paramString1));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/HtmlBannerWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.HtmlInterstitialWebView;

public class HtmlInterstitialWebViewFactory {
    protected static HtmlInterstitialWebViewFactory a = new HtmlInterstitialWebViewFactory();

    public static HtmlInterstitialWebView create(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, boolean paramBoolean, String paramString1, String paramString2, AdConfiguration paramAdConfiguration) {
        return a.internalCreate(paramContext, paramCustomEventInterstitialListener, paramBoolean, paramString1, paramString2, paramAdConfiguration);
    }

    @Deprecated
    public static void setInstance(HtmlInterstitialWebViewFactory paramHtmlInterstitialWebViewFactory) {
        a = paramHtmlInterstitialWebViewFactory;
    }

    public HtmlInterstitialWebView internalCreate(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, boolean paramBoolean, String paramString1, String paramString2, AdConfiguration paramAdConfiguration) {
        paramContext = new HtmlInterstitialWebView(paramContext, paramAdConfiguration);
        paramContext.init(paramCustomEventInterstitialListener, paramBoolean, paramString1, paramString2);
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/HtmlInterstitialWebViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
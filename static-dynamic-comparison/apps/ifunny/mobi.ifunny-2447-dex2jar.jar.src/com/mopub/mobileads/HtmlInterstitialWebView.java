package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import com.mopub.common.util.VersionCode;

public class HtmlInterstitialWebView
        extends BaseHtmlWebView {
    protected static final String MOPUB_JS_INTERFACE_NAME = "mopubUriInterface";
    private Handler mHandler = new Handler();

    public HtmlInterstitialWebView(Context paramContext, AdConfiguration paramAdConfiguration) {
        super(paramContext, paramAdConfiguration);
    }

    private void postHandlerRunnable(Runnable paramRunnable) {
        this.mHandler.post(paramRunnable);
    }

    void addMoPubUriJavascriptInterface(HtmlInterstitialWebView.MoPubUriJavascriptFireFinishLoadListener paramMoPubUriJavascriptFireFinishLoadListener) {
        addJavascriptInterface(new HtmlInterstitialWebView .1
        MoPubUriJavascriptInterface(this, paramMoPubUriJavascriptFireFinishLoadListener), "mopubUriInterface");
    }

    @TargetApi(11)
    public void destroy() {
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
            removeJavascriptInterface("mopubUriInterface");
        }
        super.destroy();
    }

    public void init(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, boolean paramBoolean, String paramString1, String paramString2) {
        super.init(paramBoolean);
        setWebViewClient(new HtmlWebViewClient(new HtmlInterstitialWebView.HtmlInterstitialWebViewListener(paramCustomEventInterstitialListener), this, paramString2, paramString1));
        addMoPubUriJavascriptInterface(new HtmlInterstitialWebView .1 (this, paramCustomEventInterstitialListener));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/HtmlInterstitialWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
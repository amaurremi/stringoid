package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebView;

class AdRendererFactory {
    public static final String LOG_TAG = "AdRendererFactory";

    protected AdRenderer createHtmlRenderer(AdData paramAdData, AdController paramAdController, WebView paramWebView, Context paramContext) {
        return new HtmlRenderer(paramAdData, paramAdController, paramWebView, paramContext);
    }

    protected AdRenderer createMraidRenderer(AdData paramAdData, AdController paramAdController, WebView paramWebView, Context paramContext) {
        return new MraidRenderer(paramAdData, paramAdController, paramWebView, paramContext);
    }

    public AdRenderer getAdRenderer(AdData.AAXCreative paramAAXCreative, AdData paramAdData, AdController paramAdController, WebView paramWebView, Context paramContext) {
        switch (paramAAXCreative) {
            default:
                return null;
            case???:
            return createHtmlRenderer(paramAdData, paramAdController, paramWebView, paramContext);
        }
        return createMraidRenderer(paramAdData, paramAdController, paramWebView, paramContext);
    }

    protected Class<?> getAdRendererClass(AdData.AAXCreative paramAAXCreative) {
        switch (paramAAXCreative) {
            default:
                return null;
            case???:
            return HtmlRenderer.class;
        }
        return MraidRenderer.class;
    }

    public boolean shouldCreateNewRenderer(AdData.AAXCreative paramAAXCreative, AdRenderer paramAdRenderer) {
        return (paramAdRenderer == null) || (!paramAdRenderer.shouldReuse()) || (paramAdRenderer.getClass() != getAdRendererClass(paramAAXCreative));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdRendererFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
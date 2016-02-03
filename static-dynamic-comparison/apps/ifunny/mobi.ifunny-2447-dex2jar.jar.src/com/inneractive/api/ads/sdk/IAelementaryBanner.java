package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.net.Uri;

class IAelementaryBanner
        extends a {
    IAmraidWebView a;
    a.a b;
    String c = "OK";

    final void a() {
    }

    final void a(Context paramContext, a.a parama, IAresponseData paramIAresponseData) {
        this.b = parama;
        int i;
        IAadConfig localIAadConfig;
        if (!c.b(paramIAresponseData.a)) {
            i = 1;
            if (i == 0) {
                break label132;
            }
            parama = Uri.decode(paramIAresponseData.a);
            localIAadConfig = IAadConfig.a(paramIAresponseData);
            if (localIAadConfig != null) {
                this.c = localIAadConfig.y();
            }
            this.a = N.createInstance(paramContext, localIAadConfig);
            paramContext = new IAelementaryBanner .1 (this);
            this.a.setListener(paramContext);
            IAadConfig.a(this.a);
            paramIAresponseData = this.a;
            if (localIAadConfig == null) {
                break label145;
            }
        }
        label132:
        label145:
        for (paramContext = localIAadConfig.k(); ; paramContext = null) {
            paramIAresponseData.loadHtmlData(paramContext, "<script>(function() {\n\tif (window.iaPreCachedAd) {\n\t\tvar wasIaLoadFinishedNotified = false;\n\t\tvar IA_AD_FINISHED_LOADING_EVENT = 'iaadfinishedloading';\n\t\tvar NOTIFY_LOADING_FINISHED_TIMEOUT_IN_MS = 5000; \t\t/* Notifiying after 10 sec., Even if onload was not called yet. */\n\n\t\tvar iaNotifyLoadFinished = function() {\n\t\t\tif (!wasIaLoadFinishedNotified) {\n\t\t\t\twasIaLoadFinishedNotified = true;\n\t\t\t\t/*if (typeof UriJavascriptInterface !== 'undefined' && UriJavascriptInterface.fireFinishLoad()) return;\n*/\t\t\t\twindow.location.href = IA_AD_FINISHED_LOADING_EVENT + '://';\n\t\t\t}\n \t\t}\n\n\t\t/* Notifiying loadFinished after window.onload */\n\t\tvar prevOnload = window.onload;\n\t\twindow.onload = function() {\n\t\t\tif (typeof prevOnload === 'function') {\n\t\t\t\tprevOnload.apply();\n\t\t\t}\n\t\t\tiaNotifyLoadFinished.apply();\n\t\t};\n\t\tsetTimeout(function() {iaNotifyLoadFinished.apply();}, NOTIFY_LOADING_FINISHED_TIMEOUT_IN_MS);\n\t\t/* Overriding previous startAutoplay function... */\n\t\twindow.prevStartProjekktorVideoAutoplay = window.startProjekktorVideoAutoplay;\n\t\tstartProjekktorVideoAutoplay = function() {};\n\n\t\t/* Overriding previous skip/close button visibility changing function... */\n\t\tvar previaStartSkipButtonVisibleCountdown = window.iaStartSkipButtonVisibleCountdown;\n\t\twindow.iaStartSkipButtonVisibleCountdown = function() {};\n\n\t\t/* Send tracking pixels and run video JS. Triggered by the native SDKs. */\n\t\twindow.showInterstitial = function() {\n\t\t\tif (window.iaPreCachedAd) {\n\n\t\t\t\t/* Add impression tracking pixels */\n\t\t\t\tiaAddImpressionTrackingPixels()\n\n\t\t\t\t/* Starting video autoplay from JS on interstitial display */\n\t\t\t\tif (typeof prevStartProjekktorVideoAutoplay === 'function' && typeof iaAutoplaySupported !== 'undefined' && iaAutoplaySupported) {\n\t\t\t\t\twindow.prevStartProjekktorVideoAutoplay.apply();\n\t\t\t\t}\n\n\t\t\t\t/* Showing video skip button after timeout. */\n\t\t\t\tif (typeof previaStartSkipButtonVisibleCountdown === 'function') {\n\t\t\t\t\tpreviaStartSkipButtonVisibleCountdown.apply();\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t}\n})();</script>" + parama);
            return;
            i = 0;
            break;
            this.b.a(InneractiveAdView.InneractiveErrorCode.SERVER_INVALID_RESPONSE);
            return;
        }
    }

    final void b() {
        if (this.a != null) {
            this.a.setListener(null);
            this.a.destroy();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAelementaryBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
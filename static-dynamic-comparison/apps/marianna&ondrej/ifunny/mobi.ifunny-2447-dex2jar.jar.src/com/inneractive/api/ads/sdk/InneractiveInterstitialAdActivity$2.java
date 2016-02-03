package com.inneractive.api.ads.sdk;

final class InneractiveInterstitialAdActivity$2
        extends V {
    InneractiveInterstitialAdActivity$2(InneractiveInterstitialAdActivity paramInneractiveInterstitialAdActivity) {
    }

    public final void onAdWillOpenExternalApp() {
        if (InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.c();
        }
    }

    public final void onClicked() {
        if (InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.b();
        }
        InneractiveInterstitialAdActivity.access$000(this.this$0).loadUrl("javascript:if(typeof iaVideoPlayer !== 'undefined' && typeof iaVideoPlayer.getState === 'function') {alert('playerState'+iaVideoPlayer.getState())}");
        if (InneractiveInterstitialAdActivity.adConfiguration.x() != 9) {
            this.this$0.finish();
            return;
        }
        InneractiveInterstitialAdActivity.access$000(this.this$0).loadUrl("javascript: (function () {\tconsole.log('calling closeVastAdActivity via JS');\tif (typeof InneractiveCloseVastAdActivityInterface !== 'undefined' && typeof iaVideoPlayer !== 'undefined' && typeof iaVideoPlayer.getState === 'function') {  \t\tInneractiveCloseVastAdActivityInterface.closeVastAdActivity(iaVideoPlayer.getState());\t\tconsole.log('calling close vast ad with player state: ' + iaVideoPlayer.getState());\t} })()");
    }

    public final void onClose(IAbaseWebView paramIAbaseWebView, IAbaseWebView.IAviewState paramIAviewState) {
        onDismissed();
    }

    public final void onDismissed() {
        this.this$0.finish();
        if (InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.e();
        }
    }

    public final void onFailure(IAbaseWebView paramIAbaseWebView, InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        if (InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.a(InneractiveAdView.InneractiveErrorCode.UNSPECIFIED);
        }
        onDismissed();
    }

    public final void onInternalBrowserDismissed() {
        if (InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.d();
        }
    }

    public final void onReady(IAbaseWebView paramIAbaseWebView) {
        if (!InneractiveInterstitialAdActivity.isTrackingPixelSent) {
            InneractiveAdView.Log.v("Inneractive_verbose", "This is the first time so isTrackingPixelSent is false and will be set to true");
            InneractiveInterstitialAdActivity.access$000(this.this$0).loadUrl(IAbaseInterstitialAdActivity.JavaScriptWebViewCallbacks.a.a());
            if (InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
                InneractiveInterstitialAdActivity.mAdInterfaceListener.a();
            }
            InneractiveInterstitialAdActivity.isTrackingPixelSent = true;
            if (InneractiveInterstitialAdActivity.adConfiguration.x() != 9) {
                break label165;
            }
            if (!IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.h)) {
                break label152;
            }
            InneractiveInterstitialAdActivity.access$000(this.this$0).loadUrl(IAbaseInterstitialAdActivity.JavaScriptWebViewCallbacks.b.a());
            label86:
            InneractiveInterstitialAdActivity.access$000(this.this$0).loadUrl("javascript:(function(){ \n\tvar iaVastDoneListener = function(done) { \n       window.console.log('video is DONE. need to setStop.'); \n\t\tif (typeof InneractiveCloseVastAdActivityInterface !== 'undefined' && typeof iaVideoPlayer !== 'undefined') {InneractiveCloseVastAdActivityInterface.videoCompleted();console.log('calling video completed function');}\t\tif (typeof iaVideoPlayer !== 'undefined') {iaVideoPlayer.removeListener('done', iaVastDoneListener); window.console.log('iaVastDoneListener IS REMOVED');} \n\t};\tif (typeof iaVideoPlayer !== 'undefined') {iaVideoPlayer.addListener('done', iaVastDoneListener);} \n})();");
            this.this$0.concealInterstitialCloseBtn();
            InneractiveInterstitialAdActivity.access$000(this.this$0).loadUrl("javascript:document.getElementById(\"iaClose\").style.display =\"inline\";");
        }
        for (; ; ) {
            if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.h)) {
                InneractiveInterstitialAdActivity.access$000(this.this$0).loadUrl("javascript:var forceReflow = function(elem){ elem = elem || document.documentElement; elem.style.zIndex = 2147483646; var width = elem.style.width, px = elem.offsetWidth+1; elem.style.width = px+'px'; setTimeout(function(){ elem.style.zIndex = 2147483646; elem.style.width = width; elem = null; }, 0); }; forceReflow(document.documentElement);");
            }
            return;
            InneractiveAdView.Log.v("Inneractive_verbose", "This is NOT the first time so isTrackingPixelSent is TRUE!");
            break;
            label152:
            InneractiveInterstitialAdActivity.access$000(this.this$0).performVastAutoclick();
            break label86;
            label165:
            this.this$0.displayInterstitialCloseBtn();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialAdActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
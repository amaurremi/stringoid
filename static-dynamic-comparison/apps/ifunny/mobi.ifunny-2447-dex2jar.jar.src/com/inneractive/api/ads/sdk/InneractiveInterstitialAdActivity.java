package com.inneractive.api.ads.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class InneractiveInterstitialAdActivity
        extends IAbaseInterstitialAdActivity {
    static IAadConfig adConfiguration;
    static boolean isTrackingPixelSent;
    static boolean isVastCompleted;
    static a.a mAdInterfaceListener;
    static IAmraidWebView temporaryMraidView;
    private IAmraidWebView mMraidView;

    private static Intent createIntent(Context paramContext, String paramString, IAadConfig paramIAadConfig) {
        paramContext = new Intent(paramContext, InneractiveInterstitialAdActivity.class);
        paramContext.putExtra(IAdefines.AdParams.a.c, paramString);
        paramContext.putExtra(IAdefines.AdParams.b.c, paramIAadConfig);
        paramContext.addFlags(268435456);
        return paramContext;
    }

    static void displayAhead(Context paramContext, a.a parama, String paramString, IAadConfig paramIAadConfig) {
        Object localObject = null;
        mAdInterfaceListener = parama;
        adConfiguration = paramIAadConfig;
        isTrackingPixelSent = false;
        isVastCompleted = false;
        paramContext = N.createInstance(paramContext, null, IAmraidWebView.ExpandMode.DISABLED, IAmraidWebView.NativeCloseButtonMode.ALWAYS_VISIBLE, IAmraidWebView.MraidPlacementType.INTERSTITIAL);
        temporaryMraidView = paramContext;
        paramContext.enablePlugins(false);
        temporaryMraidView.clearCache(true);
        temporaryMraidView.clearHistory();
        temporaryMraidView.setVisibility(8);
        temporaryMraidView.setListener(new InneractiveInterstitialAdActivity .1 ());
        parama = temporaryMraidView;
        paramContext = (Context) localObject;
        if (adConfiguration != null) {
            paramContext = adConfiguration.k();
        }
        parama.loadHtmlData(paramContext, paramString);
    }

    static void onInvalidate() {
        if (temporaryMraidView != null) {
            temporaryMraidView.destroy();
            temporaryMraidView = null;
        }
    }

    public static void start(Context paramContext, String paramString, IAadConfig paramIAadConfig) {
        paramString = createIntent(paramContext, paramString, paramIAadConfig);
        try {
            paramContext.startActivity(paramString);
            return;
        } catch (ActivityNotFoundException paramContext) {
            InneractiveAdView.Log.i("Inneractive_info", "InneractiveInterstitialAdActivity.class not found. Did you declare InneractiveInterstitialAdActivity in your manifest?");
        }
    }

    void addCloseActivityJavascriptInterface() {
        if (this.mMraidView != null) {
            this.mMraidView.addJavascriptInterface(new InneractiveInterstitialAdActivity.a(this), "InneractiveCloseVastAdActivityInterface");
        }
    }

    public View getAdView() {
        this.mMraidView = N.createInstance(this, getAdConfig(), IAmraidWebView.ExpandMode.DISABLED, IAmraidWebView.NativeCloseButtonMode.AD_CONTROLLED, IAmraidWebView.MraidPlacementType.INTERSTITIAL);
        this.mMraidView.setListener(new InneractiveInterstitialAdActivity .2 (this));
        this.mMraidView.setOnCloseButtonStateChange(new InneractiveInterstitialAdActivity .3 (this));
        String str2 = getIntent().getStringExtra(IAdefines.AdParams.a.c);
        addCloseActivityJavascriptInterface();
        IAmraidWebView localIAmraidWebView = this.mMraidView;
        if (adConfiguration != null) {
        }
        for (String str1 = adConfiguration.k(); ; str1 = null) {
            localIAmraidWebView.loadHtmlData(str1, str2);
            return this.mMraidView;
        }
    }

    public void onBackPressed() {
        finish();
        if (mAdInterfaceListener != null) {
            mAdInterfaceListener.e();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.c)) {
            getWindow().setFlags(16777216, 16777216);
        }
        getCloseButton().setOnClickListener(new InneractiveInterstitialAdActivity .4 (this));
    }

    protected void onDestroy() {
        if (this.mMraidView != null) {
            this.mMraidView.destroy();
            this.mMraidView = null;
        }
        if (temporaryMraidView != null) {
            temporaryMraidView.destroy();
            temporaryMraidView = null;
        }
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.mMraidView != null) {
            this.mMraidView.onPause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.mMraidView != null) {
            this.mMraidView.onResume();
        }
    }

    protected void onStart() {
        InneractiveAdView.Log.d("Inneractive_debug", getClass().getSimpleName() + ".onStart(), " + this);
        if ((IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.c)) && (!isVastCompleted)) {
            onResume();
            if ((adConfiguration != null) && (adConfiguration.x() == 9)) {
                this.mMraidView.loadUrl("javascript:(function() {    if (typeof iaVideoPlayer !== 'undefined' && typeof iaVideoPlayer.getState === 'function') { \n   \tvar playerstate = iaVideoPlayer.getState(); \n   \twindow.console.log('PLAYERSTATE = ' + playerstate); \n   \tif(playerstate === 'PAUSED' || playerstate === 'IDLE'){ \n       \twindow.console.log('IDLE or PAUSED case. need to setPlay.'); \n           iaVideoPlayer.setPlay(); \n    \t}\n\t}\n})();");
            }
        }
        super.onStart();
    }

    protected void onStop() {
        InneractiveAdView.Log.d("Inneractive_debug", getClass().getSimpleName() + ".onStop(), " + this);
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.c)) {
            onPause();
            if ((adConfiguration != null) && (adConfiguration.x() == 9)) {
                this.mMraidView.loadUrl("javascript:(function() {    if (typeof iaVideoPlayer !== 'undefined' && typeof iaVideoPlayer.getState === 'function') { \n   \tvar playerstate = iaVideoPlayer.getState(); \n   \twindow.console.log('PLAYERSTATE = ' + playerstate); \n   \tif(playerstate === 'PLAYING'){ \n       \twindow.console.log('PLAYING case. need to setPause.'); \n           iaVideoPlayer.setPause(); \n    \t}\n\t}\n})();");
            }
        }
        super.onStop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveInterstitialAdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
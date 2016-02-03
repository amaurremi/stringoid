package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.factories.MraidViewFactory;
import com.mopub.mobileads.util.WebViews;

public class MraidActivity
        extends BaseInterstitialActivity {
    private MraidView mMraidView;

    private static Intent createIntent(Context paramContext, String paramString, AdConfiguration paramAdConfiguration) {
        paramContext = new Intent(paramContext, MraidActivity.class);
        paramContext.putExtra("Html-Response-Body", paramString);
        paramContext.putExtra("Ad-Configuration", paramAdConfiguration);
        paramContext.addFlags(268435456);
        return paramContext;
    }

    static void preRenderHtml(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, String paramString) {
        paramContext = MraidViewFactory.create(paramContext, null, MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.ALWAYS_VISIBLE, MraidView.PlacementType.INTERSTITIAL);
        paramContext.enablePlugins(false);
        paramContext.setMraidListener(new MraidActivity .1 (paramCustomEventInterstitialListener));
        paramContext.setWebViewClient(new MraidActivity .2 (paramCustomEventInterstitialListener));
        paramContext.loadHtmlData(paramString);
    }

    public static void start(Context paramContext, String paramString, AdConfiguration paramAdConfiguration) {
        paramString = createIntent(paramContext, paramString, paramAdConfiguration);
        try {
            paramContext.startActivity(paramString);
            return;
        } catch (ActivityNotFoundException paramContext) {
            Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
        }
    }

    public View getAdView() {
        this.mMraidView = MraidViewFactory.create(this, getAdConfiguration(), MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.AD_CONTROLLED, MraidView.PlacementType.INTERSTITIAL);
        this.mMraidView.setMraidListener(new MraidActivity .3 (this));
        this.mMraidView.setOnCloseButtonStateChange(new MraidActivity .4 (this));
        String str = getIntent().getStringExtra("Html-Response-Body");
        this.mMraidView.loadHtmlData(str);
        return this.mMraidView;
    }

    @TargetApi(11)
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.show");
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            getWindow().setFlags(16777216, 16777216);
        }
        addCloseEventRegion();
    }

    protected void onDestroy() {
        this.mMraidView.destroy();
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        WebViews.onPause(this.mMraidView);
    }

    protected void onResume() {
        super.onResume();
        WebViews.onResume(this.mMraidView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
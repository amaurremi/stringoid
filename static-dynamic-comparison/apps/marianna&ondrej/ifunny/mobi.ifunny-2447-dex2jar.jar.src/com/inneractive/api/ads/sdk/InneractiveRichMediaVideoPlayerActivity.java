package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InneractiveRichMediaVideoPlayerActivity
        extends InneractiveInterstitialAdActivity
        implements k.a {
    private k a;

    static void a(Context paramContext, String paramString) {
        Intent localIntent = new Intent(paramContext, InneractiveRichMediaVideoPlayerActivity.class);
        localIntent.setFlags(268435456);
        localIntent.putExtra("videoview_classname", "mraid");
        localIntent.putExtra("video_url", paramString);
        try {
            paramContext.startActivity(localIntent);
            return;
        } catch (Exception paramContext) {
            InneractiveAdView.Log.d("Inneractive_debug", "Activity InneractiveRichMediaVideoPlayerActivity was not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    public View getAdView() {
        if ("mraid".equals(getIntent().getStringExtra("videoview_classname"))) {
        }
        for (Object localObject = new S(this, getIntent(), this); ; localObject = new InneractiveRichMediaVideoPlayerActivity
        .1 (this, this))
        {
            this.a = ((k) localObject);
            return this.a;
            finish();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a.start();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onDisplayCloseButton() {
        displayInterstitialCloseBtn();
    }

    protected void onPause() {
        k localk = this.a;
        k.b();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        k localk = this.a;
        k.a();
    }

    public void onVideoClicked() {
    }

    public void onVideoCompleted(boolean paramBoolean) {
        displayInterstitialCloseBtn();
        if (paramBoolean) {
            finish();
        }
    }

    public void onVideoError(boolean paramBoolean) {
        InneractiveAdView.Log.d("Inneractive_debug", "Error: video can not be played.");
        displayInterstitialCloseBtn();
        if (paramBoolean) {
            finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveRichMediaVideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
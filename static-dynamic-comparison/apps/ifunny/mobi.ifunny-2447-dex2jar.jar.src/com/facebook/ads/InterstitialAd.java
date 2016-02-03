package com.facebook.ads;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.ads.internal.AdRequestController;
import com.facebook.ads.internal.AdResponse;
import com.facebook.ads.internal.AdType;
import com.facebook.ads.internal.HtmlAdDataModel;

import java.util.UUID;

public class InterstitialAd
        implements Ad {
    public static final String DISPLAY_HEIGHT_INTENT_EXTRA = "displayHeight";
    public static final String DISPLAY_ROTATION_INTENT_EXTRA = "displayRotation";
    public static final String DISPLAY_WIDTH_INTENT_EXTRA = "displayWidth";
    public static final String INTERSTITIAL_CLICKED = "com.facebook.ads.interstitial.clicked";
    public static final String INTERSTITIAL_DISMISSED = "com.facebook.ads.interstitial.dismissed";
    public static final String INTERSTITIAL_DISPLAYED = "com.facebook.ads.interstitial.displayed";
    public static final String INTERSTITIAL_UNIQUE_ID_EXTRA = "adInterstitialUniqueId";
    private InterstitialAdListener adListener;
    private boolean adLoaded = false;
    private AdRequestController adRequestController;
    private AdResponse adResponse;
    private final InterstitialAd.AdInterstitialBroadcastReceiver broadcastReceiver;
    private final Context context;
    private final String uniqueId;

    public InterstitialAd(Context paramContext, String paramString) {
        this.context = paramContext;
        this.uniqueId = UUID.randomUUID().toString();
        this.adRequestController = new AdRequestController(this.context, paramString, AdSize.INTERSTITIAL, false, AdType.HTML, new InterstitialAd
        .1 (this));
        this.broadcastReceiver = new InterstitialAd.AdInterstitialBroadcastReceiver(this, null);
        this.broadcastReceiver.register();
    }

    private void ensureAdRequestController() {
        if (this.adRequestController == null) {
            throw new RuntimeException("No request controller available, has the InterstitialAd been destroyed?");
        }
    }

    public void destroy() {
        if (this.adRequestController != null) {
            this.adRequestController.destroy();
            this.adRequestController = null;
            this.broadcastReceiver.unregister();
        }
    }

    public boolean isAdLoaded() {
        return this.adLoaded;
    }

    public void loadAd() {
        ensureAdRequestController();
        this.adLoaded = false;
        this.adRequestController.loadAd();
    }

    public void setAdListener(InterstitialAdListener paramInterstitialAdListener) {
        this.adListener = paramInterstitialAdListener;
    }

    public boolean show() {
        if (!this.adLoaded) {
            if (this.adListener != null) {
                this.adListener.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        Intent localIntent = new Intent(this.context, InterstitialAdActivity.class);
        if (this.adLoaded) {
            ((HtmlAdDataModel) this.adResponse.getDataModel()).addToIntentExtra(localIntent);
        }
        Display localDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localDisplay.getMetrics(localDisplayMetrics);
        localIntent.putExtra("displayRotation", localDisplay.getRotation());
        localIntent.putExtra("displayWidth", localDisplayMetrics.widthPixels);
        localIntent.putExtra("displayHeight", localDisplayMetrics.heightPixels);
        localIntent.putExtra("adInterstitialUniqueId", this.uniqueId);
        this.context.startActivity(localIntent);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
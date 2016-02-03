package com.facebook.ads;

import android.content.Context;
import android.widget.ImageView;
import com.facebook.ads.internal.AdRequestController;
import com.facebook.ads.internal.AdType;
import com.facebook.ads.internal.DownloadImageTask;
import com.facebook.ads.internal.NativeAdDataModel;

public class NativeAd
        implements Ad {
    private static final String TAG = NativeAd.class.getSimpleName();
    private NativeAdDataModel adDataModel;
    private AdListener adListener;
    private boolean adLoaded;
    private AdRequestController adRequestController;
    private final Context context;
    private volatile boolean loadRequested;

    public NativeAd(Context paramContext, String paramString) {
        this.context = paramContext;
        this.adRequestController = new AdRequestController(this.context, paramString, AdSize.INTERSTITIAL, false, AdType.NATIVE, new NativeAd
        .1 (this));
    }

    public static void downloadAndDisplayImage(NativeAd.Image paramImage, ImageView paramImageView) {
        new DownloadImageTask(paramImageView).execute(new String[]{paramImage.getUrl()});
    }

    private void ensureAdRequestController() {
        if (this.adRequestController == null) {
            throw new RuntimeException("No request controller available, has the NativeAd been destroyed?");
        }
    }

    public void destroy() {
        if (this.adRequestController != null) {
            this.adRequestController.destroy();
            this.adRequestController = null;
        }
    }

    public String getAdBody() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getBody();
    }

    public String getAdCallToAction() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getCallToAction();
    }

    public NativeAd.Image getAdCoverImage() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getImage();
    }

    public NativeAd.Image getAdIcon() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getIcon();
    }

    public String getAdSocialContext() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getSocialContext();
    }

    public NativeAd.Rating getAdStarRating() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getStarRating();
    }

    public String getAdTitle() {
        if (!this.adLoaded) {
            return null;
        }
        return this.adDataModel.getTitle();
    }

    public void handleClick() {
        if (this.adListener != null) {
            this.adListener.onAdClicked(this);
        }
        this.adDataModel.handleClick(this.context);
    }

    public boolean isAdLoaded() {
        return this.adLoaded;
    }

    public void loadAd() {
        if (this.loadRequested) {
            throw new IllegalStateException("Ad already loaded");
        }
        this.loadRequested = true;
        ensureAdRequestController();
        this.adRequestController.loadAd();
    }

    public void logImpression() {
        this.adDataModel.logImpression();
    }

    public void setAdListener(AdListener paramAdListener) {
        this.adListener = paramAdListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/NativeAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
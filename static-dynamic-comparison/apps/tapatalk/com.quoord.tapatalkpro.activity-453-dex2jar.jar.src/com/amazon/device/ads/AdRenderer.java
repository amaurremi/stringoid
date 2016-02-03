package com.amazon.device.ads;

import android.content.Context;

import java.util.Map;

abstract class AdRenderer
        implements AdView {
    protected static final String AAX_REDIRECT_BETA = "aax-beta.integ.amazon.com";
    protected static final String AAX_REDIRECT_GAMMA = "aax-us-east.amazon-adsystem.com";
    protected static final String AAX_REDIRECT_PROD = "aax-us-east.amazon-adsystem.com";
    protected static final String CORNERSTONE_BEST_ENDPOINT_BETA = "d16g-cornerstone-bes.integ.amazon.com";
    protected static final String CORNERSTONE_BEST_ENDPOINT_PROD = "pda-bes.amazon.com";
    private static final String LOG_TAG = "AdRenderer";
    protected AdData adData;
    protected final Context context;
    protected final IAdController controller;
    protected boolean isDestroyed = false;
    protected boolean isInitialized = false;
    private double scalingMultiplier = 1.0D;
    protected boolean viewRemoved = false;

    protected AdRenderer(AdData paramAdData, IAdController paramIAdController, Context paramContext) {
        this.adData = paramAdData;
        this.controller = paramIAdController;
        this.context = paramContext;
    }

    protected static double calculateScalingMultiplier(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        double d1 = paramInt3 / paramInt1;
        double d2 = paramInt4 / paramInt2;
        if (((d2 < d1) || (d1 == 0.0D)) && (d2 != 0.0D)) {
            d1 = d2;
        }
        for (; ; ) {
            d2 = d1;
            if (d1 == 0.0D) {
                d2 = 1.0D;
            }
            return d2;
        }
    }

    protected static double determineScalingMultiplier(AdData paramAdData, IAdController paramIAdController) {
        float f = InternalAdRegistration.getInstance().getDeviceInfo().getScalingFactorAsFloat();
        int i = (int) (paramAdData.getWidth() * f);
        int j = (int) (paramAdData.getHeight() * f);
        double d = calculateScalingMultiplier(i, j, paramIAdController.getWindowWidth(), paramIAdController.getWindowHeight());
        Log.d("AdRenderer", "Scaling Params: scalingDensity: %f, windowWidth: %d, windowHeight: %d, adWidth: %d, adHeight: %d, scale: %f", new Object[]{Float.valueOf(f), Integer.valueOf(paramIAdController.getWindowWidth()), Integer.valueOf(paramIAdController.getWindowHeight()), Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d)});
        return d;
    }

    protected void adLoaded(AdProperties paramAdProperties) {
        this.controller.adLoaded(paramAdProperties);
    }

    protected abstract void destroy();

    protected abstract boolean getAdState(AdState paramAdState);

    public int getHeight() {
        return this.adData.getHeight();
    }

    protected double getScalingMultiplier() {
        return this.scalingMultiplier;
    }

    public String getScalingMultiplierDescription() {
        if (getScalingMultiplier() > 1.0D) {
            return "u";
        }
        if ((getScalingMultiplier() < 1.0D) && (getScalingMultiplier() > 0.0D)) {
            return "d";
        }
        return "n";
    }

    public AdWebViewClient.UrlExecutor getSpecialUrlExecutor() {
        return this.controller.getSpecialUrlExecutor();
    }

    public void initialize() {
        this.scalingMultiplier = determineScalingMultiplier(this.adData, this.controller);
        this.isInitialized = true;
    }

    protected boolean isAdViewDestroyed() {
        return (!isInitialized()) || (this.isDestroyed);
    }

    protected boolean isAdViewRemoved() {
        return (!isInitialized()) || (this.viewRemoved);
    }

    public boolean isAdViewRenderable() {
        return (isInitialized()) && (!isAdViewRemoved()) && (!isAdViewDestroyed());
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    protected abstract void prepareToGoAway();

    protected abstract void removeView();

    protected abstract boolean render();

    protected abstract boolean sendCommand(String paramString, Map<String, String> paramMap);

    protected void setAd(AdData paramAdData) {
        this.adData = paramAdData;
    }

    public boolean shouldDisableWebViewHardwareAcceleration() {
        return this.controller.shouldDisableWebViewHardwareAcceleration();
    }

    protected abstract boolean shouldReuse();

    protected static enum AdState {
        EXPANDED;

        private AdState() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
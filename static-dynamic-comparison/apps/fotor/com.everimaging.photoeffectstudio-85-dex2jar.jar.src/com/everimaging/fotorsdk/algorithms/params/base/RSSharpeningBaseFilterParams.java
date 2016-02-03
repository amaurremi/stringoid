package com.everimaging.fotorsdk.algorithms.params.base;

public class RSSharpeningBaseFilterParams
        extends RSBaseParams {
    private ESharpeningMode mode;
    private int radius;
    private float sharpening = 1.0F;

    public ESharpeningMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.SHARPENING;
    }

    public int getRadius() {
        return this.radius;
    }

    public float getSharpening() {
        return this.sharpening;
    }

    public void setMode(ESharpeningMode paramESharpeningMode) {
        this.mode = paramESharpeningMode;
    }

    public void setRadius(int paramInt) {
        this.radius = paramInt;
    }

    public void setSharpening(float paramFloat) {
        this.sharpening = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSSharpeningBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
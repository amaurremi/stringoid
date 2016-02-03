package com.everimaging.fotorsdk.algorithms.params.base;

public class RSHSLAdjustmentBaseFilterParams
        extends RSBaseParams {
    private float hue;
    private float lightness;
    private EHSLAdjustmentMode mode;
    private float saturation;

    public float getHue() {
        return this.hue;
    }

    public float getLightness() {
        return this.lightness;
    }

    public EHSLAdjustmentMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.HSL_ADJUSTMENT;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public void setHue(float paramFloat) {
        this.hue = paramFloat;
    }

    public void setLightness(float paramFloat) {
        this.lightness = paramFloat;
    }

    public void setMode(EHSLAdjustmentMode paramEHSLAdjustmentMode) {
        this.mode = paramEHSLAdjustmentMode;
    }

    public void setSaturation(float paramFloat) {
        this.saturation = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSHSLAdjustmentBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.algorithms.params.base;

public class RSLevelBaseFilterParams
        extends RSBaseParams {
    float dark;
    float gamma;
    float light;
    private ELevelMode mode;
    float saturation;

    public float getDark() {
        return this.dark;
    }

    public float getGamma() {
        return this.gamma;
    }

    public float getLight() {
        return this.light;
    }

    public ELevelMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.LEVEL;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public void setDark(float paramFloat) {
        this.dark = paramFloat;
    }

    public void setGamma(float paramFloat) {
        this.gamma = paramFloat;
    }

    public void setLight(float paramFloat) {
        this.light = paramFloat;
    }

    public void setMode(ELevelMode paramELevelMode) {
        this.mode = paramELevelMode;
    }

    public void setSaturation(float paramFloat) {
        this.saturation = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSLevelBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
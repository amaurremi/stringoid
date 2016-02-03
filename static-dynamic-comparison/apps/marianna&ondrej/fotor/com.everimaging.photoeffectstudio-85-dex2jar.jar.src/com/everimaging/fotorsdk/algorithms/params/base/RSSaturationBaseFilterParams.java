package com.everimaging.fotorsdk.algorithms.params.base;

public class RSSaturationBaseFilterParams
        extends RSBaseParams {
    private ESaturationMode mode;
    private float saturation;

    public ESaturationMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.SATURATION;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public void setMode(ESaturationMode paramESaturationMode) {
        this.mode = paramESaturationMode;
    }

    public void setSaturation(float paramFloat) {
        this.saturation = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSSaturationBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
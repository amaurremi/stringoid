package com.everimaging.fotorsdk.algorithms.params.base;

public class RSBrightnessBaseFilterParams
        extends RSBaseParams {
    private float brightness;

    public float getBrightness() {
        return this.brightness;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.BRIGHTNESS;
    }

    public void setBrightness(float paramFloat) {
        this.brightness = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSBrightnessBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
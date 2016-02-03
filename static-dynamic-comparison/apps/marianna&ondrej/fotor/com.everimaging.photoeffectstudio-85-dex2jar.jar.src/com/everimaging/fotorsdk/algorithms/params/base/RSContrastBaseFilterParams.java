package com.everimaging.fotorsdk.algorithms.params.base;

public class RSContrastBaseFilterParams
        extends RSBaseParams {
    private float contrast;

    public float getContrast() {
        return this.contrast;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.CONTRAST;
    }

    public void setContrast(float paramFloat) {
        this.contrast = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSContrastBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.algorithms.params.base;

public class RSMosaicBaseFilterParams
        extends RSBaseParams {
    private float blurPixels;
    private EMosaicMode mode;

    public float getBlurPixels() {
        return this.blurPixels;
    }

    public EMosaicMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.MOSAIC;
    }

    public void setBlurPixels(float paramFloat) {
        this.blurPixels = paramFloat;
    }

    public void setMode(EMosaicMode paramEMosaicMode) {
        this.mode = paramEMosaicMode;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSMosaicBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
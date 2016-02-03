package com.everimaging.fotorsdk.algorithms.params.base;

public class RSDifferenceBlendBaseFilterParams
        extends RSBaseParams {
    private EDifferenceBlendMode mode;
    private float sigma;

    public EDifferenceBlendMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.DIFFERENCE_BLEND;
    }

    public float getSigma() {
        return this.sigma;
    }

    public void setMode(EDifferenceBlendMode paramEDifferenceBlendMode) {
        this.mode = paramEDifferenceBlendMode;
    }

    public void setSigma(float paramFloat) {
        this.sigma = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSDifferenceBlendBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
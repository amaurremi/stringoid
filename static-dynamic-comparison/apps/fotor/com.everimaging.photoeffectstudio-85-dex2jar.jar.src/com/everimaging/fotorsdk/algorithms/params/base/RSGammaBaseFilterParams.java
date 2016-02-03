package com.everimaging.fotorsdk.algorithms.params.base;

public class RSGammaBaseFilterParams
        extends RSBaseParams {
    private float gamma;

    public float getGamma() {
        return this.gamma;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.GAMMA;
    }

    public void setGamma(float paramFloat) {
        this.gamma = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSGammaBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
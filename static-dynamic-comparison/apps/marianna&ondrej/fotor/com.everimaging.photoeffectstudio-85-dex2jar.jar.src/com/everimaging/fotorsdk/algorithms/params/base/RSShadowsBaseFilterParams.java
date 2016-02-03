package com.everimaging.fotorsdk.algorithms.params.base;

public class RSShadowsBaseFilterParams
        extends RSBaseParams {
    private float shadows;

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.SHADOW;
    }

    public float getShadows() {
        return this.shadows;
    }

    public void setShadows(float paramFloat) {
        this.shadows = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSShadowsBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
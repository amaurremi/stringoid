package com.everimaging.fotorsdk.algorithms.params.base;

public class RSHighlightsBaseFilterParams
        extends RSBaseParams {
    private float highlights;

    public float getHighlights() {
        return this.highlights;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.HIGHLIGHTS;
    }

    public void setHighlights(float paramFloat) {
        this.highlights = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSHighlightsBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
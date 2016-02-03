package com.everimaging.fotorsdk.algorithms.params.base;

public class RSFacetBaseFilterParams
        extends RSBaseParams {
    private int intensityLevel;
    private int radius;

    public int getIntensityLevel() {
        return this.intensityLevel;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.FACET;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setIntensityLevel(int paramInt) {
        this.intensityLevel = paramInt;
    }

    public void setRadius(int paramInt) {
        this.radius = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSFacetBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
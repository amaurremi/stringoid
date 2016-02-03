package com.everimaging.fotorsdk.algorithms.params.base;

public class RSMinBaseFilterParams
        extends RSBaseParams {
    private int radius;

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.MIN;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int paramInt) {
        this.radius = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSMinBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
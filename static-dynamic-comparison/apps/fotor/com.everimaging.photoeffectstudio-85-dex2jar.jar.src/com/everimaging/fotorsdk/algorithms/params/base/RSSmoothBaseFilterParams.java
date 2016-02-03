package com.everimaging.fotorsdk.algorithms.params.base;

public class RSSmoothBaseFilterParams
        extends RSBaseParams {
    private ESmoothMode mode;
    private int radius;

    public ESmoothMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.SMOOTH;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setMode(ESmoothMode paramESmoothMode) {
        this.mode = paramESmoothMode;
    }

    public void setRadius(int paramInt) {
        this.radius = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSSmoothBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
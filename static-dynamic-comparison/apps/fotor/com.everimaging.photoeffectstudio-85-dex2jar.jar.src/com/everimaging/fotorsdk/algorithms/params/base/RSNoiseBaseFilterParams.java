package com.everimaging.fotorsdk.algorithms.params.base;

public class RSNoiseBaseFilterParams
        extends RSBaseParams {
    private int max = 255;
    private int min = 0;

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.NOISE;
    }

    public void setMax(int paramInt) {
        this.max = paramInt;
    }

    public void setMin(int paramInt) {
        this.min = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSNoiseBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
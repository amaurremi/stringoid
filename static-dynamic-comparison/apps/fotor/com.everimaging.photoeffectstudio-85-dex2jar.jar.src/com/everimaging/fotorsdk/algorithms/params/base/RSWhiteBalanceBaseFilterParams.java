package com.everimaging.fotorsdk.algorithms.params.base;

public class RSWhiteBalanceBaseFilterParams
        extends RSBaseParams {
    float temperature;
    float tint;

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.WHITE_BALANCE;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getTint() {
        return this.tint;
    }

    public void setTemperature(float paramFloat) {
        this.temperature = paramFloat;
    }

    public void setTint(float paramFloat) {
        this.tint = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSWhiteBalanceBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
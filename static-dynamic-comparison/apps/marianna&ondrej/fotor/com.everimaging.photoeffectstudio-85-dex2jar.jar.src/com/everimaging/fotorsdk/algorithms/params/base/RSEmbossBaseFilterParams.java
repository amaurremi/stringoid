package com.everimaging.fotorsdk.algorithms.params.base;

public class RSEmbossBaseFilterParams
        extends RSBaseParams {
    private EEmbossMode mode;
    private float strength;

    public EEmbossMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.EMBOSS;
    }

    public float getStrength() {
        return this.strength;
    }

    public void setMode(EEmbossMode paramEEmbossMode) {
        this.mode = paramEEmbossMode;
    }

    public void setStrength(float paramFloat) {
        this.strength = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSEmbossBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
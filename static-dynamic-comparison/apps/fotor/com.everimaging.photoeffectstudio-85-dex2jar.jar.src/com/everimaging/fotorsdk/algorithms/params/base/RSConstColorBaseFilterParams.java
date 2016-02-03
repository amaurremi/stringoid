package com.everimaging.fotorsdk.algorithms.params.base;

public class RSConstColorBaseFilterParams
        extends RSBaseParams {
    private float blue;
    private float green;
    private float red;

    public float getBlue() {
        return this.blue;
    }

    public float getGreen() {
        return this.green;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.CONST_COLOR;
    }

    public float getRed() {
        return this.red;
    }

    public void setBlue(float paramFloat) {
        this.blue = paramFloat;
    }

    public void setGreen(float paramFloat) {
        this.green = paramFloat;
    }

    public void setRed(float paramFloat) {
        this.red = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSConstColorBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
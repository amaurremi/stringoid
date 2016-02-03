package com.everimaging.fotorsdk.algorithms.params.base;

public class RSHSVSaturationBaseFilterParams
        extends RSBaseParams {
    private float blue;
    private float cyan;
    private float green;
    private float hue;
    private float magenta;
    private EHSVSaturation mode = EHSVSaturation.NORMAL;
    private float red;
    private float yellow;

    public float getBlue() {
        return this.blue;
    }

    public float getCyan() {
        return this.cyan;
    }

    public float getGreen() {
        return this.green;
    }

    public float getHue() {
        return this.hue;
    }

    public float getMagenta() {
        return this.magenta;
    }

    public EHSVSaturation getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.HSV_SATURATION;
    }

    public float getRed() {
        return this.red;
    }

    public float getYellow() {
        return this.yellow;
    }

    public void setBlue(float paramFloat) {
        this.blue = paramFloat;
    }

    public void setCyan(float paramFloat) {
        this.cyan = paramFloat;
    }

    public void setGreen(float paramFloat) {
        this.green = paramFloat;
    }

    public void setHue(float paramFloat) {
        this.hue = paramFloat;
    }

    public void setMagenta(float paramFloat) {
        this.magenta = paramFloat;
    }

    public void setMode(EHSVSaturation paramEHSVSaturation) {
        this.mode = paramEHSVSaturation;
    }

    public void setRed(float paramFloat) {
        this.red = paramFloat;
    }

    public void setYellow(float paramFloat) {
        this.yellow = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSHSVSaturationBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
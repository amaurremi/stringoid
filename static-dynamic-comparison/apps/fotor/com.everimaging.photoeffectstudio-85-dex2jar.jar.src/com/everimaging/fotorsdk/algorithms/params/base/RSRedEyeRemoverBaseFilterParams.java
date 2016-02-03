package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float2;

public class RSRedEyeRemoverBaseFilterParams
        extends RSBaseParams {
    private Float2 center;
    private int radius;

    public Float2 getCenter() {
        return this.center;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.RED_EYE_REMOVER;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setCenter(float paramFloat1, float paramFloat2) {
        this.center = new Float2(paramFloat1, paramFloat2);
    }

    public void setCenter(Float2 paramFloat2) {
        this.center = paramFloat2;
    }

    public void setRadius(int paramInt) {
        this.radius = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSRedEyeRemoverBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
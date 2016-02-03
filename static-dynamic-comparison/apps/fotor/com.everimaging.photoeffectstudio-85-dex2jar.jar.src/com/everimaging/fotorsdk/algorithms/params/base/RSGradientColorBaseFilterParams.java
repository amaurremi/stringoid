package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float3;

public class RSGradientColorBaseFilterParams
        extends RSBaseParams {
    private Float3 gradientColor0;
    private Float3 gradientColor1;
    private Float3 gradientColor3;
    private Float3 gradientColor4;
    private Float3 gradientColorDefault;
    private float ratio;

    public Float3 getGradientColor0() {
        return this.gradientColor0;
    }

    public Float3 getGradientColor1() {
        return this.gradientColor1;
    }

    public Float3 getGradientColor3() {
        return this.gradientColor3;
    }

    public Float3 getGradientColor4() {
        return this.gradientColor4;
    }

    public Float3 getGradientColorDefault() {
        return this.gradientColorDefault;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.GRADIENT_COLOR;
    }

    public float getRatio() {
        return this.ratio;
    }

    public void setGradientColor0(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.gradientColor0 = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setGradientColor1(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.gradientColor1 = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setGradientColor3(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.gradientColor3 = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setGradientColor4(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.gradientColor4 = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setGradientColorDefault(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.gradientColorDefault = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setRatio(float paramFloat) {
        this.ratio = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSGradientColorBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
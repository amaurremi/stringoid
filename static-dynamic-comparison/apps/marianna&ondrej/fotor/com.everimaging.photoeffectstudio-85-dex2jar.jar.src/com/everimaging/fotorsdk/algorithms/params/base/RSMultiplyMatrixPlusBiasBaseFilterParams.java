package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float3;

public class RSMultiplyMatrixPlusBiasBaseFilterParams
        extends RSBaseParams {
    private Float3 vectorB;
    private Float3 vectorBias;
    private Float3 vectorG;
    private Float3 vectorR;

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.MULTIPLY_MATRIX_PLUS_BIAS;
    }

    public Float3 getVectorB() {
        return this.vectorB;
    }

    public Float3 getVectorBias() {
        return this.vectorBias;
    }

    public Float3 getVectorG() {
        return this.vectorG;
    }

    public Float3 getVectorR() {
        return this.vectorR;
    }

    public void setVectorB(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.vectorB = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setVectorBias(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.vectorBias = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setVectorG(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.vectorG = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setVectorR(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.vectorR = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSMultiplyMatrixPlusBiasBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
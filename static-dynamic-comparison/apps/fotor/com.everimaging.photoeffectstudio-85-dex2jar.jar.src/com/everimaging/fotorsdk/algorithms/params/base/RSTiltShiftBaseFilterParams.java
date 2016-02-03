package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;

public class RSTiltShiftBaseFilterParams
        extends RSBaseParams {
    private Float2 blurCentralPos;
    private Float2 blurNormal;
    private float blurRange;
    private float blurStart;
    private ETiltShiftMode mode;
    private Float2 radiusStart;
    private Float4 rotationMatrix;

    public Float2 getBlurCentralPos() {
        return this.blurCentralPos;
    }

    public Float2 getBlurNormal() {
        return this.blurNormal;
    }

    public float getBlurRange() {
        return this.blurRange;
    }

    public float getBlurStart() {
        return this.blurStart;
    }

    public ETiltShiftMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.TILT_SHIFT;
    }

    public Float2 getRadiusStart() {
        return this.radiusStart;
    }

    public Float4 getRotationMatrix() {
        return this.rotationMatrix;
    }

    public void setBlurCentralPos(float paramFloat1, float paramFloat2) {
        this.blurCentralPos = new Float2(paramFloat1, paramFloat2);
    }

    public void setBlurNormal(float paramFloat1, float paramFloat2) {
        this.blurNormal = new Float2(paramFloat1, paramFloat2);
    }

    public void setBlurRange(float paramFloat) {
        this.blurRange = paramFloat;
    }

    public void setBlurStart(float paramFloat) {
        this.blurStart = paramFloat;
    }

    public void setMode(ETiltShiftMode paramETiltShiftMode) {
        this.mode = paramETiltShiftMode;
    }

    public void setRadiusStart(float paramFloat1, float paramFloat2) {
        this.radiusStart = new Float2(paramFloat1, paramFloat2);
    }

    public void setRotationMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.rotationMatrix = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSTiltShiftBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;

public class RSVignetteBaseFilterParams
        extends RSBaseParams {
    private float amount;
    private EBlendMode blendMode;
    private float center;
    private Float4 color;
    private float intensity;
    private EVignetteMode mode;
    private int type;
    private Float2 vignette;
    private Float2 vignetteCenter;
    private float vignetteRange;
    private float vignetteStart;

    public float getAmount() {
        return this.amount;
    }

    public EBlendMode getBlendMode() {
        return this.blendMode;
    }

    public float getCenter() {
        return this.center;
    }

    public Float4 getColor() {
        return this.color;
    }

    public float getIntensity() {
        return this.intensity;
    }

    public EVignetteMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.VIGNETTE;
    }

    public int getType() {
        return this.type;
    }

    public Float2 getVignette() {
        return this.vignette;
    }

    public Float2 getVignetteCenter() {
        return this.vignetteCenter;
    }

    public float getVignetteRange() {
        return this.vignetteRange;
    }

    public float getVignetteStart() {
        return this.vignetteStart;
    }

    public void setAmount(float paramFloat) {
        this.amount = paramFloat;
    }

    public void setBlendMode(EBlendMode paramEBlendMode) {
        this.blendMode = paramEBlendMode;
    }

    public void setCenter(float paramFloat) {
        this.center = paramFloat;
    }

    public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.color = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void setIntensity(float paramFloat) {
        this.intensity = paramFloat;
    }

    public void setMode(EVignetteMode paramEVignetteMode) {
        this.mode = paramEVignetteMode;
    }

    public void setType(int paramInt) {
        this.type = paramInt;
    }

    public void setVignette(float paramFloat1, float paramFloat2) {
        this.vignette = new Float2(paramFloat1, paramFloat2);
    }

    public void setVignetteCenter(float paramFloat1, float paramFloat2) {
        this.vignetteCenter = new Float2(paramFloat1, paramFloat2);
    }

    public void setVignetteRange(float paramFloat) {
        this.vignetteRange = paramFloat;
    }

    public void setVignetteStart(float paramFloat) {
        this.vignetteStart = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSVignetteBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
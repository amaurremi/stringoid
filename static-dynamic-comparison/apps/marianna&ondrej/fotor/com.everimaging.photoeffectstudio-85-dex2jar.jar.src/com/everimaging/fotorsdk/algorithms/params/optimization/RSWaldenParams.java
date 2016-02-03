package com.everimaging.fotorsdk.algorithms.params.optimization;

import com.everimaging.fotorsdk.algorithms.params.base.EVignetteMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams.RSParamTypes;

public class RSWaldenParams
        extends RSBaseParams {
    private float dark;
    private float light;
    private float saturation;
    private float strength;
    private EVignetteMode vignetteMode;
    private float vignetteRange;
    private float vignetteStart;

    public float getDark() {
        return this.dark;
    }

    public float getLight() {
        return this.light;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.WALDEN;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public float getStrength() {
        return this.strength;
    }

    public EVignetteMode getVignetteMode() {
        return this.vignetteMode;
    }

    public float getVignetteRange() {
        return this.vignetteRange;
    }

    public float getVignetteStart() {
        return this.vignetteStart;
    }

    public void setDark(float paramFloat) {
        this.dark = paramFloat;
    }

    public void setLight(float paramFloat) {
        this.light = paramFloat;
    }

    public void setSaturation(float paramFloat) {
        this.saturation = paramFloat;
    }

    public void setStrength(float paramFloat) {
        this.strength = paramFloat;
    }

    public void setVignetteMode(EVignetteMode paramEVignetteMode) {
        this.vignetteMode = paramEVignetteMode;
    }

    public void setVignetteRange(float paramFloat) {
        this.vignetteRange = paramFloat;
    }

    public void setVignetteStart(float paramFloat) {
        this.vignetteStart = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/optimization/RSWaldenParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
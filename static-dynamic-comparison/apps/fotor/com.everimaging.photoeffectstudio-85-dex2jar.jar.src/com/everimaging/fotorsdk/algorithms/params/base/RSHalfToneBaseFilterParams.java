package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float3;

public class RSHalfToneBaseFilterParams
        extends RSBaseParams {
    private int amount;
    private boolean gray;
    private Float3 halfToneColor0;
    private Float3 halfToneColor1;

    public int getAmount() {
        return this.amount;
    }

    public Float3 getHalfToneColor0() {
        return this.halfToneColor0;
    }

    public Float3 getHalfToneColor1() {
        return this.halfToneColor1;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.HALF_TONE;
    }

    public boolean isGray() {
        return this.gray;
    }

    public void setAmount(int paramInt) {
        this.amount = paramInt;
    }

    public void setGray(boolean paramBoolean) {
        this.gray = paramBoolean;
    }

    public void setHalfToneColor0(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.halfToneColor0 = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setHalfToneColor1(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.halfToneColor1 = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSHalfToneBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
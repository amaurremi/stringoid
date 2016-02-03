package com.everimaging.fotorsdk.algorithms.params.optimization;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams.RSParamTypes;

public class RSHotFudgeParams
        extends RSBaseParams {
    private float strength;

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.HOT_FUDGE;
    }

    public float getStrength() {
        return this.strength;
    }

    public void setStrength(float paramFloat) {
        this.strength = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/optimization/RSHotFudgeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
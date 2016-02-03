package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float3;

public class RSTechnicolorBaseFilterParams
        extends RSBaseParams {
    private Float3 technicolorGreen;
    private Float3 technicolorRed;

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.TECHNICOLOR;
    }

    public Float3 getTechnicolorGreen() {
        return this.technicolorGreen;
    }

    public Float3 getTechnicolorRed() {
        return this.technicolorRed;
    }

    public void setTechnicolorGreen(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.technicolorGreen = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }

    public void setTechnicolorRed(float paramFloat1, float paramFloat2, float paramFloat3) {
        this.technicolorRed = new Float3(paramFloat1, paramFloat2, paramFloat3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSTechnicolorBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
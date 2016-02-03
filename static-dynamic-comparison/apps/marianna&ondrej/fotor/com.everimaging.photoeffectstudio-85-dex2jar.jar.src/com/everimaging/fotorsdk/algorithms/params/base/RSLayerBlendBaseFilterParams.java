package com.everimaging.fotorsdk.algorithms.params.base;

public class RSLayerBlendBaseFilterParams
        extends RSBaseParams {
    private EBlendMode mode;
    private float opacity;
    private boolean opacityTex;
    private EBlendType type = EBlendType.STRETCH;

    public EBlendMode getMode() {
        return this.mode;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.LAYER_BLEND;
    }

    public EBlendType getType() {
        return this.type;
    }

    public boolean isOpacityTex() {
        return this.opacityTex;
    }

    public void setMode(EBlendMode paramEBlendMode) {
        this.mode = paramEBlendMode;
    }

    public void setOpacity(float paramFloat) {
        this.opacity = paramFloat;
    }

    public void setOpacityTex(boolean paramBoolean) {
        this.opacityTex = paramBoolean;
    }

    public void setType(EBlendType paramEBlendType) {
        this.type = paramEBlendType;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSLayerBlendBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
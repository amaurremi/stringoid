package com.everimaging.fotorsdk.algorithms.params.base;

public class RSAnisotropicDiffusionBaseFilterParams
        extends RSBaseParams {
    private float C;
    private float alpha;
    private float dt;
    private boolean gray;
    private float lambda;
    private float m;
    private EAnisotropicDiffusionMode mode;
    private float rho;
    private float sigma;

    public float getAlpha() {
        return this.alpha;
    }

    public float getC() {
        return this.C;
    }

    public float getDt() {
        return this.dt;
    }

    public float getLambda() {
        return this.lambda;
    }

    public float getM() {
        return this.m;
    }

    public EAnisotropicDiffusionMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.ANISOTROPIC_DIFFUSION;
    }

    public float getRho() {
        return this.rho;
    }

    public float getSigma() {
        return this.sigma;
    }

    public boolean isGray() {
        return this.gray;
    }

    public void setAlpha(float paramFloat) {
        this.alpha = paramFloat;
    }

    public void setC(float paramFloat) {
        this.C = paramFloat;
    }

    public void setDt(float paramFloat) {
        this.dt = paramFloat;
    }

    public void setGray(boolean paramBoolean) {
        this.gray = paramBoolean;
    }

    public void setLambda(float paramFloat) {
        this.lambda = paramFloat;
    }

    public void setM(float paramFloat) {
        this.m = paramFloat;
    }

    public void setMode(EAnisotropicDiffusionMode paramEAnisotropicDiffusionMode) {
        this.mode = paramEAnisotropicDiffusionMode;
    }

    public void setRho(float paramFloat) {
        this.rho = paramFloat;
    }

    public void setSigma(float paramFloat) {
        this.sigma = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSAnisotropicDiffusionBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.algorithms.filter.params;

import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;
import com.everimaging.fotorsdk.algorithms.params.base.ETiltShiftMode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TiltShiftParams
        extends BaseParams {
    private Float2 mBlurCentralPos;
    private Float2 mBlurNormal;
    private float mBlurRange;
    private float mBlurStart;
    private ETiltShiftMode mCurrentMode;
    private int mProcessImgHeight;
    private int mProcessImgWidth;
    private Float2 mRadiusStart;
    private Float4 mRotationMatrix;
    private int mStrength;

    public TiltShiftParams() {
        super(BaseParams.ParamsType.TILT_SHIFT);
    }

    public Float2 getBlurCentralPos() {
        return this.mBlurCentralPos;
    }

    public Float2 getBlurNormal() {
        return this.mBlurNormal;
    }

    public float getBlurRange() {
        return this.mBlurRange;
    }

    public float getBlurStart() {
        return this.mBlurStart;
    }

    public ETiltShiftMode getMode() {
        return this.mCurrentMode;
    }

    public int getProcessImgHeight() {
        return this.mProcessImgHeight;
    }

    public int getProcessImgWidth() {
        return this.mProcessImgWidth;
    }

    public Float2 getRadiusStart() {
        return this.mRadiusStart;
    }

    public Float4 getRotationMatrix() {
        return this.mRotationMatrix;
    }

    public int getStrength() {
        return this.mStrength;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (TiltShiftParams) new GsonBuilder().create().fromJson(paramString, getClass());
        this.mBlurCentralPos = paramString.mBlurCentralPos;
        this.mBlurNormal = paramString.mBlurNormal;
        this.mBlurRange = paramString.mBlurRange;
        this.mBlurStart = paramString.mBlurStart;
        this.mCurrentMode = paramString.mCurrentMode;
        this.mRadiusStart = paramString.mRadiusStart;
        this.mRotationMatrix = paramString.mRotationMatrix;
        this.mStrength = paramString.mStrength;
        this.mProcessImgWidth = paramString.mProcessImgWidth;
        this.mProcessImgHeight = paramString.mProcessImgHeight;
    }

    public void setBlurCentralPos(float paramFloat1, float paramFloat2) {
        this.mBlurCentralPos = new Float2(paramFloat1, paramFloat2);
    }

    public void setBlurNormal(float paramFloat1, float paramFloat2) {
        this.mBlurNormal = new Float2(paramFloat1, paramFloat2);
    }

    public void setBlurRange(float paramFloat) {
        this.mBlurRange = paramFloat;
    }

    public void setBlurStart(float paramFloat) {
        this.mBlurStart = paramFloat;
    }

    public void setMode(ETiltShiftMode paramETiltShiftMode) {
        this.mCurrentMode = paramETiltShiftMode;
    }

    public void setProcessImgSize(int paramInt1, int paramInt2) {
        this.mProcessImgWidth = paramInt1;
        this.mProcessImgHeight = paramInt2;
    }

    public void setRadian(float paramFloat) {
        float f = (float) Math.sin(paramFloat);
        paramFloat = (float) Math.cos(paramFloat);
        this.mBlurNormal = new Float2(f, paramFloat);
        this.mRotationMatrix = new Float4(paramFloat, -f, f, paramFloat);
    }

    public void setRadiusStart(float paramFloat1, float paramFloat2) {
        this.mRadiusStart = new Float2(paramFloat1, paramFloat2);
    }

    public void setRotationMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.mRotationMatrix = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }

    public void setStrength(int paramInt) {
        this.mStrength = paramInt;
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/params/TiltShiftParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.filter.params;

import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.everimaging.fotorsdk.brush.brush.TiltShiftBrush.TiltShiftMode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TiltShiftParams
        extends BaseParams {
    private int mAlpha;
    private float mCenterX;
    private float mCenterY;
    private float mDegress;
    private float mInnerRadius;
    private float mInnerRadiusY;
    private TiltShiftBrush.TiltShiftMode mMode;
    private float mOuterRadius;
    private int mProcessImgHeight;
    private int mProcessImgWidth;
    private float mStrength;

    public TiltShiftParams() {
        super(BaseParams.ParamsType.TILT_SHIFT);
    }

    public void applyScale(float paramFloat) {
        this.mCenterX *= paramFloat;
        this.mCenterY *= paramFloat;
        this.mInnerRadius *= paramFloat;
        this.mInnerRadiusY *= paramFloat;
        this.mStrength *= paramFloat;
        if (this.mMode == TiltShiftBrush.TiltShiftMode.VECTOR) {
            this.mOuterRadius *= paramFloat;
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public float getDegress() {
        return this.mDegress;
    }

    public float getInnerRadius() {
        return this.mInnerRadius;
    }

    public float getInnerRadiusY() {
        return this.mInnerRadiusY;
    }

    public TiltShiftBrush.TiltShiftMode getMode() {
        return this.mMode;
    }

    public float getOuterRadius() {
        return this.mOuterRadius;
    }

    public float getOuterRadiusValue() {
        float f = this.mOuterRadius;
        if (getMode() == TiltShiftBrush.TiltShiftMode.VECTOR) {
            return f;
        }
        return this.mOuterRadius * this.mInnerRadius - this.mInnerRadius;
    }

    public int getProcessImgHeight() {
        return this.mProcessImgHeight;
    }

    public int getProcessImgWidth() {
        return this.mProcessImgWidth;
    }

    public float getStrength() {
        return this.mStrength;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (TiltShiftParams) new GsonBuilder().create().fromJson(paramString, getClass());
        this.mAlpha = paramString.mAlpha;
        this.mMode = paramString.mMode;
        this.mCenterX = paramString.mCenterX;
        this.mCenterY = paramString.mCenterY;
        this.mInnerRadius = paramString.mInnerRadius;
        this.mInnerRadiusY = paramString.mInnerRadiusY;
        this.mOuterRadius = paramString.mOuterRadius;
        this.mProcessImgWidth = paramString.mProcessImgWidth;
        this.mProcessImgHeight = paramString.mProcessImgHeight;
        this.mStrength = paramString.mStrength;
        this.mDegress = paramString.mDegress;
    }

    public void setAlpha(int paramInt) {
        this.mAlpha = paramInt;
    }

    public void setCenterX(float paramFloat) {
        this.mCenterX = paramFloat;
    }

    public void setCenterY(float paramFloat) {
        this.mCenterY = paramFloat;
    }

    public void setDegress(float paramFloat) {
        this.mDegress = paramFloat;
    }

    public void setInnerRadius(float paramFloat) {
        this.mInnerRadius = paramFloat;
    }

    public void setInnerRadiusY(float paramFloat) {
        this.mInnerRadiusY = paramFloat;
    }

    public void setMode(TiltShiftBrush.TiltShiftMode paramTiltShiftMode) {
        this.mMode = paramTiltShiftMode;
    }

    public void setOuterRadius(float paramFloat) {
        this.mOuterRadius = paramFloat;
    }

    public void setProcessImgHeight(int paramInt) {
        this.mProcessImgHeight = paramInt;
    }

    public void setProcessImgSize(int paramInt1, int paramInt2) {
        this.mProcessImgWidth = paramInt1;
        this.mProcessImgHeight = paramInt2;
    }

    public void setProcessImgWidth(int paramInt) {
        this.mProcessImgWidth = paramInt;
    }

    public void setStrength(float paramFloat) {
        this.mStrength = paramFloat;
    }

    public void setStrength(int paramInt) {
        this.mStrength = paramInt;
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/filter/params/TiltShiftParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
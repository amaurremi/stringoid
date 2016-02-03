package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float4;

public class RSFrameBaseFilterParams
        extends RSBaseParams {
    private Float4[] borderBlock = new Float4[8];
    private Float4 bottom;
    private float height;
    private Float4 left;
    private Float4 leftBottom;
    private Float4 leftTop;
    private EFrameMode mode;
    private Float4 right;
    private Float4 rightBottom;
    private Float4 rightTop;
    private Float2 thickness;
    private Float4 top;
    private float width;

    public Float4[] getBorderBlock() {
        return this.borderBlock;
    }

    public Float4 getBottom() {
        return this.bottom;
    }

    public float getHeight() {
        return this.height;
    }

    public Float4 getLeft() {
        return this.left;
    }

    public Float4 getLeftBottom() {
        return this.leftBottom;
    }

    public Float4 getLeftTop() {
        return this.leftTop;
    }

    public EFrameMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.FRAME;
    }

    public Float4 getRight() {
        return this.right;
    }

    public Float4 getRightBottom() {
        return this.rightBottom;
    }

    public Float4 getRightTop() {
        return this.rightTop;
    }

    public Float2 getThickness() {
        return this.thickness;
    }

    public Float4 getTop() {
        return this.top;
    }

    public float getWidth() {
        return this.width;
    }

    public void setBorderBlock(Float4[] paramArrayOfFloat4) {
        this.borderBlock = paramArrayOfFloat4;
        this.leftTop = paramArrayOfFloat4[0];
        this.top = paramArrayOfFloat4[1];
        this.rightTop = paramArrayOfFloat4[2];
        this.right = paramArrayOfFloat4[3];
        this.rightBottom = paramArrayOfFloat4[4];
        this.bottom = paramArrayOfFloat4[5];
        this.leftBottom = paramArrayOfFloat4[6];
        this.left = paramArrayOfFloat4[7];
    }

    public void setBottom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.bottom = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[5] = this.bottom;
    }

    public void setBottom(Float4 paramFloat4) {
        this.bottom = paramFloat4;
        this.borderBlock[5] = this.bottom;
    }

    public void setHeight(float paramFloat) {
        this.height = paramFloat;
    }

    public void setLeft(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.left = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[7] = this.left;
    }

    public void setLeft(Float4 paramFloat4) {
        this.left = paramFloat4;
        this.borderBlock[7] = this.left;
    }

    public void setLeftBottom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.leftBottom = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[6] = this.leftBottom;
    }

    public void setLeftBottom(Float4 paramFloat4) {
        this.leftBottom = paramFloat4;
        this.borderBlock[6] = this.leftBottom;
    }

    public void setLeftTop(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.leftTop = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[0] = this.leftTop;
    }

    public void setLeftTop(Float4 paramFloat4) {
        this.leftTop = paramFloat4;
        this.borderBlock[0] = this.leftTop;
    }

    public void setMode(EFrameMode paramEFrameMode) {
        this.mode = paramEFrameMode;
    }

    public void setRight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.right = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[3] = this.right;
    }

    public void setRight(Float4 paramFloat4) {
        this.right = paramFloat4;
        this.borderBlock[3] = this.right;
    }

    public void setRightBottom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.rightBottom = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[4] = this.rightBottom;
    }

    public void setRightBottom(Float4 paramFloat4) {
        this.rightBottom = paramFloat4;
        this.borderBlock[4] = this.rightBottom;
    }

    public void setRightTop(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.rightTop = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[2] = this.rightTop;
    }

    public void setRightTop(Float4 paramFloat4) {
        this.rightTop = paramFloat4;
        this.borderBlock[2] = this.rightTop;
    }

    public void setThickness(Float2 paramFloat2) {
        this.thickness = paramFloat2;
    }

    public void setTop(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        this.top = new Float4(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        this.borderBlock[1] = this.top;
    }

    public void setTop(Float4 paramFloat4) {
        this.top = paramFloat4;
        this.borderBlock[1] = this.top;
    }

    public void setWidth(float paramFloat) {
        this.width = paramFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSFrameBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
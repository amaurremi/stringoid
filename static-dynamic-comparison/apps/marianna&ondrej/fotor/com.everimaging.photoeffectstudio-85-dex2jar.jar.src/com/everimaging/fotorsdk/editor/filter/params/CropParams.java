package com.everimaging.fotorsdk.editor.filter.params;

import android.graphics.Rect;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CropParams
        extends BaseParams {
    private Rect mCropBounds = new Rect();
    private int mPreviewHeight = 0;
    private int mPreviewWidth = 0;
    private float mStraiDegree = 0.0F;
    private int[] mStraiSize = new int[2];

    public CropParams() {
        super(BaseParams.ParamsType.CROP);
    }

    public Rect getCropBounds() {
        return new Rect(this.mCropBounds);
    }

    public int getPreviewHeight() {
        return this.mPreviewHeight;
    }

    public int getPreviewWidth() {
        return this.mPreviewWidth;
    }

    public float getStraiDegree() {
        return this.mStraiDegree;
    }

    public int[] getStraiSize() {
        return this.mStraiSize;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (CropParams) new GsonBuilder().create().fromJson(paramString, getClass());
        setCropBounds(paramString.mCropBounds);
        this.mStraiDegree = paramString.mStraiDegree;
        this.mStraiSize = paramString.mStraiSize;
        this.mPreviewWidth = paramString.mPreviewWidth;
        this.mPreviewHeight = paramString.mPreviewHeight;
    }

    public void setCropBounds(Rect paramRect) {
        this.mCropBounds = new Rect(paramRect);
    }

    public void setPreviewSize(int paramInt1, int paramInt2) {
        this.mPreviewWidth = paramInt1;
        this.mPreviewHeight = paramInt2;
    }

    public void setStraiDegree(float paramFloat) {
        this.mStraiDegree = paramFloat;
    }

    public void setStraiSize(int[] paramArrayOfInt) {
        this.mStraiSize = paramArrayOfInt;
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/params/CropParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
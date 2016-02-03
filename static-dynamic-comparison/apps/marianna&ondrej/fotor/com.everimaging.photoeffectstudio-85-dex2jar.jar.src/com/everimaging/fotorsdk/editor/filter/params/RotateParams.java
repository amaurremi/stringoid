package com.everimaging.fotorsdk.editor.filter.params;

import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class RotateParams
        extends BaseParams {
    @Expose
    private int mDegree = 0;
    @Expose
    private boolean mIsFlipH = false;
    @Expose
    private boolean mIsFlipV = false;

    public RotateParams() {
        super(BaseParams.ParamsType.ROTATE);
    }

    public int getDegree() {
        return this.mDegree;
    }

    public boolean isFlipH() {
        return this.mIsFlipH;
    }

    public boolean isFlipV() {
        return this.mIsFlipV;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (RotateParams) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(paramString, getClass());
        this.mDegree = paramString.mDegree;
        this.mIsFlipH = paramString.mIsFlipH;
        this.mIsFlipV = paramString.mIsFlipV;
    }

    public void setDegree(int paramInt) {
        this.mDegree = paramInt;
    }

    public void setIsFlipH(boolean paramBoolean) {
        this.mIsFlipH = paramBoolean;
    }

    public void setIsFlipV(boolean paramBoolean) {
        this.mIsFlipV = paramBoolean;
    }

    public String toJsonStr() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/params/RotateParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
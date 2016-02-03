package com.everimaging.fotorsdk.algorithms.params.beauty;

import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MascaraParams
        extends BaseParams {
    private int processImgHeight = 0;
    private int processImgWidth = 0;
    private int radius = 0;

    public MascaraParams() {
        super(BaseParams.ParamsType.MASCARA);
    }

    public int getProcessImgHeight() {
        return this.processImgHeight;
    }

    public int getProcessImgWidth() {
        return this.processImgWidth;
    }

    public int getRadius() {
        return this.radius;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (MascaraParams) new GsonBuilder().create().fromJson(paramString, getClass());
        this.paramType = paramString.paramType;
        this.processImgWidth = paramString.processImgWidth;
        this.processImgHeight = paramString.processImgHeight;
        this.radius = paramString.radius;
    }

    public void setProcessImgHeight(int paramInt) {
        this.processImgHeight = paramInt;
    }

    public void setProcessImgWidth(int paramInt) {
        this.processImgWidth = paramInt;
    }

    public void setRadius(int paramInt) {
        this.radius = paramInt;
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/beauty/MascaraParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
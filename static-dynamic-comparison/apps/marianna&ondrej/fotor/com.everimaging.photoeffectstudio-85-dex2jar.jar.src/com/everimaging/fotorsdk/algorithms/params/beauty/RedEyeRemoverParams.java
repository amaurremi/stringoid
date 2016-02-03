package com.everimaging.fotorsdk.algorithms.params.beauty;

import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RedEyeRemoverParams
        extends BaseParams {
    private int centerX = 0;
    private int centerY = 0;
    private int processImgHeight = 0;
    private int processImgWidth = 0;
    private int radius = 0;

    public RedEyeRemoverParams() {
        super(BaseParams.ParamsType.REDEYE_REMOVER);
    }

    public int getCenterX() {
        return this.centerX;
    }

    public int getCenterY() {
        return this.centerY;
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
        paramString = (RedEyeRemoverParams) new GsonBuilder().create().fromJson(paramString, getClass());
        this.paramType = paramString.paramType;
        this.processImgWidth = paramString.processImgWidth;
        this.processImgHeight = paramString.processImgHeight;
        this.centerX = paramString.centerX;
        this.centerY = paramString.centerY;
        this.radius = paramString.radius;
    }

    public void setCenterX(int paramInt) {
        this.centerX = paramInt;
    }

    public void setCenterY(int paramInt) {
        this.centerY = paramInt;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/beauty/RedEyeRemoverParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
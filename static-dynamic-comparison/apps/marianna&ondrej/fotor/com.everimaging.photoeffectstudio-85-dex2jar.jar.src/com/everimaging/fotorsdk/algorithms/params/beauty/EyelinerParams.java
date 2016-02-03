package com.everimaging.fotorsdk.algorithms.params.beauty;

import android.graphics.Color;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EyelinerParams
        extends BaseParams {
    private float blue = 0.0F;
    private float green = 0.0F;
    private float red = 0.0F;

    public EyelinerParams() {
        super(BaseParams.ParamsType.EYELINER);
    }

    public float getBlue() {
        return this.blue;
    }

    public float getGreen() {
        return this.green;
    }

    public float getRed() {
        return this.red;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (EyelinerParams) new GsonBuilder().create().fromJson(paramString, getClass());
        this.paramType = paramString.paramType;
        this.red = paramString.red;
        this.green = paramString.green;
        this.blue = paramString.blue;
    }

    public void setBlue(float paramFloat) {
        this.blue = paramFloat;
    }

    public void setColor(int paramInt) {
        this.red = (Color.red(paramInt) / 255.0F);
        this.green = (Color.green(paramInt) / 255.0F);
        this.blue = (Color.blue(paramInt) / 255.0F);
    }

    public void setGreen(float paramFloat) {
        this.green = paramFloat;
    }

    public void setRed(float paramFloat) {
        this.red = paramFloat;
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/beauty/EyelinerParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
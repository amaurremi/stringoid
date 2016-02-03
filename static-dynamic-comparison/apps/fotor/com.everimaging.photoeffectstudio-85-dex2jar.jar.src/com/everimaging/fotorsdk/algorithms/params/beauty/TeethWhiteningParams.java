package com.everimaging.fotorsdk.algorithms.params.beauty;

import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TeethWhiteningParams
        extends BaseParams {
    public TeethWhiteningParams() {
        super(BaseParams.ParamsType.TEETH_WHITENING);
    }

    public void parseFromJsonStr(String paramString) {
        this.paramType = ((TeethWhiteningParams) new GsonBuilder().create().fromJson(paramString, getClass())).paramType;
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/beauty/TeethWhiteningParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
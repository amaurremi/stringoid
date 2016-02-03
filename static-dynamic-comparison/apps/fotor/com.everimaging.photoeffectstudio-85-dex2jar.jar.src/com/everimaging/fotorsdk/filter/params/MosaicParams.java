package com.everimaging.fotorsdk.filter.params;

import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams.ParamsType;
import com.everimaging.fotorsdk.algorithms.params.base.EMosaicMode;
import com.everimaging.fotorsdk.algorithms.params.base.RSMosaicBaseFilterParams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class MosaicParams
        extends BaseParams {
    private String mMaskCachePath;
    private int mMaskHeight;
    private int mMaskWidth;
    private RSMosaicBaseFilterParams mMosaicBaseFilterParams = new RSMosaicBaseFilterParams();

    public MosaicParams() {
        super(BaseParams.ParamsType.MOSAIC);
        this.mMosaicBaseFilterParams.setMode(EMosaicMode.MEAN);
    }

    public void deleteMaskCache() {
        if ((this.mMaskCachePath != null) && (!this.mMaskCachePath.isEmpty())) {
            File localFile = new File(this.mMaskCachePath);
            if (localFile.exists()) {
                localFile.delete();
            }
        }
    }

    public float getBlurPixels() {
        return this.mMosaicBaseFilterParams.getBlurPixels();
    }

    public String getMaskCachePath() {
        return this.mMaskCachePath;
    }

    public int getMaskHeight() {
        return this.mMaskHeight;
    }

    public int getMaskWidth() {
        return this.mMaskWidth;
    }

    public RSMosaicBaseFilterParams getRsMosaicBaseFilterParams() {
        return this.mMosaicBaseFilterParams;
    }

    public void parseFromJsonStr(String paramString) {
        paramString = (MosaicParams) new GsonBuilder().create().fromJson(paramString, MosaicParams.class);
        this.mMaskCachePath = paramString.mMaskCachePath;
        this.mMaskWidth = paramString.mMaskWidth;
        this.mMaskHeight = paramString.mMaskHeight;
        this.mMosaicBaseFilterParams = paramString.mMosaicBaseFilterParams;
    }

    public void setBlurPixels(float paramFloat) {
        this.mMosaicBaseFilterParams.setBlurPixels(paramFloat);
    }

    public void setMaskCachePath(String paramString) {
        this.mMaskCachePath = paramString;
    }

    public void setMaskHeight(int paramInt) {
        this.mMaskHeight = paramInt;
    }

    public void setMaskWidth(int paramInt) {
        this.mMaskWidth = paramInt;
    }

    public String toJsonStr() {
        return new GsonBuilder().create().toJson(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/filter/params/MosaicParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
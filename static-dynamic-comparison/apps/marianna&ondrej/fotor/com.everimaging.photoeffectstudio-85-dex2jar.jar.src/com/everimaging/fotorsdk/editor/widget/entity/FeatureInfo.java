package com.everimaging.fotorsdk.editor.widget.entity;

import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;

public class FeatureInfo {
    private FotorFeaturesFactory.FeatureType featureType;
    private int thumbnailResID;
    private int titleResID;

    public FotorFeaturesFactory.FeatureType getFeatureType() {
        return this.featureType;
    }

    public int getThumbnailResID() {
        return this.thumbnailResID;
    }

    public int getTitleResID() {
        return this.titleResID;
    }

    public void setFeatureType(FotorFeaturesFactory.FeatureType paramFeatureType) {
        this.featureType = paramFeatureType;
    }

    public void setFeatureType(String paramString) {
        this.featureType = FotorFeaturesFactory.FeatureType.valueOf(paramString);
    }

    public void setThumbnailResID(int paramInt) {
        this.thumbnailResID = paramInt;
    }

    public void setTitleResID(int paramInt) {
        this.titleResID = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/entity/FeatureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
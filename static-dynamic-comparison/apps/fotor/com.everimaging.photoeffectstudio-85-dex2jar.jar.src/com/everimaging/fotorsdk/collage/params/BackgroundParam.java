package com.everimaging.fotorsdk.collage.params;

import com.everimaging.fotorsdk.collage.entity.BackgroundInfo;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.FeaturePack;

public class BackgroundParam {
    private BackgroundInfo backgroundInfo;
    private FeaturePack featurePack;

    public BackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    public FeaturePack getFeaturePack() {
        return this.featurePack;
    }

    public void setBackgroundInfo(BackgroundInfo paramBackgroundInfo) {
        this.backgroundInfo = paramBackgroundInfo;
    }

    public void setFeatureInternalPack(FeatureInternalPack paramFeatureInternalPack) {
        this.featurePack = paramFeatureInternalPack;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/params/BackgroundParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
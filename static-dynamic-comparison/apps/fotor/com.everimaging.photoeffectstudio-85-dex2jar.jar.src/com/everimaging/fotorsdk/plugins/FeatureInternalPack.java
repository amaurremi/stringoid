package com.everimaging.fotorsdk.plugins;

import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class FeatureInternalPack
        extends FeaturePack {
    private static final String TAG = FeatureInternalPack.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);

    public FeatureInternalPack(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
        super(paramString1, paramString2, paramInt1, paramInt2, paramInt3);
    }

    public FeatureInternalPack copy() {
        FeatureInternalPack localFeatureInternalPack = new FeatureInternalPack(this.packageName, this.packName, this.packageVersionCode, this.version, this.pluginType);
        localFeatureInternalPack.packageVersion = this.packageVersion;
        return localFeatureInternalPack;
    }

    public boolean isFree() {
        return false;
    }

    public String toString() {
        return super.toString() + "[packageName:" + this.packageName + ",pluginType:" + getPluginType() + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/FeatureInternalPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
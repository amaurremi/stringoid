package com.everimaging.fotorsdk.plugins;

public class FeatureDownloadedPack
        extends FeatureInternalPack {
    private String mPackFolderPath;

    public FeatureDownloadedPack(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3) {
        super(paramString1, paramString2, paramInt1, paramInt2, paramInt3);
        this.mPackFolderPath = paramString3;
    }

    public FeatureDownloadedPack copy() {
        FeatureDownloadedPack localFeatureDownloadedPack = new FeatureDownloadedPack(this.packageName, this.packageName, this.packageVersionCode, this.version, this.pluginType, this.mPackFolderPath);
        localFeatureDownloadedPack.packageVersion = this.packageVersion;
        return localFeatureDownloadedPack;
    }

    public String getPackFolderPath() {
        return this.mPackFolderPath;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/FeatureDownloadedPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.everimaging.fotorsdk.plugins;

import java.io.Serializable;

public class UpdateType
        implements Serializable {
    private final String mAction;
    private final String mPackName;
    private final String mPackageName;
    private final int mPackageVersionCode;
    private final int mPluginType;

    public UpdateType(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3) {
        this.mPackageName = paramString1;
        this.mPackName = paramString2;
        this.mPluginType = paramInt1;
        this.mPackageVersionCode = paramInt2;
        this.mAction = paramString3;
    }

    public int getPluginType() {
        return this.mPluginType;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/UpdateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
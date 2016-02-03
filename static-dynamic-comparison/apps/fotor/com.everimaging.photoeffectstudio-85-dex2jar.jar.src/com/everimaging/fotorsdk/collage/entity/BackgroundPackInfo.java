package com.everimaging.fotorsdk.collage.entity;

import java.util.List;

public class BackgroundPackInfo {
    private List<BackgroundInfo> classes;
    private String package_key;
    private String title;
    private String version;

    public List<BackgroundInfo> getClasses() {
        return this.classes;
    }

    public String getPackage_key() {
        return this.package_key;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVersion() {
        return this.version;
    }

    public void setClasses(List<BackgroundInfo> paramList) {
        this.classes = paramList;
    }

    public void setPackage_key(String paramString) {
        this.package_key = paramString;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setVersion(String paramString) {
        this.version = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/entity/BackgroundPackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
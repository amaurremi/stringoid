package com.everimaging.fotorsdk.collage.entity;

import android.text.TextUtils;

public class BackgroundInfo {
    private String color;
    private String resName;

    public BackgroundInfo() {
    }

    public BackgroundInfo(BackgroundInfo paramBackgroundInfo) {
        this.color = paramBackgroundInfo.color;
        this.resName = paramBackgroundInfo.resName;
    }

    public String getColor() {
        return this.color;
    }

    public String getResName() {
        return this.resName;
    }

    public boolean isSameBackground(BackgroundInfo paramBackgroundInfo) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramBackgroundInfo != null) {
            if ((paramBackgroundInfo.color == null) || (!paramBackgroundInfo.color.equalsIgnoreCase(this.color))) {
                bool1 = bool2;
                if (paramBackgroundInfo.resName != null) {
                    bool1 = bool2;
                    if (!paramBackgroundInfo.resName.equals(this.resName)) {
                    }
                }
            } else {
                bool1 = true;
            }
        }
        return bool1;
    }

    public boolean isTexture() {
        return !TextUtils.isEmpty(this.resName);
    }

    public void setColor(String paramString) {
        this.color = paramString;
    }

    public void setResName(String paramString) {
        this.resName = paramString;
    }

    public String toString() {
        return "color:" + this.color + ",resName:" + this.resName;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/entity/BackgroundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
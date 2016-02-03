package com.quoord.tapatalkpro.bean;

import android.content.Context;
import android.graphics.Bitmap;

public class BaseBean {
    private String cookies;
    private String extra;
    private Bitmap icon;
    protected String localIconUri = null;
    private String timeString = null;

    public String getCookies() {
        return this.cookies;
    }

    public String getExtra() {
        return this.extra;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    public String getLocalIconUri() {
        return this.localIconUri;
    }

    public String getSmartTimeString() {
        return this.timeString;
    }

    public String getTimeString() {
        return this.timeString;
    }

    public void setCookies(String paramString) {
        this.cookies = paramString;
    }

    public void setExtra(String paramString) {
        this.extra = paramString;
    }

    public void setIcon(Bitmap paramBitmap) {
        this.icon = paramBitmap;
    }

    public void setLocalIconUri(String paramString) {
        this.localIconUri = paramString;
    }

    public void setLocalIconUri(String paramString, Context paramContext) {
        this.localIconUri = paramString;
    }

    public void setSmartTimeString(String paramString) {
        this.timeString = paramString;
    }

    public void setTimeString(String paramString) {
        this.timeString = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/BaseBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
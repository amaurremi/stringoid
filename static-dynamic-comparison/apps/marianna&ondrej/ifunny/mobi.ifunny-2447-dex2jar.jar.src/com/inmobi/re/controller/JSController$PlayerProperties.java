package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class JSController$PlayerProperties
        extends JSController.ReflectedParcelable {
    public static final Parcelable.Creator<PlayerProperties> CREATOR = new f();
    public boolean audioMuted;
    public boolean autoPlay;
    public boolean doLoop;
    public String id;
    public boolean showControl;
    public String startStyle;
    public String stopStyle;

    public JSController$PlayerProperties() {
        this.showControl = true;
        this.autoPlay = true;
        this.audioMuted = false;
        this.doLoop = false;
        this.stopStyle = "normal";
        this.startStyle = "normal";
        this.id = "";
    }

    public JSController$PlayerProperties(Parcel paramParcel) {
        super(paramParcel);
    }

    public boolean doLoop() {
        return this.doLoop;
    }

    public boolean doMute() {
        return this.audioMuted;
    }

    public boolean exitOnComplete() {
        return this.stopStyle.equalsIgnoreCase("exit");
    }

    public boolean isAutoPlay() {
        return this.autoPlay == true;
    }

    public boolean isFullScreen() {
        return this.startStyle.equalsIgnoreCase("fullscreen");
    }

    public void setFullScreen() {
        this.startStyle = "fullscreen";
    }

    public void setProperties(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, String paramString3) {
        this.autoPlay = paramBoolean2;
        this.showControl = paramBoolean3;
        this.doLoop = paramBoolean4;
        this.audioMuted = paramBoolean1;
        this.startStyle = paramString1;
        this.stopStyle = paramString2;
        this.id = paramString3;
    }

    public void setStopStyle(String paramString) {
        this.stopStyle = paramString;
    }

    public boolean showControl() {
        return this.showControl;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController$PlayerProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
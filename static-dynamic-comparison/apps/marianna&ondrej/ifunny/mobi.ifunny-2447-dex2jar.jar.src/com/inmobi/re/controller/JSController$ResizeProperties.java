package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class JSController$ResizeProperties
        extends JSController.ReflectedParcelable {
    public static final Parcelable.Creator<ResizeProperties> CREATOR = new e();
    public boolean allowOffscreen;
    public String customClosePosition;
    public int height;
    public int offsetX;
    public int offsetY;
    public int width;

    public JSController$ResizeProperties() {
        initializeResizeProperties();
    }

    protected JSController$ResizeProperties(Parcel paramParcel) {
        super(paramParcel);
    }

    public void initializeResizeProperties() {
        this.offsetY = 0;
        this.offsetX = 0;
        this.height = 0;
        this.width = 0;
        this.allowOffscreen = false;
        this.customClosePosition = "top-right";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController$ResizeProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
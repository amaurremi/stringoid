package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class JSController$ExpandProperties
        extends JSController.ReflectedParcelable {
    public static final Parcelable.Creator<ExpandProperties> CREATOR = new d();
    public int actualHeightRequested;
    public int actualWidthRequested;
    public int bottomStuff;
    public int currentX;
    public int currentY;
    public int height;
    public boolean isModal;
    public boolean lockOrientation;
    public String orientation;
    public int portraitHeightRequested;
    public int portraitWidthRequested;
    public String rotationAtExpand;
    public int topStuff;
    public boolean useCustomClose;
    public int width;
    public int x;
    public int y;
    public boolean zeroWidthHeight;

    public JSController$ExpandProperties() {
        reinitializeExpandProperties();
    }

    protected JSController$ExpandProperties(Parcel paramParcel) {
        super(paramParcel);
    }

    public void reinitializeExpandProperties() {
        this.width = 0;
        this.height = 0;
        this.x = -1;
        this.y = -1;
        this.useCustomClose = false;
        this.isModal = true;
        this.lockOrientation = false;
        this.orientation = "";
        this.actualWidthRequested = 0;
        this.actualHeightRequested = 0;
        this.topStuff = 0;
        this.bottomStuff = 0;
        this.portraitWidthRequested = 0;
        this.portraitHeightRequested = 0;
        this.zeroWidthHeight = false;
        this.rotationAtExpand = "";
        this.currentX = 0;
        this.currentY = 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController$ExpandProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
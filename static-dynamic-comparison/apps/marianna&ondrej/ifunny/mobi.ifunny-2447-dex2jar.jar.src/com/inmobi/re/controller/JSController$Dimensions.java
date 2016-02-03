package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class JSController$Dimensions
        extends JSController.ReflectedParcelable {
    public static final Parcelable.Creator<Dimensions> CREATOR = new b();
    public int height;
    public int width;
    public int x;
    public int y;

    public JSController$Dimensions() {
        this.x = -1;
        this.y = -1;
        this.width = -1;
        this.height = -1;
    }

    protected JSController$Dimensions(Parcel paramParcel) {
        super(paramParcel);
    }

    public String toString() {
        return "x: " + this.x + ", y: " + this.y + ", width: " + this.width + ", height: " + this.height;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController$Dimensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
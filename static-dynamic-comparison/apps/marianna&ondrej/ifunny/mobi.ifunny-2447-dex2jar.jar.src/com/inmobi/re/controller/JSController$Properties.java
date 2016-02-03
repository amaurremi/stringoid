package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class JSController$Properties
        extends JSController.ReflectedParcelable {
    public static final Parcelable.Creator<Properties> CREATOR = new c();
    public int backgroundColor;
    public float backgroundOpacity;
    public boolean useBackground;

    public JSController$Properties() {
        this.useBackground = false;
        this.backgroundColor = 0;
        this.backgroundOpacity = 0.0F;
    }

    protected JSController$Properties(Parcel paramParcel) {
        super(paramParcel);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController$Properties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
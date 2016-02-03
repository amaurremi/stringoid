package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class JSController$OrientationProperties
        extends JSController.ReflectedParcelable {
    public static final Parcelable.Creator<OrientationProperties> CREATOR = new a();
    public boolean allowOrientationChange;
    public String forceOrientation;

    public JSController$OrientationProperties() {
        initializeOrientationProperties();
    }

    protected JSController$OrientationProperties(Parcel paramParcel) {
        super(paramParcel);
    }

    public void initializeOrientationProperties() {
        this.allowOrientationChange = true;
        this.forceOrientation = "";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController$OrientationProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
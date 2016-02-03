package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
        implements Parcelable.Creator<JSController.OrientationProperties> {
    public JSController.OrientationProperties a(Parcel paramParcel) {
        return new JSController.OrientationProperties(paramParcel);
    }

    public JSController.OrientationProperties[] a(int paramInt) {
        return new JSController.OrientationProperties[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
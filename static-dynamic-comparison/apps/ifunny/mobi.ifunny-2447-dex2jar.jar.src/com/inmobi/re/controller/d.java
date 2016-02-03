package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
        implements Parcelable.Creator<JSController.ExpandProperties> {
    public JSController.ExpandProperties a(Parcel paramParcel) {
        return new JSController.ExpandProperties(paramParcel);
    }

    public JSController.ExpandProperties[] a(int paramInt) {
        return new JSController.ExpandProperties[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
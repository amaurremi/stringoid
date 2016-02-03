package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
        implements Parcelable.Creator<JSController.Properties> {
    public JSController.Properties a(Parcel paramParcel) {
        return new JSController.Properties(paramParcel);
    }

    public JSController.Properties[] a(int paramInt) {
        return new JSController.Properties[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
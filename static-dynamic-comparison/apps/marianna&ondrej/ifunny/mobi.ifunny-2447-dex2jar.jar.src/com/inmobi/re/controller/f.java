package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
        implements Parcelable.Creator<JSController.PlayerProperties> {
    public JSController.PlayerProperties a(Parcel paramParcel) {
        return new JSController.PlayerProperties(paramParcel);
    }

    public JSController.PlayerProperties[] a(int paramInt) {
        return new JSController.PlayerProperties[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
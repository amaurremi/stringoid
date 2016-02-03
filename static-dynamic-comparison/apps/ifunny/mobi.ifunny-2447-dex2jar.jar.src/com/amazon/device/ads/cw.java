package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class cw
        implements Parcelable.Creator<Controller.ReflectedParcelable> {
    public Controller.ReflectedParcelable a(Parcel paramParcel) {
        return new Controller.ReflectedParcelable(paramParcel);
    }

    public Controller.ReflectedParcelable[] a(int paramInt) {
        return new Controller.ReflectedParcelable[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
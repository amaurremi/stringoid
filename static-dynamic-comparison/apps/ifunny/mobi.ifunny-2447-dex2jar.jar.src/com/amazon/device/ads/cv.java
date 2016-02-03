package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class cv
        implements Parcelable.Creator<Controller.PlayerProperties> {
    public Controller.PlayerProperties a(Parcel paramParcel) {
        return new Controller.PlayerProperties(paramParcel);
    }

    public Controller.PlayerProperties[] a(int paramInt) {
        return new Controller.PlayerProperties[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
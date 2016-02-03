package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class cu
        implements Parcelable.Creator<Controller.Dimensions> {
    public Controller.Dimensions a(Parcel paramParcel) {
        return new Controller.Dimensions(paramParcel);
    }

    public Controller.Dimensions[] a(int paramInt) {
        return new Controller.Dimensions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
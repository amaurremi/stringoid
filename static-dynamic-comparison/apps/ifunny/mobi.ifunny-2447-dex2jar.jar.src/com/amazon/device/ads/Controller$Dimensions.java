package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class Controller$Dimensions
        extends Controller.ReflectedParcelable {
    public static final Parcelable.Creator<Dimensions> CREATOR = new cu();
    public int a;
    public int b;
    public int c;
    public int d;

    public Controller$Dimensions() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
    }

    public Controller$Dimensions(Parcel paramParcel) {
        super(paramParcel);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/Controller$Dimensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
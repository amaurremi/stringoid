package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.BleDevice;

public class h
        implements Parcelable.Creator<b> {
    static void a(b paramb, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramb.a(), false);
        c.a(paramParcel, 1000, paramb.c());
        c.a(paramParcel, 2, paramb.b(), paramInt, false);
        c.a(paramParcel, i);
    }

    public b a(Parcel paramParcel) {
        BleDevice localBleDevice = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localBleDevice = (BleDevice) a.a(paramParcel, k, BleDevice.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new b(i, str, localBleDevice);
    }

    public b[] a(int paramInt) {
        return new b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
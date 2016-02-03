package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
        implements Parcelable.Creator<UnclaimBleDeviceRequest> {
    static void a(UnclaimBleDeviceRequest paramUnclaimBleDeviceRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1000, paramUnclaimBleDeviceRequest.b());
        c.a(paramParcel, 2, paramUnclaimBleDeviceRequest.a(), false);
        c.a(paramParcel, paramInt);
    }

    public UnclaimBleDeviceRequest a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new UnclaimBleDeviceRequest(i, str);
    }

    public UnclaimBleDeviceRequest[] a(int paramInt) {
        return new UnclaimBleDeviceRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
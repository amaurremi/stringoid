package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.BleDevice;

import java.util.ArrayList;

public class a
        implements Parcelable.Creator<BleDevicesResult> {
    static void a(BleDevicesResult paramBleDevicesResult, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.c(paramParcel, 1, paramBleDevicesResult.b(), false);
        c.a(paramParcel, 1000, paramBleDevicesResult.c());
        c.a(paramParcel, 2, paramBleDevicesResult.a(), paramInt, false);
        c.a(paramParcel, i);
    }

    public BleDevicesResult a(Parcel paramParcel) {
        Status localStatus = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, BleDevice.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    localStatus = (Status) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Status.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new BleDevicesResult(i, localArrayList, localStatus);
    }

    public BleDevicesResult[] a(int paramInt) {
        return new BleDevicesResult[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
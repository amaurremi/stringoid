package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;

public class c
        implements Parcelable.Creator<BleDevice> {
    static void a(BleDevice paramBleDevice, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramBleDevice.a(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramBleDevice.e());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramBleDevice.b(), false);
        com.google.android.gms.common.internal.safeparcel.c.b(paramParcel, 3, paramBleDevice.c(), false);
        com.google.android.gms.common.internal.safeparcel.c.c(paramParcel, 4, paramBleDevice.d(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public BleDevice a(Parcel paramParcel) {
        ArrayList localArrayList1 = null;
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList2 = null;
        String str1 = null;
        String str2 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str2 = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str1 = a.o(paramParcel, k);
                    break;
                case 3:
                    localArrayList2 = a.C(paramParcel, k);
                    break;
                case 4:
                    localArrayList1 = a.c(paramParcel, k, DataType.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new BleDevice(i, str2, str1, localArrayList2, localArrayList1);
    }

    public BleDevice[] a(int paramInt) {
        return new BleDevice[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
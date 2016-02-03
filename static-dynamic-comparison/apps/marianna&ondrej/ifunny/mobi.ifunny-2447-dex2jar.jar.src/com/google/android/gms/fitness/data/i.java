package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
        implements Parcelable.Creator<Device> {
    static void a(Device paramDevice, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramDevice.a(), false);
        c.a(paramParcel, 1000, paramDevice.h());
        c.a(paramParcel, 2, paramDevice.b(), false);
        c.a(paramParcel, 3, paramDevice.c(), false);
        c.a(paramParcel, 4, paramDevice.g(), false);
        c.a(paramParcel, 5, paramDevice.d());
        c.a(paramParcel, paramInt);
    }

    public Device a(Parcel paramParcel) {
        int i = 0;
        String str1 = null;
        int k = a.b(paramParcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    str4 = a.o(paramParcel, m);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    str3 = a.o(paramParcel, m);
                    break;
                case 3:
                    str2 = a.o(paramParcel, m);
                    break;
                case 4:
                    str1 = a.o(paramParcel, m);
                    break;
                case 5:
                    i = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new Device(j, str4, str3, str2, str1, i);
    }

    public Device[] a(int paramInt) {
        return new Device[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<CastDevice> {
    static void a(CastDevice paramCastDevice, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramCastDevice.a());
        c.a(paramParcel, 2, paramCastDevice.b(), false);
        c.a(paramParcel, 3, paramCastDevice.a, false);
        c.a(paramParcel, 4, paramCastDevice.c(), false);
        c.a(paramParcel, 5, paramCastDevice.d(), false);
        c.a(paramParcel, 6, paramCastDevice.e(), false);
        c.a(paramParcel, 7, paramCastDevice.f());
        c.c(paramParcel, 8, paramCastDevice.g(), false);
        c.a(paramParcel, 9, paramCastDevice.h());
        c.a(paramParcel, 10, paramCastDevice.i());
        c.a(paramParcel, paramInt);
    }

    public CastDevice a(Parcel paramParcel) {
        int i = 0;
        ArrayList localArrayList = null;
        int n = a.b(paramParcel);
        int j = 0;
        int k = 0;
        String str1 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int m = 0;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    m = a.g(paramParcel, i1);
                    break;
                case 2:
                    str5 = a.o(paramParcel, i1);
                    break;
                case 3:
                    str4 = a.o(paramParcel, i1);
                    break;
                case 4:
                    str3 = a.o(paramParcel, i1);
                    break;
                case 5:
                    str2 = a.o(paramParcel, i1);
                    break;
                case 6:
                    str1 = a.o(paramParcel, i1);
                    break;
                case 7:
                    k = a.g(paramParcel, i1);
                    break;
                case 8:
                    localArrayList = a.c(paramParcel, i1, WebImage.CREATOR);
                    break;
                case 9:
                    j = a.g(paramParcel, i1);
                    break;
                case 10:
                    i = a.g(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n, paramParcel);
        }
        return new CastDevice(m, str5, str4, str3, str2, str1, k, localArrayList, j, i);
    }

    public CastDevice[] a(int paramInt) {
        return new CastDevice[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/cast/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
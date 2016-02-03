package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class o
        implements Parcelable.Creator<MarkerOptions> {
    static void a(MarkerOptions paramMarkerOptions, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramMarkerOptions.a());
        c.a(paramParcel, 2, paramMarkerOptions.c(), paramInt, false);
        c.a(paramParcel, 3, paramMarkerOptions.d(), false);
        c.a(paramParcel, 4, paramMarkerOptions.e(), false);
        c.a(paramParcel, 5, paramMarkerOptions.b(), false);
        c.a(paramParcel, 6, paramMarkerOptions.f());
        c.a(paramParcel, 7, paramMarkerOptions.g());
        c.a(paramParcel, 8, paramMarkerOptions.h());
        c.a(paramParcel, 9, paramMarkerOptions.i());
        c.a(paramParcel, 10, paramMarkerOptions.j());
        c.a(paramParcel, 11, paramMarkerOptions.k());
        c.a(paramParcel, 12, paramMarkerOptions.l());
        c.a(paramParcel, 13, paramMarkerOptions.m());
        c.a(paramParcel, 14, paramMarkerOptions.n());
        c.a(paramParcel, i);
    }

    public MarkerOptions a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        LatLng localLatLng = null;
        String str2 = null;
        String str1 = null;
        IBinder localIBinder = null;
        float f6 = 0.0F;
        float f5 = 0.0F;
        boolean bool3 = false;
        boolean bool2 = false;
        boolean bool1 = false;
        float f4 = 0.0F;
        float f3 = 0.5F;
        float f2 = 0.0F;
        float f1 = 1.0F;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localLatLng = (LatLng) a.a(paramParcel, k, LatLng.CREATOR);
                    break;
                case 3:
                    str2 = a.o(paramParcel, k);
                    break;
                case 4:
                    str1 = a.o(paramParcel, k);
                    break;
                case 5:
                    localIBinder = a.p(paramParcel, k);
                    break;
                case 6:
                    f6 = a.l(paramParcel, k);
                    break;
                case 7:
                    f5 = a.l(paramParcel, k);
                    break;
                case 8:
                    bool3 = a.c(paramParcel, k);
                    break;
                case 9:
                    bool2 = a.c(paramParcel, k);
                    break;
                case 10:
                    bool1 = a.c(paramParcel, k);
                    break;
                case 11:
                    f4 = a.l(paramParcel, k);
                    break;
                case 12:
                    f3 = a.l(paramParcel, k);
                    break;
                case 13:
                    f2 = a.l(paramParcel, k);
                    break;
                case 14:
                    f1 = a.l(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new MarkerOptions(i, localLatLng, str2, str1, localIBinder, f6, f5, bool3, bool2, bool1, f4, f3, f2, f1);
    }

    public MarkerOptions[] a(int paramInt) {
        return new MarkerOptions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
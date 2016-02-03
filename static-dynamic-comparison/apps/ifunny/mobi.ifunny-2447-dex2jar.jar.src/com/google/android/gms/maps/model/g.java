package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
        implements Parcelable.Creator<CircleOptions> {
    static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCircleOptions.a());
        c.a(paramParcel, 2, paramCircleOptions.b(), paramInt, false);
        c.a(paramParcel, 3, paramCircleOptions.c());
        c.a(paramParcel, 4, paramCircleOptions.d());
        c.a(paramParcel, 5, paramCircleOptions.e());
        c.a(paramParcel, 6, paramCircleOptions.f());
        c.a(paramParcel, 7, paramCircleOptions.g());
        c.a(paramParcel, 8, paramCircleOptions.h());
        c.a(paramParcel, i);
    }

    public CircleOptions a(Parcel paramParcel) {
        float f1 = 0.0F;
        boolean bool = false;
        int m = a.b(paramParcel);
        LatLng localLatLng = null;
        double d = 0.0D;
        int i = 0;
        int j = 0;
        float f2 = 0.0F;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    localLatLng = (LatLng) a.a(paramParcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    d = a.m(paramParcel, n);
                    break;
                case 4:
                    f2 = a.l(paramParcel, n);
                    break;
                case 5:
                    j = a.g(paramParcel, n);
                    break;
                case 6:
                    i = a.g(paramParcel, n);
                    break;
                case 7:
                    f1 = a.l(paramParcel, n);
                    break;
                case 8:
                    bool = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new CircleOptions(k, localLatLng, d, f2, j, i, f1, bool);
    }

    public CircleOptions[] a(int paramInt) {
        return new CircleOptions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
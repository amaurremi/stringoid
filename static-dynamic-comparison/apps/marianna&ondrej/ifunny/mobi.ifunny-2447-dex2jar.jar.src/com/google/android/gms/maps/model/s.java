package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class s
        implements Parcelable.Creator<PolylineOptions> {
    static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramPolylineOptions.a());
        c.c(paramParcel, 2, paramPolylineOptions.b(), false);
        c.a(paramParcel, 3, paramPolylineOptions.c());
        c.a(paramParcel, 4, paramPolylineOptions.d());
        c.a(paramParcel, 5, paramPolylineOptions.e());
        c.a(paramParcel, 6, paramPolylineOptions.f());
        c.a(paramParcel, 7, paramPolylineOptions.g());
        c.a(paramParcel, paramInt);
    }

    public PolylineOptions a(Parcel paramParcel) {
        float f1 = 0.0F;
        boolean bool1 = false;
        int k = a.b(paramParcel);
        ArrayList localArrayList = null;
        boolean bool2 = false;
        int i = 0;
        float f2 = 0.0F;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    localArrayList = a.c(paramParcel, m, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = a.l(paramParcel, m);
                    break;
                case 4:
                    i = a.g(paramParcel, m);
                    break;
                case 5:
                    f1 = a.l(paramParcel, m);
                    break;
                case 6:
                    bool2 = a.c(paramParcel, m);
                    break;
                case 7:
                    bool1 = a.c(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new PolylineOptions(j, localArrayList, f2, i, f1, bool2, bool1);
    }

    public PolylineOptions[] a(int paramInt) {
        return new PolylineOptions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
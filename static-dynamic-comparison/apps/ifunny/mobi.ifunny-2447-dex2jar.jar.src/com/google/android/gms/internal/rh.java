package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class rh
        implements Parcelable.Creator<mq> {
    static void a(mq parammq, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, parammq.a(), false);
        c.a(paramParcel, 1000, parammq.a);
        c.a(paramParcel, 2, parammq.b(), paramInt, false);
        c.a(paramParcel, 3, parammq.c(), false);
        c.c(paramParcel, 4, parammq.d(), false);
        c.a(paramParcel, 5, parammq.e(), false);
        c.a(paramParcel, 6, parammq.f(), false);
        c.a(paramParcel, i);
    }

    public mq a(Parcel paramParcel) {
        String str1 = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str2 = null;
        ArrayList localArrayList = null;
        String str3 = null;
        LatLng localLatLng = null;
        String str4 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str4 = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localLatLng = (LatLng) a.a(paramParcel, k, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = a.o(paramParcel, k);
                    break;
                case 4:
                    localArrayList = a.c(paramParcel, k, mo.CREATOR);
                    break;
                case 5:
                    str2 = a.o(paramParcel, k);
                    break;
                case 6:
                    str1 = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new mq(i, str4, localLatLng, str3, localArrayList, str2, str1);
    }

    public mq[] a(int paramInt) {
        return new mq[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
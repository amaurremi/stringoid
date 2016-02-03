package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class hp
        implements Parcelable.Creator<ho> {
    static void a(ho paramho, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.a(paramParcel, 1, paramho.getName(), false);
        b.c(paramParcel, 1000, paramho.xH);
        b.a(paramParcel, 2, paramho.ia(), paramInt, false);
        b.a(paramParcel, 3, paramho.getAddress(), false);
        b.b(paramParcel, 4, paramho.ib(), false);
        b.a(paramParcel, 5, paramho.getPhoneNumber(), false);
        b.a(paramParcel, 6, paramho.ic(), false);
        b.F(paramParcel, i);
    }

    public ho aH(Parcel paramParcel) {
        String str1 = null;
        int j = a.o(paramParcel);
        int i = 0;
        String str2 = null;
        ArrayList localArrayList = null;
        String str3 = null;
        LatLng localLatLng = null;
        String str4 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str4 = a.n(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localLatLng = (LatLng) a.a(paramParcel, k, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = a.n(paramParcel, k);
                    break;
                case 4:
                    localArrayList = a.c(paramParcel, k, hm.CREATOR);
                    break;
                case 5:
                    str2 = a.n(paramParcel, k);
                    break;
                case 6:
                    str1 = a.n(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new ho(i, str4, localLatLng, str3, localArrayList, str2, str1);
    }

    public ho[] bI(int paramInt) {
        return new ho[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
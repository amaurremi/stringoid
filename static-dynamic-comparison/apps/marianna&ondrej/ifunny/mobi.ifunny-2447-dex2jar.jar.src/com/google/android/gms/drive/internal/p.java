package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.StorageStats;

public class p
        implements Parcelable.Creator<OnStorageStatsResponse> {
    static void a(OnStorageStatsResponse paramOnStorageStatsResponse, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnStorageStatsResponse.a);
        c.a(paramParcel, 2, paramOnStorageStatsResponse.b, paramInt, false);
        c.a(paramParcel, i);
    }

    public OnStorageStatsResponse a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        StorageStats localStorageStats = null;
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
                    localStorageStats = (StorageStats) a.a(paramParcel, k, StorageStats.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OnStorageStatsResponse(i, localStorageStats);
    }

    public OnStorageStatsResponse[] a(int paramInt) {
        return new OnStorageStatsResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
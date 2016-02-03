package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSource;

public class qw
        implements Parcelable.Creator<lh> {
    static void a(lh paramlh, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramlh.a(), paramInt, false);
        c.a(paramParcel, 1000, paramlh.b());
        c.a(paramParcel, i);
    }

    public lh a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        DataSource localDataSource = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localDataSource = (DataSource) a.a(paramParcel, k, DataSource.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new lh(i, localDataSource);
    }

    public lh[] a(int paramInt) {
        return new lh[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/qw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class g
        implements Parcelable.Creator<ah> {
    static void a(ah paramah, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramah.b(), paramInt, false);
        c.a(paramParcel, 1000, paramah.a());
        c.a(paramParcel, 2, paramah.c(), paramInt, false);
        c.a(paramParcel, i);
    }

    public ah a(Parcel paramParcel) {
        DataSource localDataSource = null;
        int j = a.b(paramParcel);
        int i = 0;
        DataType localDataType = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                localDataType = (DataType) a.a(paramParcel, k, DataType.CREATOR);
                continue;
                i = a.g(paramParcel, k);
                continue;
                localDataSource = (DataSource) a.a(paramParcel, k, DataSource.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ah(i, localDataType, localDataSource);
    }

    public ah[] a(int paramInt) {
        return new ah[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
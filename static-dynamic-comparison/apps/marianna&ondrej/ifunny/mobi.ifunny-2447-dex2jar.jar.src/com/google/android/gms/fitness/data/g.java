package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
        implements Parcelable.Creator<DataSource> {
    static void a(DataSource paramDataSource, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataSource.a(), paramInt, false);
        c.a(paramParcel, 1000, paramDataSource.k());
        c.a(paramParcel, 2, paramDataSource.c(), false);
        c.a(paramParcel, 3, paramDataSource.b());
        c.a(paramParcel, 4, paramDataSource.f(), paramInt, false);
        c.a(paramParcel, 5, paramDataSource.e(), paramInt, false);
        c.a(paramParcel, 6, paramDataSource.g(), false);
        c.a(paramParcel, 7, paramDataSource.h());
        c.a(paramParcel, i);
    }

    public DataSource a(Parcel paramParcel) {
        boolean bool = false;
        String str1 = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        a locala = null;
        Device localDevice = null;
        int i = 0;
        String str2 = null;
        DataType localDataType = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
                    break;
                case 1:
                    localDataType = (DataType) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, DataType.CREATOR);
                    break;
                case 1000:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 4:
                    localDevice = (Device) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, Device.CREATOR);
                    break;
                case 5:
                    locala = (a) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, a.CREATOR);
                    break;
                case 6:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 7:
                    bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new DataSource(j, localDataType, str2, i, localDevice, locala, str1, bool);
    }

    public DataSource[] a(int paramInt) {
        return new DataSource[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
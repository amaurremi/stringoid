package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataType;

public class y
        implements Parcelable.Creator<l> {
    static void a(l paraml, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paraml.a(), paramInt, false);
        c.a(paramParcel, 1000, paraml.b());
        c.a(paramParcel, i);
    }

    public l a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        DataType localDataType = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localDataType = (DataType) a.a(paramParcel, k, DataType.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new l(i, localDataType);
    }

    public l[] a(int paramInt) {
        return new l[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
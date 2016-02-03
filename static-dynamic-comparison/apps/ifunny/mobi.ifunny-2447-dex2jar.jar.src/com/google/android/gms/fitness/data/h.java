package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class h
        implements Parcelable.Creator<DataType> {
    static void a(DataType paramDataType, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataType.a(), false);
        c.a(paramParcel, 1000, paramDataType.d());
        c.c(paramParcel, 2, paramDataType.b(), false);
        c.a(paramParcel, paramInt);
    }

    public DataType a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList = a.c(paramParcel, k, Field.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataType(i, str, localArrayList);
    }

    public DataType[] a(int paramInt) {
        return new DataType[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
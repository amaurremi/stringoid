package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class p
        implements Parcelable.Creator<RawDataSet> {
    static void a(RawDataSet paramRawDataSet, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramRawDataSet.b);
        c.a(paramParcel, 1000, paramRawDataSet.a);
        c.a(paramParcel, 2, paramRawDataSet.c);
        c.c(paramParcel, 3, paramRawDataSet.d, false);
        c.a(paramParcel, 4, paramRawDataSet.e);
        c.a(paramParcel, paramInt);
    }

    public RawDataSet a(Parcel paramParcel) {
        boolean bool = false;
        int m = a.b(paramParcel);
        ArrayList localArrayList = null;
        int i = 0;
        int j = 0;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    j = a.g(paramParcel, n);
                    break;
                case 1000:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    i = a.g(paramParcel, n);
                    break;
                case 3:
                    localArrayList = a.c(paramParcel, n, RawDataPoint.CREATOR);
                    break;
                case 4:
                    bool = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new RawDataSet(k, j, i, localArrayList, bool);
    }

    public RawDataSet[] a(int paramInt) {
        return new RawDataSet[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
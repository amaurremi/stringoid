package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class n
        implements Parcelable.Creator<RawBucket> {
    static void a(RawBucket paramRawBucket, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramRawBucket.b);
        c.a(paramParcel, 1000, paramRawBucket.a);
        c.a(paramParcel, 2, paramRawBucket.c);
        c.a(paramParcel, 3, paramRawBucket.d, paramInt, false);
        c.a(paramParcel, 4, paramRawBucket.e);
        c.c(paramParcel, 5, paramRawBucket.f, false);
        c.a(paramParcel, 6, paramRawBucket.g);
        c.a(paramParcel, 7, paramRawBucket.h);
        c.a(paramParcel, i);
    }

    public RawBucket a(Parcel paramParcel) {
        long l1 = 0L;
        ArrayList localArrayList = null;
        boolean bool = false;
        int m = a.b(paramParcel);
        int i = 0;
        int j = 0;
        Session localSession = null;
        long l2 = 0L;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    l2 = a.i(paramParcel, n);
                    break;
                case 1000:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    l1 = a.i(paramParcel, n);
                    break;
                case 3:
                    localSession = (Session) a.a(paramParcel, n, Session.CREATOR);
                    break;
                case 4:
                    j = a.g(paramParcel, n);
                    break;
                case 5:
                    localArrayList = a.c(paramParcel, n, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = a.g(paramParcel, n);
                    break;
                case 7:
                    bool = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new RawBucket(k, l2, l1, localSession, j, localArrayList, i, bool);
    }

    public RawBucket[] a(int paramInt) {
        return new RawBucket[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
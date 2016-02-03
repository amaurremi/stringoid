package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class s
        implements Parcelable.Creator<q> {
    static void a(q paramq, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramq.a(), paramInt, false);
        c.a(paramParcel, 1000, paramq.a);
        c.a(paramParcel, 2, paramq.b(), paramInt, false);
        c.a(paramParcel, i);
    }

    public q a(Parcel paramParcel) {
        DataSet localDataSet = null;
        int j = a.b(paramParcel);
        int i = 0;
        Session localSession = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                localSession = (Session) a.a(paramParcel, k, Session.CREATOR);
                continue;
                i = a.g(paramParcel, k);
                continue;
                localDataSet = (DataSet) a.a(paramParcel, k, DataSet.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new q(i, localSession, localDataSet);
    }

    public q[] a(int paramInt) {
        return new q[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
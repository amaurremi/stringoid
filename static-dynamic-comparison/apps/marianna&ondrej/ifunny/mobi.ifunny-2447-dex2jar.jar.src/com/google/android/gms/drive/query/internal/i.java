package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class i
        implements Parcelable.Creator<LogicalFilter> {
    static void a(LogicalFilter paramLogicalFilter, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, paramLogicalFilter.c);
        c.a(paramParcel, 1, paramLogicalFilter.a, paramInt, false);
        c.c(paramParcel, 2, paramLogicalFilter.b, false);
        c.a(paramParcel, i);
    }

    public LogicalFilter a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = a.b(paramParcel);
        int i = 0;
        Operator localOperator = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = a.g(paramParcel, k);
                continue;
                localOperator = (Operator) a.a(paramParcel, k, Operator.CREATOR);
                continue;
                localArrayList = a.c(paramParcel, k, FilterHolder.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new LogicalFilter(i, localOperator, localArrayList);
    }

    public LogicalFilter[] a(int paramInt) {
        return new LogicalFilter[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
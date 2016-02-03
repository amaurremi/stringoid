package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.query.internal.LogicalFilter;

import java.util.ArrayList;

public class a
        implements Parcelable.Creator<Query> {
    static void a(Query paramQuery, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, paramQuery.e);
        c.a(paramParcel, 1, paramQuery.a, paramInt, false);
        c.a(paramParcel, 3, paramQuery.b, false);
        c.a(paramParcel, 4, paramQuery.c, paramInt, false);
        c.b(paramParcel, 5, paramQuery.d, false);
        c.a(paramParcel, i);
    }

    public Query a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        SortOrder localSortOrder = null;
        String str = null;
        LogicalFilter localLogicalFilter = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 1:
                    localLogicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 4:
                    localSortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, SortOrder.CREATOR);
                    break;
                case 5:
                    localArrayList = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new Query(i, localLogicalFilter, str, localSortOrder, localArrayList);
    }

    public Query[] a(int paramInt) {
        return new Query[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
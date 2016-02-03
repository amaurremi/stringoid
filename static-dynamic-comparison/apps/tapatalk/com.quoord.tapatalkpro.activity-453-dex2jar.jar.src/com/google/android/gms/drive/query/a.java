package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class a
        implements Parcelable.Creator<Query> {
    static void a(Query paramQuery, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1000, paramQuery.xH);
        b.a(paramParcel, 1, paramQuery.GA, paramInt, false);
        b.a(paramParcel, 3, paramQuery.GB, false);
        b.a(paramParcel, 4, paramQuery.GC, paramInt, false);
        b.F(paramParcel, i);
    }

    public Query[] aG(int paramInt) {
        return new Query[paramInt];
    }

    public Query ac(Parcel paramParcel) {
        SortOrder localSortOrder = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel);
        int i = 0;
        Object localObject2 = null;
        Object localObject1 = null;
        if (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
            Object localObject3;
            switch (com.google.android.gms.common.internal.safeparcel.a.R(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    localObject3 = localObject2;
                    localObject2 = localObject1;
                    localObject1 = localObject3;
            }
            for (; ; ) {
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
                break;
                i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, LogicalFilter.CREATOR);
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel, k);
                localObject2 = localObject1;
                localObject1 = localObject3;
                continue;
                localSortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, SortOrder.CREATOR);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new Query(i, (LogicalFilter) localObject1, (String) localObject2, localSortOrder);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
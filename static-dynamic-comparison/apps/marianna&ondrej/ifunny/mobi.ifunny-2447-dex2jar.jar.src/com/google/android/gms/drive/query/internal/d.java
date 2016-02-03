package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
        implements Parcelable.Creator<FilterHolder> {
    static void a(FilterHolder paramFilterHolder, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramFilterHolder.b, paramInt, false);
        c.a(paramParcel, 1000, paramFilterHolder.a);
        c.a(paramParcel, 2, paramFilterHolder.c, paramInt, false);
        c.a(paramParcel, 3, paramFilterHolder.d, paramInt, false);
        c.a(paramParcel, 4, paramFilterHolder.e, paramInt, false);
        c.a(paramParcel, 5, paramFilterHolder.f, paramInt, false);
        c.a(paramParcel, 6, paramFilterHolder.g, paramInt, false);
        c.a(paramParcel, 7, paramFilterHolder.h, paramInt, false);
        c.a(paramParcel, i);
    }

    public FilterHolder a(Parcel paramParcel) {
        HasFilter localHasFilter = null;
        int j = a.b(paramParcel);
        int i = 0;
        MatchAllFilter localMatchAllFilter = null;
        InFilter localInFilter = null;
        NotFilter localNotFilter = null;
        LogicalFilter localLogicalFilter = null;
        FieldOnlyFilter localFieldOnlyFilter = null;
        ComparisonFilter localComparisonFilter = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localComparisonFilter = (ComparisonFilter) a.a(paramParcel, k, ComparisonFilter.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localFieldOnlyFilter = (FieldOnlyFilter) a.a(paramParcel, k, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    localLogicalFilter = (LogicalFilter) a.a(paramParcel, k, LogicalFilter.CREATOR);
                    break;
                case 4:
                    localNotFilter = (NotFilter) a.a(paramParcel, k, NotFilter.CREATOR);
                    break;
                case 5:
                    localInFilter = (InFilter) a.a(paramParcel, k, InFilter.CREATOR);
                    break;
                case 6:
                    localMatchAllFilter = (MatchAllFilter) a.a(paramParcel, k, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    localHasFilter = (HasFilter) a.a(paramParcel, k, HasFilter.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new FilterHolder(i, localComparisonFilter, localFieldOnlyFilter, localLogicalFilter, localNotFilter, localInFilter, localMatchAllFilter, localHasFilter);
    }

    public FilterHolder[] a(int paramInt) {
        return new FilterHolder[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
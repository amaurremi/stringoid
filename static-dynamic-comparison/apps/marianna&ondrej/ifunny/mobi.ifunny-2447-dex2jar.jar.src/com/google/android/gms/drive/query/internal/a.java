package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class a
        implements Parcelable.Creator<ComparisonFilter> {
    static void a(ComparisonFilter paramComparisonFilter, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, paramComparisonFilter.c);
        c.a(paramParcel, 1, paramComparisonFilter.a, paramInt, false);
        c.a(paramParcel, 2, paramComparisonFilter.b, paramInt, false);
        c.a(paramParcel, i);
    }

    public ComparisonFilter a(Parcel paramParcel) {
        MetadataBundle localMetadataBundle = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        Operator localOperator = null;
        if (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                continue;
                localOperator = (Operator) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Operator.CREATOR);
                continue;
                localMetadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, MetadataBundle.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ComparisonFilter(i, localOperator, localMetadataBundle);
    }

    public ComparisonFilter[] a(int paramInt) {
        return new ComparisonFilter[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
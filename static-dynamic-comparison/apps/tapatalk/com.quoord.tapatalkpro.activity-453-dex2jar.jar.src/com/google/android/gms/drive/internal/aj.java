package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.Query;

public class aj
        implements Parcelable.Creator<QueryRequest> {
    static void a(QueryRequest paramQueryRequest, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramQueryRequest.xH);
        b.a(paramParcel, 2, paramQueryRequest.FL, paramInt, false);
        b.F(paramParcel, i);
    }

    public QueryRequest X(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        Query localQuery = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localQuery = (Query) a.a(paramParcel, k, Query.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new QueryRequest(i, localQuery);
    }

    public QueryRequest[] aB(int paramInt) {
        return new QueryRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
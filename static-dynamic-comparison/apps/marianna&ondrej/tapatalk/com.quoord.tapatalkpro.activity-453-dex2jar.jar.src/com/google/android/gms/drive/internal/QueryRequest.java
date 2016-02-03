package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

public class QueryRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<QueryRequest> CREATOR = new aj();
    final Query FL;
    final int xH;

    QueryRequest(int paramInt, Query paramQuery) {
        this.xH = paramInt;
        this.FL = paramQuery;
    }

    public QueryRequest(Query paramQuery) {
        this(1, paramQuery);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        aj.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/QueryRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
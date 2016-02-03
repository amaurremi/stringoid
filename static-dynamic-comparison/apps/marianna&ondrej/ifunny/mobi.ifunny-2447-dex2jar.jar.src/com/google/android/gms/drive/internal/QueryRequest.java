package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

public class QueryRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<QueryRequest> CREATOR = new t();
    final int a;
    final Query b;

    QueryRequest(int paramInt, Query paramQuery) {
        this.a = paramInt;
        this.b = paramQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        t.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/QueryRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
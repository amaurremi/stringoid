package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;

import java.util.List;
import java.util.Locale;

public class Query
        implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new a();
    final LogicalFilter a;
    final String b;
    final SortOrder c;
    final List<String> d;
    final int e;

    Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList) {
        this.e = paramInt;
        this.a = paramLogicalFilter;
        this.b = paramString;
        this.c = paramSortOrder;
        this.d = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s]", new Object[]{this.a, this.c, this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
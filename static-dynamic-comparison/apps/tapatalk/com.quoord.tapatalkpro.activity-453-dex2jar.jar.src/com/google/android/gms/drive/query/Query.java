package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;

import java.util.ArrayList;
import java.util.List;

public class Query
        implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new a();
    final LogicalFilter GA;
    final String GB;
    final SortOrder GC;
    final int xH;

    Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder) {
        this.xH = paramInt;
        this.GA = paramLogicalFilter;
        this.GB = paramString;
        this.GC = paramSortOrder;
    }

    Query(LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder) {
        this(1, paramLogicalFilter, paramString, paramSortOrder);
    }

    public int describeContents() {
        return 0;
    }

    public SortOrder fV() {
        return this.GC;
    }

    public Filter getFilter() {
        return this.GA;
    }

    public String getPageToken() {
        return this.GB;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }

    public static class Builder {
        private String GB;
        private SortOrder GC;
        private final List<Filter> GD = new ArrayList();

        public Builder a(SortOrder paramSortOrder) {
            this.GC = paramSortOrder;
            return this;
        }

        public Builder addFilter(Filter paramFilter) {
            if (!(paramFilter instanceof MatchAllFilter)) {
                this.GD.add(paramFilter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.GZ, this.GD), this.GB, this.GC);
        }

        public Builder setPageToken(String paramString) {
            this.GB = paramString;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
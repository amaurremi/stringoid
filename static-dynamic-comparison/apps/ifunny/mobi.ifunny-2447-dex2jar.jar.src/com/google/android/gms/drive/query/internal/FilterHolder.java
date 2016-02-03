package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
        implements SafeParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new d();
    final int a;
    final ComparisonFilter<?> b;
    final FieldOnlyFilter c;
    final LogicalFilter d;
    final NotFilter e;
    final InFilter<?> f;
    final MatchAllFilter g;
    final HasFilter h;
    private final Filter i;

    FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter) {
        this.a = paramInt;
        this.b = paramComparisonFilter;
        this.c = paramFieldOnlyFilter;
        this.d = paramLogicalFilter;
        this.e = paramNotFilter;
        this.f = paramInFilter;
        this.g = paramMatchAllFilter;
        this.h = paramHasFilter;
        if (this.b != null) {
            this.i = this.b;
            return;
        }
        if (this.c != null) {
            this.i = this.c;
            return;
        }
        if (this.d != null) {
            this.i = this.d;
            return;
        }
        if (this.e != null) {
            this.i = this.e;
            return;
        }
        if (this.f != null) {
            this.i = this.f;
            return;
        }
        if (this.g != null) {
            this.i = this.g;
            return;
        }
        if (this.h != null) {
            this.i = this.h;
            return;
        }
        throw new IllegalArgumentException("At least one filter must be set.");
    }

    public Filter a() {
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.i});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
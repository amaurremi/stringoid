package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T>
        extends AbstractFilter {
    public static final a CREATOR = new a();
    final Operator a;
    final MetadataBundle b;
    final int c;
    final com.google.android.gms.drive.metadata.a<T> d;

    ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle) {
        this.c = paramInt;
        this.a = paramOperator;
        this.b = paramMetadataBundle;
        this.d = e.a(paramMetadataBundle);
    }

    public T a() {
        return (T) this.b.a(this.d);
    }

    public <F> F a(f<F> paramf) {
        return (F) paramf.b(this.a, this.d, a());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/ComparisonFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
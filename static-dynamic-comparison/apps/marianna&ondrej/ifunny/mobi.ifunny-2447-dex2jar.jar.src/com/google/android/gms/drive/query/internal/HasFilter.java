package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T>
        extends AbstractFilter {
    public static final g CREATOR = new g();
    final MetadataBundle a;
    final int b;
    final a<T> c;

    HasFilter(int paramInt, MetadataBundle paramMetadataBundle) {
        this.b = paramInt;
        this.a = paramMetadataBundle;
        this.c = e.a(paramMetadataBundle);
    }

    public T a() {
        return (T) this.a.a(this.c);
    }

    public <F> F a(f<F> paramf) {
        return (F) paramf.b(this.c, a());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/HasFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.g;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

import java.util.Collection;
import java.util.Iterator;

public class InFilter<T>
        extends AbstractFilter {
    public static final h CREATOR = new h();
    final MetadataBundle a;
    final int b;
    private final g<T> c;

    InFilter(int paramInt, MetadataBundle paramMetadataBundle) {
        this.b = paramInt;
        this.a = paramMetadataBundle;
        this.c = ((g) e.a(paramMetadataBundle));
    }

    public T a() {
        return (T) ((Collection) this.a.a(this.c)).iterator().next();
    }

    public <F> F a(f<F> paramf) {
        return (F) paramf.b(this.c, a());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/InFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
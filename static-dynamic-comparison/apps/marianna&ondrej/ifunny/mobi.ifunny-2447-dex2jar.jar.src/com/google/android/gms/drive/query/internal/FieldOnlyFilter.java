package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter
        extends AbstractFilter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new b();
    final MetadataBundle a;
    final int b;
    private final a<?> c;

    FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle) {
        this.b = paramInt;
        this.a = paramMetadataBundle;
        this.c = e.a(paramMetadataBundle);
    }

    public <T> T a(f<T> paramf) {
        return (T) paramf.b(this.c);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/FieldOnlyFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
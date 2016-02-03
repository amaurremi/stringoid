package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter
        extends AbstractFilter {
    public static final j CREATOR = new j();
    final int a;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int paramInt) {
        this.a = paramInt;
    }

    public <F> F a(f<F> paramf) {
        return (F) paramf.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/MatchAllFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
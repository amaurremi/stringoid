package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter
        extends AbstractFilter {
    public static final Parcelable.Creator<NotFilter> CREATOR = new k();
    final FilterHolder a;
    final int b;

    NotFilter(int paramInt, FilterHolder paramFilterHolder) {
        this.b = paramInt;
        this.a = paramFilterHolder;
    }

    public <T> T a(f<T> paramf) {
        return (T) paramf.a(this.a.a().a(paramf));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        k.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/NotFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
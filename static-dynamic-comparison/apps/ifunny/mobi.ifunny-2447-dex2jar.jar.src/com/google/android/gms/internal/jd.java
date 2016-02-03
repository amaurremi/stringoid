package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jd
        implements SafeParcelable {
    public static final pe CREATOR = new pe();
    private final int a;
    private final jf b;

    jd(int paramInt, jf paramjf) {
        this.a = paramInt;
        this.b = paramjf;
    }

    private jd(jf paramjf) {
        this.a = 1;
        this.b = paramjf;
    }

    public static jd a(ph<?, ?> paramph) {
        if ((paramph instanceof jf)) {
            return new jd((jf) paramph);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    int a() {
        return this.a;
    }

    jf b() {
        return this.b;
    }

    public ph<?, ?> c() {
        if (this.b != null) {
            return this.b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public int describeContents() {
        pe localpe = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pe localpe = CREATOR;
        pe.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
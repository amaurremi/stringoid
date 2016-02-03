package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jf$a
        implements SafeParcelable {
    public static final pg CREATOR = new pg();
    final int a;
    final String b;
    final int c;

    jf$a(int paramInt1, String paramString, int paramInt2) {
        this.a = paramInt1;
        this.b = paramString;
        this.c = paramInt2;
    }

    jf$a(String paramString, int paramInt) {
        this.a = 1;
        this.b = paramString;
        this.c = paramInt;
    }

    public int describeContents() {
        pg localpg = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pg localpg = CREATOR;
        pg.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jf$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jb
        implements SafeParcelable {
    public static final pd CREATOR = new pd();
    final int a;
    public final String b;
    public final int c;

    public jb(int paramInt1, String paramString, int paramInt2) {
        this.a = paramInt1;
        this.b = paramString;
        this.c = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pd.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
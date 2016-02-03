package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jm$b
        implements SafeParcelable {
    public static final pj CREATOR = new pj();
    final int a;
    final String b;
    final ji.a<?, ?> c;

    jm$b(int paramInt, String paramString, ji.a<?, ?> parama) {
        this.a = paramInt;
        this.b = paramString;
        this.c = parama;
    }

    jm$b(String paramString, ji.a<?, ?> parama) {
        this.a = 1;
        this.b = paramString;
        this.c = parama;
    }

    public int describeContents() {
        pj localpj = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pj localpj = CREATOR;
        pj.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jm$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
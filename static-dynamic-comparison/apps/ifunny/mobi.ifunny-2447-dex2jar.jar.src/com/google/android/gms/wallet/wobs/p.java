package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p
        implements SafeParcelable {
    public static final Parcelable.Creator<p> CREATOR = new s();
    String a;
    String b;
    l c;
    n d;
    n e;
    private final int f;

    p() {
        this.f = 1;
    }

    p(int paramInt, String paramString1, String paramString2, l paraml, n paramn1, n paramn2) {
        this.f = paramInt;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paraml;
        this.d = paramn1;
        this.e = paramn2;
    }

    public int a() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        s.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
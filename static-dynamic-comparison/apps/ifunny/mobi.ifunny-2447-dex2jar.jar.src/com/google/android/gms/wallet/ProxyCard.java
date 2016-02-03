package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard
        implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new o();
    String a;
    String b;
    int c;
    int d;
    private final int e;

    ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3) {
        this.e = paramInt1;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramInt2;
        this.d = paramInt3;
    }

    public int a() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        o.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/ProxyCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
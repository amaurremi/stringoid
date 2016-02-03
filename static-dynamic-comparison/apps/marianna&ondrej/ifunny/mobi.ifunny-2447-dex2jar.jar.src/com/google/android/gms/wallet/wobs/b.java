package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class b
        implements SafeParcelable {
    public static final Parcelable.Creator<b> CREATOR = new h();
    String a;
    String b;
    private final int c;

    b() {
        this.c = 1;
    }

    b(int paramInt, String paramString1, String paramString2) {
        this.c = paramInt;
        this.a = paramString1;
        this.b = paramString2;
    }

    public int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
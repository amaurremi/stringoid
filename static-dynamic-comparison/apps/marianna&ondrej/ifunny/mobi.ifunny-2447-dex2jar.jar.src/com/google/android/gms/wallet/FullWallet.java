package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
        implements SafeParcelable {
    public static final Parcelable.Creator<FullWallet> CREATOR = new f();
    String a;
    String b;
    ProxyCard c;
    String d;
    Address e;
    Address f;
    String[] g;
    UserAddress h;
    UserAddress i;
    InstrumentInfo[] j;
    private final int k;

    private FullWallet() {
        this.k = 1;
    }

    FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo) {
        this.k = paramInt;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramProxyCard;
        this.d = paramString3;
        this.e = paramAddress1;
        this.f = paramAddress2;
        this.g = paramArrayOfString;
        this.h = paramUserAddress1;
        this.i = paramUserAddress2;
        this.j = paramArrayOfInstrumentInfo;
    }

    public int a() {
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
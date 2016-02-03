package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions
        implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new b();
    final int a;
    private int b;
    private int c;
    private WalletFragmentStyle d;
    private int e;

    private WalletFragmentOptions() {
        this.a = 1;
    }

    WalletFragmentOptions(int paramInt1, int paramInt2, int paramInt3, WalletFragmentStyle paramWalletFragmentStyle, int paramInt4) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramWalletFragmentStyle;
        this.e = paramInt4;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public WalletFragmentStyle c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
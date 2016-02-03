package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle
        implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new c();
    final int a;
    Bundle b;
    int c;

    public WalletFragmentStyle() {
        this.a = 1;
        this.b = new Bundle();
    }

    WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2) {
        this.a = paramInt1;
        this.b = paramBundle;
        this.c = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
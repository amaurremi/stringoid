package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
        implements Parcelable.Creator<WalletFragmentStyle> {
    static void a(WalletFragmentStyle paramWalletFragmentStyle, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramWalletFragmentStyle.a);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramWalletFragmentStyle.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramWalletFragmentStyle.c);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public WalletFragmentStyle a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        Bundle localBundle = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    localBundle = a.q(paramParcel, m);
                    break;
                case 3:
                    j = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new WalletFragmentStyle(i, localBundle, j);
    }

    public WalletFragmentStyle[] a(int paramInt) {
        return new WalletFragmentStyle[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/fragment/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
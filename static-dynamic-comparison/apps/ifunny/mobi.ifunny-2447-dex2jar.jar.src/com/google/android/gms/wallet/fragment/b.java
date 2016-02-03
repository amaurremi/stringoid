package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
        implements Parcelable.Creator<WalletFragmentOptions> {
    static void a(WalletFragmentOptions paramWalletFragmentOptions, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramWalletFragmentOptions.a);
        c.a(paramParcel, 2, paramWalletFragmentOptions.a());
        c.a(paramParcel, 3, paramWalletFragmentOptions.b());
        c.a(paramParcel, 4, paramWalletFragmentOptions.c(), paramInt, false);
        c.a(paramParcel, 5, paramWalletFragmentOptions.d());
        c.a(paramParcel, i);
    }

    public WalletFragmentOptions a(Parcel paramParcel) {
        int i = 1;
        int j = 0;
        int n = a.b(paramParcel);
        WalletFragmentStyle localWalletFragmentStyle = null;
        int k = 1;
        int m = 0;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    m = a.g(paramParcel, i1);
                    break;
                case 2:
                    k = a.g(paramParcel, i1);
                    break;
                case 3:
                    j = a.g(paramParcel, i1);
                    break;
                case 4:
                    localWalletFragmentStyle = (WalletFragmentStyle) a.a(paramParcel, i1, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
                    i = a.g(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n, paramParcel);
        }
        return new WalletFragmentOptions(m, k, j, localWalletFragmentStyle, i);
    }

    public WalletFragmentOptions[] a(int paramInt) {
        return new WalletFragmentOptions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/fragment/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
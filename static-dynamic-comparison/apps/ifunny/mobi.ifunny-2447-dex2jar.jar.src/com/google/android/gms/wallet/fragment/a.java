package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class a
        implements Parcelable.Creator<WalletFragmentInitParams> {
    static void a(WalletFragmentInitParams paramWalletFragmentInitParams, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramWalletFragmentInitParams.a);
        c.a(paramParcel, 2, paramWalletFragmentInitParams.a(), false);
        c.a(paramParcel, 3, paramWalletFragmentInitParams.b(), paramInt, false);
        c.a(paramParcel, 4, paramWalletFragmentInitParams.c());
        c.a(paramParcel, 5, paramWalletFragmentInitParams.d(), paramInt, false);
        c.a(paramParcel, i);
    }

    public WalletFragmentInitParams a(Parcel paramParcel) {
        MaskedWallet localMaskedWallet = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int j = 0;
        int i = -1;
        MaskedWalletRequest localMaskedWalletRequest = null;
        String str = null;
        while (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
                    break;
                case 1:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 3:
                    localMaskedWalletRequest = (MaskedWalletRequest) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 5:
                    localMaskedWallet = (MaskedWallet) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, MaskedWallet.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new WalletFragmentInitParams(j, str, localMaskedWalletRequest, i, localMaskedWallet);
    }

    public WalletFragmentInitParams[] a(int paramInt) {
        return new WalletFragmentInitParams[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/fragment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
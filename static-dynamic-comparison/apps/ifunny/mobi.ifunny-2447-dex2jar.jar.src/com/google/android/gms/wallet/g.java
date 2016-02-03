package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
        implements Parcelable.Creator<FullWalletRequest> {
    static void a(FullWalletRequest paramFullWalletRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramFullWalletRequest.a());
        c.a(paramParcel, 2, paramFullWalletRequest.a, false);
        c.a(paramParcel, 3, paramFullWalletRequest.b, false);
        c.a(paramParcel, 4, paramFullWalletRequest.c, paramInt, false);
        c.a(paramParcel, i);
    }

    public FullWalletRequest a(Parcel paramParcel) {
        Cart localCart = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str2 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str1 = a.o(paramParcel, k);
                    break;
                case 3:
                    str2 = a.o(paramParcel, k);
                    break;
                case 4:
                    localCart = (Cart) a.a(paramParcel, k, Cart.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new FullWalletRequest(i, str1, str2, localCart);
    }

    public FullWalletRequest[] a(int paramInt) {
        return new FullWalletRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
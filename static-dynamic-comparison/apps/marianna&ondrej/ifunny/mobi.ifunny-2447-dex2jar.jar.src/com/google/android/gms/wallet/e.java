package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<d> {
    static void a(d paramd, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramd.a());
        c.a(paramParcel, 2, paramd.a, paramInt, false);
        c.a(paramParcel, 3, paramd.b, paramInt, false);
        c.a(paramParcel, i);
    }

    public d a(Parcel paramParcel) {
        OfferWalletObject localOfferWalletObject = null;
        int j = a.b(paramParcel);
        int i = 0;
        LoyaltyWalletObject localLoyaltyWalletObject = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = a.g(paramParcel, k);
                continue;
                localLoyaltyWalletObject = (LoyaltyWalletObject) a.a(paramParcel, k, LoyaltyWalletObject.CREATOR);
                continue;
                localOfferWalletObject = (OfferWalletObject) a.a(paramParcel, k, OfferWalletObject.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new d(i, localLoyaltyWalletObject, localOfferWalletObject);
    }

    public d[] a(int paramInt) {
        return new d[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
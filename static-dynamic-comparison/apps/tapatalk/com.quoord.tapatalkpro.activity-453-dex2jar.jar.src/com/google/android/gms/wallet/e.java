package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
        implements Parcelable.Creator<d> {
    static void a(d paramd, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramd.getVersionCode());
        b.a(paramParcel, 2, paramd.abg, paramInt, false);
        b.F(paramParcel, i);
    }

    public d ba(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        LoyaltyWalletObject localLoyaltyWalletObject = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localLoyaltyWalletObject = (LoyaltyWalletObject) a.a(paramParcel, k, LoyaltyWalletObject.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new d(i, localLoyaltyWalletObject);
    }

    public d[] cm(int paramInt) {
        return new d[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n
        implements Parcelable.Creator<OfferWalletObject> {
    static void a(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramOfferWalletObject.getVersionCode());
        b.a(paramParcel, 2, paramOfferWalletObject.eC, false);
        b.a(paramParcel, 3, paramOfferWalletObject.acj, false);
        b.F(paramParcel, paramInt);
    }

    public OfferWalletObject bj(Parcel paramParcel) {
        String str2 = null;
        int j = a.o(paramParcel);
        int i = 0;
        String str1 = null;
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
                    str1 = a.n(paramParcel, k);
                    break;
                case 3:
                    str2 = a.n(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new OfferWalletObject(i, str1, str2);
    }

    public OfferWalletObject[] cv(int paramInt) {
        return new OfferWalletObject[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class n
        implements Parcelable.Creator<OfferWalletObject> {
    static void a(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOfferWalletObject.a());
        c.a(paramParcel, 2, paramOfferWalletObject.a, false);
        c.a(paramParcel, 3, paramOfferWalletObject.b, false);
        c.a(paramParcel, 4, paramOfferWalletObject.c, paramInt, false);
        c.a(paramParcel, i);
    }

    public OfferWalletObject a(Parcel paramParcel) {
        CommonWalletObject localCommonWalletObject = null;
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
                    localCommonWalletObject = (CommonWalletObject) a.a(paramParcel, k, CommonWalletObject.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OfferWalletObject(i, str1, str2, localCommonWalletObject);
    }

    public OfferWalletObject[] a(int paramInt) {
        return new OfferWalletObject[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
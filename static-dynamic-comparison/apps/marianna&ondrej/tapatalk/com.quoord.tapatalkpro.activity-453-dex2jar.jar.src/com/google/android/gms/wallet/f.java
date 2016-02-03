package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class f
        implements Parcelable.Creator<FullWallet> {
    static void a(FullWallet paramFullWallet, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramFullWallet.getVersionCode());
        b.a(paramParcel, 2, paramFullWallet.abh, false);
        b.a(paramParcel, 3, paramFullWallet.abi, false);
        b.a(paramParcel, 4, paramFullWallet.abj, paramInt, false);
        b.a(paramParcel, 5, paramFullWallet.abk, false);
        b.a(paramParcel, 6, paramFullWallet.abl, paramInt, false);
        b.a(paramParcel, 7, paramFullWallet.abm, paramInt, false);
        b.a(paramParcel, 8, paramFullWallet.abn, false);
        b.a(paramParcel, 9, paramFullWallet.abo, paramInt, false);
        b.a(paramParcel, 10, paramFullWallet.abp, paramInt, false);
        b.a(paramParcel, 11, paramFullWallet.abq, paramInt, false);
        b.F(paramParcel, i);
    }

    public FullWallet bb(Parcel paramParcel) {
        InstrumentInfo[] arrayOfInstrumentInfo = null;
        int j = a.o(paramParcel);
        int i = 0;
        UserAddress localUserAddress1 = null;
        UserAddress localUserAddress2 = null;
        String[] arrayOfString = null;
        Address localAddress1 = null;
        Address localAddress2 = null;
        String str1 = null;
        ProxyCard localProxyCard = null;
        String str2 = null;
        String str3 = null;
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
                    str3 = a.n(paramParcel, k);
                    break;
                case 3:
                    str2 = a.n(paramParcel, k);
                    break;
                case 4:
                    localProxyCard = (ProxyCard) a.a(paramParcel, k, ProxyCard.CREATOR);
                    break;
                case 5:
                    str1 = a.n(paramParcel, k);
                    break;
                case 6:
                    localAddress2 = (Address) a.a(paramParcel, k, Address.CREATOR);
                    break;
                case 7:
                    localAddress1 = (Address) a.a(paramParcel, k, Address.CREATOR);
                    break;
                case 8:
                    arrayOfString = a.z(paramParcel, k);
                    break;
                case 9:
                    localUserAddress2 = (UserAddress) a.a(paramParcel, k, UserAddress.CREATOR);
                    break;
                case 10:
                    localUserAddress1 = (UserAddress) a.a(paramParcel, k, UserAddress.CREATOR);
                    break;
                case 11:
                    arrayOfInstrumentInfo = (InstrumentInfo[]) a.b(paramParcel, k, InstrumentInfo.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new FullWallet(i, str3, str2, localProxyCard, str1, localAddress2, localAddress1, arrayOfString, localUserAddress2, localUserAddress1, arrayOfInstrumentInfo);
    }

    public FullWallet[] cn(int paramInt) {
        return new FullWallet[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
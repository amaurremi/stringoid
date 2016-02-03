package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class l
        implements Parcelable.Creator<MaskedWalletRequest> {
    static void a(MaskedWalletRequest paramMaskedWalletRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramMaskedWalletRequest.a());
        c.a(paramParcel, 2, paramMaskedWalletRequest.a, false);
        c.a(paramParcel, 3, paramMaskedWalletRequest.b);
        c.a(paramParcel, 4, paramMaskedWalletRequest.c);
        c.a(paramParcel, 5, paramMaskedWalletRequest.d);
        c.a(paramParcel, 6, paramMaskedWalletRequest.e, false);
        c.a(paramParcel, 7, paramMaskedWalletRequest.f, false);
        c.a(paramParcel, 8, paramMaskedWalletRequest.g, false);
        c.a(paramParcel, 9, paramMaskedWalletRequest.h, paramInt, false);
        c.a(paramParcel, 10, paramMaskedWalletRequest.i);
        c.a(paramParcel, 11, paramMaskedWalletRequest.j);
        c.a(paramParcel, 12, paramMaskedWalletRequest.k, paramInt, false);
        c.a(paramParcel, 13, paramMaskedWalletRequest.l);
        c.a(paramParcel, 14, paramMaskedWalletRequest.m);
        c.c(paramParcel, 15, paramMaskedWalletRequest.n, false);
        c.a(paramParcel, i);
    }

    public MaskedWalletRequest a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        String str4 = null;
        boolean bool7 = false;
        boolean bool6 = false;
        boolean bool5 = false;
        String str3 = null;
        String str2 = null;
        String str1 = null;
        Cart localCart = null;
        boolean bool4 = false;
        boolean bool3 = false;
        CountrySpecification[] arrayOfCountrySpecification = null;
        boolean bool2 = true;
        boolean bool1 = true;
        ArrayList localArrayList = null;
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
                    str4 = a.o(paramParcel, k);
                    break;
                case 3:
                    bool7 = a.c(paramParcel, k);
                    break;
                case 4:
                    bool6 = a.c(paramParcel, k);
                    break;
                case 5:
                    bool5 = a.c(paramParcel, k);
                    break;
                case 6:
                    str3 = a.o(paramParcel, k);
                    break;
                case 7:
                    str2 = a.o(paramParcel, k);
                    break;
                case 8:
                    str1 = a.o(paramParcel, k);
                    break;
                case 9:
                    localCart = (Cart) a.a(paramParcel, k, Cart.CREATOR);
                    break;
                case 10:
                    bool4 = a.c(paramParcel, k);
                    break;
                case 11:
                    bool3 = a.c(paramParcel, k);
                    break;
                case 12:
                    arrayOfCountrySpecification = (CountrySpecification[]) a.b(paramParcel, k, CountrySpecification.CREATOR);
                    break;
                case 13:
                    bool2 = a.c(paramParcel, k);
                    break;
                case 14:
                    bool1 = a.c(paramParcel, k);
                    break;
                case 15:
                    localArrayList = a.c(paramParcel, k, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new MaskedWalletRequest(i, str4, bool7, bool6, bool5, str3, str2, str1, localCart, bool4, bool3, arrayOfCountrySpecification, bool2, bool1, localArrayList);
    }

    public MaskedWalletRequest[] a(int paramInt) {
        return new MaskedWalletRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
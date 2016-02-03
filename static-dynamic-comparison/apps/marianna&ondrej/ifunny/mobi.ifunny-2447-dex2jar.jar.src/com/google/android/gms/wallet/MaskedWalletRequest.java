package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;

public final class MaskedWalletRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new l();
    String a;
    boolean b;
    boolean c;
    boolean d;
    String e;
    String f;
    String g;
    Cart h;
    boolean i;
    boolean j;
    CountrySpecification[] k;
    boolean l;
    boolean m;
    ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> n;
    private final int o;

    MaskedWalletRequest() {
        this.o = 3;
        this.l = true;
        this.m = true;
    }

    MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList) {
        this.o = paramInt;
        this.a = paramString1;
        this.b = paramBoolean1;
        this.c = paramBoolean2;
        this.d = paramBoolean3;
        this.e = paramString2;
        this.f = paramString3;
        this.g = paramString4;
        this.h = paramCart;
        this.i = paramBoolean4;
        this.j = paramBoolean5;
        this.k = paramArrayOfCountrySpecification;
        this.l = paramBoolean6;
        this.m = paramBoolean7;
        this.n = paramArrayList;
    }

    public int a() {
        return this.o;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        l.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
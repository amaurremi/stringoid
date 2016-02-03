package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.pn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;

import java.util.ArrayList;

public final class LoyaltyWalletObject
        implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new j();
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    int k;
    ArrayList<p> l;
    l m;
    ArrayList<LatLng> n;
    String o;
    String p;
    ArrayList<d> q;
    boolean r;
    ArrayList<n> s;
    ArrayList<com.google.android.gms.wallet.wobs.j> t;
    ArrayList<n> u;
    f v;
    private final int w;

    LoyaltyWalletObject() {
        this.w = 4;
        this.l = pn.a();
        this.n = pn.a();
        this.q = pn.a();
        this.s = pn.a();
        this.t = pn.a();
        this.u = pn.a();
    }

    LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<com.google.android.gms.wallet.wobs.j> paramArrayList4, ArrayList<n> paramArrayList5, f paramf) {
        this.w = paramInt1;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
        this.d = paramString4;
        this.e = paramString5;
        this.f = paramString6;
        this.g = paramString7;
        this.h = paramString8;
        this.i = paramString9;
        this.j = paramString10;
        this.k = paramInt2;
        this.l = paramArrayList;
        this.m = paraml;
        this.n = paramArrayList1;
        this.o = paramString11;
        this.p = paramString12;
        this.q = paramArrayList2;
        this.r = paramBoolean;
        this.s = paramArrayList3;
        this.t = paramArrayList4;
        this.u = paramArrayList5;
        this.v = paramf;
    }

    public int a() {
        return this.w;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
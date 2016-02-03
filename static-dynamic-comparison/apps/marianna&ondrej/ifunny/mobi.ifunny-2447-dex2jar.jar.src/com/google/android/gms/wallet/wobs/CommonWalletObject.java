package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.pn;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class CommonWalletObject
        implements SafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new e();
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    int i;
    ArrayList<p> j;
    l k;
    ArrayList<LatLng> l;
    String m;
    String n;
    ArrayList<d> o;
    boolean p;
    ArrayList<n> q;
    ArrayList<j> r;
    ArrayList<n> s;
    private final int t;

    CommonWalletObject() {
        this.t = 1;
        this.j = pn.a();
        this.l = pn.a();
        this.o = pn.a();
        this.q = pn.a();
        this.r = pn.a();
        this.s = pn.a();
    }

    CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<j> paramArrayList4, ArrayList<n> paramArrayList5) {
        this.t = paramInt1;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
        this.d = paramString4;
        this.e = paramString5;
        this.f = paramString6;
        this.g = paramString7;
        this.h = paramString8;
        this.i = paramInt2;
        this.j = paramArrayList;
        this.k = paraml;
        this.l = paramArrayList1;
        this.m = paramString9;
        this.n = paramString10;
        this.o = paramArrayList2;
        this.p = paramBoolean;
        this.q = paramArrayList3;
        this.r = paramArrayList4;
        this.s = paramArrayList5;
    }

    public static c a() {
        CommonWalletObject localCommonWalletObject = new CommonWalletObject();
        localCommonWalletObject.getClass();
        return new c(localCommonWalletObject, null);
    }

    public int b() {
        return this.t;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/CommonWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
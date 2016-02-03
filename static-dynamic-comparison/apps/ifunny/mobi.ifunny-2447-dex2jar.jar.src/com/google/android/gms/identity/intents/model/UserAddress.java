package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
        implements SafeParcelable {
    public static final Parcelable.Creator<UserAddress> CREATOR = new b();
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
    String k;
    String l;
    boolean m;
    String n;
    String o;
    private final int p;

    UserAddress() {
        this.p = 1;
    }

    UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14) {
        this.p = paramInt;
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
        this.k = paramString11;
        this.l = paramString12;
        this.m = paramBoolean;
        this.n = paramString13;
        this.o = paramString14;
    }

    public int a() {
        return this.p;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/identity/intents/model/UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.pn;

import java.util.ArrayList;

public final class d
        implements SafeParcelable {
    public static final Parcelable.Creator<d> CREATOR = new i();
    String a;
    String b;
    ArrayList<b> c;
    private final int d;

    d() {
        this.d = 1;
        this.c = pn.a();
    }

    d(int paramInt, String paramString1, String paramString2, ArrayList<b> paramArrayList) {
        this.d = paramInt;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramArrayList;
    }

    public int a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
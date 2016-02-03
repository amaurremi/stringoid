package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class he
        implements SafeParcelable {
    public static final nz CREATOR = new nz();
    final int a;
    final hi[] b;
    public final String c;
    public final boolean d;
    public final Account e;

    he(int paramInt, hi[] paramArrayOfhi, String paramString, boolean paramBoolean, Account paramAccount) {
        this.a = paramInt;
        this.b = paramArrayOfhi;
        this.c = paramString;
        this.d = paramBoolean;
        this.e = paramAccount;
    }

    public int describeContents() {
        nz localnz = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        nz localnz = CREATOR;
        nz.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
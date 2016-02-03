package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hm$a
        implements SafeParcelable {
    public static final od CREATOR = new od();
    final int a;
    public final Account b;

    public hm$a() {
        this(null);
    }

    hm$a(int paramInt, Account paramAccount) {
        this.a = paramInt;
        this.b = paramAccount;
    }

    public hm$a(Account paramAccount) {
        this(1, paramAccount);
    }

    public int describeContents() {
        od localod = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        od localod = CREATOR;
        od.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hm$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
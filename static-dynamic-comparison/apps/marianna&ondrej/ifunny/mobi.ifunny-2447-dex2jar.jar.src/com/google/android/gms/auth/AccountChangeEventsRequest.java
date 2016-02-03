package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest
        implements SafeParcelable {
    public static final b CREATOR = new b();
    final int a;
    int b;
    String c;

    public AccountChangeEventsRequest() {
        this.a = 1;
    }

    AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramString;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/AccountChangeEventsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
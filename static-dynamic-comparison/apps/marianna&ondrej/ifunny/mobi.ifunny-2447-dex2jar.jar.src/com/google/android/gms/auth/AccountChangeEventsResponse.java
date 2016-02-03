package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class AccountChangeEventsResponse
        implements SafeParcelable {
    public static final c CREATOR = new c();
    final int a;
    final List<AccountChangeEvent> b;

    AccountChangeEventsResponse(int paramInt, List<AccountChangeEvent> paramList) {
        this.a = paramInt;
        this.b = ((List) ag.a(paramList));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/AccountChangeEventsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
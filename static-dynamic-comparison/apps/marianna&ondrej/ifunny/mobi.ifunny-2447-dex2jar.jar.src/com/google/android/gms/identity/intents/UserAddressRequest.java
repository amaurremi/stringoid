package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;

import java.util.List;

public final class UserAddressRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<UserAddressRequest> CREATOR = new a();
    List<CountrySpecification> a;
    private final int b;

    UserAddressRequest() {
        this.b = 1;
    }

    UserAddressRequest(int paramInt, List<CountrySpecification> paramList) {
        this.b = paramInt;
        this.a = paramList;
    }

    public int a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/identity/intents/UserAddressRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
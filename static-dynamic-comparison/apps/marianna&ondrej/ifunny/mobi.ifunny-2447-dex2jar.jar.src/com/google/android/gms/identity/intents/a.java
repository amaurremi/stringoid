package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.identity.intents.model.CountrySpecification;

import java.util.ArrayList;

public class a
        implements Parcelable.Creator<UserAddressRequest> {
    static void a(UserAddressRequest paramUserAddressRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramUserAddressRequest.a());
        c.c(paramParcel, 2, paramUserAddressRequest.a, false);
        c.a(paramParcel, paramInt);
    }

    public UserAddressRequest a(Parcel paramParcel) {
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, CountrySpecification.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new UserAddressRequest(i, localArrayList);
    }

    public UserAddressRequest[] a(int paramInt) {
        return new UserAddressRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/identity/intents/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
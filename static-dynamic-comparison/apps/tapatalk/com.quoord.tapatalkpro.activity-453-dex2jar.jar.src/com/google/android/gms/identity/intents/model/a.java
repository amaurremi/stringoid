package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
        implements Parcelable.Creator<CountrySpecification> {
    static void a(CountrySpecification paramCountrySpecification, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramCountrySpecification.getVersionCode());
        b.a(paramParcel, 2, paramCountrySpecification.qd, false);
        b.F(paramParcel, paramInt);
    }

    public CountrySpecification az(Parcel paramParcel) {
        int j = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel);
        int i = 0;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.R(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new CountrySpecification(i, str);
    }

    public CountrySpecification[] bt(int paramInt) {
        return new CountrySpecification[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/identity/intents/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
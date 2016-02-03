package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
        implements Parcelable.Creator<AccountChangeEventsRequest> {
    static void a(AccountChangeEventsRequest paramAccountChangeEventsRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramAccountChangeEventsRequest.a);
        c.a(paramParcel, 2, paramAccountChangeEventsRequest.b);
        c.a(paramParcel, 3, paramAccountChangeEventsRequest.c, false);
        c.a(paramParcel, paramInt);
    }

    public AccountChangeEventsRequest a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        String str = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    j = a.g(paramParcel, m);
                    break;
                case 3:
                    str = a.o(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + k, paramParcel);
        }
        return new AccountChangeEventsRequest(i, j, str);
    }

    public AccountChangeEventsRequest[] a(int paramInt) {
        return new AccountChangeEventsRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
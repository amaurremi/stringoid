package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
        implements Parcelable.Creator<GoogleAuthApiResponse> {
    static void a(GoogleAuthApiResponse paramGoogleAuthApiResponse, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramGoogleAuthApiResponse.b);
        c.a(paramParcel, 1000, paramGoogleAuthApiResponse.a);
        c.a(paramParcel, 2, paramGoogleAuthApiResponse.c, false);
        c.a(paramParcel, 3, paramGoogleAuthApiResponse.d, false);
        c.a(paramParcel, paramInt);
    }

    public GoogleAuthApiResponse a(Parcel paramParcel) {
        byte[] arrayOfByte = null;
        int j = 0;
        int k = a.b(paramParcel);
        Bundle localBundle = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 1000:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    localBundle = a.q(paramParcel, m);
                    break;
                case 3:
                    arrayOfByte = a.r(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + k, paramParcel);
        }
        return new GoogleAuthApiResponse(i, j, localBundle, arrayOfByte);
    }

    public GoogleAuthApiResponse[] a(int paramInt) {
        return new GoogleAuthApiResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
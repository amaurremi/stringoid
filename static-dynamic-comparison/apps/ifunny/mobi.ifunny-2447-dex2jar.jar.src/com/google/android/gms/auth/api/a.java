package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class a
        implements Parcelable.Creator<GoogleAuthApiRequest> {
    static void a(GoogleAuthApiRequest paramGoogleAuthApiRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramGoogleAuthApiRequest.b, false);
        c.a(paramParcel, 1000, paramGoogleAuthApiRequest.a);
        c.a(paramParcel, 2, paramGoogleAuthApiRequest.c, false);
        c.a(paramParcel, 3, paramGoogleAuthApiRequest.d, false);
        c.a(paramParcel, 4, paramGoogleAuthApiRequest.e, false);
        c.a(paramParcel, 5, paramGoogleAuthApiRequest.f, false);
        c.a(paramParcel, 6, paramGoogleAuthApiRequest.g, false);
        c.b(paramParcel, 7, paramGoogleAuthApiRequest.h, false);
        c.a(paramParcel, 8, paramGoogleAuthApiRequest.i, false);
        c.a(paramParcel, 9, paramGoogleAuthApiRequest.j);
        c.a(paramParcel, 10, paramGoogleAuthApiRequest.k, false);
        c.a(paramParcel, 11, paramGoogleAuthApiRequest.l, false);
        c.a(paramParcel, 12, paramGoogleAuthApiRequest.m);
        c.a(paramParcel, paramInt);
    }

    public GoogleAuthApiRequest a(Parcel paramParcel) {
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int j = 0;
        String str6 = null;
        String str5 = null;
        String str4 = null;
        String str3 = null;
        Bundle localBundle2 = null;
        String str2 = null;
        ArrayList localArrayList = null;
        String str1 = null;
        int i = 0;
        Bundle localBundle1 = null;
        byte[] arrayOfByte = null;
        long l = 0L;
        while (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
                    break;
                case 1:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 1000:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 3:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 5:
                    localBundle2 = com.google.android.gms.common.internal.safeparcel.a.q(paramParcel, m);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 7:
                    localArrayList = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel, m);
                    break;
                case 8:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 9:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 10:
                    localBundle1 = com.google.android.gms.common.internal.safeparcel.a.q(paramParcel, m);
                    break;
                case 11:
                    arrayOfByte = com.google.android.gms.common.internal.safeparcel.a.r(paramParcel, m);
                    break;
                case 12:
                    l = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new GoogleAuthApiRequest(j, str6, str5, str4, str3, localBundle2, str2, localArrayList, str1, i, localBundle1, arrayOfByte, l);
    }

    public GoogleAuthApiRequest[] a(int paramInt) {
        return new GoogleAuthApiRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
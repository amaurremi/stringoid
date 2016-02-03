package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ca
        implements Parcelable.Creator<cb> {
    static void a(cb paramcb, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramcb.versionCode);
        b.a(paramParcel, 2, paramcb.nN, false);
        b.a(paramParcel, 3, paramcb.nO, false);
        b.a(paramParcel, 4, paramcb.mimeType, false);
        b.a(paramParcel, 5, paramcb.packageName, false);
        b.a(paramParcel, 6, paramcb.nP, false);
        b.a(paramParcel, 7, paramcb.nQ, false);
        b.a(paramParcel, 8, paramcb.nR, false);
        b.F(paramParcel, paramInt);
    }

    public cb d(Parcel paramParcel) {
        String str1 = null;
        int j = a.o(paramParcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str7 = a.n(paramParcel, k);
                    break;
                case 3:
                    str6 = a.n(paramParcel, k);
                    break;
                case 4:
                    str5 = a.n(paramParcel, k);
                    break;
                case 5:
                    str4 = a.n(paramParcel, k);
                    break;
                case 6:
                    str3 = a.n(paramParcel, k);
                    break;
                case 7:
                    str2 = a.n(paramParcel, k);
                    break;
                case 8:
                    str1 = a.n(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new cb(i, str7, str6, str5, str4, str3, str2, str1);
    }

    public cb[] h(int paramInt) {
        return new cb[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
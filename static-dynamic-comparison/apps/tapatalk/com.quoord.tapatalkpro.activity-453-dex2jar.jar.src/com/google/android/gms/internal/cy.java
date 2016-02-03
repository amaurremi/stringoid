package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cy
        implements Parcelable.Creator<cx> {
    static void a(cx paramcx, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramcx.versionCode);
        b.a(paramParcel, 2, paramcx.pf, false);
        b.a(paramParcel, 3, paramcx.pg, paramInt, false);
        b.a(paramParcel, 4, paramcx.kN, paramInt, false);
        b.a(paramParcel, 5, paramcx.kH, false);
        b.a(paramParcel, 6, paramcx.applicationInfo, paramInt, false);
        b.a(paramParcel, 7, paramcx.ph, paramInt, false);
        b.a(paramParcel, 8, paramcx.pi, false);
        b.a(paramParcel, 9, paramcx.pj, false);
        b.a(paramParcel, 10, paramcx.pk, false);
        b.a(paramParcel, 11, paramcx.kK, paramInt, false);
        b.a(paramParcel, 12, paramcx.pl, false);
        b.F(paramParcel, i);
    }

    public cx f(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        Bundle localBundle2 = null;
        ah localah = null;
        ak localak = null;
        String str4 = null;
        ApplicationInfo localApplicationInfo = null;
        PackageInfo localPackageInfo = null;
        String str3 = null;
        String str2 = null;
        String str1 = null;
        dx localdx = null;
        Bundle localBundle1 = null;
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
                    localBundle2 = a.p(paramParcel, k);
                    break;
                case 3:
                    localah = (ah) a.a(paramParcel, k, ah.CREATOR);
                    break;
                case 4:
                    localak = (ak) a.a(paramParcel, k, ak.CREATOR);
                    break;
                case 5:
                    str4 = a.n(paramParcel, k);
                    break;
                case 6:
                    localApplicationInfo = (ApplicationInfo) a.a(paramParcel, k, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    localPackageInfo = (PackageInfo) a.a(paramParcel, k, PackageInfo.CREATOR);
                    break;
                case 8:
                    str3 = a.n(paramParcel, k);
                    break;
                case 9:
                    str2 = a.n(paramParcel, k);
                    break;
                case 10:
                    str1 = a.n(paramParcel, k);
                    break;
                case 11:
                    localdx = (dx) a.a(paramParcel, k, dx.CREATOR);
                    break;
                case 12:
                    localBundle1 = a.p(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new cx(i, localBundle2, localah, localak, str4, localApplicationInfo, localPackageInfo, str3, str2, str1, localdx, localBundle1);
    }

    public cx[] k(int paramInt) {
        return new cx[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
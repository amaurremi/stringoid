package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;

public class da
        implements Parcelable.Creator<cz> {
    static void a(cz paramcz, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramcz.versionCode);
        b.a(paramParcel, 2, paramcz.ol, false);
        b.a(paramParcel, 3, paramcz.pm, false);
        b.a(paramParcel, 4, paramcz.ne, false);
        b.c(paramParcel, 5, paramcz.errorCode);
        b.a(paramParcel, 6, paramcz.nf, false);
        b.a(paramParcel, 7, paramcz.pn);
        b.a(paramParcel, 8, paramcz.po);
        b.a(paramParcel, 9, paramcz.pp);
        b.a(paramParcel, 10, paramcz.pq, false);
        b.a(paramParcel, 11, paramcz.ni);
        b.c(paramParcel, 12, paramcz.orientation);
        b.a(paramParcel, 13, paramcz.pr, false);
        b.a(paramParcel, 14, paramcz.ps);
        b.a(paramParcel, 15, paramcz.pt, false);
        b.a(paramParcel, 19, paramcz.pv, false);
        b.a(paramParcel, 18, paramcz.pu);
        b.a(paramParcel, 21, paramcz.pw, false);
        b.F(paramParcel, paramInt);
    }

    public cz g(Parcel paramParcel) {
        int m = a.o(paramParcel);
        int k = 0;
        String str6 = null;
        String str5 = null;
        ArrayList localArrayList3 = null;
        int j = 0;
        ArrayList localArrayList2 = null;
        long l4 = 0L;
        boolean bool2 = false;
        long l3 = 0L;
        ArrayList localArrayList1 = null;
        long l2 = 0L;
        int i = 0;
        String str4 = null;
        long l1 = 0L;
        String str3 = null;
        boolean bool1 = false;
        String str2 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
                case 16:
                case 17:
                case 20:
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    str6 = a.n(paramParcel, n);
                    break;
                case 3:
                    str5 = a.n(paramParcel, n);
                    break;
                case 4:
                    localArrayList3 = a.A(paramParcel, n);
                    break;
                case 5:
                    j = a.g(paramParcel, n);
                    break;
                case 6:
                    localArrayList2 = a.A(paramParcel, n);
                    break;
                case 7:
                    l4 = a.i(paramParcel, n);
                    break;
                case 8:
                    bool2 = a.c(paramParcel, n);
                    break;
                case 9:
                    l3 = a.i(paramParcel, n);
                    break;
                case 10:
                    localArrayList1 = a.A(paramParcel, n);
                    break;
                case 11:
                    l2 = a.i(paramParcel, n);
                    break;
                case 12:
                    i = a.g(paramParcel, n);
                    break;
                case 13:
                    str4 = a.n(paramParcel, n);
                    break;
                case 14:
                    l1 = a.i(paramParcel, n);
                    break;
                case 15:
                    str3 = a.n(paramParcel, n);
                    break;
                case 19:
                    str2 = a.n(paramParcel, n);
                    break;
                case 18:
                    bool1 = a.c(paramParcel, n);
                    break;
                case 21:
                    str1 = a.n(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new cz(k, str6, str5, localArrayList3, j, localArrayList2, l4, bool2, l3, localArrayList1, l2, i, str4, l1, str3, bool1, str2, str1);
    }

    public cz[] l(int paramInt) {
        return new cz[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
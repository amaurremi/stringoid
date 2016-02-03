package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.pn;

import java.util.ArrayList;

public class i
        implements Parcelable.Creator<d> {
    static void a(d paramd, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramd.a());
        c.a(paramParcel, 2, paramd.a, false);
        c.a(paramParcel, 3, paramd.b, false);
        c.c(paramParcel, 4, paramd.c, false);
        c.a(paramParcel, paramInt);
    }

    public d a(Parcel paramParcel) {
        String str2 = null;
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = pn.a();
        String str1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str1 = a.o(paramParcel, k);
                    break;
                case 3:
                    str2 = a.o(paramParcel, k);
                    break;
                case 4:
                    localArrayList = a.c(paramParcel, k, b.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new d(i, str1, str2, localArrayList);
    }

    public d[] a(int paramInt) {
        return new d[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
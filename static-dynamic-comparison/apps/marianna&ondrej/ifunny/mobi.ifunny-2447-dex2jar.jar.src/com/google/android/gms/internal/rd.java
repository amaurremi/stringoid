package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class rd
        implements Parcelable.Creator<mi> {
    static void a(mi parammi, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.c(paramParcel, 1, parammi.b, false);
        c.a(paramParcel, 1000, parammi.a);
        c.a(paramParcel, 2, parammi.a(), false);
        c.a(paramParcel, 3, parammi.b());
        c.c(paramParcel, 4, parammi.c, false);
        c.b(paramParcel, 6, parammi.d, false);
        c.a(paramParcel, paramInt);
    }

    public mi a(Parcel paramParcel) {
        boolean bool = false;
        ArrayList localArrayList1 = null;
        int j = a.b(paramParcel);
        ArrayList localArrayList2 = null;
        String str = null;
        ArrayList localArrayList3 = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localArrayList3 = a.c(paramParcel, k, mo.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str = a.o(paramParcel, k);
                    break;
                case 3:
                    bool = a.c(paramParcel, k);
                    break;
                case 4:
                    localArrayList2 = a.c(paramParcel, k, ms.CREATOR);
                    break;
                case 6:
                    localArrayList1 = a.C(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new mi(i, localArrayList3, str, bool, localArrayList2, localArrayList1);
    }

    public mi[] a(int paramInt) {
        return new mi[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
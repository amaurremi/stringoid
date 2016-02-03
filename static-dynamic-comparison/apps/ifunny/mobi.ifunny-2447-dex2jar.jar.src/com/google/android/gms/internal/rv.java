package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.HashSet;
import java.util.Set;

public class rv
        implements Parcelable.Creator<nv> {
    static void a(nv paramnv, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        Set localSet = paramnv.a;
        if (localSet.contains(Integer.valueOf(1))) {
            c.a(paramParcel, 1, paramnv.b);
        }
        if (localSet.contains(Integer.valueOf(2))) {
            c.a(paramParcel, 2, paramnv.c, true);
        }
        if (localSet.contains(Integer.valueOf(4))) {
            c.a(paramParcel, 4, paramnv.d, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(5))) {
            c.a(paramParcel, 5, paramnv.e, true);
        }
        if (localSet.contains(Integer.valueOf(6))) {
            c.a(paramParcel, 6, paramnv.f, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(7))) {
            c.a(paramParcel, 7, paramnv.g, true);
        }
        c.a(paramParcel, i);
    }

    public nv a(Parcel paramParcel) {
        String str1 = null;
        int j = a.b(paramParcel);
        HashSet localHashSet = new HashSet();
        int i = 0;
        nt localnt1 = null;
        String str2 = null;
        nt localnt2 = null;
        String str3 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                case 3:
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    localnt2 = (nt) a.a(paramParcel, k, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    localnt1 = (nt) a.a(paramParcel, k, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str1 = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(7));
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new nv(localHashSet, i, str3, localnt2, str2, localnt1, str1);
    }

    public nv[] a(int paramInt) {
        return new nv[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
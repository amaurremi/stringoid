package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.HashSet;
import java.util.Set;

public class se
        implements Parcelable.Creator<ny.d> {
    static void a(ny.d paramd, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        Set localSet = paramd.a;
        if (localSet.contains(Integer.valueOf(1))) {
            c.a(paramParcel, 1, paramd.b);
        }
        if (localSet.contains(Integer.valueOf(2))) {
            c.a(paramParcel, 2, paramd.c, true);
        }
        if (localSet.contains(Integer.valueOf(3))) {
            c.a(paramParcel, 3, paramd.d, true);
        }
        if (localSet.contains(Integer.valueOf(4))) {
            c.a(paramParcel, 4, paramd.e, true);
        }
        if (localSet.contains(Integer.valueOf(5))) {
            c.a(paramParcel, 5, paramd.f, true);
        }
        if (localSet.contains(Integer.valueOf(6))) {
            c.a(paramParcel, 6, paramd.g, true);
        }
        if (localSet.contains(Integer.valueOf(7))) {
            c.a(paramParcel, 7, paramd.h, true);
        }
        c.a(paramParcel, paramInt);
    }

    public ny.d a(Parcel paramParcel) {
        String str1 = null;
        int j = a.b(paramParcel);
        HashSet localHashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = a.o(paramParcel, k);
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
        return new ny.d(localHashSet, i, str6, str5, str4, str3, str2, str1);
    }

    public ny.d[] a(int paramInt) {
        return new ny.d[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/se.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
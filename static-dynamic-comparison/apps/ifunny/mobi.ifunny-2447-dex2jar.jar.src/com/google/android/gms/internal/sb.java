package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.HashSet;
import java.util.Set;

public class sb
        implements Parcelable.Creator<ny.b.a> {
    static void a(ny.b.a parama, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        Set localSet = parama.a;
        if (localSet.contains(Integer.valueOf(1))) {
            c.a(paramParcel, 1, parama.b);
        }
        if (localSet.contains(Integer.valueOf(2))) {
            c.a(paramParcel, 2, parama.c);
        }
        if (localSet.contains(Integer.valueOf(3))) {
            c.a(paramParcel, 3, parama.d);
        }
        c.a(paramParcel, paramInt);
    }

    public ny.b.a a(Parcel paramParcel) {
        int k = 0;
        int m = a.b(paramParcel);
        HashSet localHashSet = new HashSet();
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    i = a.g(paramParcel, n);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    j = a.g(paramParcel, n);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    k = a.g(paramParcel, n);
                    localHashSet.add(Integer.valueOf(3));
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new ny.b.a(localHashSet, i, j, k);
    }

    public ny.b.a[] a(int paramInt) {
        return new ny.b.a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
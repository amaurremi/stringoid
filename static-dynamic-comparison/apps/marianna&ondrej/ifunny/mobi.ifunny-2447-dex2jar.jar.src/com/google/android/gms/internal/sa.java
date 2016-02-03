package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.HashSet;
import java.util.Set;

public class sa
        implements Parcelable.Creator<ny.b> {
    static void a(ny.b paramb, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        Set localSet = paramb.a;
        if (localSet.contains(Integer.valueOf(1))) {
            c.a(paramParcel, 1, paramb.b);
        }
        if (localSet.contains(Integer.valueOf(2))) {
            c.a(paramParcel, 2, paramb.c, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(3))) {
            c.a(paramParcel, 3, paramb.d, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(4))) {
            c.a(paramParcel, 4, paramb.e);
        }
        c.a(paramParcel, i);
    }

    public ny.b a(Parcel paramParcel) {
        ny.b.b localb = null;
        int i = 0;
        int k = a.b(paramParcel);
        HashSet localHashSet = new HashSet();
        ny.b.a locala = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    locala = (ny.b.a) a.a(paramParcel, m, ny.b.a.CREATOR);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    localb = (ny.b.b) a.a(paramParcel, m, ny.b.b.CREATOR);
                    localHashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(4));
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new ny.b(localHashSet, j, locala, localb, i);
    }

    public ny.b[] a(int paramInt) {
        return new ny.b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
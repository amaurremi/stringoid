package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.HashSet;
import java.util.Set;

public class ik
        implements Parcelable.Creator<ih.b> {
    static void a(ih.b paramb, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        Set localSet = paramb.ja();
        if (localSet.contains(Integer.valueOf(1))) {
            b.c(paramParcel, 1, paramb.getVersionCode());
        }
        if (localSet.contains(Integer.valueOf(2))) {
            b.a(paramParcel, 2, paramb.jE(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(3))) {
            b.a(paramParcel, 3, paramb.jF(), paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(4))) {
            b.c(paramParcel, 4, paramb.getLayout());
        }
        b.F(paramParcel, i);
    }

    public ih.b aP(Parcel paramParcel) {
        ih.b.b localb = null;
        int i = 0;
        int k = a.o(paramParcel);
        HashSet localHashSet = new HashSet();
        ih.b.a locala = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.n(paramParcel);
            switch (a.R(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    locala = (ih.b.a) a.a(paramParcel, m, ih.b.a.CREATOR);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    localb = (ih.b.b) a.a(paramParcel, m, ih.b.b.CREATOR);
                    localHashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(4));
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new a.a("Overread allowed size end=" + k, paramParcel);
        }
        return new ih.b(localHashSet, j, locala, localb, i);
    }

    public ih.b[] bS(int paramInt) {
        return new ih.b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
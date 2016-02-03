package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.HashSet;
import java.util.Set;

public class il
        implements Parcelable.Creator<ih.b.a> {
    static void a(ih.b.a parama, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        Set localSet = parama.ja();
        if (localSet.contains(Integer.valueOf(1))) {
            b.c(paramParcel, 1, parama.getVersionCode());
        }
        if (localSet.contains(Integer.valueOf(2))) {
            b.c(paramParcel, 2, parama.getLeftImageOffset());
        }
        if (localSet.contains(Integer.valueOf(3))) {
            b.c(paramParcel, 3, parama.getTopImageOffset());
        }
        b.F(paramParcel, paramInt);
    }

    public ih.b.a aQ(Parcel paramParcel) {
        int k = 0;
        int m = a.o(paramParcel);
        HashSet localHashSet = new HashSet();
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
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
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new ih.b.a(localHashSet, i, j, k);
    }

    public ih.b.a[] bT(int paramInt) {
        return new ih.b.a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.HashSet;
import java.util.Set;

public class ir
        implements Parcelable.Creator<ih.h> {
    static void a(ih.h paramh, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        Set localSet = paramh.ja();
        if (localSet.contains(Integer.valueOf(1))) {
            b.c(paramParcel, 1, paramh.getVersionCode());
        }
        if (localSet.contains(Integer.valueOf(3))) {
            b.c(paramParcel, 3, paramh.jN());
        }
        if (localSet.contains(Integer.valueOf(4))) {
            b.a(paramParcel, 4, paramh.getValue(), true);
        }
        if (localSet.contains(Integer.valueOf(5))) {
            b.a(paramParcel, 5, paramh.getLabel(), true);
        }
        if (localSet.contains(Integer.valueOf(6))) {
            b.c(paramParcel, 6, paramh.getType());
        }
        b.F(paramParcel, paramInt);
    }

    public ih.h aW(Parcel paramParcel) {
        String str1 = null;
        int i = 0;
        int m = a.o(paramParcel);
        HashSet localHashSet = new HashSet();
        int j = 0;
        String str2 = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
                case 2:
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = a.g(paramParcel, n);
                    localHashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str1 = a.n(paramParcel, n);
                    localHashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = a.n(paramParcel, n);
                    localHashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    j = a.g(paramParcel, n);
                    localHashSet.add(Integer.valueOf(6));
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new ih.h(localHashSet, k, str2, j, str1, i);
    }

    public ih.h[] bZ(int paramInt) {
        return new ih.h[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
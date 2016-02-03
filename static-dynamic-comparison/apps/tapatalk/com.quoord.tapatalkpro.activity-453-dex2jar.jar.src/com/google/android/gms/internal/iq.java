package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.HashSet;
import java.util.Set;

public class iq
        implements Parcelable.Creator<ih.g> {
    static void a(ih.g paramg, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        Set localSet = paramg.ja();
        if (localSet.contains(Integer.valueOf(1))) {
            b.c(paramParcel, 1, paramg.getVersionCode());
        }
        if (localSet.contains(Integer.valueOf(2))) {
            b.a(paramParcel, 2, paramg.isPrimary());
        }
        if (localSet.contains(Integer.valueOf(3))) {
            b.a(paramParcel, 3, paramg.getValue(), true);
        }
        b.F(paramParcel, paramInt);
    }

    public ih.g aV(Parcel paramParcel) {
        boolean bool = false;
        int j = a.o(paramParcel);
        HashSet localHashSet = new HashSet();
        String str = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    bool = a.c(paramParcel, k);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = a.n(paramParcel, k);
                    localHashSet.add(Integer.valueOf(3));
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new ih.g(localHashSet, i, bool, str);
    }

    public ih.g[] bY(int paramInt) {
        return new ih.g[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
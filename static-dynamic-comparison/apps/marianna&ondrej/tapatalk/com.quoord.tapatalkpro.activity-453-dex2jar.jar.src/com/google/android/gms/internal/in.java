package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.HashSet;
import java.util.Set;

public class in
        implements Parcelable.Creator<ih.c> {
    static void a(ih.c paramc, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        Set localSet = paramc.ja();
        if (localSet.contains(Integer.valueOf(1))) {
            b.c(paramParcel, 1, paramc.getVersionCode());
        }
        if (localSet.contains(Integer.valueOf(2))) {
            b.a(paramParcel, 2, paramc.getUrl(), true);
        }
        b.F(paramParcel, paramInt);
    }

    public ih.c aS(Parcel paramParcel) {
        int j = a.o(paramParcel);
        HashSet localHashSet = new HashSet();
        int i = 0;
        String str = null;
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
                    str = a.n(paramParcel, k);
                    localHashSet.add(Integer.valueOf(2));
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new ih.c(localHashSet, i, str);
    }

    public ih.c[] bV(int paramInt) {
        return new ih.c[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
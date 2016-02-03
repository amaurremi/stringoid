package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.HashSet;
import java.util.Set;

public class sd
        implements Parcelable.Creator<ny.c> {
    static void a(ny.c paramc, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        Set localSet = paramc.a;
        if (localSet.contains(Integer.valueOf(1))) {
            c.a(paramParcel, 1, paramc.b);
        }
        if (localSet.contains(Integer.valueOf(2))) {
            c.a(paramParcel, 2, paramc.c, true);
        }
        c.a(paramParcel, paramInt);
    }

    public ny.c a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        HashSet localHashSet = new HashSet();
        int i = 0;
        String str = null;
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
                    str = a.o(paramParcel, k);
                    localHashSet.add(Integer.valueOf(2));
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ny.c(localHashSet, i, str);
    }

    public ny.c[] a(int paramInt) {
        return new ny.c[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
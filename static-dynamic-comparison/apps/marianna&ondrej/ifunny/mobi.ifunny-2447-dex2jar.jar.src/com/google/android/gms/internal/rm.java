package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class rm
        implements Parcelable.Creator<nl> {
    static void a(nl paramnl, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramnl.a);
        c.a(paramParcel, 2, paramnl.b, false);
        c.a(paramParcel, 3, paramnl.c);
        c.a(paramParcel, 4, paramnl.d);
        c.a(paramParcel, 5, paramnl.e, false);
        c.a(paramParcel, 6, paramnl.f, false);
        c.a(paramParcel, 7, paramnl.g);
        c.a(paramParcel, paramInt);
    }

    public nl a(Parcel paramParcel) {
        String str1 = null;
        int i = 0;
        int m = a.b(paramParcel);
        boolean bool = true;
        String str2 = null;
        int j = 0;
        String str3 = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    str3 = a.o(paramParcel, n);
                    break;
                case 3:
                    j = a.g(paramParcel, n);
                    break;
                case 4:
                    i = a.g(paramParcel, n);
                    break;
                case 5:
                    str2 = a.o(paramParcel, n);
                    break;
                case 6:
                    str1 = a.o(paramParcel, n);
                    break;
                case 7:
                    bool = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new nl(k, str3, j, i, str2, str1, bool);
    }

    public nl[] a(int paramInt) {
        return new nl[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
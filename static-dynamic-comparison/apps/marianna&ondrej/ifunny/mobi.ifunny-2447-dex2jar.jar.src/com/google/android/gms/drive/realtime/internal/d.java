package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
        implements Parcelable.Creator<ParcelableIndexReference> {
    static void a(ParcelableIndexReference paramParcelableIndexReference, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramParcelableIndexReference.a);
        c.a(paramParcel, 2, paramParcelableIndexReference.b, false);
        c.a(paramParcel, 3, paramParcelableIndexReference.c);
        c.a(paramParcel, 4, paramParcelableIndexReference.d);
        c.a(paramParcel, paramInt);
    }

    public ParcelableIndexReference a(Parcel paramParcel) {
        boolean bool = false;
        int k = a.b(paramParcel);
        String str = null;
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    str = a.o(paramParcel, m);
                    break;
                case 3:
                    j = a.g(paramParcel, m);
                    break;
                case 4:
                    bool = a.c(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new ParcelableIndexReference(i, str, j, bool);
    }

    public ParcelableIndexReference[] a(int paramInt) {
        return new ParcelableIndexReference[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
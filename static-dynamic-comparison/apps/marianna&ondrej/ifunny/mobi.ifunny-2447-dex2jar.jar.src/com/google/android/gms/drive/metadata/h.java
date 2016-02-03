package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
        implements Parcelable.Creator<CustomPropertyKey> {
    static void a(CustomPropertyKey paramCustomPropertyKey, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramCustomPropertyKey.a);
        c.a(paramParcel, 2, paramCustomPropertyKey.b, false);
        c.a(paramParcel, 3, paramCustomPropertyKey.c);
        c.a(paramParcel, paramInt);
    }

    public CustomPropertyKey a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        String str = null;
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
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new CustomPropertyKey(i, str, j);
    }

    public CustomPropertyKey[] a(int paramInt) {
        return new CustomPropertyKey[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
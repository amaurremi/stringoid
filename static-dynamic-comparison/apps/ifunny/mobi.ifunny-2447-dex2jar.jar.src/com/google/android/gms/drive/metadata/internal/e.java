package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class e
        implements Parcelable.Creator<CustomProperty> {
    static void a(CustomProperty paramCustomProperty, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCustomProperty.a);
        c.a(paramParcel, 2, paramCustomProperty.b, paramInt, false);
        c.a(paramParcel, 3, paramCustomProperty.c, false);
        c.a(paramParcel, i);
    }

    public CustomProperty a(Parcel paramParcel) {
        String str = null;
        int j = a.b(paramParcel);
        int i = 0;
        CustomPropertyKey localCustomPropertyKey = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = a.g(paramParcel, k);
                continue;
                localCustomPropertyKey = (CustomPropertyKey) a.a(paramParcel, k, CustomPropertyKey.CREATOR);
                continue;
                str = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new CustomProperty(i, localCustomPropertyKey, str);
    }

    public CustomProperty[] a(int paramInt) {
        return new CustomProperty[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
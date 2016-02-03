package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;

public class c
        implements Parcelable.Creator<AppVisibleCustomProperties> {
    static void a(AppVisibleCustomProperties paramAppVisibleCustomProperties, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramAppVisibleCustomProperties.b);
        com.google.android.gms.common.internal.safeparcel.c.c(paramParcel, 2, paramAppVisibleCustomProperties.c, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public AppVisibleCustomProperties a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList = a.c(paramParcel, k, CustomProperty.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new AppVisibleCustomProperties(i, localArrayList);
    }

    public AppVisibleCustomProperties[] a(int paramInt) {
        return new AppVisibleCustomProperties[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
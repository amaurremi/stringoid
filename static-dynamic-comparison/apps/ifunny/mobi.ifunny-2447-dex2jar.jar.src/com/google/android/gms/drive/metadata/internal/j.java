package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class j
        implements Parcelable.Creator<MetadataBundle> {
    static void a(MetadataBundle paramMetadataBundle, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramMetadataBundle.a);
        c.a(paramParcel, 2, paramMetadataBundle.b, false);
        c.a(paramParcel, paramInt);
    }

    public MetadataBundle a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        Bundle localBundle = null;
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
                    localBundle = a.q(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new MetadataBundle(i, localBundle);
    }

    public MetadataBundle[] a(int paramInt) {
        return new MetadataBundle[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
        implements Parcelable.Creator<MetadataBundle> {
    static void a(MetadataBundle paramMetadataBundle, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramMetadataBundle.xH);
        b.a(paramParcel, 2, paramMetadataBundle.FQ, false);
        b.F(paramParcel, paramInt);
    }

    public MetadataBundle[] aF(int paramInt) {
        return new MetadataBundle[paramInt];
    }

    public MetadataBundle ab(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        Bundle localBundle = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localBundle = a.p(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new MetadataBundle(i, localBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
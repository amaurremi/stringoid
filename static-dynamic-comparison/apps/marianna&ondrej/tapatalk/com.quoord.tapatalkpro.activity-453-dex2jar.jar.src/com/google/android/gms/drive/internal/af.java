package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class af
        implements Parcelable.Creator<OnMetadataResponse> {
    static void a(OnMetadataResponse paramOnMetadataResponse, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramOnMetadataResponse.xH);
        b.a(paramParcel, 2, paramOnMetadataResponse.EZ, paramInt, false);
        b.F(paramParcel, i);
    }

    public OnMetadataResponse T(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        MetadataBundle localMetadataBundle = null;
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
                    localMetadataBundle = (MetadataBundle) a.a(paramParcel, k, MetadataBundle.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new OnMetadataResponse(i, localMetadataBundle);
    }

    public OnMetadataResponse[] ax(int paramInt) {
        return new OnMetadataResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class z
        implements Parcelable.Creator<OnContentsResponse> {
    static void a(OnContentsResponse paramOnContentsResponse, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramOnContentsResponse.xH);
        b.a(paramParcel, 2, paramOnContentsResponse.EA, paramInt, false);
        b.F(paramParcel, i);
    }

    public OnContentsResponse N(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        Contents localContents = null;
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
                    localContents = (Contents) a.a(paramParcel, k, Contents.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new OnContentsResponse(i, localContents);
    }

    public OnContentsResponse[] ar(int paramInt) {
        return new OnContentsResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
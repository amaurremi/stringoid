package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;

public class f
        implements Parcelable.Creator<OnContentsResponse> {
    static void a(OnContentsResponse paramOnContentsResponse, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnContentsResponse.a);
        c.a(paramParcel, 2, paramOnContentsResponse.b, paramInt, false);
        c.a(paramParcel, 3, paramOnContentsResponse.c);
        c.a(paramParcel, i);
    }

    public OnContentsResponse a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        Contents localContents = null;
        int i = 0;
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
                localContents = (Contents) a.a(paramParcel, k, Contents.CREATOR);
                continue;
                bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OnContentsResponse(i, localContents, bool);
    }

    public OnContentsResponse[] a(int paramInt) {
        return new OnContentsResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
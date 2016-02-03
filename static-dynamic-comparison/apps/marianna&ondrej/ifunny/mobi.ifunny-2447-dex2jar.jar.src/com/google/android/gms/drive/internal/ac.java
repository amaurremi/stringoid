package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;

public class ac
        implements Parcelable.Creator<CloseContentsRequest> {
    static void a(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCloseContentsRequest.a);
        c.a(paramParcel, 2, paramCloseContentsRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramCloseContentsRequest.c, false);
        c.a(paramParcel, i);
    }

    public CloseContentsRequest a(Parcel paramParcel) {
        Boolean localBoolean = null;
        int j = a.b(paramParcel);
        int i = 0;
        Contents localContents = null;
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
                localBoolean = a.d(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new CloseContentsRequest(i, localContents, localBoolean);
    }

    public CloseContentsRequest[] a(int paramInt) {
        return new CloseContentsRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
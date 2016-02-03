package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class r
        implements Parcelable.Creator<OpenContentsRequest> {
    static void a(OpenContentsRequest paramOpenContentsRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOpenContentsRequest.a);
        c.a(paramParcel, 2, paramOpenContentsRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramOpenContentsRequest.c);
        c.a(paramParcel, 4, paramOpenContentsRequest.d);
        c.a(paramParcel, i);
    }

    public OpenContentsRequest a(Parcel paramParcel) {
        int i = 0;
        int m = a.b(paramParcel);
        DriveId localDriveId = null;
        int j = 0;
        int k = 0;
        if (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
            }
            for (; ; ) {
                break;
                k = a.g(paramParcel, n);
                continue;
                localDriveId = (DriveId) a.a(paramParcel, n, DriveId.CREATOR);
                continue;
                j = a.g(paramParcel, n);
                continue;
                i = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new OpenContentsRequest(k, localDriveId, j, i);
    }

    public OpenContentsRequest[] a(int paramInt) {
        return new OpenContentsRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
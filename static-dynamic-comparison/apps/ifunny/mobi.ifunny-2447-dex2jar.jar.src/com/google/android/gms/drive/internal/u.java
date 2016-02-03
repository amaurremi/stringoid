package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class u
        implements Parcelable.Creator<RemoveEventListenerRequest> {
    static void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramRemoveEventListenerRequest.a);
        c.a(paramParcel, 2, paramRemoveEventListenerRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramRemoveEventListenerRequest.c);
        c.a(paramParcel, i);
    }

    public RemoveEventListenerRequest a(Parcel paramParcel) {
        int i = 0;
        int k = a.b(paramParcel);
        DriveId localDriveId = null;
        int j = 0;
        if (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
            }
            for (; ; ) {
                break;
                j = a.g(paramParcel, m);
                continue;
                localDriveId = (DriveId) a.a(paramParcel, m, DriveId.CREATOR);
                continue;
                i = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new RemoveEventListenerRequest(j, localDriveId, i);
    }

    public RemoveEventListenerRequest[] a(int paramInt) {
        return new RemoveEventListenerRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
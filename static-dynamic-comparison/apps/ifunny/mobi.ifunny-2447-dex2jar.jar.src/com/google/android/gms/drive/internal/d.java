package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class d
        implements Parcelable.Creator<LoadRealtimeRequest> {
    static void a(LoadRealtimeRequest paramLoadRealtimeRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramLoadRealtimeRequest.a);
        c.a(paramParcel, 2, paramLoadRealtimeRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramLoadRealtimeRequest.c);
        c.a(paramParcel, i);
    }

    public LoadRealtimeRequest a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        DriveId localDriveId = null;
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
                localDriveId = (DriveId) a.a(paramParcel, k, DriveId.CREATOR);
                continue;
                bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new LoadRealtimeRequest(i, localDriveId, bool);
    }

    public LoadRealtimeRequest[] a(int paramInt) {
        return new LoadRealtimeRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
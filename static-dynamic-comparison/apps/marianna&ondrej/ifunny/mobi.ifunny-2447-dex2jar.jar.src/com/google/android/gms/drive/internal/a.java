package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class a
        implements Parcelable.Creator<AddEventListenerRequest> {
    static void a(AddEventListenerRequest paramAddEventListenerRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramAddEventListenerRequest.a);
        c.a(paramParcel, 2, paramAddEventListenerRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramAddEventListenerRequest.c);
        c.a(paramParcel, i);
    }

    public AddEventListenerRequest a(Parcel paramParcel) {
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        DriveId localDriveId = null;
        int j = 0;
        if (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
            }
            for (; ; ) {
                break;
                j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                continue;
                localDriveId = (DriveId) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, DriveId.CREATOR);
                continue;
                i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new AddEventListenerRequest(j, localDriveId, i);
    }

    public AddEventListenerRequest[] a(int paramInt) {
        return new AddEventListenerRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
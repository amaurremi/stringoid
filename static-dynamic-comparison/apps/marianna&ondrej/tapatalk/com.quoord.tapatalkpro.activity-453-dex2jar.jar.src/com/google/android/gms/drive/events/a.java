package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class a
        implements Parcelable.Creator<ChangeEvent> {
    static void a(ChangeEvent paramChangeEvent, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramChangeEvent.xH);
        b.a(paramParcel, 2, paramChangeEvent.Ew, paramInt, false);
        b.c(paramParcel, 3, paramChangeEvent.ER);
        b.F(paramParcel, i);
    }

    public ChangeEvent A(Parcel paramParcel) {
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel);
        DriveId localDriveId = null;
        int j = 0;
        if (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.R(m)) {
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
            throw new a.a("Overread allowed size end=" + k, paramParcel);
        }
        return new ChangeEvent(j, localDriveId, i);
    }

    public ChangeEvent[] ae(int paramInt) {
        return new ChangeEvent[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/events/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
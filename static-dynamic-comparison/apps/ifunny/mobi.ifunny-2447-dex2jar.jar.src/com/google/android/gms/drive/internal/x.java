package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

import java.util.ArrayList;

public class x
        implements Parcelable.Creator<SetResourceParentsRequest> {
    static void a(SetResourceParentsRequest paramSetResourceParentsRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramSetResourceParentsRequest.a);
        c.a(paramParcel, 2, paramSetResourceParentsRequest.b, paramInt, false);
        c.c(paramParcel, 3, paramSetResourceParentsRequest.c, false);
        c.a(paramParcel, i);
    }

    public SetResourceParentsRequest a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = a.b(paramParcel);
        int i = 0;
        DriveId localDriveId = null;
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
                localArrayList = a.c(paramParcel, k, DriveId.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new SetResourceParentsRequest(i, localDriveId, localArrayList);
    }

    public SetResourceParentsRequest[] a(int paramInt) {
        return new SetResourceParentsRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
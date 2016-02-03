package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class c
        implements Parcelable.Creator<ListParentsRequest> {
    static void a(ListParentsRequest paramListParentsRequest, Parcel paramParcel, int paramInt) {
        int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramListParentsRequest.a);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramListParentsRequest.b, paramInt, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
    }

    public ListParentsRequest a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        DriveId localDriveId = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localDriveId = (DriveId) a.a(paramParcel, k, DriveId.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ListParentsRequest(i, localDriveId);
    }

    public ListParentsRequest[] a(int paramInt) {
        return new ListParentsRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
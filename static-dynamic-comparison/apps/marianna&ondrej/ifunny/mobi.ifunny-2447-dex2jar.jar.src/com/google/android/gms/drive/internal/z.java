package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class z
        implements Parcelable.Creator<UpdateMetadataRequest> {
    static void a(UpdateMetadataRequest paramUpdateMetadataRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramUpdateMetadataRequest.a);
        c.a(paramParcel, 2, paramUpdateMetadataRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramUpdateMetadataRequest.c, paramInt, false);
        c.a(paramParcel, i);
    }

    public UpdateMetadataRequest a(Parcel paramParcel) {
        MetadataBundle localMetadataBundle = null;
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
                localMetadataBundle = (MetadataBundle) a.a(paramParcel, k, MetadataBundle.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new UpdateMetadataRequest(i, localDriveId, localMetadataBundle);
    }

    public UpdateMetadataRequest[] a(int paramInt) {
        return new UpdateMetadataRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class an
        implements Parcelable.Creator<UpdateMetadataRequest> {
    static void a(UpdateMetadataRequest paramUpdateMetadataRequest, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramUpdateMetadataRequest.xH);
        b.a(paramParcel, 2, paramUpdateMetadataRequest.EV, paramInt, false);
        b.a(paramParcel, 3, paramUpdateMetadataRequest.EW, paramInt, false);
        b.F(paramParcel, i);
    }

    public UpdateMetadataRequest[] aE(int paramInt) {
        return new UpdateMetadataRequest[paramInt];
    }

    public UpdateMetadataRequest aa(Parcel paramParcel) {
        MetadataBundle localMetadataBundle = null;
        int j = a.o(paramParcel);
        int i = 0;
        DriveId localDriveId = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
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
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new UpdateMetadataRequest(i, localDriveId, localMetadataBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
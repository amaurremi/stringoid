package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ab
        implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> {
    static void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCloseContentsAndUpdateMetadataRequest.a);
        c.a(paramParcel, 2, paramCloseContentsAndUpdateMetadataRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramCloseContentsAndUpdateMetadataRequest.c, paramInt, false);
        c.a(paramParcel, 4, paramCloseContentsAndUpdateMetadataRequest.d, paramInt, false);
        c.a(paramParcel, 5, paramCloseContentsAndUpdateMetadataRequest.e);
        c.a(paramParcel, 6, paramCloseContentsAndUpdateMetadataRequest.f, false);
        c.a(paramParcel, 7, paramCloseContentsAndUpdateMetadataRequest.g);
        c.a(paramParcel, i);
    }

    public CloseContentsAndUpdateMetadataRequest a(Parcel paramParcel) {
        int i = 0;
        String str = null;
        int k = a.b(paramParcel);
        boolean bool = false;
        Contents localContents = null;
        MetadataBundle localMetadataBundle = null;
        DriveId localDriveId = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    localDriveId = (DriveId) a.a(paramParcel, m, DriveId.CREATOR);
                    break;
                case 3:
                    localMetadataBundle = (MetadataBundle) a.a(paramParcel, m, MetadataBundle.CREATOR);
                    break;
                case 4:
                    localContents = (Contents) a.a(paramParcel, m, Contents.CREATOR);
                    break;
                case 5:
                    bool = a.c(paramParcel, m);
                    break;
                case 6:
                    str = a.o(paramParcel, m);
                    break;
                case 7:
                    i = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new CloseContentsAndUpdateMetadataRequest(j, localDriveId, localMetadataBundle, localContents, bool, str, i);
    }

    public CloseContentsAndUpdateMetadataRequest[] a(int paramInt) {
        return new CloseContentsAndUpdateMetadataRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
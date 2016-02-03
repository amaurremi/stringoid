package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class af
        implements Parcelable.Creator<CreateFileRequest> {
    static void a(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCreateFileRequest.a);
        c.a(paramParcel, 2, paramCreateFileRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramCreateFileRequest.c, paramInt, false);
        c.a(paramParcel, 4, paramCreateFileRequest.d, paramInt, false);
        c.a(paramParcel, 5, paramCreateFileRequest.e, false);
        c.a(paramParcel, 6, paramCreateFileRequest.f);
        c.a(paramParcel, 7, paramCreateFileRequest.g, false);
        c.a(paramParcel, 8, paramCreateFileRequest.h);
        c.a(paramParcel, 9, paramCreateFileRequest.i);
        c.a(paramParcel, i);
    }

    public CreateFileRequest a(Parcel paramParcel) {
        int i = 0;
        String str = null;
        int m = a.b(paramParcel);
        int j = 0;
        boolean bool = false;
        Integer localInteger = null;
        Contents localContents = null;
        MetadataBundle localMetadataBundle = null;
        DriveId localDriveId = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    localDriveId = (DriveId) a.a(paramParcel, n, DriveId.CREATOR);
                    break;
                case 3:
                    localMetadataBundle = (MetadataBundle) a.a(paramParcel, n, MetadataBundle.CREATOR);
                    break;
                case 4:
                    localContents = (Contents) a.a(paramParcel, n, Contents.CREATOR);
                    break;
                case 5:
                    localInteger = a.h(paramParcel, n);
                    break;
                case 6:
                    bool = a.c(paramParcel, n);
                    break;
                case 7:
                    str = a.o(paramParcel, n);
                    break;
                case 8:
                    j = a.g(paramParcel, n);
                    break;
                case 9:
                    i = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new CreateFileRequest(k, localDriveId, localMetadataBundle, localContents, localInteger, bool, str, j, i);
    }

    public CreateFileRequest[] a(int paramInt) {
        return new CreateFileRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
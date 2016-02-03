package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ae
        implements Parcelable.Creator<CreateFileIntentSenderRequest> {
    static void a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCreateFileIntentSenderRequest.a);
        c.a(paramParcel, 2, paramCreateFileIntentSenderRequest.b, paramInt, false);
        c.a(paramParcel, 3, paramCreateFileIntentSenderRequest.c);
        c.a(paramParcel, 4, paramCreateFileIntentSenderRequest.d, false);
        c.a(paramParcel, 5, paramCreateFileIntentSenderRequest.e, paramInt, false);
        c.a(paramParcel, 6, paramCreateFileIntentSenderRequest.f, false);
        c.a(paramParcel, i);
    }

    public CreateFileIntentSenderRequest a(Parcel paramParcel) {
        int i = 0;
        Integer localInteger = null;
        int k = a.b(paramParcel);
        DriveId localDriveId = null;
        String str = null;
        MetadataBundle localMetadataBundle = null;
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
                    localMetadataBundle = (MetadataBundle) a.a(paramParcel, m, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = a.g(paramParcel, m);
                    break;
                case 4:
                    str = a.o(paramParcel, m);
                    break;
                case 5:
                    localDriveId = (DriveId) a.a(paramParcel, m, DriveId.CREATOR);
                    break;
                case 6:
                    localInteger = a.h(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new CreateFileIntentSenderRequest(j, localMetadataBundle, i, str, localDriveId, localInteger);
    }

    public CreateFileIntentSenderRequest[] a(int paramInt) {
        return new CreateFileIntentSenderRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
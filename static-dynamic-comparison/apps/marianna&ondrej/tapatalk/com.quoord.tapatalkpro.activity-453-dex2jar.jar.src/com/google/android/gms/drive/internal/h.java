package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class h
        implements Parcelable.Creator<CreateFileRequest> {
    static void a(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramCreateFileRequest.xH);
        b.a(paramParcel, 2, paramCreateFileRequest.Fa, paramInt, false);
        b.a(paramParcel, 3, paramCreateFileRequest.EZ, paramInt, false);
        b.a(paramParcel, 4, paramCreateFileRequest.EX, paramInt, false);
        b.F(paramParcel, i);
    }

    public CreateFileRequest I(Parcel paramParcel) {
        Contents localContents = null;
        int j = a.o(paramParcel);
        int i = 0;
        Object localObject2 = null;
        Object localObject1 = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            Object localObject3;
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    localObject3 = localObject2;
                    localObject2 = localObject1;
                    localObject1 = localObject3;
            }
            for (; ; ) {
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
                break;
                i = a.g(paramParcel, k);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = (DriveId) a.a(paramParcel, k, DriveId.CREATOR);
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = (MetadataBundle) a.a(paramParcel, k, MetadataBundle.CREATOR);
                localObject2 = localObject1;
                localObject1 = localObject3;
                continue;
                localContents = (Contents) a.a(paramParcel, k, Contents.CREATOR);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new CreateFileRequest(i, (DriveId) localObject1, (MetadataBundle) localObject2, localContents);
    }

    public CreateFileRequest[] am(int paramInt) {
        return new CreateFileRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
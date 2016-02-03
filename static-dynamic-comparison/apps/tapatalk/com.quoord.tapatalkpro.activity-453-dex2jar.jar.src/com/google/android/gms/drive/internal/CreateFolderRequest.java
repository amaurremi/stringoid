package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fq;

public class CreateFolderRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new i();
    final MetadataBundle EZ;
    final DriveId Fa;
    final int xH;

    CreateFolderRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle) {
        this.xH = paramInt;
        this.Fa = ((DriveId) fq.f(paramDriveId));
        this.EZ = ((MetadataBundle) fq.f(paramMetadataBundle));
    }

    public CreateFolderRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle) {
        this(1, paramDriveId, paramMetadataBundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFolderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
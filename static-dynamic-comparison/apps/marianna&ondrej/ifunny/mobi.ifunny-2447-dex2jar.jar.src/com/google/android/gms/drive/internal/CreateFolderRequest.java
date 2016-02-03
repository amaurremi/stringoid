package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new ag();
    final int a;
    final DriveId b;
    final MetadataBundle c;

    CreateFolderRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle) {
        this.a = paramInt;
        this.b = ((DriveId) com.google.android.gms.common.internal.ag.a(paramDriveId));
        this.c = ((MetadataBundle) com.google.android.gms.common.internal.ag.a(paramMetadataBundle));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ag.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFolderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
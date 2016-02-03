package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<UpdateMetadataRequest> CREATOR = new z();
    final int a;
    final DriveId b;
    final MetadataBundle c;

    UpdateMetadataRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle) {
        this.a = paramInt;
        this.b = paramDriveId;
        this.c = paramMetadataBundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        z.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/UpdateMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
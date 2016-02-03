package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new ab();
    final int a;
    final DriveId b;
    final MetadataBundle c;
    final Contents d;
    final boolean e;
    final String f;
    final int g;

    CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean, String paramString, int paramInt2) {
        this.a = paramInt1;
        this.b = paramDriveId;
        this.c = paramMetadataBundle;
        this.d = paramContents;
        this.e = paramBoolean;
        this.f = paramString;
        this.g = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ab.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/CloseContentsAndUpdateMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
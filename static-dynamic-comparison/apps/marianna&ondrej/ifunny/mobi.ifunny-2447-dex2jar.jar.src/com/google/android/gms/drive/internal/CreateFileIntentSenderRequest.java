package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new ae();
    final int a;
    final MetadataBundle b;
    final int c;
    final String d;
    final DriveId e;
    final Integer f;

    CreateFileIntentSenderRequest(int paramInt1, MetadataBundle paramMetadataBundle, int paramInt2, String paramString, DriveId paramDriveId, Integer paramInteger) {
        this.a = paramInt1;
        this.b = paramMetadataBundle;
        this.c = paramInt2;
        this.d = paramString;
        this.e = paramDriveId;
        this.f = paramInteger;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ae.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileIntentSenderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
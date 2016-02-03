package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new ak();
    final int ES;
    final DriveId Ew;
    final int xH;

    RemoveEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2) {
        this.xH = paramInt1;
        this.Ew = paramDriveId;
        this.ES = paramInt2;
    }

    public RemoveEventListenerRequest(DriveId paramDriveId, int paramInt) {
        this(1, paramDriveId, paramInt);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ak.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/RemoveEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
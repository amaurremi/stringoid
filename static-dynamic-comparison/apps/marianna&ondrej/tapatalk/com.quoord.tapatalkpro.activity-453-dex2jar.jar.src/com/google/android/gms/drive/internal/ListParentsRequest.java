package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ListParentsRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<ListParentsRequest> CREATOR = new x();
    final DriveId FB;
    final int xH;

    ListParentsRequest(int paramInt, DriveId paramDriveId) {
        this.xH = paramInt;
        this.FB = paramDriveId;
    }

    public ListParentsRequest(DriveId paramDriveId) {
        this(1, paramDriveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        x.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/ListParentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
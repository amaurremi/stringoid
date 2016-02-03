package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<TrashResourceRequest> CREATOR = new y();
    final int a;
    final DriveId b;

    TrashResourceRequest(int paramInt, DriveId paramDriveId) {
        this.a = paramInt;
        this.b = paramDriveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        y.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/TrashResourceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new h();
    final int a;
    DriveId b;

    OnDriveIdResponse(int paramInt, DriveId paramDriveId) {
        this.a = paramInt;
        this.b = paramDriveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/OnDriveIdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
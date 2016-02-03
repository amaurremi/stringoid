package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

import java.util.List;

public class SetResourceParentsRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<SetResourceParentsRequest> CREATOR = new x();
    final int a;
    final DriveId b;
    final List<DriveId> c;

    SetResourceParentsRequest(int paramInt, DriveId paramDriveId, List<DriveId> paramList) {
        this.a = paramInt;
        this.b = paramDriveId;
        this.c = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        x.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/SetResourceParentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class LoadRealtimeRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new d();
    final int a;
    final DriveId b;
    final boolean c;

    LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean) {
        this.a = paramInt;
        this.b = paramDriveId;
        this.c = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/LoadRealtimeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
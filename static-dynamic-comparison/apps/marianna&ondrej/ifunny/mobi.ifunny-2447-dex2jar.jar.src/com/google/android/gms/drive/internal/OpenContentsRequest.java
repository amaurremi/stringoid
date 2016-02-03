package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new r();
    final int a;
    final DriveId b;
    final int c;
    final int d;

    OpenContentsRequest(int paramInt1, DriveId paramDriveId, int paramInt2, int paramInt3) {
        this.a = paramInt1;
        this.b = paramDriveId;
        this.c = paramInt2;
        this.d = paramInt3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        r.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/OpenContentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
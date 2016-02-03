package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new a();
    final int a;
    final DriveId b;
    final int c;

    AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2) {
        this.a = paramInt1;
        this.b = paramDriveId;
        this.c = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/AddEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
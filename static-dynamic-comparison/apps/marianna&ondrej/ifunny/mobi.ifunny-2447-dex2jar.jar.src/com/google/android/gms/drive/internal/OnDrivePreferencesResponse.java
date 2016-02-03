package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnDrivePreferencesResponse> CREATOR = new i();
    final int a;
    DrivePreferences b;

    OnDrivePreferencesResponse(int paramInt, DrivePreferences paramDrivePreferences) {
        this.a = paramInt;
        this.b = paramDrivePreferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/OnDrivePreferencesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
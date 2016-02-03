package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences
        implements SafeParcelable {
    public static final Parcelable.Creator<DrivePreferences> CREATOR = new c();
    final int a;
    final boolean b;

    DrivePreferences(int paramInt, boolean paramBoolean) {
        this.a = paramInt;
        this.b = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/DrivePreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
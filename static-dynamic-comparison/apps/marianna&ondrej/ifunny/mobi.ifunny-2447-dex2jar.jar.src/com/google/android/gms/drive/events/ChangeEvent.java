package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

import java.util.Locale;

public final class ChangeEvent
        implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new a();
    final int a;
    final DriveId b;
    final int c;

    ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2) {
        this.a = paramInt1;
        this.b = paramDriveId;
        this.c = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.b, Integer.valueOf(this.c)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/events/ChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
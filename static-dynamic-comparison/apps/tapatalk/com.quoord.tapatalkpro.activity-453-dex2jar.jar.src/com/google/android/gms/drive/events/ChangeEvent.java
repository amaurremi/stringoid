package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ChangeEvent
        implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new a();
    final int ER;
    final DriveId Ew;
    final int xH;

    ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2) {
        this.xH = paramInt1;
        this.Ew = paramDriveId;
        this.ER = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Ew;
    }

    public int getType() {
        return 1;
    }

    public boolean hasContentChanged() {
        return (this.ER & 0x2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.ER & 0x1) != 0;
    }

    public String toString() {
        return String.format("ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.Ew, Integer.valueOf(this.ER)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/events/ChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
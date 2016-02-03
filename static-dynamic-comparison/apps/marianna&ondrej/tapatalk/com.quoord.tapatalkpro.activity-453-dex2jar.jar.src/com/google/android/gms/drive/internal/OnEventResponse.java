package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;

public class OnEventResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnEventResponse> CREATOR = new ac();
    final int ES;
    final ChangeEvent FH;
    final ConflictEvent FI;
    final int xH;

    OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, ConflictEvent paramConflictEvent) {
        this.xH = paramInt1;
        this.ES = paramInt2;
        this.FH = paramChangeEvent;
        this.FI = paramConflictEvent;
    }

    public int describeContents() {
        return 0;
    }

    public ChangeEvent fL() {
        return this.FH;
    }

    public ConflictEvent fM() {
        return this.FI;
    }

    public int getEventType() {
        return this.ES;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ac.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
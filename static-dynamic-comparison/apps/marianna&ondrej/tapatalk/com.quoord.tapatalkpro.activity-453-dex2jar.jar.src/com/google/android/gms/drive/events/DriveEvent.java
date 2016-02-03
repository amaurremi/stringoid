package com.google.android.gms.drive.events;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public abstract interface DriveEvent
        extends SafeParcelable {
    public static final int TYPE_CHANGE = 1;

    public abstract DriveId getDriveId();

    public abstract int getType();

    public static abstract interface Listener<E extends DriveEvent> {
        public abstract void onEvent(E paramE);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/events/DriveEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
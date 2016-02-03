package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public abstract interface ResourceEvent
        extends DriveEvent {
    public abstract DriveId getDriveId();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/events/ResourceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
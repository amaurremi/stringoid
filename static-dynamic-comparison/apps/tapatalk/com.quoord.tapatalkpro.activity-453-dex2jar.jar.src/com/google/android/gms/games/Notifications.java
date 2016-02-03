package com.google.android.gms.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

public abstract interface Notifications {
    public static final int NOTIFICATION_TYPES_ALL = 7;
    public static final int NOTIFICATION_TYPES_MULTIPLAYER = 3;
    public static final int NOTIFICATION_TYPE_INVITATION = 1;
    public static final int NOTIFICATION_TYPE_MATCH_UPDATE = 2;
    public static final int NOTIFICATION_TYPE_REQUEST = 4;

    public abstract void clear(GoogleApiClient paramGoogleApiClient, int paramInt);

    public abstract void clearAll(GoogleApiClient paramGoogleApiClient);

    public static abstract interface ContactSettingLoadResult
            extends Result {
    }

    public static abstract interface GameMuteStatusChangeResult
            extends Result {
    }

    public static abstract interface GameMuteStatusLoadResult
            extends Result {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/Notifications.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
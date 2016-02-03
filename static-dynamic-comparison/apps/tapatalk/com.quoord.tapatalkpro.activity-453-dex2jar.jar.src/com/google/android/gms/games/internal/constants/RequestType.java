package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class RequestType {
    public static String bd(int paramInt) {
        switch (paramInt) {
            default:
                GamesLog.h("RequestType", "Unknown request type: " + paramInt);
                return "UNKNOWN_TYPE";
            case 1:
                return "GIFT";
        }
        return "WISH";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/constants/RequestType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
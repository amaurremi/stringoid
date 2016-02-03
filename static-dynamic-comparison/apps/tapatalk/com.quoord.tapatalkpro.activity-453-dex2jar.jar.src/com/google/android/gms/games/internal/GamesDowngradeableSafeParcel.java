package com.google.android.gms.games.internal;

import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.go;

public abstract class GamesDowngradeableSafeParcel
        extends fe {
    protected static boolean c(Integer paramInteger) {
        if (paramInteger == null) {
            return false;
        }
        return go.aa(paramInteger.intValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/GamesDowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.c;
import com.google.android.gms.internal.ps;

public abstract class GamesDowngradeableSafeParcel
        extends c {
    protected static boolean b(Integer paramInteger) {
        if (paramInteger == null) {
            return false;
        }
        return ps.a(paramInteger.intValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/GamesDowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
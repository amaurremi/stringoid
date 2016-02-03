package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class t {
    public static void a(Bundle paramBundle, String paramString, Parcelable paramParcelable) {
        paramBundle.setClassLoader(t.class.getClassLoader());
        Bundle localBundle2 = paramBundle.getBundle("map_state");
        Bundle localBundle1 = localBundle2;
        if (localBundle2 == null) {
            localBundle1 = new Bundle();
        }
        localBundle1.setClassLoader(t.class.getClassLoader());
        localBundle1.putParcelable(paramString, paramParcelable);
        paramBundle.putBundle("map_state", localBundle1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
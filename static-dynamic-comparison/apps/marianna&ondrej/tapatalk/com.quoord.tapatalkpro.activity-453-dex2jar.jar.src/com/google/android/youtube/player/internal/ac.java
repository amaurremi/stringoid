package com.google.android.youtube.player.internal;

import android.text.TextUtils;

public final class ac {
    public static <T> T a(T paramT) {
        if (paramT == null) {
            throw new NullPointerException("null reference");
        }
        return paramT;
    }

    public static <T> T a(T paramT, Object paramObject) {
        if (paramT == null) {
            throw new NullPointerException(String.valueOf(paramObject));
        }
        return paramT;
    }

    public static String a(String paramString, Object paramObject) {
        if (TextUtils.isEmpty(paramString)) {
            throw new IllegalArgumentException(String.valueOf(paramObject));
        }
        return paramString;
    }

    public static void a(boolean paramBoolean) {
        if (!paramBoolean) {
            throw new IllegalStateException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
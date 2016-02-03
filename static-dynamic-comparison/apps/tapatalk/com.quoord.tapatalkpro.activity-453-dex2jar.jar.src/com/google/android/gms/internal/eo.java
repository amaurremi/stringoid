package com.google.android.gms.internal;

import android.text.TextUtils;

public final class eo {
    public static void W(String paramString)
            throws IllegalArgumentException {
        if (TextUtils.isEmpty(paramString)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if (paramString.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (!paramString.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if (paramString.length() == "urn:x-cast:".length()) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static String X(String paramString) {
        return "urn:x-cast:" + paramString;
    }

    public static <T> boolean a(T paramT1, T paramT2) {
        return ((paramT1 == null) && (paramT2 == null)) || ((paramT1 != null) && (paramT2 != null) && (paramT1.equals(paramT2)));
    }

    public static long b(double paramDouble) {
        return (1000.0D * paramDouble);
    }

    public static double m(long paramLong) {
        return paramLong / 1000.0D;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
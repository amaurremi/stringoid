package com.google.android.gms.internal;

public final class gn
        implements gl {
    private static gn Er;

    public static gl ft() {
        try {
            if (Er == null) {
                Er = new gn();
            }
            gn localgn = Er;
            return localgn;
        } finally {
        }
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
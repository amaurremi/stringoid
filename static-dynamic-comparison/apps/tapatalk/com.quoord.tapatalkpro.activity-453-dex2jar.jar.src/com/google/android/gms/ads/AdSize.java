package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.ak;
import com.google.android.gms.internal.dv;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    private final int kr;
    private final int ks;
    private final String kt;

    public AdSize(int paramInt1, int paramInt2) {
    }

    AdSize(int paramInt1, int paramInt2, String paramString) {
        if ((paramInt1 < 0) && (paramInt1 != -1)) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
        }
        if ((paramInt2 < 0) && (paramInt2 != -2)) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
        }
        this.kr = paramInt1;
        this.ks = paramInt2;
        this.kt = paramString;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof AdSize)) {
                return false;
            }
            paramObject = (AdSize) paramObject;
        }
        while ((this.kr == ((AdSize) paramObject).kr) && (this.ks == ((AdSize) paramObject).ks) && (this.kt.equals(((AdSize) paramObject).kt)));
        return false;
    }

    public int getHeight() {
        return this.ks;
    }

    public int getHeightInPixels(Context paramContext) {
        if (this.ks == -2) {
            return ak.b(paramContext.getResources().getDisplayMetrics());
        }
        return dv.a(paramContext, this.ks);
    }

    public int getWidth() {
        return this.kr;
    }

    public int getWidthInPixels(Context paramContext) {
        if (this.kr == -1) {
            return ak.a(paramContext.getResources().getDisplayMetrics());
        }
        return dv.a(paramContext, this.kr);
    }

    public int hashCode() {
        return this.kt.hashCode();
    }

    public boolean isAutoHeight() {
        return this.ks == -2;
    }

    public boolean isFullWidth() {
        return this.kr == -1;
    }

    public String toString() {
        return this.kt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/ads/AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
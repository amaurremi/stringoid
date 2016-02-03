package com.mopub.common.util;

import android.os.Build.VERSION;

public enum VersionCode {
    private int a;

    private VersionCode(int paramInt) {
        this.a = paramInt;
    }

    private static VersionCode a(int paramInt) {
        VersionCode[] arrayOfVersionCode = values();
        int j = arrayOfVersionCode.length;
        int i = 0;
        while (i < j) {
            VersionCode localVersionCode = arrayOfVersionCode[i];
            if (localVersionCode.getApiLevel() == paramInt) {
                return localVersionCode;
            }
            i += 1;
        }
        return CUR_DEVELOPMENT;
    }

    public static VersionCode currentApiLevel() {
        return a(Build.VERSION.SDK_INT);
    }

    public int getApiLevel() {
        return this.a;
    }

    public boolean isAtLeast(VersionCode paramVersionCode) {
        return getApiLevel() >= paramVersionCode.getApiLevel();
    }

    public boolean isAtMost(VersionCode paramVersionCode) {
        return getApiLevel() <= paramVersionCode.getApiLevel();
    }

    public boolean isBelow(VersionCode paramVersionCode) {
        return getApiLevel() < paramVersionCode.getApiLevel();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/VersionCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
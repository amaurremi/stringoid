package com.mopub.common.util;

public class Visibility {
    public static boolean hasScreenVisibilityChanged(int paramInt1, int paramInt2) {
        return isScreenVisible(paramInt1) != isScreenVisible(paramInt2);
    }

    public static boolean isScreenVisible(int paramInt) {
        return paramInt == 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Visibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
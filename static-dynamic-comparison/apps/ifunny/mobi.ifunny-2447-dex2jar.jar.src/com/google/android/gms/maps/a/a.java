package com.google.android.gms.maps.a;

public final class a {
    public static byte a(Boolean paramBoolean) {
        if (paramBoolean != null) {
            if (paramBoolean.booleanValue()) {
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public static Boolean a(byte paramByte) {
        switch (paramByte) {
            default:
                return null;
            case 1:
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.mopub.common.util;

import org.apache.http.conn.util.InetAddressUtils;

public enum DeviceUtils$IP {
    private DeviceUtils$IP() {
    }

    private boolean a(String paramString) {
        switch (a.a[ordinal()]) {
            default:
                return false;
            case 1:
                return InetAddressUtils.isIPv4Address(paramString);
        }
        return InetAddressUtils.isIPv6Address(paramString);
    }

    private String b(String paramString) {
        String str = paramString;
        switch (a.a[ordinal()]) {
            default:
                str = null;
            case 1:
                return str;
        }
        return paramString.split("%")[0];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/DeviceUtils$IP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
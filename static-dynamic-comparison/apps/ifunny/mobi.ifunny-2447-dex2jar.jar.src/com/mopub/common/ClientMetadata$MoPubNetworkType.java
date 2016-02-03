package com.mopub.common;

public enum ClientMetadata$MoPubNetworkType {
    private final int a;

    static {
        ETHERNET = new MoPubNetworkType("ETHERNET", 1, 1);
        WIFI = new MoPubNetworkType("WIFI", 2, 2);
    }

    private ClientMetadata$MoPubNetworkType(int paramInt) {
        this.a = paramInt;
    }

    private static MoPubNetworkType b(int paramInt) {
        switch (paramInt) {
            case 6:
            case 7:
            case 8:
            default:
                return UNKNOWN;
            case 9:
                return ETHERNET;
            case 1:
                return WIFI;
        }
        return MOBILE;
    }

    public String toString() {
        return Integer.toString(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/ClientMetadata$MoPubNetworkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
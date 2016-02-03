package com.inmobi.commons.thinICE.wifi;

public final class WifiInfo {
    public long bssid;
    public int ip;
    public int rssi;
    public String ssid;

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getClass().getSimpleName()).append("[");
        localStringBuilder.append("bssid=").append(this.bssid).append(", ");
        localStringBuilder.append("ssid=").append(this.ssid).append(", ");
        localStringBuilder.append("rssi=").append(this.rssi).append(", ");
        localStringBuilder.append("ip=").append(String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(this.ip & 0xFF), Integer.valueOf(this.ip >> 8 & 0xFF), Integer.valueOf(this.ip >> 16 & 0xFF), Integer.valueOf(this.ip >> 24 & 0xFF)}));
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/wifi/WifiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
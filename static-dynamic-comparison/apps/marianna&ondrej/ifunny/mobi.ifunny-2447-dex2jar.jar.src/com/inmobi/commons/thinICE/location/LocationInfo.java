package com.inmobi.commons.thinICE.location;

public final class LocationInfo {
    public float accuracy;
    public double latitude;
    public double longitude;
    public String provider;
    public long time;

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getClass().getSimpleName()).append("[");
        localStringBuilder.append("time=").append(this.time).append(", ");
        localStringBuilder.append("provider=").append(this.provider).append(", ");
        localStringBuilder.append("latitude=").append(this.latitude).append(", ");
        localStringBuilder.append("longitude=").append(this.longitude).append(", ");
        localStringBuilder.append("accuracy=").append(this.accuracy);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/location/LocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
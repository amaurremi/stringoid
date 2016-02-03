package twitter4j;

import java.io.Serializable;

public class GeoLocation
        implements Serializable {
    private static final long serialVersionUID = -4847567157651889935L;
    protected double latitude;
    protected double longitude;

    GeoLocation() {
    }

    public GeoLocation(double paramDouble1, double paramDouble2) {
        this.latitude = paramDouble1;
        this.longitude = paramDouble2;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof GeoLocation)) {
                return false;
            }
            paramObject = (GeoLocation) paramObject;
            if (Double.compare(((GeoLocation) paramObject).getLatitude(), this.latitude) != 0) {
                return false;
            }
        } while (Double.compare(((GeoLocation) paramObject).getLongitude(), this.longitude) == 0);
        return false;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.latitude);
        int i = (int) (l >>> 32 ^ l);
        l = Double.doubleToLongBits(this.longitude);
        return i * 31 + (int) (l >>> 32 ^ l);
    }

    public String toString() {
        return "GeoLocation{latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/GeoLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
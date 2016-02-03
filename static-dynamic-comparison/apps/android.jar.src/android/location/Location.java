/*    */
package android.location;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*  5 */ public class Location implements android.os.Parcelable {
    public Location(String provider) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Location(Location l) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void dump(android.util.Printer pw, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void set(Location l) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static String convert(double coordinate, int outputType) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static double convert(String coordinate) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static void distanceBetween(double startLatitude, double startLongitude, double endLatitude, double endLongitude, float[] results) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public float distanceTo(Location dest) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public float bearingTo(Location dest) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String getProvider() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setProvider(String provider) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public long getTime() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setTime(long time) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public double getLatitude() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setLatitude(double latitude) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public double getLongitude() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setLongitude(double longitude) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean hasAltitude() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public double getAltitude() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setAltitude(double altitude) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void removeAltitude() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean hasSpeed() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public float getSpeed() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setSpeed(float speed) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void removeSpeed() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean hasBearing() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public float getBearing() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setBearing(float bearing) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void removeBearing() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean hasAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public float getAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void setAccuracy(float accuracy) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void removeAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public Bundle getExtras() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setExtras(Bundle extras) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void writeToParcel(android.os.Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int FORMAT_DEGREES = 0;
    /*    */   public static final int FORMAT_MINUTES = 1;
    /*    */   public static final int FORMAT_SECONDS = 2;
    /* 48 */   public static final android.os.Parcelable.Creator<Location> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/location/Location.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
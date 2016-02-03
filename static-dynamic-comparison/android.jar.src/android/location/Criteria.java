/*    */
package android.location;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class Criteria implements android.os.Parcelable {
    public Criteria() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Criteria(Criteria criteria) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setHorizontalAccuracy(int accuracy) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getHorizontalAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setVerticalAccuracy(int accuracy) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getVerticalAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setSpeedAccuracy(int accuracy) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getSpeedAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setBearingAccuracy(int accuracy) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getBearingAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setAccuracy(int accuracy) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getAccuracy() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setPowerRequirement(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getPowerRequirement() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setCostAllowed(boolean costAllowed) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean isCostAllowed() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setAltitudeRequired(boolean altitudeRequired) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean isAltitudeRequired() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setSpeedRequired(boolean speedRequired) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean isSpeedRequired() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setBearingRequired(boolean bearingRequired) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isBearingRequired() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void writeToParcel(Parcel parcel, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int NO_REQUIREMENT = 0;
    /*    */   public static final int POWER_LOW = 1;
    /*    */   public static final int POWER_MEDIUM = 2;
    /*    */   public static final int POWER_HIGH = 3;
    /*    */   public static final int ACCURACY_FINE = 1;
    /*    */   public static final int ACCURACY_COARSE = 2;
    /*    */   public static final int ACCURACY_LOW = 1;
    /*    */   public static final int ACCURACY_MEDIUM = 2;
    /*    */   public static final int ACCURACY_HIGH = 3;
    /* 39 */   public static final android.os.Parcelable.Creator<Criteria> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/location/Criteria.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
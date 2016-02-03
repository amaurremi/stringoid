/*    */
package android.location;

/*    */
/*    */ 
/*    */ public final class GpsStatus
/*    */ {
    /*    */   public static final int GPS_EVENT_STARTED = 1;
    /*    */
/*    */   public static final int GPS_EVENT_STOPPED = 2;
    /*    */   public static final int GPS_EVENT_FIRST_FIX = 3;
    /*    */   public static final int GPS_EVENT_SATELLITE_STATUS = 4;

    /*    */
/* 12 */   GpsStatus() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getTimeToFirstFix() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public Iterable<GpsSatellite> getSatellites() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getMaxSatellites() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface NmeaListener
/*    */ {
        /*    */
        public abstract void onNmeaReceived(long paramLong, String paramString);
/*    */
    }

    /*    */
/*    */   public static abstract interface Listener
/*    */ {
        /*    */
        public abstract void onGpsStatusChanged(int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/location/GpsStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
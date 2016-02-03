/*   */
package android.location;

/*   */
/*   */ public abstract class LocationProvider {
    /* 4 */   LocationProvider() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public boolean meetsCriteria(Criteria criteria) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int OUT_OF_SERVICE = 0;
    /*   */   public static final int TEMPORARILY_UNAVAILABLE = 1;
    /*   */   public static final int AVAILABLE = 2;

    /*   */
    public abstract boolean requiresNetwork();

    /*   */
/*   */
    public abstract boolean requiresSatellite();

    /*   */
/*   */
    public abstract boolean requiresCell();

    /*   */
/*   */
    public abstract boolean hasMonetaryCost();

    /*   */
/*   */
    public abstract boolean supportsAltitude();

    /*   */
/*   */
    public abstract boolean supportsSpeed();

    /*   */
/*   */
    public abstract boolean supportsBearing();

    /*   */
/*   */
    public abstract int getPowerRequirement();

    /*   */
/*   */
    public abstract int getAccuracy();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/location/LocationProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*   */
package android.location;
/*   */

import android.content.Context;

/*   */
/* 4 */ public final class Geocoder {
    public Geocoder(Context context, java.util.Locale locale) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public Geocoder(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public static boolean isPresent() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public java.util.List<Address> getFromLocation(double latitude, double longitude, int maxResults) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public java.util.List<Address> getFromLocationName(String locationName, int maxResults) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public java.util.List<Address> getFromLocationName(String locationName, int maxResults, double lowerLeftLatitude, double lowerLeftLongitude, double upperRightLatitude, double upperRightLongitude) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/location/Geocoder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
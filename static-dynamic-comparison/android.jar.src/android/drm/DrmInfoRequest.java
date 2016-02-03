/*    */
package android.drm;
/*    */

import java.util.Iterator;

/*    */
/*  4 */ public class DrmInfoRequest {
    public DrmInfoRequest(int infoType, String mimeType) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public String getMimeType() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public int getInfoType() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void put(String key, Object value) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public Object get(String key) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Iterator<String> keyIterator() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Iterator<Object> iterator() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int TYPE_REGISTRATION_INFO = 1;
    /*    */   public static final int TYPE_UNREGISTRATION_INFO = 2;
    /*    */   public static final int TYPE_RIGHTS_ACQUISITION_INFO = 3;
    /*    */   public static final int TYPE_RIGHTS_ACQUISITION_PROGRESS_INFO = 4;
    /*    */   public static final String ACCOUNT_ID = "account_id";
    /*    */   public static final String SUBSCRIPTION_ID = "subscription_id";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/drm/DrmInfoRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
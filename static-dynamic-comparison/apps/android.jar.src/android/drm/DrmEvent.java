/*   */
package android.drm;
/*   */

import java.util.HashMap;

/*   */
/* 4 */ public class DrmEvent {
    protected DrmEvent(int uniqueId, int type, String message, HashMap<String, Object> attributes) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    protected DrmEvent(int uniqueId, int type, String message) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public int getUniqueId() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public int getType() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public String getMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public Object getAttribute(String key) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int TYPE_ALL_RIGHTS_REMOVED = 1001;
    /*   */   public static final int TYPE_DRM_INFO_PROCESSED = 1002;
    /*   */   public static final String DRM_INFO_STATUS_OBJECT = "drm_info_status_object";
    /*   */   public static final String DRM_INFO_OBJECT = "drm_info_object";
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/drm/DrmEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
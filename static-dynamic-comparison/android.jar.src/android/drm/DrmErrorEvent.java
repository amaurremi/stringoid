/*   */
package android.drm;
/*   */ 
/*   */

import java.util.HashMap;

/*   */
/* 5 */ public class DrmErrorEvent extends DrmEvent {
    public DrmErrorEvent(int uniqueId, int type, String message) {
        super(0, 0, (String) null);
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public DrmErrorEvent(int uniqueId, int type, String message, HashMap<String, Object> attributes) {
        super(0, 0, (String) null);
        throw new RuntimeException("Stub!");
/*   */
    }

    /*   */
/*   */   public static final int TYPE_RIGHTS_NOT_INSTALLED = 2001;
    /*   */   public static final int TYPE_RIGHTS_RENEWAL_NOT_ALLOWED = 2002;
    /*   */   public static final int TYPE_NOT_SUPPORTED = 2003;
    /*   */   public static final int TYPE_OUT_OF_MEMORY = 2004;
    /*   */   public static final int TYPE_NO_INTERNET_CONNECTION = 2005;
    /*   */   public static final int TYPE_PROCESS_DRM_INFO_FAILED = 2006;
    /*   */   public static final int TYPE_REMOVE_ALL_RIGHTS_FAILED = 2007;
    /*   */   public static final int TYPE_ACQUIRE_DRM_INFO_FAILED = 2008;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/drm/DrmErrorEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
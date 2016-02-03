/*   */
package android.drm;
/*   */ 
/*   */

import java.util.HashMap;

/*   */
/* 5 */ public class DrmInfoEvent extends DrmEvent {
    public DrmInfoEvent(int uniqueId, int type, String message) {
        super(0, 0, (String) null);
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public DrmInfoEvent(int uniqueId, int type, String message, HashMap<String, Object> attributes) {
        super(0, 0, (String) null);
        throw new RuntimeException("Stub!");
/*   */
    }

    /*   */
/*   */   public static final int TYPE_ALREADY_REGISTERED_BY_ANOTHER_ACCOUNT = 1;
    /*   */   public static final int TYPE_REMOVE_RIGHTS = 2;
    /*   */   public static final int TYPE_RIGHTS_INSTALLED = 3;
    /*   */   public static final int TYPE_WAIT_FOR_RIGHTS = 4;
    /*   */   public static final int TYPE_ACCOUNT_ALREADY_REGISTERED = 5;
    /*   */   public static final int TYPE_RIGHTS_REMOVED = 6;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/drm/DrmInfoEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
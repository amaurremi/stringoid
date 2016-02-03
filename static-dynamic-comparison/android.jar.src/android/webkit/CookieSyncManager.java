/*   */
package android.webkit;
/*   */ 
/*   */

import android.content.Context;

/*   */
/* 5 */ public final class CookieSyncManager extends WebSyncManager {
    CookieSyncManager() {
        super((Context) null, (String) null);
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public static synchronized CookieSyncManager getInstance() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public static synchronized CookieSyncManager createInstance(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    protected void syncFromRamToFlash() {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/CookieSyncManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
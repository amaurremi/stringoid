/*    */
package android.database;
/*    */

import android.net.Uri;

/*    */
/*  4 */ public abstract class ContentObserver {
    public ContentObserver(android.os.Handler handler) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public boolean deliverSelfNotifications() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void onChange(boolean selfChange) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void onChange(boolean selfChange, Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  9 */ public final void dispatchChange(boolean selfChange) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final void dispatchChange(boolean selfChange, Uri uri) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/ContentObserver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
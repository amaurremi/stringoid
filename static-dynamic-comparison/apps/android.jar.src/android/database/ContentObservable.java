/*    */
package android.database;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*  5 */ public class ContentObservable extends Observable<ContentObserver> {
    public ContentObservable() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void registerObserver(ContentObserver observer) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  8 */ public void dispatchChange(boolean selfChange) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void dispatchChange(boolean selfChange, Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 11 */ public void notifyChange(boolean selfChange) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/ContentObservable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
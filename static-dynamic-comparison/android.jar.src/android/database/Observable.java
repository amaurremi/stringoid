/*   */
package android.database;
/*   */

import java.util.ArrayList;

/*   */
/* 4 */ public abstract class Observable<T> {
    public Observable() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void registerObserver(T observer) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void unregisterObserver(T observer) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void unregisterAll() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   protected final ArrayList<T> mObservers;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/Observable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
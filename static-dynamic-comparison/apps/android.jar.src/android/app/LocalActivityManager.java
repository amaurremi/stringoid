/*    */
package android.app;
/*    */

import android.os.Bundle;

/*    */
/*    */
@Deprecated
/*  5 */ public class LocalActivityManager {
    public LocalActivityManager(Activity parent, boolean singleMode) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public android.view.Window startActivity(String id, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public android.view.Window destroyActivity(String id, boolean finish) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public Activity getCurrentActivity() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String getCurrentId() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public Activity getActivity(String id) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void dispatchCreate(Bundle state) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Bundle saveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void dispatchResume() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void dispatchPause(boolean finishing) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void dispatchStop() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void removeAllActivities() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void dispatchDestroy(boolean finishing) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/LocalActivityManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
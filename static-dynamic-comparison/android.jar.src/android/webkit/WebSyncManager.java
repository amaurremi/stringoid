/*    */
package android.webkit;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ abstract class WebSyncManager implements Runnable {
    protected WebSyncManager(Context context, String name) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void run() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void sync() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void resetSync() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void startSync() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void stopSync() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    protected void onSyncInit() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   protected android.os.Handler mHandler;
    /*    */   protected WebViewDatabase mDataBase;
    /*    */   protected static final String LOGTAG = "websync";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebSyncManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
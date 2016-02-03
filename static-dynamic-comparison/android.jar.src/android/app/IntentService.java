/*    */
package android.app;
/*    */ 
/*    */

import android.content.Intent;

/*    */
/*  5 */ public abstract class IntentService extends Service {
    public IntentService(String name) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void setIntentRedelivery(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void onStart(Intent intent, int startId) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int onStartCommand(Intent intent, int flags, int startId) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.os.IBinder onBind(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    protected abstract void onHandleIntent(Intent paramIntent);
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/IntentService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
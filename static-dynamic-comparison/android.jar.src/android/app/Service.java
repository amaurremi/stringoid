/*    */
package android.app;
/*    */ 
/*    */

import android.content.Intent;

/*    */
/*    */ public abstract class Service extends android.content.ContextWrapper implements android.content.ComponentCallbacks2 {
    /*  6 */
    public Service() {
        super((android.content.Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public final Application getApplication() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 10 */ public void onStart(Intent intent, int startId) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int onStartCommand(Intent intent, int flags, int startId) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void onLowMemory() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onTrimMemory(int level) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract android.os.IBinder onBind(Intent paramIntent);

    /* 17 */
    public boolean onUnbind(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void onRebind(Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void onTaskRemoved(Intent rootIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public final void stopSelf() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final void stopSelf(int startId) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public final boolean stopSelfResult(int startId) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final void startForeground(int id, Notification notification) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final void stopForeground(boolean removeNotification) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int START_CONTINUATION_MASK = 15;
    /*    */   public static final int START_STICKY_COMPATIBILITY = 0;
    /*    */   public static final int START_STICKY = 1;
    /*    */   public static final int START_NOT_STICKY = 2;
    /*    */   public static final int START_REDELIVER_INTENT = 3;
    /*    */   public static final int START_FLAG_REDELIVERY = 1;
    /*    */   public static final int START_FLAG_RETRY = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/Service.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
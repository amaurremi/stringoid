/*    */
package android.app;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*    */ public class Instrumentation {
    /*  6 */   public static class ActivityMonitor {
        public ActivityMonitor(android.content.IntentFilter which, Instrumentation.ActivityResult result, boolean block) {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public ActivityMonitor(String cls, Instrumentation.ActivityResult result, boolean block) {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public final android.content.IntentFilter getFilter() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public final Instrumentation.ActivityResult getResult() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public final boolean isBlocking() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public final int getHits() {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public final Activity getLastActivity() {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public final Activity waitForActivity() {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public final Activity waitForActivityWithTimeout(long timeOut) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/*    */   public static final String REPORT_KEY_IDENTIFIER = "id";
    /*    */   public static final String REPORT_KEY_STREAMRESULT = "stream";

    /* 18 */   public static final class ActivityResult {
        public ActivityResult(int resultCode, android.content.Intent resultData) {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public int getResultCode() {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public android.content.Intent getResultData() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 22 */
    public Instrumentation() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void onCreate(Bundle arguments) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void start() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean onException(Object obj, Throwable e) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void sendStatus(int resultCode, Bundle results) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void finish(int resultCode, Bundle results) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setAutomaticPerformanceSnapshots() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void startPerformanceSnapshot() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void endPerformanceSnapshot() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public android.content.Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public android.content.ComponentName getComponentName() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public android.content.Context getTargetContext() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean isProfiling() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public void startProfiling() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void stopProfiling() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setInTouchMode(boolean inTouch) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void waitForIdle(Runnable recipient) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void waitForIdleSync() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void runOnMainSync(Runnable runner) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public Activity startActivitySync(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void addMonitor(ActivityMonitor monitor) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public ActivityMonitor addMonitor(android.content.IntentFilter filter, ActivityResult result, boolean block) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public ActivityMonitor addMonitor(String cls, ActivityResult result, boolean block) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public boolean checkMonitorHit(ActivityMonitor monitor, int minHits) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public Activity waitForMonitor(ActivityMonitor monitor) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public Activity waitForMonitorWithTimeout(ActivityMonitor monitor, long timeOut) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void removeMonitor(ActivityMonitor monitor) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public boolean invokeMenuActionSync(Activity targetActivity, int id, int flag) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public boolean invokeContextMenuAction(Activity targetActivity, int id, int flag) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void sendStringSync(String text) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void sendKeySync(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void sendKeyDownUpSync(int key) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void sendCharacterSync(int keyCode) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void sendPointerSync(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void sendTrackballEventSync(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public Application newApplication(ClassLoader cl, String className, android.content.Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public static Application newApplication(Class<?> clazz, android.content.Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void callApplicationOnCreate(Application app) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public Activity newActivity(Class<?> clazz, android.content.Context context, android.os.IBinder token, Application application, android.content.Intent intent, android.content.pm.ActivityInfo info, CharSequence title, Activity parent, String id, Object lastNonConfigurationInstance) throws InstantiationException, IllegalAccessException {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public Activity newActivity(ClassLoader cl, String className, android.content.Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void callActivityOnDestroy(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public void callActivityOnPostCreate(Activity activity, Bundle icicle) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public void callActivityOnNewIntent(Activity activity, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public void callActivityOnStart(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public void callActivityOnRestart(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public void callActivityOnResume(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    public void callActivityOnStop(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    public void callActivityOnSaveInstanceState(Activity activity, Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    public void callActivityOnPause(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 75 */
    public void callActivityOnUserLeaving(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 76 */
    public void startAllocCounting() {
        throw new RuntimeException("Stub!");
    }

    /* 77 */
    public void stopAllocCounting() {
        throw new RuntimeException("Stub!");
    }

    /* 78 */
    public Bundle getAllocCounts() {
        throw new RuntimeException("Stub!");
    }

    /* 79 */
    public Bundle getBinderCounts() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/Instrumentation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */
package android.app;
/*    */ 
/*    */

import android.content.ComponentCallbacks;
/*    */ import android.content.ComponentCallbacks2;
/*    */ import android.content.Context;
/*    */ import android.content.ContextWrapper;
/*    */ import android.content.res.Configuration;
/*    */ import android.os.Bundle;

/*    */
/*    */ public class Application
/*    */ extends ContextWrapper
/*    */ implements ComponentCallbacks2
/*    */ {
    /*    */
    public Application()
/*    */ {
/* 16 */
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void onTerminate() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void onConfigurationChanged(Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void onLowMemory() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void onTrimMemory(int level) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface ActivityLifecycleCallbacks
/*    */ {
        /*    */
        public abstract void onActivityCreated(Activity paramActivity, Bundle paramBundle);

        /*    */
/*    */
        public abstract void onActivityStarted(Activity paramActivity);

        /*    */
/*    */
        public abstract void onActivityResumed(Activity paramActivity);

        /*    */
/*    */
        public abstract void onActivityPaused(Activity paramActivity);

        /*    */
/*    */
        public abstract void onActivityStopped(Activity paramActivity);

        /*    */
/*    */
        public abstract void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle);

        /*    */
/*    */
        public abstract void onActivityDestroyed(Activity paramActivity);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/Application.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
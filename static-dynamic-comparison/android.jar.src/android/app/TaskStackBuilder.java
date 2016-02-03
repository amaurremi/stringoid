/*    */
package android.app;
/*    */

import android.content.Intent;

/*    */
/*  4 */ public class TaskStackBuilder {
    TaskStackBuilder() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static TaskStackBuilder create(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public TaskStackBuilder addNextIntent(Intent nextIntent) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public TaskStackBuilder addNextIntentWithParentStack(Intent nextIntent) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public TaskStackBuilder addParentStack(Activity sourceActivity) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public TaskStackBuilder addParentStack(Class<?> sourceActivityClass) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public TaskStackBuilder addParentStack(android.content.ComponentName sourceActivityName) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getIntentCount() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Intent editIntentAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void startActivities() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void startActivities(android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public PendingIntent getPendingIntent(int requestCode, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public PendingIntent getPendingIntent(int requestCode, int flags, android.os.Bundle options) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public Intent[] getIntents() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/TaskStackBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
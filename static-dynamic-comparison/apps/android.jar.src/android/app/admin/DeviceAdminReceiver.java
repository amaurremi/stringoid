/*    */
package android.app.admin;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public class DeviceAdminReceiver extends android.content.BroadcastReceiver {
    public DeviceAdminReceiver() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public DevicePolicyManager getManager(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public android.content.ComponentName getWho(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void onEnabled(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public CharSequence onDisableRequested(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onDisabled(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onPasswordChanged(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onPasswordFailed(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onPasswordSucceeded(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void onPasswordExpiring(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onReceive(Context context, android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String ACTION_DEVICE_ADMIN_ENABLED = "android.app.action.DEVICE_ADMIN_ENABLED";
    /*    */   public static final String ACTION_DEVICE_ADMIN_DISABLE_REQUESTED = "android.app.action.DEVICE_ADMIN_DISABLE_REQUESTED";
    /*    */   public static final String EXTRA_DISABLE_WARNING = "android.app.extra.DISABLE_WARNING";
    /*    */   public static final String ACTION_DEVICE_ADMIN_DISABLED = "android.app.action.DEVICE_ADMIN_DISABLED";
    /*    */   public static final String ACTION_PASSWORD_CHANGED = "android.app.action.ACTION_PASSWORD_CHANGED";
    /*    */   public static final String ACTION_PASSWORD_FAILED = "android.app.action.ACTION_PASSWORD_FAILED";
    /*    */   public static final String ACTION_PASSWORD_SUCCEEDED = "android.app.action.ACTION_PASSWORD_SUCCEEDED";
    /*    */   public static final String ACTION_PASSWORD_EXPIRING = "android.app.action.ACTION_PASSWORD_EXPIRING";
    /*    */   public static final String DEVICE_ADMIN_META_DATA = "android.app.device_admin";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/admin/DeviceAdminReceiver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
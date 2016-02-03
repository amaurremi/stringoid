/*    */
package android.app.admin;
/*    */

import android.content.ComponentName;

/*    */
/*  4 */ public class DevicePolicyManager {
    DevicePolicyManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public boolean isAdminActive(ComponentName who) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public java.util.List<ComponentName> getActiveAdmins() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void removeActiveAdmin(ComponentName who) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setPasswordQuality(ComponentName admin, int quality) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getPasswordQuality(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setPasswordMinimumLength(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getPasswordMinimumLength(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setPasswordMinimumUpperCase(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getPasswordMinimumUpperCase(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setPasswordMinimumLowerCase(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getPasswordMinimumLowerCase(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setPasswordMinimumLetters(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getPasswordMinimumLetters(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setPasswordMinimumNumeric(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getPasswordMinimumNumeric(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setPasswordMinimumSymbols(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getPasswordMinimumSymbols(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setPasswordMinimumNonLetter(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getPasswordMinimumNonLetter(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setPasswordHistoryLength(ComponentName admin, int length) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setPasswordExpirationTimeout(ComponentName admin, long timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public long getPasswordExpirationTimeout(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public long getPasswordExpiration(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getPasswordHistoryLength(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getPasswordMaximumLength(int quality) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean isActivePasswordSufficient() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int getCurrentFailedPasswordAttempts() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void setMaximumFailedPasswordsForWipe(ComponentName admin, int num) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean resetPassword(String password, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setMaximumTimeToLock(ComponentName admin, long timeMs) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public long getMaximumTimeToLock(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void lockNow() {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void wipeData(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean getStorageEncryption(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public int getStorageEncryptionStatus() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void setCameraDisabled(ComponentName admin, boolean disabled) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean getCameraDisabled(ComponentName admin) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String ACTION_ADD_DEVICE_ADMIN = "android.app.action.ADD_DEVICE_ADMIN";
    /*    */   public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    /*    */   public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    /*    */   public static final String ACTION_SET_NEW_PASSWORD = "android.app.action.SET_NEW_PASSWORD";
    /*    */   public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    /*    */   public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 32768;
    /*    */   public static final int PASSWORD_QUALITY_SOMETHING = 65536;
    /*    */   public static final int PASSWORD_QUALITY_NUMERIC = 131072;
    /*    */   public static final int PASSWORD_QUALITY_ALPHABETIC = 262144;
    /*    */   public static final int PASSWORD_QUALITY_ALPHANUMERIC = 327680;
    /*    */   public static final int PASSWORD_QUALITY_COMPLEX = 393216;
    /*    */   public static final int RESET_PASSWORD_REQUIRE_ENTRY = 1;
    /*    */   public static final int WIPE_EXTERNAL_STORAGE = 1;
    /*    */   public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    /*    */   public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    /*    */   public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    /*    */   public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    /*    */   public static final String ACTION_START_ENCRYPTION = "android.app.action.START_ENCRYPTION";
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/admin/DevicePolicyManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
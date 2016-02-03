/*    */
package android.preference;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.content.SharedPreferences;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PreferenceManager
/*    */ {
    /*    */   public static final String METADATA_KEY_PREFERENCES = "android.preference";
    /*    */   public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";

    /*    */
/* 16 */   PreferenceManager() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public PreferenceScreen createPreferenceScreen(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public String getSharedPreferencesName() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setSharedPreferencesName(String sharedPreferencesName) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getSharedPreferencesMode() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setSharedPreferencesMode(int sharedPreferencesMode) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public SharedPreferences getSharedPreferences() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public Preference findPreference(CharSequence key) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static void setDefaultValues(Context context, int resId, boolean readAgain) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public static void setDefaultValues(Context context, String sharedPreferencesName, int sharedPreferencesMode, int resId, boolean readAgain) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnActivityDestroyListener
/*    */ {
        /*    */
        public abstract void onActivityDestroy();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnActivityStopListener
/*    */ {
        /*    */
        public abstract void onActivityStop();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnActivityResultListener
/*    */ {
        /*    */
        public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/PreferenceManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
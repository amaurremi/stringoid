/*    */
package android.preference;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*    */ 
/*    */ public abstract class PreferenceFragment
/*    */ extends android.app.Fragment
/*    */ {
    /*  9 */
    public PreferenceFragment() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onCreate(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onActivityCreated(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onDestroyView() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void onSaveInstanceState(Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public PreferenceManager getPreferenceManager() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public PreferenceScreen getPreferenceScreen() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void addPreferencesFromIntent(android.content.Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void addPreferencesFromResource(int preferencesResId) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public Preference findPreference(CharSequence key) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnPreferenceStartFragmentCallback
/*    */ {
        /*    */
        public abstract boolean onPreferenceStartFragment(PreferenceFragment paramPreferenceFragment, Preference paramPreference);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/PreferenceFragment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
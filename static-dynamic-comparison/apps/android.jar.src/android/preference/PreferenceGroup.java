/*    */
package android.preference;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public abstract class PreferenceGroup extends Preference {
    public PreferenceGroup(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public PreferenceGroup(Context context, android.util.AttributeSet attrs) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setOrderingAsAdded(boolean orderingAsAdded) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public boolean isOrderingAsAdded() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void addItemFromInflater(Preference preference) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getPreferenceCount() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public Preference getPreference(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean addPreference(Preference preference) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean removePreference(Preference preference) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void removeAll() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected boolean onPrepareAddPreference(Preference preference) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public Preference findPreference(CharSequence key) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected boolean isOnSameScreenAsChildren() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected void onAttachedToActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected void onPrepareForRemoval() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void dispatchSaveInstanceState(android.os.Bundle container) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected void dispatchRestoreInstanceState(android.os.Bundle container) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/PreferenceGroup.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */
package android.preference;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class RingtonePreference extends Preference implements PreferenceManager.OnActivityResultListener {
    /*  6 */
    public RingtonePreference(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public RingtonePreference(Context context, android.util.AttributeSet attrs) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public RingtonePreference(Context context) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getRingtoneType() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setRingtoneType(int type) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean getShowDefault() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setShowDefault(boolean showDefault) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean getShowSilent() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setShowSilent(boolean showSilent) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected void onClick() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void onPrepareRingtonePickerIntent(android.content.Intent ringtonePickerIntent) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected void onSaveRingtone(android.net.Uri ringtoneUri) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected android.net.Uri onRestoreRingtone() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected Object onGetDefaultValue(android.content.res.TypedArray a, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValueObj) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/RingtonePreference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
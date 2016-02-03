/*    */
package android.preference;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public abstract class TwoStatePreference extends Preference {
    public TwoStatePreference(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public TwoStatePreference(Context context, android.util.AttributeSet attrs) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public TwoStatePreference(Context context) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected void onClick() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setChecked(boolean checked) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isChecked() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean shouldDisableDependents() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setSummaryOn(CharSequence summary) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setSummaryOn(int summaryResId) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public CharSequence getSummaryOn() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setSummaryOff(CharSequence summary) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setSummaryOff(int summaryResId) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public CharSequence getSummaryOff() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean getDisableDependentsState() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setDisableDependentsState(boolean disableDependentsState) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected Object onGetDefaultValue(android.content.res.TypedArray a, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/TwoStatePreference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
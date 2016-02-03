/*    */
package android.preference;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public class ListPreference extends DialogPreference {
    public ListPreference(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ListPreference(Context context) {
        super((Context) null, (android.util.AttributeSet) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setEntries(CharSequence[] entries) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setEntries(int entriesResId) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public CharSequence[] getEntries() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void setEntryValues(CharSequence[] entryValues) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setEntryValues(int entryValuesResId) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public CharSequence[] getEntryValues() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void setValue(String value) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public CharSequence getSummary() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setSummary(CharSequence summary) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setValueIndex(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public String getValue() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public CharSequence getEntry() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int findIndexOfValue(String value) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void onDialogClosed(boolean positiveResult) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    protected Object onGetDefaultValue(android.content.res.TypedArray a, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/ListPreference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
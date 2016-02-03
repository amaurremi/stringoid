/*    */
package android.preference;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public class MultiSelectListPreference extends DialogPreference {
    public MultiSelectListPreference(Context context, android.util.AttributeSet attrs) {
        super((Context) null, (android.util.AttributeSet) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public MultiSelectListPreference(Context context) {
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
    public void setValues(java.util.Set<String> values) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public java.util.Set<String> getValues() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int findIndexOfValue(String value) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected void onDialogClosed(boolean positiveResult) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected Object onGetDefaultValue(android.content.res.TypedArray a, int index) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/MultiSelectListPreference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
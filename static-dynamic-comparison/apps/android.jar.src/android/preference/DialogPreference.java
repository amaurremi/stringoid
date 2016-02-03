/*    */
package android.preference;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public abstract class DialogPreference extends Preference implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, PreferenceManager.OnActivityDestroyListener {
    /*  6 */
    public DialogPreference(Context context, android.util.AttributeSet attrs, int defStyle) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public DialogPreference(Context context, android.util.AttributeSet attrs) {
        super((Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void setDialogTitle(CharSequence dialogTitle) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void setDialogTitle(int dialogTitleResId) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public CharSequence getDialogTitle() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void setDialogMessage(CharSequence dialogMessage) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void setDialogMessage(int dialogMessageResId) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public CharSequence getDialogMessage() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setDialogIcon(android.graphics.drawable.Drawable dialogIcon) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setDialogIcon(int dialogIconRes) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.graphics.drawable.Drawable getDialogIcon() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setPositiveButtonText(CharSequence positiveButtonText) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setPositiveButtonText(int positiveButtonTextResId) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public CharSequence getPositiveButtonText() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setNegativeButtonText(CharSequence negativeButtonText) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setNegativeButtonText(int negativeButtonTextResId) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public CharSequence getNegativeButtonText() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setDialogLayoutResource(int dialogLayoutResId) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getDialogLayoutResource() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    protected void onClick() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    protected void showDialog(android.os.Bundle state) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    protected android.view.View onCreateDialogView() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected void onBindDialogView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void onClick(android.content.DialogInterface dialog, int which) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void onDismiss(android.content.DialogInterface dialog) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    protected void onDialogClosed(boolean positiveResult) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public android.app.Dialog getDialog() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void onActivityDestroy() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    protected android.os.Parcelable onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    protected void onRestoreInstanceState(android.os.Parcelable state) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/preference/DialogPreference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
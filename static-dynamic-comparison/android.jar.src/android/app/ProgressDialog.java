/*    */
package android.app;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*  5 */ public class ProgressDialog extends AlertDialog {
    public ProgressDialog(Context context) {
        super((Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public ProgressDialog(Context context, int theme) {
        super((Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static ProgressDialog show(Context context, CharSequence title, CharSequence message) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static ProgressDialog show(Context context, CharSequence title, CharSequence message, boolean indeterminate) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static ProgressDialog show(Context context, CharSequence title, CharSequence message, boolean indeterminate, boolean cancelable) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static ProgressDialog show(Context context, CharSequence title, CharSequence message, boolean indeterminate, boolean cancelable, android.content.DialogInterface.OnCancelListener cancelListener) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    protected void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setProgress(int value) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setSecondaryProgress(int secondaryProgress) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getProgress() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getSecondaryProgress() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getMax() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setMax(int max) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void incrementProgressBy(int diff) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void incrementSecondaryProgressBy(int diff) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setProgressDrawable(android.graphics.drawable.Drawable d) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void setIndeterminateDrawable(android.graphics.drawable.Drawable d) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setIndeterminate(boolean indeterminate) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isIndeterminate() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setMessage(CharSequence message) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setProgressStyle(int style) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setProgressNumberFormat(String format) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setProgressPercentFormat(java.text.NumberFormat format) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int STYLE_SPINNER = 0;
    /*    */   public static final int STYLE_HORIZONTAL = 1;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/ProgressDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */
package android.app;
/*    */ 
/*    */

import android.os.Bundle;

/*    */
/*    */ public class DialogFragment extends Fragment implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener {
    /*  6 */
    public DialogFragment() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setStyle(int style, int theme) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void show(FragmentManager manager, String tag) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int show(FragmentTransaction transaction, String tag) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void dismiss() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void dismissAllowingStateLoss() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Dialog getDialog() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getTheme() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setCancelable(boolean cancelable) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean isCancelable() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setShowsDialog(boolean showsDialog) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean getShowsDialog() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void onAttach(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void onDetach() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void onCreate(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void onCancel(android.content.DialogInterface dialog) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void onDismiss(android.content.DialogInterface dialog) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void onActivityCreated(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void onSaveInstanceState(Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void onDestroyView() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void dump(String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int STYLE_NORMAL = 0;
    /*    */   public static final int STYLE_NO_TITLE = 1;
    /*    */   public static final int STYLE_NO_FRAME = 2;
    /*    */   public static final int STYLE_NO_INPUT = 3;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/DialogFragment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
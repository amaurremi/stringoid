/*    */
package android.view.inputmethod;
/*    */

import android.view.View;

/*    */
/*  4 */ public final class InputMethodManager {
    InputMethodManager() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public java.util.List<InputMethodInfo> getInputMethodList() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public java.util.List<InputMethodInfo> getEnabledInputMethodList() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public java.util.List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi, boolean allowsImplicitlySelectedSubtypes) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void showStatusIcon(android.os.IBinder imeToken, String packageName, int iconId) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void hideStatusIcon(android.os.IBinder imeToken) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean isFullscreenMode() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean isActive(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean isActive() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean isAcceptingText() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void displayCompletions(View view, CompletionInfo[] completions) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void updateExtractedText(View view, int token, ExtractedText text) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean showSoftInput(View view, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean showSoftInput(View view, int flags, android.os.ResultReceiver resultReceiver) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean hideSoftInputFromWindow(android.os.IBinder windowToken, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean hideSoftInputFromWindow(android.os.IBinder windowToken, int flags, android.os.ResultReceiver resultReceiver) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void toggleSoftInputFromWindow(android.os.IBinder windowToken, int showFlags, int hideFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void toggleSoftInput(int showFlags, int hideFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void restartInput(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void updateSelection(View view, int selStart, int selEnd, int candidatesStart, int candidatesEnd) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void viewClicked(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isWatchingCursor(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void updateCursor(View view, int left, int top, int right, int bottom) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void sendAppPrivateCommand(View view, String action, android.os.Bundle data) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setInputMethod(android.os.IBinder token, String id) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setInputMethodAndSubtype(android.os.IBinder token, String id, InputMethodSubtype subtype) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void hideSoftInputFromInputMethod(android.os.IBinder token, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void showSoftInputFromInputMethod(android.os.IBinder token, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void showInputMethodPicker() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void showInputMethodAndSubtypeEnabler(String imiId) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public InputMethodSubtype getCurrentInputMethodSubtype() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean setCurrentInputMethodSubtype(InputMethodSubtype subtype) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public java.util.Map<InputMethodInfo, java.util.List<InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean switchToLastInputMethod(android.os.IBinder imeToken) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean switchToNextInputMethod(android.os.IBinder imeToken, boolean onlyCurrentIme) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public InputMethodSubtype getLastInputMethodSubtype() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int SHOW_IMPLICIT = 1;
    /*    */   public static final int SHOW_FORCED = 2;
    /*    */   public static final int RESULT_UNCHANGED_SHOWN = 0;
    /*    */   public static final int RESULT_UNCHANGED_HIDDEN = 1;
    /*    */   public static final int RESULT_SHOWN = 2;
    /*    */   public static final int RESULT_HIDDEN = 3;
    /*    */   public static final int HIDE_IMPLICIT_ONLY = 1;
    /*    */   public static final int HIDE_NOT_ALWAYS = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/InputMethodManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
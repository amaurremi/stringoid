/*    */
package android.view.inputmethod;
/*    */ 
/*    */

import android.text.Spannable;

/*    */
/*  5 */ public class BaseInputConnection implements InputConnection {
    public BaseInputConnection(android.view.View targetView, boolean fullEditor) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static final void removeComposingSpans(Spannable text) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static void setComposingSpans(Spannable text) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static int getComposingSpanStart(Spannable text) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static int getComposingSpanEnd(Spannable text) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public android.text.Editable getEditable() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public boolean beginBatchEdit() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean endBatchEdit() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean clearMetaKeyStates(int states) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean commitCompletion(CompletionInfo text) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean commitText(CharSequence text, int newCursorPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean finishComposingText() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getCursorCapsMode(int reqModes) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public CharSequence getTextBeforeCursor(int length, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public CharSequence getSelectedText(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public CharSequence getTextAfterCursor(int length, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public boolean performEditorAction(int actionCode) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean performContextMenuAction(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean performPrivateCommand(String action, android.os.Bundle data) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public boolean setComposingRegion(int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public boolean setSelection(int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean sendKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean reportFullscreenMode(boolean enabled) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/BaseInputConnection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
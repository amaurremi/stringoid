package android.view.inputmethod;

import android.os.Bundle;
import android.view.KeyEvent;

public abstract interface InputConnection {
    public static final int GET_TEXT_WITH_STYLES = 1;
    public static final int GET_EXTRACTED_TEXT_MONITOR = 1;

    public abstract CharSequence getTextBeforeCursor(int paramInt1, int paramInt2);

    public abstract CharSequence getTextAfterCursor(int paramInt1, int paramInt2);

    public abstract CharSequence getSelectedText(int paramInt);

    public abstract int getCursorCapsMode(int paramInt);

    public abstract ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt);

    public abstract boolean deleteSurroundingText(int paramInt1, int paramInt2);

    public abstract boolean setComposingText(CharSequence paramCharSequence, int paramInt);

    public abstract boolean setComposingRegion(int paramInt1, int paramInt2);

    public abstract boolean finishComposingText();

    public abstract boolean commitText(CharSequence paramCharSequence, int paramInt);

    public abstract boolean commitCompletion(CompletionInfo paramCompletionInfo);

    public abstract boolean commitCorrection(CorrectionInfo paramCorrectionInfo);

    public abstract boolean setSelection(int paramInt1, int paramInt2);

    public abstract boolean performEditorAction(int paramInt);

    public abstract boolean performContextMenuAction(int paramInt);

    public abstract boolean beginBatchEdit();

    public abstract boolean endBatchEdit();

    public abstract boolean sendKeyEvent(KeyEvent paramKeyEvent);

    public abstract boolean clearMetaKeyStates(int paramInt);

    public abstract boolean reportFullscreenMode(boolean paramBoolean);

    public abstract boolean performPrivateCommand(String paramString, Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/inputmethod/InputConnection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
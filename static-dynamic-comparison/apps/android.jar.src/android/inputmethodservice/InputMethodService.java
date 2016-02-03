/*     */
package android.inputmethodservice;
/*     */ 
/*     */

import android.view.inputmethod.EditorInfo;

/*     */
/*     */ public class InputMethodService extends AbstractInputMethodService {
    /*     */   public static final int BACK_DISPOSITION_DEFAULT = 0;

    /*     */
/*   8 */   public class InputMethodImpl extends AbstractInputMethodService.AbstractInputMethodImpl {
        public InputMethodImpl() {
            super();
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public void attachToken(android.os.IBinder token) {
            throw new RuntimeException("Stub!");
        }

        /*  10 */
        public void bindInput(android.view.inputmethod.InputBinding binding) {
            throw new RuntimeException("Stub!");
        }

        /*  11 */
        public void unbindInput() {
            throw new RuntimeException("Stub!");
        }

        /*  12 */
        public void startInput(android.view.inputmethod.InputConnection ic, EditorInfo attribute) {
            throw new RuntimeException("Stub!");
        }

        /*  13 */
        public void restartInput(android.view.inputmethod.InputConnection ic, EditorInfo attribute) {
            throw new RuntimeException("Stub!");
        }

        /*  14 */
        public void hideSoftInput(int flags, android.os.ResultReceiver resultReceiver) {
            throw new RuntimeException("Stub!");
        }

        /*  15 */
        public void showSoftInput(int flags, android.os.ResultReceiver resultReceiver) {
            throw new RuntimeException("Stub!");
        }

        /*  16 */
        public void changeInputMethodSubtype(android.view.inputmethod.InputMethodSubtype subtype) {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
    /*     */   public static final int BACK_DISPOSITION_WILL_DISMISS = 2;

    /*  21 */   public class InputMethodSessionImpl extends AbstractInputMethodService.AbstractInputMethodSessionImpl {
        public InputMethodSessionImpl() {
            super();
            throw new RuntimeException("Stub!");
        }

        /*  22 */
        public void finishInput() {
            throw new RuntimeException("Stub!");
        }

        /*  23 */
        public void displayCompletions(android.view.inputmethod.CompletionInfo[] completions) {
            throw new RuntimeException("Stub!");
        }

        /*  24 */
        public void updateExtractedText(int token, android.view.inputmethod.ExtractedText text) {
            throw new RuntimeException("Stub!");
        }

        /*  25 */
        public void updateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) {
            throw new RuntimeException("Stub!");
        }

        /*  26 */
        public void viewClicked(boolean focusChanged) {
            throw new RuntimeException("Stub!");
        }

        /*  27 */
        public void updateCursor(android.graphics.Rect newCursor) {
            throw new RuntimeException("Stub!");
        }

        /*  28 */
        public void appPrivateCommand(String action, android.os.Bundle data) {
            throw new RuntimeException("Stub!");
        }

        /*  29 */
        public void toggleSoftInput(int showFlags, int hideFlags) {
            throw new RuntimeException("Stub!");
        }
    }

    /*     */
/*     */   public static final class Insets {
        public int contentTopInsets;

        /*     */
/*  33 */
        public Insets() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public int visibleTopInsets;
        /*     */     public final android.graphics.Region touchableRegion;
        /*     */     public static final int TOUCHABLE_INSETS_FRAME = 0;
        /*     */     public static final int TOUCHABLE_INSETS_CONTENT = 1;
        /*     */     public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        /*     */     public static final int TOUCHABLE_INSETS_REGION = 3;
        /*     */     public int touchableInsets;
    }

    /*     */
/*  43 */
    public InputMethodService() {
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public void setTheme(int theme) {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public void onInitializeInterface() {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public AbstractInputMethodService.AbstractInputMethodImpl onCreateInputMethodInterface() {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public AbstractInputMethodService.AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public android.view.LayoutInflater getLayoutInflater() {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public android.app.Dialog getWindow() {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public void setBackDisposition(int disposition) {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public int getBackDisposition() {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public int getMaxWidth() {
        throw new RuntimeException("Stub!");
    }

    /*  56 */
    public android.view.inputmethod.InputBinding getCurrentInputBinding() {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public android.view.inputmethod.InputConnection getCurrentInputConnection() {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public boolean getCurrentInputStarted() {
        throw new RuntimeException("Stub!");
    }

    /*  59 */
    public EditorInfo getCurrentInputEditorInfo() {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public void updateFullscreenMode() {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public void onConfigureWindow(android.view.Window win, boolean isFullscreen, boolean isCandidatesOnly) {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public boolean isFullscreenMode() {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public boolean onEvaluateFullscreenMode() {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public void setExtractViewShown(boolean shown) {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public boolean isExtractViewShown() {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public void onComputeInsets(Insets outInsets) {
        throw new RuntimeException("Stub!");
    }

    /*  67 */
    public void updateInputViewShown() {
        throw new RuntimeException("Stub!");
    }

    /*  68 */
    public boolean isShowInputRequested() {
        throw new RuntimeException("Stub!");
    }

    /*  69 */
    public boolean isInputViewShown() {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public boolean onEvaluateInputViewShown() {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public void setCandidatesViewShown(boolean shown) {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public int getCandidatesHiddenVisibility() {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public void showStatusIcon(int iconResId) {
        throw new RuntimeException("Stub!");
    }

    /*  74 */
    public void hideStatusIcon() {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public void switchInputMethod(String id) {
        throw new RuntimeException("Stub!");
    }

    /*  76 */
    public void setExtractView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /*  77 */
    public void setCandidatesView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /*  78 */
    public void setInputView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /*  79 */
    public android.view.View onCreateExtractTextView() {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public android.view.View onCreateCandidatesView() {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public android.view.View onCreateInputView() {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public void onStartInputView(EditorInfo info, boolean restarting) {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    public void onFinishInputView(boolean finishingInput) {
        throw new RuntimeException("Stub!");
    }

    /*  84 */
    public void onStartCandidatesView(EditorInfo info, boolean restarting) {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public void onFinishCandidatesView(boolean finishingInput) {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public boolean onShowInputRequested(int flags, boolean configChange) {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public void showWindow(boolean showInput) {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public void hideWindow() {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public void onWindowShown() {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public void onWindowHidden() {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public void onBindInput() {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public void onUnbindInput() {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public void onFinishInput() {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public void onDisplayCompletions(android.view.inputmethod.CompletionInfo[] completions) {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public void onUpdateExtractedText(int token, android.view.inputmethod.ExtractedText text) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public void onUpdateSelection(int oldSelStart, int oldSelEnd, int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public void onViewClicked(boolean focusChanged) {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public void onUpdateCursor(android.graphics.Rect newCursor) {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public void requestHideSelf(int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    public boolean onKeyMultiple(int keyCode, int count, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public boolean onTrackballEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public void onAppPrivateCommand(String action, android.os.Bundle data) {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public void sendDownUpKeyEvents(int keyEventCode) {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public boolean sendDefaultEditorAction(boolean fromEnterKey) {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public void sendKeyChar(char charCode) {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public void onExtractedSelectionChanged(int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    public void onExtractedTextClicked() {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    public void onExtractedCursorMovement(int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public boolean onExtractTextContextMenuItem(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public CharSequence getTextForImeAction(int imeOptions) {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    public void onUpdateExtractingVisibility(EditorInfo ei) {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    public void onUpdateExtractingViews(EditorInfo ei) {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public void onExtractingInputChanged(EditorInfo ei) {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    protected void onCurrentInputMethodSubtypeChanged(android.view.inputmethod.InputMethodSubtype newSubtype) {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    protected void dump(java.io.FileDescriptor fd, java.io.PrintWriter fout, String[] args) {
        throw new RuntimeException("Stub!");
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/inputmethodservice/InputMethodService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
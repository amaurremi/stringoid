/*     */
package android.view;
/*     */ 
/*     */

import android.graphics.drawable.Drawable;

/*     */
/*     */ public abstract class Window {
    /*     */   public static final int FEATURE_OPTIONS_PANEL = 0;
    /*     */   public static final int FEATURE_NO_TITLE = 1;
    /*     */   public static final int FEATURE_PROGRESS = 2;
    /*     */   public static final int FEATURE_LEFT_ICON = 3;
    /*     */   public static final int FEATURE_RIGHT_ICON = 4;
    /*     */   public static final int FEATURE_INDETERMINATE_PROGRESS = 5;
    /*     */   public static final int FEATURE_CONTEXT_MENU = 6;
    /*     */   public static final int FEATURE_CUSTOM_TITLE = 7;
    /*     */   public static final int FEATURE_ACTION_BAR = 8;
    /*     */   public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    /*     */   public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    /*     */   public static final int PROGRESS_VISIBILITY_ON = -1;
    /*     */   public static final int PROGRESS_VISIBILITY_OFF = -2;
    /*     */   public static final int PROGRESS_INDETERMINATE_ON = -3;
    /*     */   public static final int PROGRESS_INDETERMINATE_OFF = -4;
    /*     */   public static final int PROGRESS_START = 0;
    /*     */   public static final int PROGRESS_END = 10000;
    /*     */   public static final int PROGRESS_SECONDARY_START = 20000;
    /*     */   public static final int PROGRESS_SECONDARY_END = 30000;
    /*     */   protected static final int DEFAULT_FEATURES = 65;
    /*     */   public static final int ID_ANDROID_CONTENT = 16908290;

    /*     */
/*  28 */
    public Window(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  29 */
    public final android.content.Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /*  30 */
    public final android.content.res.TypedArray getWindowStyle() {
        throw new RuntimeException("Stub!");
    }

    /*  31 */
    public void setContainer(Window container) {
        throw new RuntimeException("Stub!");
    }

    /*  32 */
    public final Window getContainer() {
        throw new RuntimeException("Stub!");
    }

    /*  33 */
    public final boolean hasChildren() {
        throw new RuntimeException("Stub!");
    }

    /*  34 */
    public void setWindowManager(WindowManager wm, android.os.IBinder appToken, String appName) {
        throw new RuntimeException("Stub!");
    }

    /*  35 */
    public void setWindowManager(WindowManager wm, android.os.IBinder appToken, String appName, boolean hardwareAccelerated) {
        throw new RuntimeException("Stub!");
    }

    /*  36 */
    public WindowManager getWindowManager() {
        throw new RuntimeException("Stub!");
    }

    /*  37 */
    public void setCallback(Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /*  38 */
    public final Callback getCallback() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public abstract void takeSurface(SurfaceHolder.Callback2 paramCallback2);

    /*     */
    public abstract void takeInputQueue(InputQueue.Callback paramCallback);

    /*     */
    public abstract boolean isFloating();

    /*  42 */
    public void setLayout(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    /*  43 */
    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public void setType(int type) {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public void setFormat(int format) {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public void setWindowAnimations(int resId) {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public void setSoftInputMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public void addFlags(int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public void clearFlags(int flags) {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public void setFlags(int flags, int mask) {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public void setDimAmount(float amount) {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public void setAttributes(WindowManager.LayoutParams a) {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public final WindowManager.LayoutParams getAttributes() {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    protected final int getForcedWindowFlags() {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    protected final boolean hasSoftInputMode() {
        throw new RuntimeException("Stub!");
    }

    /*  56 */
    public boolean requestFeature(int featureId) {
        throw new RuntimeException("Stub!");
    }

    /*  57 */
    public final void makeActive() {
        throw new RuntimeException("Stub!");
    }

    /*  58 */
    public final boolean isActive() {
        throw new RuntimeException("Stub!");
    }

    /*  59 */
    public View findViewById(int id) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public abstract void setContentView(int paramInt);

    /*     */
    public abstract void setContentView(View paramView);

    /*     */
    public abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);

    /*     */
    public abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);

    /*     */
    public abstract View getCurrentFocus();

    /*     */
    public abstract LayoutInflater getLayoutInflater();

    /*     */
    public abstract void setTitle(CharSequence paramCharSequence);

    /*     */
    public abstract void setTitleColor(int paramInt);

    /*     */
    public abstract void openPanel(int paramInt, KeyEvent paramKeyEvent);

    /*     */
    public abstract void closePanel(int paramInt);

    /*     */
    public abstract void togglePanel(int paramInt, KeyEvent paramKeyEvent);

    /*     */
    public abstract void invalidatePanelMenu(int paramInt);

    /*     */
    public abstract boolean performPanelShortcut(int paramInt1, int paramInt2, KeyEvent paramKeyEvent, int paramInt3);

    /*     */
    public abstract boolean performPanelIdentifierAction(int paramInt1, int paramInt2, int paramInt3);

    /*     */
    public abstract void closeAllPanels();

    /*     */
    public abstract boolean performContextMenuIdentifierAction(int paramInt1, int paramInt2);

    /*     */
    public abstract void onConfigurationChanged(android.content.res.Configuration paramConfiguration);

    /*  77 */
    public void setBackgroundDrawableResource(int resid) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public abstract void setBackgroundDrawable(Drawable paramDrawable);

    /*     */
    public abstract void setFeatureDrawableResource(int paramInt1, int paramInt2);

    /*     */
    public abstract void setFeatureDrawableUri(int paramInt, android.net.Uri paramUri);

    /*     */
    public abstract void setFeatureDrawable(int paramInt, Drawable paramDrawable);

    /*     */
    public abstract void setFeatureDrawableAlpha(int paramInt1, int paramInt2);

    /*     */
    public abstract void setFeatureInt(int paramInt1, int paramInt2);

    /*     */
    public abstract void takeKeyEvents(boolean paramBoolean);

    /*     */
    public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);

    /*     */
    public abstract boolean superDispatchKeyShortcutEvent(KeyEvent paramKeyEvent);

    /*     */
    public abstract boolean superDispatchTouchEvent(MotionEvent paramMotionEvent);

    /*     */
    public abstract boolean superDispatchTrackballEvent(MotionEvent paramMotionEvent);

    /*     */
    public abstract boolean superDispatchGenericMotionEvent(MotionEvent paramMotionEvent);

    /*     */
    public abstract View getDecorView();

    /*     */
    public abstract View peekDecorView();

    /*     */
    public abstract android.os.Bundle saveHierarchyState();

    /*     */
    public abstract void restoreHierarchyState(android.os.Bundle paramBundle);

    /*     */
    protected abstract void onActive();

    /*  95 */
    protected final int getFeatures() {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public boolean hasFeature(int feature) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    protected final int getLocalFeatures() {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    protected void setDefaultWindowFormat(int format) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public abstract void setChildDrawable(int paramInt, Drawable paramDrawable);

    /*     */
    public abstract void setChildInt(int paramInt1, int paramInt2);

    /*     */
    public abstract boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent);

    /*     */
    public abstract void setVolumeControlStream(int paramInt);

    /*     */
    public abstract int getVolumeControlStream();

    /* 104 */
    public void setUiOptions(int uiOptions) {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public void setUiOptions(int uiOptions, int mask) {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */   public static abstract interface Callback
/*     */ {
        /*     */
        public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);

        /*     */
/*     */
        public abstract boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent);

        /*     */
/*     */
        public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent);

        /*     */
/*     */
        public abstract boolean dispatchTrackballEvent(MotionEvent paramMotionEvent);

        /*     */
/*     */
        public abstract boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent);

        /*     */
/*     */
        public abstract boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent paramAccessibilityEvent);

        /*     */
/*     */
        public abstract View onCreatePanelView(int paramInt);

        /*     */
/*     */
        public abstract boolean onCreatePanelMenu(int paramInt, Menu paramMenu);

        /*     */
/*     */
        public abstract boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu);

        /*     */
/*     */
        public abstract boolean onMenuOpened(int paramInt, Menu paramMenu);

        /*     */
/*     */
        public abstract boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem);

        /*     */
/*     */
        public abstract void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams);

        /*     */
/*     */
        public abstract void onContentChanged();

        /*     */
/*     */
        public abstract void onWindowFocusChanged(boolean paramBoolean);

        /*     */
/*     */
        public abstract void onAttachedToWindow();

        /*     */
/*     */
        public abstract void onDetachedFromWindow();

        /*     */
/*     */
        public abstract void onPanelClosed(int paramInt, Menu paramMenu);

        /*     */
/*     */
        public abstract boolean onSearchRequested();

        /*     */
/*     */
        public abstract ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback);

        /*     */
/*     */
        public abstract void onActionModeStarted(ActionMode paramActionMode);

        /*     */
/*     */
        public abstract void onActionModeFinished(ActionMode paramActionMode);
/*     */
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/Window.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
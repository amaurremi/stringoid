/*    */
package android.app;
/*    */ 
/*    */

import android.view.View;

/*    */
/*  5 */ public class Dialog implements android.content.DialogInterface, android.view.Window.Callback, android.view.KeyEvent.Callback, android.view.View.OnCreateContextMenuListener {
    public Dialog(android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public Dialog(android.content.Context context, int theme) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected Dialog(android.content.Context context, boolean cancelable, android.content.DialogInterface.OnCancelListener cancelListener) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public final android.content.Context getContext() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public ActionBar getActionBar() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final void setOwnerActivity(Activity activity) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final Activity getOwnerActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean isShowing() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void show() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void hide() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void dismiss() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected void onStart() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    protected void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public android.os.Bundle onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void onRestoreInstanceState(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public android.view.Window getWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public View getCurrentFocus() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public View findViewById(int id) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setContentView(int layoutResID) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void setContentView(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setContentView(View view, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void addContentView(View view, android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setTitle(CharSequence title) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setTitle(int titleId) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void onBackPressed() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public boolean onKeyShortcut(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public boolean onTouchEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public boolean onTrackballEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public boolean onGenericMotionEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void onContentChanged() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void onWindowFocusChanged(boolean hasFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public boolean dispatchTouchEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public boolean dispatchTrackballEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent ev) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public View onCreatePanelView(int featureId) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public boolean onCreatePanelMenu(int featureId, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public boolean onPreparePanel(int featureId, View view, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public boolean onMenuOpened(int featureId, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public boolean onMenuItemSelected(int featureId, android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void onPanelClosed(int featureId, android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public void onOptionsMenuClosed(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public void openOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void closeOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void invalidateOptionsMenu() {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void registerForContextMenu(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void unregisterForContextMenu(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public void openContextMenu(View view) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public boolean onContextItemSelected(android.view.MenuItem item) {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public void onContextMenuClosed(android.view.Menu menu) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public boolean onSearchRequested() {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public void onActionModeStarted(android.view.ActionMode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    public void onActionModeFinished(android.view.ActionMode mode) {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    public void takeKeyEvents(boolean get) {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    public final boolean requestWindowFeature(int featureId) {
        throw new RuntimeException("Stub!");
    }

    /* 75 */
    public final void setFeatureDrawableResource(int featureId, int resId) {
        throw new RuntimeException("Stub!");
    }

    /* 76 */
    public final void setFeatureDrawableUri(int featureId, android.net.Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 77 */
    public final void setFeatureDrawable(int featureId, android.graphics.drawable.Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    /* 78 */
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        throw new RuntimeException("Stub!");
    }

    /* 79 */
    public android.view.LayoutInflater getLayoutInflater() {
        throw new RuntimeException("Stub!");
    }

    /* 80 */
    public void setCancelable(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 81 */
    public void setCanceledOnTouchOutside(boolean cancel) {
        throw new RuntimeException("Stub!");
    }

    /* 82 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 83 */
    public void setOnCancelListener(android.content.DialogInterface.OnCancelListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 84 */
    public void setCancelMessage(android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }

    /* 85 */
    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 86 */
    public void setOnShowListener(android.content.DialogInterface.OnShowListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 87 */
    public void setDismissMessage(android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }

    /* 88 */
    public final void setVolumeControlStream(int streamType) {
        throw new RuntimeException("Stub!");
    }

    /* 89 */
    public final int getVolumeControlStream() {
        throw new RuntimeException("Stub!");
    }

    /* 90 */
    public void setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/Dialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
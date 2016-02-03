package android.support.v7.a;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

class p
        implements Window.Callback {
    final Window.Callback b;

    public p(o paramo, Window.Callback paramCallback) {
        this.b = paramCallback;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent) {
        return this.b.dispatchGenericMotionEvent(paramMotionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
        return this.b.dispatchKeyEvent(paramKeyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent) {
        return this.b.dispatchKeyShortcutEvent(paramKeyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        return this.b.dispatchTouchEvent(paramMotionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent) {
        return this.b.dispatchTrackballEvent(paramMotionEvent);
    }

    public void onActionModeFinished(ActionMode paramActionMode) {
        this.b.onActionModeFinished(paramActionMode);
        this.c.b(paramActionMode);
    }

    public void onActionModeStarted(ActionMode paramActionMode) {
        this.b.onActionModeStarted(paramActionMode);
        this.c.a(paramActionMode);
    }

    public void onAttachedToWindow() {
        this.b.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.b.onContentChanged();
    }

    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
        return this.b.onCreatePanelMenu(paramInt, paramMenu);
    }

    public View onCreatePanelView(int paramInt) {
        return this.b.onCreatePanelView(paramInt);
    }

    public void onDetachedFromWindow() {
        this.b.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        return this.b.onMenuItemSelected(paramInt, paramMenuItem);
    }

    public boolean onMenuOpened(int paramInt, Menu paramMenu) {
        return this.b.onMenuOpened(paramInt, paramMenu);
    }

    public void onPanelClosed(int paramInt, Menu paramMenu) {
        this.b.onPanelClosed(paramInt, paramMenu);
    }

    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
        return this.b.onPreparePanel(paramInt, paramView, paramMenu);
    }

    public boolean onSearchRequested() {
        return this.b.onSearchRequested();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams) {
        this.b.onWindowAttributesChanged(paramLayoutParams);
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        this.b.onWindowFocusChanged(paramBoolean);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback) {
        return this.b.onWindowStartingActionMode(paramCallback);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
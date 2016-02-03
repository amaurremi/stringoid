package android.support.v7.app;

import android.support.v7.appcompat.R.id;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class ActionBarImplHC
        extends ActionBarImplBase
        implements NativeActionModeAwareLayout.OnActionModeForChildListener {
    private ActionMode mCurActionMode;
    final NativeActionModeAwareLayout mNativeActionModeAwareLayout;

    public ActionBarImplHC(ActionBarActivity paramActionBarActivity, ActionBar.Callback paramCallback) {
        super(paramActionBarActivity, paramCallback);
        this.mNativeActionModeAwareLayout = ((NativeActionModeAwareLayout) paramActionBarActivity.findViewById(R.id.action_bar_root));
        if (this.mNativeActionModeAwareLayout != null) {
            this.mNativeActionModeAwareLayout.setActionModeForChildListener(this);
        }
    }

    public void hide() {
        super.hide();
        if (this.mCurActionMode != null) {
            this.mCurActionMode.finish();
        }
    }

    boolean isShowHideAnimationEnabled() {
        return (this.mCurActionMode == null) && (super.isShowHideAnimationEnabled());
    }

    public ActionMode.Callback onActionModeForChild(ActionMode.Callback paramCallback) {
        return new CallbackWrapper(paramCallback);
    }

    public void show() {
        super.show();
        if (this.mCurActionMode != null) {
            this.mCurActionMode.finish();
        }
    }

    private class CallbackWrapper
            implements ActionMode.Callback {
        private final ActionMode.Callback mWrappedCallback;

        CallbackWrapper(ActionMode.Callback paramCallback) {
            this.mWrappedCallback = paramCallback;
        }

        public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
            return this.mWrappedCallback.onActionItemClicked(paramActionMode, paramMenuItem);
        }

        public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
            boolean bool = this.mWrappedCallback.onCreateActionMode(paramActionMode, paramMenu);
            if (bool) {
                ActionBarImplHC.access$002(ActionBarImplHC.this, paramActionMode);
                ActionBarImplHC.this.showForActionMode();
            }
            return bool;
        }

        public void onDestroyActionMode(ActionMode paramActionMode) {
            this.mWrappedCallback.onDestroyActionMode(paramActionMode);
            ActionBarImplHC.this.hideForActionMode();
            ActionBarImplHC.access$002(ActionBarImplHC.this, null);
        }

        public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
            return this.mWrappedCallback.onPrepareActionMode(paramActionMode, paramMenu);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/app/ActionBarImplHC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package android.support.v7.internal.view.menu;

import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class MenuItemWrapperJB
        extends MenuItemWrapperICS {
    MenuItemWrapperJB(MenuItem paramMenuItem) {
        super(paramMenuItem, false);
    }

    MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider paramActionProvider) {
        return new ActionProviderWrapperJB(paramActionProvider);
    }

    class ActionProviderWrapperJB
            extends MenuItemWrapperICS.ActionProviderWrapper
            implements android.support.v4.view.ActionProvider.VisibilityListener {
        android.view.ActionProvider.VisibilityListener mListener;

        public ActionProviderWrapperJB(ActionProvider paramActionProvider) {
            super(paramActionProvider);
        }

        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean paramBoolean) {
            if (this.mListener != null) {
                this.mListener.onActionProviderVisibilityChanged(paramBoolean);
            }
        }

        public View onCreateActionView(MenuItem paramMenuItem) {
            return this.mInner.onCreateActionView(paramMenuItem);
        }

        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        public void setVisibilityListener(android.view.ActionProvider.VisibilityListener paramVisibilityListener) {
            this.mListener = paramVisibilityListener;
            ActionProvider localActionProvider = this.mInner;
            if (paramVisibilityListener != null) {
            }
            for (paramVisibilityListener = this; ; paramVisibilityListener = null) {
                localActionProvider.setVisibilityListener(paramVisibilityListener);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/internal/view/menu/MenuItemWrapperJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
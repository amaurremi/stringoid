package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.reflect.Method;

public class MenuItemWrapperICS
        extends BaseMenuWrapper<MenuItem>
        implements SupportMenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private final boolean mEmulateProviderVisibilityOverride;
    private boolean mLastRequestVisible;
    private Method mSetExclusiveCheckableMethod;

    MenuItemWrapperICS(MenuItem paramMenuItem) {
        this(paramMenuItem, true);
    }

    MenuItemWrapperICS(MenuItem paramMenuItem, boolean paramBoolean) {
        super(paramMenuItem);
        this.mLastRequestVisible = paramMenuItem.isVisible();
        this.mEmulateProviderVisibilityOverride = paramBoolean;
    }

    final boolean checkActionProviderOverrideVisibility() {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (this.mLastRequestVisible) {
            android.support.v4.view.ActionProvider localActionProvider = getSupportActionProvider();
            bool1 = bool2;
            if (localActionProvider != null) {
                bool1 = bool2;
                if (localActionProvider.overridesItemVisibility()) {
                    bool1 = bool2;
                    if (!localActionProvider.isVisible()) {
                        wrappedSetVisible(false);
                        bool1 = true;
                    }
                }
            }
        }
        return bool1;
    }

    public boolean collapseActionView() {
        return ((MenuItem) this.mWrappedObject).collapseActionView();
    }

    ActionProviderWrapper createActionProviderWrapper(android.support.v4.view.ActionProvider paramActionProvider) {
        return new ActionProviderWrapper(paramActionProvider);
    }

    public boolean expandActionView() {
        return ((MenuItem) this.mWrappedObject).expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        return ((MenuItem) this.mWrappedObject).getActionProvider();
    }

    public View getActionView() {
        View localView2 = ((MenuItem) this.mWrappedObject).getActionView();
        View localView1 = localView2;
        if ((localView2 instanceof CollapsibleActionViewWrapper)) {
            localView1 = ((CollapsibleActionViewWrapper) localView2).getWrappedView();
        }
        return localView1;
    }

    public char getAlphabeticShortcut() {
        return ((MenuItem) this.mWrappedObject).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((MenuItem) this.mWrappedObject).getGroupId();
    }

    public Drawable getIcon() {
        return ((MenuItem) this.mWrappedObject).getIcon();
    }

    public Intent getIntent() {
        return ((MenuItem) this.mWrappedObject).getIntent();
    }

    public int getItemId() {
        return ((MenuItem) this.mWrappedObject).getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((MenuItem) this.mWrappedObject).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((MenuItem) this.mWrappedObject).getNumericShortcut();
    }

    public int getOrder() {
        return ((MenuItem) this.mWrappedObject).getOrder();
    }

    public SubMenu getSubMenu() {
        return getSubMenuWrapper(((MenuItem) this.mWrappedObject).getSubMenu());
    }

    public android.support.v4.view.ActionProvider getSupportActionProvider() {
        ActionProviderWrapper localActionProviderWrapper = (ActionProviderWrapper) ((MenuItem) this.mWrappedObject).getActionProvider();
        if (localActionProviderWrapper != null) {
            return localActionProviderWrapper.mInner;
        }
        return null;
    }

    public CharSequence getTitle() {
        return ((MenuItem) this.mWrappedObject).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((MenuItem) this.mWrappedObject).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((MenuItem) this.mWrappedObject).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((MenuItem) this.mWrappedObject).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((MenuItem) this.mWrappedObject).isCheckable();
    }

    public boolean isChecked() {
        return ((MenuItem) this.mWrappedObject).isChecked();
    }

    public boolean isEnabled() {
        return ((MenuItem) this.mWrappedObject).isEnabled();
    }

    public boolean isVisible() {
        return ((MenuItem) this.mWrappedObject).isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider) {
        ((MenuItem) this.mWrappedObject).setActionProvider(paramActionProvider);
        if ((paramActionProvider != null) && (this.mEmulateProviderVisibilityOverride)) {
            checkActionProviderOverrideVisibility();
        }
        return this;
    }

    public MenuItem setActionView(int paramInt) {
        ((MenuItem) this.mWrappedObject).setActionView(paramInt);
        View localView = ((MenuItem) this.mWrappedObject).getActionView();
        if ((localView instanceof android.support.v7.view.CollapsibleActionView)) {
            ((MenuItem) this.mWrappedObject).setActionView(new CollapsibleActionViewWrapper(localView));
        }
        return this;
    }

    public MenuItem setActionView(View paramView) {
        Object localObject = paramView;
        if ((paramView instanceof android.support.v7.view.CollapsibleActionView)) {
            localObject = new CollapsibleActionViewWrapper(paramView);
        }
        ((MenuItem) this.mWrappedObject).setActionView((View) localObject);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char paramChar) {
        ((MenuItem) this.mWrappedObject).setAlphabeticShortcut(paramChar);
        return this;
    }

    public MenuItem setCheckable(boolean paramBoolean) {
        ((MenuItem) this.mWrappedObject).setCheckable(paramBoolean);
        return this;
    }

    public MenuItem setChecked(boolean paramBoolean) {
        ((MenuItem) this.mWrappedObject).setChecked(paramBoolean);
        return this;
    }

    public MenuItem setEnabled(boolean paramBoolean) {
        ((MenuItem) this.mWrappedObject).setEnabled(paramBoolean);
        return this;
    }

    public void setExclusiveCheckable(boolean paramBoolean) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = ((MenuItem) this.mWrappedObject).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(paramBoolean)});
            return;
        } catch (Exception localException) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
        }
    }

    public MenuItem setIcon(int paramInt) {
        ((MenuItem) this.mWrappedObject).setIcon(paramInt);
        return this;
    }

    public MenuItem setIcon(Drawable paramDrawable) {
        ((MenuItem) this.mWrappedObject).setIcon(paramDrawable);
        return this;
    }

    public MenuItem setIntent(Intent paramIntent) {
        ((MenuItem) this.mWrappedObject).setIntent(paramIntent);
        return this;
    }

    public MenuItem setNumericShortcut(char paramChar) {
        ((MenuItem) this.mWrappedObject).setNumericShortcut(paramChar);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
        ((MenuItem) this.mWrappedObject).setOnActionExpandListener(paramOnActionExpandListener);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
        MenuItem localMenuItem = (MenuItem) this.mWrappedObject;
        if (paramOnMenuItemClickListener != null) {
        }
        for (paramOnMenuItemClickListener = new OnMenuItemClickListenerWrapper(paramOnMenuItemClickListener); ; paramOnMenuItemClickListener = null) {
            localMenuItem.setOnMenuItemClickListener(paramOnMenuItemClickListener);
            return this;
        }
    }

    public MenuItem setShortcut(char paramChar1, char paramChar2) {
        ((MenuItem) this.mWrappedObject).setShortcut(paramChar1, paramChar2);
        return this;
    }

    public void setShowAsAction(int paramInt) {
        ((MenuItem) this.mWrappedObject).setShowAsAction(paramInt);
    }

    public MenuItem setShowAsActionFlags(int paramInt) {
        ((MenuItem) this.mWrappedObject).setShowAsActionFlags(paramInt);
        return this;
    }

    public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider) {
        MenuItem localMenuItem = (MenuItem) this.mWrappedObject;
        if (paramActionProvider != null) {
        }
        for (paramActionProvider = createActionProviderWrapper(paramActionProvider); ; paramActionProvider = null) {
            localMenuItem.setActionProvider(paramActionProvider);
            return this;
        }
    }

    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {
        MenuItem localMenuItem = (MenuItem) this.mWrappedObject;
        if (paramOnActionExpandListener != null) {
        }
        for (paramOnActionExpandListener = new OnActionExpandListenerWrapper(paramOnActionExpandListener); ; paramOnActionExpandListener = null) {
            localMenuItem.setOnActionExpandListener(paramOnActionExpandListener);
            return null;
        }
    }

    public MenuItem setTitle(int paramInt) {
        ((MenuItem) this.mWrappedObject).setTitle(paramInt);
        return this;
    }

    public MenuItem setTitle(CharSequence paramCharSequence) {
        ((MenuItem) this.mWrappedObject).setTitle(paramCharSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
        ((MenuItem) this.mWrappedObject).setTitleCondensed(paramCharSequence);
        return this;
    }

    public MenuItem setVisible(boolean paramBoolean) {
        if (this.mEmulateProviderVisibilityOverride) {
            this.mLastRequestVisible = paramBoolean;
            if (checkActionProviderOverrideVisibility()) {
                return this;
            }
        }
        return wrappedSetVisible(paramBoolean);
    }

    final MenuItem wrappedSetVisible(boolean paramBoolean) {
        return ((MenuItem) this.mWrappedObject).setVisible(paramBoolean);
    }

    class ActionProviderWrapper
            extends android.view.ActionProvider {
        final android.support.v4.view.ActionProvider mInner;

        public ActionProviderWrapper(android.support.v4.view.ActionProvider paramActionProvider) {
            super();
            this.mInner = paramActionProvider;
            if (MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride) {
                this.mInner.setVisibilityListener(new ActionProvider.VisibilityListener() {
                    public void onActionProviderVisibilityChanged(boolean paramAnonymousBoolean) {
                        if ((MenuItemWrapperICS.ActionProviderWrapper.this.mInner.overridesItemVisibility()) && (MenuItemWrapperICS.this.mLastRequestVisible)) {
                            MenuItemWrapperICS.this.wrappedSetVisible(paramAnonymousBoolean);
                        }
                    }
                });
            }
        }

        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        public View onCreateActionView() {
            if (MenuItemWrapperICS.this.mEmulateProviderVisibilityOverride) {
                MenuItemWrapperICS.this.checkActionProviderOverrideVisibility();
            }
            return this.mInner.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu paramSubMenu) {
            this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(paramSubMenu));
        }
    }

    static class CollapsibleActionViewWrapper
            extends FrameLayout
            implements android.view.CollapsibleActionView {
        final android.support.v7.view.CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View paramView) {
            super();
            this.mWrappedView = ((android.support.v7.view.CollapsibleActionView) paramView);
            addView(paramView);
        }

        View getWrappedView() {
            return (View) this.mWrappedView;
        }

        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }
    }

    private class OnActionExpandListenerWrapper
            extends BaseWrapper<MenuItemCompat.OnActionExpandListener>
            implements MenuItem.OnActionExpandListener {
        OnActionExpandListenerWrapper(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {
            super();
        }

        public boolean onMenuItemActionCollapse(MenuItem paramMenuItem) {
            return ((MenuItemCompat.OnActionExpandListener) this.mWrappedObject).onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem paramMenuItem) {
            return ((MenuItemCompat.OnActionExpandListener) this.mWrappedObject).onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
        }
    }

    private class OnMenuItemClickListenerWrapper
            extends BaseWrapper<MenuItem.OnMenuItemClickListener>
            implements MenuItem.OnMenuItemClickListener {
        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
            super();
        }

        public boolean onMenuItemClick(MenuItem paramMenuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.mWrappedObject).onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(paramMenuItem));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/internal/view/menu/MenuItemWrapperICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
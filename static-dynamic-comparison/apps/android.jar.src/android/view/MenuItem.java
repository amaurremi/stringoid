package android.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;

public abstract interface MenuItem {
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    public abstract int getItemId();

    public abstract int getGroupId();

    public abstract int getOrder();

    public abstract MenuItem setTitle(CharSequence paramCharSequence);

    public abstract MenuItem setTitle(int paramInt);

    public abstract CharSequence getTitle();

    public abstract MenuItem setTitleCondensed(CharSequence paramCharSequence);

    public abstract CharSequence getTitleCondensed();

    public abstract MenuItem setIcon(Drawable paramDrawable);

    public abstract MenuItem setIcon(int paramInt);

    public abstract Drawable getIcon();

    public abstract MenuItem setIntent(Intent paramIntent);

    public abstract Intent getIntent();

    public abstract MenuItem setShortcut(char paramChar1, char paramChar2);

    public abstract MenuItem setNumericShortcut(char paramChar);

    public abstract char getNumericShortcut();

    public abstract MenuItem setAlphabeticShortcut(char paramChar);

    public abstract char getAlphabeticShortcut();

    public abstract MenuItem setCheckable(boolean paramBoolean);

    public abstract boolean isCheckable();

    public abstract MenuItem setChecked(boolean paramBoolean);

    public abstract boolean isChecked();

    public abstract MenuItem setVisible(boolean paramBoolean);

    public abstract boolean isVisible();

    public abstract MenuItem setEnabled(boolean paramBoolean);

    public abstract boolean isEnabled();

    public abstract boolean hasSubMenu();

    public abstract SubMenu getSubMenu();

    public abstract MenuItem setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener);

    public abstract ContextMenu.ContextMenuInfo getMenuInfo();

    public abstract void setShowAsAction(int paramInt);

    public abstract MenuItem setShowAsActionFlags(int paramInt);

    public abstract MenuItem setActionView(View paramView);

    public abstract MenuItem setActionView(int paramInt);

    public abstract View getActionView();

    public abstract MenuItem setActionProvider(ActionProvider paramActionProvider);

    public abstract ActionProvider getActionProvider();

    public abstract boolean expandActionView();

    public abstract boolean collapseActionView();

    public abstract boolean isActionViewExpanded();

    public abstract MenuItem setOnActionExpandListener(OnActionExpandListener paramOnActionExpandListener);

    public static abstract interface OnActionExpandListener {
        public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);

        public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    }

    public static abstract interface OnMenuItemClickListener {
        public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
    }
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/MenuItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
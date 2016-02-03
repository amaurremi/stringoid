package android.view;

import android.content.ComponentName;
import android.content.Intent;

public abstract interface Menu {
    public static final int NONE = 0;
    public static final int FIRST = 1;
    public static final int CATEGORY_CONTAINER = 65536;
    public static final int CATEGORY_SYSTEM = 131072;
    public static final int CATEGORY_SECONDARY = 196608;
    public static final int CATEGORY_ALTERNATIVE = 262144;
    public static final int FLAG_APPEND_TO_GROUP = 1;
    public static final int FLAG_PERFORM_NO_CLOSE = 1;
    public static final int FLAG_ALWAYS_PERFORM_CLOSE = 2;

    public abstract MenuItem add(CharSequence paramCharSequence);

    public abstract MenuItem add(int paramInt);

    public abstract MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence);

    public abstract MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public abstract SubMenu addSubMenu(CharSequence paramCharSequence);

    public abstract SubMenu addSubMenu(int paramInt);

    public abstract SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence);

    public abstract SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public abstract int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem);

    public abstract void removeItem(int paramInt);

    public abstract void removeGroup(int paramInt);

    public abstract void clear();

    public abstract void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2);

    public abstract void setGroupVisible(int paramInt, boolean paramBoolean);

    public abstract void setGroupEnabled(int paramInt, boolean paramBoolean);

    public abstract boolean hasVisibleItems();

    public abstract MenuItem findItem(int paramInt);

    public abstract int size();

    public abstract MenuItem getItem(int paramInt);

    public abstract void close();

    public abstract boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2);

    public abstract boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent);

    public abstract boolean performIdentifierAction(int paramInt1, int paramInt2);

    public abstract void setQwertyMode(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/Menu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
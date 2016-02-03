package android.view;

import android.graphics.drawable.Drawable;

public abstract interface SubMenu
        extends Menu {
    public abstract SubMenu setHeaderTitle(int paramInt);

    public abstract SubMenu setHeaderTitle(CharSequence paramCharSequence);

    public abstract SubMenu setHeaderIcon(int paramInt);

    public abstract SubMenu setHeaderIcon(Drawable paramDrawable);

    public abstract SubMenu setHeaderView(View paramView);

    public abstract void clearHeader();

    public abstract SubMenu setIcon(int paramInt);

    public abstract SubMenu setIcon(Drawable paramDrawable);

    public abstract MenuItem getItem();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/SubMenu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
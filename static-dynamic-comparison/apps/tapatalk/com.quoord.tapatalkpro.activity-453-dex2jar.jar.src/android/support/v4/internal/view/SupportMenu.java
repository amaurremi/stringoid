package android.support.v4.internal.view;

import android.view.Menu;

public abstract interface SupportMenu
        extends Menu {
    public static final int CATEGORY_MASK = -65536;
    public static final int CATEGORY_SHIFT = 16;
    public static final int USER_MASK = 65535;
    public static final int USER_SHIFT = 0;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/android/support/v4/internal/view/SupportMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
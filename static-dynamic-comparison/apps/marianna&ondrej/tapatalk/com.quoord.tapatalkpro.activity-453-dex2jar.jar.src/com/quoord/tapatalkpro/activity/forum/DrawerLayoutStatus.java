package com.quoord.tapatalkpro.activity.forum;

import android.view.Menu;

public abstract interface DrawerLayoutStatus {
    public abstract void closeDrawerLay();

    public abstract void createDrawerMenu(Menu paramMenu);

    public abstract boolean isDrawMenuOpen();

    public abstract void toggle();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/DrawerLayoutStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
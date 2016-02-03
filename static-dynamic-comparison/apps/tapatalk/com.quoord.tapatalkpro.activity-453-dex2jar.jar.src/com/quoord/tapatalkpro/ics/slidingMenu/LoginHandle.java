package com.quoord.tapatalkpro.ics.slidingMenu;

public abstract interface LoginHandle {
    public abstract String getNeededString(int paramInt);

    public abstract void showEditUsernameDialog();

    public abstract void showLoginErrorDialog(String paramString);

    public abstract void showLoginErrorDialog4HasStatus(String paramString);

    public abstract void showSignErrorDialog(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/LoginHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.quoord.tools;

import android.content.Context;

import java.util.HashMap;

public abstract interface ForumHttpStatus {
    public abstract String getAppVersion(Context paramContext);

    public abstract String getCookie();

    public abstract HashMap<String, String> getCookies();

    public abstract String getUrl();

    public abstract boolean getUseZip();

    public abstract boolean isAgent();

    public abstract boolean isContentType();

    public abstract boolean isGuestOkay();

    public abstract boolean isLogin();

    public abstract boolean isRequestZip();

    public abstract void setZip(boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/ForumHttpStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
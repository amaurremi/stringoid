package com.quoord.tapatalkpro.bean;

import org.json.JSONObject;

public abstract interface TapatalkId {
    public static final String PREFSKEY_TAPATALKID_AUID = "tapatalk_auid";
    public static final String PREFSKEY_TAPATALKID_EMAIL = "email";
    public static final String PREFSKEY_TAPATALKID_HASACCOUNTS = "tapatalkhasaccount";
    public static final String PREFSKEY_TAPATALKID_LOGINSTATUS = "login";
    public static final String PREFSKEY_TAPATALKID_PASSWORD = "ttidpassword";
    public static final String PREFSKEY_TAPATALKID_STATUS = "status";
    public static final String PREFSKEY_TAPATALKID_TOKEN = "token";
    public static final String PREFSKEY_TAPATALKID_USERNAME = "username";
    public static final String PREFSKEY_TAPATALKID_VIP = "vip";

    public abstract int getAuid();

    public abstract String getPassword();

    public abstract String getSignInMode();

    public abstract String getTapatalkIdEmail();

    public abstract String getToken();

    public abstract String getUsername();

    public abstract boolean isConfirmed();

    public abstract boolean isHasAccounts();

    public abstract boolean isTapatalkIdLogin();

    public abstract boolean isVIP();

    public abstract boolean saveTapatalkId(JSONObject paramJSONObject);

    public abstract void saveTapatalkIdData(String paramString, int paramInt);

    public abstract void saveTapatalkIdData(String paramString1, String paramString2);

    public abstract void saveTapatalkIdData(String paramString, boolean paramBoolean);

    public abstract boolean signOut();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/TapatalkId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.wbtech.ums.common;

public class UmsConstants {
    public static boolean DebugMode = false;
    public static final String activityUrl = "/ums/postActivityLog";
    public static final String clientDataUrl = "/ums/postClientData";
    public static final String errorUrl = "/ums/postErrorLog";
    public static final String eventUrl = "/ums/postEvent";
    public static long kContinueSessionMillis = 30000L;
    public static final String onlineConfigUrl = "/ums/getOnlineConfiguration";
    public static String preUrl = "";
    public static final Object saveOnlineConfigMutex = new Object();
    public static final String updataUrl = "/ums/getApplicationUpdate";
    public static final String uploadUrl = "/ums/uploadLog";
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/common/UmsConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
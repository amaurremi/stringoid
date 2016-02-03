package com.wbtech.ums;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.util.Util;
import com.wbtech.ums.common.CommonUtil;
import com.wbtech.ums.common.EventThread;
import com.wbtech.ums.common.MD5Utility;
import com.wbtech.ums.common.MyCrashHandler;
import com.wbtech.ums.common.NetworkUitlity;
import com.wbtech.ums.common.UmsConstants;
import com.wbtech.ums.dao.GetInfoFromFile;
import com.wbtech.ums.dao.SaveInfo;
import com.wbtech.ums.objects.MyMessage;
import com.wbtech.ums.objects.SCell;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UmsAgent {
    private static String activities;
    private static String appkey;
    private static String curVersion;
    private static int defaultReportMode;
    private static String deviceID;
    private static String duration;
    private static long end;
    private static String end_millis;
    private static Handler handler;
    private static boolean isFirst;
    private static boolean isPostFile;
    private static boolean mUpdateOnlyWifi;
    private static boolean mUseLocationService = true;
    private static String os_version;
    private static String packagename;
    private static String sdk_version;
    private static String session_id;
    private static String stacktrace;
    private static long start;
    private static String start_millis = null;
    private static long tcp_rcv = 0L;
    private static long tcp_rcvofbegin;
    private static long tcp_snd;
    private static long tcp_sndofbegin;
    private static String time;
    private static UmsAgent umsAgentEntity;

    static {
        start = 0L;
        end_millis = null;
        end = 0L;
        duration = null;
        session_id = null;
        activities = null;
        appkey = "";
        stacktrace = null;
        time = null;
        os_version = null;
        deviceID = null;
        curVersion = null;
        packagename = null;
        sdk_version = null;
        umsAgentEntity = new UmsAgent();
        mUpdateOnlyWifi = true;
        defaultReportMode = 0;
        isPostFile = true;
        isFirst = true;
        tcp_sndofbegin = 0L;
        tcp_rcvofbegin = 0L;
        tcp_snd = 0L;
    }

    private UmsAgent() {
        HandlerThread localHandlerThread = new HandlerThread("UmsAgent");
        localHandlerThread.start();
        handler = new Handler(localHandlerThread.getLooper());
    }

    private static String generateSeesion(Context paramContext)
            throws ParseException {
        paramContext = CommonUtil.getAppKey(paramContext);
        if (paramContext != null) {
            String str = CommonUtil.getTime();
            return MD5Utility.md5Appkey(paramContext + str);
        }
        return null;
    }

    private static JSONObject getClientDataJSONObject(Context paramContext) {
        boolean bool2 = false;
        Object localObject1 = (TelephonyManager) paramContext.getSystemService("phone");
        WifiManager localWifiManager = (WifiManager) paramContext.getSystemService("wifi");
        Object localObject2 = (WindowManager) paramContext.getSystemService("window");
        Object localObject3 = new DisplayMetrics();
        ((WindowManager) localObject2).getDefaultDisplay().getMetrics((DisplayMetrics) localObject3);
        LocationManager localLocationManager = (LocationManager) paramContext.getSystemService("location");
        BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        localObject2 = new JSONObject();
        for (; ; ) {
            try {
                ((JSONObject) localObject2).put("os_version", CommonUtil.getOsVersion(paramContext));
                ((JSONObject) localObject2).put("platform", "android");
                ((JSONObject) localObject2).put("language", Util.getDeviceLanguage(paramContext));
                ((JSONObject) localObject2).put("deviceid", Util.getMD5(Util.getMacAddress(paramContext)));
                ((JSONObject) localObject2).put("appkey", CommonUtil.getAppKey(paramContext));
                ((JSONObject) localObject2).put("resolution", ((DisplayMetrics) localObject3).widthPixels + "x" + ((DisplayMetrics) localObject3).heightPixels);
                ((JSONObject) localObject2).put("ismobiledevice", true);
                ((JSONObject) localObject2).put("phonetype", ((TelephonyManager) localObject1).getPhoneType());
                ((JSONObject) localObject2).put("network", CommonUtil.getNetworkType(paramContext));
                ((JSONObject) localObject2).put("version", CommonUtil.getVersion(paramContext));
                localObject3 = CommonUtil.getCellInfo(paramContext);
                if (localObject3 != null) {
                    localObject1 = ((SCell) localObject3).MCCMNC;
                    ((JSONObject) localObject2).put("mccmnc", localObject1);
                    if (localObject3 == null) {
                        break label537;
                    }
                    localObject1 = ((SCell) localObject3).CID;
                    ((JSONObject) localObject2).put("cellid", localObject1);
                    if (localObject3 != null) {
                        localObject1 = ((SCell) localObject3).LAC;
                        ((JSONObject) localObject2).put("lac", localObject1);
                        ((JSONObject) localObject2).put("time", CommonUtil.getTime());
                        new Build();
                        ((JSONObject) localObject2).put("modulename", Build.MODEL);
                        ((JSONObject) localObject2).put("devicename", Build.MANUFACTURER + Build.PRODUCT);
                        ((JSONObject) localObject2).put("wifimac", localWifiManager.getConnectionInfo().getMacAddress());
                        if (localBluetoothAdapter == null) {
                            bool1 = false;
                            ((JSONObject) localObject2).put("havebt", bool1);
                            ((JSONObject) localObject2).put("havewifi", CommonUtil.isWiFiActive(paramContext));
                            if (localLocationManager != null) {
                                continue;
                            }
                            bool1 = bool2;
                            ((JSONObject) localObject2).put("havegps", bool1);
                            ((JSONObject) localObject2).put("havegravity", CommonUtil.isHaveGravity(paramContext));
                            CommonUtil.printLog("ums", ((JSONObject) localObject2).toString());
                            return (JSONObject) localObject2;
                        }
                    } else {
                        localObject1 = "";
                        continue;
                    }
                    boolean bool1 = true;
                    continue;
                    bool1 = true;
                    continue;
                }
                localObject1 = "";
            } catch (JSONException paramContext) {
                paramContext.printStackTrace();
                return (JSONObject) localObject2;
            } catch (Exception paramContext) {
                paramContext.printStackTrace();
                return (JSONObject) localObject2;
            }
            continue;
            label537:
            localObject1 = "";
        }
    }

    public static String getConfigParams(Context paramContext, String paramString) {
        appkey = CommonUtil.getAppKey(paramContext);
        Object localObject = new JSONObject();
        try {
            ((JSONObject) localObject).put("appkey", appkey);
            localObject = ((JSONObject) localObject).toString();
            if (CommonUtil.isNetworkAvailable(paramContext)) {
                paramContext = NetworkUitlity.post(UmsConstants.preUrl + "/ums/getOnlineConfiguration", (String) localObject);
                if (!paramContext.isFlag()) {
                }
            }
        } catch (JSONException localJSONException) {
            for (; ; ) {
                try {
                    paramContext = new JSONObject(paramContext.getMsg()).getString(paramString);
                    return paramContext;
                } catch (JSONException paramContext) {
                    paramContext.printStackTrace();
                }
                localJSONException = localJSONException;
                localJSONException.printStackTrace();
            }
        }
        for (; ; ) {
            return "";
            CommonUtil.printLog("error", "getConfigParams error");
            continue;
            CommonUtil.printLog("NetworkError", "Network, not work");
        }
    }

    private static JSONObject getErrorInfoJSONObj() {
        JSONObject localJSONObject = new JSONObject();
        try {
            new Build();
            localJSONObject.put("stacktrace", stacktrace);
            localJSONObject.put("time", time);
            localJSONObject.put("activity", activities);
            localJSONObject.put("appkey", appkey);
            localJSONObject.put("os_version", os_version);
            localJSONObject.put("deviceid", Build.MANUFACTURER + Build.PRODUCT);
            return localJSONObject;
        } catch (JSONException localJSONException) {
            localJSONException.printStackTrace();
        }
        return localJSONObject;
    }

    private JSONObject getEventJOSNobj(Context paramContext, String paramString1, String paramString2, int paramInt) {
        JSONObject localJSONObject = new JSONObject();
        String str = CommonUtil.getTime();
        try {
            localJSONObject.put("time", str);
            localJSONObject.put("version", CommonUtil.getVersion(paramContext));
            localJSONObject.put("event_identifier", paramString2);
            localJSONObject.put("appkey", appkey);
            localJSONObject.put("activity", CommonUtil.getActivityName(paramContext));
            if (paramString1 != null) {
                localJSONObject.put("label", paramString1);
            }
            localJSONObject.put("acc", paramInt);
            return localJSONObject;
        } catch (JSONException paramContext) {
            CommonUtil.printLog("UmsAgent", "json error in emitCustomLogReport");
            paramContext.printStackTrace();
        }
        return localJSONObject;
    }

    private static JSONObject getJSONObject(Context paramContext) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("session_id", session_id);
            localJSONObject.put("start_millis", start_millis);
            localJSONObject.put("end_millis", end_millis);
            localJSONObject.put("duration", duration);
            localJSONObject.put("version", CommonUtil.getVersion(paramContext));
            localJSONObject.put("activities", activities);
            localJSONObject.put("appkey", appkey);
            return localJSONObject;
        } catch (JSONException paramContext) {
            paramContext.printStackTrace();
        }
        return localJSONObject;
    }

    public static UmsAgent getUmsAgent() {
        return umsAgentEntity;
    }

    private static void isupdate(Context paramContext) {
        try {
            appkey = CommonUtil.getAppKey(paramContext);
            curVersion = CommonUtil.getCurVersion(paramContext);
            localObject = new JSONObject();
        } catch (Exception localException) {
            try {
                Object localObject;
                ((JSONObject) localObject).put("appkey", appkey);
                ((JSONObject) localObject).put("version_code", curVersion);
                if ((CommonUtil.isNetworkAvailable(paramContext)) && (CommonUtil.isNetworkTypeWifi(paramContext))) {
                    localObject = NetworkUitlity.post(UmsConstants.preUrl + "/ums/getApplicationUpdate", ((JSONObject) localObject).toString());
                    if (!((MyMessage) localObject).isFlag()) {
                    }
                } else {
                    try {
                        localObject = new JSONObject(((MyMessage) localObject).getMsg());
                        if (Integer.parseInt(((JSONObject) localObject).getString("flag")) > 0) {
                            String str1 = ((JSONObject) localObject).getString("fileurl");
                            ((JSONObject) localObject).getString("msg");
                            String str2 = ((JSONObject) localObject).getString("forceupdate");
                            String str3 = ((JSONObject) localObject).getString("description");
                            ((JSONObject) localObject).getString("time");
                            new UpdateManager(paramContext, ((JSONObject) localObject).getString("version"), str2, str1, str3);
                            UpdateManager.showNoticeDialog(paramContext);
                        }
                        return;
                    } catch (JSONException paramContext) {
                        paramContext.printStackTrace();
                        return;
                    }
                    localException = localException;
                    Toast.makeText(paramContext, end_millis.toString(), 1).show();
                }
            } catch (JSONException localJSONException) {
                for (; ; ) {
                    localJSONException.printStackTrace();
                }
            }
        }
        CommonUtil.printLog("error", localException.getMsg());
    }

    public static void onError(Context paramContext) {
        MyCrashHandler localMyCrashHandler = MyCrashHandler.getInstance();
        localMyCrashHandler.init(paramContext);
        Thread.setDefaultUncaughtExceptionHandler(localMyCrashHandler);
    }

    public static void onError(Context paramContext, final String paramString) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.postErrorInfo(UmsAgent.this, paramString);
            }
        };
        handler.post(paramContext);
    }

    public static void onEvent(Context paramContext, final String paramString) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.postEventInfo(UmsAgent.this, paramString);
            }
        };
        handler.post(paramContext);
    }

    private static void onEvent(Context paramContext, String paramString, int paramInt) {
        postEventInfo(paramContext, paramString, null, paramInt);
    }

    public static void onEvent(Context paramContext, final String paramString1, final String paramString2) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.postEventInfo(UmsAgent.this, paramString1, paramString2);
            }
        };
        handler.post(paramContext);
    }

    public static void onPause(Context paramContext) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.postOnPauseInfo(UmsAgent.this);
            }
        };
        handler.post(paramContext);
    }

    public static void onResume(Context paramContext) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.postonResume(UmsAgent.this);
            }
        };
        handler.post(paramContext);
    }

    public static void postClientData(Context paramContext) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.postClientDatas(UmsAgent.this);
            }
        };
        handler.post(paramContext);
    }

    private static void postClientDatas(Context paramContext) {
        int i = 1;
        JSONObject localJSONObject = getClientDataJSONObject(paramContext);
        if (1 == CommonUtil.getReportPolicyMode(paramContext)) {
            if ((i & CommonUtil.isNetworkAvailable(paramContext)) == 0) {
                break label89;
            }
            MyMessage localMyMessage = NetworkUitlity.post(UmsConstants.preUrl + "/ums/postClientData", localJSONObject.toString());
            if (!localMyMessage.isFlag()) {
                saveInfoToFile("clientData", localJSONObject, paramContext);
                CommonUtil.printLog("Errorinfo", localMyMessage.getMsg());
            }
        }
        for (; ; ) {
            isFirst = false;
            return;
            i = 0;
            break;
            label89:
            saveInfoToFile("clientData", localJSONObject, paramContext);
        }
    }

    private static void postErrorInfo(Context paramContext, String paramString) {
        stacktrace = paramString;
        activities = CommonUtil.getActivityName(paramContext);
        time = CommonUtil.getTime();
        appkey = CommonUtil.getAppKey(paramContext);
        os_version = CommonUtil.getOsVersion(paramContext);
        deviceID = CommonUtil.getDeviceID(paramContext);
        paramString = getErrorInfoJSONObj();
        if ((1 == CommonUtil.getReportPolicyMode(paramContext)) && (CommonUtil.isNetworkAvailable(paramContext))) {
            MyMessage localMyMessage = NetworkUitlity.post(UmsConstants.preUrl + "/ums/postErrorLog", paramString.toString());
            if (!localMyMessage.isFlag()) {
                saveInfoToFile("errorInfo", paramString, paramContext);
                CommonUtil.printLog("error", localMyMessage.getMsg());
            }
            return;
        }
        saveInfoToFile("errorInfo", paramString, paramContext);
    }

    private static void postEventInfo(Context paramContext, String paramString) {
        onEvent(paramContext, paramString, 1);
    }

    private static void postEventInfo(Context paramContext, String paramString1, String paramString2) {
        if ((paramString2 == null) || (paramString2 == "")) {
            CommonUtil.printLog("UMSAgent", "label is null or empty in onEvent(4p)");
            return;
        }
        postEventInfo(paramContext, URLEncoder.encode(paramString1), paramString2, 1);
    }

    private static void postEventInfo(Context paramContext, String paramString1, String paramString2, int paramInt) {
        try {
            String str = CommonUtil.getAppKey(paramContext);
            if (paramInt <= 0) {
                CommonUtil.printLog("UMSAgent", "Illegal value of acc in postEventInfo");
                return;
            }
            new EventThread(paramContext, str, paramString1, paramString2, paramInt).start();
            return;
        } catch (Exception paramContext) {
            CommonUtil.printLog("UMSAgent", "Exception occurred in postEventInfo()");
            paramContext.printStackTrace();
        }
    }

    private static void postOnPauseInfo(Context paramContext) {
        end_millis = CommonUtil.getTime();
        end = Long.valueOf(System.currentTimeMillis()).longValue();
        duration = end - start;
        appkey = CommonUtil.getAppKey(paramContext);
        JSONObject localJSONObject = getJSONObject(paramContext);
        CommonUtil.printLog("UmsAgent", localJSONObject);
        if ((1 == CommonUtil.getReportPolicyMode(paramContext)) && (CommonUtil.isNetworkAvailable(paramContext))) {
            CommonUtil.printLog("activityInfo", localJSONObject.toString());
            MyMessage localMyMessage = NetworkUitlity.post(UmsConstants.preUrl + "/ums/postActivityLog", localJSONObject.toString());
            if (!localMyMessage.isFlag()) {
                saveInfoToFile("activityInfo", localJSONObject, paramContext);
                CommonUtil.printLog("error", localMyMessage.getMsg());
            }
            return;
        }
        saveInfoToFile("activityInfo", localJSONObject, paramContext);
    }

    private static void postonResume(Context paramContext) {
        if (!CommonUtil.isNetworkAvailable(paramContext)) {
            setDefaultReportPolicy(paramContext, 0);
        }
        for (; ; ) {
            activities = CommonUtil.getActivityName(paramContext);
            try {
                if (session_id == null) {
                    session_id = generateSeesion(paramContext);
                }
                start_millis = CommonUtil.getTime();
                start = Long.valueOf(System.currentTimeMillis()).longValue();
                return;
                if (!isPostFile) {
                    continue;
                }
                new GetInfoFromFile(paramContext).run();
                isPostFile = false;
            } catch (Exception paramContext) {
                for (; ; ) {
                    paramContext.printStackTrace();
                }
            }
        }
    }

    private void saveEvent(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt) {
        paramString1 = getEventJOSNobj(paramContext, paramString3, paramString2, paramInt);
        if ((1 == CommonUtil.getReportPolicyMode(paramContext)) && (CommonUtil.isNetworkAvailable(paramContext))) {
            try {
                paramString2 = UmsConstants.preUrl + "/ums/postEvent";
                CommonUtil.printLog("UMSAgent", "call post method. " + paramString2);
                paramString2 = NetworkUitlity.post(paramString2, paramString1.toString());
                CommonUtil.printLog("UmsAgent", paramString2.getMsg().toString());
                if (!paramString2.isFlag()) {
                    saveInfoToFile("eventInfo", paramString1, paramContext);
                    CommonUtil.printLog("error", paramString2.getMsg());
                }
                CommonUtil.printLog("UmsAgent", "errorInfo" + paramString2.getMsg());
                return;
            } catch (Exception paramContext) {
                CommonUtil.printLog("UmsAgent", "fail to post eventContent");
                return;
            }
        }
        saveInfoToFile("eventInfo", paramString1, paramContext);
    }

    public static void saveEvent(UmsAgent paramUmsAgent, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt) {
        umsAgentEntity = paramUmsAgent;
        umsAgentEntity.saveEvent(paramContext, paramString1, paramString2, paramString3, paramInt);
    }

    public static void saveInfoToFile(String paramString, JSONObject paramJSONObject, Context paramContext) {
        JSONArray localJSONArray = new JSONArray();
        try {
            localJSONArray.put(0, paramJSONObject);
            if (handler != null) {
                paramJSONObject = new JSONObject();
                paramJSONObject.put(paramString, localJSONArray);
                handler.post(new SaveInfo(paramContext, paramJSONObject));
                return;
            }
            CommonUtil.printLog(CommonUtil.getActivityName(paramContext), "handler--null");
            return;
        } catch (JSONException paramString) {
            paramString.printStackTrace();
        }
    }

    public static void setAutoLocation(boolean paramBoolean) {
        mUseLocationService = paramBoolean;
    }

    public static void setBaseURL(String paramString) {
        UmsConstants.preUrl = paramString;
    }

    public static void setDefaultReportPolicy(Context arg0, int paramInt) {
        CommonUtil.printLog("reportType", paramInt);
        if ((paramInt == 0) || (paramInt == 1)) {
            defaultReportMode = paramInt;
            Object localObject1 =???.getPackageName();
            localObject1 =???.getSharedPreferences("ums_agent_online_setting_" + (String) localObject1, 0);
            synchronized (UmsConstants.saveOnlineConfigMutex) {
                ((SharedPreferences) localObject1).edit().putInt("ums_local_report_policy", paramInt).commit();
                return;
            }
        }
    }

    public static void setUpdateOnlyWifi(boolean paramBoolean) {
        mUpdateOnlyWifi = paramBoolean;
        CommonUtil.printLog("mUpdateOnlyWifi value", mUpdateOnlyWifi);
    }

    public static void update(Context paramContext) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.isupdate(UmsAgent.this);
            }
        };
        handler.post(paramContext);
    }

    public static void updateOnlineConfig(Context paramContext) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.updateOnlineConfigs(UmsAgent.this);
            }
        };
        handler.post(paramContext);
    }

    private static void updateOnlineConfigs(Context paramContext) {
        appkey = CommonUtil.getAppKey(paramContext);
        Object localObject1 = new JSONObject();
        try {
            ((JSONObject) localObject1).put("appkey", appkey);
            localObject2 = ((JSONObject) localObject1).toString();
            localObject1 = paramContext.getSharedPreferences("ums_agent_online_setting_" + CommonUtil.getPackageName(paramContext), 0).edit();
            if (!CommonUtil.isNetworkAvailable(paramContext)) {
                break label324;
            }
            localObject2 = NetworkUitlity.post(UmsConstants.preUrl + "/ums/getOnlineConfiguration", (String) localObject2);
        } catch (JSONException localJSONException) {
            try {
                Object localObject2;
                CommonUtil.printLog("message", ((MyMessage) localObject2).getMsg());
                if (((MyMessage) localObject2).isFlag()) {
                    localObject2 = new JSONObject(((MyMessage) localObject2).getMsg());
                    if (UmsConstants.DebugMode) {
                        CommonUtil.printLog("uploadJSON", ((JSONObject) localObject2).toString());
                    }
                    Iterator localIterator = ((JSONObject) localObject2).keys();
                    for (; ; ) {
                        if (!localIterator.hasNext()) {
                            ((SharedPreferences.Editor) localObject1).commit();
                            return;
                            localJSONException = localJSONException;
                            localJSONException.printStackTrace();
                            break;
                        }
                        String str1 = (String) localIterator.next();
                        String str2 = localJSONException.getString(str1);
                        ((SharedPreferences.Editor) localObject1).putString(str1, str2);
                        if ((str1.equals("autogetlocation")) && (!str2.equals("1"))) {
                            setAutoLocation(false);
                        }
                        if ((str1.equals("updateonlywifi")) && (!str2.equals("1"))) {
                            setUpdateOnlyWifi(false);
                        }
                        if ((str1.equals("reportpolicy")) && (str2.equals("1"))) {
                            setDefaultReportPolicy(paramContext, 1);
                        }
                        if (str1.equals("sessionmillis")) {
                            UmsConstants.kContinueSessionMillis = Integer.parseInt(str2) * 1000;
                        }
                    }
                }
                CommonUtil.printLog("error", localJSONException.getMsg());
            } catch (JSONException paramContext) {
                paramContext.printStackTrace();
                return;
            }
        }
        return;
        label324:
        CommonUtil.printLog("UMSAgent", " updateOnlineConfig network error");
    }

    private static void uploadAllLog(Context paramContext) {
        if (new File(AppCacheManager.getBaseCacheDir(paramContext) + "mobclick_agent_cached_" + paramContext.getPackageName()).exists()) {
            try {
                FileInputStream localFileInputStream = new FileInputStream(AppCacheManager.getBaseCacheDir(paramContext) + "mobclick_agent_cached_" + paramContext.getPackageName());
                StringBuffer localStringBuffer = new StringBuffer();
                byte[] arrayOfByte = new byte['က'];
                for (; ; ) {
                    int i = localFileInputStream.read(arrayOfByte);
                    if (i == -1) {
                        if (!CommonUtil.isNetworkAvailable(paramContext)) {
                            break label237;
                        }
                        if (!NetworkUitlity.post(UmsConstants.preUrl + "/ums/uploadLog", localStringBuffer).isFlag()) {
                            break;
                        }
                        new File(AppCacheManager.getBaseCacheDir(paramContext) + "mobclick_agent_cached_" + paramContext.getPackageName()).delete();
                        return;
                    }
                    localStringBuffer.append(new String(arrayOfByte, 0, i));
                }
                CommonUtil.printLog("uploadError", "uploadLog Error");
            } catch (Exception paramContext) {
                paramContext.printStackTrace();
                return;
            }
            return;
            label237:
            CommonUtil.printLog("NetworkError", "Network, not work");
        }
    }

    public static void uploadLog1(Context paramContext) {
        paramContext = new Runnable() {
            public void run() {
                UmsAgent.uploadAllLog(UmsAgent.this);
            }
        };
        handler.post(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/UmsAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
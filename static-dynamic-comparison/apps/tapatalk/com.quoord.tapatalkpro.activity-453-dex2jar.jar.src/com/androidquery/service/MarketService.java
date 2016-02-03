package com.androidquery.service;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.text.Html.TagHandler;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import java.util.Locale;

import org.json.JSONObject;
import org.xml.sax.XMLReader;

public class MarketService {
    private static final String BULLET = "•";
    public static final int MAJOR = 2;
    public static final int MINOR = 1;
    public static final int REVISION = 0;
    private static final String SKIP_VERSION = "aqs.skip";
    private static ApplicationInfo ai;
    private static PackageInfo pi;
    private Activity act;
    private AQuery aq;
    private boolean completed;
    private long expire = 720000L;
    private boolean fetch;
    private boolean force;
    private Handler handler;
    private int level = 0;
    private String locale;
    private int progress;
    private String rateUrl;
    private String updateUrl;
    private String version;

    public MarketService(Activity paramActivity) {
        this.act = paramActivity;
        this.aq = new AQuery(paramActivity);
        this.handler = new Handler(null);
        this.locale = Locale.getDefault().toString();
        this.rateUrl = getMarketUrl();
        this.updateUrl = this.rateUrl;
    }

    private Drawable getAppIcon() {
        return getApplicationInfo().loadIcon(this.act.getPackageManager());
    }

    private String getAppId() {
        return getApplicationInfo().packageName;
    }

    private ApplicationInfo getApplicationInfo() {
        if (ai == null) {
            ai = this.act.getApplicationInfo();
        }
        return ai;
    }

    private String getHost() {
        return "https://androidquery.appspot.com";
    }

    private String getMarketUrl() {
        String str = getAppId();
        return "market://details?id=" + str;
    }

    private PackageInfo getPackageInfo() {
        if (pi == null) {
        }
        try {
            pi = this.act.getPackageManager().getPackageInfo(getAppId(), 0);
            return pi;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            for (; ; ) {
                localNameNotFoundException.printStackTrace();
            }
        }
    }

    private String getQueryUrl() {
        Object localObject = getAppId();
        String str = getHost() + "/api/market?app=" + (String) localObject + "&locale=" + this.locale + "&version=" + getVersion() + "&code=" + getVersionCode() + "&aq=" + "0.26.7";
        localObject = str;
        if (this.force) {
            localObject = str + "&force=true";
        }
        return (String) localObject;
    }

    private static String getSkipVersion(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("aqs.skip", null);
    }

    private String getVersion() {
        return getPackageInfo().versionName;
    }

    private int getVersionCode() {
        return getPackageInfo().versionCode;
    }

    private boolean isActive() {
        return !this.act.isFinishing();
    }

    private static boolean openUrl(Activity paramActivity, String paramString) {
        if (paramString == null) {
            return false;
        }
        try {
            paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
            return true;
        } catch (Exception paramActivity) {
        }
        return false;
    }

    private boolean outdated(String paramString, int paramInt) {
        if (paramString.equals(getSkipVersion(this.act))) {
        }
        String str;
        int i;
        do {
            return false;
            str = getVersion();
            i = getVersionCode();
        } while ((str.equals(paramString)) || (i > paramInt));
        return requireUpdate(str, paramString, this.level);
    }

    private static String patchBody(String paramString) {
        return "<small>" + paramString + "</small>";
    }

    private boolean requireUpdate(String paramString1, String paramString2, int paramInt) {
        if (paramString1.equals(paramString2)) {
        }
        do {
            return false;
            try {
                paramString1 = paramString1.split("\\.");
                paramString2 = paramString2.split("\\.");
                if (paramString1.length < 3) {
                    break;
                }
                if (paramString2.length >= 3) {
                    break label114;
                }
            } catch (Exception paramString1) {
                boolean bool;
                AQUtility.report(paramString1);
                return true;
            }
            if (!paramString1[(paramString1.length - 1)].equals(paramString2[(paramString2.length - 1)])) {
                return true;
            }
            if (!paramString1[(paramString1.length - 2)].equals(paramString2[(paramString2.length - 2)])) {
                return true;
            }
            bool = paramString1[(paramString1.length - 3)].equals(paramString2[(paramString2.length - 3)]);
        } while (bool);
        return true;
        return true;
        label114:
        switch (paramInt) {
        }
        return true;
    }

    private static void setSkipVersion(Context paramContext, String paramString) {
        PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("aqs.skip", paramString).commit();
    }

    protected void callback(String paramString, JSONObject paramJSONObject, AjaxStatus paramAjaxStatus) {
        if (paramJSONObject == null) {
        }
        int i;
        do {
            return;
            paramString = paramJSONObject.optString("version", "0");
            i = paramJSONObject.optInt("code", 0);
            AQUtility.debug("version", getVersion() + "->" + paramString + ":" + getVersionCode() + "->" + i);
            AQUtility.debug("outdated", Boolean.valueOf(outdated(paramString, i)));
        } while ((!this.force) && (!outdated(paramString, i)));
        showUpdateDialog(paramJSONObject);
    }

    public void checkVersion() {
        Object localObject = getQueryUrl();
        AjaxCallback localAjaxCallback = new AjaxCallback();
        localObject = (AjaxCallback) ((AjaxCallback) ((AjaxCallback) localAjaxCallback.url((String) localObject)).type(JSONObject.class)).handler(this.handler, "marketCb");
        if (this.force) {
        }
        for (boolean bool = false; ; bool = true) {
            ((AjaxCallback) ((AjaxCallback) localObject).fileCache(bool)).expire(this.expire);
            ((AQuery) this.aq.progress(this.progress)).ajax(localAjaxCallback);
            return;
        }
    }

    public MarketService expire(long paramLong) {
        this.expire = paramLong;
        return this;
    }

    public MarketService force(boolean paramBoolean) {
        this.force = paramBoolean;
        return this;
    }

    public MarketService level(int paramInt) {
        this.level = paramInt;
        return this;
    }

    public MarketService locale(String paramString) {
        this.locale = paramString;
        return this;
    }

    public MarketService progress(int paramInt) {
        this.progress = paramInt;
        return this;
    }

    public MarketService rateUrl(String paramString) {
        this.rateUrl = paramString;
        return this;
    }

    protected void showUpdateDialog(JSONObject paramJSONObject) {
        if ((paramJSONObject == null) || (this.version != null)) {
        }
        while (!isActive()) {
            return;
        }
        Object localObject = paramJSONObject.optJSONObject("dialog");
        String str2 = ((JSONObject) localObject).optString("update", "Update");
        String str3 = ((JSONObject) localObject).optString("skip", "Skip");
        String str4 = ((JSONObject) localObject).optString("rate", "Rate");
        String str1 = ((JSONObject) localObject).optString("wbody", "");
        localObject = ((JSONObject) localObject).optString("title", "Update Available");
        AQUtility.debug("wbody", str1);
        this.version = paramJSONObject.optString("version", null);
        paramJSONObject = getAppIcon();
        paramJSONObject = new AlertDialog.Builder(this.act).setIcon(paramJSONObject).setTitle((CharSequence) localObject).setPositiveButton(str4, this.handler).setNeutralButton(str3, this.handler).setNegativeButton(str2, this.handler).create();
        paramJSONObject.setMessage(Html.fromHtml(patchBody(str1), null, this.handler));
        this.aq.show(paramJSONObject);
    }

    public MarketService updateUrl(String paramString) {
        this.updateUrl = paramString;
        return this;
    }

    private class Handler
            implements DialogInterface.OnClickListener, Html.TagHandler {
        private Handler() {
        }

        private void cb(String paramString, JSONObject paramJSONObject, AjaxStatus paramAjaxStatus) {
            if (!MarketService.this.completed) {
                MarketService.this.completed = true;
                MarketService.this.progress = 0;
                MarketService.this.callback(paramString, paramJSONObject, paramAjaxStatus);
            }
        }

        public void detailCb(String paramString1, String paramString2, AjaxStatus paramAjaxStatus) {
            if ((paramString2 != null) && (paramString2.length() > 1000)) {
                paramString1 = MarketService.this.getQueryUrl();
                paramAjaxStatus = new AjaxCallback();
                ((AjaxCallback) ((AjaxCallback) paramAjaxStatus.url(paramString1)).type(JSONObject.class)).handler(this, "marketCb");
                paramAjaxStatus.param("html", paramString2);
                ((AQuery) MarketService.this.aq.progress(MarketService.this.progress)).ajax(paramAjaxStatus);
            }
        }

        public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader) {
            if ("li".equals(paramString)) {
                if (paramBoolean) {
                    paramEditable.append("  ");
                    paramEditable.append("•");
                    paramEditable.append("  ");
                }
            } else {
                return;
            }
            paramEditable.append("\n");
        }

        public void marketCb(String paramString, JSONObject paramJSONObject, AjaxStatus paramAjaxStatus) {
            if (MarketService.this.act.isFinishing()) {
            }
            String str;
            do {
                return;
                if (paramJSONObject == null) {
                    break label177;
                }
                str = paramJSONObject.optString("status");
                if (!"1".equals(str)) {
                    break;
                }
                if (paramJSONObject.has("dialog")) {
                    cb(paramString, paramJSONObject, paramAjaxStatus);
                }
            }
            while ((MarketService.this.fetch) || (!paramJSONObject.optBoolean("fetch", false)) || (paramAjaxStatus.getSource() != 1));
            MarketService.this.fetch = true;
            paramString = paramJSONObject.optString("marketUrl", null);
            paramJSONObject = new AjaxCallback();
            ((AjaxCallback) ((AjaxCallback) paramJSONObject.url(paramString)).type(String.class)).handler(this, "detailCb");
            ((AQuery) MarketService.this.aq.progress(MarketService.this.progress)).ajax(paramJSONObject);
            return;
            if ("0".equals(str)) {
                paramAjaxStatus.invalidate();
                return;
            }
            cb(paramString, paramJSONObject, paramAjaxStatus);
            return;
            label177:
            cb(paramString, paramJSONObject, paramAjaxStatus);
        }

        public void onClick(DialogInterface paramDialogInterface, int paramInt) {
            switch (paramInt) {
                default:
                    return;
                case -1:
                    MarketService.openUrl(MarketService.this.act, MarketService.this.rateUrl);
                    return;
                case -2:
                    MarketService.openUrl(MarketService.this.act, MarketService.this.updateUrl);
                    return;
            }
            MarketService.setSkipVersion(MarketService.this.act, MarketService.this.version);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/service/MarketService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
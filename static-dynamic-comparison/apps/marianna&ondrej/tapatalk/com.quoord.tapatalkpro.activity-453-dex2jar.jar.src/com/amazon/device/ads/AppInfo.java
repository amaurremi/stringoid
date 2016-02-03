package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import org.json.JSONObject;

class AppInfo {
    private String applicationLabel;
    private JSONObject packageInfoUrlJSON;
    private String packageName;
    private String versionCode;
    private String versionName;

    protected AppInfo() {
    }

    public AppInfo(Context paramContext) {
        this.packageName = paramContext.getPackageName();
        Object localObject = paramContext.getPackageManager();
        this.applicationLabel = ((String) ((PackageManager) localObject).getApplicationLabel(paramContext.getApplicationInfo()));
        paramContext = null;
        try {
            localObject = ((PackageManager) localObject).getPackageInfo(this.packageName, 0);
            paramContext = (Context) localObject;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            label147:
            for (; ; ) {
            }
        }
        if (paramContext != null) {
            localObject = paramContext.versionName;
            this.versionName = ((String) localObject);
            if (paramContext == null) {
                break label147;
            }
        }
        for (paramContext = Integer.toString(paramContext.versionCode); ; paramContext = "") {
            this.versionCode = paramContext;
            this.packageInfoUrlJSON = new JSONObject();
            JSONUtils.put(this.packageInfoUrlJSON, "lbl", this.applicationLabel);
            JSONUtils.put(this.packageInfoUrlJSON, "pn", this.packageName);
            JSONUtils.put(this.packageInfoUrlJSON, "v", this.versionCode);
            JSONUtils.put(this.packageInfoUrlJSON, "vn", this.versionName);
            return;
            localObject = "";
            break;
        }
    }

    public JSONObject getPackageInfoJSON() {
        return this.packageInfoUrlJSON;
    }

    public String getPackageInfoJSONString() {
        if (this.packageInfoUrlJSON != null) {
            return this.packageInfoUrlJSON.toString();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
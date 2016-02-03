package com.facebook.ads.internal.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.AdInvalidationUtils;
import com.facebook.ads.internal.AppSiteData;
import com.facebook.ads.internal.OpenUrlTask;
import com.facebook.ads.internal.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppAdAction
        implements AdAction {
    private static final String MARKET_DETAIL_URI_FORMAT = "market://details?id=%s";
    private static final String TAG = AppAdAction.class.getSimpleName();
    private final Context context;
    private final Uri uri;

    public AppAdAction(Context paramContext, Uri paramUri) {
        this.context = paramContext;
        this.uri = paramUri;
    }

    private Intent getAppLaunchIntent(AppSiteData paramAppSiteData) {
        if (StringUtils.isNullOrEmpty(paramAppSiteData.getPackageName())) {
            return null;
        }
        if (!AdInvalidationUtils.isNativePackageInstalled(this.context, paramAppSiteData.getPackageName())) {
            return null;
        }
        Object localObject1 = paramAppSiteData.getAppLinkUri();
        if ((!StringUtils.isNullOrEmpty((String) localObject1)) && ((((String) localObject1).startsWith("tel:")) || (((String) localObject1).startsWith("telprompt:")))) {
            return new Intent("android.intent.action.CALL", Uri.parse((String) localObject1));
        }
        Object localObject2 = this.context.getPackageManager();
        if ((StringUtils.isNullOrEmpty(paramAppSiteData.getClassName())) && (StringUtils.isNullOrEmpty((String) localObject1))) {
            return ((PackageManager) localObject2).getLaunchIntentForPackage(paramAppSiteData.getPackageName());
        }
        localObject1 = getAppLinkIntentUnresolved(paramAppSiteData);
        localObject2 = ((PackageManager) localObject2).queryIntentActivities((Intent) localObject1, 65536);
        if (((Intent) localObject1).getComponent() == null) {
            Iterator localIterator = ((List) localObject2).iterator();
            while (localIterator.hasNext()) {
                ResolveInfo localResolveInfo = (ResolveInfo) localIterator.next();
                if (localResolveInfo.activityInfo.packageName.equals(paramAppSiteData.getPackageName())) {
                    ((Intent) localObject1).setComponent(new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name));
                }
            }
        }
        if ((((List) localObject2).isEmpty()) || (((Intent) localObject1).getComponent() == null)) {
            return null;
        }
        return (Intent) localObject1;
    }

    private List<Intent> getAppLaunchIntents() {
        Object localObject = getAppsiteDatas();
        ArrayList localArrayList = new ArrayList();
        if (localObject != null) {
            localObject = ((List) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                Intent localIntent = getAppLaunchIntent((AppSiteData) ((Iterator) localObject).next());
                if (localIntent != null) {
                    localArrayList.add(localIntent);
                }
            }
        }
        return localArrayList;
    }

    private Intent getAppLinkIntentUnresolved(AppSiteData paramAppSiteData) {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        if ((!StringUtils.isNullOrEmpty(paramAppSiteData.getPackageName())) && (!StringUtils.isNullOrEmpty(paramAppSiteData.getClassName()))) {
            localIntent.setComponent(new ComponentName(paramAppSiteData.getPackageName(), paramAppSiteData.getClassName()));
        }
        if (!StringUtils.isNullOrEmpty(paramAppSiteData.getAppLinkUri())) {
            localIntent.setData(Uri.parse(paramAppSiteData.getAppLinkUri()));
        }
        return localIntent;
    }

    private List<AppSiteData> getAppsiteDatas() {
        Object localObject = this.uri.getQueryParameter("appsite_data");
        if ((StringUtils.isNullOrEmpty((String) localObject)) || ("[]".equals(localObject))) {
            localObject = null;
        }
        for (; ; ) {
            return (List<AppSiteData>) localObject;
            localArrayList = new ArrayList();
            try {
                JSONArray localJSONArray = new JSONObject((String) localObject).optJSONArray("android");
                localObject = localArrayList;
                if (localJSONArray == null) {
                    continue;
                }
                int i = 0;
                for (; ; ) {
                    localObject = localArrayList;
                    if (i >= localJSONArray.length()) {
                        break;
                    }
                    localObject = AppSiteData.fromJSONObject(localJSONArray.optJSONObject(i));
                    if (localObject != null) {
                        localArrayList.add(localObject);
                    }
                    i += 1;
                }
                return localArrayList;
            } catch (JSONException localJSONException) {
                Log.w(TAG, "Error parsing appsite_data", localJSONException);
            }
        }
    }

    private Uri getMarketUri() {
        return Uri.parse(String.format("market://details?id=%s", new Object[]{this.uri.getQueryParameter("store_id")}));
    }

    private void logAdClick() {
        String str = this.uri.getQueryParameter("native_click_report_url");
        if (StringUtils.isNullOrEmpty(str)) {
            return;
        }
        new OpenUrlTask().execute(new String[]{str});
    }

    public void execute() {
        logAdClick();
        Object localObject = getAppLaunchIntents();
        Intent localIntent1;
        if (localObject != null) {
            localObject = ((List) localObject).iterator();
            if (((Iterator) localObject).hasNext()) {
                localIntent1 = (Intent) ((Iterator) localObject).next();
            }
        }
        String str;
        do {
            try {
                this.context.startActivity(localIntent1);
                return;
            } catch (Exception localException2) {
                Log.d(TAG, "Failed to open app intent, falling back", localException2);
            }
            break;
            localObject = new Intent("android.intent.action.VIEW", getMarketUri());
            try {
                this.context.startActivity((Intent) localObject);
                return;
            } catch (Exception localException1) {
                Log.d(TAG, "Failed to open market url: " + this.uri.toString(), localException1);
                str = this.uri.getQueryParameter("store_url_web_fallback");
            }
        } while ((str == null) || (str.length() <= 0));
        Intent localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
        try {
            this.context.startActivity(localIntent2);
            return;
        } catch (Exception localException3) {
            Log.d(TAG, "Failed to open fallback url: " + str, localException3);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/action/AppAdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
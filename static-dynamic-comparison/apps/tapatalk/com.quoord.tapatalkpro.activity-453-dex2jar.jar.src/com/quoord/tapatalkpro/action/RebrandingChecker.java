package com.quoord.tapatalkpro.action;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Window;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRebrandingEntryActivity;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class RebrandingChecker
        implements CallBackInterface {
    public static boolean isReset = false;
    private TapatalkJsonEngine engine = new TapatalkJsonEngine(paramIcsRebrandingEntryActivity, this);
    JSONObject jsonObject;
    private IcsRebrandingEntryActivity mContext;
    private SharedPreferences prefs;
    String rebrandingCacheUrl;
    public RebrandingConfig rebrandingConfig;

    public RebrandingChecker(IcsRebrandingEntryActivity paramIcsRebrandingEntryActivity) {
        this.mContext = paramIcsRebrandingEntryActivity;
        this.prefs = Prefs.get(this.mContext);
        this.rebrandingCacheUrl = AppCacheManager.getRebrandingUrl(this.mContext);
        if (AppCacheManager.checkFile(this.rebrandingCacheUrl)) {
        }
        for (; ; ) {
            try {
                this.rebrandingConfig = ((RebrandingConfig) AppCacheManager.getCacheData(this.rebrandingCacheUrl));
                i = 0;
                if (i < this.rebrandingConfig.getOrder().size()) {
                    continue;
                }
                startApp();
                isReset = false;
            } catch (Exception localException) {
                int i;
                TabItem localTabItem;
                isReset = true;
                continue;
            }
            this.prefs = Prefs.get(paramIcsRebrandingEntryActivity);
            paramIcsRebrandingEntryActivity = "https://directory.tapatalk.com/get_branded.php?app_type=android&bid=" + TapatalkApp.rebranding_id + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mContext));
            this.engine.call(paramIcsRebrandingEntryActivity);
            return;
            localTabItem = (TabItem) this.rebrandingConfig.getOrder().get(i);
            localTabItem.setDrawable(this.mContext, localTabItem.getName(), localTabItem.getDisplay_name(), localTabItem.getValue(), localTabItem.isSelected());
            i += 1;
        }
    }

    private void parseResult(JSONObject paramJSONObject) {
        Object localObject = new ArrayList();
        int i;
        try {
            this.rebrandingConfig = new RebrandingConfig();
            this.rebrandingConfig.setExt(paramJSONObject.getString("ext"));
            this.rebrandingConfig.setFolder(paramJSONObject.getString("mobiquo_dir"));
            this.rebrandingConfig.setGAId(paramJSONObject.getString("ga_id"));
            this.rebrandingConfig.setAdmobId(paramJSONObject.getString("admob_id"));
            this.rebrandingConfig.setDfp_320x50(paramJSONObject.getString("dfp_320x50"));
            this.rebrandingConfig.setDfp_300x250(paramJSONObject.getString("dfp_300x250"));
            this.rebrandingConfig.setVigLinkId(paramJSONObject.getString("viglink"));
            this.rebrandingConfig.setSkimId(paramJSONObject.getString("skimlinks_publisher_id"));
            this.rebrandingConfig.setInterstitials(paramJSONObject.getString("admob_interstitials"));
            if (paramJSONObject.getString("powered_by").equals("0")) {
                this.rebrandingConfig.setShowPoweredBy(false);
            }
            JSONArray localJSONArray;
            for (; ; ) {
                this.rebrandingConfig.setCms_url(paramJSONObject.getString("cms_url"));
                if (paramJSONObject.has("tab_order")) {
                    localJSONArray = paramJSONObject.getJSONArray("tab_order");
                    i = 0;
                    if (i < localJSONArray.length()) {
                        break;
                    }
                    this.rebrandingConfig.setOrder((ArrayList) localObject);
                }
                localObject = this.prefs.edit();
                ((SharedPreferences.Editor) localObject).putString("android_api_key", paramJSONObject.getString("android_api_key"));
                ((SharedPreferences.Editor) localObject).commit();
                if ((paramJSONObject.has("purchase")) && (paramJSONObject.get("purchase").equals("0"))) {
                    this.rebrandingConfig.setPurcahse(false);
                    new AlertDialog.Builder(this.mContext).setTitle("Invalid License").setMessage("This forum is currently not available on this app. Please contact the forum administrator.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            RebrandingChecker.this.mContext.finish();
                        }
                    }).create().show();
                }
                if ((paramJSONObject.has("usergroup_ids")) && (paramJSONObject.getString("usergroup_ids").length() > 0)) {
                    paramJSONObject.getString("usergroup_ids").split(",");
                }
                if ((TapatalkApp.ics_default_color == null) || (TapatalkApp.ics_default_color.equals(""))) {
                    return;
                }
                paramJSONObject = this.prefs.edit();
                paramJSONObject.putString("primary_color", TapatalkApp.ics_default_color);
                paramJSONObject.putString("second_color", TapatalkApp.ics_default_color);
                paramJSONObject.putString("third_color", TapatalkApp.ics_default_color);
                paramJSONObject.commit();
                return;
                this.rebrandingConfig.setShowPoweredBy(true);
            }
            localJSONObject = (JSONObject) localJSONArray.get(i);
        } catch (Exception paramJSONObject) {
            paramJSONObject.printStackTrace();
            return;
        }
        JSONObject localJSONObject;
        if (localJSONObject.getString("is_default").equals("0")) {
        }
        for (boolean bool = false; ; bool = true) {
            ((ArrayList) localObject).add(new TabItem(this.mContext, localJSONObject.getString("name"), localJSONObject.getString("display_name"), localJSONObject.getString("value"), bool));
            i += 1;
            break;
        }
    }

    private void startApp() {
        if (this.mContext.getResources().getBoolean(2131558406)) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    try {
                        RebrandingChecker.this.mContext.setContentView(2130903112);
                        RebrandingChecker.this.mContext.getWindow().clearFlags(1024);
                        RebrandingChecker.this.mContext.bar.show();
                        RebrandingChecker.this.mContext.showAllInOneFirstFragment();
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }, 1000L);
            return;
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                RebrandingChecker.this.startSingleBYO();
            }
        }, 1000L);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        try {
            paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
            int i = 0;
            if (this.rebrandingConfig == null) {
                i = 1;
            }
            parseResult(paramEngineResponse);
            if (i != 0) {
                startApp();
            }
            AppCacheManager.cacheData(this.rebrandingCacheUrl, this.rebrandingConfig);
            return;
        } catch (Exception paramEngineResponse) {
            paramEngineResponse.printStackTrace();
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void startSingleBYO() {
        Object localObject1 = new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        Object localObject2 = new TapatalkForum();
        ArrayList localArrayList = ((FavoriateSqlHelper) localObject1).getFavrivate();
        localObject1 = localObject2;
        int i;
        if (localArrayList != null) {
            localObject1 = localObject2;
            if (localArrayList.size() > 0) {
                i = 0;
            }
        }
        for (localObject1 = localObject2; ; localObject1 = localObject2) {
            if (i >= localArrayList.size()) {
                localObject2 = localObject1;
                if (((TapatalkForum) localObject1).getUrl() == null) {
                    localObject2 = new TapatalkForum();
                    ((TapatalkForum) localObject2).setUrl(TapatalkApp.rebranding_url);
                    ((TapatalkForum) localObject2).setId(Integer.valueOf(0));
                    ((TapatalkForum) localObject2).setName(TapatalkApp.rebranding_name);
                }
                Intent localIntent = new Intent();
                localIntent.setClass(this.mContext, SlidingMenuActivity.class);
                localIntent.putExtra("forum", (Serializable) localObject2);
                String str = this.mContext.getIntent().getStringExtra("shortcutURL");
                localArrayList = null;
                localObject1 = localArrayList;
                if (((TapatalkForum) localObject2).getUserName() != null) {
                    localObject1 = localArrayList;
                    if (((TapatalkForum) localObject2).getPassword() == null) {
                        localObject1 = ((TapatalkForum) localObject2).getUserName();
                    }
                }
                ForumStatus.initialForumStatus(this.mContext, (TapatalkForum) localObject2, (String) localObject1, str).setRebrandingConfig(this.rebrandingConfig);
                localIntent.putExtra("rebrandingConfig", this.rebrandingConfig);
                localIntent.putExtra("shouldLogin", false);
                this.mContext.startActivity(localIntent);
                this.mContext.finish();
                this.mContext.overridePendingTransition(0, 0);
                return;
            }
            localObject2 = localObject1;
            if (((TapatalkForum) localArrayList.get(i)).getUserName() != null) {
                localObject2 = localObject1;
                if (((TapatalkForum) localArrayList.get(i)).getUserName().length() > 0) {
                    localObject2 = localObject1;
                    if (((TapatalkForum) localArrayList.get(i)).hasPassword()) {
                        localObject2 = (TapatalkForum) localArrayList.get(i);
                    }
                }
            }
            i += 1;
        }
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/RebrandingChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
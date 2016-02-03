package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CmsUrlWordPressSupportAction
        implements CallBackInterface {
    private CmsUrlInterface cmsUrlInterface;
    private TapatalkJsonEngine engine;
    private ForumStatus forumStatus;
    private SharedPreferences prefs;

    public CmsUrlWordPressSupportAction(Activity paramActivity, String paramString, ForumStatus paramForumStatus, CmsUrlInterface paramCmsUrlInterface) {
        this.cmsUrlInterface = paramCmsUrlInterface;
        this.forumStatus = paramForumStatus;
        this.engine = new TapatalkJsonEngine(paramActivity, this);
        this.prefs = Prefs.get(paramActivity);
        paramActivity = new SimpleDateFormat("yyyy-MM-dd");
        for (; ; ) {
            try {
                boolean bool2 = Util.DateCompareTheDayUpdate(paramActivity.format(new Date()), this.prefs.getString("get_cmsurl_config_time", ""), 1);
                if ((this.prefs.getInt(this.forumStatus.tapatalkForum.getId() + "|is_support_cmsurl_config", -1) == -1) || (bool2)) {
                    this.engine.call(paramString + "?tapatalk=config");
                    paramString = this.prefs.edit();
                    paramString.putString("get_cmsurl_config_time", paramActivity.format(new Date()));
                    paramString.commit();
                    return;
                }
                paramActivity = this.cmsUrlInterface;
                if (this.prefs.getInt(this.forumStatus.tapatalkForum.getId() + "|is_support_cmsurl_config", -1) == 1) {
                    paramActivity.cmsUrlCallback(bool1);
                    return;
                }
            } catch (Exception paramActivity) {
                paramActivity.printStackTrace();
                return;
            }
            bool1 = false;
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse == null) {
            return;
        }
        SharedPreferences.Editor localEditor = this.prefs.edit();
        if (paramEngineResponse.isSuccess()) {
            localEditor.putInt(this.forumStatus.tapatalkForum.getId() + "|is_support_cmsurl_config", 1);
        }
        for (; ; ) {
            localEditor.commit();
            this.cmsUrlInterface.cmsUrlCallback(paramEngineResponse.isSuccess());
            return;
            localEditor.putInt(this.forumStatus.tapatalkForum.getId() + "|is_support_cmsurl_config", 0);
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface CmsUrlInterface {
        public abstract void cmsUrlCallback(boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/CmsUrlWordPressSupportAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
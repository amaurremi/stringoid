package com.quoord.tapatalkpro.action;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.google.android.gcm.GCMRegistrar;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import org.json.JSONException;
import org.json.JSONObject;

public class LogNewLogin
        implements CallBackInterface {
    ForumStatus forumStatus;
    Context mContext;

    public LogNewLogin(Context paramContext, ForumStatus paramForumStatus) {
        this.mContext = paramContext;
        this.forumStatus = paramForumStatus;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
        try {
            if (paramEngineResponse.getString("result").equalsIgnoreCase("1")) {
                Prefs.get(this.mContext).edit().putBoolean("lognewlogin|" + this.forumStatus.getForumId(), true).commit();
            }
            return;
        } catch (JSONException paramEngineResponse) {
            paramEngineResponse.printStackTrace();
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void log() {
        if ((!Prefs.get(this.mContext).getBoolean("lognewlogin|" + this.forumStatus.getForumId(), false)) && (this.forumStatus.isLogin()) && (this.mContext.getResources().getBoolean(2131558401))) {
            Prefs.get(this.mContext).edit().putString("byo-uid", this.forumStatus.tapatalkForum.getUserId()).commit();
            for (; ; ) {
                String str;
                Object localObject3;
                try {
                    GCMRegistrar.checkDevice(this.mContext);
                    GCMRegistrar.checkManifest(this.mContext);
                    str = GCMRegistrar.getRegistrationId(this.mContext);
                    if (str.equals("")) {
                        GCMRegistrar.register(this.mContext, new String[]{"608452217441"});
                        return;
                    }
                    if (GCMRegistrar.isRegisteredOnServer(this.mContext)) {
                        break;
                    }
                    long l = System.currentTimeMillis();
                    Prefs.get(this.mContext).getLong("last_register_token_time", 0L);
                    localObject3 = null;
                    if (this.mContext.getResources().getBoolean(2131558406)) {
                        Object localObject1 = localObject3;
                        if (this.forumStatus.tapatalkForum.getId() != null) {
                            localObject1 = localObject3;
                            if (!this.forumStatus.tapatalkForum.getId().equals("")) {
                                localObject1 = localObject3;
                                if (this.forumStatus.tapatalkForum.getUserId() != null) {
                                    localObject1 = localObject3;
                                    if (!this.forumStatus.tapatalkForum.getUserId().equals("")) {
                                        localObject1 = TapatalkJsonEngine.REGIEST_RB + "?" + "token=" + str + "&aid=" + TapatalkApp.rebranding_aid + "&uid=" + this.forumStatus.tapatalkForum.getUserId() + "&fid=" + this.forumStatus.tapatalkForum.getId();
                                    }
                                }
                            }
                        }
                        TapatalkJsonEngine.callLogin(this.mContext, (String) localObject1);
                        Prefs.get(this.mContext).edit().putLong("last_register_token_time", Long.valueOf(l).longValue()).commit();
                        return;
                    }
                } catch (Exception localException) {
                    localException.printStackTrace();
                    return;
                }
                Object localObject2 = localObject3;
                if (this.forumStatus.tapatalkForum.getUserId() != null) {
                    localObject2 = localObject3;
                    if (!this.forumStatus.tapatalkForum.getUserId().equals("")) {
                        localObject2 = TapatalkJsonEngine.REGIEST_RB + "?" + "token=" + str + "&aid=" + TapatalkApp.rebranding_aid + "&uid=" + this.forumStatus.tapatalkForum.getUserId();
                    }
                }
            }
        }
    }

    public void reset() {
        Prefs.get(this.mContext).edit().putBoolean("lognewlogin|" + this.forumStatus.getForumId(), false).commit();
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/LogNewLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
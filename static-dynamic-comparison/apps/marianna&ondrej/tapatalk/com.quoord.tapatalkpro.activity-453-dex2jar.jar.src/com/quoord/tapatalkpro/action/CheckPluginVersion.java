package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import org.json.JSONObject;

public class CheckPluginVersion
        implements CallBackInterface {
    private TapatalkJsonEngine engine = new TapatalkJsonEngine(paramActivity, this);
    private ForumStatus forumStatus;
    JSONObject jsonObject;
    private Activity mContext;
    private SharedPreferences prefs;

    public CheckPluginVersion(ForumStatus paramForumStatus, Activity paramActivity) {
        this.forumStatus = paramForumStatus;
        this.mContext = paramActivity;
        this.prefs = Prefs.get(this.mContext);
        if (paramForumStatus.tapatalkForum != null) {
            long l = this.prefs.getLong("last_checkplugin_time" + paramForumStatus.tapatalkForum.getId(), 0L);
            if ((System.currentTimeMillis() - l) / 86400000L >= 30L) {
                paramForumStatus = TapatalkJsonEngine.CHECK_PLUGIN_VERSION + "?version=" + paramForumStatus.tapatalkForum.getVersion();
                this.engine.call(paramForumStatus);
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        try {
            if (Boolean.valueOf(paramEngineResponse.isSuccess()).booleanValue()) {
                SharedPreferences.Editor localEditor = this.prefs.edit();
                localEditor.putLong("last_checkplugin_time" + this.forumStatus.tapatalkForum.getId(), System.currentTimeMillis());
                localEditor.commit();
                if (((JSONObject) paramEngineResponse.getResponse()).get("result").toString().equalsIgnoreCase("false")) {
                    paramEngineResponse = new AlertDialog.Builder(this.mContext);
                    paramEngineResponse.setMessage(this.mContext.getString(2131100456));
                    paramEngineResponse.setPositiveButton(this.mContext.getResources().getString(2131099792), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            paramAnonymousDialogInterface.dismiss();
                        }
                    });
                    paramEngineResponse.create().show();
                }
            }
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

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/CheckPluginVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
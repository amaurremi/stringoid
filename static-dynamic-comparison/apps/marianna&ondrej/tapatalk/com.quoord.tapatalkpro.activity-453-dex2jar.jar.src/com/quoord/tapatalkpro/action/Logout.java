package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRebrandingEntryActivity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;

public class Logout
        implements TryTwiceCallBackInterface {
    private Activity context;
    private TapatalkEngine engine = null;

    public Logout(ForumStatus paramForumStatus, Activity paramActivity) {
        this.context = paramActivity;
        this.engine = new TapatalkEngine(this, paramForumStatus, paramActivity);
        paramForumStatus.setLogin(false);
        ArrayList localArrayList = new ArrayList();
        setOpCancel(false);
        doLogout(paramForumStatus.tapatalkForum, paramActivity);
        this.engine.call("logout_user", localArrayList);
    }

    public static void begin(TapatalkForum paramTapatalkForum, Activity paramActivity) {
        doLogout(paramTapatalkForum, paramActivity);
    }

    private static void doLogout(TapatalkForum paramTapatalkForum, Activity paramActivity) {
        Util.clearSigninForum(paramActivity, paramTapatalkForum, TapatalkIdFactory.getTapatalkId(paramActivity).getAuid());
        String str1 = paramTapatalkForum.getUrl();
        String str2 = paramTapatalkForum.getId().toString();
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramActivity).edit();
        localEditor.remove(str1 + "|username");
        localEditor.remove(str1 + "|password");
        localEditor.remove(str1 + "|inbox");
        localEditor.remove(str1 + "|outbox");
        localEditor.remove(str2 + "|username");
        localEditor.remove(str2 + "|password");
        localEditor.remove(paramTapatalkForum.getId().toString() + "|inbox");
        localEditor.remove(paramTapatalkForum.getId().toString() + "|outbox");
        localEditor.remove(paramTapatalkForum.getId().toString() + "|last_visit_time");
        localEditor.commit();
        AppCacheManager.del(AppCacheManager.getCookieCacheUrl(paramActivity, paramTapatalkForum.getUrl(), paramTapatalkForum.getCacheUsernameDir()));
        AppCacheManager.clearForumCache(paramActivity, str1);
        paramTapatalkForum.setPassword(null);
        paramTapatalkForum.setRawPassword(null);
        new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).saveFavoriate(paramTapatalkForum);
        Util.signOutForum(paramActivity, paramTapatalkForum);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        ((SlidingMenuActivity) this.context).closeProgress();
        ((SlidingMenuActivity) this.context).clearStack();
        paramEngineResponse = new Intent();
        if (this.context.getResources().getBoolean(2131558401)) {
            paramEngineResponse.setClass(this.context, IcsRebrandingEntryActivity.class);
            paramEngineResponse.setFlags(67108864);
        }
        for (; ; ) {
            this.context.startActivity(paramEngineResponse);
            ((SlidingMenuActivity) this.context).finish();
            return;
            paramEngineResponse.setClass(this.context, AccountEntryActivity.class);
            paramEngineResponse.setFlags(67108864);
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/Logout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.quoord.tapatalkpro.action.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.quoord.tapatalkpro.action.GetUserInfoAction;
import com.quoord.tapatalkpro.action.GetUserInfoAction.UserInfoBack;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

public class LogNewSession {
    public Context context;
    public ForumStatus forumStatus;

    public LogNewSession(Context paramContext, ForumStatus paramForumStatus) {
        this.context = paramContext;
        this.forumStatus = paramForumStatus;
    }

    private void logAfterCheck(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        int j = 1;
        TapatalkForum localTapatalkForum = this.forumStatus.tapatalkForum;
        Object localObject1;
        Object localObject2;
        if (paramBoolean3) {
            i = 0;
            localObject1 = TapatalkJsonEngine.NEW_SESSION + "?device_id=" + Util.getMD5(Util.getMacAddress(this.context)) + "&device_type=" + Util.getDeviceName() + "&fid=" + localTapatalkForum.getId() + "&is_member=" + i;
            if ((localTapatalkForum.getUserId() == null) || (localTapatalkForum.getUserId().equals("")) || (localTapatalkForum.getUserId().equals("0"))) {
                break label371;
            }
            localObject2 = localObject1 + "&user_id=" + localTapatalkForum.getUserId();
            label153:
            localObject1 = localObject2;
            if (localTapatalkForum.getUserName() != null) {
                localObject1 = localObject2;
                if (!localTapatalkForum.getUserNameOrDisplayName().equals("")) {
                    localObject1 = localObject2 + "&username=" + localTapatalkForum.getUserNameOrDisplayName();
                }
            }
            localObject2 = localObject1;
            if (paramBoolean1) {
                localObject1 = new StringBuilder(String.valueOf(localObject1)).append("&register=");
                if (!paramBoolean1) {
                    break label396;
                }
                i = 1;
                label246:
                localObject2 = i;
            }
            localObject1 = localObject2;
            if (paramBoolean2) {
                localObject1 = new StringBuilder(String.valueOf(localObject2)).append("&new_login=");
                if (!paramBoolean2) {
                    break label402;
                }
            }
        }
        label371:
        label396:
        label402:
        for (int i = j; ; i = 0) {
            localObject1 = i;
            localObject1 = localObject1 + "&version=" + Util.getVersionCode(this.context);
            TapatalkJsonEngine.callLogin(this.context, (String) localObject1);
            return;
            if (Util.isLoginedUser(this.context, localTapatalkForum)) {
            }
            for (i = 1; ; i = 0) {
                break;
            }
            localObject2 = localObject1 + "&user_id=0";
            break label153;
            i = 0;
            break label246;
        }
    }

    public void log(final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3) {
        try {
            if (this.context.getResources().getBoolean(2131558401)) {
                return;
            }
            if ((this.forumStatus.getUserId() == null) || (this.forumStatus.getUserId().equals(""))) {
                Object localObject = Prefs.get(this.context);
                long l1 = ((SharedPreferences) localObject).getLong("fourm_uid_stored_time_" + this.forumStatus.tapatalkForum.getId(), 0L);
                long l2 = System.currentTimeMillis();
                int i = 0;
                if (l2 - l1 > 604800000L) {
                    i = 1;
                    localObject = ((SharedPreferences) localObject).edit();
                    ((SharedPreferences.Editor) localObject).putLong("fourm_uid_stored_time_" + this.forumStatus.tapatalkForum.getId(), l2);
                    ((SharedPreferences.Editor) localObject).commit();
                }
                if (i != 0) {
                    new GetUserInfoAction(this.context, this.forumStatus).getUserInfo(this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), null, new GetUserInfoAction.UserInfoBack() {
                        public void userInfoBack(User paramAnonymousUser) {
                            LogNewSession.this.forumStatus.tapatalkForum.setUserId(paramAnonymousUser.getId());
                            LogNewSession.this.logAfterCheck(paramBoolean1, paramBoolean2, paramBoolean3);
                        }
                    });
                    return;
                }
                logAfterCheck(paramBoolean1, paramBoolean2, paramBoolean3);
                return;
            }
        } catch (Exception localException) {
            localException.printStackTrace();
            return;
        }
        logAfterCheck(paramBoolean1, paramBoolean2, paramBoolean3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/log/LogNewSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
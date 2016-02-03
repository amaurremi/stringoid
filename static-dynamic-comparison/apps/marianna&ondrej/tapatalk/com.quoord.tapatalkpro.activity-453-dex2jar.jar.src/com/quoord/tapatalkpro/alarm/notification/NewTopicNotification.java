package com.quoord.tapatalkpro.alarm.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;

import java.util.ArrayList;

public class NewTopicNotification
        extends BaseNotification {
    public static String ACTION = "viewnewtopic";
    public static ArrayList<String> mList = new ArrayList();

    public static Notification getNewNotification(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        if (mList == null) {
            mList = new ArrayList();
        }
        Intent localIntent = new Intent();
        paramString4 = new Topic();
        paramString4.setNewPost(true);
        paramString4.setId(paramString2);
        if (paramString5 != null) {
            paramString4.setPostId(paramString5);
        }
        localIntent.putExtra("push_count", paramInt);
        localIntent.putExtra("topic", paramString4);
        localIntent.putExtra("spkey", paramString6);
        localIntent.putExtra("notification", true);
        localIntent.putExtra("forum", paramTapatalkForum);
        localIntent.putExtra("viewsubscribe", true);
        localIntent.putExtra("forumId", paramTapatalkForum.getId());
        localIntent.setClass(paramContext, SlidingMenuActivity.class);
        localIntent.setAction(ACTION + new StringBuilder(String.valueOf(paramTapatalkForum.getName())).append(paramString2).toString().hashCode());
        localIntent.setFlags(32768);
        if (paramInt > 1) {
        }
        for (paramString4 = paramString1 + " " + paramContext.getString(2131100387) + " " + paramString3; ; paramString4 = paramContext.getString(2131100387)) {
            return getNotification(paramContext, paramInt, paramString4, paramTapatalkForum, mList, localIntent, paramString6, paramString2, paramString1, paramString3);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/NewTopicNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
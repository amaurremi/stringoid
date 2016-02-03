package com.quoord.tapatalkpro.alarm.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;

import java.util.ArrayList;

public class SubscribeNotification
        extends BaseNotification {
    public static String ACTION = "viewsubscribe";
    public static ArrayList<String> mList = new ArrayList();

    public static Notification getSubscribeNotification(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        if (mList == null) {
            mList = new ArrayList();
        }
        Intent localIntent = new Intent();
        if (paramInt == 1) {
            paramString4 = new Topic();
            paramString4.setNewPost(true);
            paramString4.setId(paramString2);
            paramString4.setSubscribe(true);
            if (paramString5 != null) {
                paramString4.setPostId(paramString5);
            }
            localIntent.putExtra("topic", paramString4);
        }
        localIntent.putExtra("push_count", paramInt);
        localIntent.setClass(paramContext, SlidingMenuActivity.class);
        localIntent.putExtra("spkey", paramString6);
        localIntent.putExtra("notification", true);
        localIntent.putExtra("forum", paramTapatalkForum);
        localIntent.putExtra("viewsubscribe", true);
        localIntent.putExtra("forumId", paramTapatalkForum.getId());
        if (paramString5 != null) {
            localIntent.putExtra("post_id", paramString5);
            localIntent.putExtra("getPost", true);
        }
        localIntent.setAction(ACTION + new StringBuilder(String.valueOf(paramTapatalkForum.getName())).append(paramString2).toString().hashCode());
        localIntent.setFlags(32768);
        if (paramInt > 1) {
        }
        for (paramString4 = paramString1 + " " + paramContext.getString(2131100385) + " " + paramString3; ; paramString4 = paramContext.getString(2131100385)) {
            return getNotification(paramContext, paramInt, paramString4, paramTapatalkForum, mList, localIntent, paramString6, paramString2, paramString1, paramString3);
        }
    }

    public static void notifySubscribeTopicNotification(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, int paramInt, Uri paramUri, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {
        paramInt -= 1;
        paramUri = paramContext.getSharedPreferences("notificationsetting", 0);
        if ((paramTapatalkForum != null) && (paramUri.getBoolean(paramTapatalkForum.getId() + "sub", true)) && (paramUri.getBoolean(paramTapatalkForum.getId() + "notification", true))) {
            paramUri = paramTapatalkForum.getId() + "notification";
            if (paramInt <= 0) {
                break label148;
            }
        }
        label148:
        for (paramTapatalkForum = getSubscribeNotification(paramContext, paramTapatalkForum, paramString1, paramInt + 1, paramString2, paramString4, null, null, paramUri); ; paramTapatalkForum = getSubscribeNotification(paramContext, paramTapatalkForum, paramString1, paramInt + 1, paramString2, paramString4, null, null, paramUri)) {
            ((NotificationManager) paramContext.getSystemService("notification")).notify(paramUri.hashCode(), paramTapatalkForum);
            return;
        }
    }

    public static void notifySubscribeTopicNotifycation(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        paramIntent.getExtras().getString("uid");
        String str1 = paramIntent.getExtras().getString("author");
        String str4 = paramIntent.getExtras().getString("fid");
        String str2 = paramIntent.getExtras().getString("title");
        String str3 = paramIntent.getExtras().getString("did");
        paramIntent = paramIntent.getExtras().getString("pid");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str4);
        Object localObject = Prefs.get(paramContext).getString("tapatalk_ringtone", "content://settings/system/notification_sound");
        int i;
        if (localObject == null) {
            localObject = paramContext.getSharedPreferences("notificationsetting", 0);
            if ((localTapatalkForum != null) && (((SharedPreferences) localObject).getBoolean(localTapatalkForum.getId() + "sub", true)) && (((SharedPreferences) localObject).getBoolean(str4 + "notification", true))) {
                str4 = str4 + "notification";
                i = paramSharedPreferences.getInt(str4, 0);
                if (i <= 0) {
                    break label305;
                }
            }
        }
        label305:
        for (paramIntent = getSubscribeNotification(paramContext, localTapatalkForum, str1, i + 1, str3, str2, null, paramIntent, str4); ; paramIntent = getSubscribeNotification(paramContext, localTapatalkForum, str1, i + 1, str3, str2, null, paramIntent, str4)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str4, i + 1);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str4.hashCode(), paramIntent);
            return;
            Uri.parse((String) localObject);
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/SubscribeNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
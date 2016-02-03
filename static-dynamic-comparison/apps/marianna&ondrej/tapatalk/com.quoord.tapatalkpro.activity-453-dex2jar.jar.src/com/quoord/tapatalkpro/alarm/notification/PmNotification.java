package com.quoord.tapatalkpro.alarm.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;

import java.io.Serializable;
import java.util.ArrayList;

public class PmNotification
        extends BaseNotification {
    public static String ACTION = "viewprivatemessage";
    public static ArrayList<String> mList = new ArrayList();

    public static Notification getPmNotification(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
        if (mList == null) {
            mList = new ArrayList();
        }
        Intent localIntent = new Intent();
        if (paramInt == 1) {
            localObject = new PrivateMessage();
            ((PrivateMessage) localObject).setMsgid(paramString2);
            localIntent.putExtra("pm", (Serializable) localObject);
        }
        localIntent.putExtra("push_count", paramInt);
        localIntent.putExtra("fid", paramTapatalkForum.getId());
        localIntent.setClass(paramContext, SlidingMenuActivity.class);
        localIntent.putExtra("notification", true);
        localIntent.putExtra("spkey", paramString4);
        localIntent.putExtra("forum", paramTapatalkForum);
        localIntent.putExtra("viewpm", true);
        localIntent.putExtra("forumId", paramTapatalkForum.getId());
        localIntent.setAction(ACTION + new StringBuilder(String.valueOf(paramTapatalkForum.getName())).append(paramTapatalkForum.getUserName()).append(paramString2).toString().hashCode());
        localIntent.setFlags(32768);
        if (paramInt > 1) {
        }
        for (Object localObject = paramString1 + " " + paramContext.getString(2131100374) + " " + paramString3; ; localObject = paramContext.getString(2131100374)) {
            return getNotification(paramContext, paramInt, (String) localObject, paramTapatalkForum, mList, localIntent, paramString4, paramString2, paramString1, paramString3);
        }
    }

    public static void notifyPmNotification(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        String str2 = paramIntent.getExtras().getString("author");
        String str1 = paramIntent.getExtras().getString("fid");
        String str3 = paramIntent.getExtras().getString("title");
        paramIntent = paramIntent.getExtras().getString("did");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str1);
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("notificationsetting", 0);
        int i;
        if ((localTapatalkForum != null) && (localSharedPreferences.getBoolean(localTapatalkForum.getId() + "pm", true)) && (localSharedPreferences.getBoolean(str1 + "notification", true))) {
            str1 = str1 + "notification";
            i = paramSharedPreferences.getInt(str1, 0);
            if (i <= 0) {
                break label253;
            }
        }
        label253:
        for (paramIntent = getPmNotification(paramContext, localTapatalkForum, str2, i + 1, paramIntent, str3, str1); ; paramIntent = getPmNotification(paramContext, localTapatalkForum, str2, i + 1, paramIntent, str3, str1)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str1, paramIntent.number);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str1.hashCode(), paramIntent);
            return;
        }
    }

    public static void notifyPmNotification(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
        paramString3 = paramContext.getSharedPreferences("notificationsetting", 0);
        if ((paramTapatalkForum != null) && (paramString3.getBoolean(paramTapatalkForum.getId() + "pm", true))) {
            paramString3 = paramTapatalkForum.getId() + "notification";
            if (paramInt <= 0) {
                break label109;
            }
        }
        label109:
        for (paramTapatalkForum = getPmNotification(paramContext, paramTapatalkForum, paramString1, paramInt + 1, paramString2, paramString4, paramString3); ; paramTapatalkForum = getPmNotification(paramContext, paramTapatalkForum, paramString1, paramInt + 1, paramString2, paramString4, paramString3)) {
            ((NotificationManager) paramContext.getSystemService("notification")).notify(paramString3.hashCode(), paramTapatalkForum);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/PmNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
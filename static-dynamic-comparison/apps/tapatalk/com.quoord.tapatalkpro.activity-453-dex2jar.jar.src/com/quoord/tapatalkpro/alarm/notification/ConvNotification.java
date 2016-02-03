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
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;

import java.util.ArrayList;

public class ConvNotification
        extends BaseNotification {
    public static String ACTION = "viewconv";
    public static ArrayList<String> mList = new ArrayList();

    public static Notification getConvNotification(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, int paramInt1, Uri paramUri, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5) {
        if (mList == null) {
            mList = new ArrayList();
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("forum", paramTapatalkForum);
        localIntent.putExtra("viewConvos", true);
        if (paramInt1 == 1) {
            paramUri = new Conversation();
            paramUri.setConv_id(paramString2);
            localIntent.putExtra("conversation", paramUri);
        }
        localIntent.putExtra("push_count", paramInt1);
        localIntent.setClass(paramContext, SlidingMenuActivity.class);
        localIntent.putExtra("spkey", paramString5);
        localIntent.putExtra("notification", true);
        localIntent.putExtra("forumId", paramTapatalkForum.getId());
        localIntent.setAction(ACTION + new StringBuilder(String.valueOf(paramTapatalkForum.getName())).append(paramString3).append(paramString2).toString().hashCode());
        localIntent.setFlags(32768);
        if (paramInt2 > 1) {
            if (paramInt1 > 1) {
                paramUri = paramString1 + " " + paramContext.getString(2131100390) + " " + paramString4;
            }
        }
        for (; ; ) {
            return getNotification(paramContext, paramInt1, paramUri, paramTapatalkForum, mList, localIntent, paramString5, paramString2, paramString1, paramString4);
            paramUri = paramContext.getString(2131100390);
            continue;
            if (paramInt1 > 1) {
                paramUri = paramString1 + " " + paramContext.getString(2131100389) + " " + paramString4;
            } else {
                paramUri = paramContext.getString(2131100389);
            }
        }
    }

    public static void getConvNotification(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, int paramInt1, Uri paramUri, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt2) {
        paramString3 = paramContext.getSharedPreferences("notificationsetting", 0);
        if ((paramTapatalkForum != null) && (paramString3.getBoolean(paramTapatalkForum.getId() + "conversation", true))) {
            paramString3 = paramTapatalkForum.getId() + "notification";
            paramInt1 -= 1;
            if (paramInt1 <= 0) {
                break label129;
            }
        }
        label129:
        for (paramTapatalkForum = getConvNotification(paramContext, paramTapatalkForum, paramString1, paramInt1 + 1, null, paramBoolean, paramString2, paramTapatalkForum.getUserName(), paramString4, paramInt2, paramString3); ; paramTapatalkForum = getConvNotification(paramContext, paramTapatalkForum, paramString1, paramInt1 + 1, paramUri, paramBoolean, paramString2, paramTapatalkForum.getUserName(), paramString4, paramInt2, paramString3)) {
            paramTapatalkForum.number = (paramInt1 + 1);
            ((NotificationManager) paramContext.getSystemService("notification")).notify(paramString3.hashCode(), paramTapatalkForum);
            return;
        }
    }

    public static void notifyConversationNotification(Context paramContext, Intent paramIntent, SharedPreferences paramSharedPreferences) {
        String str1 = paramIntent.getExtras().getString("author");
        String str4 = paramIntent.getExtras().getString("fid");
        String str2 = paramIntent.getExtras().getString("title");
        String str3 = paramIntent.getExtras().getString("did");
        String str5 = paramIntent.getExtras().getString("pid");
        TapatalkForum localTapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(str4);
        paramIntent = Prefs.get(paramContext).getString("tapatalk_ringtone", "content://settings/system/notification_sound");
        Boolean localBoolean;
        int i;
        if (paramIntent == null) {
            paramIntent = null;
            localBoolean = Boolean.valueOf(true);
            SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("notificationsetting", 0);
            if ((localTapatalkForum != null) && (localSharedPreferences.getBoolean(localTapatalkForum.getId() + "conversation", true)) && (localSharedPreferences.getBoolean(str4 + "notification", true))) {
                str4 = str4 + "notification";
                i = paramSharedPreferences.getInt(str4, 0);
                if (i <= 0) {
                    break label318;
                }
            }
        }
        label318:
        for (paramIntent = getConvNotification(paramContext, localTapatalkForum, str1, i + 1, null, localBoolean.booleanValue(), str3, localTapatalkForum.getUserName(), str2, Integer.parseInt(str5) - 1, str4); ; paramIntent = getConvNotification(paramContext, localTapatalkForum, str1, i + 1, paramIntent, localBoolean.booleanValue(), str3, localTapatalkForum.getUserName(), str2, Integer.parseInt(str5) - 1, str4)) {
            paramIntent.number = (i + 1);
            paramSharedPreferences = paramSharedPreferences.edit();
            paramSharedPreferences.putInt(str4, paramIntent.number);
            paramSharedPreferences.commit();
            ((NotificationManager) paramContext.getSystemService("notification")).notify(str4.hashCode(), paramIntent);
            return;
            paramIntent = Uri.parse(paramIntent);
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/ConvNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.quoord.tapatalkpro.alarm.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.IcsRecommendForumAction;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRecommendActivity;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction.IcsSearchForumActionBack;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.util.ArrayList;

public class RecommendForumNotification {
    public static void getRecommendForumNotification(Context paramContext, final Intent paramIntent) {
        final String str1 = paramIntent.getExtras().getString("round");
        final String str2 = paramIntent.getExtras().getString("au_id");
        final NotificationManager localNotificationManager = (NotificationManager) paramContext.getSystemService("notification");
        final SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        final int i = localSharedPreferences.getInt("tapatalk_auid", -1);
        String str3 = TapatalkJsonEngine.GET_FEED_FORUMS_PUSH + "?au_id=" + str2 + "&round=" + str1 + "&" + TapatalkApp.APP_KEY;
        new IcsRecommendForumAction(paramContext).getRecommendForums(str3, new IcsSearchForumAction.IcsSearchForumActionBack() {
            public void searchForumActionBack(ArrayList<TapatalkForumForSearch> paramAnonymousArrayList) {
                try {
                    Object localObject = new Intent(RecommendForumNotification.this, IcsRecommendActivity.class);
                    ((Intent) localObject).putExtra("recommendForums", true);
                    ((Intent) localObject).putExtra("recommend_data", paramAnonymousArrayList);
                    ((Intent) localObject).putExtra("round", str1);
                    ((Intent) localObject).setFlags(67108864);
                    paramAnonymousArrayList = PendingIntent.getActivity(RecommendForumNotification.this, paramAnonymousArrayList.hashCode(), (Intent) localObject, 1);
                    localObject = new NotificationCompat.Builder(RecommendForumNotification.this.getApplicationContext());
                    Bitmap localBitmap = BitmapFactory.decodeResource(RecommendForumNotification.this.getResources(), 2130839351);
                    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
                    localBigTextStyle.setBigContentTitle(paramIntent.getStringExtra("title")).bigText(paramIntent.getStringExtra("msg"));
                    ((NotificationCompat.Builder) localObject).setLargeIcon(localBitmap).setSmallIcon(2130839351).setTicker(paramIntent.getStringExtra("msg")).setContentTitle(paramIntent.getStringExtra("title")).setContentText(paramIntent.getStringExtra("msg")).setAutoCancel(true).setContentIntent(paramAnonymousArrayList);
                    if (Build.VERSION.SDK_INT > 15) {
                        ((NotificationCompat.Builder) localObject).setStyle(localBigTextStyle);
                    }
                    for (paramAnonymousArrayList = ((NotificationCompat.Builder) localObject).build(); ; paramAnonymousArrayList = ((NotificationCompat.Builder) localObject).getNotification()) {
                        paramAnonymousArrayList.flags = 16;
                        if ((i != Integer.parseInt(str2)) || (!localSharedPreferences.getBoolean("notification_recommend_flag", true)) || (!localSharedPreferences.getBoolean("notification_flag", true))) {
                            break;
                        }
                        localNotificationManager.notify("tapatalkid".hashCode(), paramAnonymousArrayList);
                        return;
                    }
                    return;
                } catch (Exception paramAnonymousArrayList) {
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/RecommendForumNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
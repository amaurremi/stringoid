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
import android.util.Log;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.FeedAction;
import com.quoord.tapatalkpro.action.FeedAction.FeedActionCallBack;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRecommendActivity;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.util.ArrayList;

public class RecommendTopicNotification {
    public static void getRecommendTopicNotification(Context paramContext, final Intent paramIntent) {
        final String str1 = paramIntent.getExtras().getString("round");
        final String str2 = paramIntent.getExtras().getString("au_id");
        final NotificationManager localNotificationManager = (NotificationManager) paramContext.getSystemService("notification");
        FeedAction localFeedAction = new FeedAction(paramContext, false);
        final SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        final int i = localSharedPreferences.getInt("tapatalk_auid", -1);
        Log.v("hy", "recommend topic---------->" + TapatalkJsonEngine.GET_FEED_TOPICS_PUSH + "?auid=" + str2 + "&round=" + str1 + "&" + TapatalkApp.APP_KEY);
        localFeedAction.getRecommendTopicFeeds(TapatalkJsonEngine.GET_FEED_TOPICS_PUSH + "?auid=" + str2 + "&round=" + str1 + "&" + TapatalkApp.APP_KEY, new FeedAction.FeedActionCallBack() {
            public void actionCallBack(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
                try {
                    Object localObject = new Intent(RecommendTopicNotification.this, IcsRecommendActivity.class);
                    ((Intent) localObject).putExtra("recommendForums", false);
                    ((Intent) localObject).putExtra("recommend_data", paramAnonymousArrayList);
                    ((Intent) localObject).putExtra("round", str1);
                    ((Intent) localObject).setFlags(67108864);
                    paramAnonymousArrayList = PendingIntent.getActivity(RecommendTopicNotification.this, (int) System.currentTimeMillis(), (Intent) localObject, 2);
                    localObject = new NotificationCompat.Builder(RecommendTopicNotification.this.getApplicationContext());
                    Bitmap localBitmap = BitmapFactory.decodeResource(RecommendTopicNotification.this.getResources(), 2130839351);
                    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
                    localBigTextStyle.setBigContentTitle(paramIntent.getStringExtra("title")).bigText(paramIntent.getStringExtra("msg"));
                    ((NotificationCompat.Builder) localObject).setLargeIcon(localBitmap).setSmallIcon(2130839351).setTicker(paramIntent.getStringExtra("msg")).setContentTitle(paramIntent.getStringExtra("title")).setContentText(paramIntent.getStringExtra("msg")).setAutoCancel(true).setContentIntent(paramAnonymousArrayList);
                    if (Build.VERSION.SDK_INT > 15) {
                        ((NotificationCompat.Builder) localObject).setStyle(localBigTextStyle);
                    }
                    for (paramAnonymousArrayList = ((NotificationCompat.Builder) localObject).build(); ; paramAnonymousArrayList = ((NotificationCompat.Builder) localObject).getNotification()) {
                        paramAnonymousArrayList.flags = 16;
                        if ((i != Integer.parseInt(str2)) || (!localSharedPreferences.getBoolean("notification_recommend_topic", true)) || (!localSharedPreferences.getBoolean("notification_flag", true))) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/RecommendTopicNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
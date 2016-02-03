package com.quoord.tapatalkpro.alarm.notification;

import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.util.Prefs;

public class AddForumNotification {
    public static final String ADD_FORUM_ACTION = "add_forum_action";
    public static int notificationId = 10002;
    private String fid;
    private String msg;
    private PendingIntent pendingIntent;
    private String title;

    private PendingIntent getPendingIntent(Context paramContext, String paramString) {
        Intent localIntent = new Intent(paramContext, AccountEntryActivity.class);
        localIntent.putExtra("add_forum_action", true);
        localIntent.setAction("add_forum_action" + new StringBuilder(String.valueOf(paramString)).append(System.currentTimeMillis()).toString().hashCode());
        localIntent.setFlags(32768);
        return PendingIntent.getActivity(paramContext, ("add_forum_action" + paramString + System.currentTimeMillis()).hashCode(), localIntent, 0);
    }

    public void getTopicTextNotification(Context paramContext, Intent paramIntent) {
        this.fid = paramIntent.getStringExtra("fid");
        this.msg = paramIntent.getStringExtra("msg");
        this.title = paramIntent.getStringExtra("title");
        paramIntent = BitmapFactory.decodeResource(paramContext.getResources(), 2130839351);
        this.pendingIntent = getPendingIntent(paramContext, this.fid);
        try {
            paramIntent = new Notification.Builder(paramContext).setContentTitle(this.title).setTicker(this.title).setContentText(this.msg).setAutoCancel(true).setSmallIcon(2130839351).setLargeIcon(paramIntent);
            if (Build.VERSION.SDK_INT > 15) {
                paramIntent.setStyle(new Notification.BigTextStyle().bigText(this.msg));
            }
            if (this.pendingIntent != null) {
                paramIntent.setContentIntent(this.pendingIntent);
            }
            if (Build.VERSION.SDK_INT > 15) {
            }
            for (paramIntent = paramIntent.build(); ; paramIntent = paramIntent.getNotification()) {
                NotificationManager localNotificationManager = (NotificationManager) paramContext.getSystemService("notification");
                paramContext = Prefs.get(paramContext);
                if ((!paramContext.getBoolean("notification_recommend_topic", true)) || (!paramContext.getBoolean("notification_flag", true))) {
                    break;
                }
                localNotificationManager.notify(notificationId, paramIntent);
                return;
            }
            return;
        } catch (Exception paramContext) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/AddForumNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.quoord.tapatalkpro.alarm.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;

public class RegisterTapatalkIdNotification {
    public static void getTapatalkIdNotification(Context paramContext, Intent paramIntent) {
        try {
            NotificationManager localNotificationManager = (NotificationManager) paramContext.getSystemService("notification");
            Object localObject = new Intent(paramContext, ObEntryActivity.class);
            ((Intent) localObject).putExtra("fromNotification", true);
            ((Intent) localObject).setFlags(268435456);
            localObject = PendingIntent.getActivity(paramContext, 0, (Intent) localObject, 134217728);
            NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext.getApplicationContext());
            Bitmap localBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130839351);
            NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
            localBigTextStyle.setBigContentTitle(paramIntent.getStringExtra("title")).bigText(paramIntent.getStringExtra("msg"));
            localBuilder.setLargeIcon(localBitmap).setSmallIcon(2130839351).setTicker(paramIntent.getStringExtra("msg")).setContentTitle(paramIntent.getStringExtra("title")).setContentText(paramIntent.getStringExtra("msg")).setAutoCancel(true).setContentIntent((PendingIntent) localObject);
            if (Build.VERSION.SDK_INT > 15) {
                localBuilder.setStyle(localBigTextStyle);
            }
            paramIntent = localBuilder.getNotification();
            paramIntent.flags = 16;
            if (!TapatalkIdFactory.getTapatalkId(paramContext).isTapatalkIdLogin()) {
                localNotificationManager.notify("tapatalkid".hashCode(), paramIntent);
            }
            return;
        } catch (Exception paramContext) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/RegisterTapatalkIdNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
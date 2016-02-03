package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;

public class bk
        implements ap, aq {
    private Notification.Builder a;

    public bk(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean3, Bundle paramBundle, String paramString1, boolean paramBoolean4, String paramString2) {
        paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
        if ((paramNotification.flags & 0x2) != 0) {
            bool = true;
            paramContext = paramContext.setOngoing(bool);
            if ((paramNotification.flags & 0x8) == 0) {
                break label264;
            }
            bool = true;
            label112:
            paramContext = paramContext.setOnlyAlertOnce(bool);
            if ((paramNotification.flags & 0x10) == 0) {
                break label270;
            }
            bool = true;
            label132:
            paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
            if ((paramNotification.flags & 0x80) == 0) {
                break label276;
            }
        }
        label264:
        label270:
        label276:
        for (boolean bool = true; ; bool = false) {
            this.a = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1).setLocalOnly(paramBoolean3).setExtras(paramBundle).setGroup(paramString1).setGroupSummary(paramBoolean4).setSortKey(paramString2);
            return;
            bool = false;
            break;
            bool = false;
            break label112;
            bool = false;
            break label132;
        }
    }

    public Notification.Builder a() {
        return this.a;
    }

    public void a(bm parambm) {
        Notification.Action.Builder localBuilder = new Notification.Action.Builder(parambm.a(), parambm.b(), parambm.c());
        if (parambm.f() != null) {
            RemoteInput[] arrayOfRemoteInput = cn.a(parambm.f());
            int j = arrayOfRemoteInput.length;
            int i = 0;
            while (i < j) {
                localBuilder.addRemoteInput(arrayOfRemoteInput[i]);
                i += 1;
            }
        }
        if (parambm.d() != null) {
            localBuilder.addExtras(parambm.d());
        }
        this.a.addAction(localBuilder.build());
    }

    public Notification b() {
        return this.a.build();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
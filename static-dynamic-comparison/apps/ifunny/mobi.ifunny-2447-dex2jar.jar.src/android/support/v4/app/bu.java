package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

public class bu
        implements ap, aq {
    private Notification.Builder a;
    private Bundle b;
    private List<Bundle> c = new ArrayList();

    public bu(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean3, Bundle paramBundle, String paramString1, boolean paramBoolean4, String paramString2) {
        paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
        boolean bool;
        if ((paramNotification.flags & 0x2) != 0) {
            bool = true;
            paramContext = paramContext.setOngoing(bool);
            if ((paramNotification.flags & 0x8) == 0) {
                break label337;
            }
            bool = true;
            label123:
            paramContext = paramContext.setOnlyAlertOnce(bool);
            if ((paramNotification.flags & 0x10) == 0) {
                break label343;
            }
            bool = true;
            label143:
            paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
            if ((paramNotification.flags & 0x80) == 0) {
                break label349;
            }
            bool = true;
            label202:
            this.a = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
            this.b = new Bundle();
            if (paramBundle != null) {
                this.b.putAll(paramBundle);
            }
            if (paramBoolean3) {
                this.b.putBoolean("android.support.localOnly", true);
            }
            if (paramString1 != null) {
                this.b.putString("android.support.groupKey", paramString1);
                if (!paramBoolean4) {
                    break label355;
                }
                this.b.putBoolean("android.support.isGroupSummary", true);
            }
        }
        for (; ; ) {
            if (paramString2 != null) {
                this.b.putString("android.support.sortKey", paramString2);
            }
            return;
            bool = false;
            break;
            label337:
            bool = false;
            break label123;
            label343:
            bool = false;
            break label143;
            label349:
            bool = false;
            break label202;
            label355:
            this.b.putBoolean("android.support.useSideChannel", true);
        }
    }

    public Notification.Builder a() {
        return this.a;
    }

    public void a(bm parambm) {
        this.c.add(br.a(this.a, parambm));
    }

    public Notification b() {
        SparseArray localSparseArray = br.a(this.c);
        if (localSparseArray != null) {
            this.b.putSparseParcelableArray("android.support.actionExtras", localSparseArray);
        }
        this.a.setExtras(this.b);
        return this.a.build();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
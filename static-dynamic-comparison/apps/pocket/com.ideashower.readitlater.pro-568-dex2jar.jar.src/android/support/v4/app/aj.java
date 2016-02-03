package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

class aj
{
  private Notification.Builder a;
  
  public aj(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4)
  {
    paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    if ((paramNotification.flags & 0x2) != 0)
    {
      bool = true;
      paramContext = paramContext.setOngoing(bool);
      if ((paramNotification.flags & 0x8) == 0) {
        break label239;
      }
      bool = true;
      label112:
      paramContext = paramContext.setOnlyAlertOnce(bool);
      if ((paramNotification.flags & 0x10) == 0) {
        break label245;
      }
      bool = true;
      label132:
      paramContext = paramContext.setAutoCancel(bool).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
      if ((paramNotification.flags & 0x80) == 0) {
        break label251;
      }
    }
    label239:
    label245:
    label251:
    for (boolean bool = true;; bool = false)
    {
      this.a = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
      return;
      bool = false;
      break;
      bool = false;
      break label112;
      bool = false;
      break label132;
    }
  }
  
  public Notification a()
  {
    return this.a.build();
  }
  
  public void a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.a.addAction(paramInt, paramCharSequence, paramPendingIntent);
  }
  
  public void a(CharSequence paramCharSequence1, boolean paramBoolean1, CharSequence paramCharSequence2, Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean2)
  {
    paramCharSequence1 = new Notification.BigPictureStyle(this.a).setBigContentTitle(paramCharSequence1).bigPicture(paramBitmap1);
    if (paramBoolean2) {
      paramCharSequence1.bigLargeIcon(paramBitmap2);
    }
    if (paramBoolean1) {
      paramCharSequence1.setSummaryText(paramCharSequence2);
    }
  }
  
  public void a(CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paramCharSequence1 = new Notification.BigTextStyle(this.a).setBigContentTitle(paramCharSequence1).bigText(paramCharSequence3);
    if (paramBoolean) {
      paramCharSequence1.setSummaryText(paramCharSequence2);
    }
  }
  
  public void a(CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, ArrayList paramArrayList)
  {
    paramCharSequence1 = new Notification.InboxStyle(this.a).setBigContentTitle(paramCharSequence1);
    if (paramBoolean) {
      paramCharSequence1.setSummaryText(paramCharSequence2);
    }
    paramCharSequence2 = paramArrayList.iterator();
    while (paramCharSequence2.hasNext()) {
      paramCharSequence1.addLine((CharSequence)paramCharSequence2.next());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

class NotificationCompatKitKat
{
  public static NotificationCompatBase.Action getAction(Notification paramNotification, int paramInt, NotificationCompatBase.Action.Factory paramFactory, RemoteInputCompatBase.RemoteInput.Factory paramFactory1)
  {
    Notification.Action localAction = paramNotification.actions[paramInt];
    Object localObject = null;
    SparseArray localSparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
    paramNotification = (Notification)localObject;
    if (localSparseArray != null) {
      paramNotification = (Bundle)localSparseArray.get(paramInt);
    }
    return NotificationCompatJellybean.readAction(paramFactory, paramFactory1, localAction.icon, localAction.title, localAction.actionIntent, paramNotification);
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    if (paramNotification.actions != null) {
      return paramNotification.actions.length;
    }
    return 0;
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    return paramNotification.extras;
  }
  
  public static String getGroup(Notification paramNotification)
  {
    return paramNotification.extras.getString("android.support.groupKey");
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    return paramNotification.extras.getBoolean("android.support.localOnly");
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    return paramNotification.extras.getString("android.support.sortKey");
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    return paramNotification.extras.getBoolean("android.support.isGroupSummary");
  }
  
  public static class Builder
    implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions
  {
    private Notification.Builder b;
    private List<Bundle> mActionExtrasList = new ArrayList();
    private Bundle mExtras;
    
    public Builder(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4, boolean paramBoolean3, Bundle paramBundle, String paramString1, boolean paramBoolean4, String paramString2)
    {
      paramContext = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
      boolean bool;
      if ((paramNotification.flags & 0x2) != 0)
      {
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
        this.b = paramContext.setFullScreenIntent(paramPendingIntent2, bool).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
        this.mExtras = new Bundle();
        if (paramBundle != null) {
          this.mExtras.putAll(paramBundle);
        }
        if (paramBoolean3) {
          this.mExtras.putBoolean("android.support.localOnly", true);
        }
        if (paramString1 != null)
        {
          this.mExtras.putString("android.support.groupKey", paramString1);
          if (!paramBoolean4) {
            break label355;
          }
          this.mExtras.putBoolean("android.support.isGroupSummary", true);
        }
      }
      for (;;)
      {
        if (paramString2 != null) {
          this.mExtras.putString("android.support.sortKey", paramString2);
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
        this.mExtras.putBoolean("android.support.useSideChannel", true);
      }
    }
    
    public void addAction(NotificationCompatBase.Action paramAction)
    {
      this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, paramAction));
    }
    
    public Notification build()
    {
      SparseArray localSparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (localSparseArray != null) {
        this.mExtras.putSparseParcelableArray("android.support.actionExtras", localSparseArray);
      }
      this.b.setExtras(this.mExtras);
      return this.b.build();
    }
    
    public Notification.Builder getBuilder()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v4/app/NotificationCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
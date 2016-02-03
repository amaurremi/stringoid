package mobi.beyondpod.rsscore.helpers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;

public abstract class NotificationHelper
{
  public static String NOTIFICATION_LINE1_EXTRA = "LINE1";
  public static String NOTIFICATION_LINE2_EXTRA = "LINE2";
  public static String NOTIFICATION_TICKER_EXTRA;
  public static String NOTIFICATION_TYPE_EXTRA;
  public static final int NT_Canceled = 1;
  public static final int NT_Completed = 3;
  public static final int NT_Connecting = 0;
  public static final int NT_ProcessingCompleted = 6;
  public static final int NT_ProcessingStarted = 5;
  public static final int NT_Progress = 4;
  public static final int NT_Started = 2;
  public static final int NT_UpdateAndDownloadCompleted = 7;
  public static final int NT_UpdateAndDownloadCompletedWithErrors = 8;
  private static String TAG = NotificationHelper.class.getSimpleName();
  public static final int UPDATEANDDOWNLOAD_COMPLETED = 129;
  public static final int UPDATEANDDOWNLOAD_STATUS = 128;
  private static SparseBooleanArray _CurrentNotifications = new SparseBooleanArray();
  
  static
  {
    NOTIFICATION_TYPE_EXTRA = "TYPE";
    NOTIFICATION_TICKER_EXTRA = "TICKER";
  }
  
  public static boolean IsNotificationIntent(Intent paramIntent)
  {
    return paramIntent.getIntExtra(NOTIFICATION_TYPE_EXTRA, -1) != -1;
  }
  
  private static void MarkCleared(int paramInt)
  {
    if (_CurrentNotifications.get(paramInt)) {
      _CurrentNotifications.put(paramInt, false);
    }
  }
  
  private static void MarkVisible(int paramInt)
  {
    if (!_CurrentNotifications.get(paramInt)) {
      _CurrentNotifications.put(paramInt, true);
    }
  }
  
  public static NotificationHelper getInstance()
  {
    return NotificationHelper.NewStyle.Holder.sInstance;
  }
  
  public void ClearNotification(Context paramContext, int paramInt)
  {
    getNotificationManager(paramContext).cancel(paramInt);
    MarkCleared(paramInt);
  }
  
  public boolean IsNotificationShowing(int paramInt)
  {
    return _CurrentNotifications.get(paramInt);
  }
  
  public abstract void StartForegroundAndShowNotification(Service paramService, int paramInt, Notification paramNotification);
  
  public abstract void StopForeground(Service paramService, int paramInt);
  
  public void UpdateNotification(Context paramContext, int paramInt, Notification paramNotification)
  {
    getNotificationManager(paramContext).notify(paramInt, paramNotification);
    MarkVisible(paramInt);
  }
  
  protected NotificationManager getNotificationManager(Context paramContext)
  {
    return (NotificationManager)paramContext.getSystemService("notification");
  }
  
  private static class NewStyle
    extends NotificationHelper
  {
    private static String TAG = NewStyle.class.getSimpleName();
    
    public void StartForegroundAndShowNotification(Service paramService, int paramInt, Notification paramNotification)
    {
      paramService.startForeground(paramInt, paramNotification);
      NotificationHelper.MarkVisible(paramInt);
    }
    
    public void StopForeground(Service paramService, int paramInt)
    {
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false) {
        try
        {
          paramService.stopForeground(bool);
          if (paramInt > 0)
          {
            getNotificationManager(paramService).cancel(paramInt);
            NotificationHelper.MarkCleared(paramInt);
          }
          return;
        }
        catch (Exception paramService)
        {
          CoreHelper.WriteLogEntry(TAG, " Cancel Notification failed! Reason: " + CoreHelper.ExtractExceptionMessages(paramService));
        }
      }
    }
    
    private static class Holder
    {
      private static final NotificationHelper.NewStyle sInstance = new NotificationHelper.NewStyle(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/NotificationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
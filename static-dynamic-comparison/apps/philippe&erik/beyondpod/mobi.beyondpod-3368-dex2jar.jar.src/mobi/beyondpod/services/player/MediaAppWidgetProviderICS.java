package mobi.beyondpod.services.player;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.widget.RemoteViews;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Track;

public class MediaAppWidgetProviderICS
  extends MediaAppWidgetProvider
{
  private static final int SIZE_LARGE = 4;
  private static final int SIZE_MED = 3;
  private static final int SIZE_MINI = 1;
  private static final int SIZE_SMALL = 2;
  protected static final int SIZE_XLARGE = 5;
  static String TAG = MediaAppWidgetProviderICS.class.getSimpleName();
  static final ComponentName THIS_APPWIDGET = new ComponentName(Configuration.PackageName(), "mobi.beyondpod.services.player.MediaAppWidgetProviderICS");
  
  private static void WireRemoteNotificationViewButtons(Context paramContext, RemoteViews paramRemoteViews, Track paramTrack)
  {
    WireRemoteNotificationViewButtons(paramContext, paramRemoteViews);
    if ((paramTrack == null) && (!SmartPlaylistTemplate.IsConfigured())) {
      paramRemoteViews.setOnClickPendingIntent(2131230847, createOpenMainWindowPendingIntent(paramContext));
    }
  }
  
  public static void WireRemoteNotificationViews(MediaAppWidgetProvider.NotificationState paramNotificationState, RemoteViews paramRemoteViews)
  {
    paramRemoteViews.setImageViewResource(2131230848, paramNotificationState.ProgressResource);
    if ((paramNotificationState.Title == null) || (paramNotificationState.Title.length() == 0))
    {
      paramRemoteViews.setViewVisibility(2131230782, 8);
      if ((paramNotificationState.Artist != null) && (paramNotificationState.Artist.length() != 0)) {
        break label135;
      }
      paramRemoteViews.setViewVisibility(2131230854, 8);
    }
    for (;;)
    {
      paramRemoteViews.setTextViewText(2131230855, paramNotificationState.InfoMessage);
      paramRemoteViews.setTextViewText(2131230852, paramNotificationState.PlaylistSize);
      paramRemoteViews.setImageViewResource(2131230849, paramNotificationState.PlayPauseResource);
      paramRemoteViews.setViewVisibility(2131230850, paramNotificationState.StreamVisibility);
      paramRemoteViews.setViewVisibility(2131230851, paramNotificationState.NextVisibility);
      return;
      paramRemoteViews.setTextViewText(2131230782, paramNotificationState.Title);
      paramRemoteViews.setViewVisibility(2131230782, 0);
      break;
      label135:
      paramRemoteViews.setTextViewText(2131230854, paramNotificationState.Artist);
      paramRemoteViews.setViewVisibility(2131230854, 0);
    }
  }
  
  public static void WireRemoteViews(Context paramContext, RemoteViews paramRemoteViews, Track paramTrack, int paramInt)
  {
    boolean bool = false;
    switch (Configuration.WidgetBackgroundColor())
    {
    default: 
      paramRemoteViews.setViewVisibility(2131230845, 8);
      paramRemoteViews.setViewVisibility(2131230846, 0);
      PendingIntent localPendingIntent = createOpenMainWindowPendingIntent(paramContext);
      paramRemoteViews.setOnClickPendingIntent(2131230856, localPendingIntent);
      paramRemoteViews.setOnClickPendingIntent(2131230857, localPendingIntent);
      if (SmartPlaylistTemplate.IsConfigured())
      {
        paramRemoteViews.setViewVisibility(2131230861, 0);
        paramRemoteViews.setOnClickPendingIntent(2131230861, createWidgetActionPickerPendingIntent(paramContext));
      }
      break;
    }
    for (;;)
    {
      WireRemoteNotificationViews(MediaAppWidgetProvider.NotificationState.BuildFromTrack(paramTrack, true, paramContext), paramRemoteViews);
      if (paramInt == 5) {
        bool = true;
      }
      WireRemoteNotificationViewImage(paramRemoteViews, paramTrack, paramContext, bool);
      WireRemoteNotificationViewButtons(paramContext, paramRemoteViews, paramTrack);
      return;
      paramRemoteViews.setViewVisibility(2131230845, 8);
      paramRemoteViews.setViewVisibility(2131230846, 8);
      break;
      paramRemoteViews.setViewVisibility(2131230845, 0);
      paramRemoteViews.setViewVisibility(2131230846, 8);
      break;
      paramRemoteViews.setViewVisibility(2131230861, 8);
    }
  }
  
  private int getSizeBucketForWidget(Context paramContext, int paramInt)
  {
    paramContext = getWidgetSize(paramContext, paramInt);
    if (paramContext.left == 0) {}
    do
    {
      return 3;
      if ((paramContext.left >= 280) && (paramContext.top >= 120)) {
        return 5;
      }
      if (paramContext.left > 330) {
        return 4;
      }
    } while (paramContext.left > 250);
    if (paramContext.left > 170) {
      return 2;
    }
    return 1;
  }
  
  protected ComponentName ThisAppWidget()
  {
    return THIS_APPWIDGET;
  }
  
  protected void initWidgets(Context paramContext, int[] paramArrayOfInt)
  {
    int j;
    int i;
    if (paramArrayOfInt.length > 0)
    {
      j = paramArrayOfInt.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return;
      }
      int k = paramArrayOfInt[i];
      paramContext = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903075);
      paramContext.setOnClickPendingIntent(2131230856, createOpenMainWindowPendingIntent(BeyondPodApplication.GetInstance()));
      paramContext.setOnClickPendingIntent(2131230847, createOpenMainWindowPendingIntent(BeyondPodApplication.GetInstance()));
      pushUpdate(BeyondPodApplication.GetInstance(), k, paramContext);
      i += 1;
    }
  }
  
  protected void performWidgetUpdate(Context paramContext, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i >= j) {
      return;
    }
    int k = paramArrayOfInt[i];
    int m = getSizeBucketForWidget(paramContext, k);
    RemoteViews localRemoteViews;
    if (m == 1) {
      localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903076);
    }
    for (;;)
    {
      Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
      WireRemoteViews(paramContext, localRemoteViews, localTrack, m);
      WireRemoteNotificationViewButtons(paramContext, localRemoteViews, localTrack);
      pushUpdate(paramContext, k, localRemoteViews);
      i += 1;
      break;
      if (m == 2) {
        localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903078);
      } else if (m == 3) {
        localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903075);
      } else if (m == 5) {
        localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903079);
      } else {
        localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903073);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/MediaAppWidgetProviderICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
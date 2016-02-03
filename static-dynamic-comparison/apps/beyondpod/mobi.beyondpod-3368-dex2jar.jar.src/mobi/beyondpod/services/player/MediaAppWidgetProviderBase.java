package mobi.beyondpod.services.player;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.ui.dialogs.WidgetActionPicker;

public abstract class MediaAppWidgetProviderBase
  extends AppWidgetProvider
  implements PlayListEvents.PlayListEventListener, RepositoryEvents.RepositoryEventListener
{
  static String TAG = MediaAppWidgetProviderBase.class.getSimpleName();
  
  public static int GetProgressResource(float paramFloat)
  {
    if (paramFloat < 0.1D) {
      return 2130837611;
    }
    if ((paramFloat >= 0.1D) && (paramFloat < 0.2D)) {
      return 2130837613;
    }
    if ((paramFloat >= 0.2D) && (paramFloat < 0.3D)) {
      return 2130837615;
    }
    if ((paramFloat >= 0.3D) && (paramFloat < 0.4D)) {
      return 2130837616;
    }
    if ((paramFloat >= 0.4D) && (paramFloat < 0.5D)) {
      return 2130837617;
    }
    if ((paramFloat >= 0.5D) && (paramFloat < 0.6D)) {
      return 2130837618;
    }
    if ((paramFloat >= 0.6D) && (paramFloat < 0.7D)) {
      return 2130837619;
    }
    if ((paramFloat >= 0.7D) && (paramFloat < 0.8D)) {
      return 2130837620;
    }
    if ((paramFloat >= 0.8D) && (paramFloat < 0.9D)) {
      return 2130837621;
    }
    if ((paramFloat >= 0.9D) && (paramFloat < 0.97D)) {
      return 2130837622;
    }
    return 2130837614;
  }
  
  static PendingIntent createOpenMainWindowPendingIntent(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, BeyondPodApplication.GetInstance().MasterViewClass());
    localIntent.setFlags(536870912);
    localIntent.setData(Uri.parse("mobi.beyondpod.ui.dialogs.WidgetActionPicker"));
    return PendingIntent.getActivity(paramContext, 0, localIntent, 0);
  }
  
  static PendingIntent createOpenPlaylistEditorPendingIntent(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, BeyondPodApplication.GetInstance().MasterViewClass());
    localIntent.setFlags(536870912);
    localIntent.setData(Uri.parse("mobi.beyondpod.ui.views.PlaylistEditorActivity"));
    return PendingIntent.getActivity(paramContext, 0, localIntent, 0);
  }
  
  static PendingIntent createWidgetActionPickerPendingIntent(Context paramContext)
  {
    return PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, WidgetActionPicker.class), 0);
  }
  
  private int[] getIds()
  {
    return AppWidgetManager.getInstance(BeyondPodApplication.GetInstance()).getAppWidgetIds(ThisAppWidget());
  }
  
  public boolean HasInstances()
  {
    return getIds().length > 0;
  }
  
  public void Initialize()
  {
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    BeyondPodApplication.MessageBus.Subscribe(this, PlayListEvents.PlayListEvent.class);
  }
  
  public void OnPlayListEvent(PlayListEvents.PlayListEvent paramPlayListEvent)
  {
    RefreshViews();
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if (paramRepositoryEvent.Type == 11)
    {
      Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
      if ((paramRepositoryEvent.Track != null) && (paramRepositoryEvent.Track == localTrack)) {
        RefreshViews();
      }
    }
    if (paramRepositoryEvent.Type == 2) {
      RefreshViews();
    }
  }
  
  public void RefreshViews()
  {
    int[] arrayOfInt = getIds();
    if (arrayOfInt.length > 0) {
      updateWidgets(BeyondPodApplication.GetInstance(), arrayOfInt);
    }
    if (Configuration.RichPlayerNotication()) {
      performNotificationUpdate();
    }
  }
  
  protected abstract ComponentName ThisAppWidget();
  
  @TargetApi(16)
  protected Rect getWidgetSize(Context paramContext, int paramInt)
  {
    if (CoreHelper.ApiLevel() < 16) {
      return new Rect();
    }
    paramContext = AppWidgetManager.getInstance(paramContext).getAppWidgetOptions(paramInt);
    return new Rect(paramContext.getInt("appWidgetMinWidth", 0), paramContext.getInt("appWidgetMinHeight", 0), paramContext.getInt("appWidgetMaxWidth", 0), paramContext.getInt("appWidgetMaxHeight", 0));
  }
  
  protected void initWidgets(Context paramContext, int[] paramArrayOfInt) {}
  
  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    onUpdate(paramContext, paramAppWidgetManager, new int[] { paramInt });
  }
  
  public void onEnabled(Context paramContext)
  {
    CoreHelper.WriteTraceEntry(TAG, "Widgets enabled! Initializing...");
    initWidgets(paramContext, getIds());
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Found that the repository is not loaded when enabling widgets! Loading now...");
      FeedRepository.InitializeAndLoadRepository();
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    updateWidgets(paramContext, paramArrayOfInt);
  }
  
  protected abstract void performNotificationUpdate();
  
  protected abstract void performWidgetUpdate(Context paramContext, int[] paramArrayOfInt);
  
  protected void pushUpdate(Context paramContext, int paramInt, RemoteViews paramRemoteViews)
  {
    AppWidgetManager.getInstance(paramContext).updateAppWidget(paramInt, paramRemoteViews);
  }
  
  protected void updateWidgets(Context paramContext, int[] paramArrayOfInt)
  {
    if (FeedRepository.IsRepositoryAvailable()) {
      performWidgetUpdate(paramContext, paramArrayOfInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/MediaAppWidgetProviderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
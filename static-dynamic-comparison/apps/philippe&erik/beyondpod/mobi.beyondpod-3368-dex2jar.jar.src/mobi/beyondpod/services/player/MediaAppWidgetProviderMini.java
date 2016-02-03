package mobi.beyondpod.services.player;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class MediaAppWidgetProviderMini
  extends MediaAppWidgetProviderBase
{
  static final ComponentName THIS_APPWIDGET = new ComponentName(Configuration.PackageName(), "mobi.beyondpod.services.player.MediaAppWidgetProviderMini");
  
  static void WireRemoteViewButtons(Context paramContext, RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    ComponentName localComponentName = new ComponentName(paramContext, MediaPlaybackService.class);
    Intent localIntent = new Intent("mobi.beyondpod.services.musicservicewidgetcommand.playpause");
    localIntent.putExtra("command", "togglepause");
    localIntent.setComponent(localComponentName);
    paramRemoteViews.setOnClickPendingIntent(2131230847, PendingIntent.getService(paramContext, 0, localIntent, 0));
  }
  
  public static void WireRemoteViews(Context paramContext, RemoteViews paramRemoteViews, Track paramTrack)
  {
    int i = 1;
    if (paramTrack != null)
    {
      paramRemoteViews.setImageViewResource(2131230848, GetProgressResource(paramTrack.PlayedAsFraction()));
      paramRemoteViews.setViewVisibility(2131230852, 0);
      switch (Configuration.WidgetBackgroundColor())
      {
      default: 
        paramRemoteViews.setViewVisibility(2131230845, 8);
        paramRemoteViews.setViewVisibility(2131230846, 0);
        label67:
        paramContext = CoreHelper.ExternalStorageState();
        if ((paramContext.equals("shared")) || (paramContext.equals("unmounted")))
        {
          paramRemoteViews.setTextViewText(2131230852, "No SD");
          label97:
          if ((paramTrack == null) || (paramTrack.getCurrentPlayState() != 1)) {
            break label349;
          }
          label109:
          if (i == 0) {
            break label354;
          }
          paramRemoteViews.setImageViewResource(2131230849, 2130837609);
          label121:
          if ((paramTrack == null) || (paramTrack.HasDownloadStarted())) {
            break label365;
          }
        }
        break;
      }
    }
    label349:
    label354:
    label365:
    for (i = 0;; i = 8)
    {
      paramRemoteViews.setViewVisibility(2131230850, i);
      return;
      paramRemoteViews.setImageViewResource(2131230848, 2130837612);
      break;
      paramRemoteViews.setViewVisibility(2131230845, 8);
      paramRemoteViews.setViewVisibility(2131230846, 8);
      break label67;
      paramRemoteViews.setViewVisibility(2131230845, 0);
      paramRemoteViews.setViewVisibility(2131230846, 8);
      break label67;
      if (paramContext.equals("removed"))
      {
        paramRemoteViews.setTextViewText(2131230852, "No SD");
        break label97;
      }
      if ((FeedRepository.RepositoryLoadState() == 0) || (FeedRepository.RepositoryLoadState() == 1))
      {
        paramRemoteViews.setTextViewText(2131230852, "...");
        break label97;
      }
      if (PlayList.IsEmpty())
      {
        paramRemoteViews.setTextViewText(2131230852, "");
        break label97;
      }
      if ((paramTrack != null) && (paramTrack.getCurrentPlayState() == 3) && (paramTrack.HasUrl()))
      {
        paramRemoteViews.setTextViewText(2131230852, paramTrack.getBufferedPercent() + "%");
        break label97;
      }
      int j = BeyondPodApplication.GetInstance().PlayList().PlaylistSize() - BeyondPodApplication.GetInstance().PlayList().GetCurrentPlayingTrackPosition();
      if (j > 0) {}
      for (paramContext = Integer.toString(j);; paramContext = "")
      {
        paramRemoteViews.setTextViewText(2131230852, paramContext);
        break;
      }
      i = 0;
      break label109;
      paramRemoteViews.setImageViewResource(2131230849, 2130837610);
      break label121;
    }
  }
  
  protected ComponentName ThisAppWidget()
  {
    return THIS_APPWIDGET;
  }
  
  protected void performNotificationUpdate() {}
  
  protected void performWidgetUpdate(Context paramContext, int[] paramArrayOfInt)
  {
    Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      int k = paramArrayOfInt[i];
      RemoteViews localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903077);
      WireRemoteViews(paramContext, localRemoteViews, localTrack);
      WireRemoteViewButtons(paramContext, localRemoteViews, true);
      pushUpdate(paramContext, k, localRemoteViews);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/MediaAppWidgetProviderMini.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
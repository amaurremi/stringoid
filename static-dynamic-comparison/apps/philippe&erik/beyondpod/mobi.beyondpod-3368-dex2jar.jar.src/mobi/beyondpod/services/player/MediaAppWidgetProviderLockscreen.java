package mobi.beyondpod.services.player;

import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;

public class MediaAppWidgetProviderLockscreen
  extends MediaAppWidgetProviderICS
{
  static String TAG = MediaAppWidgetProviderLockscreen.class.getSimpleName();
  static final ComponentName THIS_APPWIDGET = new ComponentName(Configuration.PackageName(), "mobi.beyondpod.services.player.MediaAppWidgetProviderLockscreen");
  
  protected ComponentName ThisAppWidget()
  {
    return THIS_APPWIDGET;
  }
  
  protected void performWidgetUpdate(Context paramContext, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      int k = paramArrayOfInt[i];
      RemoteViews localRemoteViews = new RemoteViews(BeyondPodApplication.GetInstance().getPackageName(), 2130903074);
      WireRemoteViews(paramContext, localRemoteViews, BeyondPodApplication.GetInstance().PlayList().CurrentTrack(), 5);
      WireRemoteNotificationViewButtons(paramContext, localRemoteViews);
      pushUpdate(paramContext, k, localRemoteViews);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/MediaAppWidgetProviderLockscreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
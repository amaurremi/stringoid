package mobi.beyondpod.services.player;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.IntentFilter;
import android.media.AudioManager;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public abstract class TransportFocusHelper
{
  static final ComponentName MEDIA_RECEIVER = new ComponentName(Configuration.PackageName(), "mobi.beyondpod.services.player.MediaButtonIntentReceiver");
  
  public static TransportFocusHelper getInstance()
  {
    if (CoreHelper.ApiLevel() <= 7) {
      return TransportFocusHelper.BroadcastReceiverTransportFocus.Holder.sInstance;
    }
    return TransportFocusHelper.TransportFocus.Holder.sInstance;
  }
  
  abstract void StartListeningForMediaButton();
  
  abstract void StopListeningForMediaButton();
  
  private static class BroadcastReceiverTransportFocus
    extends TransportFocusHelper
  {
    void StartListeningForMediaButton()
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      localIntentFilter.setPriority(999);
      BeyondPodApplication.GetInstance().registerReceiver(MediaButtonIntentReceiver.Instance, localIntentFilter);
    }
    
    void StopListeningForMediaButton()
    {
      BeyondPodApplication.GetInstance().unregisterReceiver(MediaButtonIntentReceiver.Instance);
    }
    
    private static class Holder
    {
      private static final TransportFocusHelper.BroadcastReceiverTransportFocus sInstance = new TransportFocusHelper.BroadcastReceiverTransportFocus(null);
    }
  }
  
  private static class TransportFocus
    extends TransportFocusHelper
  {
    @SuppressLint({"NewApi"})
    void StartListeningForMediaButton()
    {
      if (Configuration.EnableHeadsetButton()) {
        ((AudioManager)BeyondPodApplication.GetInstance().getSystemService("audio")).registerMediaButtonEventReceiver(MEDIA_RECEIVER);
      }
      TransportFocusHelper.BroadcastReceiverTransportFocus.Holder.sInstance.StartListeningForMediaButton();
    }
    
    @SuppressLint({"NewApi"})
    void StopListeningForMediaButton()
    {
      ((AudioManager)BeyondPodApplication.GetInstance().getSystemService("audio")).unregisterMediaButtonEventReceiver(MEDIA_RECEIVER);
      TransportFocusHelper.BroadcastReceiverTransportFocus.Holder.sInstance.StopListeningForMediaButton();
    }
    
    private static class Holder
    {
      private static final TransportFocusHelper.TransportFocus sInstance = new TransportFocusHelper.TransportFocus(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/TransportFocusHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */